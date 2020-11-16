package com.example.chutesandladders.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chutesandladders.R;
import com.example.chutesandladders.databinding.ActivityGameRvBinding;
import com.example.chutesandladders.model.Board;
import com.example.chutesandladders.model.Die;
import com.example.chutesandladders.model.Turn;
import com.example.chutesandladders.utils.BoardAdapter;
import com.example.chutesandladders.viewmodel.GameActivityVM;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    public static int NUM_BOARD_COLUMNS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameRvBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game_rv);
        GameActivityVM viewmodel = new ViewModelProvider(this).get(GameActivityVM.class);

        // set up UI
        initBoardRV(binding);

        // initialize vm variables
        viewmodel.init(3);

        binding.dieBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberRolled = new Die().roll();
                binding.txtRolledNumber.setText(Integer.toString(numberRolled));
                viewmodel.takeTurn(numberRolled);
            }
        });

        initObservers(binding, viewmodel);

    }



    private void addPlayerPiece(ActivityGameRvBinding binding) {
        ConstraintLayout parentLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        ConstraintSet set = new ConstraintSet();

        ImageView piece = new ImageView(this);
        Drawable pieceDrawable = ContextCompat.getDrawable(this, R.drawable.item_player_piece);

        //pieceDrawable.mutate().setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_OVER));
        piece.setBackground(pieceDrawable);
        piece.setId(View.generateViewId());
        parentLayout.addView(piece, 0);

        set.clone(parentLayout);
        set.connect(piece.getId(), ConstraintSet.END, binding.rvBoard.getId(), ConstraintSet.START, 60);
        set.connect(piece.getId(), ConstraintSet.BOTTOM, binding.rvBoard.getId(), ConstraintSet.BOTTOM, 0);
        set.applyTo(parentLayout);
    }

    private void initObservers(com.example.chutesandladders.databinding.ActivityGameRvBinding binding,
                               GameActivityVM viewmodel) {
        viewmodel.getCurrentTurn().observe(this, new Observer<Turn>() {
            @Override
            public void onChanged(Turn turn) {
                binding.txtCurrentPlayer.setText(String.format(
                        getString(R.string.currentPlayer),
                        viewmodel.getCurrentPlayer().getValue().getPlayerIndex()));
            }
        });

        viewmodel.getGameComplete().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean gameComplete) {
                if(gameComplete){
                    handleGameCompletion(binding, viewmodel.getCurrentTurn().getValue());
                }
            }
        });
    }

    private RecyclerView.LayoutManager initBoardRV(ActivityGameRvBinding binding){
        BoardAdapter adapter = new BoardAdapter(Board.getBoxes(), this);
        binding.rvBoard.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, NUM_BOARD_COLUMNS){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        binding.rvBoard.setLayoutManager(layoutManager);

        return layoutManager;
    }

    private void handleGameCompletion(com.example.chutesandladders.databinding.ActivityGameRvBinding binding, Turn finalTurn) {
        // display winner message
        binding.txtGameComplete.setText(String.format(getString(R.string.gameComplete), finalTurn.getCurrentPlayer().getPlayerIndex()));
        binding.txtGameComplete.setVisibility(View.VISIBLE);

        // remove die click listener
        binding.dieBackground.setOnClickListener(null);
    }

}