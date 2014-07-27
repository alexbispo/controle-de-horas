package controlehoras.jovens.com.br.controledehoras.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import controlehoras.jovens.com.br.controledehoras.R;


public final class CalendarFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static CalendarFragment newInstance(int sectionNumber) {

        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }

    public CalendarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        return rootView;
    }



}
