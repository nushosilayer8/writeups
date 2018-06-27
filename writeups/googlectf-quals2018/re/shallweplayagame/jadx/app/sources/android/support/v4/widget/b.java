package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class b {
    private static final c a;

    static class c {
        private static Field a;
        private static boolean b;

        c() {
        }

        public Drawable a(CompoundButton compoundButton) {
            if (!b) {
                try {
                    a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    return (Drawable) a.get(compoundButton);
                } catch (Throwable e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    a = null;
                }
            }
            return null;
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof k) {
                ((k) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof k) {
                ((k) compoundButton).setSupportButtonTintMode(mode);
            }
        }
    }

    static class a extends c {
        a() {
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b extends a {
        b() {
        }

        public Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new b();
        } else if (VERSION.SDK_INT >= 21) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        a.a(compoundButton, mode);
    }
}
