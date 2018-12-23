package com.firelord.test.core.fw.spring.component.mvc.session;

import com.firelord.spring.component.mvc.session.SessionUtils;
import com.firelord.spring.component.mvc.session.mo.SessionMo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc/session")
public class SessionController {
    //#region Fields

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    public void test1() {
        SessionMo oSessionMo = SessionUtils.getInstance().getSessionVo();
    }

    //#endregion
}
