package com.firelord.spring.component.tmp.security._1_auth._2_token.jwt.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TokenJWTVo {
	// #region Const

	public static final String KEY_USER = "user";

	public static final String KEY_EXPIREMS = "expireMs";

	public static final String KEY_SECRETKEY = "secretKey";

	// #endreigon

	// #region Fields

	@Setter
	@Getter
	private String user;

	@Setter
	@Getter
	private String expireMs;

	@Setter
	@Getter
	private String secretKey;

	// #endreigon

}
