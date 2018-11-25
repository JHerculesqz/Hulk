package com.firelord.test.core.ioc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ioc4")
public class IOC4Controller {
    //#region Fields

    @Autowired
    private IProfile profile;

    //#endregion

    //#region viaApplicationPropertiesOrShell

    /**
     * STEP3.using IProfile Object by application.properties
     * STEP4.using IProfile Object by Shell
     */
    @RequestMapping("/viaApplicationPropertiesOrShell")
    @ResponseBody
    public void viaApplicationProperties() {
        this.profile.run();
    }

    //#endregion
}
