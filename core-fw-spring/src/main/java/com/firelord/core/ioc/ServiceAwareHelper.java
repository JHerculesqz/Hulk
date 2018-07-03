package com.firelord.core.ioc;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * 潜规则：配合使用ImportResources和ComponentScan(basePackages="xxxx")<br>
 */
@Component
public class ServiceAwareHelper
		implements ApplicationContextAware, ResourceLoaderAware, MessageSourceAware, InitializingBean {
	// #region Fields

	@Setter
	@Getter
	private ApplicationContext applicationContext;

	@Setter
	@Getter
	private ResourceLoader resourceLoader;

	@Setter
	@Getter
	private MessageSource messageSource;

	// #endregion

	// #region Construction

	private static ServiceAwareHelper m_oInstance;

	public static ServiceAwareHelper getInstance() {
		return m_oInstance;
	}

	// #endregion

	@Override
	public void afterPropertiesSet() throws Exception {
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
}
