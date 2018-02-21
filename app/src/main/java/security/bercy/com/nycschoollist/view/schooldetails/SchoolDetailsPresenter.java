package security.bercy.com.nycschoollist.view.schooldetails;

import security.bercy.com.nycschoollist.view.schoollist.SchoolList;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolDetailsPresenter implements SchoolDetailsContract.Presenter {
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
    public void initData(SchoolList school) {

    }
}
