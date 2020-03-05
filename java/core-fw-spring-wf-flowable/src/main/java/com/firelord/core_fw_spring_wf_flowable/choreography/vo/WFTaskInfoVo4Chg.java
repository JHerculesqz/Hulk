package com.firelord.core_fw_spring_wf_flowable.choreography.vo;

import com.firelord.component.ds.date.DateUtilsEx;
import com.firelord.component.ds.str.StringUtilsEx;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WFTaskInfoVo4Chg {
    //#region Fields

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String wfInsId;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private boolean isFinish;

    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private String durationInMillis;

    @Setter
    @Getter
    private String startTime;

    @Setter
    @Getter
    private String endTime;

    @Setter
    @Getter
    private List<WFTaskInfoVo4Chg> children = new ArrayList<>();

    //#endregion

    //#region trans

    public static WFTaskInfoVo4Chg transTask(Task oTask) {
        WFTaskInfoVo4Chg oWFTaskInfoVo4Chg = new WFTaskInfoVo4Chg();
        oWFTaskInfoVo4Chg.setId(oTask.getId());
        oWFTaskInfoVo4Chg.setWfInsId(oTask.getProcessInstanceId());
        oWFTaskInfoVo4Chg.setName(oTask.getName());
        oWFTaskInfoVo4Chg.setStartTime(DateUtilsEx.dateToStr(oTask.getCreateTime(), DateUtilsEx.FORMAT2));
        oWFTaskInfoVo4Chg.setEndTime(DateUtilsEx.dateToStr(oTask.getClaimTime(), DateUtilsEx.FORMAT2));
        return oWFTaskInfoVo4Chg;
    }

    public static WFTaskInfoVo4Chg transHistoricTaskInstance(HistoricTaskInstance oHistoricTaskInstance) {
        WFTaskInfoVo4Chg oWFTaskInfoVo4Chg = new WFTaskInfoVo4Chg();
        oWFTaskInfoVo4Chg.setId(oHistoricTaskInstance.getId());
        oWFTaskInfoVo4Chg.setWfInsId(oHistoricTaskInstance.getProcessInstanceId());
        oWFTaskInfoVo4Chg.setName(oHistoricTaskInstance.getName());
        oWFTaskInfoVo4Chg.setStartTime(DateUtilsEx.dateToStr(oHistoricTaskInstance.getCreateTime(),
                DateUtilsEx.FORMAT2));
        oWFTaskInfoVo4Chg.setEndTime(DateUtilsEx.dateToStr(oHistoricTaskInstance.getEndTime(),
                DateUtilsEx.FORMAT2));

        return oWFTaskInfoVo4Chg;
    }

    public static WFTaskInfoVo4Chg transHistoricActivityInstance(HistoricActivityInstance oHisActivity) {
        WFTaskInfoVo4Chg oWFTaskInfoVo4Chg = new WFTaskInfoVo4Chg();
        oWFTaskInfoVo4Chg.setId(StringUtilsEx.isNullOrEmpty(oHisActivity.getTaskId()) ?
                oHisActivity.getActivityId() : oHisActivity.getTaskId());
        oWFTaskInfoVo4Chg.setWfInsId(oHisActivity.getProcessInstanceId());
        oWFTaskInfoVo4Chg.setName(oHisActivity.getActivityName());
        oWFTaskInfoVo4Chg.setType(oHisActivity.getActivityType());
        oWFTaskInfoVo4Chg.setStartTime(DateUtilsEx.dateToStr(oHisActivity.getStartTime(),
                DateUtilsEx.FORMAT2));
        String strEndTime = DateUtilsEx.dateToStr(oHisActivity.getEndTime(),
                DateUtilsEx.FORMAT2);
        oWFTaskInfoVo4Chg.setFinish(!StringUtilsEx.isNullOrEmpty(strEndTime));
        oWFTaskInfoVo4Chg.setDurationInMillis(String.valueOf(oHisActivity.getDurationInMillis()));
        oWFTaskInfoVo4Chg.setEndTime(strEndTime);
        return oWFTaskInfoVo4Chg;
    }

    //#endregion
}
