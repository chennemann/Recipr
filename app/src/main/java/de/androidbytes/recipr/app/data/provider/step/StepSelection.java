package de.androidbytes.recipr.app.data.provider.step;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import de.androidbytes.recipr.app.data.provider.base.AbstractSelection;
import de.androidbytes.recipr.app.data.provider.recipe.*;
import de.androidbytes.recipr.app.data.provider.user.*;

/**
 * Selection for the {@code step} table.
 */
public class StepSelection extends AbstractSelection<StepSelection> {
    @Override
    protected Uri baseUri() {
        return StepColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code StepCursor} object, which is positioned before the first entry, or null.
     */
    public StepCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new StepCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public StepCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code StepCursor} object, which is positioned before the first entry, or null.
     */
    public StepCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new StepCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public StepCursor query(Context context) {
        return query(context, null);
    }


    public StepSelection id(long... value) {
        addEquals("step." + StepColumns._ID, toObjectArray(value));
        return this;
    }

    public StepSelection idNot(long... value) {
        addNotEquals("step." + StepColumns._ID, toObjectArray(value));
        return this;
    }

    public StepSelection orderById(boolean desc) {
        orderBy("step." + StepColumns._ID, desc);
        return this;
    }

    public StepSelection orderById() {
        return orderById(false);
    }

    public StepSelection recipeId(long... value) {
        addEquals(StepColumns.RECIPE_ID, toObjectArray(value));
        return this;
    }

    public StepSelection recipeIdNot(long... value) {
        addNotEquals(StepColumns.RECIPE_ID, toObjectArray(value));
        return this;
    }

    public StepSelection recipeIdGt(long value) {
        addGreaterThan(StepColumns.RECIPE_ID, value);
        return this;
    }

    public StepSelection recipeIdGtEq(long value) {
        addGreaterThanOrEquals(StepColumns.RECIPE_ID, value);
        return this;
    }

    public StepSelection recipeIdLt(long value) {
        addLessThan(StepColumns.RECIPE_ID, value);
        return this;
    }

    public StepSelection recipeIdLtEq(long value) {
        addLessThanOrEquals(StepColumns.RECIPE_ID, value);
        return this;
    }

    public StepSelection orderByRecipeId(boolean desc) {
        orderBy(StepColumns.RECIPE_ID, desc);
        return this;
    }

    public StepSelection orderByRecipeId() {
        orderBy(StepColumns.RECIPE_ID, false);
        return this;
    }

    public StepSelection recipeUserId(long... value) {
        addEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public StepSelection recipeUserIdNot(long... value) {
        addNotEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public StepSelection recipeUserIdGt(long value) {
        addGreaterThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public StepSelection recipeUserIdGtEq(long value) {
        addGreaterThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public StepSelection recipeUserIdLt(long value) {
        addLessThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public StepSelection recipeUserIdLtEq(long value) {
        addLessThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public StepSelection orderByRecipeUserId(boolean desc) {
        orderBy(RecipeColumns.USER_ID, desc);
        return this;
    }

    public StepSelection orderByRecipeUserId() {
        orderBy(RecipeColumns.USER_ID, false);
        return this;
    }

    public StepSelection recipeUserGoogleId(Integer... value) {
        addEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection recipeUserGoogleIdNot(Integer... value) {
        addNotEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection recipeUserGoogleIdGt(int value) {
        addGreaterThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection recipeUserGoogleIdGtEq(int value) {
        addGreaterThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection recipeUserGoogleIdLt(int value) {
        addLessThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection recipeUserGoogleIdLtEq(int value) {
        addLessThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public StepSelection orderByRecipeUserGoogleId(boolean desc) {
        orderBy(UserColumns.GOOGLE_ID, desc);
        return this;
    }

    public StepSelection orderByRecipeUserGoogleId() {
        orderBy(UserColumns.GOOGLE_ID, false);
        return this;
    }

    public StepSelection recipeUserFirstname(String... value) {
        addEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection recipeUserFirstnameNot(String... value) {
        addNotEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection recipeUserFirstnameLike(String... value) {
        addLike(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection recipeUserFirstnameContains(String... value) {
        addContains(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection recipeUserFirstnameStartsWith(String... value) {
        addStartsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection recipeUserFirstnameEndsWith(String... value) {
        addEndsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public StepSelection orderByRecipeUserFirstname(boolean desc) {
        orderBy(UserColumns.FIRSTNAME, desc);
        return this;
    }

    public StepSelection orderByRecipeUserFirstname() {
        orderBy(UserColumns.FIRSTNAME, false);
        return this;
    }

    public StepSelection recipeUserLastname(String... value) {
        addEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection recipeUserLastnameNot(String... value) {
        addNotEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection recipeUserLastnameLike(String... value) {
        addLike(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection recipeUserLastnameContains(String... value) {
        addContains(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection recipeUserLastnameStartsWith(String... value) {
        addStartsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection recipeUserLastnameEndsWith(String... value) {
        addEndsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public StepSelection orderByRecipeUserLastname(boolean desc) {
        orderBy(UserColumns.LASTNAME, desc);
        return this;
    }

    public StepSelection orderByRecipeUserLastname() {
        orderBy(UserColumns.LASTNAME, false);
        return this;
    }

    public StepSelection recipeUserImageUrl(String... value) {
        addEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeUserImageUrlNot(String... value) {
        addNotEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeUserImageUrlLike(String... value) {
        addLike(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeUserImageUrlContains(String... value) {
        addContains(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeUserImageUrlStartsWith(String... value) {
        addStartsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeUserImageUrlEndsWith(String... value) {
        addEndsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection orderByRecipeUserImageUrl(boolean desc) {
        orderBy(UserColumns.IMAGE_URL, desc);
        return this;
    }

    public StepSelection orderByRecipeUserImageUrl() {
        orderBy(UserColumns.IMAGE_URL, false);
        return this;
    }

    public StepSelection recipeName(String... value) {
        addEquals(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection recipeNameNot(String... value) {
        addNotEquals(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection recipeNameLike(String... value) {
        addLike(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection recipeNameContains(String... value) {
        addContains(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection recipeNameStartsWith(String... value) {
        addStartsWith(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection recipeNameEndsWith(String... value) {
        addEndsWith(RecipeColumns.NAME, value);
        return this;
    }

    public StepSelection orderByRecipeName(boolean desc) {
        orderBy(RecipeColumns.NAME, desc);
        return this;
    }

    public StepSelection orderByRecipeName() {
        orderBy(RecipeColumns.NAME, false);
        return this;
    }

    public StepSelection recipeRating(Integer... value) {
        addEquals(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection recipeRatingNot(Integer... value) {
        addNotEquals(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection recipeRatingGt(int value) {
        addGreaterThan(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection recipeRatingGtEq(int value) {
        addGreaterThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection recipeRatingLt(int value) {
        addLessThan(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection recipeRatingLtEq(int value) {
        addLessThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public StepSelection orderByRecipeRating(boolean desc) {
        orderBy(RecipeColumns.RATING, desc);
        return this;
    }

    public StepSelection orderByRecipeRating() {
        orderBy(RecipeColumns.RATING, false);
        return this;
    }

    public StepSelection recipeImageUrl(String... value) {
        addEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeImageUrlNot(String... value) {
        addNotEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeImageUrlLike(String... value) {
        addLike(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeImageUrlContains(String... value) {
        addContains(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeImageUrlStartsWith(String... value) {
        addStartsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection recipeImageUrlEndsWith(String... value) {
        addEndsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public StepSelection orderByRecipeImageUrl(boolean desc) {
        orderBy(RecipeColumns.IMAGE_URL, desc);
        return this;
    }

    public StepSelection orderByRecipeImageUrl() {
        orderBy(RecipeColumns.IMAGE_URL, false);
        return this;
    }

    public StepSelection title(String... value) {
        addEquals(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection titleNot(String... value) {
        addNotEquals(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection titleLike(String... value) {
        addLike(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection titleContains(String... value) {
        addContains(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection titleStartsWith(String... value) {
        addStartsWith(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection titleEndsWith(String... value) {
        addEndsWith(StepColumns.TITLE, value);
        return this;
    }

    public StepSelection orderByTitle(boolean desc) {
        orderBy(StepColumns.TITLE, desc);
        return this;
    }

    public StepSelection orderByTitle() {
        orderBy(StepColumns.TITLE, false);
        return this;
    }

    public StepSelection instruction(String... value) {
        addEquals(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection instructionNot(String... value) {
        addNotEquals(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection instructionLike(String... value) {
        addLike(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection instructionContains(String... value) {
        addContains(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection instructionStartsWith(String... value) {
        addStartsWith(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection instructionEndsWith(String... value) {
        addEndsWith(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepSelection orderByInstruction(boolean desc) {
        orderBy(StepColumns.INSTRUCTION, desc);
        return this;
    }

    public StepSelection orderByInstruction() {
        orderBy(StepColumns.INSTRUCTION, false);
        return this;
    }
}
