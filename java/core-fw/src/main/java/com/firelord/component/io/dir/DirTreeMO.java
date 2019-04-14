package com.firelord.component.io.dir;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class DirTreeMO {
    //#region Fields

    @Setter
    @Getter
    private String name;

    /**
     * 文件夹：folder
     * 文件：以文件后缀的小写字母为文件类型
     */
    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private String path;

    @Setter
    @Getter
    private List<DirTreeMO> children = new ArrayList<>();

    //#endregion
}
