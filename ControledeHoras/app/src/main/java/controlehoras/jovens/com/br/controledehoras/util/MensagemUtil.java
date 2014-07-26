package controlehoras.jovens.com.br.controledehoras.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Fabio on 25/07/2014.
 */
public class MensagemUtil {

    public static void exibirMensagemLonga(Context contexto, String message) {
        Toast.makeText(contexto, message, Toast.LENGTH_LONG).show();
    }
}