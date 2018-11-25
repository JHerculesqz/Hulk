package com.firelord.spring.component.tmp.http.vo;

import com.firelord.component.json.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class ReqVo implements Serializable {
	// #region Const

	private static final long serialVersionUID = -1098700249697131407L;

	// #endregion

	// #region Fields

	@Setter
	@Getter
	private String contextClientId;

	@Setter
	@Getter
	private String contextTaskId;

	@Setter
	@Getter
	private String contextReqTime;

	@Setter
	@Getter
	private String contextReqName;

	@Setter
	@Getter
	private String reqBuVoStr;

	// #endregion

	// #region reqBuVo

	public void setReqBuVo(Object oReqBuVo) {
		// 1.将oReqBuVo序列化,获得strReqBuVo
		String strReqBuVo = JsonUtils.toStr(oReqBuVo);

		// 2.赋值
		this.reqBuVoStr = strReqBuVo;
	}

	public <T> T getReqBuVo(Class<T> oClazz) {
		// 1.根据reqBuVo和oClazz，反序列化得到oRes
		T oRes = JsonUtils.toObj(this.reqBuVoStr, oClazz);

		// 2.返回
		return oRes;
	}

	// #endregion
}