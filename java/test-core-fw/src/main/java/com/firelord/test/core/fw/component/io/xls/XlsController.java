package com.firelord.test.core.fw.component.io.xls;

import com.firelord.component.io.xls.OfficeXlsConfigUtilsEx;
import com.firelord.component.io.xls.OfficeXlsConfigUtilsExCallback;
import com.firelord.component.io.xls.OfficeXlsxUtilsEx;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/io/xls")
public class XlsController {
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

        List<String> lstOutVo = new ArrayList<>();
        OfficeXlsConfigUtilsEx.parseXls("C:\\test\\core-fw\\test.xlsx",
                0, new OfficeXlsConfigUtilsExCallback() {
                    @Override
                    public void row2Obj(Row oRow) {
                        String strValue = OfficeXlsxUtilsEx.getCell(0, oRow).toString();
                        lstOutVo.add(strValue);
                    }
                });
        oRespVo.setResultObj(lstOutVo);

        return oRespVo;
    }

    //#endregion
}
