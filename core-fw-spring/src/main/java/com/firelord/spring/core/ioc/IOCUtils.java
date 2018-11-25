package com.firelord.spring.core.ioc;

/**
 * Spring Inversion of Control Utils
 */
public class IOCUtils {
    //#region Construction

    private static IOCUtils m_oInstance;

    private IOCUtils() {

    }

    /**
     * get IOCUtils instance
     *
     * @return IOCUtils instance
     */
    public synchronized static IOCUtils getInstance() {
        if (m_oInstance == null) {
            m_oInstance = new IOCUtils();
        }
        return m_oInstance;
    }

    //#endregion

    //#region getBean

    /**
     * get java bean by clazz
     *
     * @param oBeanClass java bean clazz
     * @param <T>        java bean generic type
     * @return java bean object
     */
    public <T> T getBean(Class<T> oBeanClass) {
        return ServiceAwareHelper.getInstance().getApplicationContext().getBean(oBeanClass);
    }

    /**
     * get java bean by bean name
     *
     * @param strBeanId bean name in spring container
     * @return java bean object
     */
    public Object getBean(String strBeanId) {
        return ServiceAwareHelper.getInstance().getApplicationContext().getBean(strBeanId);
    }

    //#endregion
}
