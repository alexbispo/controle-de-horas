package br.com.jovens.controledehoras.database;

import static br.com.jovens.controledehoras.database.ControleHorasContract.SQL_CREATE_APONTAMENTO;
import static br.com.jovens.controledehoras.database.ControleHorasContract.SQL_DROP_APONTAMENTO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ControleHoras.db";
	
	
	
	
	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_APONTAMENTO);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DROP_APONTAMENTO);
		onCreate(db);
		
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}

}
