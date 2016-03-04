package de.androidbytes.recipr.app.data.provider.recipe;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import de.androidbytes.recipr.app.data.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code recipe} table.
 */
public class RecipeContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return RecipeColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable RecipeSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context used to retrieve the content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable RecipeSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public RecipeContentValues putUserId(long value) {
        mContentValues.put(RecipeColumns.USER_ID, value);
        return this;
    }


    /**
     * Name of the recipe.
     */
    public RecipeContentValues putName(@Nullable String value) {
        mContentValues.put(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeContentValues putNameNull() {
        mContentValues.putNull(RecipeColumns.NAME);
        return this;
    }

    /**
     * Rating of the recipe.
     */
    public RecipeContentValues putRating(@Nullable Integer value) {
        mContentValues.put(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeContentValues putRatingNull() {
        mContentValues.putNull(RecipeColumns.RATING);
        return this;
    }

    /**
     * Image Url of the recipe.
     */
    public RecipeContentValues putImageUrl(@Nullable String value) {
        mContentValues.put(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeContentValues putImageUrlNull() {
        mContentValues.putNull(RecipeColumns.IMAGE_URL);
        return this;
    }
}
