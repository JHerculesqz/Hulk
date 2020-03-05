package com.firelord.test.core.fw.spring.core.ioc.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ioc")
public class CustomController {
    //#region Fields

    @Autowired
    private CustomClass customClass;

    //#endregion

    //#region custom

    @RequestMapping("/custom")
    @ResponseBody
    public void custom() {
        customClass.test();
    }

    //#endregion
}
