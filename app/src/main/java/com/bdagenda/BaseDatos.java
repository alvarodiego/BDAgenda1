package com.bdagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class BaseDatos extends SQLiteOpenHelper {

	public BaseDatos(Context context, String bnombre, CursorFactory factory,
			int version) {
		super(context, bnombre, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table alumnos(ci integer primary key, nombre text, apellido text, celular integer)");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
		db.execSQL("drop table if exists alumnos");
		db.execSQL("create table alumnos(ci integer primary key, nombre text, apellido text, celular integer)");
	}

}