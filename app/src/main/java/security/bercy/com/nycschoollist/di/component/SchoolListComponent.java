package security.bercy.com.nycschoollist.di.component;

import dagger.Subcomponent;
import security.bercy.com.nycschoollist.di.module.SchoolListModule;
import security.bercy.com.nycschoollist.di.scope.ActivityScope;
import security.bercy.com.nycschoollist.view.schoollist.SchoolList;

/**
 * Created by Bercy on 2/20/18.
 */

@ActivityScope
@Subcomponent(modules = SchoolListModule.class)
public interface SchoolListComponent {
    void inject(SchoolList schoolList);

}
