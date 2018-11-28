package com.firelord.opencv.video;

public interface VisionVideo4PCCallback {
    void whenOpenSuccess();

    void whenGrabImgFrame();

    void whenOpenFail();
}
