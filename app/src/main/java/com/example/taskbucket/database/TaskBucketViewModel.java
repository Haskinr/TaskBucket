package com.example.taskbucket.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskbucket.tasks.Task;

import java.util.List;

public class TaskBucketViewModel extends AndroidViewModel {

    private  TaskBucketRepository taskBucketRepository;
    private final LiveData<List<Task>> alltasks;

    public TaskBucketViewModel (Application application){
        super(application);
        taskBucketRepository = new TaskBucketRepository(application);
        alltasks = taskBucketRepository.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() { return alltasks;}
    public LiveData<List<Task>> getFilteredTasks(String col, boolean val){return taskBucketRepository.getFilteredTasks(col, val);}
    public LiveData<List<Task>> getUnfinishedTasks(){return taskBucketRepository.getUnfinishedTasks();}

    public long insert(Task task){ return taskBucketRepository.insert(task);}
    public void updateTask(Task task){taskBucketRepository.update(task);}
    public void deleteTask(Task task){
        taskBucketRepository.deleteTask(task);
    }
}
