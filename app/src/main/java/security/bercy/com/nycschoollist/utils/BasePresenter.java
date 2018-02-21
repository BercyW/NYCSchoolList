package security.bercy.com.nycschoollist.utils;

/**
 * Created by Bercy on 2/20/18.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();

}
