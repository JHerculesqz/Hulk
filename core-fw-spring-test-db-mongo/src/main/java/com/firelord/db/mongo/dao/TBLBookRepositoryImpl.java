package com.firelord.db.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class TBLBookRepositoryImpl implements TBLBookRepositoryEx {
    //#region Fields

    @Autowired
    private MongoTemplate mongoTemplate;

    //#endregion

    //#region saveEx

    @Override
    public void saveEx(TBLBook oTBLBook) {
        this.mongoTemplate.save(oTBLBook);
    }

    //#endregion

    //#region saveAll

    @Override
    public void saveAll(List<TBLBook> lstTBLBook) {
        this.mongoTemplate.insertAll(lstTBLBook);
    }

    //#endregion

    //#region updateEx

    @Override
    public void updateEx(TBLBook oTBLBookNew) {
        Query oQuery = new Query(Criteria.where("name").is(oTBLBookNew.getName()));
        Update oUpdate = new Update();
        oUpdate.set("type", oTBLBookNew.getType());
        this.mongoTemplate.updateMulti(oQuery, oUpdate, TBLBook.class);
    }

    //#endregion

    //#region deleteByName

    @Override
    public void deleteByName(String strName) {
        Query oQuery = new Query(Criteria.where("name").is(strName));
        this.mongoTemplate.remove(oQuery, TBLBook.class);
    }

    //#endregion

    //#region findOneEx

    @Override
    public TBLBook findOneEx() {
        Query oQuery = new Query();

        TBLBook oTBLBook = this.mongoTemplate.findOne(oQuery, TBLBook.class);
        return oTBLBook;
    }

    //#endregion

    //#region findAllEx

    @Override
    public List<TBLBook> findAllEx() {
        List<TBLBook> lstTBLBook = this.mongoTemplate.findAll(TBLBook.class);
        return lstTBLBook;
    }

    //#endregion

    //#region findByName

    @Override
    public List<TBLBook> findByName(String strName, int iLimit, int iSkip) {
        Query oQuery = new Query(Criteria.where("name").is(strName)).limit(iLimit).skip(iSkip);
        List<TBLBook> lstTBLBook = this.mongoTemplate.find(oQuery, TBLBook.class);
        return lstTBLBook;
    }

    //#endregion

    //#region findByNameEx

    @Override
    public DBObject findByNameEx(String strName) {
        DBCollection oTBL = this.mongoTemplate.getMongoDbFactory().getLegacyDb().
                getCollection("tblBook");

        BasicDBObject oQuery = new BasicDBObject();
        oQuery.put("name", strName);
        DBObject oDBObject = oTBL.findOne(oQuery);

        return oDBObject;
    }

    //#endregion

    //#region findByNameEx2

    @Override
    public DBCursor findByNameEx2(String strName) {
        DBCollection oTBL = this.mongoTemplate.getMongoDbFactory().getLegacyDb().
                getCollection("tblBook");

        BasicDBObject oQuery = new BasicDBObject();
        oQuery.put("name", strName);
        DBCursor oDBCursor = oTBL.find(oQuery);

        return oDBCursor;
    }

    //#endregion
}
