package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ai implements android.support.v7.view.menu.h.b, p {
    android.support.v7.view.menu.h.a a;
    e b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private d g;
    private android.support.v7.view.menu.o.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public interface a {
        boolean c();

        boolean d();
    }

    private static class b implements android.support.v7.view.menu.o.a {
        b() {
        }

        public void a(h hVar, boolean z) {
        }

        public boolean a(h hVar) {
            return false;
        }
    }

    public static class c extends android.support.v7.widget.ai.a {
        @ExportedProperty
        public boolean a;
        @ExportedProperty
        public int b;
        @ExportedProperty
        public int c;
        @ExportedProperty
        public boolean d;
        @ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }

        public c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class d implements android.support.v7.view.menu.h.a {
        final /* synthetic */ ActionMenuView a;

        d(ActionMenuView actionMenuView) {
            this.a = actionMenuView;
        }

        public void a(h hVar) {
            if (this.a.a != null) {
                this.a.a.a(hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return this.a.b != null && this.a.b.a(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!cVar.a && z2) {
            z = true;
        }
        cVar.d = z;
        cVar.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.k;
        size = i3 % this.k;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        View childAt;
        int i5;
        c cVar;
        Object obj;
        int i6 = this.k + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.l, 0, this.l, 0);
                }
                cVar = (c) childAt.getLayoutParams();
                cVar.f = false;
                cVar.c = 0;
                cVar.b = 0;
                cVar.d = false;
                cVar.leftMargin = 0;
                cVar.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).b();
                cVar.e = z2;
                int a = a(childAt, i6, cVar.a ? 1 : i4, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                paddingLeft = cVar.d ? i9 + 1 : i9;
                obj = cVar.a ? 1 : obj2;
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            int i15;
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            size = 0;
            while (true) {
                i15 = size;
                if (i15 >= childCount) {
                    break;
                }
                cVar = (c) getChildAt(i15).getLayoutParams();
                if (!cVar.d) {
                    size = i4;
                    i4 = i5;
                } else if (cVar.b < i5) {
                    i4 = cVar.b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (cVar.b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                cVar = (c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj3 != null && cVar.e && i4 == 1) {
                        childAt2.setPadding(this.l + i6, 0, this.l, 0);
                    }
                    cVar.b++;
                    cVar.f = true;
                    size = i4 - 1;
                } else if (cVar.b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((c) getChildAt(0).getLayoutParams()).e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((c) getChildAt(childCount - 1).getLayoutParams()).e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            cVar = (c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                cVar.c = paddingLeft;
                                cVar.f = true;
                                if (i4 == 0 && !cVar.e) {
                                    cVar.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (cVar.a) {
                                if (i4 != 0) {
                                    cVar.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    cVar.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                cVar.c = paddingLeft;
                                cVar.f = true;
                                cVar.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    cVar = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar.c = paddingLeft;
                        cVar.f = true;
                        cVar.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (cVar.a) {
                        if (i4 != 0) {
                            cVar.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            cVar.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        cVar.c = paddingLeft;
                        cVar.f = true;
                        cVar.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            size = 0;
            while (true) {
                paddingLeft = size;
                if (paddingLeft >= childCount) {
                    break;
                }
                childAt = getChildAt(paddingLeft);
                cVar = (c) childAt.getLayoutParams();
                if (cVar.f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(cVar.c + (cVar.b * i6), 1073741824), childMeasureSpec);
                }
                size = paddingLeft + 1;
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    public c a(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    protected c a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return b();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h > 0) {
            return cVar;
        }
        cVar.h = 16;
        return cVar;
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    public boolean a() {
        return this.f;
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = 0 | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).c() | z;
    }

    public boolean a(j jVar) {
        return this.c.a((MenuItem) jVar, 0);
    }

    protected c b() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public /* synthetic */ android.support.v7.widget.ai.a b(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.support.v7.widget.ai.a b(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public c c() {
        c b = b();
        b.a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public h d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.d();
    }

    public boolean f() {
        return this.g != null && this.g.e();
    }

    public boolean g() {
        return this.g != null && this.g.h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new h(context);
            this.c.a(new d(this));
            this.g = new d(context);
            this.g.c(true);
            this.g.a(this.h != null ? this.h : new b());
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.g != null && this.g.i();
    }

    public void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    protected /* synthetic */ android.support.v7.widget.ai.a j() {
        return b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.b(false);
            if (this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i) {
            int i5;
            int i6;
            c cVar;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bc.a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    cVar = (c) childAt.getLayoutParams();
                    if (cVar.a) {
                        i6 = childAt.getMeasuredWidth();
                        if (a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = cVar.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    cVar = (c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (cVar.a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= cVar.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((cVar.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                cVar = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (cVar.a) {
                    paddingLeft = i6;
                } else {
                    i6 += cVar.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((cVar.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.i;
        this.i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.i || this.c == null || size == this.j)) {
            this.j = size;
            this.c.b(true);
        }
        int childCount = getChildCount();
        if (!this.i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.d(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(d dVar) {
        this.g = dVar;
        this.g.a(this);
    }
}
