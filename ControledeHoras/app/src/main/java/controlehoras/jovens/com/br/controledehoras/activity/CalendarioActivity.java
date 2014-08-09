package controlehoras.jovens.com.br.controledehoras.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.timessquare.CalendarPickerView;

import controlehoras.jovens.com.br.controledehoras.R;
import controlehoras.jovens.com.br.controledehoras.activity.acao.CalendarioAcao;
import controlehoras.jovens.com.br.controledehoras.helper.SelecionadorArquivoHelper;

public class CalendarioActivity extends Activity {

    private SelecionadorArquivoHelper selecionadorArquivo;

    private CalendarioAcao acao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public SelecionadorArquivoHelper getSelecionadorArquivo(){
        return selecionadorArquivo;
    }
}
