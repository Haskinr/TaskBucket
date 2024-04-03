package com.example.taskbucket.database;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.taskbucket.tasks.Task;

import java.util.List;

public interface TaskDao {
    @Insert
    void insertTask (Task task);

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();
}
