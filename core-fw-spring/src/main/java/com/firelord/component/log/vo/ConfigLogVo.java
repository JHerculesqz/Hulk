package com.firelord.component.log.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "msCommon.log")
@EnableAutoConfiguration
@Component
@ToString
public class ConfigLogVo {
	// #region Fields

	@Setter
	@Getter
	private String dirPathRoot;

	// #endregion
}
