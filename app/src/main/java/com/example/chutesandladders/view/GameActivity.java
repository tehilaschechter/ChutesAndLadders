package com.example.chutesandladders.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chutesandladders.R;
import com.example.chutesandladders.databinding.ActivityGameRvBinding;
import com.example.chutesandladders.model.Board;
import com.example.chutesandladders.model.Die;
import com.example.chutesandladders.model.Player;
import com.example.chutesandladders.model.Turn;
import com.example.chutesandladders.utils.BoardAdapter;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    public static int NUM_BOARD_COLUMNS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameRvBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game_rv);
        Player[] players = initializePlayers(3);

        // initialize LiveData
        final MutableLiveData<Boolean> gameComplete = new MutableLiveData<>();
        gameComplete.setValue(false);
        final MutableLiveData<Player> currentPlayer = new MutableLiveData<>();
        currentPlayer.setValue(players[0]);
        final MutableLiveData<Turn> currentTurn = new MutableLiveData<>();
        currentTurn.setValue(new Turn(currentPlayer.getValue()));

        // set up UI
        initBoardRV(binding);

        binding.dieBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numberRolled = new Die().roll();
                binding.txtRolledNumber.setText(numberRolled.toString());
                Turn thisTurn = currentTurn.getValue();

                if(!gameComplete.getValue()) {
                    Log.d(TAG, "Player: " + thisTurn.getCurrentPlayer().getPlayerIndex() + "is moving from box #" + thisTurn.getCurrentBox().getBoxNumber());
                    thisTurn.takeTurn(numberRolled);

                    if(thisTurn.isGameComplete()){
                        gameComplete.setValue(true);
                    }

                    // switch players
                    switchPlayers(currentPlayer, players);
                    currentTurn.setValue(new Turn(currentPlayer.getValue()));
                }
            }
        });

        initObservers(binding, gameComplete, currentTurn, currentPlayer);

    }

    private Player[] initializePlayers(int numPlayers){
        Player[] players = new Player[numPlayers];

        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player(i, 0);
        }

        return players;
    }

    private void initObservers(com.example.chutesandladders.databinding.ActivityGameRvBinding binding,
                               MutableLiveData<Boolean> gameComplete, MutableLiveData<Turn> currentTurn, MutableLiveData<Player> currentPlayer) {
        currentTurn.observe(this, new Observer<Turn>() {
            @Override
            public void onChanged(Turn turn) {
                binding.txtCurrentPlayer.setText(String.format(
                        getString(R.string.currentPlayer),
                        currentPlayer.getValue().getPlayerIndex()));
            }
        });

        gameComplete.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean gameComplete) {
                if(gameComplete){
                    handleGameCompletion(binding, currentTurn.getValue());
                }
            }
        });
    }

    private void initBoardRV(ActivityGameRvBinding binding){
        BoardAdapter adapter = new BoardAdapter(Board.getBoxes(), this);
        binding.rvBoard.setAdapter(adapter);
        binding.rvBoard.setLayoutManager(new GridLayoutManager(this, NUM_BOARD_COLUMNS){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    private void switchPlayers(MutableLiveData<Player> currentPlayer, Player[] players) {
        int previousPlayerIndex = currentPlayer.getValue().getPlayerIndex();
        if(previousPlayerIndex < (players.length - 1)){
            currentPlayer.setValue(players[previousPlayerIndex + 1]);
        }
        else if(previousPlayerIndex == (players.length - 1)){
            currentPlayer.setValue(players[0]);
        }
    }

    private void handleGameCompletion(com.example.chutesandladders.databinding.ActivityGameRvBinding binding, Turn finalTurn) {
        // display winner message
        binding.txtGameComplete.setText(String.format(getString(R.string.gameComplete), finalTurn.getCurrentPlayer().getPlayerIndex()));
        binding.txtGameComplete.setVisibility(View.VISIBLE);

        // remove die click listener
        binding.dieBackground.setOnClickListener(null);
    }

}