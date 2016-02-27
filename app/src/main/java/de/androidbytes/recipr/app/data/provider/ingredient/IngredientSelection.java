package de.androidbytes.recipr.app.data.provider.ingredient;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import de.androidbytes.recipr.app.data.provider.base.AbstractSelection;
import de.androidbytes.recipr.app.data.provider.recipe.*;
import de.androidbytes.recipr.app.data.provider.user.*;

/**
 * Selection for the {@code ingredient} table.
 */
public class IngredientSelection extends AbstractSelection<IngredientSelection> {
    @Override
    protected Uri baseUri() {
        return IngredientColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code IngredientCursor} object, which is positioned before the first entry, or null.
     */
    public IngredientCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new IngredientCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public IngredientCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code IngredientCursor} object, which is positioned before the first entry, or null.
     */
    public IngredientCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new IngredientCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public IngredientCursor query(Context context) {
        return query(context, null);
    }


    public IngredientSelection id(long... value) {
        addEquals("ingredient." + IngredientColumns._ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection idNot(long... value) {
        addNotEquals("ingredient." + IngredientColumns._ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection orderById(boolean desc) {
        orderBy("ingredient." + IngredientColumns._ID, desc);
        return this;
    }

    public IngredientSelection orderById() {
        return orderById(false);
    }

    public IngredientSelection recipeId(long... value) {
        addEquals(IngredientColumns.RECIPE_ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection recipeIdNot(long... value) {
        addNotEquals(IngredientColumns.RECIPE_ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection recipeIdGt(long value) {
        addGreaterThan(IngredientColumns.RECIPE_ID, value);
        return this;
    }

    public IngredientSelection recipeIdGtEq(long value) {
        addGreaterThanOrEquals(IngredientColumns.RECIPE_ID, value);
        return this;
    }

    public IngredientSelection recipeIdLt(long value) {
        addLessThan(IngredientColumns.RECIPE_ID, value);
        return this;
    }

    public IngredientSelection recipeIdLtEq(long value) {
        addLessThanOrEquals(IngredientColumns.RECIPE_ID, value);
        return this;
    }

    public IngredientSelection orderByRecipeId(boolean desc) {
        orderBy(IngredientColumns.RECIPE_ID, desc);
        return this;
    }

    public IngredientSelection orderByRecipeId() {
        orderBy(IngredientColumns.RECIPE_ID, false);
        return this;
    }

    public IngredientSelection recipeUserId(long... value) {
        addEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection recipeUserIdNot(long... value) {
        addNotEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public IngredientSelection recipeUserIdGt(long value) {
        addGreaterThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public IngredientSelection recipeUserIdGtEq(long value) {
        addGreaterThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public IngredientSelection recipeUserIdLt(long value) {
        addLessThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public IngredientSelection recipeUserIdLtEq(long value) {
        addLessThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public IngredientSelection orderByRecipeUserId(boolean desc) {
        orderBy(RecipeColumns.USER_ID, desc);
        return this;
    }

    public IngredientSelection orderByRecipeUserId() {
        orderBy(RecipeColumns.USER_ID, false);
        return this;
    }

    public IngredientSelection recipeUserGoogleId(Integer... value) {
        addEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection recipeUserGoogleIdNot(Integer... value) {
        addNotEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection recipeUserGoogleIdGt(int value) {
        addGreaterThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection recipeUserGoogleIdGtEq(int value) {
        addGreaterThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection recipeUserGoogleIdLt(int value) {
        addLessThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection recipeUserGoogleIdLtEq(int value) {
        addLessThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public IngredientSelection orderByRecipeUserGoogleId(boolean desc) {
        orderBy(UserColumns.GOOGLE_ID, desc);
        return this;
    }

    public IngredientSelection orderByRecipeUserGoogleId() {
        orderBy(UserColumns.GOOGLE_ID, false);
        return this;
    }

    public IngredientSelection recipeUserFirstname(String... value) {
        addEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserFirstnameNot(String... value) {
        addNotEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserFirstnameLike(String... value) {
        addLike(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserFirstnameContains(String... value) {
        addContains(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserFirstnameStartsWith(String... value) {
        addStartsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserFirstnameEndsWith(String... value) {
        addEndsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public IngredientSelection orderByRecipeUserFirstname(boolean desc) {
        orderBy(UserColumns.FIRSTNAME, desc);
        return this;
    }

    public IngredientSelection orderByRecipeUserFirstname() {
        orderBy(UserColumns.FIRSTNAME, false);
        return this;
    }

    public IngredientSelection recipeUserLastname(String... value) {
        addEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserLastnameNot(String... value) {
        addNotEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserLastnameLike(String... value) {
        addLike(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserLastnameContains(String... value) {
        addContains(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserLastnameStartsWith(String... value) {
        addStartsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection recipeUserLastnameEndsWith(String... value) {
        addEndsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public IngredientSelection orderByRecipeUserLastname(boolean desc) {
        orderBy(UserColumns.LASTNAME, desc);
        return this;
    }

    public IngredientSelection orderByRecipeUserLastname() {
        orderBy(UserColumns.LASTNAME, false);
        return this;
    }

    public IngredientSelection recipeUserImageUrl(String... value) {
        addEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeUserImageUrlNot(String... value) {
        addNotEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeUserImageUrlLike(String... value) {
        addLike(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeUserImageUrlContains(String... value) {
        addContains(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeUserImageUrlStartsWith(String... value) {
        addStartsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeUserImageUrlEndsWith(String... value) {
        addEndsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection orderByRecipeUserImageUrl(boolean desc) {
        orderBy(UserColumns.IMAGE_URL, desc);
        return this;
    }

    public IngredientSelection orderByRecipeUserImageUrl() {
        orderBy(UserColumns.IMAGE_URL, false);
        return this;
    }

    public IngredientSelection recipeName(String... value) {
        addEquals(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection recipeNameNot(String... value) {
        addNotEquals(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection recipeNameLike(String... value) {
        addLike(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection recipeNameContains(String... value) {
        addContains(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection recipeNameStartsWith(String... value) {
        addStartsWith(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection recipeNameEndsWith(String... value) {
        addEndsWith(RecipeColumns.NAME, value);
        return this;
    }

    public IngredientSelection orderByRecipeName(boolean desc) {
        orderBy(RecipeColumns.NAME, desc);
        return this;
    }

    public IngredientSelection orderByRecipeName() {
        orderBy(RecipeColumns.NAME, false);
        return this;
    }

    public IngredientSelection recipeRating(Integer... value) {
        addEquals(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection recipeRatingNot(Integer... value) {
        addNotEquals(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection recipeRatingGt(int value) {
        addGreaterThan(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection recipeRatingGtEq(int value) {
        addGreaterThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection recipeRatingLt(int value) {
        addLessThan(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection recipeRatingLtEq(int value) {
        addLessThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public IngredientSelection orderByRecipeRating(boolean desc) {
        orderBy(RecipeColumns.RATING, desc);
        return this;
    }

    public IngredientSelection orderByRecipeRating() {
        orderBy(RecipeColumns.RATING, false);
        return this;
    }

    public IngredientSelection recipeImageUrl(String... value) {
        addEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeImageUrlNot(String... value) {
        addNotEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeImageUrlLike(String... value) {
        addLike(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeImageUrlContains(String... value) {
        addContains(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeImageUrlStartsWith(String... value) {
        addStartsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection recipeImageUrlEndsWith(String... value) {
        addEndsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public IngredientSelection orderByRecipeImageUrl(boolean desc) {
        orderBy(RecipeColumns.IMAGE_URL, desc);
        return this;
    }

    public IngredientSelection orderByRecipeImageUrl() {
        orderBy(RecipeColumns.IMAGE_URL, false);
        return this;
    }

    public IngredientSelection name(String... value) {
        addEquals(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection nameNot(String... value) {
        addNotEquals(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection nameLike(String... value) {
        addLike(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection nameContains(String... value) {
        addContains(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection nameStartsWith(String... value) {
        addStartsWith(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection nameEndsWith(String... value) {
        addEndsWith(IngredientColumns.NAME, value);
        return this;
    }

    public IngredientSelection orderByName(boolean desc) {
        orderBy(IngredientColumns.NAME, desc);
        return this;
    }

    public IngredientSelection orderByName() {
        orderBy(IngredientColumns.NAME, false);
        return this;
    }

    public IngredientSelection quantity(Integer... value) {
        addEquals(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection quantityNot(Integer... value) {
        addNotEquals(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection quantityGt(int value) {
        addGreaterThan(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection quantityGtEq(int value) {
        addGreaterThanOrEquals(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection quantityLt(int value) {
        addLessThan(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection quantityLtEq(int value) {
        addLessThanOrEquals(IngredientColumns.QUANTITY, value);
        return this;
    }

    public IngredientSelection orderByQuantity(boolean desc) {
        orderBy(IngredientColumns.QUANTITY, desc);
        return this;
    }

    public IngredientSelection orderByQuantity() {
        orderBy(IngredientColumns.QUANTITY, false);
        return this;
    }
}
