package com.firelord.javafx.thread;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;

public class ThreadProvider {
    //#region  updateUIInSubThread

    public void updateUIInSubThread(ObjectProperty<Image> property, Image value) {
        Platform.runLater(() -> {
            property.set(value);
        });
    }

    //#endregion
}
