package com.example.chutesandladders.model;

import android.util.Log;

import androidx.annotation.NonNull;

public class Turn {
    private static final String TAG = "Turn";

    private Player currentPlayer;
    private Box currentBox;
    private boolean gameComplete;

    public Turn(Player currentPlayer, Box currentBox) {
        this.currentPlayer = currentPlayer;
        this.currentBox = currentBox;
        this.gameComplete = false;
    }

    public Turn takeTurn(int numberRolled){


        advanceToNewBox(currentBox.getBoxNumber() + numberRolled);
        handleSnakeOrLadder(currentBox);
        gameComplete = handleGameComplete(currentBox);

        return this;
    }

    private void advanceToNewBox(int newBoxNumber){
        if(newBoxNumber < Board.getBoxes().size()){
            currentBox = Board.getBoxOfSpecificNumber(newBoxNumber);
        }
        else{
            currentBox = Board.getBoxOfSpecificNumber(Board.getBoxes().size());
        }

    }

    private void handleSnakeOrLadder(@NonNull Box box){
        if (box != null) {
            if(box.getLadderBeginningHereGoesTo() != Box.NO_LADDER){
                advanceToNewBox(box.getLadderBeginningHereGoesTo());
            }

            if (box.getSnakeBeginningHereGoesTo() != Box.NO_SNAKE){
                advanceToNewBox(box.getSnakeBeginningHereGoesTo());
            }
        }
    }

    private boolean handleGameComplete(Box currentBox){
        if (currentBox != null) {
            if(currentBox.isLast()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Box getCurrentBox() {
        return currentBox;
    }

    public boolean isGameComplete() {
        return gameComplete;
    }
}
