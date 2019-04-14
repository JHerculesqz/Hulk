package com.firelord.spring.component.mvc.session.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * SessionMo
 */
@ToString
public class SessionMo {
    //#region Fields

    @Setter
    @Getter
    private String sessionId;

    @Setter
    @Getter
    List<SessionItemMo> sessionItemMos = new ArrayList<>();

    //#endregion
}
