package com.app.fitness.fapp.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fitness.fapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkoutLogFragment extends Fragment {

    @BindView(R.id.textView)
    TextView title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_workout_log, container, false);
        ButterKnife.bind(this, rootView);
        title.setText("TEST");
        return rootView;
    }

}
