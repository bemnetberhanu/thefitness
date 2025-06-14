package com.example.fitnessapp11.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.fitnessapp11.R;
import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.viewmodels.WorkoutViewModel;

public class EditWorkoutFragment extends Fragment {
    private WorkoutViewModel workoutViewModel;
    private int workoutId;
    private workout currentWorkout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            workoutId = getArguments().getInt("workoutId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_workout, container, false);

        // Initialize ViewModel
        workoutViewModel = new ViewModelProvider(requireActivity()).get(WorkoutViewModel.class);

        // Get UI references
        EditText nameEditText = view.findViewById(R.id.editTextName);
        EditText durationEditText = view.findViewById(R.id.editTextDuration);
        EditText difficultyEditText = view.findViewById(R.id.editTextDifficulty);
        EditText descriptionEditText = view.findViewById(R.id.editTextDescription);
        Button saveButton = view.findViewById(R.id.buttonSave);

        // Load current workout data
        workoutViewModel.getWorkoutById(workoutId).observe(getViewLifecycleOwner(), workout -> {
            if (workout != null) {
                currentWorkout = workout;
                nameEditText.setText(workout.getName());
                durationEditText.setText(String.valueOf(workout.getDuration()));
                difficultyEditText.setText(workout.getDifficulty());
                descriptionEditText.setText(workout.getDescription());
            }
        });

        // Save button click handler
        saveButton.setOnClickListener(v -> {
            if (currentWorkout != null) {
                // Update workout object
                currentWorkout.setName(nameEditText.getText().toString());
                currentWorkout.setDuration(Integer.parseInt(durationEditText.getText().toString()));
                currentWorkout.setDifficulty(durationEditText.getText().toString());
                currentWorkout.setDescription(descriptionEditText.getText().toString());

                // Save to database
                workoutViewModel.update(currentWorkout);

                // Show confirmation and navigate back
                Toast.makeText(getContext(), "Workout updated", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).popBackStack();
            }
        });

        return view;
    }
}
