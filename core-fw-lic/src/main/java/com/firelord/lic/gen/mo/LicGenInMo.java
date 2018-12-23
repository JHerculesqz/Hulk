package com.firelord.lic.gen.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.firelord.component.os.os.mo.OSOutMo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * LicGenInMo
 */
public class LicGenInMo {
    //#region Fields

    /**
     * subject
     */
    @Setter
    @Getter
    private String subject;

    /**
     * privateAlias
     */
    @Setter
    @Getter
    private String privateAlias;

    /**
     * keyPass
     */
    @Setter
    @Getter
    private String keyPass;

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
     * privateKeysStorePath
     */
    @Setter
    @Getter
    private String privateKeysStorePath;

    /**
     * issuedTime
     */
    @Setter
    @Getter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date issuedTime = new Date();

    /**
     * expiryTime
     */
    @Setter
    @Getter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiryTime;

    /**
     * consumerType
     */
    @Setter
    @Getter
    private String consumerType = "user";

    /**
     * consumerAmount
     */
    @Setter
    @Getter
    private Integer consumerAmount = 1;

    /**
     * description
     */
    @Setter
    @Getter
    private String description = "";

    /**
     * osOutMo
     */
    @Setter
    @Getter
    private OSOutMo osOutMo;

    //#endregion
}
