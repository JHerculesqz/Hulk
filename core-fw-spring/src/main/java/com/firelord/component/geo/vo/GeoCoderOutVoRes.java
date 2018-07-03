package com.firelord.component.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GeoCoderOutVoRes {
	// #region Fields

	@Setter
	@Getter
	private String business;

	@Setter
	@Getter
	private GeoCoderOutVoItem addressComponent;

	// #endregion
}
