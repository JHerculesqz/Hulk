package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RespVo
 */
@ToString
public class RespVo {
    // #region Fields

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
}
