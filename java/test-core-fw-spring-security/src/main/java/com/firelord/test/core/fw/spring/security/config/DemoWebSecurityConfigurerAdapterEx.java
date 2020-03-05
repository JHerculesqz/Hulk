package com.firelord.test.core.fw.spring.security.config;

import com.firelord.security.app.init.SecurityService;
import com.firelord.security.app.init.SecurityServiceCallback;
import com.firelord.security.core.config.WebSecurityConfigurerAdapterEx;
import com.firelord.security.repo.dao.tblresource.TBLResource;
import com.firelord.security.repo.dao.tblrole.TBLRole;
import com.firelord.security.repo.vo.mgrdb.MgrDBMo;
import com.firelord.security.repo.vo.mgrsupport.MgrSupportMo;
import com.firelord.security.repo.vo.resource.ResourceMo;
import com.firelord.security.repo.vo.role.RoleMo;
import com.firelord.security.repo.vo.user.UserMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
@EnableWebSecurity
public class DemoWebSecurityConfigurerAdapterEx extends WebSecurityConfigurerAdapterEx {
    //#region Fields

    @Autowired
    private SecurityService securityService;

    //#endregion

    //#region init

    @PostConstruct
    public void init() {
        this.securityService.init(new SecurityServiceCallback() {
            @Override
            public List<ResourceMo> genResourceMoLst4Init() {
                List<ResourceMo> lstRes = new ArrayList<>();

                lstRes.add(ResourceMo.builder().resourceId("home").
                        resourceUrl("/").roleType(TBLRole.ROLE_ANONYMOUS).
                        resourceType(TBLResource.TYPE_MENU).build());
                lstRes.add(ResourceMo.builder().resourceId("page1").
                        resourceUrl("/page1").
                        resourceType(TBLResource.TYPE_MENU).build());

                return lstRes;
            }

            @Override
            public List<RoleMo> genRoleMoLst4Init() {
                List<RoleMo> lstRes = new ArrayList<>();

                lstRes.add(RoleMo.builder().roleName(TBLRole.ROLE_ADMIN).
                        roleAlias(TBLRole.ROLE_ADMIN).build());

                lstRes.add(RoleMo.builder().roleName(TBLRole.ROLE_ANONYMOUS).
                        roleAlias(TBLRole.ROLE_ANONYMOUS).build());

                lstRes.add(RoleMo.builder().roleName(TBLRole.ROLE_NORMAL).
                        roleAlias(TBLRole.ROLE_NORMAL).
                        resourceIdLst(Arrays.asList("page1")).build());

                return lstRes;
            }

            @Override
            public List<UserMo> genUserMoLst4Init() {
                List<UserMo> lstRes = new ArrayList<>();

                lstRes.add(UserMo.builder().name("admin").phone("13554302913").
                        email("admin@mail.com").password("admin").roleName(TBLRole.ROLE_ADMIN).build());

                return lstRes;
            }

            @Override
            public MgrDBMo genMgrDB4Init() {
                Map<String, String> mapTables = new HashMap<>();
                MgrDBMo oMgrDBMo = MgrDBMo.builder().totalCount(50000)
                        .tables(mapTables).build();
                return oMgrDBMo;
            }

            @Override
            public List<MgrSupportMo> getMgrSupportLst4Init() {
                List<MgrSupportMo> lstMgrSupportMo = new ArrayList<>();
                lstMgrSupportMo.add(MgrSupportMo.builder()
                        .name("logs")
                        .dirPath("/opt/oss/xxx").build());
                return lstMgrSupportMo;
            }
        });
    }

    //#endregion
}
