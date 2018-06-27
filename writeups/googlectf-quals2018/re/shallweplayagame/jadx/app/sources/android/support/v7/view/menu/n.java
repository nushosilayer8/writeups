package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.support.v7.view.menu.o.a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class n {
    private final Context a;
    private final h b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private a i;
    private m j;
    private OnDismissListener k;
    private final OnDismissListener l;

    public n(Context context, h hVar, View view, boolean z, int i) {
        this(context, hVar, view, z, i, 0);
    }

    public n(Context context, h hVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new OnDismissListener(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.e();
            }
        };
        this.a = context;
        this.b = hVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        m b = b();
        b.c(z2);
        if (z) {
            if ((d.a(this.g, p.b(this.f)) & 7) == 5) {
                i += this.f.getWidth();
            }
            b.b(i);
            b.c(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.a();
    }

    private m g() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        m eVar = (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(android.support.v7.a.a.d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null ? new e(this.a, this.f, this.d, this.e, this.c) : new t(this.a, this.b, this.f, this.d, this.e, this.c);
        eVar.a(this.b);
        eVar.a(this.l);
        eVar.a(this.f);
        eVar.a(this.i);
        eVar.a(this.h);
        eVar.a(this.g);
        return eVar;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.i = aVar;
        if (this.j != null) {
            this.j.a(aVar);
        }
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.a(z);
        }
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    public m b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }
}
