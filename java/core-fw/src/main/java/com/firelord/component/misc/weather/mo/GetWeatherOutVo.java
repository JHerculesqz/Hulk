package com.firelord.component.misc.weather.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetWeatherOutVo {
    //#region Fields

    @Setter
    @Getter
    private String date;

    @Setter
    @Getter
    private String temperature;

    @Setter
    @Getter
    private String wind;

    @Setter
    @Getter
    private String humidity;

    @Setter
    @Getter
    private String ultravioletRay;

    @Setter
    @Getter
    private String airQuality;

    @Setter
    @Getter
    private String glycemicIndex;

    @Setter
    @Getter
    private String dressingIndex;

    @Setter
    @Getter
    private String washingIndex;

    @Setter
    @Getter
    private String airPollutionIndex;

    @Setter
    @Getter
    private String weatherOverview;

    //#endregion
}
