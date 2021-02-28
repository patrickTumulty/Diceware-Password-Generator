package com.pt.model;

public class DiceRoller {
    private final Die singleDie;

    public DiceRoller() {
        singleDie = new Die();
    }

    public String rollDice(int numberOfDice) {
        StringBuilder numberSequence = new StringBuilder();
        for (int i = 0; i < numberOfDice; i++) {
            numberSequence.append(Integer.toString(singleDie.roll()));
        }
        return numberSequence.toString();
    }

}
