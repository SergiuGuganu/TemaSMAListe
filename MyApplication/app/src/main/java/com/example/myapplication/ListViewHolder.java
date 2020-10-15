package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private TextView upperCase;
    private TextView lowerCase;

    public ListViewHolder (@NonNull View itemView){
        super(itemView);
        initializeViews();
    }

    private void initializeViews(){
        upperCase = itemView.findViewById(R.id.tv_upper);
        lowerCase = itemView.findViewById(R.id.tv_lower);
    }

    public void setValues(String up, String down){
        upperCase.setText(up);
        lowerCase.setText(down);
    }
}
