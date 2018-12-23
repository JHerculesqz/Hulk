package com.firelord.test.core.fw.spring.component.misc;

import com.firelord.component.os.os.OSUtilsEx;
import com.firelord.component.os.os.mo.OSOutMo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/misc/os")
public class OSController {
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

        OSOutMo oOutMo = OSUtilsEx.getInfo();
        oRespVo.setResultObj(oOutMo);

        return oRespVo;
    }

    //#endregion
}
