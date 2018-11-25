package com.firelord.test.component.threadpool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {
    //#region Fields

    //#endregion

    //#region test1

    @Scheduled(fixedRate = 10 * 1000)
    @Async
    public void test1() {
        System.out.println("scheduler task1...");
    }

    //#endregion
}
