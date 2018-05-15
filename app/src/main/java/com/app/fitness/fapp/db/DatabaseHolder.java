package com.app.fitness.fapp.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.app.fitness.fapp.db.dao.ExerciseDAO;
import com.app.fitness.fapp.db.dao.MuscleGroupDAO;
import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.db.entities.MuscleGroup;
import com.app.fitness.fapp.db.entities.UserLogExercise;
import com.app.fitness.fapp.util.Constants;

import java.util.concurrent.Executors;

@Database(entities = {MuscleGroup.class, Exercise.class, UserLogExercise.class}, version = 1)
public abstract class DatabaseHolder extends RoomDatabase {

    public abstract ExerciseDAO getExerciseDao();

    public abstract MuscleGroupDAO getMuscleGroupDao();

    private static DatabaseHolder fappDB;

    public static DatabaseHolder getInstance(Context context) {
        if (null == fappDB) {
            fappDB = buildDatabaseInstance(context);
        }
        return fappDB;
    }

    private static DatabaseHolder buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                DatabaseHolder.class,
                Constants.DB_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).getMuscleGroupDao().insertAll(MuscleGroup.populateData());
                            }
                        });
                    }
                }).build();
    }

    public void cleanUp(){
        fappDB = null;
    }
}
