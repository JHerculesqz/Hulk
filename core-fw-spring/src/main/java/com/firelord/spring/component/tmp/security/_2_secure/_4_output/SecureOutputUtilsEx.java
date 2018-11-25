package com.firelord.spring.component.tmp.security._2_secure._4_output;


import com.firelord.spring.component.tmp.security._2_secure._4_output._1_validator.SecureOutputValidatorProvider;
import com.firelord.spring.component.tmp.security._2_secure._4_output._2_refmap.SecureInputRefMapProvider;

public class SecureOutputUtilsEx {
    // #region Construction

    public static SecureOutputUtilsEx getInstance() {
        return new SecureOutputUtilsEx();
    }

    // #endregion

    // #region getValidatorProvider

    public SecureOutputValidatorProvider getValidatorProvider() {
        return new SecureOutputValidatorProvider();
    }

    // #endregion

    // #region getRefMapProvider

    public SecureInputRefMapProvider getRefMapProvider() {
        return new SecureInputRefMapProvider();
    }

    // #endregion
}
