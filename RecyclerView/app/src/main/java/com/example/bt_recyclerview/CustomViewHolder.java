package com.example.bt_recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView textName;
    public TextView textAge;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.textName);
        textAge = itemView.findViewById(R.id.textAge);
    }
}