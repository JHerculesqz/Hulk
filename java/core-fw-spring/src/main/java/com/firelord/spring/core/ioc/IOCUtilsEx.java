package com.firelord.spring.core.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * please use IOCUtils
 */
public class IOCUtilsEx {
    //#region Fields

    private ApplicationContext ctx;

    //#endregion

    //#region Construction

    private static IOCUtilsEx m_oInstance;

    private IOCUtilsEx() {

    }

    /**
     * get IOCUtilsEx instance
     *
     * @return IOCUtilsEx instance
     */
    public synchronized static IOCUtilsEx getInstance() {
        if (m_oInstance == null) {
            m_oInstance = new IOCUtilsEx();
        }
        return m_oInstance;
    }

    //#endregion

    //#region init

    /**
     * register java bean config class
     * [important]java bean config class sample:
     *
     * @param oAppConfigClazz java bean config class
     *                        [Annotation]Configuration
     *                        public class AppConfig {
     *                        [Annotation]Bean
     *                        public JavaBean1 javaBean1() {
     *                        return new JavaBean1();
     *                        }
     *                        }
     */
    public void init(Class<?> oAppConfigClazz) {
        this.ctx = new AnnotationConfigApplicationContext(oAppConfigClazz);
    }

    //#endregion

    //#region getBean

    /**
     * get java bean by clazz
     *
     * @param oClazz java bean clazz
     * @param <T>    java bean generic type
     * @return java bean
     */
    public <T> T getBean(Class<T> oClazz) {
        return this.ctx.getBean(oClazz);
    }

    //#endregion
}
