package com.fernandoapeguero.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fernandoapeguero.habittracker.data.HabitDbHelper;
import com.fernandoapeguero.habittracker.data.HabitContract.habitEntry;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper hDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hDBHelper = new HabitDbHelper(this);

        displayDatabaseInfo();
    }

    public void displayDatabaseInfo(){

        SQLiteDatabase db = hDBHelper.getReadableDatabase();

        String[] projection = {
                habitEntry._ID,
                habitEntry.EXERCISE_NAME,
                habitEntry.EXERCISE_DURATION,
                habitEntry.EXERCISE_ROUND
        };


        Cursor cursor = db.query(habitEntry.TABLE_NAME,projection,null,null,null,null,null);

        TextView displayView = (TextView) findViewById(R.id.text_view_displayer);

        try {

            displayView.setText(" The habit table contains " + cursor.getCount() + " Habits.\n\n");
            displayView.append(habitEntry._ID + " - "
            + habitEntry.EXERCISE_NAME + " - "
            + habitEntry.EXERCISE_DURATION + " - "
            + habitEntry.EXERCISE_ROUND + "\n");

            int idColumnIndex = cursor.getColumnIndex(habitEntry._ID);
            int exerciseColumnIndex = cursor.getColumnIndex(habitEntry.EXERCISE_NAME);
            int durationColumnIndex = cursor.getColumnIndex(habitEntry.EXERCISE_DURATION);
            int roundColumnIndex = cursor.getColumnIndex(habitEntry.EXERCISE_ROUND);

            while (cursor.moveToNext()){

                int currentId = cursor.getInt(idColumnIndex);
                String currentExercise = cursor.getString(exerciseColumnIndex);
                int currentDuration = cursor.getInt(durationColumnIndex);
                int currentRound = cursor.getInt(roundColumnIndex);

                displayView.append("\n" + currentId + " - "
                + currentExercise + " - "
                + currentDuration + " - "
                + currentRound);
            }

        }finally {
            cursor.close();
        }

    }

    public void insertHabitInfo (){

        SQLiteDatabase db = hDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(habitEntry.EXERCISE_NAME, "Max Cardio");
        values.put(habitEntry.EXERCISE_DURATION, "12");
        values.put(habitEntry.EXERCISE_ROUND, "4" );

        db.insert(habitEntry.TABLE_NAME,null,values);
    }
}
