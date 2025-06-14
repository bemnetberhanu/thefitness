package com.example.fitnessapp11.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.fitnessapp11.R;
import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.viewmodels.WorkoutViewModel;

public class WorkoutDetailFragment extends Fragment {
    private WorkoutViewModel workoutViewModel;
    private int workoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get workout ID from navigation arguments
        if (getArguments() != null) {
            workoutId = getArguments().getInt("workoutId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_detail, container, false);

        // Initialize ViewModel
        workoutViewModel = new ViewModelProvider(requireActivity()).get(WorkoutViewModel.class);

        // UI Elements
        TextView nameTextView = view.findViewById(R.id.textViewWorkoutName);
        TextView durationTextView = view.findViewById(R.id.textViewDuration);
        TextView difficultyTextView = view.findViewById(R.id.textViewDifficulty);
        TextView descriptionTextView = view.findViewById(R.id.textViewDescription);
        Button deleteButton = view.findViewById(R.id.buttonDelete);
        Button editButton = view.findViewById(R.id.buttonEdit);

        // Observe workout data
        workoutViewModel.getWorkoutById(workoutId).observe(getViewLifecycleOwner(), workout -> {
            if (workout != null) {
                nameTextView.setText(workout.getName());
                durationTextView.setText(getString(R.string.duration_format, workout.getDuration()));
                difficultyTextView.setText(workout.getDifficulty());
                descriptionTextView.setText(workout.getDescription());
            }
        });

        // Delete button click handler
        deleteButton.setOnClickListener(v -> {
            workoutViewModel.getWorkoutById(workoutId).observe(getViewLifecycleOwner(), workout -> {
                if (workout != null) {
                    workoutViewModel.delete(workout);
                    Toast.makeText(getContext(), "Workout deleted", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).popBackStack();
                }
            });
        });

        // Edit button click handler
        editButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("workoutId", workoutId);
            Navigation.findNavController(v).navigate(
                    R.id.action_workoutDetailFragment_to_editWorkoutFragment,
                    bundle
            );
        });

        return view;
    }

}
