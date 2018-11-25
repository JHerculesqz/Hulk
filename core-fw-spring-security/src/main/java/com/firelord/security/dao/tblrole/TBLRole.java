package com.firelord.security.dao.tblrole;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TBLRole
 */
@Document(collection = "tblRole")
public class TBLRole {
    //#region Fields

    /**
     * id
     */
    @Id
    @Setter
    @Getter
    private String id;

    /**
     * role name
     */
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    @Setter
    @Getter
    private String role;

    //#endregion
}
