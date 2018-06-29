package com.firelord.component.io.zip.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ZipValidatorVo {
	// #region Fields

	@Setter
	@Getter
	private long size;

	@Setter
	@Getter
	private boolean invalidEntryPath;

	// #endregion
}
