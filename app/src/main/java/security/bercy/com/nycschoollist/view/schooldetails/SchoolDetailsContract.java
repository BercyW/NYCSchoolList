package security.bercy.com.nycschoollist.view.schooldetails;

import security.bercy.com.nycschoollist.model.School;
import security.bercy.com.nycschoollist.utils.BasePresenter;
import security.bercy.com.nycschoollist.utils.BaseView;
import security.bercy.com.nycschoollist.view.schoollist.SchoolList;

/**
 * Created by Bercy on 2/20/18.
 */

public interface SchoolDetailsContract {
    interface View extends BaseView {
        void setMath(String math);
        void setReading(String reading);
        void setWriting(String writing);
    }
    interface Presenter extends BasePresenter<View>{
        void initData(School school);
    }


}
