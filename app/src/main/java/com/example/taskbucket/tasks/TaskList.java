package com.example.taskbucket.tasks;

import android.content.Context;
import android.widget.Toast;

import com.example.taskbucket.database.TaskBucketViewModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TaskList {
    private String why;
    private HashMap<Integer, Task> tasks;

    public TaskList() {
        this.tasks = new HashMap<Integer, Task>();
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


    public Task randomtask() {
        Object[] ts = tasks.values().toArray();
        int l = ts.length;
        Random r = new Random();

        return (l < 1) ? null : (Task) ts[r.nextInt(l)];

    }

    public void removeTask(long id, Context c) {
        tasks.remove(id);
    }

    public void getAllDbTasks(TaskBucketViewModel taskBucketViewModel) {
        List<Task> listoftasks = taskBucketViewModel.getAllTasks().getValue();
        if (listoftasks == null) return;
        for (Task t : listoftasks
        ) {
            this.addTask(t);
        }
    }

}
