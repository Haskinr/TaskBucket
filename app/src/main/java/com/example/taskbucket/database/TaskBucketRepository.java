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
    LiveData<List<Task>> getFilteredTasks(String col, boolean val){return tDAO.getFilteredTasks(col, val);}
    LiveData<List<Task>> getUnfinishedTasks(){return tDAO.getUnfinishedTasks();}

    void deleteTask (Task task){
        TaskBucketDatabase.databaseWriteExecutor.execute(() ->{
            tDAO.deleteTask(task.getId());
        });
    }
    long insert(Task task){
        final long[] test = new long[1];
      TaskBucketDatabase.databaseWriteExecutor.execute(() ->{
           tDAO.insertTask(task);

       });
       return 0;
    }
    void update(Task task){
        TaskBucketDatabase.databaseWriteExecutor.execute(() ->{
            tDAO.updateTask(task);
        });
    }
}