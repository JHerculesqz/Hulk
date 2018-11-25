package com.firelord.security.dao.tblrole;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TBLRoleRepository
 */
public interface TBLRoleRepository extends MongoRepository<TBLRole, String>, TBLRoleRepositoryEx {
    /**
     * find TBLRole by role name
     *
     * @param strRoleName role name
     * @return TBLRole
     */
    TBLRole findByRole(String strRoleName);
}
