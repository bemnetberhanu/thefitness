// adapters/WorkoutAdapter.java
package com.example.fitnessapp11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.fitnessapp11.R;
import com.example.fitnessapp11.models.workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private List<workout> workouts;
    private final WorkoutClickListener clickListener;
    private final Context context;

    public interface WorkoutClickListener {
        void onWorkoutClick(workout workout);
    }

    public WorkoutAdapter(Context context, WorkoutClickListener clickListener) {
        this.context = context.getApplicationContext(); // Use application context
        this.clickListener = clickListener;
        this.workouts = new ArrayList<>();
    }

    public void setWorkouts(List<workout> workouts) {
        this.workouts = workouts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        workout workout = workouts.get(position);
        holder.bind(workout);
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public interface OnItemClickListener {
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private final ImageView thumbnail;
        private final TextView title;
        private final TextView duration;
        private final TextView difficulty;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.workout_thumbnail);
            title = itemView.findViewById(R.id.workout_title);
            duration = itemView.findViewById(R.id.workout_duration);
            difficulty = itemView.findViewById(R.id.workout_difficulty);
        }

        public void bind(workout workout) {
            title.setText(workout.getName());
            duration.setText(formatDuration(workout.getDuration()));
            difficulty.setText(workout.getDifficulty());

            // Load YouTube thumbnail
            Glide.with(context)
                    .load(workout.getThumbnailUrl())
                    .placeholder(R.drawable.ic_fitness_placeholder)
                    .error(R.drawable.ic_broken_image)
                    .into(thumbnail);

            itemView.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onWorkoutClick(workout);
                }
            });
        }

        private String formatDuration(int minutes) {
            return minutes > 60 ?
                    String.format(Locale.getDefault(), "%dh %02dm", minutes/60, minutes%60) :
                    String.format(Locale.getDefault(), "%d min", minutes);
        }
    }
}