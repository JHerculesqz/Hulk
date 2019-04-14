package com.firelord.component.io.file.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FilePathVo {
	// #region Fields

	@Setter
	@Getter
	private String fileName;

	@Setter
	@Getter
	private String dirPath4File;

	// #endregion
}
