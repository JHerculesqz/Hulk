package com.firelord.test.component.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadpool")
public class ThreadPoolController {
    //#region Fields

    @Autowired
    private ThreadPoolService threadPoolService;

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    public void test1() {
        System.out.println("[Request Thread]" + Thread.currentThread().getName());
        this.threadPoolService.test1();
    }

    //#endregion
}
