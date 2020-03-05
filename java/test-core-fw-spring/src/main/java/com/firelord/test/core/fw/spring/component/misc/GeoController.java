package com.firelord.test.core.fw.spring.component.misc;

import com.firelord.spring.component.misc.geo.GisUtilsEx;
import com.firelord.spring.component.misc.geo.vo.GeoCoderOutVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/misc/geo")
public class GeoController {
    //#region Fields

    //#endregion

    //#region geoCoderReverse

    /**
     * geoCoderReverse
     */
    @RequestMapping("/geoCoderReverse")
    @ResponseBody
    public RespVo geoCoderReverse() {
        RespVo oRespVo = new RespVo();

        GeoCoderOutVo oOutVo = GisUtilsEx.geoCoderReverse(
                "39.992368",
                "116.332404",
                "1qa8751RB1ddLeDq3EQQa3xHaAqOAoPj");
        oRespVo.setResultObj(oOutVo);

        return oRespVo;
    }

    //#endregion
}
