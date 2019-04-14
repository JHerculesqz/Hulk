package com.firelord.spring.component.rpc.http.vo;

import com.firelord.component.seri.json.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ReqVo
 */
@ToString
public class ReqVo implements Serializable {
    //#region Fields

    /**
     * reqBuVoStr
     */
    @Setter
    @Getter
    private String reqBuVoStr;

    //#region wait to delete
//    @Setter
//    @Getter
//    private String contextClientId;
//
//    @Setter
//    @Getter
//    private String contextTaskId;
//
//    @Setter
//    @Getter
//    private String contextReqTime;
//
//    @Setter
//    @Getter
//    private String contextReqName;
    //#endregion

    //#endregion

    //#region reqBuVo

    /**
     * setReqBuVo
     *
     * @param oReqBuVo object
     */
    public void setReqBuVo(Object oReqBuVo) {
        //json to string
        String strReqBuVo = JsonUtils.toStr(oReqBuVo);

        //set reqBuVoStr
        this.reqBuVoStr = strReqBuVo;
    }

    /**
     * string to object
     *
     * @param oClazz object
     * @param <T>    object type
     * @return object
     */
    public <T> T getReqBuVo(Class<T> oClazz) {
        //string to object
        T oRes = JsonUtils.toObj(this.reqBuVoStr, oClazz);
        return oRes;
    }

    //#endregion
}