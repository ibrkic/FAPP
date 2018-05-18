package com.app.fitness.fapp.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;

import com.app.fitness.fapp.util.Constants;
import com.app.fitness.fapp.util.ListAdapterFriendlyType;

@Entity(foreignKeys = @ForeignKey(entity = MuscleGroup.class, parentColumns = "id", childColumns = "muscleGroupId", onDelete = ForeignKey.CASCADE))
public class Exercise implements ListAdapterFriendlyType {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    private int muscleGroupId;

    public Exercise(String name, int muscleGroupId) {
        this.name = name;
        this.muscleGroupId = muscleGroupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
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

    public static Exercise[] populateData() {
        return new Exercise[] {
                //Shoulders
                new Exercise("Arnold Dumbbell Press", 1),
                new Exercise("Behind The Neck Barbell Press", 1),
                new Exercise("Cable Face Pull", 1),
                new Exercise("Front Dumbell Raise", 1),
                new Exercise("Hammer Strength Shoulder Press", 1),
                new Exercise("Lateral Dumbbell Raise", 1),
                new Exercise("Lateral Machine Raise", 1),
                new Exercise("Log Press", 1),
                new Exercise("One-Arm Standing Dumbbell Press", 1),
                new Exercise("Overhead Press", 1),
                new Exercise("Push Press", 1),
                new Exercise("Rear Delt Dumbbell Raise", 1),
                new Exercise("Rear Delt Machine Fly", 1),
                new Exercise("Seated Dumbbell Lateral Raise", 1),
                new Exercise("Seated Dumbbell Press", 1),
                new Exercise("Smith Machine Overhead Press", 1),
                //Triceps
                new Exercise("Cable Overhead Triceps Extension", 2),
                new Exercise("Close Grip Barbell Bench Press", 2),
                new Exercise("Dumbbell Overhead Triceps Extension", 2),
                new Exercise("EZ-Bar Skullcrusher", 2),
                new Exercise("Lying Triceps Extension", 2),
                new Exercise("Parallel Bar Triceps Dip", 2),
                new Exercise("Ring Dip", 2),
                new Exercise("Rope Push Down", 2),
                new Exercise("Smith Machine Close Grip Bench Press", 2),
                new Exercise("V-Bar Push Down", 2),
                //Biceps
                new Exercise("Barbell Curl", 3),
                new Exercise("Cable Curl", 3),
                new Exercise("Dumbbell Concentration Curl", 3),
                new Exercise("Dumbbell Curl", 3),
                new Exercise("Dumbbell Hammer Curl", 3),
                new Exercise("Dumbbell Preacher Curl", 3),
                new Exercise("EZ-Bar Curl", 3),
                new Exercise("EZ-Bar Preacher Curl", 3),
                new Exercise("Seated Incline Dumbbell Curl", 3),
                new Exercise("Seated Machine Curl", 3),
                //Chest
                new Exercise("Cable Crossover", 4),
                new Exercise("Decline Barbell Bench Press", 4),
                new Exercise("Decline Hammer Strength Chest Press", 4),
                new Exercise("Flat Barbell Bench Press", 4),
                new Exercise("Flat Dumbbell Bench Press", 4),
                new Exercise("Flat Dumbbell Fly", 4),
                new Exercise("Incline Barbell Bench Press", 4),
                new Exercise("Incline Dumbbell Bench Press", 4),
                new Exercise("Incline Dumbbell Fly", 4),
                new Exercise("Incline Hammer Strength Chest Press", 4),
                new Exercise("Seated Machine Fly", 4),
                //Back
                new Exercise("Barbell Row", 5),
                new Exercise("Barbell Shrug", 5),
                new Exercise("Chin Up", 5),
                new Exercise("DeadLift", 5),
                new Exercise("Dumbbell Row", 5),
                new Exercise("Good Morning", 5),
                new Exercise("Hammer Strength Row", 5),
                new Exercise("Lat Pulldown", 5),
                new Exercise("Machine Shrug", 5),
                new Exercise("Neutral Chin Up", 5),
                new Exercise("Pendlay Row", 5),
                new Exercise("Pull Up", 5),
                new Exercise("Rack Pull", 5),
                new Exercise("Seated Cable Row", 5),
                new Exercise("Straight-Arm Cable Pushdown", 5),
                new Exercise("T-Bar Row", 5),
                //Legs
                new Exercise("Barbell Calf Raise", 6),
                new Exercise("Barbell Front Squat", 6),
                new Exercise("Barbell Glute Bridge", 6),
                new Exercise("Barbell Squat", 6),
                new Exercise("Donkey Calf Raise", 6),
                new Exercise("Glute-Ham Raise", 6),
                new Exercise("Leg Extension Machine", 6),
                new Exercise("Leg Press", 6),
                new Exercise("Lying Leg Curl Machine", 6),
                new Exercise("Romanian Deadlift", 6),
                new Exercise("Seated Calf Raise Machine", 6),
                new Exercise("Seated Leg Curl Machine", 6),
                new Exercise("Standing Calf Raise Machine", 6),
                new Exercise("Stiff-Legged Deadlift", 6),
                new Exercise("Sumo Deadlift", 6),
                //Abs
                new Exercise("Ab-Wheel Rollout", 7),
                new Exercise("Cable Crunch", 7),
                new Exercise("Crunch", 7),
                new Exercise("Crunch Machine", 7),
                new Exercise("Decline Crunch", 7),
                new Exercise("Dragon Flag", 7),
                new Exercise("Hanging Knee Raise", 7),
                new Exercise("Hanging Leg Raise", 7),
                new Exercise("Plank", 7),
                new Exercise("Side Plank", 7),
                //Cardio
                new Exercise("Cycling", 8),
                new Exercise("Elliptical Trainer", 8),
                new Exercise("Rowing Machine", 8),
                new Exercise("Running (Outdoor)", 8),
                new Exercise("Running (Treadmill)", 8),
                new Exercise("Stationary Bike", 8),
                new Exercise("Swimming", 8),
                new Exercise("Walking", 8)
        };
    }
}
