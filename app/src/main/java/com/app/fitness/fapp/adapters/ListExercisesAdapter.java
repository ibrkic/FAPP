package com.app.fitness.fapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fitness.fapp.R;
import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.db.entities.MuscleGroup;
import com.app.fitness.fapp.util.ListAdapterFriendlyType;

import java.util.ArrayList;
import java.util.List;

public class ListExercisesAdapter extends RecyclerView.Adapter<ListExercisesAdapter.ViewHolder> {

    private List<? extends ListAdapterFriendlyType> muscleGroupsOrExcercise = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView exerciseName;

        public ViewHolder(TextView v) {
            super(v);
            exerciseName = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListExercisesAdapter(List<? extends ListAdapterFriendlyType> muscleGroups) {
        this.muscleGroupsOrExcercise = muscleGroups;
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
}
