package com.pt.controllers;

import com.pt.app.SceneManager;
import com.pt.model.DiceRoller;
import com.pt.model.WordLookup;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;

public class GeneratePasswordScreenController {
    @FXML
    public TextArea outputTextArea;
    @FXML
    private RadioButton radioOne;
    @FXML
    private RadioButton radioTwo;
    @FXML
    private RadioButton radioThree;
    @FXML
    private RadioButton radioFour;
    @FXML
    private RadioButton radioFive;
    @FXML
    private RadioButton radioSix;
    @FXML
    private RadioButton radioSeven;
    @FXML
    private RadioButton radioEight;
    @FXML
    private RadioButton radioNine;
    @FXML
    private Button generateButton;
    @FXML
    private Label displayLabel;

    private ToggleGroup numberOfWordsToggleGroup;

    private SceneManager sceneManager;

    @FXML
    public void initialize() {
        numberOfWordsToggleGroup = new ToggleGroup();
        radioOne.setToggleGroup(numberOfWordsToggleGroup);
        radioTwo.setToggleGroup(numberOfWordsToggleGroup);
        radioThree.setToggleGroup(numberOfWordsToggleGroup);
        radioFour.setToggleGroup(numberOfWordsToggleGroup);
        radioFive.setToggleGroup(numberOfWordsToggleGroup);
        radioSix.setToggleGroup(numberOfWordsToggleGroup);
        radioSeven.setToggleGroup(numberOfWordsToggleGroup);
        radioEight.setToggleGroup(numberOfWordsToggleGroup);
        radioNine.setToggleGroup(numberOfWordsToggleGroup);

    }


    public void generateButtonClicked(MouseEvent mouseEvent) {
        ToggleButton currentToggle = (ToggleButton) numberOfWordsToggleGroup.getSelectedToggle();
        if (currentToggle == null) {
            return;
        }
        int numberOfWords = Integer.parseInt(currentToggle.getText());

        DiceRoller diceRoller = new DiceRoller();
        Integer[] randomNumberSequences = new Integer[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            String currentNumberSequence = diceRoller.rollDice(5);
            randomNumberSequences[i] = Integer.parseInt(currentNumberSequence);
        }

        String newPassword = "";
        try {
            newPassword = WordLookup.lookupMultipleWords(randomNumberSequences);
        } catch (FileNotFoundException e) {
            outputTextArea.setText("Something went wrong...");
            return;
        }

        outputTextArea.setText(newPassword);
    }

    public void backButtonClicked(MouseEvent mouseEvent) {
        sceneManager.returnToPreviousScene();
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
