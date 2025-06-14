package com.example.fitnessapp11.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fitnessapp11.database.WorkoutDao;
import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.repositories.WorkoutRepository;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {
    private final WorkoutRepository repository;
    private final LiveData<List<workout>> allWorkouts;

    public WorkoutViewModel(@NonNull Application application) {
        super(application);
        repository = new WorkoutRepository(application);
        allWorkouts = repository.getAllWorkouts();
    }

    public void insert(workout workout) {
        repository.insert(workout);
    }

    public void insertAll(workout... workouts) {
        repository.insertAll(workouts);
    }

    public void update(workout workout) {
        repository.update(workout);
    }

    public void delete(workout workout) {
        repository.delete(workout);
    }

    public LiveData<List<workout>> getAllWorkouts() {
        return allWorkouts;
    }

    public LiveData<workout> getWorkoutById(int workoutId) {
        return repository.getWorkoutById(workoutId);
    }
}