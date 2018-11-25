package com.firelord.security.dao.tblright;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TBLRight
 */
@Document(collection = "tblRight")
public class TBLRight {
    //#region Fields

    /**
     * id
     */
    @Id
    @Setter
    @Getter
    private String id;

    /**
     * url
     */
    @Setter
    @Getter
    private String url;

    /**
     * role name
     */
    @Setter
    @Getter
    private String roleName;

    //#endregion
}
