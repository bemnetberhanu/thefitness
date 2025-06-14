package com.example.fitnessapp11.models;

// data/NutritionData.java
public class NutritionData {
    public static NutritionPlan[] populateNutritionData() {
        return new NutritionPlan[]{
                new NutritionPlan("Muscle Gain", "High protein meals", 2500,
                        "All Day", "High-Protein"),
                new NutritionPlan("Weight Loss", "Low calorie plan", 1800,
                        "All Day", "Low-Carb"),
                new NutritionPlan("Vegan", "Plant-based meals", 2200,
                        "All Day", "Vegan"),
                new NutritionPlan("Keto", "High fat, low carb", 2000,
                        "All Day", "Keto")
        };
    }
}
