package myapp.tae.ac.uk.watchmovies.dagger.modules;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import myapp.tae.ac.uk.watchmovies.api.InterfaceMovieAPI;
import myapp.tae.ac.uk.watchmovies.dagger.scopes.Scopes;
import retrofit2.Retrofit;

/**
 * Created by Karma on 11/03/16.
 */
@Module
public class APIModule {
    @Scopes
    @Provides
    InterfaceMovieAPI provideMovieAPI(Retrofit retrofit) {
        return retrofit.create(InterfaceMovieAPI.class);
    }
}
