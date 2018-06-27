package android.support.v4.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a.a;
import android.support.v4.c.c;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

public final class b {
    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, TextView textView) {
        return context.isRestricted() ? null : b(context, i, typedValue, i2, textView);
    }

    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i, int i2, TextView textView) {
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (!charSequence.startsWith("res/")) {
            return null;
        }
        Typeface a = c.a(resources, i, i2);
        if (a != null) {
            return a;
        }
        try {
            if (!charSequence.toLowerCase().endsWith(".xml")) {
                return c.a(context, resources, i, charSequence, i2);
            }
            a a2 = a.a(resources.getXml(i), resources);
            if (a2 != null) {
                return c.a(context, a2, resources, i, i2, textView);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            return null;
        } catch (Throwable e) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence, e);
            return null;
        } catch (Throwable e2) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence, e2);
            return null;
        }
    }

    public static Drawable a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    private static Typeface b(Context context, int i, TypedValue typedValue, int i2, TextView textView) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = a(context, resources, typedValue, i, i2, textView);
        if (a != null) {
            return a;
        }
        throw new NotFoundException("Font resource ID #0x" + Integer.toHexString(i));
    }
}
