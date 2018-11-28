package com.firelord.opencv.image_basic_feature.mo;

import com.firelord.opencv.mo.VisionRect;
import com.firelord.opencv.mo.VisionRotateRect;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.imgproc.Imgproc;

@ToString
@Builder
public class VisionMatOfP {
    //#region Fields

    @Setter
    @Getter
    private MatOfPoint matOfPoint;

    //#endregion

    //#region rectOuter

    public VisionRect rectOuter() {
        Rect oRect = Imgproc.boundingRect(this.matOfPoint);
        VisionRect oVisionRect = VisionRect.builder()
                .rect(oRect)
                .build();
        return oVisionRect;
    }

    //#endregion

    //#region rectInner

    public VisionRotateRect rectInner() {
        RotatedRect oRotatedRect = Imgproc.minAreaRect(new MatOfPoint2f(this.matOfPoint.toArray()));
        VisionRotateRect oVisionRotateRect = VisionRotateRect.builder()
                .rect(oRotatedRect)
                .build();
        return oVisionRotateRect;
    }

    //#endregion

    //#region area

    public double area() {
        double iArea = Imgproc.contourArea(this.matOfPoint, false);
        return iArea;
    }

    //#endregion

    //#region arcLength

    public double arcLength() {
        double iLength = Imgproc.arcLength(new MatOfPoint2f(this.matOfPoint.toArray()), true);
        return iLength;
    }

    //#endregion
}
