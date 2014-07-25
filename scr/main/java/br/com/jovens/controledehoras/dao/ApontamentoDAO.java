package br.com.jovens.controledehoras.dao;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.controledehoras.core.beans.RegistroArquivo;
import br.com.jovens.controledehoras.database.DataBaseHelper;
import br.com.jovens.controledehoras.database.ControleHorasContract.TabelaApontamento;
import br.com.jovens.controledehoras.entity.ApontamentoEntity;

public class ApontamentoDAO {
	
	DataBaseHelper dbHelper;
	
	public ApontamentoDAO(Context context){
		dbHelper = new DataBaseHelper(context);
	}
	
	public Long save(ApontamentoEntity apontamento){
		Long newRowId = 0L;
		try {
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			
			ContentValues values = new ContentValues();
			values.put(TabelaApontamento.COLUMN_NAME_APONTAMENTO_ID, apontamento.getId());
			values.put(TabelaApontamento.COLUMN_NAME_MINUTOS, apontamento.getTempo().getMinutos());
			values.put(TabelaApontamento.COLUMN_NAME_DATA, apontamento.getData());	
			values.put(TabelaApontamento.COLUMN_NAME_HORAINICIAL, apontamento.getHoraInicial());	
			values.put(TabelaApontamento.COLUMN_NAME_HORAFINAL, apontamento.getHoraFinal());	
			
			newRowId = db.insert(TabelaApontamento.TABLE_NAME, null, values);			
			
		} catch(Exception e) {
			e.printStackTrace();
			Log.e("ERRO", e.getMessage());
		}
		return newRowId;
	}
	
	public List<RegistroArquivo> selectApontamentoByApontamento(RegistroArquivo registros){
		// Classe Registro nesse projeto pode ser uma filha da Classe da lib (APENAS SUGESTÃO)
		//TODO: Retornar lista de registros de acordo com a data, horainicial e horafinal
		return null;
	}
	
	
}
