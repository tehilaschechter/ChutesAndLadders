package com.example.chutesandladders.model;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int number;

    public Die() {
    }

    public int getNumber() {
        return number;
    }

    public int roll(){
        return ThreadLocalRandom.current().nextInt(1, 7); // return random int between 1 and 6 // TODO SEED THIS RANDOM
    }
}
