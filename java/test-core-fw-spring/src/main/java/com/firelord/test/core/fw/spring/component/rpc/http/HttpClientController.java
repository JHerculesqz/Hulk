package com.firelord.test.core.fw.spring.component.rpc.http;

import com.firelord.component.seri.json.JsonUtils;
import com.firelord.spring.component.rpc.http.HttpClientUtils;
import com.firelord.spring.component.rpc.http.vo.*;
import com.firelord.test.core.fw.spring.component.rpc.http.vo.PostOutVo;
import com.firelord.test.core.fw.spring.component.rpc.http.vo.get.GetOutVo;
import com.firelord.test.core.fw.spring.component.rpc.http.vo.post.PostInVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/rpc/http")
public class HttpClientController {
    //#region Fields

    //#endregion

    //#region get

    @RequestMapping("/consumerGet")
    @ResponseBody
    public RespVo consumerGet() throws IOException, URISyntaxException {
        HttpClientInVo oHttpClientInVo = new HttpClientInVo();
        oHttpClientInVo.setHost("localhost:9000");
        oHttpClientInVo.setUrl("/rpc/http/producerGet");
        oHttpClientInVo.getParams().put("param1", "value1");
        oHttpClientInVo.getParams().put("param2", "2");
        HttpClientOutVo oHttpClientOutVo = HttpClientUtils.getInstance().get(oHttpClientInVo);

        RespVo oRespVo = JsonUtils.toObj(oHttpClientOutVo.getContent(), RespVo.class);
        return oRespVo;
    }

    @RequestMapping(value = "/producerGet", method = RequestMethod.GET)
    @ResponseBody
    public RespVo producerGet(@RequestParam(value = "param1") String strParam1,
                              @RequestParam(value = "param2") String strParam2) {
        RespVo oRespVo = new RespVo();

        //Provider
        GetOutVo oOutVo = new GetOutVo();
        oOutVo.setProp1(strParam1);
        oOutVo.setProp2(Integer.parseInt(strParam2));

        //OutVo
        oRespVo.setResultObj(oOutVo);
        return oRespVo;
    }

    //#endregion

    //#region getErr

    @RequestMapping("/consumerGetErr")
    @ResponseBody
    public RespVo consumerGetErr() {
        HttpClientInVo oHttpClientInVo = new HttpClientInVo();
        oHttpClientInVo.setHost("localhost:9000");
        oHttpClientInVo.setUrl("/rpc/http/producerGetErr");
        oHttpClientInVo.getParams().put("param1", "value11");
        oHttpClientInVo.getParams().put("param2", "1");
        HttpClientOutVo oHttpClientOutVo = HttpClientUtils.getInstance().get(oHttpClientInVo);

        RespVo oRespVo = JsonUtils.toObj(oHttpClientOutVo.getContent(), RespVo.class);
        return oRespVo;
    }

    @RequestMapping(value = "/producerGetErr", method = RequestMethod.GET)
    @ResponseBody
    public RespVo producerGetErr(@RequestParam(value = "param1") String strParam1,
                                 @RequestParam(value = "param2") String strParam2) {
        RespVo oRespVo = new RespVo();

        //OutVo
        oRespVo.setOK(false);
        RespErrVo oErrVo = new RespErrVo();
        RespErrItemVo oItemVo = new RespErrItemVo();
        oItemVo.setCode("1");
        oItemVo.setDesc("error1");
        oItemVo.setReason("cause by xxx." + strParam1 + "," + strParam2);
        oItemVo.setAdvice("contact Hulk.");
        oErrVo.getItems().add(oItemVo);
        oRespVo.setErrorObj(oErrVo);
        return oRespVo;
    }

    //#endregion

    //#region postJson

    @RequestMapping("/consumerPostJson")
    @ResponseBody
    public RespVo consumerPostJson() {
        HttpClientInVo oHttpClientInVo = new HttpClientInVo();
        oHttpClientInVo.setHost("localhost:9000");
        oHttpClientInVo.setUrl("/rpc/http/producerPostJson");
        oHttpClientInVo.getParams().put("param1", "value1");
        oHttpClientInVo.getParams().put("param2", "2");
        ReqVo oReqVo = new ReqVo();
        PostInVo oInVo = new PostInVo();
        oInVo.setProp1("prop1");
        oInVo.setProp2(2);
        oReqVo.setReqBuVo(oInVo);
        oHttpClientInVo.setInput(JsonUtils.toStr(oReqVo));
        HttpClientOutVo oHttpClientOutVo = HttpClientUtils.getInstance().postJson(
                oHttpClientInVo);

        RespVo oRespVo = JsonUtils.toObj(oHttpClientOutVo.getContent(), RespVo.class);
        return oRespVo;
    }

    @RequestMapping(value = "/producerPostJson", method = RequestMethod.POST)
    @ResponseBody
    public RespVo producerPostJson(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //InVo
        PostInVo oInVo = oReqVo.getReqBuVo(PostInVo.class);

        //Provider
        PostOutVo oOutVo = new PostOutVo();
        oOutVo.setProp1(oInVo.getProp1());
        oOutVo.setProp2(oInVo.getProp2());

        //OutVo
        oRespVo.setResultObj(oOutVo);
        return oRespVo;
    }

    //#endregion

    //#region postJsonErr

    @RequestMapping("/consumerPostJsonErr")
    @ResponseBody
    public RespVo consumerPostJsonErr() {
        HttpClientInVo oHttpClientInVo = new HttpClientInVo();
        oHttpClientInVo.setHost("localhost:9000");
        oHttpClientInVo.setUrl("/rpc/http/producerPostJsonErr");
        ReqVo oReqVo = new ReqVo();
        PostInVo oInVo = new PostInVo();
        oInVo.setProp1("prop1");
        oInVo.setProp2(2);
        oReqVo.setReqBuVo(oInVo);
        oHttpClientInVo.setInput(JsonUtils.toStr(oReqVo));
        HttpClientOutVo oHttpClientOutVo = HttpClientUtils.getInstance().postJson(
                oHttpClientInVo);

        RespVo oRespVo = JsonUtils.toObj(oHttpClientOutVo.getContent(), RespVo.class);
        return oRespVo;
    }

    @RequestMapping(value = "/producerPostJsonErr", method = RequestMethod.POST)
    @ResponseBody
    public RespVo producerPostJsonErr(@RequestBody ReqVo oReqVo) {
        RespVo oRespVo = new RespVo();

        //OutVo
        oRespVo.setOK(false);
        RespErrVo oErrVo = new RespErrVo();
        RespErrItemVo oItemVo = new RespErrItemVo();
        oItemVo.setCode("2");
        oItemVo.setDesc("error2");
        oItemVo.setReason("cause by xxx." + oReqVo.getReqBuVoStr());
        oItemVo.setAdvice("contact Hulk.");
        oErrVo.getItems().add(oItemVo);
        oRespVo.setErrorObj(oErrVo);
        return oRespVo;
    }

    //#endregion

    //#region postForm

    @RequestMapping("/consumerPostForm")
    @ResponseBody
    public RespVo consumerPostForm() {
        HttpClientInVo oHttpClientInVo = new HttpClientInVo();
        oHttpClientInVo.setHost("localhost:9000");
        oHttpClientInVo.setUrl("/rpc/http/producerPostForm");
        oHttpClientInVo.getFormData().put("key1", "value1");
        oHttpClientInVo.getFormData().put("key2", "3");
        HttpClientOutVo oHttpClientOutVo = HttpClientUtils.getInstance().postForm(
                oHttpClientInVo);

        RespVo oRespVo = JsonUtils.toObj(oHttpClientOutVo.getContent(), RespVo.class);
        return oRespVo;
    }

    @RequestMapping(value = "/producerPostForm", method = RequestMethod.POST)
    @ResponseBody
    public RespVo producerPostForm(@RequestParam("key1") String strKey1,
                                   @RequestParam("key2") String strKey2) {
        RespVo oRespVo = new RespVo();

        //Provider
        PostOutVo oOutVo = new PostOutVo();
        oOutVo.setProp1(strKey1);
        oOutVo.setProp2(Integer.parseInt(strKey2));

        //OutVo
        oRespVo.setResultObj(oOutVo);
        return oRespVo;
    }

    //#endregion
}
