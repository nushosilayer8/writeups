package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.k;
import android.support.v4.h.m;
import android.support.v4.h.p;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements k, ac {
    static final int[] e = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final Runnable A;
    private final Runnable B;
    private final m C;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private ad i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private a x;
    private final int y;
    private OverScroller z;

    public interface a {
        void a(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    public static class b extends MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.y = 600;
        this.d = new AnimatorListenerAdapter(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void onAnimationCancel(Animator animator) {
                this.a.c = null;
                this.a.b = false;
            }

            public void onAnimationEnd(Animator animator) {
                this.a.c = null;
                this.a.b = false;
            }
        };
        this.A = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
                this.a.c = this.a.a.animate().translationY(0.0f).setListener(this.a.d);
            }
        };
        this.B = new Runnable(this) {
            final /* synthetic */ ActionBarOverlayLayout a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
                this.a.c = this.a.a.animate().translationY((float) (-this.a.a.getHeight())).setListener(this.a.d);
            }
        };
        a(context);
        this.C = new m(this);
    }

    private ad a(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.k = z;
        this.z = new OverScroller(context);
    }

    private boolean a(float f, float f2) {
        this.z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.z.getFinalY() > this.a.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        b bVar = (b) view.getLayoutParams();
        if (z && bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    private void l() {
        d();
        postDelayed(this.A, 600);
    }

    private void m() {
        d();
        postDelayed(this.B, 600);
    }

    private void n() {
        d();
        this.A.run();
    }

    private void o() {
        d();
        this.B.run();
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void a(int i) {
        c();
        switch (i) {
            case 2:
                this.i.f();
                return;
            case 5:
                this.i.g();
                return;
            case j.AppCompatTheme_windowActionBar /*109*/:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void a(Menu menu, android.support.v7.view.menu.o.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    public boolean a() {
        return this.l;
    }

    protected b b() {
        return new b(-1, -1);
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.a = (ActionBarContainer) findViewById(f.action_bar_container);
            this.i = a(findViewById(f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    void d() {
        removeCallbacks(this.A);
        removeCallbacks(this.B);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !this.k) {
            int bottom = this.a.getVisibility() == 0 ? (int) ((((float) this.a.getBottom()) + this.a.getTranslationY()) + 0.5f) : 0;
            this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
            this.j.draw(canvas);
        }
    }

    public boolean e() {
        c();
        return this.i.h();
    }

    public boolean f() {
        c();
        return this.i.i();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        c();
        if ((p.f(this) & 256) != 0) {
            a = a(this.a, rect, true, true, false, true);
            this.t.set(rect);
            bc.a(this, this.t, this.q);
        } else {
            a = a(this.a, rect, true, true, false, true);
            this.t.set(rect);
            bc.a(this, this.t, this.q);
        }
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        c();
        return this.i.j();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.a != null ? -((int) this.a.getTranslationY()) : 0;
    }

    public int getNestedScrollAxes() {
        return this.C.a();
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    public boolean h() {
        c();
        return this.i.k();
    }

    public boolean i() {
        c();
        return this.i.l();
    }

    public void j() {
        c();
        this.i.m();
    }

    public void k() {
        c();
        this.i.n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        p.g(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int i6 = bVar.leftMargin + paddingLeft;
                paddingRight = bVar.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        c();
        measureChildWithMargins(this.a, i, 0, i2, 0);
        b bVar = (b) this.a.getLayoutParams();
        int max = Math.max(0, (this.a.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        int max2 = Math.max(0, bVar.bottomMargin + (this.a.getMeasuredHeight() + bVar.topMargin));
        int combineMeasuredStates = View.combineMeasuredStates(0, this.a.getMeasuredState());
        Object obj = (p.f(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f;
            if (this.m && this.a.getTabContainer() != null) {
                i3 += this.f;
            }
        } else {
            i3 = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        Rect rect;
        Rect rect2;
        if (this.l || obj != null) {
            rect = this.v;
            rect.top = i3 + rect.top;
            rect2 = this.v;
            rect2.bottom += 0;
        } else {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        }
        a(this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        bVar = (b) this.h.getLayoutParams();
        int max3 = Math.max(max, (this.h.getMeasuredWidth() + bVar.leftMargin) + bVar.rightMargin);
        i3 = Math.max(max2, bVar.bottomMargin + (this.h.getMeasuredHeight() + bVar.topMargin));
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.n || !z) {
            return false;
        }
        if (a(f, f2)) {
            o();
        } else {
            n();
        }
        this.b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.o += i2;
        setActionBarHideOffset(this.o);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.C.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        if (this.x != null) {
            this.x.l();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.a.getVisibility() != 0) ? false : this.n;
    }

    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.x != null) {
            this.x.m();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.x != null) {
            a aVar = this.x;
            if (z3) {
                z = false;
            }
            aVar.g(z);
            if (z2 || !z3) {
                this.x.j();
            } else {
                this.x.k();
            }
        }
        if ((i2 & 256) != 0 && this.x != null) {
            p.g(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        if (this.x != null) {
            this.x.a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.a.setTranslationY((float) (-Math.max(0, Math.min(i, this.a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.x = aVar;
        if (getWindowToken() != null) {
            this.x.a(this.g);
            if (this.p != 0) {
                onWindowSystemUiVisibilityChanged(this.p);
                p.g(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (!z) {
                d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        c();
        this.i.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.k = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        c();
        this.i.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
