package com.firelord.component.http.provider.rest_template.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@ConfigurationProperties(prefix = "msCommon.sendMsg")
@Component
@ToString
public class ConfigRestTemplateVo {
	// #region Fields

	// #region Sys

	@Setter
	@Getter
	private int httpRestTimeout4ReqSys;

	@Setter
	@Getter
	private int httpRestTimeout4ConSys;

	@Setter
	@Getter
	private int httpRestTimeout4ReadSys;

	// #endregion

	// #region Bu

	@Setter
	@Getter
	private int httpRestTimeout4ReqBu;

	@Setter
	@Getter
	private int httpRestTimeout4ConBu;

	@Setter
	@Getter
	private int httpRestTimeout4ReadBu;

	// #endregion

	// #endregion
}
