package com.firelord.test.core.fw.component.ds.id;

import com.firelord.component.ds.id.IDUtilsEx;
import com.firelord.component.ds.id.vo.GenInVo;
import com.firelord.spring.component.rpc.http.vo.ReqVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ds/id")
public class IDController {
    //#region gen

    /**
     * gen1
     */
    @RequestMapping("/gen1")
    @ResponseBody
    public RespVo gen1() {
        RespVo oRespVo = new RespVo();

        oRespVo.setResultObj(IDUtilsEx.gen());

        return oRespVo;
    }

    /**
     * gen
     */
    @RequestMapping("/gen2")
    @ResponseBody
    public RespVo gen2(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GenInVo oInVo = oReqVo.getReqBuVo(GenInVo.class);

        //Provider
        oRespVo.setResultObj(IDUtilsEx.gen(oInVo.getKey()));

        return oRespVo;
    }

    //#endregion
}
