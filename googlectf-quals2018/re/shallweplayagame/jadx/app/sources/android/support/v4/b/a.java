package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;

public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    public static final Drawable a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        int i2;
        synchronized (a) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(i, b, true);
            i2 = b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static final ColorStateList b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }
}
