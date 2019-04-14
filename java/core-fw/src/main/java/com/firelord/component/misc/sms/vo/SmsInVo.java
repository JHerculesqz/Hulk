package com.firelord.component.misc.sms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SmsInVo
 */
@ToString
public class SmsInVo {
    //#region Fields

    /**
     * accessKeyId
     */
    @Setter
    @Getter
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    @Setter
    @Getter
    private String accessKeySecret;

    /**
     * phoneNum
     */
    @Setter
    @Getter
    private String phoneNum;

    /**
     * signName
     */
    @Setter
    @Getter
    private String signName;

    /**
     * templateCode
     */
    @Setter
    @Getter
    private String templateCode;

    /**
     * userName
     */
    @Setter
    @Getter
    private String userName;

    //#endregion
}
