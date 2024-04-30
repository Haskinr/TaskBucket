package com.example.taskbucket.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskbucket.R;

public class TaskViewHolder extends RecyclerView.ViewHolder{
    private final TextView taskView;

    private TaskViewHolder(View itemView){
        super(itemView);
        taskView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){ taskView.setText((text));}

    static TaskViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(view);
    }
}
