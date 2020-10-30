package com.example.chutesandladders.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.chutesandladders.R;
import com.example.chutesandladders.databinding.ActivityGameRvBinding;
import com.example.chutesandladders.model.Board;
import com.example.chutesandladders.utils.BoardAdapter;

public class GameActivity extends AppCompatActivity {
    public static int NUM_BOARD_COLUMNS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameRvBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game_rv);

        initBoardRV(binding);
    }

    private void initBoardRV(ActivityGameRvBinding binding){
        BoardAdapter adapter = new BoardAdapter(Board.getBoxes(), this);
        binding.rvBoard.setAdapter(adapter);
        binding.rvBoard.setLayoutManager(new GridLayoutManager(this, NUM_BOARD_COLUMNS));
    }
}