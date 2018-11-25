package com.firelord.security.dao.tblrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * TBLRoleRepository
 */
public class TBLRoleRepositoryImpl implements TBLRoleRepositoryEx {
    //#region Fields

    @Autowired
    private MongoTemplate mongoTemplate;

    //#endregion

    //#region init

    @Override
    public void init(List<String> lstRoleName) {
        //insert
        for (String strRoleName : lstRoleName) {
            Query oQuery = new Query(new Criteria("role").is(strRoleName));
            TBLRole oOld = this.mongoTemplate.findOne(oQuery, TBLRole.class);
            if (null == oOld) {
                TBLRole oNewEx = new TBLRole();
                oNewEx.setRole(strRoleName);
                this.mongoTemplate.save(oNewEx);
            }
        }
    }

    //#endregion
}
