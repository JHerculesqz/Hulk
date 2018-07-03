package com.firelord.component.security._2_secure._3_input._2_header;

import com.firelord.component.log.LogUtilsEx;
import com.firelord.component.servlet.ServletUtilsEx;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SecureHeaderProvider {
	// #region Const

	private static final boolean IS_DEBUG = false;

	// #endregion

	// #region addHeader

	public void addHeader(String strKey, String strValue) {
		// 1.get oResponse
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		// 2.addHeader
		ESAPI.httpUtilities().addHeader(oResponse, strKey, strValue);
	}

	// #endregion

	// #region getHeaders

	public Map<String, String> getHeaders() {
		Map<String, String> mapRes = new HashMap<String, String>();

		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();

		// 2.iter
		Enumeration<String> arrHeaderNames = oRequest.getHeaderNames();
		while (arrHeaderNames.hasMoreElements()) {
			String strHeaderName = arrHeaderNames.nextElement();
			String strHeaderValue = getHeader(strHeaderName);
			mapRes.put(strHeaderName, strHeaderValue);
		}

		return mapRes;
	}

	// #endregion

	// #region getHeader

	public String getHeader(String strKey) {
		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();

		// 2.getHeader
		String strRes = oRequest.getHeader(strKey);
		return strRes;
	}

	public String getHeader4Secure(String strKey) {
		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();

		// 2.getHeader
		String strRes = "";
		try {
			strRes = ESAPI.httpUtilities().getHeader(oRequest, strKey);
		} catch (ValidationException e) {
			LogUtilsEx.log(String.format("[SecureHeaderProvider].getHeader4Secure error...%s", strKey), IS_DEBUG);
		}
		return strRes;
	}

	// #endregion

	// #region getHeader4RemoteIp

	public String getHeader4RemoteIp() {
		// 1.get oRequest
		HttpServletRequest oRequest = ServletUtilsEx.getRequest();

		// 2.get strIp by balabalabala...
		String strIp = getHeader("X-Forwarded-For");
		if (strIp == null || strIp.length() == 0 || "unknown".equalsIgnoreCase(strIp)) {
			strIp = getHeader("Proxy-Client-IP");
		}
		if (strIp == null || strIp.length() == 0 || "unknown".equalsIgnoreCase(strIp)) {
			strIp = getHeader("WL-Proxy-Client-IP");
		}
		if (strIp == null || strIp.length() == 0 || "unknown".equalsIgnoreCase(strIp)) {
			strIp = getHeader("HTTP_CLIENT_IP");
		}
		if (strIp == null || strIp.length() == 0 || "unknown".equalsIgnoreCase(strIp)) {
			strIp = getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (strIp == null || strIp.length() == 0 || "unknown".equalsIgnoreCase(strIp)) {
			strIp = oRequest.getRemoteAddr();
		}

		return strIp;
	}

	// #endregion

	// #region getHeader4UserAgent

	public String getHeader4UserAgent() {
		String strRes = getHeader("user-agent");
		return strRes;
	}

	// #endregion

	// #region isHeaderByAjax

	public boolean isHeaderByAjax(HttpServletRequest oRequest) {
		boolean bRes = "XMLHttpRequest".equals(getHeader("X-Requested-With"));
		return bRes;
	}

	// #endregion

	// #region setContentTypeByDefault

	/**
	 * 潜规则：业务侧一般不用
	 */
	public void setContentTypeByDefault() {
		// 1.get oResponse
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		// 2.setContentType
		ESAPI.httpUtilities().setContentType(oResponse);
	}

	// #endregion

	// #region setHeader4SecureCustom

	public void setHeader4SecureCustom(String strKey, String strValue) {
		// 1.get oResponse
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		// 2.setHeader
		ESAPI.httpUtilities().setHeader(oResponse, strKey, strValue);
	}

	// #endregion

	// #region setHeader4SecureCustomNoCache

	/**
	 * 潜规则：OWASP定义的规范,SpringSecurity都支持了，因此此类API引用了SpringSecurity之后可以不使用
	 */
	public void setHeader4SecureCustomNoCache() {
		// 1.get oResponse
		HttpServletResponse oResponse = ServletUtilsEx.getResponse();

		ESAPI.httpUtilities().setNoCacheHeaders(oResponse);
	}

	// #endregion
}
