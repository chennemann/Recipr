/**
 * Copyright (C) 2016 Christoph Hennemann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.androidbytes.recipr.app;

import android.app.Application;
import android.content.Context;

import de.androidbytes.recipr.app.di.components.ApplicationComponent;
import de.androidbytes.recipr.app.di.components.DaggerApplicationComponent;
import de.androidbytes.recipr.app.di.modules.ApplicationModule;

/**
 * Custom implementation of the {@link Application} class to expose the
 * {@link ApplicationComponent} for dependency injection.
 */
public class ReciprApplication extends Application {

    private ApplicationComponent component;

    /**
     * Create a {@link ApplicationModule} assigned to the current {@link ReciprApplication}
     * instance.
     *
     * @return New {@link ApplicationModule} with reference to  current {@link Application}
     * object.
     */
    private ApplicationModule getApplicationModule() {
        return new ApplicationModule(this);
    }

    /**
     * Retrieve the {@link ApplicationComponent} assigned to the current {@link ReciprApplication}
     * instance or create it.
     *
     * @param context {@link Context} used to retrieve the current {@link Application}
     *                object.
     * @return The assigned {@link ApplicationComponent}.
     */
    public static ApplicationComponent getApplicationComponent(Context context) {
        final ReciprApplication reciprApplication = ((ReciprApplication) context.getApplicationContext());
        if (reciprApplication.component == null) {
            reciprApplication.component = DaggerApplicationComponent.builder()
                    .applicationModule(reciprApplication.getApplicationModule())
                    .build();
        }
        return reciprApplication.component;
    }

}
