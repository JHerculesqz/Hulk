package com.firelord.component.upload;

import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

public class UploadUtilsEx {
    //#region getInVo

    public static UploadInVo getInVo(StandardMultipartHttpServletRequest oReqVo){
        UploadInVo oInVo = new UploadInVo();

        oInVo.setFileName(oReqVo.getParameter("name"));
        oInVo.setFile(oReqVo.getFile("file"));

        return oInVo;
    }

    //#endregion
}
