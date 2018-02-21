package security.bercy.com.nycschoollist.view.schoollist;

import javax.inject.Inject;

import security.bercy.com.nycschoollist.data.RemoteDataSource;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolListPresenter {

    RemoteDataSource remoteDataSource;
    @Inject
    public SchoolListPresenter(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

}
