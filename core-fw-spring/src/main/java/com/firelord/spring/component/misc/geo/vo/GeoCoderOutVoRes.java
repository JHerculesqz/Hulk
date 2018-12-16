package com.firelord.spring.component.misc.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * GeoCoderOutVoRes
 */
@ToString
public class GeoCoderOutVoRes {
    //#region Fields

    /**
     * business
     */
    @Setter
    @Getter
    private String business;

    /**
     * addressComponent
     */
    @Setter
    @Getter
    private GeoCoderOutVoItem addressComponent;

    //#endregion
}
