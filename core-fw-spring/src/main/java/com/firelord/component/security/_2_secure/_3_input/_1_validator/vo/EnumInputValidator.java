package com.firelord.component.security._2_secure._3_input._1_validator.vo;

public enum EnumInputValidator {
	// #region ins

	Email("Email");

	// #endregion

	// #region Fields

	private String value;

	// #endregion

	// #region Construct

	private EnumInputValidator(String strType) {
		this.value = strType;
	}

	// #endregion

	// #region getValue

	public String getValue() {
		return this.value;
	}

	// #endregion
}
