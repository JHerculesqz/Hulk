package com.firelord.security;

import com.firelord.security.dao.tblright.TBLRight;
import com.firelord.security.dao.tblright.TBLRightRepository;
import com.firelord.security.dao.tblright.mo.HeaderOutMo;
import com.firelord.security.dao.tblright.mo.RightMo;
import com.firelord.security.dao.tblrole.TBLRole;
import com.firelord.security.dao.tblrole.TBLRoleRepository;
import com.firelord.security.dao.tbluser.TBLUser;
import com.firelord.security.dao.tbluser.TBLUserRepository;
import com.firelord.security.dao.tbluser.mo.SignUpOutMo;
import com.firelord.security.dao.tbluser.mo.UserMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SecurityService
 */
@Service
public class SecurityService implements UserDetailsService {
    //#region Fields

    @Autowired
    private TBLRightRepository tblRightRepository;

    @Autowired
    private TBLRoleRepository tblRoleRepository;

    @Autowired
    private TBLUserRepository userRepository;

    //#endregion

    //#region init

    /**
     * SecurityAdapter invoke when init
     *
     * @param lstRightMo  RightMo collections
     * @param lstRoleName RoleName collections
     * @param oUserMo     UserMo
     */
    public void init(List<RightMo> lstRightMo, List<String> lstRoleName, UserMo oUserMo) {
        //right
        this.tblRightRepository.init(lstRightMo);
        //role
        this.tblRoleRepository.init(lstRoleName);
        //admin
        this.userRepository.init(oUserMo);
    }

    //#endregion

    //#region config

    /**
     * SecurityAdapter invoke when configuration
     *
     * @param handler HttpSecurity handler
     */
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry handler) {
        List<TBLRight> lstTBLRight = this.tblRightRepository.findAll();
        for (TBLRight oTBLRight : lstTBLRight) {
            handler.antMatchers(oTBLRight.getUrl()).hasAuthority(oTBLRight.getRoleName());
        }
    }

    //#endregion

    //#region signUp

    /**
     * signUp
     *
     * @param oUserMo UserMo
     * @return signUp result
     */
    public SignUpOutMo signUp(UserMo oUserMo) {
        SignUpOutMo oOutMo = this.userRepository.signUp(oUserMo);
        return oOutMo;
    }

    //#endregion

    //#region loadUserByUsername

    /**
     * Spring security callback when visit page
     *
     * @param strUserIdentify TBLUser Identify
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String strUserIdentify) throws UsernameNotFoundException {
        TBLUser oTBLUser = this.userRepository.findByUserIdentify(strUserIdentify);
        if (oTBLUser != null) {
            List<GrantedAuthority> lstGrantedAuthority = this.getUserAuthority(oTBLUser.getTBLRoles());
            return this.buildUserForAuthentication(oTBLUser, lstGrantedAuthority);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<TBLRole> lstTBLRole) {
        Set<GrantedAuthority> setGrantedAuthority = new HashSet<>();
        lstTBLRole.forEach((oRole) -> {
            setGrantedAuthority.add(new SimpleGrantedAuthority(oRole.getRole()));
        });

        List<GrantedAuthority> lstGrantedAuthority = new ArrayList<>(setGrantedAuthority);
        return lstGrantedAuthority;
    }

    private UserDetails buildUserForAuthentication(TBLUser oTBLUser,
                                                   List<GrantedAuthority> lstGrantedAuthority) {
        return new org.springframework.security.core.userdetails.User(oTBLUser.getEmail(),
                oTBLUser.getPassword(), lstGrantedAuthority);
    }

    //#endregion

    //#region update4Head

    /**
     * for show  menu on header page
     *
     * @param oModelAndView header page
     */
    public void update4Head(ModelAndView oModelAndView) {
        HeaderOutMo oHeaderOutMo = this.tblRightRepository.get4Header();
        oModelAndView.addObject("userIdentify", oHeaderOutMo.getUserIdentify());
        oModelAndView.addObject("lstUrl", oHeaderOutMo.getLstUrl());
    }

    //#endregion
}
