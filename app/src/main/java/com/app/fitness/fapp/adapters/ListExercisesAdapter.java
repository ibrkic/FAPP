package com.app.fitness.fapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fitness.fapp.R;
import com.app.fitness.fapp.db.entities.MuscleGroup;

import java.util.List;

public class ListExercisesAdapter extends RecyclerView.Adapter<ListExercisesAdapter.ViewHolder> {

    private List<MuscleGroup> muscleGroups;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView exerciseName;

        public ViewHolder(TextView v) {
            super(v);
            exerciseName = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListExercisesAdapter(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListExercisesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.exerciseName.setText(muscleGroups.get(position).getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return muscleGroups.size();
    }
}
