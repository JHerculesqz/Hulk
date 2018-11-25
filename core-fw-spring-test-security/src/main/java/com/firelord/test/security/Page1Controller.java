package com.firelord.test.security;

import com.firelord.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Page1Controller {
    //#region Fields

    @Autowired
    private SecurityService securityService;

    //#endregion

    //#region page1

    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public ModelAndView page1() {
        ModelAndView oModelAndView = new ModelAndView();
        this.securityService.update4Head(oModelAndView);
        oModelAndView.setViewName("pages/page1/page1");
        return oModelAndView;
    }

    //#endregion
}
