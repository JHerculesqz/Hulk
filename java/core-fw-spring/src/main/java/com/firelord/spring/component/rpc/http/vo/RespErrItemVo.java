package com.firelord.spring.component.rpc.http.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RespErrItemVo
 */
@ToString
public class RespErrItemVo {
    //#region Fields

    /**
     * error code
     */
    @Setter
    @Getter
    private String code;

    /**
     * error description
     */
    @Setter
    @Getter
    private String desc;

    /**
     * error reason
     */
    @Setter
    @Getter
    private String reason;

    /**
     * error advice
     */
    @Setter
    @Getter
    private String advice;

    //#endregion
}
