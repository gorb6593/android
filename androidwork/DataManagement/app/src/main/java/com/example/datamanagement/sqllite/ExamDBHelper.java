package com.example.datamanagement.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExamDBHelper extends SQLiteOpenHelper {

    public ExamDBHelper(Context context){
        super(context,"exam.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table product("
                + "_id integer primary key autoincrement,"
                + "name text not null, "
                + "price integer not null, "
                + "su integer not null, "
                + "totPrice integer not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
