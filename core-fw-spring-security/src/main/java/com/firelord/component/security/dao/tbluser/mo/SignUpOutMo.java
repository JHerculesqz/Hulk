package com.firelord.component.security.dao.tbluser.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SignUpOutMo
 */
@ToString
public class SignUpOutMo {
    //#region Fields

    /**
     * true:sign up success
     */
    @Setter
    @Getter
    private boolean ok = true;

    /**
     * sign up fail reason
     */
    @Setter
    @Getter
    private String retMsg;

    //#endregion
}
