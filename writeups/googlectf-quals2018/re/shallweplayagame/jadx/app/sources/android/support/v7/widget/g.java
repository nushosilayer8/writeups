package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.p;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;

class g {
    private final View a;
    private final l b;
    private int c = -1;
    private au d;
    private au e;
    private au f;

    g(View view) {
        this.a = view;
        this.b = l.a();
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new au();
        }
        au auVar = this.f;
        auVar.a();
        ColorStateList i = p.i(this.a);
        if (i != null) {
            auVar.d = true;
            auVar.a = i;
        }
        Mode j = p.j(this.a);
        if (j != null) {
            auVar.c = true;
            auVar.b = j;
        }
        if (!auVar.d && !auVar.c) {
            return false;
        }
        l.a(drawable, auVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    ColorStateList a() {
        return this.e != null ? this.e.a : null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new au();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    void a(Mode mode) {
        if (this.e == null) {
            this.e = new au();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b(null);
        c();
    }

    void a(AttributeSet attributeSet, int i) {
        aw a = aw.a(this.a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a.g(j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTint)) {
                p.a(this.a, a.e(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                p.a(this.a, ae.a(a.a(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    Mode b() {
        return this.e != null ? this.e.b : null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new au();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            if (this.e != null) {
                l.a(background, this.e, this.a.getDrawableState());
            } else if (this.d != null) {
                l.a(background, this.d, this.a.getDrawableState());
            }
        }
    }
}
