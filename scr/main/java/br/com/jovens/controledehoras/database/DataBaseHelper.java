package br.com.jovens.controledehoras.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.jovens.controledehoras.database.ControleHorasContract.TabelaApontamento;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ControleHoras.db";
	
	private static final String TEXT_TYPE = "TEXT";
	private static final String INTEGER_TYPE = "INTEGER";
	private static final String NULL_TYPE = "NULL";
	private static final String REAL_TYPE = "REAL";
	private static final String BLOB_TYPE = "BLOB";	
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_APONTAMENTO = 
			"CREATE TABLE " + TabelaApontamento.TABLE_NAME + " (" +
					TabelaApontamento._ID + INTEGER_TYPE + "PRIMARY KEY" + COMMA_SEP +
					TabelaApontamento.COLUMN_NAME_DATA + TEXT_TYPE + COMMA_SEP +
					TabelaApontamento.COLUMN_NAME_MINUTOS + INTEGER_TYPE + COMMA_SEP +
			" )";
	
	private static final String SQL_DROP_APONTAMENTO = 
			"DROP TABLE IF EXISTS " + TabelaApontamento.TABLE_NAME;
	
	
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
