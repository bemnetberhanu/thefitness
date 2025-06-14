package com.example.fitnessapp11.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.fitnessapp11.database.AppDatabase;
import com.example.fitnessapp11.database.WorkoutDao;
import com.example.fitnessapp11.models.workout;

import java.util.List;

public class WorkoutRepository {
    private WorkoutDao workoutDao;
    private LiveData<List<workout>> allWorkouts;

    public WorkoutRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        workoutDao = database.workoutDao();
        allWorkouts = workoutDao.getAllWorkouts();
    }

    // Insert operation
    public void insert(workout workout) {
        new InsertWorkoutAsyncTask(workoutDao).execute(workout);
    }

    // Update operation
    public void update(workout workout) {
        new UpdateWorkoutAsyncTask(workoutDao).execute(workout);
    }

    // Delete operation
    public void delete(workout workout) {
        new DeleteWorkoutAsyncTask(workoutDao).execute(workout);
    }

    // Get all workouts
    public LiveData<List<workout>> getAllWorkouts() {
        return allWorkouts;
    }

    // Get workout by ID
    public LiveData<workout> getWorkoutById(int workoutId) {
        return workoutDao.getWorkoutById(workoutId);
    }

    // AsyncTask for insert operation
    private static class InsertWorkoutAsyncTask extends AsyncTask<workout, Void, Void> {
        private WorkoutDao workoutDao;

        private InsertWorkoutAsyncTask(WorkoutDao workoutDao) {
            this.workoutDao = workoutDao;
        }

        @Override
        protected Void doInBackground(workout... workouts) {
            workoutDao.insert(workouts[0]);
            return null;
        }
    }

    // AsyncTask for update operation
    private static class UpdateWorkoutAsyncTask extends AsyncTask<workout, Void, Void> {
        private WorkoutDao workoutDao;

        private UpdateWorkoutAsyncTask(WorkoutDao workoutDao) {
            this.workoutDao = workoutDao;
        }

        @Override
        protected Void doInBackground(workout... workouts) {
            workoutDao.update(workouts[0]);
            return null;
        }
    }

    // AsyncTask for delete operation
    private static class DeleteWorkoutAsyncTask extends AsyncTask<workout, Void, Void> {
        private WorkoutDao workoutDao;

        private DeleteWorkoutAsyncTask(WorkoutDao workoutDao) {
            this.workoutDao = workoutDao;
        }

        @Override
        protected Void doInBackground(workout... workouts) {
            workoutDao.delete(workouts[0]);
            return null;
        }
    }
}