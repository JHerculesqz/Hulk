package com.firelord.core.ioc.ioc.usage2;

import com.firelord.core.ioc.IOCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ioc2")
public class IOC2Controller {
    //#region Fields

    @Autowired
    private JavaBeanByComponent javaBeanByComponent;

    //#endregion

    //#region viaAutowire

    /**
     * STEP4.Use javabeans via @autowire
     */
    @RequestMapping("/viaAutowire")
    @ResponseBody
    public void viaAutowire() {
        javaBeanByComponent.func();
    }

    //#endregion

    //#region viaIOCUtils

    /**
     * STEP5.Use javabeans via IOCUtils
     */
    @RequestMapping("/viaIOCUtils")
    @ResponseBody
    public void viaIOCUtils() {
        IOCUtils.getInstance().getBean(JavaBeanByComponent.class).func();
    }

    //#endregion
}
