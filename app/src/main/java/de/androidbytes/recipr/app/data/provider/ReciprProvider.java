package de.androidbytes.recipr.app.data.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import de.androidbytes.recipr.app.BuildConfig;
import de.androidbytes.recipr.app.data.provider.base.BaseContentProvider;
import de.androidbytes.recipr.app.data.provider.ingredient.IngredientColumns;
import de.androidbytes.recipr.app.data.provider.recipe.RecipeColumns;
import de.androidbytes.recipr.app.data.provider.step.StepColumns;
import de.androidbytes.recipr.app.data.provider.user.UserColumns;

import java.util.Arrays;

public class ReciprProvider extends BaseContentProvider {
    private static final String TAG = ReciprProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "de.androidbytes.recipr.app.data.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_INGREDIENT = 0;
    private static final int URI_TYPE_INGREDIENT_ID = 1;

    private static final int URI_TYPE_RECIPE = 2;
    private static final int URI_TYPE_RECIPE_ID = 3;

    private static final int URI_TYPE_STEP = 4;
    private static final int URI_TYPE_STEP_ID = 5;

    private static final int URI_TYPE_USER = 6;
    private static final int URI_TYPE_USER_ID = 7;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, IngredientColumns.TABLE_NAME, URI_TYPE_INGREDIENT);
        URI_MATCHER.addURI(AUTHORITY, IngredientColumns.TABLE_NAME + "/#", URI_TYPE_INGREDIENT_ID);
        URI_MATCHER.addURI(AUTHORITY, RecipeColumns.TABLE_NAME, URI_TYPE_RECIPE);
        URI_MATCHER.addURI(AUTHORITY, RecipeColumns.TABLE_NAME + "/#", URI_TYPE_RECIPE_ID);
        URI_MATCHER.addURI(AUTHORITY, StepColumns.TABLE_NAME, URI_TYPE_STEP);
        URI_MATCHER.addURI(AUTHORITY, StepColumns.TABLE_NAME + "/#", URI_TYPE_STEP_ID);
        URI_MATCHER.addURI(AUTHORITY, UserColumns.TABLE_NAME, URI_TYPE_USER);
        URI_MATCHER.addURI(AUTHORITY, UserColumns.TABLE_NAME + "/#", URI_TYPE_USER_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return ReciprSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_INGREDIENT:
                return TYPE_CURSOR_DIR + IngredientColumns.TABLE_NAME;
            case URI_TYPE_INGREDIENT_ID:
                return TYPE_CURSOR_ITEM + IngredientColumns.TABLE_NAME;

            case URI_TYPE_RECIPE:
                return TYPE_CURSOR_DIR + RecipeColumns.TABLE_NAME;
            case URI_TYPE_RECIPE_ID:
                return TYPE_CURSOR_ITEM + RecipeColumns.TABLE_NAME;

            case URI_TYPE_STEP:
                return TYPE_CURSOR_DIR + StepColumns.TABLE_NAME;
            case URI_TYPE_STEP_ID:
                return TYPE_CURSOR_ITEM + StepColumns.TABLE_NAME;

            case URI_TYPE_USER:
                return TYPE_CURSOR_DIR + UserColumns.TABLE_NAME;
            case URI_TYPE_USER_ID:
                return TYPE_CURSOR_ITEM + UserColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_INGREDIENT:
            case URI_TYPE_INGREDIENT_ID:
                res.table = IngredientColumns.TABLE_NAME;
                res.idColumn = IngredientColumns._ID;
                res.tablesWithJoins = IngredientColumns.TABLE_NAME;
                if (RecipeColumns.hasColumns(projection) || UserColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + RecipeColumns.TABLE_NAME + " AS " + IngredientColumns.PREFIX_RECIPE + " ON " + IngredientColumns.TABLE_NAME + "." + IngredientColumns.RECIPE_ID + "=" + IngredientColumns.PREFIX_RECIPE + "." + RecipeColumns._ID;
                }
                if (UserColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + UserColumns.TABLE_NAME + " AS " + RecipeColumns.PREFIX_USER + " ON " + IngredientColumns.PREFIX_RECIPE + "." + RecipeColumns.USER_ID + "=" + RecipeColumns.PREFIX_USER + "." + UserColumns._ID;
                }
                res.orderBy = IngredientColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_RECIPE:
            case URI_TYPE_RECIPE_ID:
                res.table = RecipeColumns.TABLE_NAME;
                res.idColumn = RecipeColumns._ID;
                res.tablesWithJoins = RecipeColumns.TABLE_NAME;
                if (UserColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + UserColumns.TABLE_NAME + " AS " + RecipeColumns.PREFIX_USER + " ON " + RecipeColumns.TABLE_NAME + "." + RecipeColumns.USER_ID + "=" + RecipeColumns.PREFIX_USER + "." + UserColumns._ID;
                }
                res.orderBy = RecipeColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_STEP:
            case URI_TYPE_STEP_ID:
                res.table = StepColumns.TABLE_NAME;
                res.idColumn = StepColumns._ID;
                res.tablesWithJoins = StepColumns.TABLE_NAME;
                if (RecipeColumns.hasColumns(projection) || UserColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + RecipeColumns.TABLE_NAME + " AS " + StepColumns.PREFIX_RECIPE + " ON " + StepColumns.TABLE_NAME + "." + StepColumns.RECIPE_ID + "=" + StepColumns.PREFIX_RECIPE + "." + RecipeColumns._ID;
                }
                if (UserColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + UserColumns.TABLE_NAME + " AS " + RecipeColumns.PREFIX_USER + " ON " + StepColumns.PREFIX_RECIPE + "." + RecipeColumns.USER_ID + "=" + RecipeColumns.PREFIX_USER + "." + UserColumns._ID;
                }
                res.orderBy = StepColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_USER:
            case URI_TYPE_USER_ID:
                res.table = UserColumns.TABLE_NAME;
                res.idColumn = UserColumns._ID;
                res.tablesWithJoins = UserColumns.TABLE_NAME;
                res.orderBy = UserColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_INGREDIENT_ID:
            case URI_TYPE_RECIPE_ID:
            case URI_TYPE_STEP_ID:
            case URI_TYPE_USER_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
