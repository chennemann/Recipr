package de.androidbytes.recipr.app.data.provider.recipe;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import de.androidbytes.recipr.app.data.provider.base.AbstractCursor;
import de.androidbytes.recipr.app.data.provider.user.*;

/**
 * Cursor wrapper for the {@code recipe} table.
 */
public class RecipeCursor extends AbstractCursor implements RecipeModel {
    public RecipeCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(RecipeColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code user_id} value.
     */
    public long getUserId() {
        Long res = getLongOrNull(RecipeColumns.USER_ID);
        if (res == null)
            throw new NullPointerException("The value of 'user_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Google Id. Provided by the Authorization Service like Google.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getUserGoogleId() {
        Integer res = getIntegerOrNull(UserColumns.GOOGLE_ID);
        return res;
    }

    /**
     * Firstname of the user account.
     * Can be {@code null}.
     */
    @Nullable
    public String getUserFirstname() {
        String res = getStringOrNull(UserColumns.FIRSTNAME);
        return res;
    }

    /**
     * Name of the user. Provided by the Authorization Service like Google.
     * Can be {@code null}.
     */
    @Nullable
    public String getUserLastname() {
        String res = getStringOrNull(UserColumns.LASTNAME);
        return res;
    }

    /**
     * Url to an image source used as a profile picture of the specific user account.
     * Can be {@code null}.
     */
    @Nullable
    public String getUserImageUrl() {
        String res = getStringOrNull(UserColumns.IMAGE_URL);
        return res;
    }

    /**
     * Name of the recipe.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(RecipeColumns.NAME);
        return res;
    }

    /**
     * Rating of the recipe.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getRating() {
        Integer res = getIntegerOrNull(RecipeColumns.RATING);
        return res;
    }

    /**
     * Image Url of the recipe.
     * Can be {@code null}.
     */
    @Nullable
    public String getImageUrl() {
        String res = getStringOrNull(RecipeColumns.IMAGE_URL);
        return res;
    }
}
