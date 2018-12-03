package com.firelord.opencv.image_basic_feature.mo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opencv.core.MatOfPoint;

import java.util.ArrayList;
import java.util.List;

@ToString
public class VisionMatOfPSet {
    //#region Fields

    @Setter
    @Getter
    private List<VisionMatOfP> visionMatOfPList = new ArrayList<>();

    //#endregion

    //#region Construction

    public VisionMatOfPSet(List<MatOfPoint> lstMatOfPoint) {
        for (MatOfPoint oMatOfPoint : lstMatOfPoint) {
            VisionMatOfP oVisionMatOfP = VisionMatOfP.builder()
                    .matOfPoint(oMatOfPoint)
                    .build();
            this.getVisionMatOfPList().add(oVisionMatOfP);
        }
    }

    //#endregion

    //#region getVisionMatOfPListOrig

    public List<MatOfPoint> getVisionMatOfPListOrig() {
        List<MatOfPoint> lstRes = new ArrayList<>();

        for (VisionMatOfP oVisionMatOfP : this.getVisionMatOfPList()) {
            lstRes.add(oVisionMatOfP.getMatOfPoint());
        }

        return lstRes;
    }

    //#endregion
}
