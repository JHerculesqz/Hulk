package com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop;

import com.firelord.component.ds.date.DateUtilsEx;
import com.firelord.component.ds.id.IDUtilsEx;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class WFLogVo4Chg {

    //#region Fields

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String insId;

    @Setter
    @Getter
    private String taskId;

    @Setter
    @Getter
    private String userId;

    @Setter
    @Getter
    private String level;

    @Setter
    @Getter
    private String content;

    @Setter
    @Getter
    private String createTime;

    //#endregion

    //#region gen

    public static WFLogVo4Chg gen(String strInsId, String strTaskId, String strLevel, String strUserId, String strContent) {
        WFLogVo4Chg oWFLogVo4Chg = new WFLogVo4Chg();
        oWFLogVo4Chg.setId(IDUtilsEx.gen());
        oWFLogVo4Chg.setInsId(strInsId);
        oWFLogVo4Chg.setTaskId(strTaskId);
        oWFLogVo4Chg.setLevel(strLevel);
        oWFLogVo4Chg.setUserId(strUserId);
        oWFLogVo4Chg.setContent(strContent);
        oWFLogVo4Chg.setCreateTime(DateUtilsEx.now(DateUtilsEx.TIMEZONE_0, DateUtilsEx.FORMAT2));
        return oWFLogVo4Chg;
    }

    //#endregion
}
