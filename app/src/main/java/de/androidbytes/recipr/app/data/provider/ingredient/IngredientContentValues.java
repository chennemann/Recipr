package de.androidbytes.recipr.app.data.provider.ingredient;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import de.androidbytes.recipr.app.data.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code ingredient} table.
 */
public class IngredientContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return IngredientColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable IngredientSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable IngredientSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public IngredientContentValues putRecipeId(long value) {
        mContentValues.put(IngredientColumns.RECIPE_ID, value);
        return this;
    }


    /**
     * Name of the recipe.
     */
    public IngredientContentValues putName(@Nullable String value) {
        mContentValues.put(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientContentValues putNameNull() {
        mContentValues.putNull(IngredientColumns.NAME);
        return this;
    }

    /**
     * Rating of the recipe.
     */
    public IngredientContentValues putQuantity(@Nullable Integer value) {
        mContentValues.put(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientContentValues putQuantityNull() {
        mContentValues.putNull(IngredientColumns.QUANTITY);
        return this;
    }
}
