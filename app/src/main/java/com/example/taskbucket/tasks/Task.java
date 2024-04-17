package com.example.taskbucket.tasks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Random;
@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
@NonNull
    private String name;
    private String description;

    
    private boolean done;

    public Task(String name){
        this.name = name;

        //generate id
        Random r = new Random();
        //this.id = Calendar.getInstance().toString() + r.nextInt() ;
        this.done = false;

    }

    public View getTaskView(Context context) {
        //todo - make more functional task display view
        TextView test = new TextView(context);
        return test;
    }

    public String getName() {return this.name;}
    public int getId(){return this.id;}
    public String getDescription(){return this.description;}
    public boolean getDone(){return  this.done;}

    public void setId(int id){this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String desc) {this.description = desc;}
    public void setDone(boolean done){this.done= done;}
    public void completeTask(){
        // TODO: 3/22/2024 decide whether to implement delete logic in task class 
        done = true;
    }

    public void done() {
        this.done = false;
    }
}
