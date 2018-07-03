package com.firelord.component.geo;

import com.firelord.component.geo.vo.GeoCoderOutVo;
import com.firelord.component.http.HttpUtilsEx;

import jodd.json.JsonParser;

public class GisUtilsEx {
	// #region Const

	private static final String API_KEY = "1qa8751RB1ddLeDq3EQQa3xHaAqOAoPj";

	private static final String URL_GEO_CODER_REVERSE = "http://api.map.baidu.com/geocoder/v2/?location=%s,%s&output=json&ak=%s";

	// #endregion

	// #region geoCoderReverse

	public static GeoCoderOutVo geoCoderReverse(String strX, String strY) {
		String strUrl = String.format(URL_GEO_CODER_REVERSE, strX, strY, API_KEY);
		String strRes = HttpUtilsEx.getProvider().get4SysEx(strUrl);
		JsonParser oJsonParser = new JsonParser();
		GeoCoderOutVo oRes = oJsonParser.parse(strRes, GeoCoderOutVo.class);
		return oRes;
	}

	// #endregion
}
