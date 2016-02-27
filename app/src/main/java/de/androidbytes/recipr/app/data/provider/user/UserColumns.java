package de.androidbytes.recipr.app.data.provider.user;

import android.net.Uri;
import android.provider.BaseColumns;

import de.androidbytes.recipr.app.data.provider.ReciprProvider;
import de.androidbytes.recipr.app.data.provider.ingredient.IngredientColumns;
import de.androidbytes.recipr.app.data.provider.recipe.RecipeColumns;
import de.androidbytes.recipr.app.data.provider.step.StepColumns;
import de.androidbytes.recipr.app.data.provider.user.UserColumns;

/**
 * A user is an account assigned to the physical human using Plannr.
 */
public class UserColumns implements BaseColumns {
    public static final String TABLE_NAME = "user";
    public static final Uri CONTENT_URI = Uri.parse(ReciprProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Google Id. Provided by the Authorization Service like Google.
     */
    public static final String GOOGLE_ID = "google_id";

    /**
     * Firstname of the user account.
     */
    public static final String FIRSTNAME = "firstname";

    /**
     * Name of the user. Provided by the Authorization Service like Google.
     */
    public static final String LASTNAME = "lastname";

    /**
     * Url to an image source used as a profile picture of the specific user account.
     */
    public static final String IMAGE_URL = "user__image_url";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            GOOGLE_ID,
            FIRSTNAME,
            LASTNAME,
            IMAGE_URL
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(GOOGLE_ID) || c.contains("." + GOOGLE_ID)) return true;
            if (c.equals(FIRSTNAME) || c.contains("." + FIRSTNAME)) return true;
            if (c.equals(LASTNAME) || c.contains("." + LASTNAME)) return true;
            if (c.equals(IMAGE_URL) || c.contains("." + IMAGE_URL)) return true;
        }
        return false;
    }

}
