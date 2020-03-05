package com.firelord.test.core.fw.spring.init;

import com.firelord.spring.component.mvc.startup.IInitAuto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Config4Debug
 */
@Profile("debug")
@Component
public class InitAuto4Debug implements IInitAuto {
    //#region Fields

    //#endregion

    //#region run

    @Override
    public void run() {
        System.out.println("InitAuto4Debug...");
    }

    //#endregion
}
