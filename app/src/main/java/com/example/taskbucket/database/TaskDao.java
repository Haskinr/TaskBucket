package com.example.taskbucket.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.taskbucket.tasks.Task;

import java.util.List;
@Dao
public interface TaskDao {
    @Insert
    long insertTask(Task task);

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTasks();

    @Query(("DELETE FROM task_table where id = :tid"))
    void deleteTask(String tid);

    @Query("DELETE FROM task_table")
    void deleteAll();
}