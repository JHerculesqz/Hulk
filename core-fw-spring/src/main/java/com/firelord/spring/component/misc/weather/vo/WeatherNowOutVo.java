package com.firelord.spring.component.misc.weather.vo;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WeatherNowOutVo {
    //#region Fields

    public List<WeatherNowOutItemVo> HeWeather6 = new ArrayList<>();

    //#endregion

    //#region isEmpty

    public boolean isEmpty() {
        return 0 == this.HeWeather6.size();
    }

    //#endregion

    //#region get

    public WeatherNowVo get() {
        if (0 == this.HeWeather6.size()) {
            return null;
        }
        return this.HeWeather6.get(0).now;
    }

    //#endregion
}
