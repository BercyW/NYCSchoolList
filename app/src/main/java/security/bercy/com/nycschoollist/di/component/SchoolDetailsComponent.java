package security.bercy.com.nycschoollist.di.component;

import dagger.Subcomponent;
import security.bercy.com.nycschoollist.di.module.SchoolDetailsModule;
import security.bercy.com.nycschoollist.di.scope.ActivityScope;
import security.bercy.com.nycschoollist.view.schooldetails.SchoolDetails;

/**
 * Created by Bercy on 2/20/18.
 */

@ActivityScope
@Subcomponent(modules = SchoolDetailsModule.class)
public interface SchoolDetailsComponent {
    void inject(SchoolDetails schoolDetails);
}
