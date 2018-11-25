package com.firelord.security.dao.tbluser;

import com.firelord.security.dao.tblrole.TBLRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * TBLUser
 */
@Document(collection = "tblUser")
public class TBLUser {
    //#region Fields

    /**
     * id
     */
    @Id
    @Setter
    @Getter
    private String id;

    /**
     * email
     */
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    @Setter
    @Getter
    private String email;

    /**
     * password
     */
    @Setter
    @Getter
    private String password;

    /**
     * fullName
     */
    @Setter
    @Getter
    private String fullname;

    /**
     * TBLRole collection
     */
    @DBRef
    @Setter
    @Getter
    private Set<TBLRole> TBLRoles;

    //#endregion
}
