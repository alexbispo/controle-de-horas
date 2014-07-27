package controlehoras.jovens.com.br.controledehoras.activity;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import controlehoras.jovens.com.br.controledehoras.Adapter.SectionsPagerAdapter;
import controlehoras.jovens.com.br.controledehoras.R;
import controlehoras.jovens.com.br.controledehoras.activity.acao.CalendarioAcao;
import controlehoras.jovens.com.br.controledehoras.helper.SelecionadorArquivoHelper;

public class ControleActivity extends Activity implements ActionBar.TabListener {

    private CalendarioAcao acao;
    private SelecionadorArquivoHelper selecionadorArquivo;

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);

        iniciarObjetos();

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // Cria a tabBar
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
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
            case R.id.action_settings:
                acao.executarSelecionadorArquivo();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
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


}
