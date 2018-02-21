package security.bercy.com.nycschoollist.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Bercy on 2/20/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
