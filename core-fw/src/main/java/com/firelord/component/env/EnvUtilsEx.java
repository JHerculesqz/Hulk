package com.firelord.component.env;

public class EnvUtilsEx {
	// #region Const

	public static String USERNAME = "user.name";
	public static String USERDIR = "user.dir";
	public static String USERHOME = "user.home";

	// #endregion

	// #region getValue

	public static String getValue(String strKey) {
		String strRes = System.getProperty(strKey);
		return strRes;
	}

	// #endregion
}
