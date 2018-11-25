package com.firelord.test.core.ioc.ioc.usage2;

import org.springframework.stereotype.Component;

/**
 * STEP1.Define and Declare javabeans using @Component
 */
@Component
public class JavaBeanByComponent {
    //#region func2

    public void func() {
        System.out.println("JavaBeanByComponent");
    }

    //#endregion
}
