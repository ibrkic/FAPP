package com.app.fitness.fapp.db.services;

import android.os.AsyncTask;

import com.app.fitness.fapp.MainActivity;
import com.app.fitness.fapp.db.entities.Exercise;

import java.lang.ref.WeakReference;


public class ExerciseService {
/*
    public static void insertExercise(MainActivity activity, Exercise exercise) {
        new InsertTask(activity, exercise).execute();
    }

    private static class InsertTask extends AsyncTask<Void,Void,Boolean> {

        private WeakReference<MainActivity> activityReference;
        private Exercise exercise;

        // only retain a weak reference to the activity
        InsertTask(MainActivity context, Exercise exercise) {
            activityReference = new WeakReference<>(context);
            this.exercise = exercise;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            activityReference.get().getExerciseDatabase().getExerciseDao().insert(exercise);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().setResult(exercise,1);
            }
        }

    }*/
}
