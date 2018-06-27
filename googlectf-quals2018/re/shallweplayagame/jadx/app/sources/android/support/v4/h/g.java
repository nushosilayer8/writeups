package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;

public final class g {
    static final c a;

    interface c {
        void a(MenuItem menuItem, char c, int i);

        void a(MenuItem menuItem, ColorStateList colorStateList);

        void a(MenuItem menuItem, Mode mode);

        void a(MenuItem menuItem, CharSequence charSequence);

        void b(MenuItem menuItem, char c, int i);

        void b(MenuItem menuItem, CharSequence charSequence);
    }

    static class b implements c {
        b() {
        }

        public void a(MenuItem menuItem, char c, int i) {
        }

        public void a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        public void a(MenuItem menuItem, Mode mode) {
        }

        public void a(MenuItem menuItem, CharSequence charSequence) {
        }

        public void b(MenuItem menuItem, char c, int i) {
        }

        public void b(MenuItem menuItem, CharSequence charSequence) {
        }
    }

    static class a extends b {
        a() {
        }

        public void a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        public void a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        public void a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        public void a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        public void b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        public void b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static MenuItem a(MenuItem menuItem, c cVar) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            return ((android.support.v4.d.a.b) menuItem).a(cVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setNumericShortcut(c, i);
        } else {
            a.b(menuItem, c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setIconTintList(colorStateList);
        } else {
            a.a(menuItem, colorStateList);
        }
    }

    public static void a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setIconTintMode(mode);
        } else {
            a.a(menuItem, mode);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).a(charSequence);
        } else {
            a.a(menuItem, charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).setAlphabeticShortcut(c, i);
        } else {
            a.a(menuItem, c, i);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.d.a.b) {
            ((android.support.v4.d.a.b) menuItem).b(charSequence);
        } else {
            a.b(menuItem, charSequence);
        }
    }
}
