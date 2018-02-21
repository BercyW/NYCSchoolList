package security.bercy.com.nycschoollist.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import security.bercy.com.nycschoollist.model.School;

/**
 * Created by Bercy on 2/20/18.
 */

public class RemoteDataSource {


    Context context;

    private static String BASE_URL;

    @Inject
    public RemoteDataSource(String BASE_URL, Context context) {
        this.BASE_URL = BASE_URL;
        this.context = context;
    }

    public static Call<List<School>> getSchool() {
        Retrofit retrofit = create();
        RemoteService remoteService =retrofit.create(RemoteService.class);
        return remoteService.getSchool();
    }

    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;


    }
}
