package com.firelord.opencv.image_basic_feature;

import com.firelord.opencv.image_basic_feature.mo.VisionMatOfP;
import com.firelord.opencv.image_basic_feature.mo.VisionMatOfPSet;
import com.firelord.opencv.matrix.VisionMatrix;
import com.firelord.opencv.mo.VisionRect;
import com.firelord.opencv.mo.VisionRotateRect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 * Basic image feature
 */
public class ImgBasicFeature {
    //#region contoursCalc

    /**
     * measure contours
     *
     * @param oSrc src matrix
     * @return dst matrix
     */
    public VisionMatrix contoursCalc(VisionMatrix oSrc) {
        VisionMatrix oDst = new VisionMatrix(oSrc);

        //generate oGray and oBinary
        VisionMatrix oGray = new VisionMatrix();
        VisionMatrix oBinary = new VisionMatrix();

        //threshold
        oSrc.threshold(oGray, oBinary);

        //find contours
        VisionMatOfPSet oVisionMatOfPSet = this.contoursQuery(oBinary);

        //measure contours
        for (int iIndex = 0; iIndex < oVisionMatOfPSet.getVisionMatOfPList().size(); iIndex++) {
            VisionMatOfP oVisionMatOfP = oVisionMatOfPSet.getVisionMatOfPList().get(iIndex);

            VisionRect oVisionRect = oVisionMatOfP.rectOuter();
            System.out.println(oVisionRect);

            VisionRotateRect oVisionRotateRect = oVisionMatOfP.rectInner();
            System.out.println(oVisionRotateRect);

            double iArea = oVisionMatOfP.area();
            System.out.println(iArea);

            double iLength = oVisionMatOfP.arcLength();
            System.out.println(iLength);

            this.contoursDraw(oDst, oVisionMatOfPSet, iIndex);
        }

        //destroy
        oGray.destroy();
        oBinary.destroy();

        return oDst;
    }

    private void contoursDraw(VisionMatrix oDst, VisionMatOfPSet VisionMatOfPSet, int iIndex) {
        Imgproc.drawContours(oDst.getMat(),
                VisionMatOfPSet.getVisionMatOfPListOrig(), iIndex,
                new Scalar(0, 0, 255), 1);
    }

    //#endregion

    //#region contoursQuery

    public VisionMatOfPSet contoursQuery(VisionMatrix oBinary) {
        VisionMatOfPSet oVisionMatOfPSet = new VisionMatOfPSet(oBinary);
        return oVisionMatOfPSet;
    }

    //#endregion
}
