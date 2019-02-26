package com.firelord.spring.component.misc.weather;

import com.firelord.spring.component.misc.weather.vo.WeatherLifeOutVo;
import com.firelord.spring.component.misc.weather.vo.WeatherNowOutVo;
import com.firelord.spring.component.rpc.http.HttpClientUtils;
import jodd.json.JsonParser;

public class WeatherUtilsEx {
    //#region Const

    private static final String LOG_NOW = "[Hulk.WeatherUtilsEx]now:";
    private static final String URL_NOW = "https://free-api.heweather.net/s6/weather/now?key=%s&lang=zh&location=%s";

    private static final String LOG_LIFE = "[Hulk.WeatherUtilsEx]lifeStyle:";
    private static final String URL_LIFE = "https://free-api.heweather.net/s6/weather/lifestyle?key=%s&lang=zh&location=%s";

    //#endregion

    //#region now

    public static WeatherNowOutVo now(String strKey, String strLocation) {
        String strUrl = String.format(URL_NOW, strKey, strLocation);
        String strRes = HttpClientUtils.getInstance().getSimple(strUrl);
        System.out.println(LOG_NOW + strRes);
        JsonParser oJsonParser = new JsonParser();
        WeatherNowOutVo oRes = oJsonParser.parse(strRes, WeatherNowOutVo.class);

        return oRes;
    }

    //#endregion

    //#region lifeStyle

    public static WeatherLifeOutVo lifeStyle(String strKey, String strLocation) {
        String strUrl = String.format(URL_LIFE, strKey, strLocation);
        String strRes = HttpClientUtils.getInstance().getSimple(strUrl);
        System.out.println(LOG_LIFE + strRes);
        JsonParser oJsonParser = new JsonParser();
        WeatherLifeOutVo oRes = oJsonParser.parse(strRes, WeatherLifeOutVo.class);

        return oRes;
    }

    //#endregion
}
