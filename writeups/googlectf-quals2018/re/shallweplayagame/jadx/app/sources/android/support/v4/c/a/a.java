package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    static final e a;

    static class e {
        e() {
        }

        public int a(Drawable drawable) {
            return 0;
        }

        public void a(Drawable drawable, float f, float f2) {
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof f) {
                ((f) drawable).setTintList(colorStateList);
            }
        }

        public void a(Drawable drawable, Theme theme) {
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }

        public void a(Drawable drawable, Mode mode) {
            if (drawable instanceof f) {
                ((f) drawable).setTintMode(mode);
            }
        }

        public void a(Drawable drawable, boolean z) {
        }

        public boolean a(Drawable drawable, int i) {
            return false;
        }

        public void b(Drawable drawable, int i) {
            if (drawable instanceof f) {
                ((f) drawable).setTint(i);
            }
        }

        public boolean b(Drawable drawable) {
            return false;
        }

        public Drawable c(Drawable drawable) {
            return !(drawable instanceof f) ? new c(drawable) : drawable;
        }

        public int d(Drawable drawable) {
            return 0;
        }

        public boolean e(Drawable drawable) {
            return false;
        }

        public ColorFilter f(Drawable drawable) {
            return null;
        }

        public void g(Drawable drawable) {
            drawable.jumpToCurrentState();
        }
    }

    static class a extends e {
        private static Method a;
        private static boolean b;
        private static Method c;
        private static boolean d;

        a() {
        }

        public int a(Drawable drawable) {
            if (!d) {
                try {
                    c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    c.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve getLayoutDirection() method", e);
                }
                d = true;
            }
            if (c != null) {
                try {
                    return ((Integer) c.invoke(drawable, new Object[0])).intValue();
                } catch (Throwable e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke getLayoutDirection() via reflection", e2);
                    c = null;
                }
            }
            return 0;
        }

        public boolean a(Drawable drawable, int i) {
            if (!b) {
                try {
                    a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                    return true;
                } catch (Throwable e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    a = null;
                }
            }
            return false;
        }
    }

    static class b extends a {
        b() {
        }

        public void a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public boolean b(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public Drawable c(Drawable drawable) {
            return !(drawable instanceof f) ? new d(drawable) : drawable;
        }

        public int d(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    static class c extends b {
        c() {
        }

        public void a(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public void a(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public void a(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        public void b(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public Drawable c(Drawable drawable) {
            return !(drawable instanceof f) ? new e(drawable) : drawable;
        }

        public boolean e(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public ColorFilter f(Drawable drawable) {
            return drawable.getColorFilter();
        }
    }

    static class d extends c {
        d() {
        }

        public int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public boolean a(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        public Drawable c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new d();
        } else if (VERSION.SDK_INT >= 21) {
            a = new c();
        } else if (VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (VERSION.SDK_INT >= 17) {
            a = new a();
        } else {
            a = new e();
        }
    }

    public static void a(Drawable drawable) {
        a.g(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        a.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i) {
        a.b(drawable, i);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Theme theme) {
        a.a(drawable, theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, Mode mode) {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean z) {
        a.a(drawable, z);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static boolean b(Drawable drawable, int i) {
        return a.a(drawable, i);
    }

    public static int c(Drawable drawable) {
        return a.d(drawable);
    }

    public static boolean d(Drawable drawable) {
        return a.e(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.f(drawable);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static int g(Drawable drawable) {
        return a.a(drawable);
    }
}
