package com.firelord.core.ioc;

public class IOCUtils {
	// #region Construction

	private static IOCUtils m_oInstance;

	private IOCUtils() {

	}

	public synchronized static IOCUtils getInstance() {
		if (m_oInstance == null) {
			m_oInstance = new IOCUtils();
		}
		return m_oInstance;
	}

	// #endregion

	// #region getBean

	public <T> T getBean(Class<T> oBeanClass) {
		return ServiceAwareHelper.getInstance().getApplicationContext().getBean(oBeanClass);
	}

	public Object getBean(String strBeanId) {
		return ServiceAwareHelper.getInstance().getApplicationContext().getBean(strBeanId);
	}

	// #endregion
}
