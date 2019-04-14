package com.firelord.spring.component.mvc.filter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HulkFilter
 */
public class HulkFilter {
    //#region Fields

    @Getter
    private List<String> excludeUrlLst = new ArrayList<>();

    @Getter
    private List<String> excludeFileLst = Arrays.asList(".css", ".html", ".js",
            ".jpg", ".svg", ".png", ".ico",
            ".ttf", ".woff");

    //#endregion
}
