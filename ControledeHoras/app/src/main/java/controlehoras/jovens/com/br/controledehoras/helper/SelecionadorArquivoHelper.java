package controlehoras.jovens.com.br.controledehoras.helper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import java.net.URISyntaxException;

import controlehoras.jovens.com.br.controledehoras.util.MensagemUtil;

/**
 * Created by Fabio on 25/07/2014.
 */
public class SelecionadorArquivoHelper {

    public static final int FILE_SELECT_CODE = 0;

    private Activity activity;

    private Uri uri;

    public SelecionadorArquivoHelper(Activity activity) {
        this.activity = activity;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            activity.startActivityForResult(Intent.createChooser(intent, "Selecione o arquivo CSV"), FILE_SELECT_CODE);

        } catch (android.content.ActivityNotFoundException ex) {
            MensagemUtil.exibirMensagemLonga(activity, "Por favor instale um gerenciador de arquivos.");

        }
    }

    public String getPath() throws URISyntaxException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {"_data"};
            Cursor cursor = null;

            try {
                cursor = activity.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

}