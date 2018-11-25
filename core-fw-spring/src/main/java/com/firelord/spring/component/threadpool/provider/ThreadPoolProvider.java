package com.firelord.spring.component.threadpool.provider;

import com.firelord.spring.component.threadpool.provider.vo.ConfigThreadPoolVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * ThreadPoolProvider
 */
@Deprecated
@Component
public class ThreadPoolProvider {
    //#region Fields

    private ThreadPoolExecutor threadPool4Bu;

    private ThreadPoolExecutor threadPool4Sys;

    @Autowired
    private ConfigThreadPoolVo configThreadPoolVo;

    @Bean
    public ConfigThreadPoolVo configThreadPoolVo() {
        return new ConfigThreadPoolVo();
    }

    //#endregion

    //#region init

    protected void init(int iCorePoolSize4Bu, int iMaxPoolSize4Bu,
                        long iKeepAliveSecond4Bu, int iQueueSize4Bu,
                        int iCorePoolSize4Sys, int iMaxPoolSize4Sys,
                        long iKeepAliveSecond4Sys, int iQueueSize4Sys) {
        if (0 == iCorePoolSize4Bu && 0 == iMaxPoolSize4Bu &&
                0 == iKeepAliveSecond4Bu && 0 == iQueueSize4Bu
                && 0 == iCorePoolSize4Sys && 0 == iMaxPoolSize4Sys
                && 0 == iKeepAliveSecond4Sys && 0 == iQueueSize4Sys) {
            return;
        }

        // 1.init threadPool4Bu
        this.threadPool4Bu = new ThreadPoolExecutor(iCorePoolSize4Bu, iMaxPoolSize4Bu,
                iKeepAliveSecond4Bu, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(iQueueSize4Bu),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread oThread = new Thread(r);
                        oThread.setName("BuPool-" + UUID.randomUUID());
                        return oThread;
                    }
                });

        // 2.init threadPool4Sys
        this.threadPool4Sys = new ThreadPoolExecutor(iCorePoolSize4Sys, iMaxPoolSize4Sys,
                iKeepAliveSecond4Sys, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(iQueueSize4Sys),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread oThread = new Thread(r);
                        oThread.setName("SysPool-" + UUID.randomUUID());
                        return oThread;
                    }
                });
    }

    //#endregion

    //#region submit4Bu

    public void submit4Bu(Runnable oTask) {
        if (null == this.threadPool4Bu && null == this.threadPool4Sys) {
            init(configThreadPoolVo.getBuCorePoolSize(),
                    configThreadPoolVo.getBuMaxPoolSize(),
                    configThreadPoolVo.getBuKeepAliveSecond(),
                    configThreadPoolVo.getBuQueueSize(),
                    configThreadPoolVo.getSysCorePoolSize(),
                    configThreadPoolVo.getSysMaxPoolSize(),
                    configThreadPoolVo.getSysKeepAliveSecond(),
                    configThreadPoolVo.getSysQueueSize());
        }

        if (this.threadPool4Bu != null) {
            this.threadPool4Bu.submit(oTask);
        }
    }

    public <T> Future<T> submit4Bu(Callable<T> oTask) {
        if (null == this.threadPool4Bu && null == this.threadPool4Sys) {
            init(configThreadPoolVo.getBuCorePoolSize(),
                    configThreadPoolVo.getBuMaxPoolSize(),
                    configThreadPoolVo.getBuKeepAliveSecond(),
                    configThreadPoolVo.getBuQueueSize(),
                    configThreadPoolVo.getSysCorePoolSize(),
                    configThreadPoolVo.getSysMaxPoolSize(),
                    configThreadPoolVo.getSysKeepAliveSecond(),
                    configThreadPoolVo.getSysQueueSize());
        }

        if (this.threadPool4Bu != null) {
            Future<T> oFuture = this.threadPool4Bu.submit(oTask);
            return oFuture;
        }
        return null;
    }

    //#endregion

    //#region submit4Sys

    public void submit4Sys(Runnable oTask) {
        if (null == this.threadPool4Bu && null == this.threadPool4Sys) {
            init(configThreadPoolVo.getBuCorePoolSize(),
                    configThreadPoolVo.getBuMaxPoolSize(),
                    configThreadPoolVo.getBuKeepAliveSecond(),
                    configThreadPoolVo.getBuQueueSize(),
                    configThreadPoolVo.getSysCorePoolSize(),
                    configThreadPoolVo.getSysMaxPoolSize(),
                    configThreadPoolVo.getSysKeepAliveSecond(),
                    configThreadPoolVo.getSysQueueSize());
        }

        if (this.threadPool4Bu != null) {
            this.threadPool4Sys.submit(oTask);
        }
    }

    public <T> Future<T> submit4Sys(Callable<T> oTask) {
        if (null == this.threadPool4Bu && null == this.threadPool4Sys) {
            init(configThreadPoolVo.getBuCorePoolSize(),
                    configThreadPoolVo.getBuMaxPoolSize(),
                    configThreadPoolVo.getBuKeepAliveSecond(),
                    configThreadPoolVo.getBuQueueSize(),
                    configThreadPoolVo.getSysCorePoolSize(),
                    configThreadPoolVo.getSysMaxPoolSize(),
                    configThreadPoolVo.getSysKeepAliveSecond(),
                    configThreadPoolVo.getSysQueueSize());
        }

        if (null != this.threadPool4Sys) {
            Future<T> oFuture = this.threadPool4Sys.submit(oTask);
            return oFuture;
        }
        return null;
    }

    //#endregion
}
