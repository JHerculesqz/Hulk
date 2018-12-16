package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * HttpClientOutVo
 */
@ToString
public class HttpClientOutVo {
    //#region Fields

    /**
     * statusCode
     */
    @Setter
    @Getter
    private int statusCode;

    /**
     * reasonPhrase
     */
    @Setter
    @Getter
    private String reasonPhrase;

    /**
     * content
     */
    @Setter
    @Getter
    private String content;

    //#endregion
}
