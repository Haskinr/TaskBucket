package com.example.taskbucket.tasks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class Task {
    private String name;
    private String desc;
    private String id;
    
    private Boolean done;

    public Task(String name){
        this.name = name;

        //generate id
        Random r = new Random();
        this.id = Calendar.getInstance().toString() + r.nextInt() ;
        this.done = false;

    }

    public View getTaskView(Context context) {
        //todo - make more functional task display view
        TextView test = new TextView(context);
        return test;
    }

    public String getName() {return this.name;}
    public String getId(){return this.id;}
    public void completeTask(){
        // TODO: 3/22/2024 decide whether to implement delete logic in task class 
        done = true;
    }

    public void done() {
        this.done = false;
    }
}
