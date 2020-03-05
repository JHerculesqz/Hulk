package com.firelord.core_fw_spring_wf_flowable.choreography;

import com.firelord.core_fw_spring_wf_flowable.choreography.provider.*;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFTaskInfoVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsSetVo;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsVo;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class WFInsUtils4Chg {
    //#region Fields

    @Autowired
    private UIWFProvider uiwfProvider;

    @Autowired
    private MopWFProvider mopWFProvider;

    //#endregion

    //#region uiWF

    public void createIns4UIWF(String strModelKey, String strUserId, Object oBuObj,
                               ICallback4CreateIns4UIWF oCallback) {
        UIWFInsVo oUIWFInsVo = this.uiwfProvider.createIns4UIWF(strModelKey, strUserId);
        oCallback.run(oUIWFInsVo, oBuObj);
    }

    public void delIns4UIWF(String strInsId, ICallback4DelIns4UIWF oCallback) {
        this.uiwfProvider.delIns4UIWF(strInsId);
        oCallback.run(strInsId);
    }

    public void updateCurTaskId4UIWF(String strInsId, String strTaskId,
                                     ICallback4UpdateCurTaskId4UIWF oCallback) {
        this.uiwfProvider.updateCurTaskId4UIWF(strInsId, strTaskId);
        oCallback.run(strInsId, strTaskId);
    }

    public void updateFinish4UIWF(String strInsId, ICallback4UpdateFinish4UIWF oCallback) {
        this.uiwfProvider.updateFinish4UIWF(strInsId);
        oCallback.run(strInsId);
    }

    public UIWFInsSetVo getInsLst4UIWF(int iLimit, int iSkip, ICallback4GetInsLst4UIWF oCallback) {
        UIWFInsSetVo oOutVo = this.uiwfProvider.getInsLst4UIWF(iLimit, iSkip);
        oCallback.run(oOutVo);
        return oOutVo;
    }

    public UIWFInsVo getIns4UIWF(String strInsId, ICallback4GetWFIns4UIWF oCallback) {
        UIWFInsVo oOutVo = this.uiwfProvider.getIns4UIWF(strInsId);
        oCallback.run(strInsId, oOutVo);
        return oOutVo;
    }

    //#endregion

    //#region mopWF

    public void createIns4MopWF(String strModelKey, Map<String, Object> mapParams,
                                Object oBuObj, ICallback4CreateIns4MopWF oCallback) {
        WFInsVo4Chg oWFInsVo4Chg = this.mopWFProvider.createIns4MopWF(strModelKey, mapParams);
        oCallback.run(oWFInsVo4Chg, oBuObj);
    }

    public void delIns4MopWF(String strInsId, ICallback4DelIns4MopWF oCallback) {
        this.mopWFProvider.delIns4MopWF(strInsId);
        oCallback.run(strInsId);
    }

    public void delHistoryIns4MopWF(String strInsId, ICallback4DelHistoryIns4MopWF oCallback) {
        this.mopWFProvider.delHistoryIns4MopWF(strInsId);
        oCallback.run(strInsId);
    }

    public void submitTask4MopWF(String strInsId, Map<String, Object> mapParams,
                                 ICallback4SubmitTask4MopWF oCallback) {
        Task oTask = this.mopWFProvider.submitTask4MopWF(strInsId, mapParams);
        oCallback.run(strInsId, oTask.getId());
    }

    public WFInsSetVo4Chg getInsList4MopWF(String strModelKey, int iLimit, int iSkip,
                                           ICallback4GetInsList4MopWF oCallback) {
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.mopWFProvider.getInsList4MopWF(strModelKey, iLimit, iSkip);
        oCallback.run(oWFInsSetVo4Chg);
        return oWFInsSetVo4Chg;
    }

    public WFInsSetVo4Chg getHistoryInsList4MopWF(String strModelKey, int iLimit, int iSkip,
                                                  ICallback4GetHistoryInsList4MopWF oCallback) {
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.mopWFProvider.getHistoryInsList4MopWF(strModelKey, iLimit, iSkip);
        oCallback.run(oWFInsSetVo4Chg);
        return oWFInsSetVo4Chg;
    }

    public List<WFTaskInfoVo4Chg> getTaskList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = this.mopWFProvider.getTaskList4MopWF(strInsId);
        return lstWFTaskInfoVo4Chg;
    }

    public List<WFTaskInfoVo4Chg> getHistoryTaskList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstHistoryTask = this.mopWFProvider.getHistoryTaskList4MopWF(strInsId);
        return lstHistoryTask;
    }

    public List<WFTaskInfoVo4Chg> getHistoryActList4MopWF(String strInsId) {
        List<WFTaskInfoVo4Chg> lstHistoryTask = this.mopWFProvider.getHistoryActList4MopWF(strInsId);
        return lstHistoryTask;
    }

    public String getWFInsPng(String strInsId) throws Exception {
        return this.mopWFProvider.getWFInsPng(strInsId);
    }

    //#region mopLogs

    public void writeLog4MopWF(WFLogVo4Chg oWFLogVo4Chg) {
        this.mopWFProvider.writeLog4MopWF(oWFLogVo4Chg);
    }

    public void writeLogList4MopWF(List<WFLogVo4Chg> lstWFLogVo4Chg) {
        this.mopWFProvider.writeLogList4MopWF(lstWFLogVo4Chg);
    }

    public void delLog4MopWF(String logId) {
        this.mopWFProvider.delLog4MopWF(logId);
    }

    public WFLogSetVo4Chg getLogList4MopWF(String strInsId, List<String> lstLevel) {
        return this.mopWFProvider.getLogList4MopWF(strInsId, lstLevel);
    }

    //#endregion

    //#endregion

    //#region algWF

    //#endregion
}
