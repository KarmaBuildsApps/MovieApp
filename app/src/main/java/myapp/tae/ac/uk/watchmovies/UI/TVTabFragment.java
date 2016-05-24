package myapp.tae.ac.uk.watchmovies.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.R;
import myapp.tae.ac.uk.watchmovies.UI.adapters.TVSeriesAdapter;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVResult;

/**
 * Created by Karma on 22/05/16.
 */
public class TVTabFragment extends Fragment {
    private TVSeriesAdapter adapter;
    @Bind(R.id.tabRecyclerView)
    RecyclerView recyclerView;
    private List<TVResult> tvList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, view);
        adapter = new TVSeriesAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.tabRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void setAdapterData(List<TVResult> tvSeries) {
        adapter.setPopularTVSeries(tvSeries);
    }
}
