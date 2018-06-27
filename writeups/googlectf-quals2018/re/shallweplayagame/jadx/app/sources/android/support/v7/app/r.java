package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.h.p;
import android.support.v4.h.s;
import android.support.v4.h.t;
import android.support.v4.h.u;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.support.v7.app.a.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ad;
import android.support.v7.widget.ap;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class r extends a implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = (!r.class.desiredAssertionStatus());
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<b> C = new ArrayList();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ad d;
    ActionBarContextView e;
    View f;
    ap g;
    a h;
    android.support.v7.view.b i;
    android.support.v7.view.b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final s p = new t(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void b(View view) {
            if (this.a.k && this.a.f != null) {
                this.a.f.setTranslationY(0.0f);
                this.a.c.setTranslationY(0.0f);
            }
            this.a.c.setVisibility(8);
            this.a.c.setTransitioning(false);
            this.a.n = null;
            this.a.h();
            if (this.a.b != null) {
                p.g(this.a.b);
            }
        }
    };
    final s q = new t(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void b(View view) {
            this.a.n = null;
            this.a.c.requestLayout();
        }
    };
    final u r = new u(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(View view) {
            ((View) this.a.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList();
    private int z = -1;

    public class a extends android.support.v7.view.b implements android.support.v7.view.menu.h.a {
        final /* synthetic */ r a;
        private final Context b;
        private final android.support.v7.view.menu.h c;
        private android.support.v7.view.b.a d;
        private WeakReference<View> e;

        public a(r rVar, Context context, android.support.v7.view.b.a aVar) {
            this.a = rVar;
            this.b = context;
            this.d = aVar;
            this.c = new android.support.v7.view.menu.h(context).a(1);
            this.c.a((android.support.v7.view.menu.h.a) this);
        }

        public MenuInflater a() {
            return new g(this.b);
        }

        public void a(int i) {
            b(this.a.a.getResources().getString(i));
        }

        public void a(android.support.v7.view.menu.h hVar) {
            if (this.d != null) {
                d();
                this.a.e.a();
            }
        }

        public void a(View view) {
            this.a.e.setCustomView(view);
            this.e = new WeakReference(view);
        }

        public void a(CharSequence charSequence) {
            this.a.e.setSubtitle(charSequence);
        }

        public void a(boolean z) {
            super.a(z);
            this.a.e.setTitleOptional(z);
        }

        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            return this.d != null ? this.d.a((android.support.v7.view.b) this, menuItem) : false;
        }

        public Menu b() {
            return this.c;
        }

        public void b(int i) {
            a(this.a.a.getResources().getString(i));
        }

        public void b(CharSequence charSequence) {
            this.a.e.setTitle(charSequence);
        }

        public void c() {
            if (this.a.h == this) {
                if (r.a(this.a.l, this.a.m, false)) {
                    this.d.a(this);
                } else {
                    this.a.i = this;
                    this.a.j = this.d;
                }
                this.d = null;
                this.a.j(false);
                this.a.e.b();
                this.a.d.a().sendAccessibilityEvent(32);
                this.a.b.setHideOnContentScrollEnabled(this.a.o);
                this.a.h = null;
            }
        }

        public void d() {
            if (this.a.h == this) {
                this.c.g();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.h();
                }
            }
        }

        public boolean e() {
            this.c.g();
            try {
                boolean a = this.d.a((android.support.v7.view.b) this, this.c);
                return a;
            } finally {
                this.c.h();
            }
        }

        public CharSequence f() {
            return this.a.e.getTitle();
        }

        public CharSequence g() {
            return this.a.e.getSubtitle();
        }

        public boolean h() {
            return this.a.e.d();
        }

        public View i() {
            return this.e != null ? (View) this.e.get() : null;
        }
    }

    public r(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.f = decorView.findViewById(16908290);
        }
    }

    public r(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.a = this.d.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.A = true;
        }
        android.support.v7.view.a a = android.support.v7.view.a.a(this.a);
        z = a.f() || z;
        a(z);
        k(a.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private ad b(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void k(boolean z) {
        boolean z2 = true;
        this.D = z;
        if (this.D) {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        } else {
            this.d.a(null);
            this.c.setTabContainer(this.g);
        }
        boolean z3 = i() == 2;
        if (this.g != null) {
            if (z3) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    p.g(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        ad adVar = this.d;
        boolean z4 = !this.D && z3;
        adVar.a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        if (this.D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z);
            }
        } else if (this.G) {
            this.G = false;
            i(z);
        }
    }

    private void n() {
        if (!this.F) {
            this.F = true;
            if (this.b != null) {
                this.b.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean p() {
        return p.l(this.c);
    }

    public int a() {
        return this.d.o();
    }

    public android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        android.support.v7.view.b aVar2 = new a(this, this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        j(true);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    public void a(float f) {
        p.a(this.c, f);
    }

    public void a(int i) {
        this.E = i;
    }

    public void a(int i, int i2) {
        int o = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.c((o & (i2 ^ -1)) | (i & i2));
    }

    public void a(Configuration configuration) {
        k(android.support.v7.view.a.a(this.a).d());
    }

    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(boolean z) {
        this.d.b(z);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h == null) {
            return false;
        }
        Menu b = this.h.b();
        if (b == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }

    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.a, i);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    public void b(boolean z) {
        if (!z || this.b.a()) {
            this.o = z;
            this.b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void c(boolean z) {
        if (!this.A) {
            f(z);
        }
    }

    public void d(boolean z) {
        this.H = z;
        if (!z && this.n != null) {
            this.n.c();
        }
    }

    public void e(boolean z) {
        if (z != this.B) {
            this.B = z;
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                ((b) this.C.get(i)).a(z);
            }
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    public void g(boolean z) {
        this.k = z;
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void h(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.c.setTranslationY(f);
            h hVar = new h();
            android.support.v4.h.r b = p.d(this.c).b(0.0f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hVar.a(p.d(this.f).b(0.0f));
            }
            hVar.a(u);
            hVar.a(250);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            p.g(this.b);
        }
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            h hVar = new h();
            float f = (float) (-this.c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            android.support.v4.h.r b = p.d(this.c).b(f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                hVar.a(p.d(this.f).b(f));
            }
            hVar.a(t);
            hVar.a(250);
            hVar.a(this.p);
            this.n = hVar;
            hVar.a();
            return;
        }
        this.p.b(null);
    }

    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    public void j(boolean z) {
        if (z) {
            n();
        } else {
            o();
        }
        if (p()) {
            android.support.v4.h.r a;
            android.support.v4.h.r a2;
            if (z) {
                a = this.d.a(4, 100);
                a2 = this.e.a(0, 200);
            } else {
                a2 = this.d.a(0, 200);
                a = this.e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(a, a2);
            hVar.a();
        } else if (z) {
            this.d.d(4);
            this.e.setVisibility(0);
        } else {
            this.d.d(0);
            this.e.setVisibility(8);
        }
    }

    public void k() {
        if (!this.m) {
            this.m = true;
            l(true);
        }
    }

    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    public void m() {
    }
}
