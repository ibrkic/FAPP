package com.app.fitness.fapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MuscleGroup {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public MuscleGroup(String name) {
        this.name = name;
    }

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

    public static MuscleGroup[] populateData() {
        return new MuscleGroup[] {
                new MuscleGroup("Shoulders"),
                new MuscleGroup("Triceps"),
                new MuscleGroup("Biceps"),
                new MuscleGroup("Chest"),
                new MuscleGroup("Back"),
                new MuscleGroup("Legs"),
                new MuscleGroup("Abs"),
                new MuscleGroup("Cardio")
        };
    }
}
