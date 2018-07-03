package com.firelord.component.distribute.zk.lock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.firelord.component.distribute.DistributeLockUtilsEx;
import com.firelord.component.distribute.IDistributeLockProvider;
import com.firelord.component.log.LogUtilsExIOC;

public class DistributeLockProvider4Zk implements Lock, Watcher, IDistributeLockProvider {
	// #region Fields

	private ZooKeeper zk;
	private String root = "/locks";// 根
	private String lockName;// 竞争资源的标志
	private String waitNode;// 等待前一个锁
	private String myZnode;// 当前锁
	private CountDownLatch connectionLatch;// 计数器
	private CountDownLatch latch;// 计数器
	private int sessionTimeout;
	private List<Exception> exceptionLst = new ArrayList<Exception>();

	private boolean timeout;

	// #endregion

	// #region Construction

	/**
	 * 创建分布式锁,使用前请确认config配置的zookeeper服务可用
	 * 
	 * @param strZkConfig
	 *            127.0.0.1:2181
	 * @param strLockName
	 *            竞争资源标志,lockName中不能包含单词lock
	 */
	public DistributeLockProvider4Zk(String strZkConfig, String strLockName, int iTimeoutMs) {
		this.lockName = strLockName;
		// 创建一个与服务器的连接
		try {
			this.connectionLatch = new CountDownLatch(1);
			this.sessionTimeout = iTimeoutMs;
			zk = new ZooKeeper(strZkConfig, sessionTimeout, this);
			this.connectionLatch.await();
			Stat stat = zk.exists(root, false);
			if (stat == null) {
				// 创建根节点
				zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (IOException e) {
			exceptionLst.add(e);
		} catch (KeeperException e) {
			exceptionLst.add(e);
		} catch (InterruptedException e) {
			exceptionLst.add(e);
		}
	}

	// #endregion

	// #region process

	/**
	 * zookeeper节点的监视器
	 */
	@Override
	public void process(WatchedEvent event) {
		if (KeeperState.SyncConnected == event.getState()) {
			if (this.connectionLatch != null) {
				this.connectionLatch.countDown();
			}

			if (this.latch != null) {
				this.latch.countDown();
			}
		}
	}

	// #endregion

	// #region lock

	@Override
	public void lock() {
		if (exceptionLst.size() > 0) {
			throw new LockException(exceptionLst.get(0));
		}
		try {
			if (this.tryLock()) {
				LogUtilsExIOC.log2File("[lock success]===" + Thread.currentThread().getId() + "===" + myZnode + "===",
						DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
				return;
			} else {
				waitForLock(waitNode, sessionTimeout);// 等待锁
			}
		} catch (KeeperException e) {
			throw new LockException(e);
		} catch (InterruptedException e) {
			throw new LockException(e);
		}
	}

	private boolean waitForLock(String lower, long waitTime) throws InterruptedException, KeeperException {
		Stat stat = zk.exists(root + "/" + lower, true);
		// 判断比自己小一个数的节点是否存在,如果不存在则无需等待锁,同时注册监听
		if (stat != null) {
			LogUtilsExIOC.log2File("[lock wait]===" + Thread.currentThread().getId() + "===" + root + "/" + lower + "===",
					DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			this.latch = new CountDownLatch(1);
			boolean bIsInTime = this.latch.await(waitTime, TimeUnit.MILLISECONDS);
			timeout = !bIsInTime;
			this.latch = null;
			if (!bIsInTime) {
				LogUtilsExIOC
						.log2File(
								"[lock expired]===" + Thread.currentThread().getId() + "===my:" + myZnode + "===last:"
										+ root + "/" + lower + "===",
								DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			} else {
				LogUtilsExIOC.log2File(
						"[wait lock success]===" + Thread.currentThread().getId() + "===my:" + myZnode + "===last:"
								+ root + "/" + lower + "===",
						DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			}
		}
		return true;
	}

	// #endregion

	// #region lockInterruptibly

	@Override
	public void lockInterruptibly() throws InterruptedException {
		this.lock();
	}

	// #endregion

	// #region tryLock

	@Override
	public boolean tryLock() {
		try {
			String splitStr = "_lock_";
			if (lockName.contains(splitStr)) {
				throw new LockException("lockName can not contains \\u000B");
			}
			// 创建临时子节点
			myZnode = zk.create(root + "/" + lockName + splitStr, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
					CreateMode.EPHEMERAL_SEQUENTIAL);
			LogUtilsExIOC.log2File(
					"[try_lock]===create tmp node===" + Thread.currentThread().getId() + "===" + myZnode + "===",
					DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			// 取出所有子节点
			List<String> subNodes = zk.getChildren(root, false);
			// 取出所有lockName的锁
			List<String> lockObjNodes = new ArrayList<String>();
			for (String node : subNodes) {
				String _node = node.split(splitStr)[0];
				if (_node.equals(lockName)) {
					lockObjNodes.add(node);
				}
			}
			Collections.sort(lockObjNodes);
			if (myZnode.equals(root + "/" + lockObjNodes.get(0))) {
				// 如果是最小的节点,则表示取得锁
				LogUtilsExIOC.log2File(
						"[try_lock]===is min node, lock success===" + Thread.currentThread().getId() + "===" + myZnode,
						DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
				return true;
			} else {
				// 如果不是最小的节点，找到比自己小1的节点
				String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);
				waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);
				LogUtilsExIOC.log2File(
						"[try_lock]===not min node, lock wait===" + Thread.currentThread().getId() + "===my:" + myZnode
								+ "===wait:" + waitNode,
						DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			}
		} catch (KeeperException e) {
			throw new LockException(e);
		} catch (InterruptedException e) {
			throw new LockException(e);
		}
		return false;
	}

	// #endregion

	// #region tryLock

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		try {
			if (this.tryLock()) {
				return true;
			}
			return waitForLock(waitNode, time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// #endregion

	// #region unlock

	@Override
	public void unlock() {
		try {
			LogUtilsExIOC.log2File("[unlock]===" + Thread.currentThread().getId() + "===" + myZnode + "===",
					DistributeLockProvider4Zk.class, DistributeLockUtilsEx.IS_DEBUG);
			zk.delete(myZnode, -1);
			myZnode = null;
			zk.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region isTimeout

	@Override
	public boolean isTimeout() {
		return timeout;
	}

	// #endregion

	// #region newCondition

	@Override
	public Condition newCondition() {
		return null;
	}

	// #endregion

	// #region private.LockException

	public class LockException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public LockException(String e) {
			super(e);
		}

		public LockException(Exception e) {
			super(e);
		}
	}

	// #endregion
}