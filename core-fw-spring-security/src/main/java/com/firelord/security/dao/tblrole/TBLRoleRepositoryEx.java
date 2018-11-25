package com.firelord.security.dao.tblrole;

import java.util.List;

/**
 * TBLRoleRepository
 */
public interface TBLRoleRepositoryEx {
    /**
     * init TBLRole collection
     *
     * @param lstRoleName role name collection
     */
    void init(List<String> lstRoleName);
}
