package com.firelord.component.collection;

import com.firelord.component.log.LogUtilsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class QueueUtilsEx {
	// #region Const

	private static final boolean IS_DEBUG = false;

	// #endregion

	// #region Fielcs

	private BlockingQueue<Object> cache = new LinkedBlockingQueue<Object>();

	// #endregion

	// #region set

	public void set(Object oPOJO) {
		try {
			cache.put(oPOJO);
		} catch (InterruptedException e) {
			LogUtilsEx.log(e.getMessage(), IS_DEBUG);
		}
	}

	// #endregion

	// #region get

	public List<Object> get() {
		List<Object> lstRes = new ArrayList<Object>();

		while (true) {
			Object oItemInQueue = cache.poll();
			if (null != oItemInQueue) {
				lstRes.add(oItemInQueue);
			}

			if (cache.isEmpty()) {
				break;
			}
		}

		return lstRes;
	}

	// #endregion
}
