/**
 * Copyright (C) 2016 Christoph Hennemann
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.androidbytes.recipr.app.base.di.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import de.androidbytes.recipr.app.ReciprApplication;

import javax.inject.Singleton;

/**
 * Dagger Module for application wide dependencies
 */
@Module
public class ApplicationModule {

    private ReciprApplication mReciprApplication;

    /**
     * Constructor of {@link ApplicationModule}.
     * @param reciprApplication {@link ReciprApplication} instance referenced inside the
     * {@link ApplicationModule}.
     */
    public ApplicationModule(ReciprApplication reciprApplication) {
        mReciprApplication = reciprApplication;
    }

    /**
     * Provider method to retrieve the applications default {@link SharedPreferences}.
     *
     * @return A {@link SharedPreferences} singleton used all over the application.
     */
    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mReciprApplication);
    }

}
