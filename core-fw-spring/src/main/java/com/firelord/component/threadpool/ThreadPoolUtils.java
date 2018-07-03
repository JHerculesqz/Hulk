package com.firelord.component.threadpool;

import com.firelord.component.threadpool.provider.ThreadPoolProvider;
import com.firelord.core.ioc.IOCUtils;

public class ThreadPoolUtils {
	// #region getProvider

	public static ThreadPoolProvider getProvider() {
		return IOCUtils.getInstance().getBean(ThreadPoolProvider.class);
	}

	// #endregion
}
