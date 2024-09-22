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

    fun allPersons(db:DatabaseHelper) : ArrayList<Persons> {
        val personsArrayList = ArrayList<Persons>()
        val db = db.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM persons",null)

        while (cursor.moveToNext()) {

            val person = Persons(cursor.getInt(cursor.getColumnIndexOrThrow("person_id"))
                ,cursor.getString(cursor.getColumnIndexOrThrow("person_name"))
                ,cursor.getString(cursor.getColumnIndexOrThrow("person_phone"))
                ,cursor.getInt(cursor.getColumnIndexOrThrow("person_age"))
                ,cursor.getDouble(cursor.getColumnIndexOrThrow("person_height")))
            personsArrayList.add(person)
        }
        return personsArrayList
    }

    fun updatePerson(db:DatabaseHelper, person_id:Int, person_name:String, person_phone:String, person_age:Int, person_height:Double) {
        val db = db.writableDatabase
        val values = ContentValues()

        values.put("person_name", person_name)
        values.put("person_phone", person_phone)
        values.put("person_age", person_age)
        values.put("person_height", person_height)

        db.update("persons", values,"person_id=?", arrayOf(person_id.toString()))
        db.close()
    }

    fun deletePerson(db:DatabaseHelper, person_id:Int) {
        val db = db.writableDatabase
        db.delete("persons", "person_id=?", arrayOf(person_id.toString()))
        db.close()
    }

}