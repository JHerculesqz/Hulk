package com.firelord.test.core.fw.component.misc.weather;

import com.firelord.component.misc.weather.WeatherUtils;
import com.firelord.component.misc.weather.mo.GetWeatherOutVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/misc/weather")
public class WeatherController {
    //#region Fields

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test")
    @ResponseBody
    public RespVo test() {
        RespVo oRespVo = new RespVo();

        GetWeatherOutVo oOutVo = WeatherUtils.getWeathers(1582);
        oRespVo.setResultObj(oOutVo);

        return oRespVo;
    }

    //#endregion
}
