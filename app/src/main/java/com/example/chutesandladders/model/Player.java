package com.example.chutesandladders.model;

public class Player {
    private int playerID;
    private int currentBoxNumber;

    public Player(int playerID, int currentBoxNumber) {
        this.playerID = playerID;
        this.currentBoxNumber = currentBoxNumber;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getCurrentBoxNumber() {
        return currentBoxNumber;
    }

    public void setCurrentBoxNumber(int currentBoxNumber) {
        this.currentBoxNumber = currentBoxNumber;
    }
}
