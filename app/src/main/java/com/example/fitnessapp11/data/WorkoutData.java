package com.example.fitnessapp11.data;

import com.example.fitnessapp11.models.workout;

// data/WorkoutData.java
public class WorkoutData {
    public static workout[] populateWorkoutData() {
        return new workout[]{
                new workout("Morning Yoga", "Perfect start to your day", 15,
                        "Beginner", "Yoga", "Vao4rzD3d5w"), // Yoga With Adriene
                new workout("Full Body HIIT", "Burn fat fast", 30,
                        "Advanced", "Cardio", "ml6cT4AZdqI"), // Pamela Reif
                new workout("Strength Training", "Build muscle at home", 25,
                        "Intermediate", "Strength", "sAq_ocpRh_I"), // Caroline Girvan
                new workout("Pilates Core", "Flatten your abs", 20,
                        "Intermediate", "Core", "J2H67Ds7Hc4"), // Blogilates
                new workout("Evening Stretch", "Relax before bed", 10,
                        "Beginner", "Recovery", "4pKly2JojMw") // Sarah Beth
        };
    }
}
