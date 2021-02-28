package com.pt.model;

import java.util.Random;

public class Die {
    private final Random numberGenerator;

    public Die() {
        numberGenerator = new Random();
    }

    public int roll() {
        return numberGenerator.nextInt(6) + 1;
    }

}
