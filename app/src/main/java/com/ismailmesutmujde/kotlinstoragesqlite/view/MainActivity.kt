package com.ismailmesutmujde.kotlinstoragesqlite.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqlite.R
import com.ismailmesutmujde.kotlinstoragesqlite.dao.PersonsDao
import com.ismailmesutmujde.kotlinstoragesqlite.datamodel.Persons
import com.ismailmesutmujde.kotlinstoragesqlite.sqlite.DatabaseHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseHelper(this)

        //PersonsDao().insertPerson(db, "Ahmet", "9999999", 18,1.69)
        //PersonsDao().insertPerson(db, "Mehmet", "8888888", 22,1.99)
        //PersonsDao().insertPerson(db, "Zeynep", "7777777", 10,1.78)
        //PersonsDao().insertPerson(db, "Ali", "3333333", 35,1.50)

        /*
        PersonsDao().insertPerson(db, "İsmail", "5555555", 34,1.80)
        PersonsDao().insertPerson(db, "Merve", "2121212", 25,1.63)
        PersonsDao().insertPerson(db, "Zeynep", "7777777", 16,1.59)
        PersonsDao().insertPerson(db, "Ayşe", "44444444", 49,1.70)
        PersonsDao().insertPerson(db, "Mesut", "66666666", 23,1.83)
         */

        //PersonsDao().updatePerson(db, 3, "New Zeynep", "1111111",100,1.22)
        //PersonsDao().deletePerson(db, 3)


        val result = PersonsDao().recordControl(db, "İsmail")
        Log.e("Record Control", result.toString())


        val personList = PersonsDao().allPersons(db)
        //val personList = PersonsDao().search(db,"met")
        //val personList = PersonsDao().randomlyBring5People(db)

        for (p in personList) {
            Log.e("****************","****************")
            Log.e("Person id", (p.person_id).toString())
            Log.e("Person name", p.person_name)
            Log.e("Person phone",p.person_phone)
            Log.e("Person age", (p.person_age).toString())
            Log.e("Person height", (p.person_height).toString())
        }
    }
}