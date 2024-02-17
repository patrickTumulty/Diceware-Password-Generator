package com.pt.app;

import com.pt.controllers.StartScreenController;
import com.pt.model.DiceRoller;
import com.pt.model.Die;
import com.pt.model.WordLookup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DicewarePasswordGenerator extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        WindowInitializer<StartScreenController> mainWindow = new WindowInitializer<>("/StartScreen.fxml");

        StartScreenController startScreenController = mainWindow.getController();
        Scene startScreenScene = mainWindow.getScene();

        SceneManager sceneManager = SceneManager.INSTANCE;
        sceneManager.setPrimaryStage(primaryStage);

        startScreenController.setSceneManager(sceneManager);

        primaryStage.setTitle("Diceware");
        primaryStage.setResizable(false);
        sceneManager.pushScene(startScreenScene);
        primaryStage.show();

    }
}
