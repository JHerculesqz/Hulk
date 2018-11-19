package com.firelord.component.security.dao.tblright;

import com.firelord.component.security.dao.tblright.mo.HeaderOutMo;
import com.firelord.component.security.dao.tblright.mo.RightMo;

import java.util.List;

/**
 * TBLRightRepository
 */
public interface TBLRightRepositoryEx {
    /**
     * init TBLRight collection
     *
     * @param lstRightMo RightMo collection
     */
    void init(List<RightMo> lstRightMo);

    /**
     * for page header
     *
     * @return HeaderOutMo
     */
    HeaderOutMo get4Header();
}
