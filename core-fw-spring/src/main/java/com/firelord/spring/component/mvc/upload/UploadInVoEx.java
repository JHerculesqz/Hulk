package com.firelord.spring.component.mvc.upload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * UploadInVoEx
 */
@ToString
public class UploadInVoEx {
    //#region Fields

    /**
     * fileMap
     */
    @Setter
    @Getter
    private Map<String, MultipartFile> fileMap = new HashMap<>();

    //#endregion
}
