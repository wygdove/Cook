package com.cook.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CookSQLiteOpenHelper extends SQLiteOpenHelper {

	public CookSQLiteOpenHelper(Context context) {
		super(context, "cook2_db.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS dishes (_id integer primary key autoincrement, name varchar(20),material varchar(20),introduce varchar(100),way varchar(120),image blob)");
		db.execSQL("CREATE TABLE IF NOT EXISTS user (_id integer primary key autoincrement, name varchar(10),password varchar(20))");
		db.execSQL("CREATE TABLE IF NOT EXISTS collect (_id integer primary key autoincrement, userid varchar(10),dishesid varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS dishes");
		db.execSQL("DROP TABLE IF EXISTS user");
		db.execSQL("DROP TABLE IF EXISTS collect");
		onCreate(db);
	}

}
