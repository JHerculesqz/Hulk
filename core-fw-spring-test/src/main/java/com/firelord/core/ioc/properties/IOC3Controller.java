package com.firelord.core.ioc.properties;

import com.firelord.core.ioc.IOCUtils;
import com.firelord.core.ioc.ioc.usage1.JavaBeanByBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ioc3")
public class IOC3Controller {
    //#region Fields

    @Autowired
    private JavaBean4Properties javaBean4Properties;

    @Autowired
    private JavaBean4Properties2 javaBean4Properties2;

    //#endregion

    //#region viaAutowire

    @RequestMapping("/viaApplicationProperties")
    @ResponseBody
    public void viaApplicationProperties() {
        System.out.println(javaBean4Properties);
    }

    //#endregion

    //#region viaCustomProperties

    @RequestMapping("/viaCustomProperties")
    @ResponseBody
    public void viaCustomProperties() {
        System.out.println(javaBean4Properties2);
    }

    //#endregion
}
