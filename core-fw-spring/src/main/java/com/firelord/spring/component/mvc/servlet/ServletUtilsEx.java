package com.firelord.spring.component.mvc.servlet;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.AccessControlException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * ServletUtilsEx
 */
public class ServletUtilsEx {
    //#region request

    /**
     * get HttpServletRequest object
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest oRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return oRequest;
    }

    //#endregion

    //#region url

    /**
     * get url in HttpServletRequest
     *
     * @return url
     */
    public static String getRequestUrl() {
        HttpServletRequest oRequest = getRequest();
        String strUrl = oRequest.getRequestURL().toString();
        return strUrl;
    }

    /**
     * get uri in HttpServletRequest
     *
     * @return uri
     */
    public static String getRequestUri() {
        HttpServletRequest oRequest = getRequest();
        String strUrl = oRequest.getRequestURI();
        return strUrl;
    }

    /**
     * get real path on server
     *
     * @param strRelativePath relative dir path on server
     * @return real path on server
     */
    @SuppressWarnings("deprecation")
    public static String getRealPath(String strRelativePath) {
        HttpServletRequest oRequest = getRequest();
        String strRealPath = oRequest.getRealPath(strRelativePath);
        return strRealPath;
    }

    /**
     * get server name
     *
     * @return server name
     */
    public static String getServerName() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getServerName();
    }

    /**
     * get server port
     *
     * @return server port
     */
    public static int getServerPort() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getServerPort();
    }

    /**
     * get remote ip
     *
     * @return remote ip
     */
    public static String getRemoteAddr() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getServerName();
    }

    /**
     * get remote user
     *
     * @return remote user
     */
    public static String getRemoteUser() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getRemoteUser();
    }

    //#endregion

    //#region auth

    /**
     * get method type
     *
     * @return method type
     */
    public static String getMethodType() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getMethod();
    }

    /**
     * get auth type
     *
     * @return auth type
     */
    public static String getAuthType() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getAuthType();
    }

    /**
     * get http protocol
     *
     * @return http protocol
     */
    public static String getProtocol() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getProtocol();
    }

    /**
     * get http scheme
     *
     * @return http scheme
     */
    public static String getScheme() {
        HttpServletRequest oRequest = getRequest();
        return oRequest.getScheme();
    }

    //#endregion

    //#region header

    /**
     * get value in header
     *
     * @param strKey param key
     * @return value in header
     */
    public static String getHeader(String strKey) {
        HttpServletRequest oRequest = getRequest();
        String strRes = oRequest.getHeader(strKey);
        return strRes;
    }

    /**
     * get header names
     *
     * @return header names
     */
    public static Enumeration<String> getHeaderNames() {
        HttpServletRequest oRequest = getRequest();
        Enumeration<String> enumRes = oRequest.getHeaderNames();
        return enumRes;
    }

    //#endregion

    //#region param

    /**
     * get param value by key
     *
     * @param strKey key
     * @return param value
     */
    public static String getParamValue(String strKey) {
        HttpServletRequest oRequest = getRequest();
        String strValue = oRequest.getParameter(strKey);
        return strValue;
    }

    /**
     * get param list by key
     *
     * @param strKey key
     * @return param list by key
     */
    public static String[] getParamValues(String strKey) {
        HttpServletRequest oRequest = getRequest();
        String[] arrValue = oRequest.getParameterValues(strKey);
        return arrValue;
    }

    /**
     * get param key list
     *
     * @return param key list
     */
    public static Enumeration<String> getParamKeys() {
        HttpServletRequest oRequest = getRequest();
        Enumeration<String> arrKeys = oRequest.getParameterNames();
        return arrKeys;
    }

    /**
     * get param object
     * key:param key
     * value:param value list
     *
     * @return param object
     */
    public static Map<String, String[]> getParams() {
        HttpServletRequest oRequest = getRequest();
        Map<String, String[]> mapRes = oRequest.getParameterMap();
        return mapRes;
    }

    //#endregion

    //#region TODO:need refactor

//    HttpServletResponse httpResponse = (HttpServletResponse) response;<br>
// * httpResponse.setCharacterEncoding("UTF-8"); <br>
// * httpResponse.setContentType( "application/json; charset=utf-8");<br>
// * httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);<br>
// * httpResponse.getWriter().write("license expired...");<br>

    /**
     * get HttpServletResponse object
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse oResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        return oResponse;
    }

    public static String setValueInRspHeader(String strKey, String strValue,
                                             HttpServletRequest oRequest) {
        // oRequest.getHea
        return null;
    }

    public static void redirect(HttpServletResponse oResponse, String strUrl) {
        try {
            oResponse.setContentType("text/html");
            oResponse.setCharacterEncoding("utf-8");
            ESAPI.httpUtilities().sendRedirect(oResponse, strUrl);
        } catch (AccessControlException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redirectByJs(HttpServletResponse oResponse, String strUrl) {
        try {
            oResponse.setContentType("text/html");
            oResponse.setCharacterEncoding("utf-8");
            oResponse.getWriter().print(strUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //#endregion
}
