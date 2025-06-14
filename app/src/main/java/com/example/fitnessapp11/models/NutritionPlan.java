package com.example.fitnessapp11.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// models/NutritionPlan.java
@Entity(tableName = "nutrition_plans")
public class NutritionPlan {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int calories;
    private String mealType;
    private String dietaryTags;



    public NutritionPlan(String muscleGain, String highProteinMeals, int i, String allDay, String mealType) {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDietaryTags() {
        return dietaryTags;
    }

    public void setDietaryTags(String dietaryTags) {
        this.dietaryTags = dietaryTags;
    }

    // Constructor, getters, setters...
}

