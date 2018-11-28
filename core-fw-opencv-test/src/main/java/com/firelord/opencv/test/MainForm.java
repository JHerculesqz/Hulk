package com.firelord.opencv.test;

import com.firelord.javafx.JavaFXUtils;
import com.firelord.opencv.VisionTools;
import com.firelord.opencv.matrix.VisionMatrix;
import com.firelord.opencv.video.VisionVideo4PCCallback;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainForm {
    //#region Fields

    @FXML
    private Button btn;

    @FXML
    private ImageView imageView;

    //#endregion

    //#region inner

    //#region btn

    public void onBtnClick(ActionEvent actionEvent) {
        VisionTools.video4PC.toggole(new VisionVideo4PCCallback() {
            @Override
            public void whenOpenSuccess() {
                btn.setText("Stop");
            }

            @Override
            public void whenGrabImgFrame() {
                VisionMatrix oSrc = VisionTools.video4PC.grabImgFrame();
                VisionMatrix oDst = VisionTools.imgBasicFeature.contoursCalc(oSrc);
                JavaFXUtils.imageView.updateImageView(oDst.toBufferImg(), imageView);
            }

            @Override
            public void whenOpenFail() {
                btn.setText("Start");
            }
        });
    }

    //#endregion

    //#endregion

    //#region callback

    //#endregion

    //#region 3rd

    //#endregion
}
