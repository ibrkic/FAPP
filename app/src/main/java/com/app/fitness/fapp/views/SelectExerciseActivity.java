package com.app.fitness.fapp.views;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.app.fitness.fapp.R;
import com.app.fitness.fapp.adapters.ListExercisesAdapter;
import com.app.fitness.fapp.db.DatabaseHolder;
import com.app.fitness.fapp.db.dao.MuscleGroupDAO;
import com.app.fitness.fapp.db.entities.MuscleGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectExerciseActivity extends FragmentActivity {

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
        new AgentAsyncTask(this).execute();
    }

    private class AgentAsyncTask extends AsyncTask<Void, Void, List<MuscleGroup>> {

        //Prevent leak
        private WeakReference<Activity> weakActivity;

        public AgentAsyncTask(Activity activity) {
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
}
