package com.firelord.component.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RespVo {
	// #region Fields

	@Setter
	@Getter
	private boolean isOK = true;

	@Setter
	@Getter
	private Object resultObj;

	// #endregion
}
