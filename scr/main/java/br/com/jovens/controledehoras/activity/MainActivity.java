package br.com.jovens.controledehoras.activity;

import java.util.zip.Inflater;

import br.com.jovens.controledehoras.R;
import br.com.jovens.controledehoras.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		System.out.println("Testando");
	}
	
}
