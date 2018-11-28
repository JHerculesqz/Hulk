package com.firelord.opencv.video;

import com.firelord.opencv.matrix.VisionMatrix;
import org.opencv.videoio.VideoCapture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VisionVideo4PC {
    //#region Fields

    private VideoCapture videoCapture = new VideoCapture();

    private boolean videoOpen;

    private ScheduledExecutorService timer;

    //#endregion

    //#region toggle

    public void toggole(VisionVideo4PCCallback oCallback) {
        //open
        if (!this.videoOpen) {
            this.videoCapture.open(0);
            //if open success
            if (this.videoCapture.isOpened()) {
                this.videoOpen = true;

                //callback whenOpenSuccess
                oCallback.whenOpenSuccess();

                //timer
                this.timer = Executors.newSingleThreadScheduledExecutor();
                this.timer.scheduleAtFixedRate(() -> {
                            //callback whenGrabImgFrame
                            oCallback.whenGrabImgFrame();
                        },
                        0, 33, TimeUnit.MILLISECONDS);
            }
            //if open fail
            else {
                System.out.println("open camera fail...");
            }
        }
        //close
        else {
            this.videoOpen = false;

            //destroy
            this.destroy();

            //callback whenOpenFail
            oCallback.whenOpenFail();
        }
    }

    //#endregion

    //#region destroy

    public void destroy() {
        //destroy timer
        if (this.timer != null && !this.timer.isShutdown()) {
            try {
                this.timer.shutdown();
                this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        //destroy videoCapture
        if (this.videoCapture.isOpened()) {
            this.videoCapture.release();
        }
    }

    //#endregion

    //#region grabImgFrame

    public VisionMatrix grabImgFrame() {
        VisionMatrix oSrc = new VisionMatrix();
        this.videoCapture.read(oSrc.getMat());
        return oSrc;
    }

    //#endregion
}
