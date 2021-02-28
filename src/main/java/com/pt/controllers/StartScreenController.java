package com.pt.controllers;

import com.pt.app.SceneManager;
import com.pt.app.WindowInitializer;
import com.pt.model.WordLookup;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StartScreenController {

    @FXML
    private Label mainTitleLabel;
    @FXML
    private RadioButton effRadio;
    @FXML
    private RadioButton originalRadio;
    @FXML
    private Button generatorButton;
    @FXML
    private Button lookupButton;

    private ToggleGroup wordListSelectToggleGroup;
    private SceneManager sceneManager;

    public void initialize() {
        wordListSelectToggleGroup = new ToggleGroup();
        effRadio.setToggleGroup(wordListSelectToggleGroup);
        originalRadio.setToggleGroup(wordListSelectToggleGroup);

        wordListSelectToggleGroup.selectToggle(effRadio);
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void generateButtonClicked(MouseEvent mouseEvent) {
        try {
            WindowInitializer<GeneratePasswordScreenController> newWindow = new WindowInitializer<>("/GeneratePasswordScreen.fxml");
            Scene newScene = newWindow.getScene();
            GeneratePasswordScreenController newController = newWindow.getController();

            newController.setSceneManager(sceneManager);
            sceneManager.pushScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lookupButtonClicked(MouseEvent mouseEvent) {
        try {
            WindowInitializer<WordLookupScreenController> newWindow = new WindowInitializer<>("/WordLookupScreen.fxml");
            Scene newScene = newWindow.getScene();
            WordLookupScreenController newController = newWindow.getController();

            newController.setSceneManager(sceneManager);
            sceneManager.pushScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wordListSelectClicked(MouseEvent mouseEvent) {
        Toggle thisToggle = wordListSelectToggleGroup.getSelectedToggle();
        if (thisToggle == effRadio) {
            WordLookup.setWordList(WordLookup.DICEWARE_EFF);
        } else {
            WordLookup.setWordList(WordLookup.DICEWARE_ORIGINAL);
        }
        System.out.println(WordLookup.getWordList());
    }
}
