package com.example.taskbucket.tasks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Task {
    private String name;
    private String desc;
    private String id;


    public Task(String name){
        this.name = name;
        this.id = Calendar.getInstance().toString();


    }

    public View getTaskView(Context context) {
        //todo - make more functional task display view
        TextView test = new TextView(context);
        return test;
    }

    public String getName() {return this.name;}
    public String getId(){return this.id;}

}
