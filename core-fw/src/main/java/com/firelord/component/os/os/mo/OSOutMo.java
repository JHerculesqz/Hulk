package com.firelord.component.os.os.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * OSOutMo
 */
@ToString
public class OSOutMo implements Serializable {
    //#region Fields

    /**
     * ipLst
     */
    @Setter
    @Getter
    private List<String> ipLst;

    /**
     * macLst
     */
    @Setter
    @Getter
    private List<String> macLst;

    /**
     * cpu
     */
    @Setter
    @Getter
    private String cpu;

    /**
     * mainBoard
     */
    @Setter
    @Getter
    private String mainBoard;

    //#endregion
}
