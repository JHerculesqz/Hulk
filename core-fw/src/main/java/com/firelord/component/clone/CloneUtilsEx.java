package com.firelord.component.clone;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

public class CloneUtilsEx {
	// #region deepClone

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T deepClone(T oObj) {
		T oRes = (T) SerializationUtils.clone(oObj);
		return oRes;
	}

	// #endregin
}
