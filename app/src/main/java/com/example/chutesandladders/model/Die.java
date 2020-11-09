package com.example.chutesandladders.model;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int number;

    public Die() {
    }

    public int getNumber() {
        return number;
    }

    public int roll(){
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(6)) + 1;
        //return ThreadLocalRandom.current().nextInt(1, 7); // return random int between 1 and 6 // TODO SEED THIS RANDOM
    }
}
