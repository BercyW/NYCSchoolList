package security.bercy.com.nycschoollist.view.schooldetails;


import android.util.Log;

import java.util.List;

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

    @Override
    public void attachView(SchoolDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void initData(School school) {

        final Call<SAT> SATCall =  RemoteDataSource.getSAT(school.getDbn());
        Log.d(TAG, "onResponse: ");

        SATCall.enqueue(new Callback<SAT>() {
            @Override
            public void onResponse(Call<SAT> call, Response<SAT> response) {
                SAT sat = response.body();

                view.setMath(sat.getSatMathAvgScore());
                view.setReading(sat.getSatCriticalReadingAvgScore());
                view.setWriting(sat.getSatWritingAvgScore());
            }

            @Override
            public void onFailure(Call<SAT> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }


        });
    }
}
