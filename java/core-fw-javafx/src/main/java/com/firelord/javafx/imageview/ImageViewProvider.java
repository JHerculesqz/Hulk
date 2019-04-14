package com.firelord.javafx.imageview;

import com.firelord.javafx.JavaFXUtils;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class ImageViewProvider {
    //#region updateImageView

    public void updateImageView(BufferedImage oBufferedImage, ImageView oImageView) {
        //validate
        if (null == oBufferedImage) {
            return;
        }

        //update ImageView
        try {
            //oBufferedImage to oImage
            Image oImage = SwingFXUtils.toFXImage(oBufferedImage, null);

            //update ImageView
            JavaFXUtils.thread.updateUIInSubThread(oImageView.imageProperty(), oImage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //#endregion
}
