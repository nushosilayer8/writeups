package android.support.v4.h;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class e {
    static final b a;
    private static Field b;
    private static boolean c;

    static class b {
        b() {
        }

        public void a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                e.a(layoutInflater, (Factory2) factory);
            } else {
                e.a(layoutInflater, factory2);
            }
        }
    }

    static class a extends b {
        a() {
        }

        public void a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new a();
        } else {
            a = new b();
        }
    }

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!c) {
            try {
                b = LayoutInflater.class.getDeclaredField("mFactory2");
                b.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            c = true;
        }
        if (b != null) {
            try {
                b.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, Factory2 factory2) {
        a.a(layoutInflater, factory2);
    }
}
