package com.firelord.test.core.fw.spring.security.config;

import com.firelord.security.config.SecurityAdapter;
import com.firelord.security.dao.tblright.mo.RightMo;
import com.firelord.security.dao.tbluser.mo.UserMo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class DemoSecurityAdapter extends SecurityAdapter {
    //#region Construction

    @PostConstruct
    public void init() {
        List<RightMo> lstRightMo = Arrays.asList(
                RightMo.builder().url("/home/**").roleName("admin").build(),
                RightMo.builder().url("/home/**").roleName("group1").build(),
                RightMo.builder().url("/page1/**").roleName("admin").build()
        );
        List<String> lstRoleName = Arrays.asList("admin", "group1");
        UserMo oUserMo = new UserMo("admin@mail.com", "admin", "admin");
        this.getSecurityService().init(lstRightMo, lstRoleName, oUserMo);
    }

    //#endregion
}
