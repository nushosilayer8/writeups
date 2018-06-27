package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.h.p;
import android.support.v4.widget.i;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class aj implements s {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private OnItemClickListener B;
    private OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    af c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    private class a implements Runnable {
        final /* synthetic */ aj a;

        a(aj ajVar) {
            this.a = ajVar;
        }

        public void run() {
            this.a.m();
        }
    }

    private class b extends DataSetObserver {
        final /* synthetic */ aj a;

        b(aj ajVar) {
            this.a = ajVar;
        }

        public void onChanged() {
            if (this.a.d()) {
                this.a.a();
            }
        }

        public void onInvalidated() {
            this.a.c();
        }
    }

    private class c implements OnScrollListener {
        final /* synthetic */ aj a;

        c(aj ajVar) {
            this.a = ajVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.a.n() && this.a.g.getContentView() != null) {
                this.a.f.removeCallbacks(this.a.e);
                this.a.e.run();
            }
        }
    }

    private class d implements OnTouchListener {
        final /* synthetic */ aj a;

        d(aj ajVar) {
            this.a = ajVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.a.g != null && this.a.g.isShowing() && x >= 0 && x < this.a.g.getWidth() && y >= 0 && y < this.a.g.getHeight()) {
                this.a.f.postDelayed(this.a.e, 250);
            } else if (action == 1) {
                this.a.f.removeCallbacks(this.a.e);
            }
            return false;
        }
    }

    private class e implements Runnable {
        final /* synthetic */ aj a;

        e(aj ajVar) {
            this.a = ajVar;
        }

        public void run() {
            if (this.a.c != null && p.m(this.a.c) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
                this.a.g.setInputMethodMode(2);
                this.a.a();
            }
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public aj(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e(this);
        this.D = new d(this);
        this.E = new c(this);
        this.F = new a(this);
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new r(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int f() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable(this) {
                final /* synthetic */ aj a;

                {
                    this.a = r1;
                }

                public void run() {
                    View i = this.a.i();
                    if (i != null && i.getWindowToken() != null) {
                        this.a.a();
                    }
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ aj a;

                {
                    this.a = r1;
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        af afVar = this.a.c;
                        if (afVar != null) {
                            afVar.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            View view2 = this.c;
            View view3 = this.w;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i = this.l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.g.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            view = this.w;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (this.p) {
                i4 = i2;
            } else {
                this.n = -this.H.top;
                i4 = i2;
            }
        } else {
            this.H.setEmpty();
            i4 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z = false;
        }
        i = a(i(), this.n, z);
        if (this.u || this.k == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.l, 1073741824);
                break;
        }
        i2 = this.c.a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.c.getPaddingTop() + this.c.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    af a(Context context, boolean z) {
        return new af(context, z);
    }

    public void a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int f = f();
        boolean n = n();
        i.a(this.g, this.o);
        PopupWindow popupWindow;
        if (!this.g.isShowing()) {
            int width = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                f = -1;
            } else if (this.k != -2) {
                f = this.k;
            }
            this.g.setWidth(width);
            this.g.setHeight(f);
            c(true);
            popupWindow = this.g;
            if (this.v || this.u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.g.setTouchInterceptor(this.D);
            if (this.s) {
                i.a(this.g, this.r);
            }
            if (h != null) {
                try {
                    h.invoke(this.g, new Object[]{this.I});
                } catch (Throwable e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            i.a(this.g, i(), this.m, this.n, this.t);
            this.c.setSelection(-1);
            if (!this.J || this.c.isInTouchMode()) {
                m();
            }
            if (!this.J) {
                this.f.post(this.F);
            }
        } else if (p.m(i())) {
            int i2;
            int width2 = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                    i2 = f;
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                    i2 = f;
                }
            } else {
                i2 = this.k == -2 ? f : this.k;
            }
            popupWindow = this.g;
            if (!(this.v || this.u)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.g;
            View i3 = i();
            f = this.m;
            int i4 = this.n;
            if (width2 < 0) {
                width2 = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(i3, f, i4, width2, i);
        }
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b(this);
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (this.j != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    public boolean d() {
        return this.g.isShowing();
    }

    public ListView e() {
        return this.c;
    }

    public void e(int i) {
        this.t = i;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = (this.H.left + this.H.right) + i;
            return;
        }
        f(i);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public View i() {
        return this.z;
    }

    public void i(int i) {
        af afVar = this.c;
        if (d() && afVar != null) {
            afVar.setListSelectionHidden(false);
            afVar.setSelection(i);
            if (afVar.getChoiceMode() != 0) {
                afVar.setItemChecked(i, true);
            }
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        return !this.p ? 0 : this.n;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        af afVar = this.c;
        if (afVar != null) {
            afVar.setListSelectionHidden(true);
            afVar.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }
}
