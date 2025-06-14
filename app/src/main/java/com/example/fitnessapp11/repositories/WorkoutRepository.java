package com.example.fitnessapp11.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.fitnessapp11.database.AppDatabase;
import com.example.fitnessapp11.database.WorkoutDao;
import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.viewmodels.WorkoutViewModel;

import java.util.List;

public class WorkoutRepository {
    private final WorkoutDao workoutDao;
    private final LiveData<List<workout>> allWorkouts;

    public WorkoutRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        this.workoutDao = database.workoutDao();
        this.allWorkouts = workoutDao.getAllWorkouts();
    }

    public void insert(workout workout) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            workoutDao.insert(workout);
        });
    }

    public void insertAll(workout... workouts) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            workoutDao.insertAll(workouts);
        });
    }

    public void update(workout workout) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            workoutDao.update(workout);
        });
    }

    public void delete(workout workout) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            workoutDao.delete(workout);
        });
    }

    public LiveData<List<workout>> getAllWorkouts() {
        return allWorkouts;
    }

    public LiveData<workout> getWorkoutById(int workoutId) {
        return workoutDao.getWorkoutById(workoutId);
    }
}