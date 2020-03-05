package com.firelord.test.core.fw.spring.core.ioc.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * STEP1.use application.properties
 */
@ToString
@Component
public class JavaBean4Properties {
    //#region Fields

    @Setter
    @Getter
    @Value("${testProperties.name}")
    private String name;

    //#endregion
}
