package com.pt.app;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public enum SceneManager {

    INSTANCE;

    private final Stack<Scene> sceneStack;
    private Stage primaryStage;

    SceneManager() {
        primaryStage = null;
        sceneStack = new Stack<>();
    }

    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public void pushScene(Scene scene) {
        sceneStack.push(scene);
        primaryStage.setScene(scene);
    }

    public void returnToPreviousScene() {
        sceneStack.pop();
        primaryStage.setScene(sceneStack.peek());
    }

}
