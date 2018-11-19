package com.firelord.component.security.dao.tbluser;

import com.firelord.component.security.dao.tbluser.mo.SignUpOutMo;
import com.firelord.component.security.dao.tbluser.mo.UserMo;

/**
 * TBLUserRepository
 */
public interface TBLUserRepositoryEx {
    /**
     * init administrator
     *
     * @param oUserMo UserMo
     */
    void init(UserMo oUserMo);

    /**
     * sign up
     *
     * @param oUserMo UserMo
     * @return SignUpOutMo
     */
    SignUpOutMo signUp(UserMo oUserMo);

    /**
     * find user by user identify
     *
     * @param strUserIdentify user identify
     * @return TBLUser
     */
    TBLUser findByUserIdentify(String strUserIdentify);
}
