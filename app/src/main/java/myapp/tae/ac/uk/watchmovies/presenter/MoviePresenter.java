package myapp.tae.ac.uk.watchmovies.presenter;

import android.util.Log;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.DataService;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;

/**
 * Created by Karma on 20/05/16.
 */
public class MoviePresenter implements Observer {
    private static final String TAG = MoviePresenter.class.getSimpleName();
    private final MovieView view;
    private DataService service;
    private boolean isDataDownloadForTheFirstTime = false;
    private int downloadDataCounter = 0;

    public MoviePresenter(MovieView view, DataService service) {
        this.view = view;
        this.service = service;
        this.service.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        switch ((int) data) {
            case Constants.MOVIE_DATA_CHANGE:
                Log.i(TAG, "update: Movie data RECEIVED");
                view.setMovieData(service.getMovies().getMovieResults());
                break;
            case Constants.TV_DATA_CHANGE:
                Log.i(TAG, "update: TV Series data RECEIVED");
                view.setTVData(service.getTvSeries().getTVResults());
                break;
            case Constants.PEOPLE_DATA_CHANGE:
                List<PeopleResult> peopleResults = service.getPeople().getResults();
                view.setPeopleData(peopleResults);
                break;
            default:
                Log.d(TAG, "update: There is no change in data received");
                break;
        }

        if (isDataDownloadForTheFirstTime) {
            downloadDataCounter++;
            if (downloadDataCounter == 3) {
                view.stopProgressDialog();
                isDataDownloadForTheFirstTime = false;
                downloadDataCounter = 0;
            }
        }
    }

    public void getMediaDataForTheFirstTime() {
        view.showProgressDialog();
        isDataDownloadForTheFirstTime = true;
        showPopularMovies();
        showPopularTVSeries();
        showPopularPeople();
    }

    public void showPopularMovies() {
        service.retrieveMoviesFromTheMovieDb();
    }

    public void showPopularTVSeries() {
        service.retrieveTVSeriesFromTheMovieDb();
    }

    public void showPopularPeople() {
        service.retrievePeopleFromTheMovieDb();
    }
}
