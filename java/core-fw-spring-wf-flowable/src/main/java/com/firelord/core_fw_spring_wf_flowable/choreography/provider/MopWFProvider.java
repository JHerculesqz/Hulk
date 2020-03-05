package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFTaskInfoVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogVo4Chg;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MopWFProvider {
    //#region Fields

    @Autowired
    private DBProviderMem dbProviderMem;

    @Autowired
    private CommonProvider commonProvider;

    //#endregion

    //#region createIns4MopWF

    public WFInsVo4Chg createIns4MopWF(String strModelKey, Map<String, Object> mapParams) {
        WFInsVo4Chg oWFInsVo4Chg = this.commonProvider.createIns(strModelKey, mapParams);
        return oWFInsVo4Chg;
    }

    //#endregion

    //#region delIns4MopWF

    public void delIns4MopWF(String strInsId) {
        this.commonProvider.delIns(strInsId);
    }

    //#endregion

    //#region delHistoryIns4MopWF

    public void delHistoryIns4MopWF(String strInsId) {
        this.commonProvider.delHistoryIns(strInsId);
    }

    //#endregion

    //#region submitTask4MopWF

    public Task submitTask4MopWF(String strInsId, Map<String, Object> mapParams) {
        Task oTask = this.commonProvider.getCurTask(strInsId);
        this.commonProvider.submitTask(oTask, mapParams);
        return oTask;
    }

    //#endregion

    //#region getInsList4MopWF

    public WFInsSetVo4Chg getInsList4MopWF(String strModelKey, int iLimit, int iSkip) {
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.commonProvider.getInsList(strModelKey, iLimit, iSkip);
        return oWFInsSetVo4Chg;
    }

    //#endregion

    //#region getHistoryInsList4MopWF

    public WFInsSetVo4Chg getHistoryInsList4MopWF(String strModelKey, int iLimit, int iSkip) {
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.commonProvider.getHistoryInsList(strModelKey, iLimit, iSkip);
        return oWFInsSetVo4Chg;
    }

    //#endregion

    //#region getTaskList4MopWF

    public List<WFTaskInfoVo4Chg> getTaskList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = this.commonProvider.getTaskList(strInsId);
        return lstWFTaskInfoVo4Chg;
    }

    //#endregion

    //#region getHistoryTaskList4MopWF

    public List<WFTaskInfoVo4Chg> getHistoryTaskList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstHistoryTask = this.commonProvider.getHistoryTaskList(strInsId);
        return lstHistoryTask;
    }

    //#endregion

    //#region getHistoryActList4MopWF

    public List<WFTaskInfoVo4Chg> getHistoryActList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstHistoryTask = this.commonProvider.getHistoryActList(strInsId);
        return lstHistoryTask;
    }

    //#endregion

    //#region mopLogs

    public void writeLog4MopWF(WFLogVo4Chg oWFLogVo4Chg) {
        this.dbProviderMem.getWfLogSetVo4Chg().getLstWFLogVo4Chg().add(oWFLogVo4Chg);
    }

    public void writeLogList4MopWF(List<WFLogVo4Chg> lstWFLogVo4Chg) {
        this.dbProviderMem.getWfLogSetVo4Chg().getLstWFLogVo4Chg().addAll(lstWFLogVo4Chg);
    }

    public void delLog4MopWF(String strLogId) {
        this.dbProviderMem.getWfLogSetVo4Chg().getLstWFLogVo4Chg().removeIf((o) -> o.getId().equals(strLogId));
    }

    /**
     * getLogList4MopWF
     *
     * @param strInsId 实例ID
     * @param lstLevel lstLevel
     * @return WFLogSetVo4Chg
     */
    public WFLogSetVo4Chg getLogList4MopWF(String strInsId, List<String> lstLevel) {
        WFLogSetVo4Chg oWFLogSetVo4Chg = new WFLogSetVo4Chg();
        List<WFLogVo4Chg> lstWFLogVo4Chg = this.dbProviderMem.getWfLogSetVo4Chg().getLstWFLogVo4Chg();
        oWFLogSetVo4Chg.setLstWFLogVo4Chg(lstWFLogVo4Chg.stream()
                .filter(o -> o.getInsId().equals(strInsId) && (lstLevel.contains(o.getLevel()) || lstLevel.size() == 0))
                .collect(Collectors.toList()));
        oWFLogSetVo4Chg.setCount(lstWFLogVo4Chg.size());
        return oWFLogSetVo4Chg;
    }

    //#endregion

    //#region getWFInsPng

    public String getWFInsPng(String strInsId) throws Exception {
        return this.commonProvider.getWFInsPng(strInsId);
    }

    //#endregion
}
