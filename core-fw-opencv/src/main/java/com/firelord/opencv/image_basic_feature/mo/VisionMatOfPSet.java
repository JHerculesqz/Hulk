package com.firelord.opencv.image_basic_feature.mo;

import com.firelord.opencv.matrix.VisionMatrix;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

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

    public VisionMatOfPSet(VisionMatrix oBinary) {
        VisionMatrix oHierarchy = new VisionMatrix();
        List<MatOfPoint> lstMatOfPoint = new ArrayList<>();
        Imgproc.findContours(oBinary.getMat(), lstMatOfPoint, oHierarchy.getMat(),
                Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));
        for (MatOfPoint oMatOfPoint : lstMatOfPoint) {
            VisionMatOfP oVisionMatOfP = VisionMatOfP.builder()
                    .matOfPoint(oMatOfPoint)
                    .build();
            this.visionMatOfPList.add(oVisionMatOfP);
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
