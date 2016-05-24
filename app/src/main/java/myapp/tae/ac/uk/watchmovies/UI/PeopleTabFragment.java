package myapp.tae.ac.uk.watchmovies.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.R;
import myapp.tae.ac.uk.watchmovies.UI.adapters.PeopleAdapter;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;

/**
 * Created by Karma on 23/05/16.
 */
public class PeopleTabFragment extends Fragment {
    private static final String TAG = PeopleTabFragment.class.getSimpleName();
    @Bind(R.id.tabRecyclerView)
    RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    int counter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, view);
        peopleAdapter = new PeopleAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.tabRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(peopleAdapter);
        Log.d(TAG, "onCreateView: Count: " + ++counter);
        return view;
    }

    public void setPeopleData(List<PeopleResult> peopleData) {
            peopleAdapter.setPopularPeople(peopleData);
    }
}
