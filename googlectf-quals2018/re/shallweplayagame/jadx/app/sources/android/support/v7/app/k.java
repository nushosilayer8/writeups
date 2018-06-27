package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.a.w;
import android.support.v4.h.n;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.t;
import android.support.v4.h.v;
import android.support.v7.a.a.g;
import android.support.v7.a.a.i;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ac;
import android.support.v7.widget.ag;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.support.v7.widget.l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

class k extends f implements android.support.v7.view.menu.h.a, Factory2 {
    private static final boolean t = (VERSION.SDK_INT < 21);
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d[] E;
    private d F;
    private boolean G;
    private final Runnable H = new Runnable(this) {
        final /* synthetic */ k a;

        {
            this.a = r1;
        }

        public void run() {
            if ((this.a.s & 1) != 0) {
                this.a.f(0);
            }
            if ((this.a.s & 4096) != 0) {
                this.a.f(j.AppCompatTheme_tooltipFrameBackground);
            }
            this.a.r = false;
            this.a.s = 0;
        }
    };
    private boolean I;
    private Rect J;
    private Rect K;
    private m L;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    r q = null;
    boolean r;
    int s;
    private ac u;
    private a v;
    private e w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    private final class a implements android.support.v7.view.menu.o.a {
        final /* synthetic */ k a;

        a(k kVar) {
            this.a = kVar;
        }

        public void a(h hVar, boolean z) {
            this.a.b(hVar);
        }

        public boolean a(h hVar) {
            Callback q = this.a.q();
            if (q != null) {
                q.onMenuOpened(j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
            return true;
        }
    }

    class b implements android.support.v7.view.b.a {
        final /* synthetic */ k a;
        private android.support.v7.view.b.a b;

        public b(k kVar, android.support.v7.view.b.a aVar) {
            this.a = kVar;
            this.b = aVar;
        }

        public void a(android.support.v7.view.b bVar) {
            this.b.a(bVar);
            if (this.a.o != null) {
                this.a.b.getDecorView().removeCallbacks(this.a.p);
            }
            if (this.a.n != null) {
                this.a.t();
                this.a.q = p.d(this.a.n).a(0.0f);
                this.a.q.a(new t(this) {
                    final /* synthetic */ b a;

                    {
                        this.a = r1;
                    }

                    public void b(View view) {
                        this.a.a.n.setVisibility(8);
                        if (this.a.a.o != null) {
                            this.a.a.o.dismiss();
                        } else if (this.a.a.n.getParent() instanceof View) {
                            p.g((View) this.a.a.n.getParent());
                        }
                        this.a.a.n.removeAllViews();
                        this.a.a.q.a(null);
                        this.a.a.q = null;
                    }
                });
            }
            if (this.a.e != null) {
                this.a.e.b(this.a.m);
            }
            this.a.m = null;
        }

        public boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        public boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        public boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.b.b(bVar, menu);
        }
    }

    private class c extends ContentFrameLayout {
        final /* synthetic */ k a;

        public c(k kVar, Context context) {
            this.a = kVar;
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.a.e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.b.a.b.b(getContext(), i));
        }
    }

    protected static final class d {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        h j;
        f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        d(int i) {
            this.a = i;
        }

        android.support.v7.view.menu.p a(android.support.v7.view.menu.o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new f(this.l, g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(i.Theme_AppCompat_CompactMenu, true);
            }
            Context dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(h hVar) {
            if (hVar != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = hVar;
                if (hVar != null && this.k != null) {
                    hVar.a(this.k);
                }
            }
        }

        public boolean a() {
            return this.h == null ? false : this.i != null || this.k.a().getCount() > 0;
        }
    }

    private final class e implements android.support.v7.view.menu.o.a {
        final /* synthetic */ k a;

        e(k kVar) {
            this.a = kVar;
        }

        public void a(h hVar, boolean z) {
            Menu hVar2;
            Menu p = hVar2.p();
            boolean z2 = p != hVar2;
            k kVar = this.a;
            if (z2) {
                hVar2 = p;
            }
            d a = kVar.a(hVar2);
            if (a == null) {
                return;
            }
            if (z2) {
                this.a.a(a.a, a, p);
                this.a.a(a, true);
                return;
            }
            this.a.a(a, z);
        }

        public boolean a(h hVar) {
            if (hVar == null && this.a.h) {
                Callback q = this.a.q();
                if (!(q == null || this.a.p())) {
                    q.onMenuOpened(j.AppCompatTheme_tooltipFrameBackground, hVar);
                }
            }
            return true;
        }
    }

    k(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.k.d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.p();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.q();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.a;
        r5 = r11.j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.b;
        r4 = r11.g;
        r4.setBackgroundResource(r0);
        r0 = r11.h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.g;
        r4 = r11.h;
        r0.addView(r4, r1);
        r0 = r11.h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.d;
        r4 = r11.e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.c;
        r0.gravity = r1;
        r1 = r11.f;
        r0.windowAnimations = r1;
        r1 = r11.g;
        r8.addView(r1, r0);
        r11.o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.k.a(android.support.v7.app.k$d, android.view.KeyEvent):void");
    }

    private void a(h hVar, boolean z) {
        if (this.u == null || !this.u.e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.u.g())) {
            d a = a(0, true);
            a.q = true;
            a(a, false);
            a(a, null);
            return;
        }
        Callback q = q();
        if (this.u.f() && z) {
            this.u.i();
            if (!p()) {
                q.onPanelClosed(j.AppCompatTheme_tooltipFrameBackground, a(0, true).j);
            }
        } else if (q != null && !p()) {
            if (this.r && (this.s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.H);
                this.H.run();
            }
            d a2 = a(0, true);
            if (a2.j != null && !a2.r && q.onPreparePanel(0, a2.i, a2.j)) {
                q.onMenuOpened(j.AppCompatTheme_tooltipFrameBackground, a2.j);
                this.u.h();
            }
        }
    }

    private boolean a(d dVar) {
        dVar.a(n());
        dVar.g = new c(this, dVar.l);
        dVar.c = 81;
        return true;
    }

    private boolean a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((dVar.m || b(dVar, keyEvent)) && dVar.j != null) {
                z = dVar.j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.u == null) {
                a(dVar, true);
            }
        }
        return z;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || p.m((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private boolean b(d dVar) {
        Context dVar2;
        h hVar;
        Context context = this.a;
        if ((dVar.a == 0 || dVar.a == j.AppCompatTheme_tooltipFrameBackground) && this.u != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                dVar2 = new android.support.v7.view.d(context, 0);
                dVar2.getTheme().setTo(theme3);
                hVar = new h(dVar2);
                hVar.a((android.support.v7.view.menu.h.a) this);
                dVar.a(hVar);
                return true;
            }
        }
        dVar2 = context;
        hVar = new h(dVar2);
        hVar.a((android.support.v7.view.menu.h.a) this);
        dVar.a(hVar);
        return true;
    }

    private boolean b(d dVar, KeyEvent keyEvent) {
        if (p()) {
            return false;
        }
        if (dVar.m) {
            return true;
        }
        if (!(this.F == null || this.F == dVar)) {
            a(this.F, false);
        }
        Callback q = q();
        if (q != null) {
            dVar.i = q.onCreatePanelView(dVar.a);
        }
        boolean z = dVar.a == 0 || dVar.a == j.AppCompatTheme_tooltipFrameBackground;
        if (z && this.u != null) {
            this.u.j();
        }
        if (dVar.i == null && !(z && (m() instanceof o))) {
            if (dVar.j == null || dVar.r) {
                if (dVar.j == null && (!b(dVar) || dVar.j == null)) {
                    return false;
                }
                if (z && this.u != null) {
                    if (this.v == null) {
                        this.v = new a(this);
                    }
                    this.u.a(dVar.j, this.v);
                }
                dVar.j.g();
                if (q.onCreatePanelMenu(dVar.a, dVar.j)) {
                    dVar.r = false;
                } else {
                    dVar.a(null);
                    if (!z || this.u == null) {
                        return false;
                    }
                    this.u.a(null, this.v);
                    return false;
                }
            }
            dVar.j.g();
            if (dVar.s != null) {
                dVar.j.b(dVar.s);
                dVar.s = null;
            }
            if (q.onPreparePanel(0, dVar.i, dVar.j)) {
                dVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                dVar.j.setQwertyMode(dVar.p);
                dVar.j.h();
            } else {
                if (z && this.u != null) {
                    this.u.a(null, this.v);
                }
                dVar.j.h();
                return false;
            }
        }
        dVar.m = true;
        dVar.n = false;
        this.F = dVar;
        return true;
    }

    private boolean c(d dVar) {
        if (dVar.i != null) {
            dVar.h = dVar.i;
            return true;
        } else if (dVar.j == null) {
            return false;
        } else {
            if (this.w == null) {
                this.w = new e(this);
            }
            dVar.h = (View) dVar.a(this.w);
            return dVar.h != null;
        }
    }

    private void d(int i) {
        this.s |= 1 << i;
        if (!this.r) {
            p.a(this.b.getDecorView(), this.H);
            this.r = true;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            d a = a(i, true);
            if (!a.o) {
                return b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.m != null) {
            return false;
        }
        d a = a(i, true);
        if (i != 0 || this.u == null || !this.u.e() || ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
            boolean z2;
            if (a.o || a.n) {
                z2 = a.o;
                a(a, true);
                z = z2;
            } else {
                if (a.m) {
                    if (a.r) {
                        a.m = false;
                        z2 = b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.u.f()) {
            z = this.u.i();
        } else {
            if (!p() && b(a, keyEvent)) {
                z = this.u.h();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return j.AppCompatTheme_tooltipFrameBackground;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return j.AppCompatTheme_windowActionBar;
        }
    }

    private void w() {
        if (!this.x) {
            this.y = x();
            CharSequence r = r();
            if (!TextUtils.isEmpty(r)) {
                b(r);
            }
            y();
            a(this.y);
            this.x = true;
            d a = a(0, false);
            if (!p()) {
                if (a == null || a.j == null) {
                    d(j.AppCompatTheme_tooltipFrameBackground);
                }
            }
        }
    }

    private ViewGroup x() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowNoTitle, false)) {
                c(1);
            } else if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBar, false)) {
                c((int) j.AppCompatTheme_tooltipFrameBackground);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBarOverlay, false)) {
                c((int) j.AppCompatTheme_windowActionBar);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionModeOverlay, false)) {
                c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            View view2;
            if (this.l) {
                View view3 = this.j ? (ViewGroup) from.inflate(g.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(g.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    p.a(view3, new n(this) {
                        final /* synthetic */ k a;

                        {
                            this.a = r1;
                        }

                        public v a(View view, v vVar) {
                            int b = vVar.b();
                            int g = this.a.g(b);
                            if (b != g) {
                                vVar = vVar.a(vVar.a(), g, vVar.c(), vVar.d());
                            }
                            return p.a(view, vVar);
                        }
                    });
                    view = view3;
                } else {
                    ((ag) view3).setOnFitSystemWindowsListener(new android.support.v7.widget.ag.a(this) {
                        final /* synthetic */ k a;

                        {
                            this.a = r1;
                        }

                        public void a(Rect rect) {
                            rect.top = this.a.g(rect.top);
                        }
                    });
                    view = view3;
                }
            } else if (this.k) {
                view2 = (ViewGroup) from.inflate(g.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = view2;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                view2 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.a, typedValue.resourceId) : this.a).inflate(g.abc_screen_toolbar, null);
                this.u = (ac) view2.findViewById(android.support.v7.a.a.f.decor_content_parent);
                this.u.setWindowCallback(q());
                if (this.i) {
                    this.u.a(j.AppCompatTheme_windowActionBar);
                }
                if (this.B) {
                    this.u.a(2);
                }
                if (this.C) {
                    this.u.a(5);
                }
                view = view2;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.u == null) {
                this.z = (TextView) view.findViewById(android.support.v7.a.a.f.title);
            }
            bc.b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(android.support.v7.a.a.f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new android.support.v7.widget.ContentFrameLayout.a(this) {
                final /* synthetic */ k a;

                {
                    this.a = r1;
                }

                public void a() {
                }

                public void b() {
                    this.a.v();
                }
            });
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(j.AppCompatTheme);
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void z() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    protected d a(int i, boolean z) {
        Object obj = this.E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.E = obj2;
            obj = obj2;
        }
        d dVar = obj[i];
        if (dVar != null) {
            return dVar;
        }
        dVar = new d(i);
        obj[i] = dVar;
        return dVar;
    }

    d a(Menu menu) {
        d[] dVarArr = this.E;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.j == menu) {
                return dVar;
            }
        }
        return null;
    }

    android.support.v7.view.b a(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b bVar;
        t();
        if (this.m != null) {
            this.m.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(this, aVar);
        }
        if (this.e == null || p()) {
            bVar = null;
        } else {
            try {
                bVar = this.e.a(aVar);
            } catch (AbstractMethodError e) {
                bVar = null;
            }
        }
        if (bVar != null) {
            this.m = bVar;
        } else {
            if (this.n == null) {
                if (this.k) {
                    Context dVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new android.support.v7.view.d(this.a, 0);
                        dVar.getTheme().setTo(newTheme);
                    } else {
                        dVar = this.a;
                    }
                    this.n = new ActionBarContextView(dVar);
                    this.o = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                    android.support.v4.widget.i.a(this.o, 2);
                    this.o.setContentView(this.n);
                    this.o.setWidth(-1);
                    dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                    this.n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.o.setHeight(-2);
                    this.p = new Runnable(this) {
                        final /* synthetic */ k a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.o.showAtLocation(this.a.n, 55, 0, 0);
                            this.a.t();
                            if (this.a.s()) {
                                this.a.n.setAlpha(0.0f);
                                this.a.q = p.d(this.a.n).a(1.0f);
                                this.a.q.a(new t(this) {
                                    final /* synthetic */ AnonymousClass5 a;

                                    {
                                        this.a = r1;
                                    }

                                    public void a(View view) {
                                        this.a.a.n.setVisibility(0);
                                    }

                                    public void b(View view) {
                                        this.a.a.n.setAlpha(1.0f);
                                        this.a.a.q.a(null);
                                        this.a.a.q = null;
                                    }
                                });
                                return;
                            }
                            this.a.n.setAlpha(1.0f);
                            this.a.n.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.y.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n()));
                        this.n = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.n != null) {
                t();
                this.n.c();
                android.support.v7.view.b eVar = new android.support.v7.view.e(this.n.getContext(), this.n, aVar, this.o == null);
                if (aVar.a(eVar, eVar.b())) {
                    eVar.d();
                    this.n.a(eVar);
                    this.m = eVar;
                    if (s()) {
                        this.n.setAlpha(0.0f);
                        this.q = p.d(this.n).a(1.0f);
                        this.q.a(new t(this) {
                            final /* synthetic */ k a;

                            {
                                this.a = r1;
                            }

                            public void a(View view) {
                                this.a.n.setVisibility(0);
                                this.a.n.sendAccessibilityEvent(32);
                                if (this.a.n.getParent() instanceof View) {
                                    p.g((View) this.a.n.getParent());
                                }
                            }

                            public void b(View view) {
                                this.a.n.setAlpha(1.0f);
                                this.a.q.a(null);
                                this.a.q = null;
                            }
                        });
                    } else {
                        this.n.setAlpha(1.0f);
                        this.n.setVisibility(0);
                        this.n.sendAccessibilityEvent(32);
                        if (this.n.getParent() instanceof View) {
                            p.g((View) this.n.getParent());
                        }
                    }
                    if (this.o != null) {
                        this.b.getDecorView().post(this.p);
                    }
                } else {
                    this.m = null;
                }
            }
        }
        if (!(this.m == null || this.e == null)) {
            this.e.a(this.m);
        }
        return this.m;
    }

    public <T extends View> T a(int i) {
        w();
        return this.b.findViewById(i);
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    void a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.E.length) {
                dVar = this.E[i];
            }
            if (dVar != null) {
                menu = dVar.j;
            }
        }
        if ((dVar == null || dVar.o) && !p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    void a(int i, Menu menu) {
        if (i == j.AppCompatTheme_tooltipFrameBackground) {
            a a = a();
            if (a != null) {
                a.e(false);
            }
        } else if (i == 0) {
            d a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    public void a(Configuration configuration) {
        if (this.h && this.x) {
            a a = a();
            if (a != null) {
                a.a(configuration);
            }
        }
        l.a().a(this.a);
        i();
    }

    public void a(Bundle bundle) {
        if ((this.c instanceof Activity) && w.b((Activity) this.c) != null) {
            a m = m();
            if (m == null) {
                this.I = true;
            } else {
                m.c(true);
            }
        }
    }

    void a(d dVar, boolean z) {
        if (z && dVar.a == 0 && this.u != null && this.u.f()) {
            b(dVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !dVar.o || dVar.g == null)) {
            windowManager.removeView(dVar.g);
            if (z) {
                a(dVar.a, dVar, null);
            }
        }
        dVar.m = false;
        dVar.n = false;
        dVar.o = false;
        dVar.h = null;
        dVar.q = true;
        if (this.F == dVar) {
            this.F = null;
        }
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void a(View view, LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    boolean a(int i, KeyEvent keyEvent) {
        a a = a();
        if (a != null && a.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.F == null) {
                d a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.F == null) {
            return true;
        } else {
            this.F.n = true;
            return true;
        }
    }

    public boolean a(h hVar, MenuItem menuItem) {
        Callback q = q();
        if (!(q == null || p())) {
            d a = a(hVar.p());
            if (a != null) {
                return q.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.m != null) {
            this.m.c();
        }
        android.support.v7.view.b.a bVar = new b(this, aVar);
        a a = a();
        if (a != null) {
            this.m = a.a(bVar);
            if (!(this.m == null || this.e == null)) {
                this.e.a(this.m);
            }
        }
        if (this.m == null) {
            this.m = a(bVar);
        }
        return this.m;
    }

    public View b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.L == null) {
            this.L = new m();
        }
        if (t) {
            boolean a = attributeSet instanceof XmlPullParser ? ((XmlPullParser) attributeSet).getDepth() > 1 : a((ViewParent) view);
            z = a;
        } else {
            z = false;
        }
        return this.L.a(view, str, context, attributeSet, z, t, true, bb.a());
    }

    public void b(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void b(Bundle bundle) {
        w();
    }

    void b(h hVar) {
        if (!this.D) {
            this.D = true;
            this.u.k();
            Callback q = q();
            if (!(q == null || p())) {
                q.onPanelClosed(j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
            this.D = false;
        }
    }

    public void b(View view, LayoutParams layoutParams) {
        w();
        ((ViewGroup) this.y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void b(CharSequence charSequence) {
        if (this.u != null) {
            this.u.setWindowTitle(charSequence);
        } else if (m() != null) {
            m().a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    boolean b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.G;
                this.G = false;
                d a = a(0, false);
                if (a == null || !a.o) {
                    if (u()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(a, true);
                    return true;
                }
                break;
            case j.AppCompatTheme_popupMenuStyle /*82*/:
                e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean b(int i, Menu menu) {
        if (i != j.AppCompatTheme_tooltipFrameBackground) {
            return false;
        }
        a a = a();
        if (a == null) {
            return true;
        }
        a.e(true);
        return true;
    }

    public boolean c(int i) {
        int h = h(i);
        if (this.l && h == j.AppCompatTheme_tooltipFrameBackground) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                z();
                this.l = true;
                return true;
            case 2:
                z();
                this.B = true;
                return true;
            case 5:
                z();
                this.C = true;
                return true;
            case 10:
                z();
                this.j = true;
                return true;
            case j.AppCompatTheme_tooltipFrameBackground /*108*/:
                z();
                this.h = true;
                return true;
            case j.AppCompatTheme_windowActionBar /*109*/:
                z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.G = z;
                break;
            case j.AppCompatTheme_popupMenuStyle /*82*/:
                d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            a(i, keyEvent);
        }
        return false;
    }

    public void d() {
        a a = a();
        if (a != null) {
            a.d(false);
        }
    }

    public void e() {
        a a = a();
        if (a != null) {
            a.d(true);
        }
    }

    void e(int i) {
        a(a(i, true), true);
    }

    public void f() {
        a a = a();
        if (a == null || !a.e()) {
            d(0);
        }
    }

    void f(int i) {
        d a = a(i, true);
        if (a.j != null) {
            Bundle bundle = new Bundle();
            a.j.a(bundle);
            if (bundle.size() > 0) {
                a.s = bundle;
            }
            a.j.g();
            a.j.clear();
        }
        a.r = true;
        a.q = true;
        if ((i == j.AppCompatTheme_tooltipFrameBackground || i == 0) && this.u != null) {
            a = a(0, false);
            if (a != null) {
                a.m = false;
                b(a, null);
            }
        }
    }

    int g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.n == null || !(this.n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.n.getLayoutParams();
            if (this.n.isShown()) {
                if (this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }
                Rect rect = this.J;
                Rect rect2 = this.K;
                rect.set(0, i, 0, 0);
                bc.a(this.y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(android.support.v7.a.a.c.abc_input_method_navigation_guard));
                        this.y.addView(this.A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.A == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.A != null) {
            View view = this.A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    public void g() {
        if (this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }
        super.g();
        if (this.f != null) {
            this.f.g();
        }
    }

    public void h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            android.support.v4.h.e.b(from, this);
        } else if (!(from.getFactory2() instanceof k)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void l() {
        w();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new r((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new r((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.c(this.I);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(view, str, context, attributeSet);
        return a != null ? a : b(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    final boolean s() {
        return this.x && this.y != null && p.l(this.y);
    }

    void t() {
        if (this.q != null) {
            this.q.b();
        }
    }

    boolean u() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        a a = a();
        return a != null && a.f();
    }

    void v() {
        if (this.u != null) {
            this.u.k();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.o = null;
        }
        t();
        d a = a(0, false);
        if (a != null && a.j != null) {
            a.j.close();
        }
    }
}
