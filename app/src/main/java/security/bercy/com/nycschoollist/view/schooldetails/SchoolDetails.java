package security.bercy.com.nycschoollist.view.schooldetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import security.bercy.com.nycschoollist.SchoolApplication;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolDetails extends AppCompatActivity implements SchoolDetailsContract.View{

    @Inject
    SchoolDetailsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDaggerComponent();
        presenter.attachView(this);


    }

    private void setupDaggerComponent() {

        SchoolApplication.get(this).getSchoolDetailsComponent().inject(this);


    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setMath(String math) {

    }

    @Override
    public void setReading(String reading) {

    }

    @Override
    public void setWriting(String writing) {

    }
}
