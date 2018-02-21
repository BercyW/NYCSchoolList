package security.bercy.com.nycschoollist.view.schoollist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
    public static final String TAG = "SchoolList";
    List<School> schoolList = new ArrayList<>();

    @Inject
    SchoolListPresenter presenter;
    private RecyclerView rvSchoolList;
    private RecyclerView.LayoutManager layoutManager;
    private SchoolListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        setupDaggerComponent();
        presenter.attachView(this);
        presenter.getSchool();
        Log.d(TAG, "onCreate:111 "+schoolList);
        setupRecipeRecyclerView();

    }

    private void setupRecipeRecyclerView() {
        rvSchoolList = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rvSchoolList.setLayoutManager(layoutManager);
        rvSchoolList.addItemDecoration(new DividerItemDecoration(SchoolList.this,DividerItemDecoration.VERTICAL));
        adapter = new SchoolListAdapter(this, schoolList);

        rvSchoolList.setAdapter(adapter);
    }

    private void setupDaggerComponent() {

        SchoolApplication.get(this).getSchoolListComponent().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateSchool(List<School> schoolList) {
        this.schoolList.addAll(schoolList);
        adapter.notifyDataSetChanged();
    }

}
