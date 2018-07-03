package com.firelord.component.security._2_secure._2_session.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SessionVo {
	// #region Fields

	@Setter
	@Getter
	private String sessionId;

	@Setter
	@Getter
	List<SessionItemVo> lstSessionItem = new ArrayList<SessionItemVo>();

	// #endregion
}
