package security.bercy.com.nycschoollist.view.schooldetails;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.model.SAT;
import security.bercy.com.nycschoollist.model.School;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolDetailsPresenter implements SchoolDetailsContract.Presenter {

    public static final String TAG = "detail";
    SchoolDetailsContract.View view;
    RemoteDataSource remoteDataSource;
    List<SAT> sats = new ArrayList<>();


    @Inject
    public SchoolDetailsPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void attachView(SchoolDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public void initData(School school) {

        final Call<List<SAT>> SATCall =  remoteDataSource.getSAT(school.getDbn());
        Log.d(TAG, "initData: "+school.getDbn());

        SATCall.enqueue(new Callback<List<SAT>>() {
            @Override
            public void onResponse(Call<List<SAT>> call, Response<List<SAT>> response) {
                sats = response.body();
                view.setMath(sats.get(0).getSatMathAvgScore());
                view.setReading(sats.get(0).getSatCriticalReadingAvgScore());
                view.setWriting(sats.get(0).getSatWritingAvgScore());
            }

            @Override
            public void onFailure(Call<List<SAT>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }


        });
    }
}
