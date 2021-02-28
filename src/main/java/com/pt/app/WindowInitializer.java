package com.pt.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WindowInitializer<T> {
    private String fxmlFileName;
    private Scene scene;
    private T controller;

    public WindowInitializer(String fxmlFileName) throws IOException {
        this.fxmlFileName = fxmlFileName;
        initialize();
    }

    public void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        scene = new Scene(root);
    }

    public T getController() {
        return controller;
    }

    public Scene getScene() {
        return scene;
    }

}

