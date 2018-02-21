package security.bercy.com.nycschoollist.di.module;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.di.scope.ActivityScope;
import security.bercy.com.nycschoollist.view.schoollist.SchoolListPresenter;

/**
 * Created by Bercy on 2/20/18.
 */
@Module
public class SchoolListModule {
    @ActivityScope
    @Provides
    SchoolListPresenter provideSchoolListPresenter(RemoteDataSource remoteDataSource){
        return new SchoolListPresenter(remoteDataSource);
    }
}
