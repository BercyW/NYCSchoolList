package security.bercy.com.nycschoollist.di.module;

import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.di.scope.AppScope;

/**
 * Created by Bercy on 2/20/18.
 */
@Module
public class AppModule {
    public static final String TAG = "APPMODULE";
    String BASE_URL;
    Context context;

    public AppModule(String BASE_URL, Context context) {
        this.BASE_URL = BASE_URL;
        this.context = context;
    }

    @AppScope
    @Provides
    RemoteDataSource provideRemoteDataSource(){

        return new RemoteDataSource(BASE_URL, context);
    }

    @AppScope
    @Provides
    Context providesContext(){
        return this.context;
    }


}
