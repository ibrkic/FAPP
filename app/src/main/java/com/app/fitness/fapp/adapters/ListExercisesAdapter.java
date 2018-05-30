package com.app.fitness.fapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fitness.fapp.R;
import com.app.fitness.fapp.db.DatabaseHolder;
import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.db.entities.MuscleGroup;
import com.app.fitness.fapp.util.ListAdapterFriendlyType;
import com.app.fitness.fapp.views.TrackExerciseActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ListExercisesAdapter extends RecyclerView.Adapter<ListExercisesAdapter.ViewHolder> {

    private List<? extends ListAdapterFriendlyType> muscleGroupsOrExcercise = new ArrayList<>();
    private Activity activity;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView exerciseName;

        public ViewHolder(TextView v) {
            super(v);
            exerciseName = v;
            exerciseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(muscleGroupsOrExcercise.get(getAdapterPosition()) instanceof MuscleGroup) {
                        new ExerciseAsyncTask(activity).execute(muscleGroupsOrExcercise.get(getAdapterPosition()).getId());
                    } else {
                        Intent i = new Intent(activity, TrackExerciseActivity.class);
                        activity.startActivity(i);
                    }
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListExercisesAdapter(List<? extends ListAdapterFriendlyType> muscleGroups, Activity activity) {
        this.muscleGroupsOrExcercise = muscleGroups;
        this.activity = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListExercisesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.exerciseName.setText(muscleGroupsOrExcercise.get(position).getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return muscleGroupsOrExcercise.size();
    }

    public void updateData(List<? extends ListAdapterFriendlyType> data) {
        if(data.size() > 0 && data.get(0) instanceof Exercise) {
            muscleGroupsOrExcercise.clear();
            ((List<Exercise>)muscleGroupsOrExcercise).addAll((List<Exercise>)data);
        } else {
            muscleGroupsOrExcercise.clear();
            ((List<MuscleGroup>)muscleGroupsOrExcercise).addAll((List<MuscleGroup>)data);
        }
        notifyDataSetChanged();
    }

    private class ExerciseAsyncTask extends AsyncTask<Integer, Void, List<Exercise>> {

        //Prevent leak
        private WeakReference<Activity> weakActivity;

        public ExerciseAsyncTask(Activity activity) {
            weakActivity = new WeakReference<>(activity);
        }

        @Override
        protected List<Exercise> doInBackground(Integer... params) {
            return DatabaseHolder.getInstance(weakActivity.get()).getExerciseDao().getExerciseByMuscleGroup(params[0]);
        }

        @Override
        protected void onPostExecute(List<Exercise> exercises) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return;
            }
            updateData(exercises);
        }
    }
}
