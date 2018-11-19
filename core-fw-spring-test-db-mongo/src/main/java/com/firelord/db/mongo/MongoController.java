package com.firelord.db.mongo;

import com.firelord.db.mongo.dao.CellMo;
import com.firelord.db.mongo.dao.TBLBook;
import com.firelord.db.mongo.dao.TBLBookRepository;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/db/mongo")
public class MongoController {
    //#region Fields

    @Resource
    private TBLBookRepository tblBookRepository;

    //#endregion

    //#region test

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        this.tblBookRepository.deleteAll();

        //save
        TBLBook oTBLBook1 = new TBLBook();
        oTBLBook1.setName("name1");
        oTBLBook1.setType("type1");
        CellMo oCellMo = new CellMo();
        oCellMo.setKey("key1");
        oCellMo.setValue("value1");
        oTBLBook1.getCellMos().add(oCellMo);
        this.tblBookRepository.saveEx(oTBLBook1);

        //saveAll
        List<TBLBook> lstTBLBook = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TBLBook oTBLBookTmp = new TBLBook();
            oTBLBookTmp.setName("SaveAll" + i);
            oTBLBookTmp.setType("SaveAllType" + i);
            CellMo oCellMo2 = new CellMo();
            oCellMo2.setKey("key1");
            oCellMo2.setValue("value1");
            oTBLBookTmp.getCellMos().add(oCellMo2);
            lstTBLBook.add(oTBLBookTmp);
        }
        this.tblBookRepository.saveAll(lstTBLBook);

        //updateEx
        oTBLBook1.setType("type'");
        this.tblBookRepository.updateEx(oTBLBook1);

        //deleteByName
        this.tblBookRepository.deleteByName(oTBLBook1.getName());

        //findOneEx
        TBLBook oTBLBook2 = this.tblBookRepository.findOneEx();

        //findAll
        List<TBLBook> lstTBLBook2 = this.tblBookRepository.findAllEx();

        //findByName
        List<TBLBook> lstTBLBook3 = this.tblBookRepository.findByName("SaveAll1",
                10, 0);

        //findByNameEx
        DBObject oTBLBook3 = this.tblBookRepository.findByNameEx("SaveAll1");

        //findByNameEx2
        DBCursor oDBCursor = this.tblBookRepository.findByNameEx2("SaveAll1");
        List<DBObject> lstTBLBook4 = oDBCursor.toArray();
    }

    //#endregion
}
