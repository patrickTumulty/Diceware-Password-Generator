package com.pt.controllers;

import com.pt.app.InputParser;
import com.pt.app.SceneManager;
import com.pt.model.WordLookup;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class WordLookupScreenController {
    @FXML
    public Button backButton;
    @FXML
    public TextArea textFieldOutput;
    @FXML
    private TextField numberTextField;
    @FXML
    private Button lookupButton;
    @FXML
    private Label displayLabel;

    private SceneManager sceneManager;

    public void lookupButtonClicked(MouseEvent mouseEvent) {
        String inputString = numberTextField.getText();

        String[] inputNumbers = convertInputToArrayOfStrings(inputString);
        if (inputNumbers == null) return;

        String output;
        try {
            output = WordLookup.lookupMultipleWords(inputNumbers);
        } catch (FileNotFoundException ex) {
            displayWarningMessage("Diceware Word List File Not Found...");
            return;
        }

        displayOutput(output);
    }

    private String[] convertInputToArrayOfStrings(String inputString) {
        String[] inputNumbers = null;
        try {
            inputNumbers = InputParser.parseInput(inputString);
        } catch (IllegalArgumentException ex) {
            displayWarningMessage(ex.getMessage());
            return null;
        }
        return inputNumbers;
    }

    private void displayOutput(String outputString) {
        textFieldOutput.setText(outputString);
    }

    private void displayWarningMessage(String message) {
//        textFieldOutput.setTextFill(Color.RED);
        textFieldOutput.setText(message);
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void backButtonClicked(MouseEvent mouseEvent) {
        sceneManager.returnToPreviousScene();
    }
}
