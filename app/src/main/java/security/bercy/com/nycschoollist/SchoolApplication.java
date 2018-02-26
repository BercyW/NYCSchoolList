package security.bercy.com.nycschoollist;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import security.bercy.com.nycschoollist.di.component.AppComponent;

import security.bercy.com.nycschoollist.di.component.DaggerAppComponent;
import security.bercy.com.nycschoollist.di.component.SchoolDetailsComponent;
import security.bercy.com.nycschoollist.di.component.SchoolListComponent;
import security.bercy.com.nycschoollist.di.module.AppModule;
import security.bercy.com.nycschoollist.di.module.SchoolDetailsModule;
import security.bercy.com.nycschoollist.di.module.SchoolListModule;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolApplication extends Application{
    public static final String BASEURL = "https://data.cityofnewyork.us/resource/";
    private AppComponent appComponent;
    private SchoolListComponent schoolListComponent;
    private SchoolDetailsComponent schoolDetailsComponent;

    public static final String TAG = "application";
    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(BASEURL, getApplicationContext());
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

    }

    public static SchoolApplication get(Context context) {
        return (SchoolApplication) context.getApplicationContext();
    }

    public SchoolListComponent getSchoolListComponent() {

        schoolListComponent = appComponent.plus(new SchoolListModule());
        return schoolListComponent;
    }

    public SchoolDetailsComponent getSchoolDetailsComponent() {
        schoolDetailsComponent = appComponent.plus(new SchoolDetailsModule());
        return schoolDetailsComponent;
    }



    public void clearSchoolListComponent() {
        schoolListComponent = null;

    }
    public void clearSchoolDetailsComponent() {
        schoolDetailsComponent = null;

    }



}
