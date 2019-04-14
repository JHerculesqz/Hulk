package com.firelord.spring.component.mvc.session;


import com.firelord.spring.component.mvc.servlet.ServletUtilsEx;
import com.firelord.spring.component.mvc.session.mo.SessionItemMo;
import com.firelord.spring.component.mvc.session.mo.SessionMo;
import com.firelord.spring.component.tmp.security._2_secure._3_input.SecureInputUtilsEx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * SessionUtils
 */
public class SessionUtils {
    //#region Const

    private static final String KEY_REMOTE_IP = "RemoteIp";
    private static final String KEY_USER_AGENT = "UserAgent";

    //#endregion

    //#region Construction

    /**
     * Single Instance
     *
     * @return SessionUtils
     */
    public static SessionUtils getInstance() {
        return new SessionUtils();
    }

    //#endregion

    //#region getSessionVo

    /**
     * get session view object
     *
     * @return SessionMo
     */
    public SessionMo getSessionVo() {
        SessionMo oSessionMo = new SessionMo();

        //get oRequest
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();
        //get oSession
        HttpSession oSession = oRequest.getSession();

        //generate oSessionMo
        if (oSession != null) {
            oSessionMo.setSessionId(oSession.getId());
            Enumeration<String> enumNames = oSession.getAttributeNames();
            while (enumNames.hasMoreElements()) {
                SessionItemMo oSessionItemMo = new SessionItemMo();
                String strKey = enumNames.nextElement();
                oSessionItemMo.setKey(strKey);
                oSessionItemMo.setValue(oSession.getAttribute(strKey).toString());
                oSessionMo.getSessionItemMos().add(oSessionItemMo);
            }
        }

        return oSessionMo;
    }

    //#endregion

    //#region TODO:need refactor

    //#region whenLoginSuccess

    public void whenLoginSuccess() {
        // 1.get oRequest
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();

        // 2.get strRemoteIp and strUserAgent
        String strRemoteIp = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4RemoteIp();
        String strUserAgent = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4UserAgent();

        // 3.get oHttpSession
        HttpSession oHttpSession = oRequest.getSession(true);

        // 4.put
        oHttpSession.setAttribute(KEY_REMOTE_IP, strRemoteIp);
        oHttpSession.setAttribute(KEY_USER_AGENT, strUserAgent);
    }

    //#endregion

    //#region validateRemoteIpAndUserAgent

    public boolean validateRemoteIpAndUserAgent(ISessionInvalidCallback oISessionInvalidCallback) {
        // 1.get oRequest
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();

        // 2.get strRemoteIp and strUserAgent
        String strRemoteIp = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4RemoteIp();
        String strUserAgent = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4UserAgent();

        // 3.get oHttpSession
        HttpSession oHttpSession = oRequest.getSession(false);

        if (oHttpSession != null) {
            // 4.get strRemoteIpInSession and strUserAgentInSession
            String strRemoteIpInSession = (String) oHttpSession.getAttribute(KEY_REMOTE_IP);
            String strUserAgentInSession = (String) oHttpSession.getAttribute(KEY_USER_AGENT);

            // 5.compare
            if (null == strRemoteIpInSession) {
                return true;
            } else {
                if (strRemoteIpInSession.equals(strRemoteIp) && strUserAgentInSession.equals(strUserAgent)) {
                    return true;
                } else {
                    // 5.1.callback to redirect
                    oISessionInvalidCallback.redirectToLogout();

                    // 5.2.invalidate current session
                    oHttpSession.invalidate();

                    return false;
                }
            }
        } else {
            return true;
        }
    }

    //#endregion

    //#endregion
}
