package com.firelord.security.dao.tbluser;

import com.firelord.security.dao.tblrole.TBLRole;
import com.firelord.security.dao.tblrole.TBLRoleRepository;
import com.firelord.security.dao.tbluser.mo.SignUpOutMo;
import com.firelord.security.dao.tbluser.mo.UserMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

/**
 * TBLUserRepository
 */
public class TBLUserRepositoryImpl implements TBLUserRepositoryEx {
    //#region Fields

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TBLRoleRepository tblRoleRepository;

    //#endregion

    //#region init

    @Override
    public void init(UserMo oUserMo) {
        //clear
        Query oQuery = new Query(new Criteria("email").is(oUserMo.getEmail()));
        TBLUser oOld = this.mongoTemplate.findOne(oQuery, TBLUser.class);
        if (null != oOld) {
            this.mongoTemplate.remove(oOld);
        }
        //insert
        TBLUser oNew = new TBLUser();
        oNew.setEmail(oUserMo.getEmail());
        oNew.setPassword(bCryptPasswordEncoder.encode(oUserMo.getPassword()));
        oNew.setFullname(oUserMo.getEmail());
        TBLRole oTBLRole = this.tblRoleRepository.findByRole(oUserMo.getRoleName());
        oNew.setTBLRoles(new HashSet<>(Arrays.asList(oTBLRole)));
        this.mongoTemplate.save(oNew);
    }

    //#endregion

    //#region signUp

    @Override
    public SignUpOutMo signUp(UserMo oUserMo) {
        SignUpOutMo oOutMo = new SignUpOutMo();

        //role
        TBLRole oTBLRole = this.tblRoleRepository.findByRole(oUserMo.getRoleName());
        if (null == oTBLRole) {
            oOutMo.setOk(false);
            oOutMo.setRetMsg("role name is not exists");
            return oOutMo;
        }

        //user
        Query oQuery = new Query(new Criteria("email").is(oUserMo.getEmail()));
        TBLUser oOld = this.mongoTemplate.findOne(oQuery, TBLUser.class);
        if (null != oOld) {
            oOutMo.setOk(false);
            oOutMo.setRetMsg("user exists");
            return oOutMo;
        }
        TBLUser oTBLUser = new TBLUser();
        oTBLUser.setEmail(oUserMo.getEmail());
        oTBLUser.setPassword(bCryptPasswordEncoder.encode(oUserMo.getPassword()));
        oTBLUser.setFullname(oUserMo.getEmail());
        oTBLUser.setTBLRoles(new HashSet<>(Arrays.asList(oTBLRole)));
        this.mongoTemplate.save(oTBLUser);

        return oOutMo;
    }

    //#endregion

    //#region findByUserIdentify

    @Override
    public TBLUser findByUserIdentify(String strUserIdentify) {
        Query oQuery = new Query(new Criteria("email").is(strUserIdentify));
        TBLUser oOld = this.mongoTemplate.findOne(oQuery, TBLUser.class);
        return oOld;
    }

    //#endregion
}
