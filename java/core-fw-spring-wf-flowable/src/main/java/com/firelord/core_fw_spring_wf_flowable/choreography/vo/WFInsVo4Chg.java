package com.firelord.core_fw_spring_wf_flowable.choreography.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Date;

@ToString
public class WFInsVo4Chg {
    //#region Fields

    @Setter
    @Getter
    private String id;

    /**
     * ModelId
     */
    @Setter
    @Getter
    private String processDefId;

    @Setter
    @Getter
    private String name;

    /**
     * ?
     */
    @Setter
    @Getter
    private String businessKey;

    @Setter
    @Getter
    private Date startTime;

    @Setter
    @Getter
    private Date endTime;

    //#endregion

    //#region gen

    public static WFInsVo4Chg genByProcessInstance(ProcessInstance oProcessInstance) {
        WFInsVo4Chg oWFInsVo4Chg = new WFInsVo4Chg();

        oWFInsVo4Chg.setId(oProcessInstance.getId());
        oWFInsVo4Chg.setProcessDefId(oProcessInstance.getProcessDefinitionId());
        oWFInsVo4Chg.setName(oProcessInstance.getName());
        oWFInsVo4Chg.setBusinessKey(oProcessInstance.getBusinessKey());
        oWFInsVo4Chg.setStartTime(oProcessInstance.getStartTime());

        return oWFInsVo4Chg;
    }

    public static WFInsVo4Chg genByHistoryProcessInstance(HistoricProcessInstance oHistoricProcessInstance) {
        WFInsVo4Chg oWFInsVo4Chg = new WFInsVo4Chg();

        oWFInsVo4Chg.setId(oHistoricProcessInstance.getId());
        oWFInsVo4Chg.setProcessDefId(oHistoricProcessInstance.getProcessDefinitionId());
        oWFInsVo4Chg.setName(oHistoricProcessInstance.getName());
        oWFInsVo4Chg.setBusinessKey(oHistoricProcessInstance.getBusinessKey());
        oWFInsVo4Chg.setStartTime(oHistoricProcessInstance.getStartTime());
        oWFInsVo4Chg.setEndTime(oHistoricProcessInstance.getEndTime());

        return oWFInsVo4Chg;
    }

    //#endregion
}
