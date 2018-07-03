package com.firelord.component.security._2_secure._2_session;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.firelord.component.security._2_secure._2_session.vo.SessionItemVo;
import com.firelord.component.security._2_secure._2_session.vo.SessionVo;
import com.firelord.component.security._2_secure._3_input.SecureInputUtilsEx;
import com.firelord.component.servlet.ServletUtilsEx;

public class SecureSessionUtilsEx {
	// #region Const

	private static final String KEY_REMOTE_IP = "RemoteIp";
	private static final String KEY_USER_AGENT = "UserAgent";

	// #endregion

	// #region Construction

	public static SecureSessionUtilsEx getInstance() {
		return new SecureSessionUtilsEx();
	}

	// #endregion

	// #region whenLoginSuccess

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

	// #endregion

	// #region validateRemoteIpAndUserAgent

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

	// #endregion

	// #region getSessionVo

	public SessionVo getSessionVo() {
		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();
		// 2.get oSession
		HttpSession oSession = oRequest.getSession();

		SessionVo oSessionVo = new SessionVo();
		if (oSession != null) {
			oSessionVo.setSessionId(oSession.getId());
			Enumeration<String> enumNames = oSession.getAttributeNames();
			while (enumNames.hasMoreElements()) {
				SessionItemVo oSessionItemVo = new SessionItemVo();
				String strKey = enumNames.nextElement();
				oSessionItemVo.setKey(strKey);
				oSessionItemVo.setValue(oSession.getAttribute(strKey).toString());
				oSessionVo.getLstSessionItem().add(oSessionItemVo);
			}
		}
		return oSessionVo;
	}

	// #endregion
}
