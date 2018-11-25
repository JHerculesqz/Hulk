package com.firelord.test.component.mvc.upload;

import com.firelord.spring.component.mvc.upload.UploadInVo;
import com.firelord.spring.component.mvc.upload.UploadUtilsEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

@Controller
@RequestMapping("/mvc/upload")
public class UploadController {
    //#region Fields

    //#endregion

    //#region test1

    /**
     * test1
     */
    @RequestMapping("/test1")
    @ResponseBody
    @SuppressWarnings("unused")
    public void test1(StandardMultipartHttpServletRequest oReqVo) {
        UploadInVo oInVo = UploadUtilsEx.getInVo(oReqVo);
    }

    //#endregion
}
