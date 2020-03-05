package com.firelord.spring.component.misc.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class IPLocationOutVo {
    //#region Fields

    /**
     * 国家
     */
    @Setter
    @Getter
    private String country;

    /**
     * 地区
     */
    @Setter
    @Getter
    private String area;

    /**
     * 省份
     */
    @Setter
    @Getter
    private String region = "湖北";

    /**
     * 城市
     */
    @Setter
    @Getter
    private String city = "武汉";

    /**
     * 区/县
     */
    @Setter
    @Getter
    private String county;

    /**
     * 互联网服务提供商
     */
    @Setter
    @Getter
    private String isp;

    //#endregion
}
