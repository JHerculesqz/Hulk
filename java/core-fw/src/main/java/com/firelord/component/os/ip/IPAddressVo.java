package com.firelord.component.os.ip;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * IPAddressVo
 */
@ToString
public class IPAddressVo {
    // #region Fields

    /**
     * ip
     */
    @Setter
    @Getter
    private String ip;

    /**
     * port
     */
    @Setter
    @Getter
    private String port;

    // #endregion
}
