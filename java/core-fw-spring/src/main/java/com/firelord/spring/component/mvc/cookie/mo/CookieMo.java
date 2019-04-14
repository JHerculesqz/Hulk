package com.firelord.spring.component.mvc.cookie.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * CookieMo
 */
@ToString
public class CookieMo {
    //#region Fields

    /**
     * key
     */
    @Setter
    @Getter
    private String key;

    /**
     * value
     */
    @Setter
    @Getter
    private String value;

    /**
     * domain
     */
    @Setter
    @Getter
    private String domain;

    /**
     * path
     */
    @Setter
    @Getter
    private String path;

    /**
     * expire
     */
    @Setter
    @Getter
    private int expire;

    /**
     * secure
     */
    @Setter
    @Getter
    private boolean secure;

    /**
     * httpOnly
     */
    @Setter
    @Getter
    private boolean httpOnly;

    //#endregion
}
