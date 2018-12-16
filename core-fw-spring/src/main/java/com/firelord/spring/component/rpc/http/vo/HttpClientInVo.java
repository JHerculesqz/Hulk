package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpClientInVo
 */
@ToString
public class HttpClientInVo {
    //#region Fields

    /**
     * host
     */
    @Setter
    @Getter
    private String host;

    /**
     * url
     */
    @Setter
    @Getter
    private String url;

    /**
     * params
     */
    @Setter
    @Getter
    private Map<String, String> params = new HashMap<>();

    /**
     * input
     */
    @Setter
    @Getter
    private String input;

    /**
     * formData
     */
    @Setter
    @Getter
    private Map<String, String> formData = new HashMap<>();

    //#endregion
}
