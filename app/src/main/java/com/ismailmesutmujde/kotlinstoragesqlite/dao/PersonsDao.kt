package com.ismailmesutmujde.kotlinstoragesqlite.dao

import android.content.ContentValues
import com.ismailmesutmujde.kotlinstoragesqlite.datamodel.Persons
import com.ismailmesutmujde.kotlinstoragesqlite.sqlite.DatabaseHelper

class PersonsDao {

    fun insertPerson(dbh: DatabaseHelper, person_name:String, person_phone:String, person_age:Int, person_height:Double) {
        val db = dbh.writableDatabase

        val values = ContentValues()

        values.put("person_name", person_name)
        values.put("person_phone", person_phone)
        values.put("person_age", person_age)
        values.put("person_height", person_height)

        db.insertOrThrow("persons", null, values)
        db.close()
    }


}