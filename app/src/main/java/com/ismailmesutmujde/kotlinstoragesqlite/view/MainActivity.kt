package com.ismailmesutmujde.kotlinstoragesqlite.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqlite.R
import com.ismailmesutmujde.kotlinstoragesqlite.dao.PersonsDao
import com.ismailmesutmujde.kotlinstoragesqlite.sqlite.DatabaseHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseHelper(this)

        PersonsDao().insertPerson(db, "Ahmet", "9999999", 18,1.69)
        PersonsDao().insertPerson(db, "Mehmet", "8888888", 22,1.99)
        PersonsDao().insertPerson(db, "Zeynep", "7777777", 10,1.78)
        PersonsDao().insertPerson(db, "Ali", "3333333", 35,1.50)
    }
}