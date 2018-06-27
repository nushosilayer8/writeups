package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.a.a.b;
import android.support.constraint.a.a.c;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> a = new SparseArray();
    c b = new c();
    private final ArrayList<b> c = new ArrayList(100);
    private int d = 0;
    private int e = 0;
    private int f = Integer.MAX_VALUE;
    private int g = Integer.MAX_VALUE;
    private boolean h = true;
    private int i = 2;
    private a j = null;

    public static class a extends MarginLayoutParams {
        int A = 1;
        public float B = 0.0f;
        public float C = 0.0f;
        public int D = 0;
        public int E = 0;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        boolean O = true;
        boolean P = true;
        boolean Q = false;
        boolean R = false;
        int S = -1;
        int T = -1;
        int U = -1;
        int V = -1;
        int W = -1;
        int X = -1;
        float Y = 0.5f;
        b Z = new b();
        public int a = -1;
        public int b = -1;
        public float c = -1.0f;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public int g = -1;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public float w = 0.5f;
        public float x = 0.5f;
        public String y = null;
        float z = 0.0f;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.constraint.c.a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
                    this.d = obtainStyledAttributes.getResourceId(index, this.d);
                    if (this.d == -1) {
                        this.d = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    if (this.e == -1) {
                        this.e = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
                    this.f = obtainStyledAttributes.getResourceId(index, this.f);
                    if (this.f == -1) {
                        this.f = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
                    this.g = obtainStyledAttributes.getResourceId(index, this.g);
                    if (this.g == -1) {
                        this.g = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
                    this.h = obtainStyledAttributes.getResourceId(index, this.h);
                    if (this.h == -1) {
                        this.h = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
                    this.i = obtainStyledAttributes.getResourceId(index, this.i);
                    if (this.i == -1) {
                        this.i = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
                    this.j = obtainStyledAttributes.getResourceId(index, this.j);
                    if (this.j == -1) {
                        this.j = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
                    this.k = obtainStyledAttributes.getResourceId(index, this.k);
                    if (this.k == -1) {
                        this.k = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
                    this.l = obtainStyledAttributes.getResourceId(index, this.l);
                    if (this.l == -1) {
                        this.l = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_editor_absoluteX) {
                    this.L = obtainStyledAttributes.getDimensionPixelOffset(index, this.L);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_editor_absoluteY) {
                    this.M = obtainStyledAttributes.getDimensionPixelOffset(index, this.M);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintGuide_begin) {
                    this.a = obtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintGuide_end) {
                    this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintGuide_percent) {
                    this.c = obtainStyledAttributes.getFloat(index, this.c);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_android_orientation) {
                    this.N = obtainStyledAttributes.getInt(index, this.N);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
                    this.m = obtainStyledAttributes.getResourceId(index, this.m);
                    if (this.m == -1) {
                        this.m = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
                    this.n = obtainStyledAttributes.getResourceId(index, this.n);
                    if (this.n == -1) {
                        this.n = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
                    this.o = obtainStyledAttributes.getResourceId(index, this.o);
                    if (this.o == -1) {
                        this.o = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
                    this.p = obtainStyledAttributes.getResourceId(index, this.p);
                    if (this.p == -1) {
                        this.p = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginLeft) {
                    this.q = obtainStyledAttributes.getDimensionPixelSize(index, this.q);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginTop) {
                    this.r = obtainStyledAttributes.getDimensionPixelSize(index, this.r);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginRight) {
                    this.s = obtainStyledAttributes.getDimensionPixelSize(index, this.s);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginBottom) {
                    this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginStart) {
                    this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_goneMarginEnd) {
                    this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
                    this.w = obtainStyledAttributes.getFloat(index, this.w);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintVertical_bias) {
                    this.x = obtainStyledAttributes.getFloat(index, this.x);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
                    this.y = obtainStyledAttributes.getString(index);
                    this.z = Float.NaN;
                    this.A = -1;
                    if (this.y != null) {
                        int length = this.y.length();
                        index = this.y.indexOf(44);
                        if (index <= 0 || index >= length - 1) {
                            index = 0;
                        } else {
                            String substring = this.y.substring(0, index);
                            if (substring.equalsIgnoreCase("W")) {
                                this.A = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.A = 1;
                            }
                            index++;
                        }
                        int indexOf = this.y.indexOf(58);
                        String substring2;
                        if (indexOf < 0 || indexOf >= length - 1) {
                            substring2 = this.y.substring(index);
                            if (substring2.length() > 0) {
                                try {
                                    this.z = Float.parseFloat(substring2);
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else {
                            substring2 = this.y.substring(index, indexOf);
                            String substring3 = this.y.substring(indexOf + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.A == 1) {
                                            this.z = Math.abs(parseFloat2 / parseFloat);
                                        } else {
                                            this.z = Math.abs(parseFloat / parseFloat2);
                                        }
                                    }
                                } catch (NumberFormatException e2) {
                                }
                            }
                        }
                    }
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
                    this.B = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintVertical_weight) {
                    this.C = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
                    this.D = obtainStyledAttributes.getInt(index, 0);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
                    this.E = obtainStyledAttributes.getInt(index, 0);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintWidth_default) {
                    this.F = obtainStyledAttributes.getInt(index, 0);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHeight_default) {
                    this.G = obtainStyledAttributes.getInt(index, 0);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintWidth_min) {
                    this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintWidth_max) {
                    this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHeight_min) {
                    this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintHeight_max) {
                    this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                } else if (!(index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintLeft_creator || index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintTop_creator || index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintRight_creator || index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintBottom_creator || index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_constraintBaseline_creator)) {
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void a() {
            this.R = false;
            this.O = true;
            this.P = true;
            if (this.width == 0 || this.width == -1) {
                this.O = false;
            }
            if (this.height == 0 || this.height == -1) {
                this.P = false;
            }
            if (this.c != -1.0f || this.a != -1 || this.b != -1) {
                this.R = true;
                this.O = true;
                this.P = true;
                if (!(this.Z instanceof d)) {
                    this.Z = new d();
                }
                ((d) this.Z).m(this.N);
            }
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            Object obj = 1;
            super.resolveLayoutDirection(i);
            this.U = -1;
            this.V = -1;
            this.S = -1;
            this.T = -1;
            this.W = -1;
            this.X = -1;
            this.W = this.q;
            this.X = this.s;
            this.Y = this.w;
            if (1 != getLayoutDirection()) {
                obj = null;
            }
            if (obj != null) {
                if (this.m != -1) {
                    this.U = this.m;
                } else if (this.n != -1) {
                    this.V = this.n;
                }
                if (this.o != -1) {
                    this.T = this.o;
                }
                if (this.p != -1) {
                    this.S = this.p;
                }
                if (this.u != -1) {
                    this.X = this.u;
                }
                if (this.v != -1) {
                    this.W = this.v;
                }
                this.Y = 1.0f - this.w;
            } else {
                if (this.m != -1) {
                    this.T = this.m;
                }
                if (this.n != -1) {
                    this.S = this.n;
                }
                if (this.o != -1) {
                    this.U = this.o;
                }
                if (this.p != -1) {
                    this.V = this.p;
                }
                if (this.u != -1) {
                    this.W = this.u;
                }
                if (this.v != -1) {
                    this.X = this.v;
                }
            }
            if (this.o == -1 && this.p == -1) {
                if (this.f != -1) {
                    this.U = this.f;
                } else if (this.g != -1) {
                    this.V = this.g;
                }
            }
            if (this.n != -1 || this.m != -1) {
                return;
            }
            if (this.d != -1) {
                this.S = this.d;
            } else if (this.e != -1) {
                this.T = this.e;
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        b(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
    }

    private final b a(int i) {
        if (i == 0) {
            return this.b;
        }
        View view = (View) this.a.get(i);
        return view == this ? this.b : view == null ? null : ((a) view.getLayoutParams()).Z;
    }

    private final b a(View view) {
        return view == this ? this.b : view == null ? null : ((a) view.getLayoutParams()).Z;
    }

    private void a(int i, int i2) {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                b bVar = aVar.Z;
                if (!aVar.R) {
                    int i4 = aVar.width;
                    int i5 = aVar.height;
                    Object obj = (aVar.O || aVar.P || ((!aVar.O && aVar.F == 1) || aVar.width == -1 || (!aVar.P && (aVar.G == 1 || aVar.height == -1)))) ? 1 : null;
                    Object obj2 = null;
                    Object obj3 = null;
                    if (obj != null) {
                        Object obj4;
                        int childMeasureSpec;
                        int childMeasureSpec2;
                        if (i4 == 0 || i4 == -1) {
                            obj4 = 1;
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                        } else {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i4);
                            obj4 = null;
                        }
                        if (i5 == 0 || i5 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                            obj3 = 1;
                        } else {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        i5 = childAt.getMeasuredWidth();
                        Object obj5 = obj4;
                        i4 = childAt.getMeasuredHeight();
                        obj2 = obj5;
                    } else {
                        int i6 = i5;
                        i5 = i4;
                        i4 = i6;
                    }
                    bVar.d(i5);
                    bVar.e(i4);
                    if (obj2 != null) {
                        bVar.h(i5);
                    }
                    if (obj3 != null) {
                        bVar.i(i4);
                    }
                    if (aVar.Q) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            bVar.j(baseline);
                        }
                    }
                }
            }
        }
    }

    private void b(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        android.support.constraint.a.a.b.a aVar = android.support.constraint.a.a.b.a.FIXED;
        android.support.constraint.a.a.b.a aVar2 = android.support.constraint.a.a.b.a.FIXED;
        getLayoutParams();
        switch (mode) {
            case Integer.MIN_VALUE:
                aVar = android.support.constraint.a.a.b.a.WRAP_CONTENT;
                break;
            case 0:
                aVar = android.support.constraint.a.a.b.a.WRAP_CONTENT;
                size = 0;
                break;
            case 1073741824:
                size = Math.min(this.f, size) - paddingLeft;
                break;
            default:
                size = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                aVar2 = android.support.constraint.a.a.b.a.WRAP_CONTENT;
                break;
            case 0:
                aVar2 = android.support.constraint.a.a.b.a.WRAP_CONTENT;
                size2 = 0;
                break;
            case 1073741824:
                size2 = Math.min(this.g, size2) - paddingTop;
                break;
            default:
                size2 = 0;
                break;
        }
        this.b.f(0);
        this.b.g(0);
        this.b.a(aVar);
        this.b.d(size);
        this.b.b(aVar2);
        this.b.e(size2);
        this.b.f((this.d - getPaddingLeft()) - getPaddingRight());
        this.b.g((this.e - getPaddingTop()) - getPaddingBottom());
    }

    private void b(AttributeSet attributeSet) {
        this.b.a((Object) this);
        this.a.put(getId(), this);
        this.j = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, android.support.constraint.c.a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == android.support.constraint.c.a.ConstraintLayout_Layout_android_minWidth) {
                    this.d = obtainStyledAttributes.getDimensionPixelOffset(index, this.d);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_android_minHeight) {
                    this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_android_maxWidth) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_android_maxHeight) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.i = obtainStyledAttributes.getInt(index, this.i);
                } else if (index == android.support.constraint.c.a.ConstraintLayout_Layout_constraintSet) {
                    index = obtainStyledAttributes.getResourceId(index, 0);
                    this.j = new a();
                    this.j.a(getContext(), index);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.b.m(this.i);
    }

    private void c() {
        Object obj = null;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            this.c.clear();
            d();
        }
    }

    private void d() {
        if (this.j != null) {
            this.j.a(this);
        }
        int childCount = getChildCount();
        this.b.I();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            b a = a((View) childAt);
            if (a != null) {
                a aVar = (a) childAt.getLayoutParams();
                a.a();
                a.a(childAt.getVisibility());
                a.a(childAt);
                this.b.b(a);
                if (!(aVar.P && aVar.O)) {
                    this.c.add(a);
                }
                if (aVar.R) {
                    d dVar = (d) a;
                    if (aVar.a != -1) {
                        dVar.n(aVar.a);
                    }
                    if (aVar.b != -1) {
                        dVar.o(aVar.b);
                    }
                    if (aVar.c != -1.0f) {
                        dVar.e(aVar.c);
                    }
                } else if (aVar.S != -1 || aVar.T != -1 || aVar.U != -1 || aVar.V != -1 || aVar.h != -1 || aVar.i != -1 || aVar.j != -1 || aVar.k != -1 || aVar.l != -1 || aVar.L != -1 || aVar.M != -1 || aVar.width == -1 || aVar.height == -1) {
                    float f;
                    int i2;
                    int i3;
                    b a2;
                    View view;
                    a aVar2;
                    int i4 = aVar.S;
                    int i5 = aVar.T;
                    int i6 = aVar.U;
                    int i7 = aVar.V;
                    int i8 = aVar.W;
                    int i9 = aVar.X;
                    float f2 = aVar.Y;
                    if (VERSION.SDK_INT < 17) {
                        i4 = aVar.d;
                        i5 = aVar.e;
                        i6 = aVar.f;
                        i7 = aVar.g;
                        i8 = aVar.q;
                        i9 = aVar.s;
                        f2 = aVar.w;
                        if (i4 == -1 && i5 == -1) {
                            if (aVar.n != -1) {
                                i4 = aVar.n;
                            } else if (aVar.m != -1) {
                                i5 = aVar.m;
                            }
                        }
                        if (i6 == -1 && i7 == -1) {
                            if (aVar.o != -1) {
                                f = f2;
                                i2 = aVar.o;
                                i3 = i5;
                                i5 = i9;
                                i9 = i4;
                                i4 = i7;
                            } else if (aVar.p != -1) {
                                f = f2;
                                i2 = i6;
                                i3 = i5;
                                i5 = i9;
                                i9 = i4;
                                i4 = aVar.p;
                            }
                            if (i9 != -1) {
                                a2 = a(i9);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.LEFT, a2, android.support.constraint.a.a.a.c.LEFT, aVar.leftMargin, i8);
                                }
                            } else if (i3 != -1) {
                                a2 = a(i3);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.LEFT, a2, android.support.constraint.a.a.a.c.RIGHT, aVar.leftMargin, i8);
                                }
                            }
                            if (i2 != -1) {
                                a2 = a(i2);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.RIGHT, a2, android.support.constraint.a.a.a.c.LEFT, aVar.rightMargin, i5);
                                }
                            } else if (i4 != -1) {
                                a2 = a(i4);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.RIGHT, a2, android.support.constraint.a.a.a.c.RIGHT, aVar.rightMargin, i5);
                                }
                            }
                            if (aVar.h != -1) {
                                a2 = a(aVar.h);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.TOP, a2, android.support.constraint.a.a.a.c.TOP, aVar.topMargin, aVar.r);
                                }
                            } else if (aVar.i != -1) {
                                a2 = a(aVar.i);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.TOP, a2, android.support.constraint.a.a.a.c.BOTTOM, aVar.topMargin, aVar.r);
                                }
                            }
                            if (aVar.j != -1) {
                                a2 = a(aVar.j);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.BOTTOM, a2, android.support.constraint.a.a.a.c.TOP, aVar.bottomMargin, aVar.t);
                                }
                            } else if (aVar.k != -1) {
                                a2 = a(aVar.k);
                                if (a2 != null) {
                                    a.a(android.support.constraint.a.a.a.c.BOTTOM, a2, android.support.constraint.a.a.a.c.BOTTOM, aVar.bottomMargin, aVar.t);
                                }
                            }
                            if (aVar.l != -1) {
                                view = (View) this.a.get(aVar.l);
                                a2 = a(aVar.l);
                                if (!(a2 == null || view == null || !(view.getLayoutParams() instanceof a))) {
                                    aVar2 = (a) view.getLayoutParams();
                                    aVar.Q = true;
                                    aVar2.Q = true;
                                    a.a(android.support.constraint.a.a.a.c.BASELINE).a(a2.a(android.support.constraint.a.a.a.c.BASELINE), 0, -1, android.support.constraint.a.a.a.b.STRONG, 0, true);
                                    a.a(android.support.constraint.a.a.a.c.TOP).i();
                                    a.a(android.support.constraint.a.a.a.c.BOTTOM).i();
                                }
                            }
                            if (f >= 0.0f && f != 0.5f) {
                                a.a(f);
                            }
                            if (aVar.x >= 0.0f && aVar.x != 0.5f) {
                                a.b(aVar.x);
                            }
                            if (isInEditMode() && !(aVar.L == -1 && aVar.M == -1)) {
                                a.a(aVar.L, aVar.M);
                            }
                            if (!aVar.O) {
                                a.a(android.support.constraint.a.a.b.a.FIXED);
                                a.d(aVar.width);
                            } else if (aVar.width != -1) {
                                a.a(android.support.constraint.a.a.b.a.MATCH_PARENT);
                                a.a(android.support.constraint.a.a.a.c.LEFT).d = aVar.leftMargin;
                                a.a(android.support.constraint.a.a.a.c.RIGHT).d = aVar.rightMargin;
                            } else {
                                a.a(android.support.constraint.a.a.b.a.MATCH_CONSTRAINT);
                                a.d(0);
                            }
                            if (!aVar.P) {
                                a.b(android.support.constraint.a.a.b.a.FIXED);
                                a.e(aVar.height);
                            } else if (aVar.height != -1) {
                                a.b(android.support.constraint.a.a.b.a.MATCH_PARENT);
                                a.a(android.support.constraint.a.a.a.c.TOP).d = aVar.topMargin;
                                a.a(android.support.constraint.a.a.a.c.BOTTOM).d = aVar.bottomMargin;
                            } else {
                                a.b(android.support.constraint.a.a.b.a.MATCH_CONSTRAINT);
                                a.e(0);
                            }
                            if (aVar.y != null) {
                                a.a(aVar.y);
                            }
                            a.c(aVar.B);
                            a.d(aVar.C);
                            a.k(aVar.D);
                            a.l(aVar.E);
                            a.a(aVar.F, aVar.H, aVar.J);
                            a.b(aVar.G, aVar.I, aVar.K);
                        }
                    }
                    f = f2;
                    i2 = i6;
                    i3 = i5;
                    i5 = i9;
                    i9 = i4;
                    i4 = i7;
                    if (i9 != -1) {
                        a2 = a(i9);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.LEFT, a2, android.support.constraint.a.a.a.c.LEFT, aVar.leftMargin, i8);
                        }
                    } else if (i3 != -1) {
                        a2 = a(i3);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.LEFT, a2, android.support.constraint.a.a.a.c.RIGHT, aVar.leftMargin, i8);
                        }
                    }
                    if (i2 != -1) {
                        a2 = a(i2);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.RIGHT, a2, android.support.constraint.a.a.a.c.LEFT, aVar.rightMargin, i5);
                        }
                    } else if (i4 != -1) {
                        a2 = a(i4);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.RIGHT, a2, android.support.constraint.a.a.a.c.RIGHT, aVar.rightMargin, i5);
                        }
                    }
                    if (aVar.h != -1) {
                        a2 = a(aVar.h);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.TOP, a2, android.support.constraint.a.a.a.c.TOP, aVar.topMargin, aVar.r);
                        }
                    } else if (aVar.i != -1) {
                        a2 = a(aVar.i);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.TOP, a2, android.support.constraint.a.a.a.c.BOTTOM, aVar.topMargin, aVar.r);
                        }
                    }
                    if (aVar.j != -1) {
                        a2 = a(aVar.j);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.BOTTOM, a2, android.support.constraint.a.a.a.c.TOP, aVar.bottomMargin, aVar.t);
                        }
                    } else if (aVar.k != -1) {
                        a2 = a(aVar.k);
                        if (a2 != null) {
                            a.a(android.support.constraint.a.a.a.c.BOTTOM, a2, android.support.constraint.a.a.a.c.BOTTOM, aVar.bottomMargin, aVar.t);
                        }
                    }
                    if (aVar.l != -1) {
                        view = (View) this.a.get(aVar.l);
                        a2 = a(aVar.l);
                        aVar2 = (a) view.getLayoutParams();
                        aVar.Q = true;
                        aVar2.Q = true;
                        a.a(android.support.constraint.a.a.a.c.BASELINE).a(a2.a(android.support.constraint.a.a.a.c.BASELINE), 0, -1, android.support.constraint.a.a.a.b.STRONG, 0, true);
                        a.a(android.support.constraint.a.a.a.c.TOP).i();
                        a.a(android.support.constraint.a.a.a.c.BOTTOM).i();
                    }
                    a.a(f);
                    a.b(aVar.x);
                    a.a(aVar.L, aVar.M);
                    if (!aVar.O) {
                        a.a(android.support.constraint.a.a.b.a.FIXED);
                        a.d(aVar.width);
                    } else if (aVar.width != -1) {
                        a.a(android.support.constraint.a.a.b.a.MATCH_CONSTRAINT);
                        a.d(0);
                    } else {
                        a.a(android.support.constraint.a.a.b.a.MATCH_PARENT);
                        a.a(android.support.constraint.a.a.a.c.LEFT).d = aVar.leftMargin;
                        a.a(android.support.constraint.a.a.a.c.RIGHT).d = aVar.rightMargin;
                    }
                    if (!aVar.P) {
                        a.b(android.support.constraint.a.a.b.a.FIXED);
                        a.e(aVar.height);
                    } else if (aVar.height != -1) {
                        a.b(android.support.constraint.a.a.b.a.MATCH_CONSTRAINT);
                        a.e(0);
                    } else {
                        a.b(android.support.constraint.a.a.b.a.MATCH_PARENT);
                        a.a(android.support.constraint.a.a.a.c.TOP).d = aVar.topMargin;
                        a.a(android.support.constraint.a.a.a.c.BOTTOM).d = aVar.bottomMargin;
                    }
                    if (aVar.y != null) {
                        a.a(aVar.y);
                    }
                    a.c(aVar.B);
                    a.d(aVar.C);
                    a.k(aVar.D);
                    a.l(aVar.E);
                    a.a(aVar.F, aVar.H, aVar.J);
                    a.b(aVar.G, aVar.I, aVar.K);
                }
            }
        }
    }

    public a a(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected void a() {
        this.b.F();
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    protected a b() {
        return new a(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.g;
    }

    public int getMaxWidth() {
        return this.f;
    }

    public int getMinHeight() {
        return this.e;
    }

    public int getMinWidth() {
        return this.d;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || aVar.R || isInEditMode) {
                b bVar = aVar.Z;
                int n = bVar.n();
                int o = bVar.o();
                childAt.layout(n, o, bVar.h() + n, bVar.l() + o);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.b.b(paddingLeft);
        this.b.c(paddingTop);
        b(i, i2);
        if (this.h) {
            this.h = false;
            c();
        }
        a(i, i2);
        if (getChildCount() > 0) {
            a();
        }
        int i3 = 0;
        int size = this.c.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size > 0) {
            Object obj = null;
            Object obj2 = this.b.B() == android.support.constraint.a.a.b.a.WRAP_CONTENT ? 1 : null;
            Object obj3 = this.b.C() == android.support.constraint.a.a.b.a.WRAP_CONTENT ? 1 : null;
            int i4 = 0;
            while (i4 < size) {
                b bVar = (b) this.c.get(i4);
                if (bVar instanceof d) {
                    paddingLeft = i3;
                } else {
                    View view = (View) bVar.x();
                    if (view == null) {
                        paddingLeft = i3;
                    } else if (view.getVisibility() == 8) {
                        paddingLeft = i3;
                    } else {
                        Object obj4;
                        a aVar = (a) view.getLayoutParams();
                        view.measure(aVar.width == -2 ? getChildMeasureSpec(i, paddingRight, aVar.width) : MeasureSpec.makeMeasureSpec(bVar.h(), 1073741824), aVar.height == -2 ? getChildMeasureSpec(i2, paddingBottom, aVar.height) : MeasureSpec.makeMeasureSpec(bVar.l(), 1073741824));
                        int measuredWidth = view.getMeasuredWidth();
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredWidth != bVar.h()) {
                            bVar.d(measuredWidth);
                            if (obj2 != null && bVar.t() > this.b.h()) {
                                this.b.d(Math.max(this.d, bVar.t() + bVar.a(android.support.constraint.a.a.a.c.RIGHT).d()));
                            }
                            obj4 = 1;
                        } else {
                            obj4 = obj;
                        }
                        if (measuredHeight != bVar.l()) {
                            bVar.e(measuredHeight);
                            if (obj3 != null && bVar.u() > this.b.l()) {
                                this.b.e(Math.max(this.e, bVar.u() + bVar.a(android.support.constraint.a.a.a.c.BOTTOM).d()));
                            }
                            obj4 = 1;
                        }
                        if (aVar.Q) {
                            int baseline = view.getBaseline();
                            if (!(baseline == -1 || baseline == bVar.w())) {
                                bVar.j(baseline);
                                obj4 = 1;
                            }
                        }
                        if (VERSION.SDK_INT >= 11) {
                            paddingLeft = combineMeasuredStates(i3, view.getMeasuredState());
                            obj = obj4;
                        } else {
                            obj = obj4;
                            paddingLeft = i3;
                        }
                    }
                }
                i4++;
                i3 = paddingLeft;
            }
            if (obj != null) {
                a();
            }
        }
        paddingLeft = this.b.h() + paddingRight;
        paddingTop = this.b.l() + paddingBottom;
        if (VERSION.SDK_INT >= 11) {
            paddingLeft = Math.min(this.f, resolveSizeAndState(paddingLeft, i, i3)) & 16777215;
            paddingTop = Math.min(this.g, resolveSizeAndState(paddingTop, i2, i3 << 16)) & 16777215;
            if (this.b.D()) {
                paddingLeft |= 16777216;
            }
            if (this.b.E()) {
                paddingTop |= 16777216;
            }
            setMeasuredDimension(paddingLeft, paddingTop);
            return;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        b a = a(view);
        if ((view instanceof b) && !(a instanceof d)) {
            a aVar = (a) view.getLayoutParams();
            aVar.Z = new d();
            aVar.R = true;
            ((d) aVar.Z).m(aVar.N);
            a = aVar.Z;
        }
        this.a.put(view.getId(), view);
        this.h = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.a.remove(view.getId());
        this.b.c(a(view));
        this.h = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.h = true;
    }

    public void setConstraintSet(a aVar) {
        this.j = aVar;
    }

    public void setId(int i) {
        this.a.remove(getId());
        super.setId(i);
        this.a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.g) {
            this.g = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.f) {
            this.f = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.e) {
            this.e = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.d) {
            this.d = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.b.m(i);
    }
}
