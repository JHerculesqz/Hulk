package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.component.ds.str.StringUtilsEx;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFTaskInfoVo4Chg;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.history.HistoricProcessInstanceQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceQuery;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommonProvider {

    //#region Fields

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;

    //#endregion

    //#region createIns

    public WFInsVo4Chg createIns(String strModelKey, Map<String, Object> mapParams) {
        //Provider
        ProcessInstance oProcessInstance = this.runtimeService.startProcessInstanceByKey(
                strModelKey, mapParams);

        //OutVo
        WFInsVo4Chg oOutVo = new WFInsVo4Chg();
        oOutVo.setId(oProcessInstance.getId());
        oOutVo.setName(oProcessInstance.getName());
        oOutVo.setProcessDefId(oProcessInstance.getProcessDefinitionId());
        oOutVo.setBusinessKey(oProcessInstance.getBusinessKey());
        oOutVo.setStartTime(oProcessInstance.getStartTime());
        return oOutVo;
    }

    //#endregion

    //#region delIns

    public void delIns(String strInsId) {
        this.runtimeService.deleteProcessInstance(strInsId, "");
    }

    public void delHistoryIns(String strInsId) {
        this.historyService.deleteHistoricProcessInstance(strInsId);
    }

    //#endregion

    //#region getCurTask

    public Task getCurTask(String strInsId) {
        Task oTask = this.taskService.createTaskQuery().processInstanceId(strInsId)
                .active().singleResult();
        return oTask;
    }

    //#endregion

    //#region submitTask

    public void submitTask(Task oTask, Map<String, Object> mapParams) {
        this.taskService.complete(oTask.getId(), mapParams);
    }

    //#endregion

    //#region getTaskList

    public List<WFTaskInfoVo4Chg> getTaskList(String strInsId) {
        //Provider
        List<Task> lstTask = this.taskService.createTaskQuery().processInstanceId(strInsId)
                .orderByTaskCreateTime().asc().list();

        //OutVo
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = new ArrayList<>();
        for (Task oTask : lstTask) {
            lstWFTaskInfoVo4Chg.add(WFTaskInfoVo4Chg.transTask(oTask));
        }
        return lstWFTaskInfoVo4Chg;
    }

    //#endregion

    //#region getHistoryTaskList

    public List<WFTaskInfoVo4Chg> getHistoryTaskList(String strInsId) {
        List<HistoricTaskInstance> lstHistoricTaskInstance = this.historyService.
                createHistoricTaskInstanceQuery().
                processInstanceId(strInsId).
                orderByTaskCreateTime().asc().list();

        List<HistoricTaskInstance> lstParent = lstHistoricTaskInstance.parallelStream()
                .filter((o) -> StringUtilsEx.isNullOrEmpty(o.getParentTaskId())).collect(Collectors.toList());

        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = new ArrayList<>();
        for (HistoricTaskInstance oHistoricTaskInstance : lstParent) {
            WFTaskInfoVo4Chg oParentWFTaskInfoVo4Chg = WFTaskInfoVo4Chg.transHistoricTaskInstance(oHistoricTaskInstance);
            getChildTask(oParentWFTaskInfoVo4Chg, lstHistoricTaskInstance);
            lstWFTaskInfoVo4Chg.add(oParentWFTaskInfoVo4Chg);
        }
        return lstWFTaskInfoVo4Chg;
    }

    private void getChildTask(WFTaskInfoVo4Chg oParentWFTaskInfoVo4Chg, List<HistoricTaskInstance> lstHistoricTaskInstance) {
        lstHistoricTaskInstance.forEach((oHistoricTaskInstance) -> {
            if (oParentWFTaskInfoVo4Chg.getId().equals(oHistoricTaskInstance.getParentTaskId())) {
                WFTaskInfoVo4Chg oWFTaskInfoVo4Chg = WFTaskInfoVo4Chg.transHistoricTaskInstance(oHistoricTaskInstance);
                getChildTask(oWFTaskInfoVo4Chg, lstHistoricTaskInstance);
                oParentWFTaskInfoVo4Chg.getChildren().add(oWFTaskInfoVo4Chg);
            }
        });
    }

    public List<WFTaskInfoVo4Chg> getHistoryActList(String strInsId) {
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = new ArrayList<>();
        List<HistoricActivityInstance> lstHisActivity = this.historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(strInsId).list();
        Collections.sort(lstHisActivity, (o1, o2) -> o1.getStartTime().compareTo(o2.getStartTime()));
        for (HistoricActivityInstance oHisActivity : lstHisActivity) {
            if (!StringUtilsEx.isNullOrEmpty(oHisActivity.getActivityName())) {
                WFTaskInfoVo4Chg oWFTaskInfoVo4Chg = WFTaskInfoVo4Chg.transHistoricActivityInstance(oHisActivity);
                lstWFTaskInfoVo4Chg.add(oWFTaskInfoVo4Chg);
            }
        }
        return lstWFTaskInfoVo4Chg;
    }

    //#endregion

    //#region getInsList

    public WFInsSetVo4Chg getInsList(String strModelKey, int iLimit, int iSkip) {
        WFInsSetVo4Chg oOutVo = new WFInsSetVo4Chg();

        ProcessInstanceQuery oProcessInstanceQuery = this.runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(strModelKey);
        List<ProcessInstance> lstProcessInstanceQuery = oProcessInstanceQuery.listPage(iSkip, iLimit);
        if (lstProcessInstanceQuery != null && lstProcessInstanceQuery.size() > 0) {
            for (ProcessInstance oProcessInstance : lstProcessInstanceQuery) {
                WFInsVo4Chg oWFInsVo4Chg = WFInsVo4Chg.genByProcessInstance(oProcessInstance);
                oOutVo.getLstWFInsVo4Chg().add(oWFInsVo4Chg);
            }
        }
        oOutVo.setCount(oProcessInstanceQuery.count());

        return oOutVo;
    }

    //#endregion

    //#region getHistoryInsList

    public WFInsSetVo4Chg getHistoryInsList(String strModelKey, int iLimit, int iSkip) {
        WFInsSetVo4Chg oOutVo = new WFInsSetVo4Chg();

        HistoricProcessInstanceQuery oHistoricProcessInstanceQuery = this.historyService
                .createHistoricProcessInstanceQuery().processDefinitionKey(strModelKey);
        List<HistoricProcessInstance> lstHistoricProcessInstance =
                oHistoricProcessInstanceQuery.finished().listPage(iSkip, iLimit);
        if (lstHistoricProcessInstance != null && lstHistoricProcessInstance.size() > 0) {
            for (HistoricProcessInstance oHistoricProcessInstance : lstHistoricProcessInstance) {
                WFInsVo4Chg oWFInsVo4Chg = WFInsVo4Chg.genByHistoryProcessInstance(oHistoricProcessInstance);
                oOutVo.getLstWFInsVo4Chg().add(oWFInsVo4Chg);
            }
        }
        oOutVo.setCount(oHistoricProcessInstanceQuery.count());

        return oOutVo;
    }

    //#endregion

    //???

    //#region executeAlg

    public ProcessInstance executeAlg(String strWFModelKey, Map<String, Object> mapParams) {
        ProcessInstance oProcessInstance = this.runtimeService.startProcessInstanceByKey(
                strWFModelKey, mapParams);
        return oProcessInstance;
    }

    public Task getCurTaskInProcessInstance(String strWFInsId) {
        Task oTask = this.taskService.createTaskQuery().
                processInstanceId(strWFInsId).singleResult();
        return oTask;
    }

    //#endregion

    //#region getWFInsPng

    public String getWFInsPng(String strWFInsId) throws Exception {

        //获取历史流程实例
        HistoricProcessInstance processInstance = this.historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(strWFInsId).singleResult();
        //获取流程图
        BpmnModel bpmnModel = this.repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList = this.historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(strWFInsId).list();

        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();

        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }
        List<String> highLightedFlows = new ArrayList<String>();

        //中文显示的是口口口，设置字体就好了
        DefaultProcessDiagramGenerator oDefaultProcessDiagramGenerator = new DefaultProcessDiagramGenerator();

        InputStream imageStream = oDefaultProcessDiagramGenerator.generateDiagram(bpmnModel, "png",
                highLightedActivitis, highLightedFlows,
                "宋体", "宋体", "宋体",
                null, 1.0, true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while ((len = imageStream.read(buffer)) != -1) {
            outputStream.write(buffer);
        }
        imageStream.close();
        BASE64Encoder oBASE64Encoder = new BASE64Encoder();
        String strImg = oBASE64Encoder.encodeBuffer(outputStream.toByteArray()).trim();
        return strImg;
    }

    //#endregion
}
