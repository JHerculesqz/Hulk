package com.firelord.component.security;

import com.firelord.component.security.dao.tbluser.mo.SignUpOutMo;
import com.firelord.component.security.dao.tbluser.mo.UserMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * SecurityController
 */
@Controller
public class SecurityController {
    //#region Fields

    @Autowired
    private SecurityService securityService;

    //#endregion

    //#region signUp

    /**
     * signUp page
     *
     * @return signUp page
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView oModelAndView = new ModelAndView();
        oModelAndView.addObject("user", new UserMo());
        oModelAndView.setViewName("security/signup/signup");
        return oModelAndView;
    }

    /**
     * signUp
     *
     * @param oUserMo        UserMo
     * @param oBindingResult BindingResult
     * @return signUp from page
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signUp(@Valid UserMo oUserMo, BindingResult oBindingResult) {
        ModelAndView oModelAndView = new ModelAndView();

        //service
        SignUpOutMo oOutMo = this.securityService.signUp(oUserMo);

        //if success
        if (oOutMo.isOk()) {
            oModelAndView.setViewName("security/signin/signin");
        }
        //if fail
        else {
            oBindingResult.rejectValue("email",
                    "error.user",
                    "There is already a user registered with the username provided");
            oModelAndView.setViewName("security/signup/signup");
        }

        return oModelAndView;
    }

    //#endregion

    //#region signin

    /**
     * signIn page
     *
     * @return signIn page
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        ModelAndView oModelAndView = new ModelAndView();
        oModelAndView.setViewName("security/signin/signin");
        return oModelAndView;
    }

    //#endregion
}
