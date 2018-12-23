package com.firelord.test.core.fw.spring.db.es;

import com.firelord.test.core.fw.spring.db.es.dao.CellMo;
import com.firelord.test.core.fw.spring.db.es.dao.TBLBook;
import com.firelord.test.core.fw.spring.db.es.dao.TBLBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/db/es")
public class ESController {
    //#region Fields

    @Resource
    private TBLBookRepository tblBookRepository;

    //#endregion

    //#region test

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        this.tblBookRepository.deleteAll();

        TBLBook oTBLBook1 = new TBLBook();
        oTBLBook1.setName("name1");
        oTBLBook1.setType("type1");
        CellMo oCellMo = new CellMo();
        oCellMo.setKey("key1");
        oCellMo.setValue("value1");
        oTBLBook1.getCellMos().add(oCellMo);
        oTBLBook1 = this.tblBookRepository.save(oTBLBook1);
        Optional<TBLBook> oTBLBook2 = this.tblBookRepository.findById(oTBLBook1.getId());

        oTBLBook2.get().setName("name2");
        this.tblBookRepository.save(oTBLBook2.get());
        Optional<TBLBook> oTBLBook3 = this.tblBookRepository.findById(oTBLBook2.get().getId());

        TBLBook oTBLBook11 = new TBLBook();
        oTBLBook11.setName("name2");
        oTBLBook11.setType("type11");
        this.tblBookRepository.save(oTBLBook11);

        List<TBLBook> lstTBLBook1 = this.tblBookRepository.findByNameAndType("name1", "type1");
        List<TBLBook> lstTBLBook2 = this.tblBookRepository.findByNameAndType("name2", "type1");

        List<TBLBook> lstTBLBook3 = this.tblBookRepository.findByNameStartingWith("name2");
    }

    //#endregion
}
