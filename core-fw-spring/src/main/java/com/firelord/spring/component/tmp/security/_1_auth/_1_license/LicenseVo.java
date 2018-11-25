package com.firelord.spring.component.tmp.security._1_auth._1_license;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class LicenseVo {
	// #region Fields

	@Setter
	@Getter
	private String user;

	@Setter
	@Getter
	private String expireDate;

	@Setter
	@Getter
	private String macAddressLst;

	// #endregion
}
