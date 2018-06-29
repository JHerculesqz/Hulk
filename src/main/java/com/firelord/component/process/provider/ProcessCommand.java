package com.firelord.component.process.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ProcessCommand {
	// #region Fields

	@Setter
	@Getter
	private String directory;

	@Setter
	@Getter
	private String command;

	// #endregion
}
