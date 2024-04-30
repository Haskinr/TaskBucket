package com.example.taskbucket.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.taskbucket.tasks.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Task.class}, version = 2, exportSchema = false)
public abstract class TaskBucketDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile TaskBucketDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskBucketDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskBucketDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TaskBucketDatabase.class, "word_database")
                            .addMigrations(MIGRATION_1_2)
                            .addCallback(RoomDatabaseCallback)
                            .build();
                    Log.i("Taskbucket Database" ,"Creating DB instance");
                }
            }
        }
        Log.i("Taskbucket Database" ,"Returning DB Instance");
        return INSTANCE;
    }

    private static RoomDatabase.Callback RoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //in case I ever need to do something different here
            Log.i("Taskbucket Database" ,"callback function opened");
            databaseWriteExecutor.execute(() -> {
                TaskDao dao = INSTANCE.taskDao();
                dao.deleteAll();
                Task word = new Task("Hello");
                dao.insertTask(word);
                word = new Task("World");
                dao.insertTask(word);
                Log.i("Taskbucket Database" ,"callback insert stmt finished");
            });
            Log.i("Taskbucket Database" ,"callback function closed");
        }
    };

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("DROP TABLE task_table");
            database.execSQL("CREATE TABLE task_table(name TEXT NOT NULL, description TEXT, id INTEGER Primary Key NOT NULL, done INTEGER NOT NULL)");
        }
    };


}