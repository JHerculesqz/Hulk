package com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getLogList4MopWF;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class GetLogList4MopWFInVo {
    //#region Fields

    @Setter
    @Getter
    private String insId;

    @Setter
    @Getter
    private List<String> levels;

    //#endregion
}
