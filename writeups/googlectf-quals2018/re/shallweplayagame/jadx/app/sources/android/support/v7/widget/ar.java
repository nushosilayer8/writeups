package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.c.a;
import android.util.TypedValue;

class ar {
    static final int[] a = new int[]{-16842910};
    static final int[] b = new int[]{16842908};
    static final int[] c = new int[]{16843518};
    static final int[] d = new int[]{16842919};
    static final int[] e = new int[]{16842912};
    static final int[] f = new int[]{16842913};
    static final int[] g = new int[]{-16842919, -16842908};
    static final int[] h = new int[0];
    private static final ThreadLocal<TypedValue> i = new ThreadLocal();
    private static final int[] j = new int[1];

    public static int a(Context context, int i) {
        j[0] = i;
        aw a = aw.a(context, null, j);
        try {
            int b = a.b(0, 0);
            return b;
        } finally {
            a.a();
        }
    }

    static int a(Context context, int i, float f) {
        int a = a(context, i);
        return a.b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue a() {
        TypedValue typedValue = (TypedValue) i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList b(Context context, int i) {
        j[0] = i;
        aw a = aw.a(context, null, j);
        try {
            ColorStateList e = a.e(0);
            return e;
        } finally {
            a.a();
        }
    }

    public static int c(Context context, int i) {
        ColorStateList b = b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(a, b.getDefaultColor());
        }
        TypedValue a = a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return a(context, i, a.getFloat());
    }
}
