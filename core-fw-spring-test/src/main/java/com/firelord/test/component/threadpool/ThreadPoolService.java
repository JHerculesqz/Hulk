package com.firelord.test.component.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolService {
    //#region test1

    @Async
    public void test1() {
        System.out.println("[Process Thread]" + Thread.currentThread().getName());
    }

    //#endregion
}
