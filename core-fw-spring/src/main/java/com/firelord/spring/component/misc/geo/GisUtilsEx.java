package com.firelord.spring.component.misc.geo;


import com.firelord.spring.component.misc.geo.vo.GeoCoderOutVo;
import com.firelord.spring.component.rpc.http.HttpClientUtils;
import jodd.json.JsonParser;

/**
 * GisUtilsEx
 */
public class GisUtilsEx {
    //#region Const

    private static final String URL_GEO_CODER_REVERSE =
            "http://api.map.baidu.com/geocoder/v2/?location=%s,%s&output=json&ak=%s";

    //#endregion

    //#region geoCoderReverse

    /**
     * get geo info by coordinate
     *
     * @param strX      x
     * @param strY      y
     * @param strAPIKey apiKey
     * @return geo info
     */
    public static GeoCoderOutVo geoCoderReverse(String strX, String strY, String strAPIKey) {
        String strUrl = String.format(URL_GEO_CODER_REVERSE, strX, strY, strAPIKey);
        String strRes = HttpClientUtils.getInstance().getSimple(strUrl);
        JsonParser oJsonParser = new JsonParser();
        GeoCoderOutVo oRes = oJsonParser.parse(strRes, GeoCoderOutVo.class);
        return oRes;
    }

    //#endregion
}
