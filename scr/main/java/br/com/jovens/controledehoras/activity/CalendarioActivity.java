package br.com.jovens.controledehoras.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import br.com.jovens.controledehoras.R;
import br.com.jovens.controledehoras.activity.acao.CalendarioAcao;
import br.com.jovens.controledehoras.activity.helper.SelecionadorArquivoHelper;

public class CalendarioActivity extends Activity {	

	private SelecionadorArquivoHelper selecionadorArquivo;
	private CalendarioAcao acao;


	public SelecionadorArquivoHelper getSelecionadorArquivo(){
		return selecionadorArquivo;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);

		iniciarObjetos();

		final CalendarView calendario = (CalendarView) findViewById(R.id.calendario);

		calendario.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {

				Toast.makeText(CalendarioActivity.this,
						dayOfMonth + "/" + month + "/" + year,
						Toast.LENGTH_LONG).show();
			}
		});

	}

	private void iniciarObjetos(){
		selecionadorArquivo = new SelecionadorArquivoHelper(this);
		acao = new CalendarioAcao(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemClicado = item.getItemId();

		switch (itemClicado) {
		case R.id.importCsv:						
			acao.executarSelecionadorArquivo();
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}	


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case SelecionadorArquivoHelper.FILE_SELECT_CODE:
			if(resultCode == RESULT_OK){				
				acao.executarArquivoSelecionado(data.getData());
			}

			break;

		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}


}