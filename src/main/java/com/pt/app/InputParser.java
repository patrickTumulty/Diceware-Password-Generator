package com.pt.app;

public class InputParser {

    public static String[] parseInput(String input) throws IllegalArgumentException {
        ensureLegalInput(input);
        return convertStringInputToStringArray(input);
    }

    private static String[] convertStringInputToStringArray(String input) {
        return input.split("\\s");
    }

    private static void ensureLegalInput(String input) {
        if (!allCharactersAreNumeric(input)) {
            throw new IllegalArgumentException("Invalid input: Illegal character.");
        } else if (!numberOfCharactersIsCorrect(input)) {
            throw new IllegalArgumentException("Invalid input: Enter numbers in groups of five.");
        }
    }

    private static boolean numberOfCharactersIsCorrect(String input) {
        String textInput = input.replace(" ", "");
        return textInput.length() % 5 == 0;
    }

    private static boolean allCharactersAreNumeric(String input) {
        String textInput = input.replace(" ", "");
        for (char c : textInput.toCharArray()) {
            if (!isNumeric(Character.toString(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String element) {
        return element.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}

