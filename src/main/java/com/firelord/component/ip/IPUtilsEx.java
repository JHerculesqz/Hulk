package com.firelord.component.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class IPUtilsEx {
	// #region const

	private static final String SPLIT_COLON = ":";

	private static final String SPLIT_SQUARE_BRACKET = "]";

	// #endregion

	// #region getIPAddress

	/**
	 * deal with 127.0.0.1:49130 or [::]:135 or *:*
	 * 
	 * @param strAddress strAddress
	 * @return IPAddressVo
	 */
	public static IPAddressVo getIPAddress(String strAddress) {
		IPAddressVo oRes = new IPAddressVo();

		if (strAddress.contains(SPLIT_SQUARE_BRACKET)) {
			int iIndex4Bracket = strAddress.indexOf(SPLIT_SQUARE_BRACKET);
			oRes.setIp(strAddress.substring(0, iIndex4Bracket + 1));
			oRes.setPort(strAddress.substring(iIndex4Bracket + 2));
		} else {
			int iIndex4Colon = strAddress.indexOf(SPLIT_COLON);
			oRes.setIp(strAddress.substring(0, iIndex4Colon));
			oRes.setPort(strAddress.substring(iIndex4Colon + 1));
		}

		return oRes;
	}

	// #endregion

	// #region getLocalIp

	public static String getLocalIp() {
		String strRes = "";

		try {
			InetAddress oLocal = InetAddress.getLocalHost();
			strRes = oLocal.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return strRes;
	}

	// #endregion

	// #region getMacAddress

	public static String getMacAddress() {
		String strRes = "";

		try {
			InetAddress oLocal = InetAddress.getLocalHost();
			byte[] arrMacBytes = NetworkInterface.getByInetAddress(oLocal).getHardwareAddress();
			StringBuffer strMacAddress = new StringBuffer("");
			for (int i = 0; i < arrMacBytes.length; i++) {
				if (i != 0) {
					strMacAddress.append("-");
				}
				// 字节转换为整数
				int iHex = arrMacBytes[i] & 0xff;
				String strHex = Integer.toHexString(iHex);
				if (strHex.length() == 1) {
					strMacAddress.append("0" + strHex);
				} else {
					strMacAddress.append(strHex);
				}
			}
			strRes = strMacAddress.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strRes;
	}

	// #endregion
}
