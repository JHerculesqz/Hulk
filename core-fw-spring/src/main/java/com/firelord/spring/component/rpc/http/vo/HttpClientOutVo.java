package com.firelord.spring.component.rpc.http.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.http.HttpStatus;

/**
 * HttpClientOutVo
 */
@ToString
public class HttpClientOutVo {
    //#region Fields

    /**
     * statusCode
     */
    @Setter
    @Getter
    private int statusCode;

    /**
     * reasonPhrase
     */
    @Setter
    @Getter
    private String reasonPhrase;

    /**
     * content
     */
    @Setter
    @Getter
    private String content;

    //#endregion

    //#region isExecuteOK

    /**
     * isExecuteOK
     *
     * @return true:execute ok
     */
    public boolean isExecuteOK() {
        //if ok
        if (this.statusCode == HttpStatus.SC_OK ||
                this.statusCode == HttpStatus.SC_ACCEPTED) {
            return true;
        }
        //if pok
        else {
            return false;
        }
    }

    //#endregion
}
