package com.example.taskbucket.tasks;

import android.content.Context;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TaskList {
    private String why;
    private HashMap<Integer, Task> tasks;

    public TaskList() {
        this.tasks = new HashMap<Integer, Task>();
    }

    public void addTask(Task task) {
        int maxkey = 0;
        if (tasks.isEmpty()) {
            tasks.put(1, task);
        } else {
            maxkey = Collections.max(tasks.keySet());

            tasks.put(maxkey + 1, task);
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
}
