package com.example.taskbucket.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskbucket.R;
import com.example.taskbucket.database.TaskBucketViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskViewHolder extends RecyclerView.ViewHolder{
    private final TextView titletextview;
    private final FloatingActionButton delete_btn;

    private TaskViewHolder(View itemView){
        super(itemView);
        titletextview = itemView.findViewById(R.id.tasktitleview);
        delete_btn = itemView.findViewById(R.id.deletebtn);
    }

    public void bind(Task task, TaskBucketViewModel vm){
        titletextview.setText((task.getName()));
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.deleteTask(task);
            }
        });

    }

    static TaskViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(view);
    }
}
