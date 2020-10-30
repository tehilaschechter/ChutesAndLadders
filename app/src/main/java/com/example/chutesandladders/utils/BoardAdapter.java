package com.example.chutesandladders.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chutesandladders.R;
import com.example.chutesandladders.model.Box;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoxViewHolder>{
    private ArrayList<Box> boxObjects = new ArrayList<>();
    private Context context;

    public BoardAdapter(ArrayList<Box> boxObjectList, Context context) {
        boxObjects = boxObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public BoardAdapter.BoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game_box, parent, false);
        return new BoardAdapter.BoxViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.BoxViewHolder holder, int position) {
        int boxNumber = boxObjects.get(position).getBoxNumber();

        holder.txtBoxNumber.setText(String.valueOf(boxNumber));

        if((boxNumber % 2) == 0){
            holder.boxBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.background_box_even));
        }

    }

    @Override
    public int getItemCount() {
        return boxObjects.size();
    }

    public static class BoxViewHolder extends RecyclerView.ViewHolder{
        TextView txtBoxNumber;
        View boxBackground;

        public BoxViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBoxNumber = itemView.findViewById(R.id.txtBoxNumber);
            boxBackground = itemView.findViewById(R.id.boxBackground);
        }
    }
}