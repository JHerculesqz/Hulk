package com.firelord.spring.component.threadpool;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * ThreadConfig
 */
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {
    //#region getAsyncExecutor

    /**
     * override task executor
     * core pool size:10
     * max pool seize:30
     * queue size:2000
     *
     * @return task executor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor oTaskExecutor = new ThreadPoolTaskExecutor();
        oTaskExecutor.setCorePoolSize(10);
        oTaskExecutor.setMaxPoolSize(30);
        oTaskExecutor.setQueueCapacity(2000);
        oTaskExecutor.initialize();
        return oTaskExecutor;
    }

    //#endregion
}
