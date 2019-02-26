package com.firelord.spring.component.misc.weather.vo;

import lombok.ToString;

@ToString
public class WeatherLifeVo {
    //#region Const

    /**
     * 紫外线指数
     */
    public static final String TYPE_UV = "uv";

    /**
     * 穿衣指数
     */
    public static final String TYPE_DRESS = "drsg";

    /**
     * 洗车指数
     */
    public static final String TYPE_WASH_CAR = "cw";

    /**
     * 空气指数
     */
    public static final String TYPE_AIR = "air";

    //#endregion

    //#region Fields

    public String type;

    public String txt;

    //#endregion
}
