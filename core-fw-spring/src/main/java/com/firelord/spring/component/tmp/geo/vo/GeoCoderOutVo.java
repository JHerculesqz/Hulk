package com.firelord.spring.component.tmp.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GeoCoderOutVo {
	// #region Const

	private static final String TEMPLATE_LOCATION = "%s-%s-%s-%s-%s";

	// #endregion

	// #region Fields

	@Setter
	@Getter
	private int status;

	@Setter
	@Getter
	private GeoCoderOutVoRes result;

	// #endregion

	// #region toStrEx

	public String toStrEx() {
		String strRes = "";

		if (0 == status) {
			String strCountry = result.getAddressComponent().getCountry();
			String strProvince = result.getAddressComponent().getProvince();
			String strCity = result.getAddressComponent().getCity();
			String strDistrict = result.getAddressComponent().getCity();
			String strStreet = result.getAddressComponent().getStreet();
			strRes = String.format(TEMPLATE_LOCATION, strCountry, strProvince, strCity, strDistrict, strStreet);
		}

		return strRes;
	}

	// #endregion
}
