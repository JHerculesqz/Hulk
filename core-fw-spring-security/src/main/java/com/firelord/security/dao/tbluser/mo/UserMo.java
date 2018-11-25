package com.firelord.security.dao.tbluser.mo;

import lombok.*;

/**
 * UserMo
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserMo {
    //#region Fields

    /**
     * email
     */
    @Setter
    @Getter
    private String email;

    /**
     * password
     */
    @Setter
    @Getter
    private String password;

    /**
     * role name
     */
    @Setter
    @Getter
    private String roleName;

    //#endregion
}
