package com.firelord.spring.component.mvc.session.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SessionItemMo
 */
@ToString
public class SessionItemMo {
    //#region Fields

    /**
     * session key
     */
    @Setter
    @Getter
    private String key;

    /**
     * session value
     */
    @Setter
    @Getter
    private Object value;

    //#endregion
}
