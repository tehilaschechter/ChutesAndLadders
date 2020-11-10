package com.example.chutesandladders.model;

public class Player {
    private int playerIndex;
    private int currentBoxNumber;

    public Player(int playerIndex, int currentBoxNumber) {
        this.playerIndex = playerIndex;
        this.currentBoxNumber = currentBoxNumber;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getCurrentBoxNumber() {
        return currentBoxNumber;
    }

    public void setCurrentBoxNumber(int currentBoxNumber) {
        this.currentBoxNumber = currentBoxNumber;
    }
}
