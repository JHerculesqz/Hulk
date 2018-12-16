package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * RespErrVo
 */
@ToString
public class RespErrVo {
    //#region Fields

    /**
     * error items
     */
    @Setter
    @Getter
    private List<RespErrItemVo> items = new ArrayList<>();

    //#endregion
}
