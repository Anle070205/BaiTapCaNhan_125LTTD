package com.example.bt_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<MyModel> modelList;
    private SelectListener listener;

    public CustomAdapter(Context context, List<MyModel> modelList, SelectListener listener) {
        this.context = context;
        this.modelList = modelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_items, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        MyModel model = modelList.get(position);

        // Gắn dữ liệu vào view
        holder.textName.setText(model.getName());
        holder.textAge.setText(String.valueOf(model.getAge()));

        // Xử lý sự kiện click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}