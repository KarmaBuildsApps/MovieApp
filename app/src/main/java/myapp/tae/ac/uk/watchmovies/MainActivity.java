package myapp.tae.ac.uk.watchmovies;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.UI.adapters.MediaViewPagerAdapter;
import myapp.tae.ac.uk.watchmovies.model.DataService;
import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVResult;
import myapp.tae.ac.uk.watchmovies.presenter.MoviePresenter;
import myapp.tae.ac.uk.watchmovies.presenter.MovieView;

public class MainActivity extends AppCompatActivity implements MovieView {
    @Bind(R.id.navigationDrawer)
    DrawerLayout drawerLayout;
    @Bind(R.id.toolbarNavigationDrawer)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.movieViewPager)
    ViewPager viewPager;

    private MoviePresenter presenter;
    private MediaViewPagerAdapter viewPagerAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataService dataService = new DataService();
        configInjection(dataService);
        setupProgressDialog();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        presenter = new MoviePresenter(this, dataService);
        viewPagerAdapter = new MediaViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getMediaDataForTheFirstTime();
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data");
    }

    private void configInjection(DataService dataService) {
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getApiComponent().inject(dataService);
    }

    @Override
    public void setMovieData(List<MovieResult> movieData) {
        viewPagerAdapter.setMovieDataForAdapter(movieData);
    }

    @Override
    public void setTVData(List<TVResult> tvData) {
        viewPagerAdapter.setTVDataForAdapter(tvData);
    }

    @Override
    public void setPeopleData(List<PeopleResult> peopleData) {
        viewPagerAdapter.setPeopleData(peopleData);
    }

    @Override
    public void showProgressDialog() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void stopProgressDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
