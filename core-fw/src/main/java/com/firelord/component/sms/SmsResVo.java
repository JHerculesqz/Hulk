package com.firelord.component.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SmsResVo {
	// #region Fields

	@Setter
	@Getter
	private boolean ok = true;

	@Setter
	@Getter
	private String res;

	// #endregion
}
