package myapp.tae.ac.uk.watchmovies.api;

import myapp.tae.ac.uk.watchmovies.extras.Constants;
import myapp.tae.ac.uk.watchmovies.model.Movies.Movies;
import myapp.tae.ac.uk.watchmovies.model.People.People;
import myapp.tae.ac.uk.watchmovies.model.People.PeopleResult;
import myapp.tae.ac.uk.watchmovies.model.TVSeries.TVSeries;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Karma on 20/05/16.
 */
public interface InterfaceMovieAPI {
    @GET(Constants.MOVIE_POPULAR_QUERY)
    Call<Movies> getPopularMovies();

    @GET(Constants.TV_POPULAR_QUERY)
    Call<TVSeries> getPopularTVSeries();

    @GET(Constants.PEOPLE_POPULAR_QUERY)
    Call<People> getPopularPeople();
}
