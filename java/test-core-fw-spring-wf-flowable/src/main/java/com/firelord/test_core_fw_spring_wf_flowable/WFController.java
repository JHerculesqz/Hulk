package com.firelord.test_core_fw_spring_wf_flowable;

import com.firelord.core_fw_spring_wf_flowable.choreography.WFInsUtils4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFTaskInfoVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsSetVo;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsVo;
import com.firelord.spring.component.rpc.http.vo.ReqVo;
import com.firelord.spring.component.rpc.http.vo.RespVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.createIns4MopWF.CreateIns4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.delHistoryIns4MopWF.DelHistoryIns4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.delIns4MopWF.DelIns4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getHistoryActList4MopWF.GetHistoryActList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getHistoryInsList4MopWF.GetHistoryInsList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getHistoryTaskList4MopWF.GetHistoryTaskList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getInsList4MopWF.GetInsList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getInsPng4MopWF.GetInsPng4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getLogList4MopWF.GetLogList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.getTaskList4MopWF.GetTaskList4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.submitTask4MopWF.SubmitTask4MopWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.createIns4UIWF.CreateIns4UIWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.delIns4UIWF.DelIns4UIWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.getIns4UIWF.GetIns4UIWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.getInsLst4UIWF.GetInsLst4UIWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.updateCurTaskId4UIWF.UpdateCurTaskId4UIWFInVo;
import com.firelord.test_core_fw_spring_wf_flowable.vo.uiwf.updateFinish4UIWF.UpdateFinish4UIWFInVo;
import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/wf/flowable")
public class WFController {
    //#region Fields

    @Autowired
    private WFInsUtils4Chg wfInsUtils4Chg;

    private Map<String, WFInsVo4Chg> mapIns4MopWF = new HashMap<>();

    //?bak
    @Autowired
    private IdentityService identityService;

    //#endregion

    //#region choreography

    //#region common

    //#endregion

    //#region uiWF

    @RequestMapping("/createIns4UIWF")
    @ResponseBody
    public RespVo createIns4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        CreateIns4UIWFInVo oInVo = oReqVo.getReqBuVo(CreateIns4UIWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.createIns4UIWF(oInVo.getModelKey(), oInVo.getUserId(), "业务侧属性",
                (oUIWFInsVo, oBuObj) -> {
                    System.out.println("业务侧回调");
                });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/delIns4UIWF")
    @ResponseBody
    public RespVo delIns4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        DelIns4UIWFInVo oInVo = oReqVo.getReqBuVo(DelIns4UIWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.delIns4UIWF(oInVo.getInsId(), (strInsId) -> {
            System.out.println("业务侧回调");
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/updateCurTaskId4UIWF")
    @ResponseBody
    public RespVo updateCurTaskId4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        UpdateCurTaskId4UIWFInVo oInVo = oReqVo.getReqBuVo(UpdateCurTaskId4UIWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.updateCurTaskId4UIWF(oInVo.getInsId(), oInVo.getTaskId(), (strInsId, strTaskId) -> {
            System.out.println("业务侧回调");
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/updateFinish4UIWF")
    @ResponseBody
    public RespVo updateFinish4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        UpdateFinish4UIWFInVo oInVo = oReqVo.getReqBuVo(UpdateFinish4UIWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.updateFinish4UIWF(oInVo.getInsId(), (strInsId) -> {
            System.out.println("业务侧回调");
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/getInsLst4UIWF")
    @ResponseBody
    public RespVo getInsLst4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetInsLst4UIWFInVo oInVo = oReqVo.getReqBuVo(GetInsLst4UIWFInVo.class);

        //Provider
        UIWFInsSetVo oUIWFInsSetVoEx = this.wfInsUtils4Chg.getInsLst4UIWF(oInVo.getLimit(), oInVo.getSkip(),
                (oUIWFInsSetVo) -> {
                    System.out.println("业务侧回调");
                });

        //OutVo
        oRespVo.setResultObj(oUIWFInsSetVoEx);
        return oRespVo;
    }

    @RequestMapping("/getIns4UIWF")
    @ResponseBody
    public RespVo getIns4UIWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetIns4UIWFInVo oInVo = oReqVo.getReqBuVo(GetIns4UIWFInVo.class);

        //Provider
        UIWFInsVo oOutVo = this.wfInsUtils4Chg.getIns4UIWF(oInVo.getInsId(), (strInsId, oUIWFInsVo) -> {
            System.out.println("业务侧回调");
        });

        //OutVo
        oRespVo.setResultObj(oOutVo);
        return oRespVo;
    }

    //#endregion

    //#region mopWF

    @RequestMapping("/createIns4MopWF")
    @ResponseBody
    public RespVo createIns4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        CreateIns4MopWFInVo oInVo = oReqVo.getReqBuVo(CreateIns4MopWFInVo.class);

        //Provider
        if (!mapIns4MopWF.containsKey(oInVo.getInsId4UIWF())) {
            this.wfInsUtils4Chg.createIns4MopWF(oInVo.getModelKey(), oInVo.getMapParams(), "业务数据",
                    (oWFInsVo4Chg, oBuObj) -> {
                        mapIns4MopWF.put(oInVo.getInsId4UIWF(), oWFInsVo4Chg);
                        //log
                        this.wfInsUtils4Chg.writeLog4MopWF(WFLogVo4Chg.gen(oWFInsVo4Chg.getId(), "",
                                "1", "", "【创建工作流】业务数据保存成功.."));
                    });
        }

        //OutVo
        oRespVo.setResultObj(mapIns4MopWF.get(oInVo.getInsId4UIWF()));
        return oRespVo;
    }

    @RequestMapping("/delIns4MopWF")
    @ResponseBody
    public RespVo delIns4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        DelIns4MopWFInVo oInVo = oReqVo.getReqBuVo(DelIns4MopWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.delIns4MopWF(oInVo.getInsId(), strInsId -> {
            System.out.println("业务侧回调");
            this.wfInsUtils4Chg.writeLog4MopWF(WFLogVo4Chg.gen(strInsId, "",
                    "1", "", "【删除工作流】删除业务数据成功.."));
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/delHistoryIns4MopWF")
    @ResponseBody
    public RespVo delHistoryIns4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        DelHistoryIns4MopWFInVo oInVo = oReqVo.getReqBuVo(DelHistoryIns4MopWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.delHistoryIns4MopWF(oInVo.getInsId(), strInsId -> {
            System.out.println("业务侧回调");
            this.wfInsUtils4Chg.writeLog4MopWF(WFLogVo4Chg.gen(strInsId, "",
                    "2", "", "【删除工作流】删除业务数据成功.."));
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/submitTask4MopWF")
    @ResponseBody
    public RespVo submitTask4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        SubmitTask4MopWFInVo oInVo = oReqVo.getReqBuVo(SubmitTask4MopWFInVo.class);

        //Provider
        this.wfInsUtils4Chg.submitTask4MopWF(oInVo.getInsId(), oInVo.getMapParams(), (strInsId, strTaskId) -> {
            System.out.println("业务侧回调");
            this.wfInsUtils4Chg.writeLog4MopWF(WFLogVo4Chg.gen(strInsId, strTaskId,
                    "2", "", "【工作流流转】流转前ID:" + strTaskId));
        });

        //OutVo
        return oRespVo;
    }

    @RequestMapping("/getInsList4MopWF")
    @ResponseBody
    public RespVo getInsList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetInsList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetInsList4MopWFInVo.class);

        //Provider
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.wfInsUtils4Chg.getInsList4MopWF(oInVo.getModelKey(),
                oInVo.getLimit(), oInVo.getSkip(), oWFInsSetVo4Chg1 -> {
                    System.out.println("业务侧回调");
                });

        //OutVo
        oRespVo.setResultObj(oWFInsSetVo4Chg);
        return oRespVo;
    }

    @RequestMapping("/getHistoryInsList4MopWF")
    @ResponseBody
    public RespVo getHistoryInsList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetHistoryInsList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetHistoryInsList4MopWFInVo.class);

        //Provider
        WFInsSetVo4Chg oWFInsSetVo4Chg = this.wfInsUtils4Chg.getHistoryInsList4MopWF(oInVo.getModelKey(),
                oInVo.getLimit(), oInVo.getSkip(), oWFInsSetVo4Chg1 -> {
                    System.out.println("业务侧回调");
                });

        //OutVo
        oRespVo.setResultObj(oWFInsSetVo4Chg);
        return oRespVo;
    }

    @RequestMapping("/getTaskList4MopWF")
    @ResponseBody
    public RespVo getTaskList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetTaskList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetTaskList4MopWFInVo.class);

        //Provider
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = this.wfInsUtils4Chg.getTaskList4MopWF(oInVo.getInsId());

        //OutVo
        oRespVo.setResultObj(lstWFTaskInfoVo4Chg);
        return oRespVo;
    }

    @RequestMapping("/getHistoryTaskList4MopWF")
    @ResponseBody
    public RespVo getHistoryTaskList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetHistoryTaskList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetHistoryTaskList4MopWFInVo.class);

        //Provider
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = this.wfInsUtils4Chg.getHistoryTaskList4MopWF(
                oInVo.getInsId());

        //OutVo
        oRespVo.setResultObj(lstWFTaskInfoVo4Chg);
        return oRespVo;
    }

    @RequestMapping("/getHistoryActList4MopWF")
    @ResponseBody
    public RespVo getHistoryActList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetHistoryActList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetHistoryActList4MopWFInVo.class);

        //Provider
        List<WFTaskInfoVo4Chg> lstWFTaskInfoVo4Chg = this.wfInsUtils4Chg.getHistoryActList4MopWF(
                oInVo.getInsId());

        //OutVo
        oRespVo.setResultObj(lstWFTaskInfoVo4Chg);
        return oRespVo;
    }

    @RequestMapping("/getLogList4MopWF")
    @ResponseBody
    public RespVo getLogList4MopWF(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        GetLogList4MopWFInVo oInVo = oReqVo.getReqBuVo(GetLogList4MopWFInVo.class);

        //Provider
        WFLogSetVo4Chg oWFLogSetVo4Chg = this.wfInsUtils4Chg.getLogList4MopWF(
                oInVo.getInsId(), oInVo.getLevels());

        //OutVo
        oRespVo.setResultObj(oWFLogSetVo4Chg);
        return oRespVo;
    }


    @RequestMapping("/getInsPng4MopWF")
    @ResponseBody
    public RespVo getInsPng4MopWF(@RequestBody ReqVo oReqVo) throws Exception {
        RespVo oRespVo = new RespVo();

        //InVo
        GetInsPng4MopWFInVo oInVo = oReqVo.getReqBuVo(GetInsPng4MopWFInVo.class);

        //Provider
        String oWFLogSetVo4Chg = this.wfInsUtils4Chg.getWFInsPng(oInVo.getInsId());

        //OutVo
        oRespVo.setResultObj(oWFLogSetVo4Chg);
        return oRespVo;
    }

    //#endregion

    //#region algWF

    //#endregion

    //#region ?bak

    @RequestMapping("/testWfInsExeSN")
    @ResponseBody
    public RespVo testWfInsExeSN(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

//        //InVo
//        TestWfInsExeSNInVo oInVo = oReqVo.getReqBuVo(TestWfInsExeSNInVo.class);
//
//        //#region Provider
//
//        //if processInstance is null
//        if (null == this.processInstance) {
//            Map<String, Object> mapParams = new HashMap<>();
//            this.processInstance = this.wfInsUtils4Chg.createIns("SNOSSMOP",
//                    mapParams);
//        }
//        //if processInstance is not null
//        else {
//            Map<String, Object> mapParams = new HashMap<>();
//            mapParams.put("actionType", oInVo.getActionType());
//            Task oTask = this.wfInsUtils4Chg.getCurTaskInProcessInstance(
//                    this.processInstance.getId());
//            this.wfInsUtils4Chg.submitTask(oTask, mapParams);
//        }
//
//        //#endregion
//
//        //OutVo
//        Task oTask = this.wfInsUtils4Chg.getCurTaskInProcessInstance(
//                this.processInstance.getId());
//        oRespVo.setResultObj(oTask.getName());

        return oRespVo;
    }

    //#endregion

    //#endregion

    //#region oa

    //#region wfSecurity

    @RequestMapping("/wfSecurity")
    @ResponseBody
    public void wfSecurity() {
        Group oGroup = this.identityService.newGroup("group1");
        oGroup.setName("group1");
        oGroup.setType("group1");
        this.identityService.saveGroup(oGroup);

        User oUser = this.identityService.newUser("user1");
        oUser.setEmail("user1@qq.com");
        oUser.setFirstName("user1");
        oUser.setLastName("user1");
        oUser.setPassword("user1");
        this.identityService.saveUser(oUser);

        this.identityService.createMembership(oUser.getId(), oGroup.getId());
    }

    //#endregion

    //#endregion
}
