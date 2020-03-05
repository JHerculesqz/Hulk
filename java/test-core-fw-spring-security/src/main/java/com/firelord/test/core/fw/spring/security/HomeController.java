package com.firelord.test.core.fw.spring.security;

import com.firelord.security.app.init.SecurityService;
import com.firelord.security.app.mgr.SecurityMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    //#region Fields

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SecurityMgrService securityMgrService;

    //#endregion

    //#region home

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        this.securityMgrService.addULogs("view home page", null);

        ModelAndView oModelAndView = this.securityService.genModelAndView4Head();
        oModelAndView.setViewName("pages/home/home");
        return oModelAndView;
    }

    //#endregion
}
