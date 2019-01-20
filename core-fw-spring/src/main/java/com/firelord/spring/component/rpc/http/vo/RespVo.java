package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * RespVo
 */
@ToString
public class RespVo {
    //#region Fields

    /**
     * true: success
     */
    @Setter
    @Getter
    private boolean isOK = true;

    /**
     * result object
     */
    @Setter
    @Getter
    private Object resultObj;

    /**
     * error object
     */
    @Setter
    @Getter
    private RespErrVo errorObj;

    // #endregion

    //#region genRespVo4Err

    public static RespVo genRespVo4Err(String strErrCode) {
        RespVo oRespVo = new RespVo();

        oRespVo.setOK(false);
        RespErrVo oRespErrVo = new RespErrVo();
        RespErrItemVo oRespErrItemVo = new RespErrItemVo();
        oRespErrItemVo.setCode(strErrCode);
        oRespErrItemVo.setDesc(strErrCode);
        oRespErrItemVo.setReason(strErrCode);
        oRespErrItemVo.setAdvice(strErrCode);
        oRespErrVo.getItems().add(oRespErrItemVo);
        oRespVo.setErrorObj(oRespErrVo);

        return oRespVo;
    }

    public static RespVo genRespVo4Err(List<String> lstErrCode) {
        RespVo oRespVo = new RespVo();

        oRespVo.setOK(false);

        for (String strErrCode : lstErrCode) {
            RespErrVo oRespErrVo = new RespErrVo();
            RespErrItemVo oRespErrItemVo = new RespErrItemVo();
            oRespErrItemVo.setCode(strErrCode);
            oRespErrItemVo.setDesc(strErrCode);
            oRespErrItemVo.setReason(strErrCode);
            oRespErrItemVo.setAdvice(strErrCode);
            oRespErrVo.getItems().add(oRespErrItemVo);
            oRespVo.setErrorObj(oRespErrVo);
        }

        return oRespVo;
    }

    //#endregion
}
