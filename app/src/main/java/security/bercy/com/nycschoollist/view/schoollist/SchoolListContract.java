package security.bercy.com.nycschoollist.view.schoollist;

import java.util.List;

import security.bercy.com.nycschoollist.model.School;
import security.bercy.com.nycschoollist.utils.BasePresenter;
import security.bercy.com.nycschoollist.utils.BaseView;

/**
 * Created by Bercy on 2/20/18.
 */

public interface SchoolListContract {

    interface View extends BaseView {

        void updateSchool(List<School> schoolList);
        void showProgress(int MODE);
    }

    interface Presenter extends BasePresenter<View> {
        void getSchool();


    }
}
