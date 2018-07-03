package com.firelord.component.security._2_secure._4_output._2_refmap;

import javax.servlet.http.HttpSession;

import org.owasp.esapi.errors.AccessControlException;
import org.owasp.esapi.reference.RandomAccessReferenceMap;

import com.firelord.component.servlet.ServletUtilsEx;

public class SecureInputRefMapProvider {
	// #region Const

	private static final String RANDOM_MAP_KEY = "RandomAccessReferenceMap";

	// #endregion

	// #region whenLoginSuccess

	public void whenLoginSuccess() {
		HttpSession oHttpSession = ServletUtilsEx.getRequest().getSession();
		synchronized (oHttpSession) {
			if (oHttpSession.getAttribute(RANDOM_MAP_KEY) == null) {
				RandomAccessReferenceMap oRandomAccessReferenceMap = new RandomAccessReferenceMap();
				oHttpSession.setAttribute(RANDOM_MAP_KEY, oRandomAccessReferenceMap);
			}
		}

	}

	// #endregion

	// #region randomAccessReferenceMapAdd

	public String randomAccessReferenceMapAdd(Object obj) {
		HttpSession oHttpSession = ServletUtilsEx.getRequest().getSession();
		RandomAccessReferenceMap oRandomAccessReferenceMap = (RandomAccessReferenceMap) oHttpSession
				.getAttribute(RANDOM_MAP_KEY);
		String strRandomKey = oRandomAccessReferenceMap.addDirectReference(obj);
		return strRandomKey;
	}

	// #endregion

	// #region randomAccessReferenceMapGetAndRemove

	public String randomAccessReferenceMapGetAndRemove(String strRandomKey) {
		try {
			// 1.get oHttpSession
			HttpSession oHttpSession = ServletUtilsEx.getRequest().getSession();

			// 2.get oRandomAccessReferenceMap
			RandomAccessReferenceMap oRandomAccessReferenceMap = (RandomAccessReferenceMap) oHttpSession
					.getAttribute(RANDOM_MAP_KEY);

			// 3.get strRealObj
			String strRealObj = oRandomAccessReferenceMap.getDirectReference(strRandomKey);

			// 4.remove
			oRandomAccessReferenceMap.removeDirectReference(strRealObj);
			return strRealObj;
		} catch (AccessControlException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// #endregion
}
