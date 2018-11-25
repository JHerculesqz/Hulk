package com.firelord.test.db.es.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "testdb", type = "tblBook")
public class TBLBook {
    //#region Fields

    @Id
    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private List<CellMo> cellMos = new ArrayList<>();

    //#endregion
}
