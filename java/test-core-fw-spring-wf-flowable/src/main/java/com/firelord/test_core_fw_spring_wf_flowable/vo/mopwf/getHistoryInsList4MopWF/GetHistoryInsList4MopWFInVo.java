package com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getHistoryInsList4MopWF;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetHistoryInsList4MopWFInVo {
    //#region Fields

    @Setter
    @Getter
    private String modelKey;

    @Setter
    @Getter
    private int limit;

    @Setter
    @Getter
    private int skip;

    //#endregion
}
