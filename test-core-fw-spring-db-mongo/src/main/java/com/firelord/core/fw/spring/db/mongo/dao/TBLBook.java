package com.firelord.core.fw.spring.db.mongo.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tblBook")
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
