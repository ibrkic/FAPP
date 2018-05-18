package com.app.fitness.fapp.views;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.app.fitness.fapp.R;
import com.app.fitness.fapp.adapters.ListExercisesAdapter;
import com.app.fitness.fapp.db.DatabaseHolder;
import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.db.entities.MuscleGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectExerciseActivity extends FragmentActivity {

    @BindView(R.id.search_exercise)
    SearchView exerciseSearchView;
    @BindView(R.id.exercise_recycler_view)
    RecyclerView exerciseRv;

    private LinearLayoutManager mLayoutManager;
    private ListExercisesAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exercise);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(this);
        exerciseRv.setLayoutManager(mLayoutManager);
        new MuscleGroupAsyncTask(this).execute();
        exerciseSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() > 0) {
                    new ExerciseAsyncTask(SelectExerciseActivity.this).execute(newText);
                } else {

                }
                return false;
            }
        });
    }

    private class MuscleGroupAsyncTask extends AsyncTask<Void, Void, List<MuscleGroup>> {

        //Prevent leak
        private WeakReference<Activity> weakActivity;

        public MuscleGroupAsyncTask(Activity activity) {
            weakActivity = new WeakReference<>(activity);
        }

        @Override
        protected List<MuscleGroup> doInBackground(Void... params) {
            return DatabaseHolder.getInstance(weakActivity.get()).getMuscleGroupDao().getAll();
        }

        @Override
        protected void onPostExecute(List<MuscleGroup> muscleGroups) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return;
            }
            mAdapter = new ListExercisesAdapter(muscleGroups);
            exerciseRv.setAdapter(mAdapter);
        }
    }

    private class ExerciseAsyncTask extends AsyncTask<String, Void, List<Exercise>> {

        //Prevent leak
        private WeakReference<Activity> weakActivity;

        public ExerciseAsyncTask(Activity activity) {
            weakActivity = new WeakReference<>(activity);
        }

        @Override
        protected List<Exercise> doInBackground(String... params) {
            return DatabaseHolder.getInstance(weakActivity.get()).getExerciseDao().getExerciseByName(params[0]);
        }

        @Override
        protected void onPostExecute(List<Exercise> exercises) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return;
            }
            mAdapter.updateData(exercises);
        }
    }
}
