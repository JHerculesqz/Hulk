package com.firelord.spring.component.mvc.cookie;

import com.firelord.spring.component.mvc.cookie.mo.CookieMo;
import com.firelord.spring.component.mvc.servlet.ServletUtilsEx;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * CookieUtilsEx
 */
public class CookieUtilsEx {
    //#region getCookie

    /**
     * get cookie value by key
     *
     * @param strKey cookie key
     * @return cookie value
     */
    public static String getCookie(String strKey) {
        try {
            HttpServletRequest oRequest = ServletUtilsEx.getRequest();

            String strValue = ESAPI.httpUtilities().getCookie(oRequest, strKey);
            return strValue;
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return null;
    }

    //#endregion

    //#region getCookies

    /**
     * get cookie object list
     *
     * @return cookie object list
     */
    public static List<CookieMo> getCookies() {
        List<CookieMo> lstRes = new ArrayList<>();

        // 1.get oRequest
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();

        // 2.get arrCookie
        Cookie[] arrCookie = oRequest.getCookies();
        if (null != arrCookie) {
            for (int i = 0; i < arrCookie.length; i++) {
                CookieMo oCookieMo = new CookieMo();

                Cookie oCookie = arrCookie[i];
                oCookieMo.setKey(oCookie.getName());
                oCookieMo.setValue(oCookie.getValue());
                oCookieMo.setDomain(oCookie.getDomain());
                oCookieMo.setPath(oCookie.getPath());
                oCookieMo.setExpire(oCookie.getMaxAge());
                oCookieMo.setSecure(oCookie.getSecure());
                oCookieMo.setHttpOnly(oCookie.isHttpOnly());

                lstRes.add(oCookieMo);
            }
        }

        // 3.return
        return lstRes;
    }

    //#endregion

    //#region addCookie

    /**
     * add secure cookie
     *
     * @param strKey   cookie key
     * @param strValue cookie value
     * @param strPath  cookie path
     */
    public static void addSecureCookie(String strKey, String strValue, String strPath) {
        HttpServletResponse oResponse = ServletUtilsEx.getResponse();
        Cookie oCookie = new Cookie(strKey, strValue);
        oCookie.setPath(strPath);
        ESAPI.httpUtilities().addCookie(oResponse, oCookie);
    }

    /**
     * add common cookie
     *
     * @param strKey   cookie key
     * @param strValue cookie value
     * @param strPath  cookie path
     */
    public static void addCommonCookie(String strKey, String strValue, String strPath) {
        HttpServletResponse oResponse = ServletUtilsEx.getResponse();
        Cookie oCookie = new Cookie(strKey, strValue);
        oCookie.setPath(strPath);
        oResponse.addCookie(oCookie);
    }

    //#endregion

    //#region delCookie

    /**
     * delete cookie by key
     *
     * @param strKey cookie key
     */
    public static void delCookie(String strKey) {
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();
        HttpServletResponse oResponse = ServletUtilsEx.getResponse();
        ESAPI.httpUtilities().killCookie(oRequest, oResponse, strKey);
    }

    //#endregion
}
