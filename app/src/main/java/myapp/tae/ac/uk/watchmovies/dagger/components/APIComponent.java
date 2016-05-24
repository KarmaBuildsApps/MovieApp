package myapp.tae.ac.uk.watchmovies.dagger.components;

import dagger.Component;
import myapp.tae.ac.uk.watchmovies.MainActivity;
import myapp.tae.ac.uk.watchmovies.dagger.modules.APIModule;
import myapp.tae.ac.uk.watchmovies.dagger.scopes.Scopes;
import myapp.tae.ac.uk.watchmovies.model.DataService;

/**
 * Created by Karma on 11/03/16.
 */
@Scopes
@Component(dependencies = NetComponent.class, modules = APIModule.class)
public interface APIComponent {
    void inject (DataService dataService);
    void inject (MainActivity mainActivity);
}
