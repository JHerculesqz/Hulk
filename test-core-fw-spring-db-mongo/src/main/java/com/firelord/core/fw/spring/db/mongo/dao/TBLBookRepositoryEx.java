package com.firelord.core.fw.spring.db.mongo.dao;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.List;

public interface TBLBookRepositoryEx {
    void saveEx(TBLBook oTBLBook);

    void saveAll(List<TBLBook> lstTBLBook);

    void updateEx(TBLBook oTBLBookNew);

    void deleteByName(String strName);

    TBLBook findOneEx();

    List<TBLBook> findAllEx();

    List<TBLBook> findByName(String strName, int iLimit, int iSkip);

    DBObject findByNameEx(String strName);

    DBCursor findByNameEx2(String strName);
}
