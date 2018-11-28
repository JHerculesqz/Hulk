package com.firelord.opencv.mo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opencv.core.Rect;

@ToString
@Builder
public class VisionRect {
    //#region Fields

    @Setter
    @Getter
    private Rect rect;

    public int getWidth() {
        return this.rect.width;
    }

    public int getHeight() {
        return this.rect.height;
    }

    public int getX() {
        return this.rect.x;
    }

    public int getY() {
        return this.rect.y;
    }

    //#endregion
}
