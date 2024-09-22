package com.ismailmesutmujde.kotlinstoragesqlite.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, "guide", null,1) {


    // This is where tables in the database are created.
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE persons (person_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",person_name TEXT,person_phone TEXT,person_age INTEGER,person_height DOUBLE);")
    }

    // What to do if a problem occurs in the database or it is deleted is specified here
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS persons")
        onCreate(db)
    }


}