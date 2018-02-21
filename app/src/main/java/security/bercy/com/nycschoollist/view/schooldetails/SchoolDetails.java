package security.bercy.com.nycschoollist.view.schooldetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import security.bercy.com.nycschoollist.R;
import security.bercy.com.nycschoollist.SchoolApplication;
import security.bercy.com.nycschoollist.model.School;
import security.bercy.com.nycschoollist.view.schoollist.SchoolList;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolDetails extends AppCompatActivity implements SchoolDetailsContract.View {

    @Inject
    SchoolDetailsPresenter presenter;
    private TextView tv_math;
    private TextView tv_reading;
    private TextView tv_writing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);
        setupDaggerComponent();
        presenter.attachView(this);
        bindViews();
        presenter.initData(getSchool());

    }

    private School getSchool() {
        School school = (School) getIntent().getSerializableExtra("school");
        return school;
    }

    private void bindViews() {
        tv_math = findViewById(R.id.tv_math);
        tv_reading = findViewById(R.id.tv_reading);
        tv_writing = findViewById(R.id.tv_writing);

    }

    private void setupDaggerComponent() {

        SchoolApplication.get(this).getSchoolDetailsComponent().inject(this);


    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setMath(String math) {
        tv_math.setText(math);
    }

    @Override
    public void setReading(String reading) {
        tv_reading.setText(reading);
    }

    @Override
    public void setWriting(String writing) {
        tv_writing.setText(writing);
    }
}
