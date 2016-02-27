package de.androidbytes.recipr.app.data.provider.step;

import de.androidbytes.recipr.app.data.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A recipe is an Entity used to combine related ingredients and steps for preparation.
 */
public interface StepModel extends BaseModel {

    /**
     * Get the {@code recipe_id} value.
     */
    long getRecipeId();

    /**
     * Title of the Step.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Instruction of the preparation step.
     * Can be {@code null}.
     */
    @Nullable
    String getInstruction();
}
