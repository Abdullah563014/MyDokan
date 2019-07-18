package com.github.abdullah563014.mydokan.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient databaseInstance;
    private TaskDatabase taskDatabase;

    public DatabaseClient(Context context){
        this.context=context;
        taskDatabase= Room.databaseBuilder(context,TaskDatabase.class,"MyDatabase").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (databaseInstance == null) {
            databaseInstance = new DatabaseClient(mCtx);
        }
        return databaseInstance;
    }

    public TaskDatabase getTaskDatabase() {
        return taskDatabase;
    }
}
