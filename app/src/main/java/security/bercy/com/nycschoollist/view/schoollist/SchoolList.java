package security.bercy.com.nycschoollist.view.schoollist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import security.bercy.com.nycschoollist.R;
import security.bercy.com.nycschoollist.SchoolApplication;
import security.bercy.com.nycschoollist.data.RemoteDataSource;
import security.bercy.com.nycschoollist.model.School;

public class SchoolList extends AppCompatActivity implements SchoolListContract.View{

    private List<School> schoolList = new ArrayList<>();

    @Inject
    SchoolListPresenter presenter;
    private RecyclerView rvRecipeList;
    private RecyclerView.LayoutManager layoutManager;
    private SchoolListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        setupDaggerComponent();


    }

    private void setupDaggerComponent() {

        SchoolApplication.get(this).getRecipeListComponent().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateSchool(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @Override
    public void showProgress(int MODE) {

    }
}
