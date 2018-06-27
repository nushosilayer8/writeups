package android.support.v4.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.b.a.a.d;
import android.support.v4.f.b.b;
import android.support.v4.g.g;
import android.widget.TextView;

public class c {
    private static final a a;
    private static final g<String, Typeface> b = new g(16);

    interface a {
        Typeface a(Context context, Resources resources, int i, String str, int i2);

        Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i);

        Typeface a(Context context, android.support.v4.b.a.a.b bVar, Resources resources, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new f();
        } else if (VERSION.SDK_INT >= 24 && e.a()) {
            a = new e();
        } else if (VERSION.SDK_INT >= 21) {
            a = new d();
        } else {
            a = new g();
        }
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = a.a(context, resources, i, str, i2);
        if (a != null) {
            b.a(b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i) {
        return a.a(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface a(Context context, android.support.v4.b.a.a.a aVar, Resources resources, int i, int i2, TextView textView) {
        Typeface a;
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            a = android.support.v4.f.b.a(context, dVar.a(), textView, dVar.b(), dVar.c(), i2);
        } else {
            a = a.a(context, (android.support.v4.b.a.a.b) aVar, resources, i2);
        }
        if (a != null) {
            b.a(b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return (Typeface) b.a(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
