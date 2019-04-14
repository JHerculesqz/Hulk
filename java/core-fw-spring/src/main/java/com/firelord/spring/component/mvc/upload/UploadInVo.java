package com.firelord.spring.component.mvc.upload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * UploadInVol
 */
@ToString
public class UploadInVo {
    //#region Fields

    @Setter
    @Getter
    private String fileName;

    @Setter
    @Getter
    private MultipartFile file;

    //#endregion
}
