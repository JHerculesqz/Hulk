package com.firelord.component.security._2_secure._1_cookie;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

import com.firelord.component.security._2_secure._1_cookie.vo.CookieVo;
import com.firelord.component.servlet.ServletUtilsEx;

/**
 * Demo:<br>
 * SecureCookieUtilsEx.getInstance.addSecureCookie("testSecureCookie", "secure",
 * "/") <br>
 * SecureCookieUtilsEx.getInstance.addCommonCookie("testCommonCookie", "common",
 * "/")<br>
 * SecureCookieUtilsEx.getInstance.getCookie("testSecureCookie")<br>
 * SecureCookieUtilsEx.getInstance.delCookie("testSecureCookie")<br>
 */
public class SecureCookieUtilsEx {
	// #region Construction

	public static SecureCookieUtilsEx getInstance() {
		return new SecureCookieUtilsEx();
	}

	// #endregion

	// #region addCookie

	public void addSecureCookie(String strKey, String strValue, String strPath) {
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		Cookie oCookie = new Cookie(strKey, strValue);
		oCookie.setPath(strPath);
		ESAPI.httpUtilities().addCookie(oResponse, oCookie);
	}

	public void addCommonCookie(String strKey, String strValue, String strPath) {
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		Cookie oCookie = new Cookie(strKey, strValue);
		oCookie.setPath(strPath);
		oResponse.addCookie(oCookie);
	}

	// #endregion

	// #region getCookie

	public String getCookie(String strKey) {
		try {
			HttpServletRequest oRequest = ServletUtilsEx.getRequest();

			String strValue = ESAPI.httpUtilities().getCookie(oRequest, strKey);
			return strValue;
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return null;
	}

	// #endregion

	// #region getCookies

	public List<CookieVo> getCookies() {
		List<CookieVo> lstRes = new ArrayList<>();

		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();

		// 2.get arrCookie
		Cookie[] arrCookie = oRequest.getCookies();
		if (null != arrCookie) {
			for (int i = 0; i < arrCookie.length; i++) {
				CookieVo oCookieVo = new CookieVo();

				Cookie oCookie = arrCookie[i];
				oCookieVo.setKey(oCookie.getName());
				oCookieVo.setValue(oCookie.getValue());
				oCookieVo.setDomain(oCookie.getDomain());
				oCookieVo.setPath(oCookie.getPath());
				oCookieVo.setExpire(oCookie.getMaxAge());
				oCookieVo.setSecure(oCookie.getSecure());
				oCookieVo.setHttpOnly(oCookie.isHttpOnly());

				lstRes.add(oCookieVo);
			}
		}

		// 3.return
		return lstRes;
	}

	// #endregion

	// #region delCookie

	public void delCookie(String strKey) {
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		ESAPI.httpUtilities().killCookie(oRequest, oResponse, strKey);
	}

	// #endregion
}
