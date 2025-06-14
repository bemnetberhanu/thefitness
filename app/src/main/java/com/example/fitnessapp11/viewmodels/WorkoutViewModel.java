package com.example.fitnessapp11.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.repositories.WorkoutRepository;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {
    private WorkoutRepository repository;
    private LiveData<List<workout>> allWorkouts;

    public WorkoutViewModel(Application application) {
        super(application);
        repository = new WorkoutRepository(application);
        allWorkouts = repository.getAllWorkouts();
    }

    public void insert(workout workout) {
        repository.insert(workout);
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

    // Add to existing ViewModel class
    public LiveData<workout> getWorkoutById(int workoutId) {
        return repository.getWorkoutById(workoutId);
    }

    public void updateWorkout(workout workout) {
        repository.update(workout);
    }
}
