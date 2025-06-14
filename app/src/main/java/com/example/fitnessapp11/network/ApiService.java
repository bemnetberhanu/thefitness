package com.example.fitnessapp11.network;

import com.example.fitnessapp11.models.workout;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("workouts")
    Call<List<workout>> getAllWorkouts();

    @POST("workouts")
    Call<workout> createWorkout(@Body workout workout);
}
