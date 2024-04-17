package com.example.taskbucket.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.taskbucket.tasks.Task;

import java.util.List;

public class TaskBucketRepository {
    private TaskDao tDAO;
    private LiveData<List<Task>> alltasks;

    TaskBucketRepository(Application application){
        TaskBucketDatabase db = TaskBucketDatabase.getDatabase(application);
        tDAO = db.taskDao();
        alltasks = tDAO.getAllTasks();

    }

    LiveData<List<Task>> getAllTasks(){return alltasks;}

    long insert(Task task){
        final long[] test = new long[1];
       TaskBucketDatabase.databaseWriteExecutor.execute(() ->{
           test[0] = tDAO.insertTask(task);

        });
       return test[0];
    }
}