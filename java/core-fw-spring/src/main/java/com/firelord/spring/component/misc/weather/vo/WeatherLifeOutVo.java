package com.firelord.spring.component.misc.weather.vo;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WeatherLifeOutVo {
    //#region Fields

    public List<WeatherLifeOutItemVo> HeWeather6 = new ArrayList<>();

    //#endregion

    //#region isEmpty

    public boolean isEmpty() {
        return 0 == this.HeWeather6.size();
    }

    //#endregion

    //#region get

    public WeatherLifeVo get(String strType) {
        if (0 == this.HeWeather6.size()) {
            return null;
        }

        List<WeatherLifeVo> lstWeatherLifeVo = this.HeWeather6.get(0).lifestyle;
        for (WeatherLifeVo oWeatherLifeVo : lstWeatherLifeVo) {
            if (oWeatherLifeVo.type.equals(strType)) {
                return oWeatherLifeVo;
            }
        }

        return null;
    }

    //#endregion
}
