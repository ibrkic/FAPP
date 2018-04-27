package com.app.fitness.fapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.app.fitness.fapp.db.entities.Exercise;

@Database(entities = {Exercise.class}, version = 1)
public abstract class DatabaseHolder extends RoomDatabase {
}
