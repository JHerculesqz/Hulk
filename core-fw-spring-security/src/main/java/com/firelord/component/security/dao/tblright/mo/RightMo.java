package com.firelord.component.security.dao.tblright.mo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RightMo
 */
@Builder
@ToString
public class RightMo {
    //#region Fields

    /**
     * url pattern
     */
    @Setter
    @Getter
    private String url;

    /**
     * role name
     */
    @Setter
    @Getter
    private String roleName;

    //#endregion
}
