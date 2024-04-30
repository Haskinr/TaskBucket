package com.example.taskbucket.database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.taskbucket.tasks.Task;

import java.util.List;

public class TaskBucketRepository {
    private TaskDao tDAO;
    private LiveData<List<Task>> alltasks;
    //private LiveData<List<Task>> alltasks;

    TaskBucketRepository(Application application){
        TaskBucketDatabase db = TaskBucketDatabase.getDatabase(application);
        tDAO = db.taskDao();
        alltasks = tDAO.getAllTasks();
        Log.i("Taskbucket Repository" ,"Repo instantiated");

    }

    LiveData<List<Task>> getAllTasks(){return alltasks;}

    long insert(Task task){
        final long[] test = new long[1];
      TaskBucketDatabase.databaseWriteExecutor.execute(() ->{
           tDAO.insertTask(task);

       });
       return 0;
    }
}