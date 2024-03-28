package com.example.taskbucket.tasks;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TaskList {
    private String why;
    private HashMap<String, Task> tasks;

    public TaskList() {
        this.tasks = new HashMap<String, Task>();
    }

    public void addTask(Task task) {
        if (tasks.isEmpty()) {
            tasks.put(task.getId(), task);
        } else {
            tasks.put(task.getId(), task);
        }
    }

    public String getTaskName(int index) {
        return tasks.get(index).getName();
    }

    public Collection<Task> getTasks() {
        return tasks.values();
    }

    public void testtoast(Context c) {
        Toast test = new Toast(c);
        test.setText(getTaskName(1));
        test.show();

    }


    public Task randomtask(){
        Object[] ts = tasks.values().toArray();
        int l = ts.length;
        Random r = new Random();

        return (l < 1)? null: (Task)ts[r.nextInt(l)];

    }

    public void removeTask(String id, Context c) {
        tasks.remove(id);
    }
}
