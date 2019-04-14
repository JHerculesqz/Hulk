package com.firelord.spring.component.misc.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * GeoCoderOutVoItem
 */
@ToString
public class GeoCoderOutVoItem {
    //#region Fields

    /**
     * country
     */
    @Setter
    @Getter
    private String country;

    /**
     * province
     */
    @Setter
    @Getter
    private String province;

    /**
     * city
     */
    @Setter
    @Getter
    private String city;

    /**
     * district
     */
    @Setter
    @Getter
    private String district;

    /**
     * town
     */
    @Setter
    @Getter
    private String town;

    /**
     * street
     */
    @Setter
    @Getter
    private String street;

    /**
     * streetNum
     */
    @Setter
    @Getter
    private String streetNum;

    //#endregion
}
