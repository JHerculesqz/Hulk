package com.firelord.spring.core.ioc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * [important]use with ImportResources and ComponentScan(basePackages="xxxx")
 */
@Component
public class ServiceAwareHelper implements ApplicationContextAware, ResourceLoaderAware, MessageSourceAware, InitializingBean {
    //#region Fields

    @Setter
    @Getter
    private ApplicationContext applicationContext;

    @Setter
    @Getter
    private ResourceLoader resourceLoader;

    @Setter
    @Getter
    private MessageSource messageSource;

    //#endregion

    //#region Construction

    private static ServiceAwareHelper m_oInstance;

    public static ServiceAwareHelper getInstance() {
        return m_oInstance;
    }

    //#endregion

    //#region afterPropertiesSet

    @Override
    public void afterPropertiesSet() {
        m_oInstance = this;

        if (this.getApplicationContext() == null) {
            throw new BeanInstantiationException(getClass(), "applicationContext is null");
        }

        if (this.getResourceLoader() == null) {
            throw new BeanInstantiationException(getClass(), "resourceLoader is null");
        }

        if (this.getMessageSource() == null) {
            throw new BeanInstantiationException(getClass(), "messageSource is null");
        }
    }

    //#endregion
}
