package controlehoras.jovens.com.br.controledehoras.activity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.achep.header2actionbar.FadingActionBarHelper;

import controlehoras.jovens.com.br.controledehoras.Adapter.SectionsPagerAdapter;
import controlehoras.jovens.com.br.controledehoras.R;
import controlehoras.jovens.com.br.controledehoras.activity.acao.CalendarioAcao;
import controlehoras.jovens.com.br.controledehoras.fragment.HomeFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.ListViewFragment;
import controlehoras.jovens.com.br.controledehoras.helper.SelecionadorArquivoHelper;

public class ControleActivity extends Activity  {

    private CalendarioAcao acao;
    private SelecionadorArquivoHelper selecionadorArquivo;
    private FadingActionBarHelper mFadingActionBarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);
        iniciarObjetos();

        // esse atributo que cuida do efeito na actionBar
        mFadingActionBarHelper = new FadingActionBarHelper(montarActionBar(), getResources().getDrawable(R.drawable.actionbar_bg));

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.content, new HomeFragment())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.controle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        switch (itemClicado) {
            case R.id.importar:
                acao.executarSelecionadorArquivo();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    // Metodo criado para cuidar da montagem da actionBar, por enquanto só foi solicitado que o titulo nao apareça
    private ActionBar montarActionBar(){
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        return actionBar;
    }

    private void iniciarObjetos(){
        selecionadorArquivo = new SelecionadorArquivoHelper(this);
        acao = new CalendarioAcao(this);
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

    public SelecionadorArquivoHelper getSelecionadorArquivo(){
        return selecionadorArquivo;
    }

    public FadingActionBarHelper getFadingActionBarHelper() {
        return mFadingActionBarHelper;
    }


}