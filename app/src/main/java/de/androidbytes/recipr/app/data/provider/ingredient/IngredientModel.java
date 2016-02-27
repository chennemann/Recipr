package de.androidbytes.recipr.app.data.provider.ingredient;

import de.androidbytes.recipr.app.data.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A recipe is an Entity used to combine related ingredients and steps for preparation.
 */
public interface IngredientModel extends BaseModel {

    /**
     * Get the {@code recipe_id} value.
     */
    long getRecipeId();

    /**
     * Name of the recipe.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Rating of the recipe.
     * Can be {@code null}.
     */
    @Nullable
    Integer getQuantity();
}
