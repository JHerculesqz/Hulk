package com.firelord.lic.check.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * LicCheckInMo
 */
@ToString
public class LicCheckInMo {
    //#region Fields

    /**
     * subject
     */
    @Setter
    @Getter
    private String subject;

    /**
     * publicAlias
     */
    @Setter
    @Getter
    private String publicAlias;

    /**
     * storePass
     */
    @Setter
    @Getter
    private String storePass;

    /**
     * licensePath
     */
    @Setter
    @Getter
    private String licensePath;

    /**
     * publicKeysStorePath
     */
    @Setter
    @Getter
    private String publicKeysStorePath;

    //#endregion
}
