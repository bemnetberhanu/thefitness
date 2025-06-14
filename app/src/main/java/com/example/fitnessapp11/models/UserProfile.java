package com.example.fitnessapp11.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// models/UserProfile.java
@Entity(tableName = "user_profiles")
public class UserProfile {
    @PrimaryKey
    private int id = 1; // Single profile

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    private double height; // in cm
    private double weight; // in kg
    private double targetWeight;
    private String fitnessGoal;
    private int dailyCalories;

    // Getters, setters, and helper methods
    public double calculateBMI() {
        return weight / ((height / 100) * (height / 100));
    }
}



