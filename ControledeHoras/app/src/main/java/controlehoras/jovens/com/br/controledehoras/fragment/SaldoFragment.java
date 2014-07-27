package controlehoras.jovens.com.br.controledehoras.fragment;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import controlehoras.jovens.com.br.controledehoras.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SaldoFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number" ;

    public SaldoFragment() {
    }

    /*
        Metodo responsavel por criar a pagina que sera exibida
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saldo, container, false);
    }


    public static Fragment newInstance(int sectionNumber) {
        SaldoFragment fragment = new SaldoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
