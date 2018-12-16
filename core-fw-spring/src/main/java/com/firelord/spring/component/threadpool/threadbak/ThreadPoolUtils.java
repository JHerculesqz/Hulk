package com.firelord.spring.component.threadpool.threadbak;

import com.firelord.spring.core.ioc.IOCUtils;

/**
 * ThreadPoolUtils
 * TODO:need refactor
 */
@Deprecated
public class ThreadPoolUtils {
    //#region getProvider

    /**
     * get ThreadPoolProvider
     *
     * @return ThreadPoolProvider
     */
    public static ThreadPoolProvider getProvider() {
        return IOCUtils.getInstance().getBean(ThreadPoolProvider.class);
    }

    //#endregion
}
