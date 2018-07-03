package com.firelord.component.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.AccessControlException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * HttpServletResponse httpResponse = (HttpServletResponse) response;<br>
 * httpResponse.setCharacterEncoding("UTF-8"); <br>
 * httpResponse.setContentType( "application/json; charset=utf-8");<br>
 * httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);<br>
 * httpResponse.getWriter().write("license expired...");<br>
 */
public class ServletUtilsEx {
	// // #region setValueInReqHeader
	//
	// public static String setValueInRspHeader(String strKey, String strValue,
	// HttpServletRequest oRequest) {
	// oRequest.getHea
	// }
	//
	// // #endregion

	// #region getValueInReqHeader

	public static String getValueInReqHeader(String strKey, HttpServletRequest oRequest) {
		String strRes = oRequest.getHeader(strKey);
		return strRes;
	}

	// #endregion

	// #region getRequest

	public static HttpServletRequest getRequest() {
		HttpServletRequest oRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return oRequest;
	}

	// #endregion

	// #region getResponse

	public static HttpServletResponse getResponse() {
		HttpServletResponse oResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		return oResponse;
	}

	// #endregion

	// #region redirect

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

	// #endregion

	// #region getUrl

	public static String getUrl() {
		HttpServletRequest oRequest = getRequest();
		String strUrl = oRequest.getRequestURI();
		return strUrl;
	}

	// #endregion
}
