package com.example.fitnessapp11.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// models/Workout.java
@Entity(tableName = "workouts")
public class workout {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int duration; // minutes
    private String difficulty;
    private String category;
    private String youtubeId;
    private String thumbnailUrl;

    public workout(String name, String description, int duration,
                   String difficulty, String category, String youtubeId) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.difficulty = difficulty;
        this.category = category;
        this.youtubeId = youtubeId;
        this.thumbnailUrl = "https://img.youtube.com/vi/" + youtubeId + "/0.jpg";
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}