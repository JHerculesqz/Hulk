package com.firelord.init;

import com.firelord.spring.component.mvc.startup.IInitAuto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * InitAuto4Debug
 */
@Component
@Log4j2
public class InitAuto4Debug implements IInitAuto {
    //#region Const

    /**
     * LOG_INIT_AUTO4DEBUG
     */
    static final String LOG_INIT_AUTO4DEBUG = "[FLOWABLE.InitAuto4Debug]";

    //#endregion

    //#region run

    @Override
    public void run() {
        log.info(LOG_INIT_AUTO4DEBUG + "start...");


        log.info(LOG_INIT_AUTO4DEBUG + "end...");
    }

    //#endregion
}
