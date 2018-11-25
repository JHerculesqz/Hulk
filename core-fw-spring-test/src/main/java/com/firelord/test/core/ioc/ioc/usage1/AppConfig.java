package com.firelord.test.core.ioc.ioc.usage1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * STEP2.Declare javabeans using AppConfig
 */
@Configuration
public class AppConfig {
    @Bean
    public JavaBeanByBean javaBeanByBean() {
        return new JavaBeanByBean();
    }
}
