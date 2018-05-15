package com.app.fitness.fapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.app.fitness.fapp.db.entities.MuscleGroup;
import com.app.fitness.fapp.util.Constants;

import java.util.List;

@Dao
public interface MuscleGroupDAO {

    @Query("SELECT * FROM MuscleGroup")
    List<MuscleGroup> getAll();

    @Insert
    void insertAll(MuscleGroup... muscleGroups);
}
