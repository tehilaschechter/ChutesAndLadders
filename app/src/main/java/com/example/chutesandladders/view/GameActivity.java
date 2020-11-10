package com.example.chutesandladders.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        Player player1 = new Player(1, 0);

        // initialize LiveData
        MutableLiveData<Boolean> gameComplete = new MutableLiveData<>();
        gameComplete.setValue(false);
        final MutableLiveData<Turn> currentTurn = new MutableLiveData<>();
        currentTurn.setValue(new Turn(player1, Board.getBoxOfSpecificNumber(player1.getCurrentBoxNumber())));

        // set up UI
        initBoardRV(binding);

        binding.dieBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer numberRolled = new Die().roll();
                binding.txtRolledNumber.setText(numberRolled.toString());
                Turn thisTurn = currentTurn.getValue();

                if(!gameComplete.getValue()) {
                    Log.d(TAG, "Taking turn: box#" + thisTurn.getCurrentBox().getBoxNumber() + " player:" + thisTurn.getCurrentPlayer().getPlayerID());
                    currentTurn.setValue(thisTurn.takeTurn(numberRolled));

                    if(thisTurn.isGameComplete()){
                        gameComplete.setValue(true);
                    }
                    // todo switch players
                }
            }
        });

        currentTurn.observe(this, new Observer<Turn>() {
            @Override
            public void onChanged(Turn turn) {
                binding.txtCurrentPlayer.setText(String.format(
                        getString(R.string.currentPlayer),
                        currentTurn.getValue().getCurrentPlayer().getPlayerID()));
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
        binding.rvBoard.setLayoutManager(new GridLayoutManager(this, NUM_BOARD_COLUMNS));
    }

    private void handleGameCompletion(com.example.chutesandladders.databinding.ActivityGameRvBinding binding, Turn finalTurn) {
        // display winner message
        binding.txtGameComplete.setText(String.format(getString(R.string.gameComplete), finalTurn.getCurrentPlayer().getPlayerID()));
        binding.txtGameComplete.setVisibility(View.VISIBLE);

        // remove die click listener
        binding.dieBackground.setOnClickListener(null);
    }

}