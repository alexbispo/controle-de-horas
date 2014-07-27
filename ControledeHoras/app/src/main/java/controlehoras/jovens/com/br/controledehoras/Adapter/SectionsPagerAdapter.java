package controlehoras.jovens.com.br.controledehoras.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.Locale;

import controlehoras.jovens.com.br.controledehoras.fragment.CalendarFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.PlaceholderFragment;
import controlehoras.jovens.com.br.controledehoras.fragment.SaldoFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final static int TAB_ABA_INICIO = 0;
    private final static int TAB_ABA_CALENDARIO = 1;
    private final static int TAB_ABA_SALDO = 2;

    protected static final String[] ABAS_DA_TABELA = new String[] {"Inicio" , "Calendario" , "Saldo"};

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /*
        Metodo responsavel por pegar a posicao clicada pelo usuario na tabela e direcionar
        para um fragment
      */

    @Override
    public Fragment getItem(int position) {
        if (position == TAB_ABA_INICIO) {
            return PlaceholderFragment.newInstance(position + 1);
        } else if (position == TAB_ABA_CALENDARIO) {
            return CalendarFragment.newInstance(position + 1);
        } else if(position == TAB_ABA_SALDO) {
            return SaldoFragment.newInstance(position + 1);
        }
            return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ABAS_DA_TABELA[position];
    }
}