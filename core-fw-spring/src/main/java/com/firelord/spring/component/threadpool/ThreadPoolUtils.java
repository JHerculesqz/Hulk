package com.firelord.spring.component.threadpool;

import com.firelord.spring.component.threadpool.provider.ThreadPoolProvider;
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
