package br.com.jovens.controledehoras.activity.util;

import android.content.Context;
import android.widget.Toast;

public class MensagemUtil {
	
	public static void exibirMensagemLonga(Context contexto, String message) {
		Toast.makeText(contexto, message, Toast.LENGTH_LONG).show();
	}
}
