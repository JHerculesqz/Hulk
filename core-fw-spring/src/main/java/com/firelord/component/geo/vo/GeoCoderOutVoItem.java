package com.firelord.component.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GeoCoderOutVoItem {
	// #region Fields

	@Setter
	@Getter
	private String country;

	@Setter
	@Getter
	private String province;

	@Setter
	@Getter
	private String city;

	@Setter
	@Getter
	private String district;

	@Setter
	@Getter
	private String town;

	@Setter
	@Getter
	private String street;

	@Setter
	@Getter
	private String streetNum;

	// #endregion
}
