package com.example.fitnessapp11.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.fitnessapp11.models.UserProfile;

public class ProfileViewModel extends AndroidViewModel {
    private UserProfileRepository repository;
    private LiveData<UserProfile> profile;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        repository = new UserProfileRepository(application);
        profile = repository.getProfile();
    }

    public void saveProfile(UserProfile userProfile) {
        repository.updateProfile(userProfile);
    }

    public LiveData<Double> getBMIObservable() {
        return Transformations.map(profile, UserProfile::calculateBMI);
    }
}
