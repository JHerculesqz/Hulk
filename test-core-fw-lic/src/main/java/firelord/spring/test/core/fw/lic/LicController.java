package firelord.spring.test.core.fw.lic;

import com.firelord.lic.check.LicCheck;
import com.firelord.lic.check.mo.LicCheckInMo;
import com.firelord.lic.gen.LicGen;
import com.firelord.lic.gen.mo.LicGenInMo;
import com.firelord.spring.component.rpc.http.vo.ReqVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lic")
public class LicController {
    //#region Fields

    //#endregion

    //#region gen

    /**
     * gen
     */
    @RequestMapping("/gen")
    @ResponseBody
    public RespVo gen(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        LicGenInMo oInVo = oReqVo.getReqBuVo(LicGenInMo.class);

        //Provider
        LicGen.gen(oInVo);

        return oRespVo;
    }

    //#endregion

    //#region install

    /**
     * install
     */
    @RequestMapping("/install")
    @ResponseBody
    public RespVo install(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        LicCheckInMo oInVo = oReqVo.getReqBuVo(LicCheckInMo.class);

        //Provider
        LicCheck oLicChecker = new LicCheck();
        oLicChecker.install(oInVo);

        return oRespVo;
    }

    //#endregion

    //#region check

    /**
     * check
     */
    @RequestMapping("/check")
    @ResponseBody
    public RespVo check() {
        RespVo oRespVo = new RespVo();

        //Provider
        boolean bCheckRes = LicCheck.check();
        oRespVo.setOK(bCheckRes);

        return oRespVo;
    }

    //#endregion
}
