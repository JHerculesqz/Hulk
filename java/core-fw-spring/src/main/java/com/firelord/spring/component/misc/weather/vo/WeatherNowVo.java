package com.firelord.spring.component.misc.weather.vo;

import lombok.ToString;

@ToString
public class WeatherNowVo {
    //#region Fields

    /**
     * 空气概览
     */
    public String cond_txt;

    /**
     * 温度
     */
    public String tmp;

    /**
     * 风向
     */
    public String wind_dir;

    /**
     * 湿度
     */
    public String hum;

    //#endregion
}
