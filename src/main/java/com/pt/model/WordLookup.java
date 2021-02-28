package com.pt.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordLookup {

    public static final String DICEWARE_EFF = "wordlists/diceware-wordlist-eff.txt";
    public static final String DICEWARE_ORIGINAL = "wordlists/diceware-wordlist-original.txt";
    private static String wordList = DICEWARE_EFF;

    public static String lookupSingleWord(int lookupNumber) throws FileNotFoundException {
        String word = "";
        Scanner fileReader = getFileReader();
        while (fileReader.hasNextLine()) {
            String[] line = fileReader.nextLine().split("\\s");
            String thisWord = line[1];
            int thisNumber = Integer.parseInt(line[0]);
            if (thisNumber == lookupNumber) {
                word = thisWord;
                break;
            }
        }
        return word;
    }

    public static String lookupSingleWord(String lookupNumber) throws FileNotFoundException {
        String word = "";
        Scanner fileReader = getFileReader();
        while (fileReader.hasNextLine()) {
            String[] line = fileReader.nextLine().split("\\s");
            String thisWord = line[1];
            String thisNumber = line[0];
            if (thisNumber.equals(lookupNumber)) {
                word = thisWord;
                break;
            }
        }
        return word;
    }

    public static String lookupMultipleWords(Integer[] lookupNumbers) throws FileNotFoundException {
        StringBuilder words = new StringBuilder();
        for (Integer num : lookupNumbers) {
            String thisWord = lookupSingleWord(num);
            if (thisWord.equals("")) {
                words.append("? ");
            } else {
                words.append(thisWord);
                words.append(" ");
            }
        }
        return words.substring(0, words.length() - 1); // The last character is a space. This line removes the space.
    }

    public static String lookupMultipleWords(String[] lookupNumbers) throws FileNotFoundException {
        StringBuilder dicewareWords = new StringBuilder();
        for (String num : lookupNumbers) {
            String thisWord = lookupSingleWord(num);
            if (thisWord.equals("")) {
                dicewareWords.append("? ");
            } else {
                dicewareWords.append(thisWord);
                dicewareWords.append(" ");
            }
        }
        return dicewareWords.substring(0, dicewareWords.length() - 1); // The last character is a space. This line removes the space.
    }

    public static void setWordList(String wordList) {
        WordLookup.wordList = wordList;
    }

    public static String getWordList() {
        return wordList;
    }

    private static Scanner getFileReader() throws FileNotFoundException {
        File file = new File(wordList);
        return new Scanner(file);
    }
}
