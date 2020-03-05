package com.firelord.test.core.fw.spring.security.config;

import com.firelord.security.app.mgr.IResourceEntity;
import com.firelord.security.repo.dao.tblresourceentity.TBLResourceEntity;
import com.firelord.security.repo.dao.tblresourceentity.TBLResourceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResourceEntityConfig implements IResourceEntity {
    //#region Fields

    @Autowired
    private TBLResourceEntityRepository tblResourceEntityRepository;

    //#endregion

    //#region addResourceEntityLstBySync

    @Override
    public List<TBLResourceEntity> addResourceEntityLstBySync() {
        List<TBLResourceEntity> lstNew = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            TBLResourceEntity oNew = new TBLResourceEntity();
            oNew.setResourceEntityId("id" + i);
            oNew.setResourceEntityName("name" + i);
            lstNew.add(oNew);
        }

        return lstNew;
    }

    //#endregion
}
