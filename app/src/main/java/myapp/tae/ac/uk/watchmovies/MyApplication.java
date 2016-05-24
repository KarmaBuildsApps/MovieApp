package myapp.tae.ac.uk.watchmovies;

import android.app.Application;

import myapp.tae.ac.uk.watchmovies.dagger.components.APIComponent;
import myapp.tae.ac.uk.watchmovies.dagger.components.DaggerAPIComponent;
import myapp.tae.ac.uk.watchmovies.dagger.components.DaggerNetComponent;
import myapp.tae.ac.uk.watchmovies.dagger.components.NetComponent;
import myapp.tae.ac.uk.watchmovies.dagger.modules.APIModule;
import myapp.tae.ac.uk.watchmovies.dagger.modules.AppModule;
import myapp.tae.ac.uk.watchmovies.dagger.modules.NetModule;
import myapp.tae.ac.uk.watchmovies.extras.Constants;

/**
 * Created by Karma on 19/05/16.
 */
public class MyApplication extends Application {
    private APIComponent mApiComponent;
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();
        mApiComponent = DaggerAPIComponent.builder()
                .netComponent(mNetComponent)
                .aPIModule(new APIModule())
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public APIComponent getApiComponent() {
        return mApiComponent;
    }
}
