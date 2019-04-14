package com.firelord.component.io.ftp.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FTPAddressVo {
	// #region Fields

	@Getter
	@Setter
	private String hostName;

	@Getter
	@Setter
	private int port;

	// #endregion
}
