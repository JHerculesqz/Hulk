package com.firelord.component.security.dao.tblright;

import com.firelord.component.security.dao.tblright.mo.HeaderOutMo;
import com.firelord.component.security.dao.tblright.mo.RightMo;
import com.firelord.component.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * TBLRightRepository
 */
public class TBLRightRepositoryImpl implements TBLRightRepositoryEx {
    //#region Fields

    @Autowired
    private MongoTemplate mongoTemplate;

    //#endregion

    //#region init

    @Override
    public void init(List<RightMo> lstRightMo) {
        //clear
        this.mongoTemplate.dropCollection(TBLRight.class);
        //insert
        List<TBLRight> lstTBLRight = new ArrayList<>();
        for (RightMo oRightMo : lstRightMo) {
            TBLRight oTBLRight = new TBLRight();
            oTBLRight.setRoleName(oRightMo.getRoleName());
            oTBLRight.setUrl(oRightMo.getUrl());
            lstTBLRight.add(oTBLRight);
        }
        this.mongoTemplate.insertAll(lstTBLRight);
    }

    //#endregion

    //#region get4Header

    @Override
    public HeaderOutMo get4Header() {
        HeaderOutMo oHeaderOutMo = new HeaderOutMo();

        //get oUser
        oHeaderOutMo.setUserIdentify(SecurityUtils.getCurUser());

        //get oRight
        List<String> lstRoleName = SecurityUtils.getCurUserRoleLst();
        for (String strRoleName : lstRoleName) {
            Query oQuery = new Query(new Criteria("roleName").is(strRoleName));
            List<TBLRight> lstTBLRight = this.mongoTemplate.find(oQuery, TBLRight.class);
            oHeaderOutMo.addUrlLst(lstTBLRight);
        }

        return oHeaderOutMo;
    }

    //#endregion
}
