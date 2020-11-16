package com.example.chutesandladders.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chutesandladders.model.Player;
import com.example.chutesandladders.model.Turn;

public class GameActivityVM extends ViewModel {
    private final MutableLiveData<Boolean> gameComplete = new MutableLiveData<>();
    private final MutableLiveData<Player> currentPlayer = new MutableLiveData<>();
    private final MutableLiveData<Turn> currentTurn = new MutableLiveData<>();
    private Player[] players;

    private static final String TAG = "GameActivityVM";

    public void init(int numPlayers){
        // initialize player array
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player(i, 0);
        }

        // initialize LiveData
        gameComplete.setValue(false);
        currentPlayer.setValue(players[0]);
        currentTurn.setValue(new Turn(currentPlayer.getValue()));
    }

    public void takeTurn(int numberRolled){

        if(!gameComplete.getValue()) {
            Log.d(TAG, "Player: " + currentTurn.getValue().getCurrentPlayer().getPlayerIndex() + "is moving from box #"
                    + currentTurn.getValue().getCurrentBox().getBoxNumber());
            currentTurn.getValue().takeTurn(numberRolled);

            if(currentTurn.getValue().isGameComplete()){
                gameComplete.setValue(true);
            }

            setVariablesForNextTurn();
        }
    }

    public void switchPlayers() {
        int previousPlayerIndex = currentPlayer.getValue().getPlayerIndex();
        if(previousPlayerIndex < (players.length - 1)){
            currentPlayer.setValue(players[previousPlayerIndex + 1]);
        }
        else if(previousPlayerIndex == (players.length - 1)){
            currentPlayer.setValue(players[0]);
        }
    }

    public void setVariablesForNextTurn(){
        switchPlayers();
        currentTurn.setValue(new Turn(currentPlayer.getValue()));
    }

    public LiveData<Boolean> getGameComplete() {
        return gameComplete;
    }

    public LiveData<Player> getCurrentPlayer() {
        return currentPlayer;
    }

    public LiveData<Turn> getCurrentTurn() {
        return currentTurn;
    }

    public Player[] getPlayers() {
        return players;
    }
}
