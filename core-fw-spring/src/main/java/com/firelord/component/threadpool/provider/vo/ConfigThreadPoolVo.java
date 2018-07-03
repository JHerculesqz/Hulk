package com.firelord.component.threadpool.provider.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@ConfigurationProperties(prefix = "msCommon.threadpool")
@Component
@ToString
public class ConfigThreadPoolVo {
	// #region Fields

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

	// #endregion
}
