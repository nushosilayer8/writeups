package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ai extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static class a extends MarginLayoutParams {
        public float g;
        public int h;

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    public ai(Context context) {
        this(context, null);
    }

    public ai(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ai(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        aw a = aw.a(context, attributeSet, j.LinearLayoutCompat, i, 0);
        int a2 = a.a(j.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(j.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(j.LinearLayoutCompat_divider));
        this.n = a.a(j.LinearLayoutCompat_showDividers, 0);
        this.o = a.e(j.LinearLayoutCompat_dividerPadding, 0);
        a.a();
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        View b;
        a aVar;
        this.f = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj = null;
        Object obj2 = null;
        int i14 = this.b;
        boolean z = this.h;
        int i15 = Integer.MIN_VALUE;
        int i16 = 0;
        while (i16 < virtualChildCount) {
            Object obj3;
            View b2 = b(i16);
            if (b2 == null) {
                this.f += d(i16);
                i3 = i15;
                obj3 = obj2;
                i4 = i13;
                i5 = i10;
                i6 = i9;
            } else if (b2.getVisibility() == 8) {
                i16 += a(b2, i16);
                i3 = i15;
                obj3 = obj2;
                i4 = i13;
                i5 = i10;
                i6 = i9;
            } else {
                if (c(i16)) {
                    this.f += this.m;
                }
                a aVar2 = (a) b2.getLayoutParams();
                float f2 = f + aVar2.g;
                if (mode2 == 1073741824 && aVar2.height == 0 && aVar2.g > 0.0f) {
                    i3 = this.f;
                    this.f = Math.max(i3, (aVar2.topMargin + i3) + aVar2.bottomMargin);
                    obj2 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aVar2.height == 0 && aVar2.g > 0.0f) {
                        i3 = 0;
                        aVar2.height = -2;
                    }
                    int i17 = i3;
                    a(b2, i16, i, 0, i2, f2 == 0.0f ? this.f : 0);
                    if (i17 != Integer.MIN_VALUE) {
                        aVar2.height = i17;
                    }
                    i3 = b2.getMeasuredHeight();
                    i7 = this.f;
                    this.f = Math.max(i7, (((i7 + i3) + aVar2.topMargin) + aVar2.bottomMargin) + b(b2));
                    if (z) {
                        i15 = Math.max(i3, i15);
                    }
                }
                if (i14 >= 0 && i14 == i16 + 1) {
                    this.c = this.f;
                }
                if (i16 >= i14 || aVar2.g <= 0.0f) {
                    Object obj4;
                    Object obj5 = null;
                    if (mode == 1073741824 || aVar2.width != -1) {
                        obj4 = obj;
                    } else {
                        obj4 = 1;
                        obj5 = 1;
                    }
                    i5 = aVar2.rightMargin + aVar2.leftMargin;
                    i6 = b2.getMeasuredWidth() + i5;
                    i9 = Math.max(i9, i6);
                    int combineMeasuredStates = View.combineMeasuredStates(i10, b2.getMeasuredState());
                    i4 = (i13 == 0 || aVar2.width != -1) ? 0 : 1;
                    if (aVar2.g > 0.0f) {
                        i3 = Math.max(i12, obj5 != null ? i5 : i6);
                        i5 = i11;
                    } else {
                        if (obj5 == null) {
                            i5 = i6;
                        }
                        i5 = Math.max(i11, i5);
                        i3 = i12;
                    }
                    i16 += a(b2, i16);
                    obj3 = obj2;
                    i12 = i3;
                    i11 = i5;
                    i6 = i9;
                    i3 = i15;
                    i5 = combineMeasuredStates;
                    obj = obj4;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i16++;
            i15 = i3;
            obj2 = obj3;
            i13 = i4;
            i10 = i5;
            i9 = i6;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f = 0;
            i8 = 0;
            while (i8 < virtualChildCount) {
                b = b(i8);
                if (b == null) {
                    this.f += d(i8);
                    i3 = i8;
                } else if (b.getVisibility() == 8) {
                    i3 = a(b, i8) + i8;
                } else {
                    aVar = (a) b.getLayoutParams();
                    i4 = this.f;
                    this.f = Math.max(i4, (aVar.bottomMargin + ((i4 + i15) + aVar.topMargin)) + b(b));
                    i3 = i8;
                }
                i8 = i3 + 1;
            }
        }
        this.f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
        i8 = (16777215 & resolveSizeAndState) - this.f;
        int i18;
        if (obj2 != null || (i8 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            this.f = 0;
            i15 = 0;
            float f3 = f;
            i6 = i13;
            i18 = i11;
            i4 = i10;
            i12 = i9;
            while (true) {
                i7 = i8;
                if (i15 >= virtualChildCount) {
                    break;
                }
                View b3 = b(i15);
                if (b3.getVisibility() == 8) {
                    i3 = i18;
                    i8 = i4;
                    i5 = i12;
                    i4 = i6;
                } else {
                    float f4;
                    float f5;
                    aVar = (a) b3.getLayoutParams();
                    float f6 = aVar.g;
                    if (f6 > 0.0f) {
                        i8 = (int) ((((float) i7) * f6) / f3);
                        f3 -= f6;
                        i7 -= i8;
                        i5 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + aVar.leftMargin) + aVar.rightMargin, aVar.width);
                        if (aVar.height == 0 && mode2 == 1073741824) {
                            if (i8 <= 0) {
                                i8 = 0;
                            }
                            b3.measure(i5, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                        } else {
                            i8 += b3.getMeasuredHeight();
                            if (i8 < 0) {
                                i8 = 0;
                            }
                            b3.measure(i5, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                        }
                        f4 = f3;
                        i16 = i7;
                        i7 = View.combineMeasuredStates(i4, b3.getMeasuredState() & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i16 = i7;
                        i7 = i4;
                    }
                    i4 = aVar.leftMargin + aVar.rightMargin;
                    i5 = b3.getMeasuredWidth() + i4;
                    i12 = Math.max(i12, i5);
                    Object obj6 = (mode == 1073741824 || aVar.width != -1) ? null : 1;
                    if (obj6 == null) {
                        i4 = i5;
                    }
                    i5 = Math.max(i18, i4);
                    i4 = (i6 == 0 || aVar.width != -1) ? 0 : 1;
                    i6 = this.f;
                    this.f = Math.max(i6, (aVar.bottomMargin + ((b3.getMeasuredHeight() + i6) + aVar.topMargin)) + b(b3));
                    i3 = i5;
                    i5 = i12;
                    f4 = f5;
                    i8 = i7;
                    i7 = i16;
                    f3 = f4;
                }
                i15++;
                i18 = i3;
                i12 = i5;
                i6 = i4;
            }
            this.f += getPaddingTop() + getPaddingBottom();
            i13 = i6;
            i3 = i18;
            i10 = i4;
            i8 = i12;
        } else {
            i18 = Math.max(i11, i12);
            if (z && mode2 != 1073741824) {
                i3 = 0;
                while (true) {
                    i8 = i3;
                    if (i8 >= virtualChildCount) {
                        break;
                    }
                    b = b(i8);
                    if (!(b == null || b.getVisibility() == 8 || ((a) b.getLayoutParams()).g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i15, 1073741824));
                    }
                    i3 = i8 + 1;
                }
            }
            i3 = i18;
            i8 = i9;
        }
        if (i13 != 0 || mode == 1073741824) {
            i3 = i8;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), resolveSizeAndState);
        if (obj != null) {
            c(virtualChildCount, i2);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.e & 8388615;
        switch (this.e & j.AppCompatTheme_windowFixedHeightMajor) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f) / 2);
                break;
            case j.AppCompatTheme_panelMenuListTheme /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = b(i7);
            if (b == null) {
                i8 += d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                i5 = aVar.h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (d.a(i5, p.b(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + aVar.leftMargin;
                        break;
                }
                int i10 = (c(i7) ? this.m + i8 : i8) + aVar.topMargin;
                a(b, i9, i10 + a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((aVar.bottomMargin + measuredHeight) + b(b));
                i5 = a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            int height;
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                a aVar = (a) b2.getLayoutParams();
                height = aVar.bottomMargin + b2.getBottom();
            }
            a(canvas, height);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int b(View view) {
        return 0;
    }

    public a b(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected a b(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    View b(int i) {
        return getChildAt(i);
    }

    void b(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        a aVar;
        this.f = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.a;
        boolean z2 = this.h;
        Object obj5 = mode == 1073741824 ? 1 : null;
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        while (i14 < virtualChildCount) {
            Object obj6;
            View b = b(i14);
            if (b == null) {
                this.f += d(i14);
                i3 = i13;
                obj = obj4;
                obj6 = obj2;
                i4 = i10;
                i5 = i9;
            } else if (b.getVisibility() == 8) {
                i14 += a(b, i14);
                i3 = i13;
                obj = obj4;
                obj6 = obj2;
                i4 = i10;
                i5 = i9;
            } else {
                Object obj7;
                if (c(i14)) {
                    this.f += this.l;
                }
                a aVar2 = (a) b.getLayoutParams();
                float f2 = f + aVar2.g;
                if (mode == 1073741824 && aVar2.width == 0 && aVar2.g > 0.0f) {
                    if (obj5 != null) {
                        this.f += aVar2.leftMargin + aVar2.rightMargin;
                    } else {
                        i3 = this.f;
                        this.f = Math.max(i3, (aVar2.leftMargin + i3) + aVar2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aVar2.width == 0 && aVar2.g > 0.0f) {
                        i3 = 0;
                        aVar2.width = -2;
                    }
                    int i15 = i3;
                    a(b, i14, i, f2 == 0.0f ? this.f : 0, i2, 0);
                    if (i15 != Integer.MIN_VALUE) {
                        aVar2.width = i15;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj5 != null) {
                        this.f += ((aVar2.leftMargin + i3) + aVar2.rightMargin) + b(b);
                    } else {
                        i6 = this.f;
                        this.f = Math.max(i6, (((i6 + i3) + aVar2.leftMargin) + aVar2.rightMargin) + b(b));
                    }
                    if (z2) {
                        i13 = Math.max(i3, i13);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || aVar2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i4 = aVar2.bottomMargin + aVar2.topMargin;
                i5 = b.getMeasuredHeight() + i4;
                int combineMeasuredStates = View.combineMeasuredStates(i10, b.getMeasuredState());
                if (z) {
                    i10 = b.getBaseline();
                    if (i10 != -1) {
                        i7 = ((((aVar2.h < 0 ? this.e : aVar2.h) & j.AppCompatTheme_windowFixedHeightMajor) >> 4) & -2) >> 1;
                        iArr[i7] = Math.max(iArr[i7], i10);
                        iArr2[i7] = Math.max(iArr2[i7], i5 - i10);
                    }
                }
                i10 = Math.max(i9, i5);
                obj6 = (obj2 == null || aVar2.height != -1) ? null : 1;
                if (aVar2.g > 0.0f) {
                    i3 = Math.max(i12, obj8 != null ? i4 : i5);
                    i4 = i11;
                } else {
                    if (obj8 == null) {
                        i4 = i5;
                    }
                    i4 = Math.max(i11, i4);
                    i3 = i12;
                }
                i14 += a(b, i14);
                obj = obj4;
                i12 = i3;
                i11 = i4;
                i5 = i10;
                i3 = i13;
                i4 = combineMeasuredStates;
                obj3 = obj7;
                f = f2;
            }
            i14++;
            i13 = i3;
            obj4 = obj;
            obj2 = obj6;
            i10 = i4;
            i9 = i5;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        i14 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i9 : Math.max(i9, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            i8 = 0;
            while (i8 < virtualChildCount) {
                View b2 = b(i8);
                if (b2 == null) {
                    this.f += d(i8);
                    i3 = i8;
                } else if (b2.getVisibility() == 8) {
                    i3 = a(b2, i8) + i8;
                } else {
                    aVar = (a) b2.getLayoutParams();
                    if (obj5 != null) {
                        this.f = ((aVar.rightMargin + (aVar.leftMargin + i13)) + b(b2)) + this.f;
                        i3 = i8;
                    } else {
                        i4 = this.f;
                        this.f = Math.max(i4, (aVar.rightMargin + ((i4 + i13) + aVar.leftMargin)) + b(b2));
                        i3 = i8;
                    }
                }
                i8 = i3 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        i8 = (16777215 & resolveSizeAndState) - this.f;
        int i16;
        if (obj4 != null || (i8 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            i13 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i11;
            i7 = i10;
            i6 = i8;
            i11 = -1;
            while (i13 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = b(i13);
                if (b3 == null) {
                    f4 = f3;
                    i8 = i6;
                    i4 = i11;
                    i6 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i8 = i6;
                    i4 = i11;
                    i6 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    aVar = (a) b3.getLayoutParams();
                    float f6 = aVar.g;
                    if (f6 > 0.0f) {
                        i8 = (int) ((((float) i6) * f6) / f3);
                        f3 -= f6;
                        i4 = i6 - i8;
                        i6 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + aVar.topMargin) + aVar.bottomMargin, aVar.height);
                        if (aVar.width == 0 && mode == 1073741824) {
                            if (i8 <= 0) {
                                i8 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), i6);
                        } else {
                            i8 += b3.getMeasuredWidth();
                            if (i8 < 0) {
                                i8 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), i6);
                        }
                        i12 = View.combineMeasuredStates(i7, b3.getMeasuredState() & -16777216);
                        f5 = f3;
                    } else {
                        i4 = i6;
                        i12 = i7;
                        f5 = f3;
                    }
                    if (obj5 != null) {
                        this.f += ((b3.getMeasuredWidth() + aVar.leftMargin) + aVar.rightMargin) + b(b3);
                    } else {
                        i8 = this.f;
                        this.f = Math.max(i8, (((b3.getMeasuredWidth() + i8) + aVar.leftMargin) + aVar.rightMargin) + b(b3));
                    }
                    obj = (mode2 == 1073741824 || aVar.height != -1) ? null : 1;
                    i14 = aVar.topMargin + aVar.bottomMargin;
                    i6 = b3.getMeasuredHeight() + i14;
                    i11 = Math.max(i11, i6);
                    i14 = Math.max(i16, obj != null ? i14 : i6);
                    obj = (obj9 == null || aVar.height != -1) ? null : 1;
                    if (z) {
                        i5 = b3.getBaseline();
                        if (i5 != -1) {
                            i3 = ((((aVar.h < 0 ? this.e : aVar.h) & j.AppCompatTheme_windowFixedHeightMajor) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i5);
                            iArr2[i3] = Math.max(iArr2[i3], i6 - i5);
                        }
                    }
                    f4 = f5;
                    i6 = i14;
                    obj10 = obj;
                    i7 = i12;
                    i8 = i4;
                    i4 = i11;
                }
                i13++;
                i16 = i6;
                i11 = i4;
                obj9 = obj10;
                i6 = i8;
                f3 = f4;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i11 = Math.max(i11, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i10 = i7;
            i8 = i11;
        } else {
            i16 = Math.max(i11, i12);
            if (z2 && mode != 1073741824) {
                i3 = 0;
                while (true) {
                    i8 = i3;
                    if (i8 >= virtualChildCount) {
                        break;
                    }
                    View b4 = b(i8);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((a) b4.getLayoutParams()).g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i13, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                    i3 = i8 + 1;
                }
            }
            i3 = i16;
            i8 = i14;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i8;
        }
        setMeasuredDimension((-16777216 & i10) | resolveSizeAndState, View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i10 << 16));
        if (obj3 != null) {
            d(virtualChildCount, i);
        }
    }

    void b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bc.a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.e & 8388615;
        int i8 = this.e & j.AppCompatTheme_windowFixedHeightMajor;
        boolean z = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        switch (d.a(i7, p.b(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = b(i10);
            if (b == null) {
                paddingLeft += d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                i7 = (!z || aVar.height == -1) ? -1 : b.getBaseline();
                int i12 = aVar.h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & j.AppCompatTheme_windowFixedHeightMajor) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + aVar.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case j.AppCompatTheme_panelMenuListTheme /*80*/:
                        i11 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (c(i10) ? this.l + paddingLeft : paddingLeft) + aVar.leftMargin;
                a(b, paddingLeft + a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (aVar.rightMargin + measuredWidth) + b(b);
                i7 = a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void b(Canvas canvas) {
        a aVar;
        int virtualChildCount = getVirtualChildCount();
        boolean a = bc.a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                aVar = (a) b.getLayoutParams();
                b(canvas, a ? aVar.rightMargin + b.getRight() : (b.getLeft() - aVar.leftMargin) - this.l);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            int paddingLeft;
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.l;
            } else {
                aVar = (a) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - aVar.leftMargin) - this.l : aVar.rightMargin + b2.getRight();
            }
            b(canvas, paddingLeft);
        }
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    protected boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.n & 4) != 0;
            } else {
                if ((this.n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.c;
            if (this.d == 1) {
                i = this.e & j.AppCompatTheme_windowFixedHeightMajor;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                            break;
                        case j.AppCompatTheme_panelMenuListTheme /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                            break;
                    }
                }
            }
            i = i2;
            return (((a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    protected a j() {
        return this.d == 0 ? new a(-2, -2) : this.d == 1 ? new a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ai.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ai.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & j.AppCompatTheme_windowFixedHeightMajor) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & j.AppCompatTheme_windowFixedHeightMajor;
        if ((this.e & j.AppCompatTheme_windowFixedHeightMajor) != i2) {
            this.e = i2 | (this.e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
