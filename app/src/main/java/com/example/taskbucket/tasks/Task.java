package com.example.taskbucket.tasks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class Task {
    private String name;
    private String desc;


    public Task(String name){
        this.name = name;
    }

    public View getTaskView(Context context) {
        //todo - make more functional task display view
        TextView test = new TextView(context);
        return test;
    }

    public String getName() {return this.name;}
}
