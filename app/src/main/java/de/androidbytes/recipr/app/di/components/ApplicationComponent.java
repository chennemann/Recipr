package de.androidbytes.recipr.app.di.components;

import dagger.Component;
import de.androidbytes.recipr.app.di.modules.ApplicationModule;

import javax.inject.Singleton;

/**
 * Created by Christoph on 20.02.2016.
 */
@Component(
        modules = ApplicationModule.class
)
@Singleton
public interface ApplicationComponent {

}
