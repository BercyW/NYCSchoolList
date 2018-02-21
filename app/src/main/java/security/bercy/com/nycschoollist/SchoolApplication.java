package security.bercy.com.nycschoollist;

import android.app.Application;

import security.bercy.com.nycschoollist.di.component.AppComponent;
import security.bercy.com.nycschoollist.di.component.SchoolDetailsComponent;
import security.bercy.com.nycschoollist.di.component.SchoolListComponent;
import security.bercy.com.nycschoollist.di.module.AppModule;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolApplication extends Application{
    public static final String BASEURL = "https:https://data.cityofnewyork.us/resource";
    private AppComponent appComponent;
    private SchoolListComponent schoolListComponent;
    private SchoolDetailsComponent schoolDetailsComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(BASEURL, getApplicationContext());
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();




    }
}
