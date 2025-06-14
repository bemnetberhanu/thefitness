package com.example.fitnessapp11.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fitnessapp11.models.workout;
import java.util.List;

@Dao
public interface WorkoutDao {
    @Insert
    void insert(workout workout);

    @Update
    void update(workout workout);

    @Delete
    void delete(workout workout);

    @Query("DELETE FROM workouts")
    void deleteAllWorkouts();

    @Query("SELECT * FROM workouts ORDER BY createdAt DESC")
    LiveData<List<workout>> getAllWorkouts();

    @Query("SELECT * FROM workouts WHERE id = :workoutId")
    LiveData<workout> getWorkoutById(int workoutId);


}
