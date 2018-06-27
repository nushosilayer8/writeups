package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class t extends m implements o, OnKeyListener, OnItemClickListener, OnDismissListener {
    final am a;
    View b;
    private final Context c;
    private final h d;
    private final g e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private final OnGlobalLayoutListener j = new OnGlobalLayoutListener(this) {
        final /* synthetic */ t a;

        {
            this.a = r1;
        }

        public void onGlobalLayout() {
            if (this.a.d() && !this.a.a.g()) {
                View view = this.a.b;
                if (view == null || !view.isShown()) {
                    this.a.c();
                } else {
                    this.a.a.a();
                }
            }
        }
    };
    private final OnAttachStateChangeListener k = new OnAttachStateChangeListener(this) {
        final /* synthetic */ t a;

        {
            this.a = r1;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.a.o != null) {
                if (!this.a.o.isAlive()) {
                    this.a.o = view.getViewTreeObserver();
                }
                this.a.o.removeGlobalOnLayoutListener(this.a.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private OnDismissListener l;
    private View m;
    private a n;
    private ViewTreeObserver o;
    private boolean p;
    private boolean q;
    private int r;
    private int s = 0;
    private boolean t;

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = hVar;
        this.f = z;
        this.e = new g(hVar, LayoutInflater.from(context), this.f);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.m = view;
        this.a = new am(this.c, null, this.h, this.i);
        hVar.a((o) this, context);
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.p || this.m == null) {
            return false;
        }
        this.b = this.m;
        this.a.a((OnDismissListener) this);
        this.a.a((OnItemClickListener) this);
        this.a.a(true);
        View view = this.b;
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this.j);
        }
        view.addOnAttachStateChangeListener(this.k);
        this.a.b(view);
        this.a.e(this.s);
        if (!this.q) {
            this.r = m.a(this.e, null, this.c, this.g);
            this.q = true;
        }
        this.a.g(this.r);
        this.a.h(2);
        this.a.a(g());
        this.a.a();
        ViewGroup e = this.a.e();
        e.setOnKeyListener(this);
        if (this.t && this.d.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.a.a(this.e);
        this.a.a();
        return true;
    }

    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void a(int i) {
        this.s = i;
    }

    public void a(h hVar) {
    }

    public void a(h hVar, boolean z) {
        if (hVar == this.d) {
            c();
            if (this.n != null) {
                this.n.a(hVar, z);
            }
        }
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void a(View view) {
        this.m = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.c, uVar, this.b, this.f, this.h, this.i);
            nVar.a(this.n);
            nVar.a(m.b((h) uVar));
            nVar.a(this.s);
            nVar.a(this.l);
            this.l = null;
            this.d.a(false);
            if (nVar.a(this.a.j(), this.a.k())) {
                if (this.n != null) {
                    this.n.a(uVar);
                }
                return true;
            }
        }
        return false;
    }

    public void b(int i) {
        this.a.c(i);
    }

    public void b(boolean z) {
        this.q = false;
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        if (d()) {
            this.a.c();
        }
    }

    public void c(int i) {
        this.a.d(i);
    }

    public void c(boolean z) {
        this.t = z;
    }

    public boolean d() {
        return !this.p && this.a.d();
    }

    public ListView e() {
        return this.a.e();
    }

    public void onDismiss() {
        this.p = true;
        this.d.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.j);
            this.o = null;
        }
        this.b.removeOnAttachStateChangeListener(this.k);
        if (this.l != null) {
            this.l.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }
}
