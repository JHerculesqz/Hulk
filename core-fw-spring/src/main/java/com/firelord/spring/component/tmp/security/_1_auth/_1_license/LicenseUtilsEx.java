package com.firelord.spring.component.tmp.security._1_auth._1_license;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.firelord.component.date.DateUtilsEx;
import com.firelord.component.ip.IPUtilsEx;
import com.verhas.licensor.License;

public class LicenseUtilsEx {
	// #region Fields

	private License m_oLicense;

	// #endregion

	// #region Construction

	private static LicenseUtilsEx m_oInstance;

	private LicenseUtilsEx() {

	}

	public static synchronized LicenseUtilsEx getInstance() {
		if (null == m_oInstance) {
			m_oInstance = new LicenseUtilsEx();
		}
		return m_oInstance;
	}

	// #endregion

	// #region init

	public void init() {
		this.m_oLicense = new License();
	}

	// #endregion

	// #region encode

	public void encode(String strFilePathSrc, String strFilePathDst, String strFilePathSecRing, String strUser,
			String strPwd) {
		try {
			// license 的原文
			m_oLicense.setLicense(new File(strFilePathSrc));
			// 私钥与之前生成密钥时产生的USER-ID
			m_oLicense.loadKey(strFilePathSecRing, strUser);
			// 生成密钥时输入的密码
			String strMsg = m_oLicense.encodeLicense(strPwd);

			// license 文件生成
			OutputStream os = new FileOutputStream(strFilePathDst);
			os.write(strMsg.getBytes("utf-8"));
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region validate

	public boolean validate(String strFilePathSrc, String strFilePathPubRing) {
		LicenseVo oLicenseVo = decode(strFilePathSrc, strFilePathPubRing);

		// 1.isExpire
		boolean bIsExpire = DateUtilsEx.isExpire(oLicenseVo.getExpireDate(), DateUtilsEx.TIMEZONE_0);

		// 2.isSameMac
		String strMacAddress4Local = IPUtilsEx.getMacAddress();
		String strMacAddress4LicenseLst = oLicenseVo.getMacAddressLst();
		boolean bIsMacValid = false;
		if (strMacAddress4LicenseLst.contains(strMacAddress4Local)) {
			bIsMacValid = true;
		}

		// 3.bIsExpire && bIsMacValid, valid
		if (!bIsExpire && bIsMacValid) {
			return true;
		}
		// 4.not valid
		else {
			return false;
		}
	}

	private LicenseVo decode(String strFilePathSrc, String strFilePathPubRing) {
		LicenseVo oLicenseVo = new LicenseVo();

		try {
			m_oLicense.loadKeyRing(strFilePathPubRing, null);
			m_oLicense.setLicenseEncodedFromFile(strFilePathSrc);
			if (m_oLicense.isVerified()) {
				oLicenseVo.setUser(m_oLicense.getFeature("user"));
				oLicenseVo.setExpireDate(m_oLicense.getFeature("expireDate"));
				oLicenseVo.setMacAddressLst(m_oLicense.getFeature("mac"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oLicenseVo;
	}

	// #endregion
}
