package com.example.taskbucket.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.taskbucket.tasks.Task;

import java.util.List;
@Dao
public interface TaskDao {
    @Insert
    long insertTask(Task task);

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTasks();

    // TODO: 5/6/2024 redesign filter query 
    @Query("SELECT * FROM task_table WHERE :col = :val")
    LiveData<List<Task>> getFilteredTasks(String col, boolean val);
    @Query("SELECT * FROM task_table WHERE done = 0")
    LiveData<List<Task>> getUnfinishedTasks();
    @Update
    void updateTask(Task task);

    @Query(("DELETE FROM task_table where id = :tid"))
    void deleteTask(long tid);

    @Query("DELETE FROM task_table")
    void deleteAll();
}