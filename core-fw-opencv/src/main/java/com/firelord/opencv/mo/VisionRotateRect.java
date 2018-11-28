package com.firelord.opencv.mo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opencv.core.RotatedRect;

@ToString
@Builder
public class VisionRotateRect {
    //#region Fields

    @Setter
    @Getter
    private RotatedRect rect;

    public double getWidth() {
        return this.rect.size.width;
    }

    public double getHeight() {
        return this.rect.size.height;
    }

    public double getCenterX() {
        return this.rect.center.x;
    }

    public double getCenterY() {
        return this.rect.center.y;
    }

    //#endregion
}
