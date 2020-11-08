package com.example.chutesandladders.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Box {
    private int boxNumber;
    private int snakeBeginningHereGoesTo;
    private int ladderBeginningHereGoesTo;
    private boolean isLast;
    private boolean isFreeTurn;

    public static final int NO_LADDER = 0;
    public static final int NO_SNAKE = 0;

    public Box(int boxNumber, int snakeBeginningHereGoesTo, int ladderBeginningHereGoesTo, boolean isLast, boolean isFreeTurn) {
        this.boxNumber = boxNumber;
        this.snakeBeginningHereGoesTo = snakeBeginningHereGoesTo;
        this.ladderBeginningHereGoesTo = ladderBeginningHereGoesTo;
        this.isLast = isLast;
        this.isFreeTurn = isFreeTurn;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public int getSnakeBeginningHereGoesTo() {
        return snakeBeginningHereGoesTo;
    }

    public void setSnakeBeginningHereGoesTo(int snakeBeginningHereGoesTo) {
        this.snakeBeginningHereGoesTo = snakeBeginningHereGoesTo;
    }

    public int getLadderBeginningHereGoesTo() {
        return ladderBeginningHereGoesTo;
    }

    public void setLadderBeginningHereGoesTo(int ladderBeginningHereGoesTo) {
        this.ladderBeginningHereGoesTo = ladderBeginningHereGoesTo;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isFreeTurn() {
        return isFreeTurn;
    }

    public void setFreeTurn(boolean freeTurn) {
        isFreeTurn = freeTurn;
    }
}
