package com.firelord.test.core.aop;

import com.firelord.test.core.aop.usage1.ProxyBean;
import com.firelord.test.core.aop.usage1.TestBean;
import com.firelord.test.core.aop.usage1.TestBeanImpl;
import com.firelord.test.core.aop.usage1.TestInterceptor;
import com.firelord.test.core.aop.usage2.TestAOPService;
import com.firelord.test.core.aop.usage2.TestServiceAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aop")
public class TestAOPController {
    //#region Fields

    @Autowired
    private TestAOPService testAOPService;

    //#endregion

    //#region test1

    @RequestMapping("test1")
    @ResponseBody
    public String test1() {
        TestBean oProxy = (TestBean) ProxyBean.getProxyBean(new TestBeanImpl(), new TestInterceptor());
        String strOut = oProxy.test("input");
        return strOut;
    }

    //#endregion

    //#region test2

    @RequestMapping("test2")
    @ResponseBody
    public String test2() {
        String strOut = this.testAOPService.test("testAOPService1");
        return strOut;
    }

    //#endregion

    //#region test3

    @RequestMapping("test3")
    @ResponseBody
    public String test3() {
        ((TestServiceAdv) this.testAOPService).adv();
        return "test3...";
    }

    //#endregion
}
