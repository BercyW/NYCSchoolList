package security.bercy.com.nycschoollist.di.module;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.di.scope.ActivityScope;
import security.bercy.com.nycschoollist.view.schooldetails.SchoolDetailsPresenter;

/**
 * Created by Bercy on 2/20/18.
 */

@Module
public class SchoolDetailsModule {

    @ActivityScope
    @Provides
    SchoolDetailsPresenter provideSchoolDetailPresenter(RemoteDataSource remoteDataSource) {
        return new SchoolDetailsPresenter(remoteDataSource);
    }


}
