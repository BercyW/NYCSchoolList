package security.bercy.com.nycschoollist.di.component;

import dagger.Component;
import security.bercy.com.nycschoollist.di.module.AppModule;
import security.bercy.com.nycschoollist.di.module.SchoolDetailsModule;
import security.bercy.com.nycschoollist.di.module.SchoolListModule;
import security.bercy.com.nycschoollist.di.scope.AppScope;

/**
 * Created by Bercy on 2/20/18.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent{
    SchoolListComponent plus(SchoolListModule schoolListModule);
    SchoolDetailsComponent plus(SchoolDetailsModule schoolDetailsModule);
}
