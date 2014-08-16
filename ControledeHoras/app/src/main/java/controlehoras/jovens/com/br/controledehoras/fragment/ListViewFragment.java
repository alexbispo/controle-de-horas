package controlehoras.jovens.com.br.controledehoras.fragment;



import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.achep.header2actionbar.HeaderFragment;

import java.lang.ref.WeakReference;

import controlehoras.jovens.com.br.controledehoras.R;
import controlehoras.jovens.com.br.controledehoras.activity.ActionBarActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ListViewFragment extends HeaderFragment {

    private View mListView;
    private String[] mListViewTitles;
    private boolean mLoaded;


    private AsyncLoadSomething mAsyncLoadSomething;
    private FrameLayout mContentOverlay;

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

                ((ActionBarActivity) getActivity())
                        .getFadingActionBarHelper()
                        .setActionBarAlpha((int) (255 * progress));
            }
        });

        cancelAsyncTask(mAsyncLoadSomething);
        mAsyncLoadSomething = new AsyncLoadSomething(this);
        mAsyncLoadSomething.execute();
    }

    @Override
    public void onDetach() {
        cancelAsyncTask(mAsyncLoadSomething);
        super.onDetach();
    }

    @Override
    public View onCreateHeaderView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public View onCreateContentView(LayoutInflater inflater, ViewGroup container) {
        mListView =  inflater.inflate(R.layout.fragment_home, container, false);
        if (mLoaded) setListViewTitles(mListViewTitles);
        return mListView;
    }

    @Override
    public View onCreateContentOverlayView(LayoutInflater inflater, ViewGroup container) {
        ProgressBar progressBar = new ProgressBar(getActivity());
        mContentOverlay = new FrameLayout(getActivity());
        mContentOverlay.addView(progressBar, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        if (mLoaded) mContentOverlay.setVisibility(View.GONE);
        return mContentOverlay;
    }

    private void setListViewTitles(String[] titles) {

    }

    private void cancelAsyncTask(AsyncTask task) {
        if (task != null) task.cancel(false);
    }


    private static class AsyncLoadSomething extends AsyncTask<Void, Void, String[]> {


            private static final String TAG = "AsyncLoadSomething";

            final WeakReference<ListViewFragment> weakFragment;

            public AsyncLoadSomething(ListViewFragment fragment) {
                this.weakFragment = new WeakReference<ListViewFragment>(fragment);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                final ListViewFragment audioFragment = weakFragment.get();
                if (audioFragment.mListView != null) audioFragment.mListView.setVisibility(View.INVISIBLE);
                if (audioFragment.mContentOverlay != null) audioFragment.mContentOverlay.setVisibility(View.VISIBLE);
            }

            @Override
            protected String[] doInBackground(Void... voids) {

                try {
                    // Emulate long downloading
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String[] titles) {
                super.onPostExecute(titles);
                final ListViewFragment audioFragment = weakFragment.get();

                if (audioFragment.mContentOverlay != null) audioFragment.mContentOverlay.setVisibility(View.GONE);

            }
        }

    }
