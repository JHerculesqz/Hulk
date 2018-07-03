package com.firelord.component.security._2_secure._1_cookie.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CookieVo {
	// #region Fields

	@Setter
	@Getter
	private String key;

	@Setter
	@Getter
	private String value;

	@Setter
	@Getter
	private String domain;

	@Setter
	@Getter
	private String path;

	@Setter
	@Getter
	private int expire;

	@Setter
	@Getter
	private boolean secure;

	@Setter
	@Getter
	private boolean httpOnly;

	// #endregion
}
