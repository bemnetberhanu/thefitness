package com.example.fitnessapp11.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fitnessapp11.R;

public class NutritionFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);

        // Add basic content
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("Nutrition Tracking Coming Soon!");

        return view;
    }
}

