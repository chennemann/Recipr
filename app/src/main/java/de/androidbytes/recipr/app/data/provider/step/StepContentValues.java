package de.androidbytes.recipr.app.data.provider.step;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import de.androidbytes.recipr.app.data.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code step} table.
 */
public class StepContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return StepColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable StepSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context used to retrieve the content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable StepSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public StepContentValues putRecipeId(long value) {
        mContentValues.put(StepColumns.RECIPE_ID, value);
        return this;
    }


    /**
     * Title of the Step.
     */
    public StepContentValues putTitle(@Nullable String value) {
        mContentValues.put(StepColumns.TITLE, value);
        return this;
    }

    public StepContentValues putTitleNull() {
        mContentValues.putNull(StepColumns.TITLE);
        return this;
    }

    /**
     * Instruction of the preparation step.
     */
    public StepContentValues putInstruction(@Nullable String value) {
        mContentValues.put(StepColumns.INSTRUCTION, value);
        return this;
    }

    public StepContentValues putInstructionNull() {
        mContentValues.putNull(StepColumns.INSTRUCTION);
        return this;
    }
}
