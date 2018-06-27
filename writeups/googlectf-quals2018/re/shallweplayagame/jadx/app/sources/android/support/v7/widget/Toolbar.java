package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.h.f;
import android.support.v4.h.p;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView.e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final e H;
    private ax I;
    private d J;
    private a K;
    private android.support.v7.view.menu.o.a L;
    private android.support.v7.view.menu.h.a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ao u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    private class a implements o {
        h a;
        j b;
        final /* synthetic */ Toolbar c;

        a(Toolbar toolbar) {
            this.c = toolbar;
        }

        public void a(Context context, h hVar) {
            if (!(this.a == null || this.b == null)) {
                this.a.d(this.b);
            }
            this.a = hVar;
        }

        public void a(h hVar, boolean z) {
        }

        public void a(android.support.v7.view.menu.o.a aVar) {
        }

        public boolean a(h hVar, j jVar) {
            this.c.i();
            if (this.c.a.getParent() != this.c) {
                this.c.addView(this.c.a);
            }
            this.c.b = jVar.getActionView();
            this.b = jVar;
            if (this.c.b.getParent() != this.c) {
                LayoutParams j = this.c.j();
                j.a = 8388611 | (this.c.c & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor);
                j.b = 2;
                this.c.b.setLayoutParams(j);
                this.c.addView(this.c.b);
            }
            this.c.k();
            this.c.requestLayout();
            jVar.e(true);
            if (this.c.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) this.c.b).a();
            }
            return true;
        }

        public boolean a(u uVar) {
            return false;
        }

        public void b(boolean z) {
            Object obj = null;
            if (this.b != null) {
                if (this.a != null) {
                    int size = this.a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    b(this.a, this.b);
                }
            }
        }

        public boolean b() {
            return false;
        }

        public boolean b(h hVar, j jVar) {
            if (this.c.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) this.c.b).b();
            }
            this.c.removeView(this.c.b);
            this.c.removeView(this.c.a);
            this.c.b = null;
            this.c.l();
            this.b = null;
            this.c.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    public static class b extends android.support.v7.app.a.a {
        int b;

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(android.support.v7.app.a.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public b(b bVar) {
            super((android.support.v7.app.a.a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public static class d extends android.support.v4.h.a {
        public static final Creator<d> CREATOR = new ClassLoaderCreator<d>() {
            public d a(Parcel parcel) {
                return new d(parcel, null);
            }

            public d a(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            public d[] a(int i) {
                return new d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }
        };
        int b;
        boolean c;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new e(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public boolean a(MenuItem menuItem) {
                return this.a.d != null ? this.a.d.a(menuItem) : false;
            }
        };
        this.O = new Runnable(this) {
            final /* synthetic */ Toolbar a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
            }
        };
        aw a = aw.a(getContext(), attributeSet, android.support.v7.a.a.j.Toolbar, i, 0);
        this.n = a.g(android.support.v7.a.a.j.Toolbar_titleTextAppearance, 0);
        this.o = a.g(android.support.v7.a.a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = a.c(android.support.v7.a.a.j.Toolbar_android_gravity, this.x);
        this.c = a.c(android.support.v7.a.a.j.Toolbar_buttonGravity, 48);
        int d = a.d(android.support.v7.a.a.j.Toolbar_titleMargin, 0);
        if (a.g(android.support.v7.a.a.j.Toolbar_titleMargins)) {
            d = a.d(android.support.v7.a.a.j.Toolbar_titleMargins, d);
        }
        this.t = d;
        this.s = d;
        this.r = d;
        this.q = d;
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.q = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.r = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.s = d;
        }
        d = a.d(android.support.v7.a.a.j.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.t = d;
        }
        this.p = a.e(android.support.v7.a.a.j.Toolbar_maxButtonHeight, -1);
        d = a.d(android.support.v7.a.a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.d(android.support.v7.a.a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.e(android.support.v7.a.a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a.e(android.support.v7.a.a.j.Toolbar_contentInsetRight, 0);
        s();
        this.u.b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.u.a(d, d2);
        }
        this.v = a.d(android.support.v7.a.a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a.d(android.support.v7.a.a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = a.a(android.support.v7.a.a.j.Toolbar_collapseIcon);
        this.k = a.c(android.support.v7.a.a.j.Toolbar_collapseContentDescription);
        CharSequence c = a.c(android.support.v7.a.a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.l = getContext();
        setPopupTheme(a.g(android.support.v7.a.a.j.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(android.support.v7.a.a.j.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.a(android.support.v7.a.a.j.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.c(android.support.v7.a.a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.g(android.support.v7.a.a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.b(android.support.v7.a.a.j.Toolbar_titleTextColor, -1));
        }
        if (a.g(android.support.v7.a.a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.b(android.support.v7.a.a.j.Toolbar_subtitleTextColor, -1));
        }
        a.a();
    }

    private int a(int i) {
        int i2 = i & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor;
        switch (i2) {
            case 16:
            case 48:
            case android.support.v7.a.a.j.AppCompatTheme_panelMenuListTheme /*80*/:
                return i2;
            default:
                return this.x & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor;
        }
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(bVar.a)) {
            case 48:
                return getPaddingTop() - i2;
            case android.support.v7.a.a.j.AppCompatTheme_panelMenuListTheme /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < bVar.topMargin) {
                    i3 = bVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < bVar.bottomMargin ? Math.max(0, i2 - (bVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (bVar.rightMargin + measuredWidth) + max;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            b bVar = (b) view.getLayoutParams();
            i6 = bVar.leftMargin - i6;
            i = bVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = j();
        } else if (checkLayoutParams(layoutParams)) {
            b bVar = (b) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.b == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.F.add(view);
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (p.b(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = android.support.v4.h.d.a(i, p.b(this));
        list.clear();
        b bVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            bVar = (b) childAt2.getLayoutParams();
            if (bVar.b == 0 && a(childAt2) && b(bVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int b = p.b(this);
        int a = android.support.v4.h.d.a(i, b) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return b == 1 ? 5 : 3;
        }
    }

    private int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return f.b(marginLayoutParams) + f.a(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (bVar.leftMargin + measuredWidth);
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private void m() {
        if (this.i == null) {
            this.i = new p(getContext());
        }
    }

    private void n() {
        o();
        if (this.e.d() == null) {
            h hVar = (h) this.e.getMenu();
            if (this.K == null) {
                this.K = new a(this);
            }
            this.e.setExpandedActionViewsExclusive(true);
            hVar.a(this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            LayoutParams j = j();
            j.a = 8388613 | (this.c & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor);
            this.e.setLayoutParams(j);
            a(this.e, false);
        }
    }

    private void p() {
        if (this.h == null) {
            this.h = new n(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            LayoutParams j = j();
            j.a = 8388611 | (this.c & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor);
            this.h.setLayoutParams(j);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.u == null) {
            this.u = new ao();
        }
    }

    public b a(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    protected b a(LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof android.support.v7.app.a.a ? new b((android.support.v7.app.a.a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        s();
        this.u.a(i, i2);
    }

    public void a(Context context, int i) {
        this.n = i;
        if (this.f != null) {
            this.f.setTextAppearance(context, i);
        }
    }

    public void a(h hVar, d dVar) {
        if (hVar != null || this.e != null) {
            o();
            h d = this.e.d();
            if (d != hVar) {
                if (d != null) {
                    d.b(this.J);
                    d.b(this.K);
                }
                if (this.K == null) {
                    this.K = new a(this);
                }
                dVar.d(true);
                if (hVar != null) {
                    hVar.a((o) dVar, this.l);
                    hVar.a(this.K, this.l);
                } else {
                    dVar.a(this.l, null);
                    this.K.a(this.l, null);
                    dVar.b(true);
                    this.K.b(true);
                }
                this.e.setPopupTheme(this.m);
                this.e.setPresenter(dVar);
                this.J = dVar;
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.e != null) {
            this.e.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.u != null ? this.u.d() : 0;
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.u != null ? this.u.a() : 0;
    }

    public int getContentInsetRight() {
        return this.u != null ? this.u.b() : 0;
    }

    public int getContentInsetStart() {
        return this.u != null ? this.u.c() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.e != null) {
            h d = this.e.d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        return i != 0 ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return p.b(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return p.b(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.i != null ? this.i.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.i != null ? this.i.getContentDescription() : null;
    }

    public Menu getMenu() {
        n();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.h != null ? this.h.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.h != null ? this.h.getDrawable() : null;
    }

    d getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public ad getWrapper() {
        if (this.I == null) {
            this.I = new ax(this, true);
        }
        return this.I;
    }

    public void h() {
        j jVar = this.K == null ? null : this.K.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    void i() {
        if (this.a == null) {
            this.a = new n(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            LayoutParams j = j();
            j.a = 8388611 | (this.c & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor);
            j.b = 2;
            this.a.setLayoutParams(j);
            this.a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ Toolbar a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.h();
                }
            });
        }
    }

    protected b j() {
        return new b(-2, -2);
    }

    void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((b) childAt.getLayoutParams()).b == 2 || childAt == this.e)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar;
        int measuredHeight;
        int measuredWidth;
        Object obj = p.b(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int c = p.c(this);
        int min = c >= 0 ? Math.min(c, i4 - i2) : 0;
        if (!a(this.h)) {
            c = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            c = b(this.h, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = a(this.h, paddingLeft, iArr, min);
            c = i6;
        }
        if (a(this.a)) {
            if (obj != null) {
                c = b(this.a, c, iArr, min);
            } else {
                i5 = a(this.a, i5, iArr, min);
            }
        }
        if (a(this.e)) {
            if (obj != null) {
                i5 = a(this.e, i5, iArr, min);
            } else {
                c = b(this.e, c, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - c));
        i5 = Math.max(i5, currentContentInsetLeft);
        c = Math.min(c, (width - paddingRight) - currentContentInsetRight);
        if (a(this.b)) {
            if (obj != null) {
                c = b(this.b, c, iArr, min);
            } else {
                i5 = a(this.b, i5, iArr, min);
            }
        }
        if (!a(this.i)) {
            currentContentInsetLeft = c;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = b(this.i, c, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = c;
            currentContentInsetRight = a(this.i, i5, iArr, min);
        }
        boolean a = a(this.f);
        boolean a2 = a(this.g);
        i5 = 0;
        if (a) {
            bVar = (b) this.f.getLayoutParams();
            i5 = 0 + (bVar.bottomMargin + (bVar.topMargin + this.f.getMeasuredHeight()));
        }
        if (a2) {
            bVar = (b) this.g.getLayoutParams();
            measuredHeight = (bVar.bottomMargin + (bVar.topMargin + this.g.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            bVar = (b) (a ? this.f : this.g).getLayoutParams();
            b bVar2 = (b) (a2 ? this.g : this.f).getLayoutParams();
            Object obj2 = ((!a || this.f.getMeasuredWidth() <= 0) && (!a2 || this.g.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.x & android.support.v7.a.a.j.AppCompatTheme_windowFixedHeightMajor) {
                case 48:
                    paddingTop2 = (bVar.topMargin + getPaddingTop()) + this.s;
                    break;
                case android.support.v7.a.a.j.AppCompatTheme_panelMenuListTheme /*80*/:
                    paddingTop2 = (((height - paddingBottom) - bVar2.bottomMargin) - this.t) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < bVar.topMargin + this.s) {
                        c = bVar.topMargin + this.s;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        c = measuredHeight < bVar.bottomMargin + this.t ? Math.max(0, paddingTop2 - ((bVar2.bottomMargin + this.t) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + c;
                    break;
            }
            if (obj != null) {
                c = (obj2 != null ? this.q : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, c);
                iArr[1] = Math.max(0, -c);
                if (a) {
                    bVar = (b) this.f.getLayoutParams();
                    measuredWidth = i5 - this.f.getMeasuredWidth();
                    currentContentInsetLeft = this.f.getMeasuredHeight() + paddingTop2;
                    this.f.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + bVar.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.r;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    bVar = (b) this.g.getLayoutParams();
                    measuredWidth = bVar.topMargin + paddingTop2;
                    measuredHeight = this.g.getMeasuredHeight() + measuredWidth;
                    this.g.layout(i5 - this.g.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    c = bVar.bottomMargin + measuredHeight;
                    c = i5 - this.r;
                } else {
                    c = i5;
                }
                currentContentInsetLeft = obj2 != null ? Math.min(currentContentInsetLeft, c) : i5;
            } else {
                c = (obj2 != null ? this.q : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, c);
                iArr[0] = Math.max(0, -c);
                if (a) {
                    bVar = (b) this.f.getLayoutParams();
                    i5 = this.f.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f.getMeasuredHeight() + paddingTop2;
                    this.f.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    c = bVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.r;
                    i5 = c;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    bVar = (b) this.g.getLayoutParams();
                    i5 += bVar.topMargin;
                    paddingTop2 = this.g.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.g.getMeasuredHeight() + i5;
                    this.g.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    c = bVar.bottomMargin + measuredHeight;
                    c = this.r + paddingTop2;
                } else {
                    c = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, c);
                }
            }
        }
        a(this.E, 3);
        int size = this.E.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = a((View) this.E.get(measuredWidth), i5, iArr, min);
        }
        a(this.E, 5);
        currentContentInsetRight = this.E.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = b((View) this.E.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        a(this.E, 1);
        measuredWidth = a(this.E, iArr);
        c = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += c;
        if (c < i5) {
            c = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            c -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.E.size();
        measuredWidth = c;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = a((View) this.E.get(i5), measuredWidth, iArr, min);
        }
        this.E.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.G;
        if (bc.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            i7 = this.h.getMeasuredWidth() + b(this.h);
            max = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            i6 = View.combineMeasuredStates(0, this.h.getMeasuredState());
            i5 = max;
        }
        if (a(this.a)) {
            a(this.a, i, 0, i2, 0, this.p);
            i7 = this.a.getMeasuredWidth() + b(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            i6 = View.combineMeasuredStates(i6, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (a(this.e)) {
            a(this.e, i, max2, i2, 0, this.p);
            i7 = this.e.getMeasuredWidth() + b(this.e);
            i5 = Math.max(i5, this.e.getMeasuredHeight() + c(this.e));
            i6 = View.combineMeasuredStates(i6, this.e.getMeasuredState());
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (a(this.b)) {
            max2 += a(this.b, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + c(this.b));
            i6 = View.combineMeasuredStates(i6, this.b.getMeasuredState());
        }
        if (a(this.i)) {
            max2 += a(this.i, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + c(this.i));
            i6 = View.combineMeasuredStates(i6, this.i.getMeasuredState());
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i7 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.s + this.t;
        max = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = b(this.f) + this.f.getMeasuredWidth();
            i7 = this.f.getMeasuredHeight() + c(this.f);
            i5 = View.combineMeasuredStates(i5, this.f.getMeasuredState());
        }
        if (a(this.g)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, a(this.g, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.g.getMeasuredHeight() + c(this.g);
            i5 = View.combineMeasuredStates(i5, this.g.getMeasuredState());
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = View.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (r()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            super.onRestoreInstanceState(dVar.a());
            Menu d = this.e != null ? this.e.d() : null;
            if (!(dVar.b == 0 || this.K == null || d == null)) {
                MenuItem findItem = d.findItem(dVar.b);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (dVar.c) {
                q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        s();
        ao aoVar = this.u;
        if (i != 1) {
            z = false;
        }
        aoVar.a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable dVar = new d(super.onSaveInstanceState());
        if (!(this.K == null || this.K.b == null)) {
            dVar.b = this.K.b.getItemId();
        }
        dVar.c = b();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.b.a.b.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.i)) {
                a(this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.b.a.b.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.h)) {
                a(this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        p();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new aa(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a(this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.B = i;
        if (this.g != null) {
            this.g.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new aa(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a(this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        if (this.f != null) {
            this.f.setTextColor(i);
        }
    }
}
