package de.androidbytes.recipr.app.di.modules;

import dagger.Module;
import de.androidbytes.recipr.app.Recipr;

/**
 * Created by Christoph on 20.02.2016.
 */
@Module
public class ApplicationModule {

    private Recipr mRecipr;

    public ApplicationModule(Recipr recipr) {
        mRecipr = recipr;
    }

}
