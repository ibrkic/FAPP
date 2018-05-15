package com.app.fitness.fapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.util.Constants;

import java.util.List;

@Dao
public interface ExerciseDAO {

    @Query("SELECT * FROM Exercise")
    List<Exercise> getAll();

    @Insert
    void insert(Exercise exercise);
}
