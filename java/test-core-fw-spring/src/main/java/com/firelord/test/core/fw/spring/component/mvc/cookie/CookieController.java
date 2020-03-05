package com.firelord.test.core.fw.spring.component.mvc.cookie;

import com.firelord.spring.component.mvc.cookie.CookieUtilsEx;
import com.firelord.spring.component.mvc.cookie.mo.CookieMo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mvc/cookie")
public class CookieController {
    //#region Fields

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    @SuppressWarnings("unused")
    public void test1() {
        CookieUtilsEx.addCommonCookie("key1", "1", "/");
        CookieUtilsEx.addSecureCookie("key2", "2", "/");
        String strValue1 = CookieUtilsEx.getCookie("key1");
        String strValue2 = CookieUtilsEx.getCookie("key2");
        List<CookieMo> lstCookieMo = CookieUtilsEx.getCookies();
        CookieUtilsEx.delCookie("key1");
        CookieUtilsEx.delCookie("key2");
    }

    //#endregion
}
