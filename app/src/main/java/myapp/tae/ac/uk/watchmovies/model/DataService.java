package myapp.tae.ac.uk.watchmovies.model;

import android.util.Log;

import java.util.Observable;

import javax.inject.Inject;

import myapp.tae.ac.uk.watchmovies.api.InterfaceMovieAPI;
import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.Movies.Movies;
import myapp.tae.ac.uk.watchmovies.model.People.People;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVSeries;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Karma on 20/05/16.
 */
public class DataService extends Observable {
    @Inject
    InterfaceMovieAPI movieAPI;
    private static final String TAG = DataService.class.getSimpleName();
    private Movies movies;
    private TVSeries tvSeries;
    private People people;

    public Movies getMovies() {
        return movies;
    }

    public TVSeries getTvSeries() {
        return tvSeries;
    }

    public People getPeople() {
        return people;
    }

    public void retrieveMoviesFromTheMovieDb() {
        movieAPI.getPopularMovies().enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                movies = response.body();
                setChanged();
                notifyObservers(Constants.MOVIE_DATA_CHANGE);
                Log.d(TAG, "onResponse: Movie Data Received");
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d(TAG, "onFailure: Movie data retrieval failure");
            }
        });
    }

    public void retrieveTVSeriesFromTheMovieDb() {
        movieAPI.getPopularTVSeries().enqueue(new Callback<TVSeries>() {
            @Override
            public void onResponse(Call<TVSeries> call, Response<TVSeries> response) {
                tvSeries = response.body();
                setChanged();
                notifyObservers(Constants.TV_DATA_CHANGE);
            }

            @Override
            public void onFailure(Call<TVSeries> call, Throwable t) {
                Log.d(TAG, "onFailure: TV Series data retrieval failure");
            }
        });
    }

    public void retrievePeopleFromTheMovieDb() {
        movieAPI.getPopularPeople().enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                people = response.body();
                setChanged();
                notifyObservers(Constants.PEOPLE_DATA_CHANGE);
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {

            }
        });
    }


}
