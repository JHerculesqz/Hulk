package com.firelord.spring.component.tmp.distribute;

import com.firelord.spring.component.tmp.distribute.redis.lock.DistributeLockProvider4Redis;
import com.firelord.spring.component.tmp.distribute.zk.lock.DistributeLockProvider4Zk;
import com.firelord.spring.component.tmp.distribute.zk.lock.debug.DistributeLockDebugProvider;

public class DistributeLockUtilsEx {
    // #region Const

    public static final boolean IS_DEBUG = false;

    // #endregion

    // #region getProvider

    public static IDistributeLockProvider getProvider(String strZkConfig, String strLockName, int iTimeoutMs) {
        IDistributeLockProvider oProvider = new DistributeLockProvider4Zk(strZkConfig, strLockName, iTimeoutMs);
        return oProvider;
    }

    public static IDistributeLockProvider getProvider(String strLockName, int iTimeoutMs) {
        IDistributeLockProvider oProvider = new DistributeLockProvider4Redis(strLockName, iTimeoutMs);
        return oProvider;
    }

    // #endregion

    // #region lock

    public static void lock(IDistributeLockProvider oProvider) {
        oProvider.lock();
    }

    // #endregion

    // #region unlock

    public static void unlock(IDistributeLockProvider oProvider) {
        oProvider.unlock();
    }

    // #endregion

    // #region isTimeout

    public boolean isTimeout(IDistributeLockProvider oProvider) {
        return oProvider.isTimeout();
    }

    // #endregion

    // #region getDebugProvider4Zk

    public static DistributeLockDebugProvider getDebugProvider4Zk() {
        return new DistributeLockDebugProvider();
    }

    // #endregion
}
