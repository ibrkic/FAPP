package com.app.fitness.fapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;

import com.app.fitness.fapp.util.Constants;

@Entity(foreignKeys = @ForeignKey(entity = MuscleGroup.class, parentColumns = "id", childColumns = "muscleGroupId", onDelete = ForeignKey.CASCADE))
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    private int muscleGroupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMuscleGroupId() {
        return muscleGroupId;
    }

    public void setMuscleGroupId(int muscleGroupId) {
        this.muscleGroupId = muscleGroupId;
    }
}
