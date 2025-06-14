// adapters/WorkoutAdapter.java
package com.example.fitnessapp11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp11.R;
import com.example.fitnessapp11.models.workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private List<workout> workouts = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(workout workout);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        workout currentWorkout = workouts.get(position);
        holder.textViewName.setText(currentWorkout.getName());
        holder.textViewDuration.setText(String.valueOf(currentWorkout.getDuration()));
        holder.textViewDifficulty.setText(currentWorkout.getDifficulty());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null && position != RecyclerView.NO_POSITION) {
                listener.onItemClick(workouts.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public void setWorkouts(List<workout> workouts) {
        this.workouts = workouts;
        notifyDataSetChanged();
    }

    static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDuration;
        private TextView textViewDifficulty;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);
            textViewDifficulty = itemView.findViewById(R.id.textViewDifficulty);
        }
    }
}