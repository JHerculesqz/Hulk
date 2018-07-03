package com.firelord.component.servlet;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class WebFilterUtilsEx {
	// #region Const

	public final static String[] EXCLUDE_EXT = { "css", "js", "jpg", "png", "ico" };

	// #endregion

	// #region exclude

	public static boolean isExcludeByExtension(HttpServletRequest oHttpServletRequest, String[] arrExcludeExt) {
		String strUrl = oHttpServletRequest.getRequestURI();
		String strExtention = strUrl.substring(strUrl.lastIndexOf('.') + 1).toLowerCase();
		boolean bIsExclude = Arrays.asList(arrExcludeExt).contains(strExtention);
		return bIsExclude;
	}

	public static boolean isExcludeByUrl(HttpServletRequest oHttpServletRequest, String[] arrExcludeUrl) {
		String strUrl = oHttpServletRequest.getRequestURI();
		List<String> lstExcludeUrl = Arrays.asList(arrExcludeUrl);
		for (String strExcludeUrl : lstExcludeUrl) {
			if (strUrl.contains(strExcludeUrl)) {
				return true;
			}
		}
		return false;
	}

	// #endregion
}
