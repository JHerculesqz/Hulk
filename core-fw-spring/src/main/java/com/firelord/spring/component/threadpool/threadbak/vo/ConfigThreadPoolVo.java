package com.firelord.spring.component.threadpool.threadbak.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * ConfigThreadPoolVo
 */
//@ConfigurationProperties(prefix = "msCommon.threadpool")
@Deprecated
@Component
@ToString
public class ConfigThreadPoolVo {
    //#region Fields

    @Setter
    @Getter
    private int buCorePoolSize;

    @Setter
    @Getter
    private int buMaxPoolSize;

    @Setter
    @Getter
    private long buKeepAliveSecond;

    @Setter
    @Getter
    private int buQueueSize;

    @Setter
    @Getter
    private int sysCorePoolSize;

    @Setter
    @Getter
    private int sysMaxPoolSize;

    @Setter
    @Getter
    private long sysKeepAliveSecond;

    @Setter
    @Getter
    private int sysQueueSize;

    //#endregion
}
