package myapp.tae.ac.uk.watchmovies.extras;

/**
 * Created by Karma on 20/05/16.
 */
public class Constants {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String MOVIE_POPULAR = "movie/popular?sort_by=popularity.desc&api_key=";
    public static final String TV_POPULAR = "tv/popular?sort_by=popularity.desc&api_key=";
    public static final String PEOPLE_POPULAR = "person/popular?sort_by=popularity.desc&api_key=";
    public static final String API_KEY = "2943485038f25a96a2bccf8077eb71f6";
    public static final String POSTER_URL_BASE = "http://image.tmdb.org/t/p/w185";
    public static final String MOVIE_POPULAR_QUERY = MOVIE_POPULAR + API_KEY;
    public static final String TV_POPULAR_QUERY = TV_POPULAR + API_KEY;
    public static final String PEOPLE_POPULAR_QUERY = PEOPLE_POPULAR + API_KEY;
    public static final int MOVIE_DATA_CHANGE = 10;
    public static final int TV_DATA_CHANGE = 20;
    public static final int PEOPLE_DATA_CHANGE = 30;
    public static int MOVIE_TYPE = 0;
    public static final int TV_TYPE = 1;
    public static final int PEOPLE_TYPE = 2;

    public static String FRAGMENT_CONTAINER_TAG = "fragment_container";
}
