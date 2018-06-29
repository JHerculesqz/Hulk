package com.firelord.component.io.ini;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class IniUtilsEx {
	// #region getValue

	public static String getValue(String strKey, String strFilePath) {
		String strRes = "";

		try {
			Properties oProperties = new Properties();
			FileInputStream oFileInputStream = new FileInputStream(strFilePath);
			oProperties.load(oFileInputStream);
			strRes = oProperties.getProperty(strKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strRes;
	}

	// #endregion

	// #region setValue

	public static void setValue(String strKey, String strValue, String strFilePath) {
		try {
			Properties oProperties = new Properties();
			FileOutputStream oFileOutputStream = new FileOutputStream(strFilePath);
			oProperties.setProperty(strKey, strValue);
			oProperties.store(oFileOutputStream, null);
			oFileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #endregion
}
