package com.fernandoapeguero.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by nico on 7/17/2017.
 */

public class HabitContract {

    public class habitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit";

        public final static String _ID = BaseColumns._ID;
        public final static String EXERCISE_NAME = "name";
        public final static String EXERCISE_DURATION = "duration";
        public final static String EXERCISE_ROUND = "round";

    }
}
