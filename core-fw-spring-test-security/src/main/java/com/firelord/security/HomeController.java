package com.firelord.security;

import com.firelord.component.security.SecurityService;
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

    //#endregion

    //#region home

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView oModelAndView = new ModelAndView();
        this.securityService.update4Head(oModelAndView);
        oModelAndView.setViewName("pages/home/home");
        return oModelAndView;
    }

    //#endregion
}
