package com.firelord.spring.component.mvc.resource;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * ResourceUtilsEx
 */
public class ResourceUtilsEx {
    //#region getFile

    /**
     * getFile
     *
     * @param strFilePathRelative relative file path
     * @return file object
     */
    public static File getFile(String strFilePathRelative) {
        File oFile = null;
        try {
            oFile = ResourceUtils.getFile(strFilePathRelative);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return oFile;
    }

    //#endregion
}
