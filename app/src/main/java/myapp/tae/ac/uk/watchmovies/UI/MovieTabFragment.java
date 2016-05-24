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
import myapp.tae.ac.uk.watchmovies.UI.adapters.MovieAdapter;
import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;

/**
 * Created by Karma on 21/05/16.
 */
public class MovieTabFragment extends Fragment {
    private MovieAdapter adapter;
    @Bind(R.id.tabRecyclerView)
    RecyclerView recyclerView;
    private List<MovieResult> movieList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, view);
        adapter = new MovieAdapter(getActivity());

        if (movieList != null)
            adapter.setPopularMovies(movieList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void setAdapterData(List<MovieResult> movies) {
        if (adapter != null)
            adapter.setPopularMovies(movies);
        else
            movieList = movies;
    }
}
