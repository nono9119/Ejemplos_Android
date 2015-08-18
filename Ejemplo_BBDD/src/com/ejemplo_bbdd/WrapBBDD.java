package com.ejemplo_bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WrapBBDD extends SQLiteOpenHelper {
	final private static int BBDD_VERSION = 1;
	private static final String BBDD_NAME = "BBDDTradicional";
	static final String TITULO = "titulo";
	static final String VALOR = "valor";
	static final String BBDD_TABLA_VALORES = "valores";
	
	public WrapBBDD(Context context) {
		super(context, BBDD_NAME, null, BBDD_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+BBDD_TABLA_VALORES+
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, valor INTEGER)");
		
		// DATOS DE PRUEBA
		ContentValues cv = new ContentValues();
		cv.put(TITULO, "TITULO 1");
		cv.put(VALOR, 1);
		db.insert(BBDD_TABLA_VALORES, TITULO, cv);
		
		cv.put(TITULO, "TITULO 2");
		cv.put(VALOR, 2);
		db.insert(BBDD_TABLA_VALORES, TITULO, cv);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//android.util.Log.w(BBDD_TABLA_VALORES, "Actualizando la BBDD: BBDDTradicional");
		db.execSQL("DROP TABLE IF EXISTS " + BBDD_TABLA_VALORES);
		onCreate(db);
	}
	
}
