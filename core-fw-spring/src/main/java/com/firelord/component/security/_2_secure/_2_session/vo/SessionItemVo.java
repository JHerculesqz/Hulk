package com.firelord.component.security._2_secure._2_session.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SessionItemVo {
	// #region Fields

	@Setter
	@Getter
	private String key;

	@Setter
	@Getter
	private Object value;

	// #endregion
}
