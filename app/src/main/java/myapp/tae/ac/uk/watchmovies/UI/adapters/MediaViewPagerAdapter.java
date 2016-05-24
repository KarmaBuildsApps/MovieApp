package myapp.tae.ac.uk.watchmovies.UI.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import myapp.tae.ac.uk.watchmovies.UI.MovieTabFragment;
import myapp.tae.ac.uk.watchmovies.UI.PeopleTabFragment;
import myapp.tae.ac.uk.watchmovies.UI.TVTabFragment;
import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVResult;

/**
 * Created by Karma on 22/05/16.
 */
public class MediaViewPagerAdapter extends FragmentPagerAdapter {
    private MovieTabFragment movieTabFragment;
    private TVTabFragment tvTabFragment;
    private PeopleTabFragment peopleTabFragment;

    public MediaViewPagerAdapter(FragmentManager fm) {
        super(fm);
        movieTabFragment = new MovieTabFragment();
        tvTabFragment = new TVTabFragment();
        peopleTabFragment = new PeopleTabFragment();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == Constants.MOVIE_TYPE)
            fragment = movieTabFragment;
        else if (position == Constants.TV_TYPE)
            fragment = tvTabFragment;
        else if (position == Constants.PEOPLE_TYPE)
            fragment = peopleTabFragment;
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position) {
            case 0:
                title = "Movies";
                break;
            case 1:
                title = "TV Series";
                break;
            case 2:
                title = "People";
                break;
            default:
                title = "";
        }
        return title;
    }

    public void setMovieDataForAdapter(List<MovieResult> movieData) {
        movieTabFragment.setAdapterData(movieData);
    }

    public void setTVDataForAdapter(List<TVResult> tvData) {
        tvTabFragment.setAdapterData(tvData);
    }

    public void setPeopleData(List<PeopleResult> peopleData) {
        peopleTabFragment.setPeopleData(peopleData);
    }
}
