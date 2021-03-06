package security.bercy.com.nycschoollist.data;


import java.util.List;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import security.bercy.com.nycschoollist.model.SAT;
import security.bercy.com.nycschoollist.model.School;

/**
 * Created by Bercy on 2/20/18.
 */

public interface RemoteService{


    @GET("97mf-9njv.json")
    Call<List<School>> getSchool();

    @GET("734v-jeq5.json")
    Call<List<SAT>> getSAT(@Query("dbn") String dbn);

}
