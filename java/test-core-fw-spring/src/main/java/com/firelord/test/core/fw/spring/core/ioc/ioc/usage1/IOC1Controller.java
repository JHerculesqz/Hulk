package com.firelord.test.core.fw.spring.core.ioc.ioc.usage1;

import com.firelord.spring.core.ioc.IOCUtilsEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ioc1")
public class IOC1Controller {
    //#region Fields

    @Autowired
    private JavaBeanByBean javaBeanByBean;

    //#endregion

    //#region viaAutowire

    /**
     * STEP4.Use javabeans via @autowire
     */
    @RequestMapping("/viaAutowire")
    @ResponseBody
    public void viaAutowire() {
        javaBeanByBean.func();
    }

    //#endregion

    //#region viaIOCUtils

    /**
     * STEP5.Use javabeans via IOCUtils
     */
    @RequestMapping("/viaIOCUtils")
    @ResponseBody
    public void viaIOCUtils() {
        IOCUtilsEx.getInstance().getBean(JavaBeanByBean.class).func();
    }

    //#endregion
}
