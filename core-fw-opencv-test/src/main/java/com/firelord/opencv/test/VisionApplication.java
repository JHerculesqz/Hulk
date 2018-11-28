package com.firelord.opencv.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VisionApplication extends Application {
    //#region Fields

    static {
        System.load("C:/1.Monkey/1.Research/1.Tools/opencv3.4.4/build/java/x86/opencv_java344.dll");
    }

    //#endregion

    //#region main

    public static void main(String[] args) {
        launch(args);
    }

    //#endregion

    //#region start

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainForm.fxml"));
        Scene scene = new Scene(root, 600, 420);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("app.css")
                .toExternalForm());

        primaryStage.setTitle("Vision Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //#endregion
}
