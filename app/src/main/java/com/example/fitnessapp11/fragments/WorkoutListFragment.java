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

public class WorkoutListFragment extends Fragment implements WorkoutAdapter.OnItemClickListener {
    private WorkoutViewModel workoutViewModel;
    private WorkoutAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new WorkoutAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);
        workoutViewModel.getAllWorkouts().observe(getViewLifecycleOwner(), workouts -> {
            adapter.setWorkouts(workouts);
        });

        return view;
    }

    @Override
    public void onItemClick(workout workout) {
        // Navigate to detail fragment with workout ID
        Bundle args = new Bundle();
        args.putInt("workoutId", workout.getId());
        Navigation.findNavController(requireView()).navigate(
                R.id.action_workoutListFragment_to_workoutDetailFragment,
                args
        );
    }
}