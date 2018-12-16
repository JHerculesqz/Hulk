package com.firelord.spring.component.misc.geo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * GeoCoderOutVo
 */
@ToString
public class GeoCoderOutVo {
    //#region Const

    private static final String TEMPLATE_LOCATION = "%s-%s-%s-%s-%s";

    //#endregion

    //#region Fields

    /**
     * status
     */
    @Setter
    @Getter
    private int status;

    /**
     * result
     */
    @Setter
    @Getter
    private GeoCoderOutVoRes result;

    //#endregion

    //#region toStrEx

    /**
     * format result to String
     *
     * @return format result to String
     */
    public String toStrEx() {
        String strRes = "";

        if (0 == status) {
            String strCountry = result.getAddressComponent().getCountry();
            String strProvince = result.getAddressComponent().getProvince();
            String strCity = result.getAddressComponent().getCity();
            String strDistrict = result.getAddressComponent().getCity();
            String strStreet = result.getAddressComponent().getStreet();
            strRes = String.format(TEMPLATE_LOCATION, strCountry, strProvince, strCity,
                    strDistrict, strStreet);
        }

        return strRes;
    }

    //#endregion
}
