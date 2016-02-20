package de.androidbytes.recipr.app;

import android.app.Application;
import android.content.Context;
import de.androidbytes.recipr.app.di.components.ApplicationComponent;
import de.androidbytes.recipr.app.di.components.DaggerApplicationComponent;
import de.androidbytes.recipr.app.di.modules.ApplicationModule;

/**
 * Created by Christoph on 20.02.2016.
 */
public class Recipr extends Application {

    private ApplicationComponent component;

    protected ApplicationModule getApplicationModule() {
        return new ApplicationModule(this);
    }

    public static ApplicationComponent getApplicationComponent(Context context) {
        final Recipr recipr = ((Recipr) context.getApplicationContext());
        if (recipr.component == null) {
            recipr.component = DaggerApplicationComponent.builder()
                .applicationModule(recipr.getApplicationModule())
                    .build();
        }
        return recipr.component;
    }

}
