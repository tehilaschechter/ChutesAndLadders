package com.example.chutesandladders.model;

public class Turn {

    private Player currentPlayer;
    private Box currentBox;
    private boolean gameComplete;

    public Turn(Player currentPlayer, Box currentBox) {
        this.currentPlayer = currentPlayer;
        this.currentBox = currentBox;
        this.gameComplete = false;
    }

    public Turn takeTurn(){

        int dieNumber = rollDie();
        advanceToNewBox(currentBox.getBoxNumber() + dieNumber);
        handleSnakeOrLadder(currentBox);
        gameComplete = handleGameComplete(currentBox);

        return this;
    }

    private int rollDie(){
        return new Die().roll();
    }

    private void advanceToNewBox(int newBoxNumber){
        currentBox = Board.getBoxes().get(newBoxNumber - 1);
    }

    private void handleSnakeOrLadder(Box box){
        if(box.getLadderBeginningHereGoesTo() != Box.NO_LADDER){
            advanceToNewBox(box.getLadderBeginningHereGoesTo());
        }

        if (box.getSnakeBeginningHereGoesTo() != Box.NO_SNAKE){
            advanceToNewBox(box.getSnakeBeginningHereGoesTo());
        }
    }

    private boolean handleGameComplete(Box currentBox){
        if(currentBox.isLast()){
            return true;
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
