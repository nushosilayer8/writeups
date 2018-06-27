package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class e {
    private static final b a;

    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static class a extends b {
        a() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        a.a(edgeEffect, f, f2);
    }
}
