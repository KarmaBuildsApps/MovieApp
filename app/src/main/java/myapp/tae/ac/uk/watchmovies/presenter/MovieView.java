package myapp.tae.ac.uk.watchmovies.presenter;

import java.util.List;

import myapp.tae.ac.uk.watchmovies.model.Movies.MovieResult;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVResult;

/**
 * Created by Karma on 20/05/16.
 */
public interface MovieView {
    public void setMovieData(List<MovieResult> movieData);

    public void setTVData(List<TVResult> tvData);

    public void setPeopleData(List<PeopleResult> peopleData);

    public void showProgressDialog();

    public void stopProgressDialog();

    public void selectTab(int index);

}
