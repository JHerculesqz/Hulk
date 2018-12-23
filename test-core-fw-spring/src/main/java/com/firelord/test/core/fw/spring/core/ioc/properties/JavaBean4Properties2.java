package com.firelord.test.core.fw.spring.core.ioc.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * STEP2.use custom.properties
 */
@ToString
@Component
@PropertySource(value = {"classpath:custom.properties"}, ignoreResourceNotFound = true)
public class JavaBean4Properties2 {
    //#region Fields

    @Setter
    @Getter
    @Value("${testProperties.age}")
    private String age;

    //#endregion
}
