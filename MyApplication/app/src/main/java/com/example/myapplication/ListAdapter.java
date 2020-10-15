package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private List<ListModel> alfaList;
    private Context context;

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.row_list,parent,false);
        ListViewHolder viewHolder = new ListViewHolder(contactView);
        return viewHolder;
    }

    public ListAdapter(List<ListModel> newList){
        this.alfaList = newList;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final ListModel newModel = alfaList.get(position);
        holder.setValues(newModel.getUp(), newModel.getLow());
    }

    @Override
    public int getItemCount() {
        return alfaList.size();
    }
}
