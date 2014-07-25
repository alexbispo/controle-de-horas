package br.com.jovens.controledehoras.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import br.com.jovens.controledehoras.R;

public class SplashScreenActivity extends Activity implements Runnable{

	private static final int SPLASH_SHOW_TIME = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		final ImageView animationImageView = (ImageView) findViewById(R.id.logo);
		Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.movimento_vertical_suave);
		animationImageView.startAnimation(hyperspaceJump);
		
		//Treço para animação por frames
		animationImageView.setBackgroundResource(R.anim.mudanca_de_cor);
		
        final AnimationDrawable frameAnimation = (AnimationDrawable) animationImageView.getBackground();
        animationImageView.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        Handler h = new Handler();
        h.postDelayed(this, 2000);
        

		new BackgroundSplashTask().execute();

	}

	/**
	 * Async Task: Pode ser usada para carregar informações do BD
	 */
	private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			//carregamentos de informações podem ser feitos aqui
			try {
				Thread.sleep(SPLASH_SHOW_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Intent i = new Intent(SplashScreenActivity.this,
					CalendarioActivity.class);
			// qualquer informação carregada durante o splash_show
			// pode ser passada para a main activity usando
			// abaixo
			i.putExtra("loaded_info", " ");
			startActivity(i);
			finish();
		}

	}

	@Override
	public void run() {
		startActivity(new Intent(this, CalendarioActivity.class));
        finish();
		
	}
}