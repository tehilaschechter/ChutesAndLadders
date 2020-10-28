package com.example.chutesandladders.model;

public class Turn {

    private Player currentPlayer;
    private Box currentBox;

    public boolean takeTurn(){
        boolean finishGame = false;

        int dieNumber = rollDie();
        Box cBox = advanceToNewBox(dieNumber);
        // act on box


        return finishGame;
    }

    public int rollDie(){
        return new Die().roll();
    }

    public Box advanceToNewBox(int spacesToAdvance){
        int newBoxNumber = currentBox.getBoxNumber() + spacesToAdvance;
        //currentBox = getBoxWithNewBoxNumber;
        return currentBox;
    }

    /*public void actOnBox(Box box){
        if(box.)
    }*/
}
