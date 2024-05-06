package com.example.taskbucket.tasks;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.taskbucket.database.TaskBucketViewModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TaskList extends ListAdapter<Task, TaskViewHolder> {
    private String why;
    private HashMap<Integer, Task> tasks;

    private TaskBucketViewModel vm;

    public TaskList(@NonNull DiffUtil.ItemCallback<Task> diffCallback) {
        super(diffCallback);
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
        List<Task> tl = this.getCurrentList();
        int l = tl.size();
        Random r = new Random();

        return (l < 1) ? null : (Task) tl.get(r.nextInt(l));

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

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    public void setViewModel (TaskBucketViewModel taskBucketViewModel){vm = taskBucketViewModel;}

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current, vm);
    }

    public static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task  newItem) {
            // TODO: 4/26/2024 more robust content comparison
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
