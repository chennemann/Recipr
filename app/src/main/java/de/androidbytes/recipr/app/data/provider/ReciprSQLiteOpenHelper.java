package de.androidbytes.recipr.app.data.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import de.androidbytes.recipr.app.BuildConfig;
import de.androidbytes.recipr.app.data.provider.ingredient.IngredientColumns;
import de.androidbytes.recipr.app.data.provider.recipe.RecipeColumns;
import de.androidbytes.recipr.app.data.provider.step.StepColumns;
import de.androidbytes.recipr.app.data.provider.user.UserColumns;

public class ReciprSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = ReciprSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "recipr.db";
    private static final int DATABASE_VERSION = 1;
    private static ReciprSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final ReciprSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_INGREDIENT = "CREATE TABLE IF NOT EXISTS "
            + IngredientColumns.TABLE_NAME + " ( "
            + IngredientColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + IngredientColumns.RECIPE_ID + " INTEGER NOT NULL, "
            + IngredientColumns.NAME + " TEXT, "
            + IngredientColumns.QUANTITY + " INTEGER "
            + ", CONSTRAINT fk_recipe_id FOREIGN KEY (" + IngredientColumns.RECIPE_ID + ") REFERENCES recipe (_id) ON DELETE RESTRICT"
            + " );";

    public static final String SQL_CREATE_TABLE_RECIPE = "CREATE TABLE IF NOT EXISTS "
            + RecipeColumns.TABLE_NAME + " ( "
            + RecipeColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + RecipeColumns.USER_ID + " INTEGER NOT NULL, "
            + RecipeColumns.NAME + " TEXT, "
            + RecipeColumns.RATING + " INTEGER, "
            + RecipeColumns.IMAGE_URL + " TEXT "
            + ", CONSTRAINT fk_user_id FOREIGN KEY (" + RecipeColumns.USER_ID + ") REFERENCES user (_id) ON DELETE RESTRICT"
            + " );";

    public static final String SQL_CREATE_TABLE_STEP = "CREATE TABLE IF NOT EXISTS "
            + StepColumns.TABLE_NAME + " ( "
            + StepColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + StepColumns.RECIPE_ID + " INTEGER NOT NULL, "
            + StepColumns.TITLE + " TEXT, "
            + StepColumns.INSTRUCTION + " TEXT "
            + ", CONSTRAINT fk_recipe_id FOREIGN KEY (" + StepColumns.RECIPE_ID + ") REFERENCES recipe (_id) ON DELETE RESTRICT"
            + " );";

    public static final String SQL_CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS "
            + UserColumns.TABLE_NAME + " ( "
            + UserColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserColumns.GOOGLE_ID + " INTEGER, "
            + UserColumns.FIRSTNAME + " TEXT, "
            + UserColumns.LASTNAME + " TEXT, "
            + UserColumns.IMAGE_URL + " TEXT "
            + ", CONSTRAINT unique_google_id UNIQUE (google_id) ON CONFLICT REPLACE"
            + " );";

    // @formatter:on

    public static ReciprSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static ReciprSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static ReciprSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new ReciprSQLiteOpenHelper(context);
    }

    private ReciprSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new ReciprSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static ReciprSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new ReciprSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private ReciprSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new ReciprSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_INGREDIENT);
        db.execSQL(SQL_CREATE_TABLE_RECIPE);
        db.execSQL(SQL_CREATE_TABLE_STEP);
        db.execSQL(SQL_CREATE_TABLE_USER);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
