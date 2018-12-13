package com.firelord.spring.component.mvc.upload;

import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

/**
 * UploadUtilsEx
 */
public class UploadUtilsEx {
    //#region getInVo

    /**
     * get UploadInVo
     * config in application.properties
     * spring.servlet.multipart.enabled=true
     * spring.servlet.multipart.file-size-threshold=0
     * spring.servlet.multipart.location=c:/tmp
     * spring.servlet.multipart.max-file-size=1MB
     * spring.servlet.multipart.max-request-size=10MB
     * spring.servlet.multipart.resolve-lazily=false
     *
     * @param oReqVo StandardMultipartHttpServletRequest
     * @return UploadInVo
     */
    public static UploadInVo getInVo(StandardMultipartHttpServletRequest oReqVo) {
        UploadInVo oInVo = new UploadInVo();

        oInVo.setFileName(oReqVo.getParameter("name"));
        oInVo.setFile(oReqVo.getFile("file"));

        return oInVo;
    }

    //#endregion

    //#region getInVoEx

    /**
     * get UploadInVoEx
     * config in application.properties
     * spring.servlet.multipart.enabled=true
     * spring.servlet.multipart.file-size-threshold=0
     * spring.servlet.multipart.location=c:/tmp
     * spring.servlet.multipart.max-file-size=1MB
     * spring.servlet.multipart.max-request-size=10MB
     * spring.servlet.multipart.resolve-lazily=false
     *
     * @param oReqVo StandardMultipartHttpServletRequest
     * @return UploadInVoEx
     */
    public static UploadInVoEx getInVoEx(StandardMultipartHttpServletRequest oReqVo) {
        UploadInVoEx oInVo = new UploadInVoEx();

        oInVo.setFileMap(oReqVo.getFileMap());

        return oInVo;
    }

    //#endregion
}
