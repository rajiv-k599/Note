package com.example.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Table columns
    public static final String TABLE_NAME="COUNTRIES";
    public static final String _ID="_id";
    public static final String SUBJECT="subject";
    public static final String DESC="description";

    //databse Information
    public static final String DB_Name="Note.DB";

    //database version
    public static final int DB_version=1;

    //Creating table
    public static final String CREATE_TABLE="create table " +TABLE_NAME+ "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SUBJECT +" TEXT NOT NULL," + DESC + " TEXT);";

    //constructor
    public DatabaseHelper(Context context){
        super(context, DB_Name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Executing the query
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
