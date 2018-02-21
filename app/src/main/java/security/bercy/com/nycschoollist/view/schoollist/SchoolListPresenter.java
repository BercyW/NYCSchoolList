package security.bercy.com.nycschoollist.view.schoollist;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.model.School;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolListPresenter implements SchoolListContract.Presenter {
    public static final String TAG  = "SchoolListPresenter";
    RemoteDataSource remoteDataSource;
    SchoolListContract.View view;
    List<School> schoolList = new ArrayList<>();



    @Inject
    public SchoolListPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public void attachView(SchoolListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getSchool() {

        final Call<List<School>> schoolCall =  RemoteDataSource.getSchool();

        
        schoolCall.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {

                schoolList = response.body();

                view.updateSchool(schoolList);
            }


            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });



    }
}
