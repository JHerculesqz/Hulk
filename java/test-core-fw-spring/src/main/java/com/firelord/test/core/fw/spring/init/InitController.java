package com.firelord.test.core.fw.spring.init;

import com.firelord.spring.component.rpc.http.vo.ReqVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * InitController
 */
@RestController
public class InitController {
    //#region Fields

    @Autowired
    private InitService initService;

    //#endregion

    //#region initXXX

    @RequestMapping("/initXXX")
    @ResponseBody
    public RespVo initXXX(@RequestBody ReqVo oReqVo) {
        return this.initService.initXXX(oReqVo);
    }

    //#endregion
}
