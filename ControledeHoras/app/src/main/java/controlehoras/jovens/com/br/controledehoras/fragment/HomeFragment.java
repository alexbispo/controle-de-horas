package controlehoras.jovens.com.br.controledehoras.fragment;



import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achep.header2actionbar.HeaderFragment;

import controlehoras.jovens.com.br.controledehoras.R;
import controlehoras.jovens.com.br.controledehoras.activity.ControleActivity;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardView;

public class HomeFragment extends HeaderFragment {

    private View view;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        setHeaderBackgroundScrollMode(HEADER_BACKGROUND_SCROLL_PARALLAX);
        setOnHeaderScrollChangedListener(new OnHeaderScrollChangedListener() {
            @Override
            public void onHeaderScrollChanged(float progress, int height, int scroll) {
                height -= getActivity().getActionBar().getHeight();

                progress = (float) scroll / height;
                if (progress > 1f) progress = 1f;

                // *
                // `*
                // ```*
                // ``````*
                // ````````*
                // `````````*
                progress = (1 - (float) Math.cos(progress * Math.PI)) * 0.5f;

                ((ControleActivity) getActivity())
                        .getFadingActionBarHelper()
                        .setActionBarAlpha((int) (255 * progress));
            }
        });

    }

    @Override
    public View onCreateHeaderView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public View onCreateContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        onCreateCard(view);
        return view;

    }

    @Override
    public View onCreateContentOverlayView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void onCreateCard(View view){
        Card card = new Card(getActivity(), R.layout.row_card);
        CardView cardView = (CardView) view.findViewById(R.id.carddemo);
        cardView.setCard(card);
    }


}
