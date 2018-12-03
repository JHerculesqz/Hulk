package com.firelord.opencv.test;

import com.firelord.opencv.VisionTools;
import com.firelord.opencv.matrix.VisionMatrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/opencv")
public class OpenCVController {
    //#region Fields

    //#endregion

    //#region test

    @RequestMapping("/contoursCalc")
    @ResponseBody
    public void contoursCalc() {
        VisionMatrix oSrc = new VisionMatrix("C:/test/contoursCalc.bmp");
        VisionMatrix oDst = VisionTools.imgBasicFeature.contoursCalc(oSrc);
    }

    //#endregion
}
