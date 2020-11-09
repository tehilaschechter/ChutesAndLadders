package com.example.chutesandladders.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

        initBoardRV(binding);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Player player1 = new Player(1, 0);
        Turn currentTurn = new Turn(player1, Board.getBoxOfSpecificNumber(player1.getCurrentBoxNumber()));
        do{
            Log.d(TAG, "Taking turn: box#" + currentTurn.getCurrentBox().getBoxNumber() + " player:" + currentTurn.getCurrentPlayer().getPlayerID());
            currentTurn = currentTurn.takeTurn();
            // todo switch players
        }
        while (!currentTurn.isGameComplete());
    }

    private void initBoardRV(ActivityGameRvBinding binding){
        BoardAdapter adapter = new BoardAdapter(Board.getBoxes(), this);
        binding.rvBoard.setAdapter(adapter);
        binding.rvBoard.setLayoutManager(new GridLayoutManager(this, NUM_BOARD_COLUMNS));
    }

}