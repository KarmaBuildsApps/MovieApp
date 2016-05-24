package myapp.tae.ac.uk.watchmovies.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import myapp.tae.ac.uk.watchmovies.dagger.modules.AppModule;
import myapp.tae.ac.uk.watchmovies.dagger.modules.NetModule;
import retrofit2.Retrofit;

/**
 * Created by Karma on 11/03/16.
 */
@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
