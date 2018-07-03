package com.firelord.component.ip;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class IPAddressVo {
	// #region Fields

	@Setter
	@Getter
	private String ip;

	@Setter
	@Getter
	private String port;

	// #endregion
}
