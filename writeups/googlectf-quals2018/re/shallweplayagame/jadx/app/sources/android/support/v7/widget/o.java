package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.f;
import android.support.v7.a.a.j;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public class o {
    private final ImageView a;
    private au b;
    private au c;
    private au d;

    public o(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new au();
        }
        au auVar = this.d;
        auVar.a();
        ColorStateList a = f.a(this.a);
        if (a != null) {
            auVar.d = true;
            auVar.a = a;
        }
        Mode b = f.b(this.a);
        if (b != null) {
            auVar.c = true;
            auVar.b = b;
        }
        if (!auVar.d && !auVar.c) {
            return false;
        }
        l.a(drawable, auVar, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = b.b(this.a.getContext(), i);
            if (b != null) {
                ae.a(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    void a(Mode mode) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        aw a = aw.a(this.a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null) {
                int g = a.g(j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = b.b(this.a.getContext(), g);
                    if (drawable != null) {
                        this.a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                ae.a(drawable);
            }
            if (a.g(j.AppCompatImageView_tint)) {
                f.a(this.a, a.e(j.AppCompatImageView_tint));
            }
            if (a.g(j.AppCompatImageView_tintMode)) {
                f.a(this.a, ae.a(a.a(j.AppCompatImageView_tintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    boolean a() {
        return VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList b() {
        return this.c != null ? this.c.a : null;
    }

    Mode c() {
        return this.c != null ? this.c.b : null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            ae.a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            if (this.c != null) {
                l.a(drawable, this.c, this.a.getDrawableState());
            } else if (this.b != null) {
                l.a(drawable, this.b, this.a.getDrawableState());
            }
        }
    }
}
