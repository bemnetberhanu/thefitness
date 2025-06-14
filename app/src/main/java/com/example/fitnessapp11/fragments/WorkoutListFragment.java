// fragments/WorkoutListFragment.java
package com.example.fitnessapp11.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp11.R;
import com.example.fitnessapp11.adapters.WorkoutAdapter;
import com.example.fitnessapp11.models.workout;
import com.example.fitnessapp11.viewmodels.WorkoutViewModel;

import java.util.ArrayList;
import java.util.List;

public class WorkoutListFragment extends Fragment implements WorkoutAdapter.OnItemClickListener {
    private WorkoutViewModel workoutViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        WorkoutAdapter adapter = new WorkoutAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        workoutViewModel.getAllWorkouts().observe(getViewLifecycleOwner(), adapter::setWorkouts);




        addSampleWorkouts();
        return view;
    }

    private void addSampleWorkouts() {
        List<workout> sampleWorkouts = new ArrayList<>();

        // Add category as the 5th parameter
        sampleWorkouts.add(new workout(
                "Morning Yoga",
                "15 min relaxing routine",
                15,
                "Beginner",
                "Yoga"  // Added category
        ));

        sampleWorkouts.add(new workout(
                "Full Body HIIT",
                "Intense 30 min workout",
                30,
                "Advanced",
                "Cardio"  // Added category
        ));

        workoutViewModel.insertAll(sampleWorkouts.toArray(new workout[0]));
    }

    @Override
    public void onItemClick(workout workout) {
        Bundle args = new Bundle();
        args.putInt("workoutId", workout.getId());
        Navigation.findNavController(requireView()).navigate(
                R.id.action_workoutListFragment_to_workoutDetailFragment,
                args
        );
    }
}