package com.busanit.ch17_todo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "testdb", null, 1) {
  override fun onCreate(db: SQLiteDatabase?) {
    db?.execSQL("create table TODO_TB("+
      "_id integer primary key autoincrement, " +
      "todo text not null)")
  }

  override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    db?.execSQL("drop table if exists TODO_TB")
    onCreate(db)
  }
}