package com.example.taskbucket.tasks;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TaskList {
    private HashMap<Integer,Task> tasks;

    public TaskList(){
        this.tasks = new HashMap<Integer, Task>();
    }
    public void addTask(Task task){
        int maxkey = 0;
        if (tasks.isEmpty()){

        }
        else {
            maxkey = Collections.max(tasks.keySet());

            tasks.put(maxkey + 1, task);
        }
    }
    public String getTaskName (int index){
        return tasks.get(index).getName();
    }
    public Collection<Task> getTasks (){
        return tasks.values();
    }
}
