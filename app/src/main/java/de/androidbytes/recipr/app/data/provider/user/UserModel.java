package de.androidbytes.recipr.app.data.provider.user;

import de.androidbytes.recipr.app.data.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A user is an account assigned to the physical human using Plannr.
 */
public interface UserModel extends BaseModel {

    /**
     * Google Id. Provided by the Authorization Service like Google.
     * Can be {@code null}.
     */
    @Nullable
    Integer getGoogleId();

    /**
     * Firstname of the user account.
     * Can be {@code null}.
     */
    @Nullable
    String getFirstname();

    /**
     * Name of the user. Provided by the Authorization Service like Google.
     * Can be {@code null}.
     */
    @Nullable
    String getLastname();

    /**
     * Url to an image source used as a profile picture of the specific user account.
     * Can be {@code null}.
     */
    @Nullable
    String getImageUrl();
}
