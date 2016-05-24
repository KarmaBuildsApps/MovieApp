package myapp.tae.ac.uk.watchmovies;

import android.app.ProgressDialog;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.watchmovies.UI.adapters.MediaViewPagerAdapter;
import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.DataService;
import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVResult;
import myapp.tae.ac.uk.watchmovies.presenter.MoviePresenter;
import myapp.tae.ac.uk.watchmovies.presenter.MovieView;

public class MainActivity extends AppCompatActivity implements MovieView {
    @Bind(R.id.navigationDrawer)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigationMenu)
    NavigationView navigationView;
    @Bind(R.id.toolbarNavigationDrawer)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.movieViewPager)
    ViewPager viewPager;

    private ActionBarDrawerToggle toggle;
    private MoviePresenter presenter;
    private MediaViewPagerAdapter viewPagerAdapter;
    private ProgressDialog progressDialog;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataService dataService = new DataService();
        configInjection(dataService);
        setupToolbar();
        setupNavigation();
        setupProgressDialog();
        presenter = new MoviePresenter(this, dataService);
        viewPagerAdapter = new MediaViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupNavigation() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_movies:
                        selectTab(Constants.MOVIE_TYPE);
                        Snackbar.make(viewPager, "Movies Menu Clicked", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.nav_item_tv:
                        selectTab(Constants.TV_TYPE);
                        Snackbar.make(viewPager, "TV Menu Clicked", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.nav_item_people:
                        selectTab(Constants.PEOPLE_TYPE);
                        Snackbar.make(viewPager, "People Menu Clicked", Snackbar.LENGTH_LONG).show();
                        break;
                    default:
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firstTime) {
            firstTime = false;
            presenter.getMediaDataForTheFirstTime();
        }
//        presenter.test();
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

    @Override
    public void selectTab(int index) {
        tabLayout.setScrollPosition(index, 0f, true);
        viewPager.setCurrentItem(index);
    }
}
