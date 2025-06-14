package com.example.fitnessapp11;  // Or the correct package name

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.fitnessapp11.activities.WorkoutPlayerActivity;
import com.example.fitnessapp11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View binding initialization
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Navigation setup
        setupNavigation();
    }

    private void setupNavigation() {
        // Get NavController from NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        // Connect BottomNavigationView with NavController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

        // Optional: Custom navigation handling
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            NavigationUI.onNavDestinationSelected(item, navController);
            return true;
        });
    }
    // From another activity
 // Intent intent = new Intent(this, WorkoutPlayerActivity.class);
// intent.putExtra("VIDEO_ID", "dQw4w9WgXcQ"); // Example video ID
 //  startActivity(intent);
}