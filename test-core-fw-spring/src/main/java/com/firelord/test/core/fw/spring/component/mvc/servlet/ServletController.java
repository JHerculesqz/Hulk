package com.firelord.test.core.fw.spring.component.mvc.servlet;

import com.firelord.spring.component.mvc.servlet.ServletUtilsEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Controller
@RequestMapping("/mvc/servlet")
public class ServletController {
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
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();
        String strUrl = ServletUtilsEx.getRequestUrl();
        String strUri = ServletUtilsEx.getRequestUri();
        String strRealPath = ServletUtilsEx.getRealPath("resources");
        String strServerName = ServletUtilsEx.getServerName();
        int iServerPort = ServletUtilsEx.getServerPort();
        String strRemoteAddr = ServletUtilsEx.getRemoteAddr();
        String strRemoteUser = ServletUtilsEx.getRemoteUser();
        String strAuthType = ServletUtilsEx.getAuthType();
        String strProtocol = ServletUtilsEx.getProtocol();
        String strScheme = ServletUtilsEx.getScheme();
        String strHeader = ServletUtilsEx.getHeader("id");
        Enumeration<String> enumHeader = ServletUtilsEx.getHeaderNames();
        String strParamVal = ServletUtilsEx.getParamValue("param1");
        String[] arrParamVal = ServletUtilsEx.getParamValues("param2");
        Enumeration<String> enumParamKey = ServletUtilsEx.getParamKeys();
        Map<String, String[]> mapParamObj = ServletUtilsEx.getParams();
    }

    //#endregion
}
