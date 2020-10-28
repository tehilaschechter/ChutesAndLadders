package com.example.chutesandladders.model;

public class Box {
    private int boxNumber;
    private boolean snakeBeginning;
    private boolean ladderBeginning;
    private boolean isLast;
    private boolean isFreeTurn;

    public Box(int boxNumber, boolean snakeBeginning, boolean ladderBeginning, boolean isLast, boolean isFreeTurn) {
        this.boxNumber = boxNumber;
        this.snakeBeginning = snakeBeginning;
        this.ladderBeginning = ladderBeginning;
        this.isLast = isLast;
        this.isFreeTurn = isFreeTurn;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public boolean isSnakeBeginning() {
        return snakeBeginning;
    }

    public void setSnakeBeginning(boolean snakeBeginning) {
        this.snakeBeginning = snakeBeginning;
    }

    public boolean isLadderBeginning() {
        return ladderBeginning;
    }

    public void setLadderBeginning(boolean ladderBeginning) {
        this.ladderBeginning = ladderBeginning;
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
