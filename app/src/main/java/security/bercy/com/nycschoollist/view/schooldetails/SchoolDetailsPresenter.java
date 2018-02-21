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

    }

    @Override
    public void initData(School school) {

        final Call<List<SAT>> SATCall =  RemoteDataSource.getSAT(school.getDbn());
        Log.d(TAG, "initData: "+school.getDbn());

        SATCall.enqueue(new Callback<List<SAT>>() {
            @Override
            public void onResponse(Call<List<SAT>> call, Response<List<SAT>> response) {
                List<SAT> sat = response.body();
                view.setMath(sat.get(0).getSatMathAvgScore());
                view.setReading(sat.get(0).getSatCriticalReadingAvgScore());
                view.setWriting(sat.get(0).getSatWritingAvgScore());
            }

            @Override
            public void onFailure(Call<List<SAT>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }


        });
    }
}
