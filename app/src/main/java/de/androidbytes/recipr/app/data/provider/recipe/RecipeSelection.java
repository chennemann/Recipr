package de.androidbytes.recipr.app.data.provider.recipe;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import de.androidbytes.recipr.app.data.provider.base.AbstractSelection;
import de.androidbytes.recipr.app.data.provider.user.*;

/**
 * Selection for the {@code recipe} table.
 */
public class RecipeSelection extends AbstractSelection<RecipeSelection> {
    @Override
    protected Uri baseUri() {
        return RecipeColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RecipeCursor} object, which is positioned before the first entry, or null.
     */
    public RecipeCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RecipeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public RecipeCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RecipeCursor} object, which is positioned before the first entry, or null.
     */
    public RecipeCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RecipeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public RecipeCursor query(Context context) {
        return query(context, null);
    }


    public RecipeSelection id(long... value) {
        addEquals("recipe." + RecipeColumns._ID, toObjectArray(value));
        return this;
    }

    public RecipeSelection idNot(long... value) {
        addNotEquals("recipe." + RecipeColumns._ID, toObjectArray(value));
        return this;
    }

    public RecipeSelection orderById(boolean desc) {
        orderBy("recipe." + RecipeColumns._ID, desc);
        return this;
    }

    public RecipeSelection orderById() {
        return orderById(false);
    }

    public RecipeSelection userId(long... value) {
        addEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public RecipeSelection userIdNot(long... value) {
        addNotEquals(RecipeColumns.USER_ID, toObjectArray(value));
        return this;
    }

    public RecipeSelection userIdGt(long value) {
        addGreaterThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public RecipeSelection userIdGtEq(long value) {
        addGreaterThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public RecipeSelection userIdLt(long value) {
        addLessThan(RecipeColumns.USER_ID, value);
        return this;
    }

    public RecipeSelection userIdLtEq(long value) {
        addLessThanOrEquals(RecipeColumns.USER_ID, value);
        return this;
    }

    public RecipeSelection orderByUserId(boolean desc) {
        orderBy(RecipeColumns.USER_ID, desc);
        return this;
    }

    public RecipeSelection orderByUserId() {
        orderBy(RecipeColumns.USER_ID, false);
        return this;
    }

    public RecipeSelection userGoogleId(Integer... value) {
        addEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection userGoogleIdNot(Integer... value) {
        addNotEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection userGoogleIdGt(int value) {
        addGreaterThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection userGoogleIdGtEq(int value) {
        addGreaterThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection userGoogleIdLt(int value) {
        addLessThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection userGoogleIdLtEq(int value) {
        addLessThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public RecipeSelection orderByUserGoogleId(boolean desc) {
        orderBy(UserColumns.GOOGLE_ID, desc);
        return this;
    }

    public RecipeSelection orderByUserGoogleId() {
        orderBy(UserColumns.GOOGLE_ID, false);
        return this;
    }

    public RecipeSelection userFirstname(String... value) {
        addEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection userFirstnameNot(String... value) {
        addNotEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection userFirstnameLike(String... value) {
        addLike(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection userFirstnameContains(String... value) {
        addContains(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection userFirstnameStartsWith(String... value) {
        addStartsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection userFirstnameEndsWith(String... value) {
        addEndsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public RecipeSelection orderByUserFirstname(boolean desc) {
        orderBy(UserColumns.FIRSTNAME, desc);
        return this;
    }

    public RecipeSelection orderByUserFirstname() {
        orderBy(UserColumns.FIRSTNAME, false);
        return this;
    }

    public RecipeSelection userLastname(String... value) {
        addEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection userLastnameNot(String... value) {
        addNotEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection userLastnameLike(String... value) {
        addLike(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection userLastnameContains(String... value) {
        addContains(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection userLastnameStartsWith(String... value) {
        addStartsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection userLastnameEndsWith(String... value) {
        addEndsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public RecipeSelection orderByUserLastname(boolean desc) {
        orderBy(UserColumns.LASTNAME, desc);
        return this;
    }

    public RecipeSelection orderByUserLastname() {
        orderBy(UserColumns.LASTNAME, false);
        return this;
    }

    public RecipeSelection userImageUrl(String... value) {
        addEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection userImageUrlNot(String... value) {
        addNotEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection userImageUrlLike(String... value) {
        addLike(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection userImageUrlContains(String... value) {
        addContains(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection userImageUrlStartsWith(String... value) {
        addStartsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection userImageUrlEndsWith(String... value) {
        addEndsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection orderByUserImageUrl(boolean desc) {
        orderBy(UserColumns.IMAGE_URL, desc);
        return this;
    }

    public RecipeSelection orderByUserImageUrl() {
        orderBy(UserColumns.IMAGE_URL, false);
        return this;
    }

    public RecipeSelection name(String... value) {
        addEquals(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection nameNot(String... value) {
        addNotEquals(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection nameLike(String... value) {
        addLike(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection nameContains(String... value) {
        addContains(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection nameStartsWith(String... value) {
        addStartsWith(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection nameEndsWith(String... value) {
        addEndsWith(RecipeColumns.NAME, value);
        return this;
    }

    public RecipeSelection orderByName(boolean desc) {
        orderBy(RecipeColumns.NAME, desc);
        return this;
    }

    public RecipeSelection orderByName() {
        orderBy(RecipeColumns.NAME, false);
        return this;
    }

    public RecipeSelection rating(Integer... value) {
        addEquals(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection ratingNot(Integer... value) {
        addNotEquals(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection ratingGt(int value) {
        addGreaterThan(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection ratingGtEq(int value) {
        addGreaterThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection ratingLt(int value) {
        addLessThan(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection ratingLtEq(int value) {
        addLessThanOrEquals(RecipeColumns.RATING, value);
        return this;
    }

    public RecipeSelection orderByRating(boolean desc) {
        orderBy(RecipeColumns.RATING, desc);
        return this;
    }

    public RecipeSelection orderByRating() {
        orderBy(RecipeColumns.RATING, false);
        return this;
    }

    public RecipeSelection imageUrl(String... value) {
        addEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection imageUrlNot(String... value) {
        addNotEquals(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection imageUrlLike(String... value) {
        addLike(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection imageUrlContains(String... value) {
        addContains(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection imageUrlStartsWith(String... value) {
        addStartsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection imageUrlEndsWith(String... value) {
        addEndsWith(RecipeColumns.IMAGE_URL, value);
        return this;
    }

    public RecipeSelection orderByImageUrl(boolean desc) {
        orderBy(RecipeColumns.IMAGE_URL, desc);
        return this;
    }

    public RecipeSelection orderByImageUrl() {
        orderBy(RecipeColumns.IMAGE_URL, false);
        return this;
    }
}
