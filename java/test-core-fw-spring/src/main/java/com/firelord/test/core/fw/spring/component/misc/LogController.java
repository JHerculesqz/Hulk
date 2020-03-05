package com.firelord.test.core.fw.spring.component.misc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/misc/log")
@Log4j2
public class LogController {
    //#region Fields

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    public void test1() {
        log.info("test1...");
    }

    //#endregion
}
