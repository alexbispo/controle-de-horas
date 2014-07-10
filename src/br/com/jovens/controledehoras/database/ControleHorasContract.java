package br.com.jovens.controledehoras.database;

import android.provider.BaseColumns;

public final class ControleHorasContract {
	
	public static final String TEXT_TYPE = "TEXT";
	public static final String INTEGER_TYPE = "INTEGER";
	public static final String NULL_TYPE = "NULL";
	public static final String REAL_TYPE = "REAL";
	public static final String BLOB_TYPE = "BLOB";	
	public static final String COMMA_SEP = ",";
	
	public static final String SQL_CREATE_APONTAMENTO = 
			"CREATE TABLE " + TabelaApontamento.TABLE_NAME + " (" +
					TabelaApontamento._ID + INTEGER_TYPE + "PRIMARY KEY" + COMMA_SEP +
					TabelaApontamento.COLUMN_NAME_DATA + TEXT_TYPE + COMMA_SEP +
					TabelaApontamento.COLUMN_NAME_MINUTOS + INTEGER_TYPE + COMMA_SEP +
			" )";
	
	public static final String SQL_DROP_APONTAMENTO = 
			"DROP TABLE IF EXISTS " + TabelaApontamento.TABLE_NAME;
	
	public ControleHorasContract() {}
	
	public abstract class TabelaApontamento implements BaseColumns {
		public static final String TABLE_NAME = "apontamento";
		public static final String COLUMN_NAME_APONTAMENTO_ID = "apontamentoid";
		public static final String COLUMN_NAME_MINUTOS = "minutos";
		public static final String COLUMN_NAME_DATA = "data";		
		
	}
	
}
