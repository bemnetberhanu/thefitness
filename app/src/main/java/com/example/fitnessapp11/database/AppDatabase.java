package com.example.fitnessapp11.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fitnessapp11.models.workout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {workout.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WorkoutDao workoutDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "workout_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}