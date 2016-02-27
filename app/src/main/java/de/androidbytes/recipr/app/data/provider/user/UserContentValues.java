package de.androidbytes.recipr.app.data.provider.user;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import de.androidbytes.recipr.app.data.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code user} table.
 */
public class UserContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return UserColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable UserSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable UserSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Google Id. Provided by the Authorization Service like Google.
     */
    public UserContentValues putGoogleId(@Nullable Integer value) {
        mContentValues.put(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserContentValues putGoogleIdNull() {
        mContentValues.putNull(UserColumns.GOOGLE_ID);
        return this;
    }

    /**
     * Firstname of the user account.
     */
    public UserContentValues putFirstname(@Nullable String value) {
        mContentValues.put(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserContentValues putFirstnameNull() {
        mContentValues.putNull(UserColumns.FIRSTNAME);
        return this;
    }

    /**
     * Name of the user. Provided by the Authorization Service like Google.
     */
    public UserContentValues putLastname(@Nullable String value) {
        mContentValues.put(UserColumns.LASTNAME, value);
        return this;
    }

    public UserContentValues putLastnameNull() {
        mContentValues.putNull(UserColumns.LASTNAME);
        return this;
    }

    /**
     * Url to an image source used as a profile picture of the specific user account.
     */
    public UserContentValues putImageUrl(@Nullable String value) {
        mContentValues.put(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserContentValues putImageUrlNull() {
        mContentValues.putNull(UserColumns.IMAGE_URL);
        return this;
    }
}
