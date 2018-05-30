package com.app.fitness.fapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.util.Log;

import com.app.fitness.fapp.db.entities.Exercise;
import com.app.fitness.fapp.util.Constants;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface ExerciseDAO {

    @Query("SELECT * FROM Exercise")
    List<Exercise> getAll();

    @Insert
    void insert(Exercise exercise);

    @Insert
    void insertAll(Exercise... exercises);

    @Query("SELECT * FROM Exercise WHERE lower(name) LIKE '%' || lower(:name) || '%'")
    List<Exercise> getExerciseByName(String name);

    @Query("SELECT * FROM Exercise WHERE muscleGroupId = :muscleGroupId")
    List<Exercise> getExerciseByMuscleGroup(int muscleGroupId);
}
