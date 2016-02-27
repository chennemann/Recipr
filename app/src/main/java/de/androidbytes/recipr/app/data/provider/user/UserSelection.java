package de.androidbytes.recipr.app.data.provider.user;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import de.androidbytes.recipr.app.data.provider.base.AbstractSelection;

/**
 * Selection for the {@code user} table.
 */
public class UserSelection extends AbstractSelection<UserSelection> {
    @Override
    protected Uri baseUri() {
        return UserColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code UserCursor} object, which is positioned before the first entry, or null.
     */
    public UserCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new UserCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public UserCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code UserCursor} object, which is positioned before the first entry, or null.
     */
    public UserCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new UserCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public UserCursor query(Context context) {
        return query(context, null);
    }


    public UserSelection id(long... value) {
        addEquals("user." + UserColumns._ID, toObjectArray(value));
        return this;
    }

    public UserSelection idNot(long... value) {
        addNotEquals("user." + UserColumns._ID, toObjectArray(value));
        return this;
    }

    public UserSelection orderById(boolean desc) {
        orderBy("user." + UserColumns._ID, desc);
        return this;
    }

    public UserSelection orderById() {
        return orderById(false);
    }

    public UserSelection googleId(Integer... value) {
        addEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection googleIdNot(Integer... value) {
        addNotEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection googleIdGt(int value) {
        addGreaterThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection googleIdGtEq(int value) {
        addGreaterThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection googleIdLt(int value) {
        addLessThan(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection googleIdLtEq(int value) {
        addLessThanOrEquals(UserColumns.GOOGLE_ID, value);
        return this;
    }

    public UserSelection orderByGoogleId(boolean desc) {
        orderBy(UserColumns.GOOGLE_ID, desc);
        return this;
    }

    public UserSelection orderByGoogleId() {
        orderBy(UserColumns.GOOGLE_ID, false);
        return this;
    }

    public UserSelection firstname(String... value) {
        addEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection firstnameNot(String... value) {
        addNotEquals(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection firstnameLike(String... value) {
        addLike(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection firstnameContains(String... value) {
        addContains(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection firstnameStartsWith(String... value) {
        addStartsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection firstnameEndsWith(String... value) {
        addEndsWith(UserColumns.FIRSTNAME, value);
        return this;
    }

    public UserSelection orderByFirstname(boolean desc) {
        orderBy(UserColumns.FIRSTNAME, desc);
        return this;
    }

    public UserSelection orderByFirstname() {
        orderBy(UserColumns.FIRSTNAME, false);
        return this;
    }

    public UserSelection lastname(String... value) {
        addEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection lastnameNot(String... value) {
        addNotEquals(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection lastnameLike(String... value) {
        addLike(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection lastnameContains(String... value) {
        addContains(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection lastnameStartsWith(String... value) {
        addStartsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection lastnameEndsWith(String... value) {
        addEndsWith(UserColumns.LASTNAME, value);
        return this;
    }

    public UserSelection orderByLastname(boolean desc) {
        orderBy(UserColumns.LASTNAME, desc);
        return this;
    }

    public UserSelection orderByLastname() {
        orderBy(UserColumns.LASTNAME, false);
        return this;
    }

    public UserSelection imageUrl(String... value) {
        addEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection imageUrlNot(String... value) {
        addNotEquals(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection imageUrlLike(String... value) {
        addLike(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection imageUrlContains(String... value) {
        addContains(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection imageUrlStartsWith(String... value) {
        addStartsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection imageUrlEndsWith(String... value) {
        addEndsWith(UserColumns.IMAGE_URL, value);
        return this;
    }

    public UserSelection orderByImageUrl(boolean desc) {
        orderBy(UserColumns.IMAGE_URL, desc);
        return this;
    }

    public UserSelection orderByImageUrl() {
        orderBy(UserColumns.IMAGE_URL, false);
        return this;
    }
}
