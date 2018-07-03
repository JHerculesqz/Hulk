package com.firelord.component.security._2_secure._3_input;

import com.firelord.component.security._2_secure._3_input._1_validator.SecureInputValidatorProvider;
import com.firelord.component.security._2_secure._3_input._2_header.SecureHeaderProvider;
import com.firelord.component.security._2_secure._3_input._3_trojan.SecureTrojanProvider;
import com.firelord.component.security._2_secure._3_input._4_ddos.SecureDoSProvider;
import com.firelord.component.security._2_secure._3_input._5_whitelst.SecureWhiteLstProvider;

public class SecureInputUtilsEx {
	// #region Construction

	public static SecureInputUtilsEx getInstance() {
		return new SecureInputUtilsEx();
	}

	// #endregion

	// #region getValidatorProvider

	public SecureInputValidatorProvider getValidatorProvider() {
		return new SecureInputValidatorProvider();
	}

	// #endregion

	// #region getHeaderProvider

	public SecureHeaderProvider getHeaderProvider() {
		return new SecureHeaderProvider();
	}

	// #endregion

	// #region getTrojanProvider

	public SecureTrojanProvider getTrojanProvider() {
		return new SecureTrojanProvider();
	}

	// #endregion

	// #region getDoSProvider

	public SecureDoSProvider getDoSProvider() {
		return new SecureDoSProvider();
	}

	// #endregion

	// #region getWhiteLstProvider

	public SecureWhiteLstProvider getWhiteLstProvider() {
		return new SecureWhiteLstProvider();
	}

	// #endregion
}
