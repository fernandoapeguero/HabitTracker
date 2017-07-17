package com.fernandoapeguero.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fernandoapeguero.habittracker.data.HabitContract.habitEntry;

/**
 * Created by nico on 7/17/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private final static String LOG_TAG = HabitDbHelper.class.getName();

    private final static String DATABASE_NAME = "habit.db";
    private final static int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + habitEntry.TABLE_NAME + " ("
                + habitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + habitEntry.EXERCISE_NAME + " TEXT NOT NULL, "
                + habitEntry.EXERCISE_DURATION + " INTEGER NOT NULL DEFAULT 0, "
                + habitEntry.EXERCISE_ROUND + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABIT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
