package de.androidbytes.recipr.app.data.provider.step;

import android.net.Uri;
import android.provider.BaseColumns;

import de.androidbytes.recipr.app.data.provider.ReciprProvider;
import de.androidbytes.recipr.app.data.provider.ingredient.IngredientColumns;
import de.androidbytes.recipr.app.data.provider.recipe.RecipeColumns;
import de.androidbytes.recipr.app.data.provider.step.StepColumns;
import de.androidbytes.recipr.app.data.provider.user.UserColumns;

/**
 * A recipe is an Entity used to combine related ingredients and steps for preparation.
 */
public class StepColumns implements BaseColumns {
    public static final String TABLE_NAME = "step";
    public static final Uri CONTENT_URI = Uri.parse(ReciprProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String RECIPE_ID = "recipe_id";

    /**
     * Title of the Step.
     */
    public static final String TITLE = "title";

    /**
     * Instruction of the preparation step.
     */
    public static final String INSTRUCTION = "instruction";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            RECIPE_ID,
            TITLE,
            INSTRUCTION
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(RECIPE_ID) || c.contains("." + RECIPE_ID)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(INSTRUCTION) || c.contains("." + INSTRUCTION)) return true;
        }
        return false;
    }

    public static final String PREFIX_RECIPE = TABLE_NAME + "__" + RecipeColumns.TABLE_NAME;
}
