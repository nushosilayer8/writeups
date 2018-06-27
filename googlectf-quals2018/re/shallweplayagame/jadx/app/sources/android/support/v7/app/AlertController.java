package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.h.p;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
    private boolean A = false;
    private CharSequence B;
    private CharSequence C;
    private CharSequence D;
    private int E = 0;
    private Drawable F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private View J;
    private int K;
    private int L;
    private boolean M;
    private int N = 0;
    private final OnClickListener O = new OnClickListener(this) {
        final /* synthetic */ AlertController a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            Message obtain = (view != this.a.c || this.a.d == null) ? (view != this.a.e || this.a.f == null) ? (view != this.a.g || this.a.h == null) ? null : Message.obtain(this.a.h) : Message.obtain(this.a.f) : Message.obtain(this.a.d);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.a.p.obtainMessage(1, this.a.a).sendToTarget();
        }
    };
    final l a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k = -1;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private CharSequence s;
    private CharSequence t;
    private View u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public static class RecycleListView extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
            }
        }
    }

    public static class a {
        public int A;
        public boolean B = false;
        public boolean[] C;
        public boolean D;
        public boolean E;
        public int F = -1;
        public OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public OnItemSelectedListener K;
        public a L;
        public boolean M = true;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public CharSequence k;
        public DialogInterface.OnClickListener l;
        public CharSequence m;
        public DialogInterface.OnClickListener n;
        public boolean o;
        public OnCancelListener p;
        public OnDismissListener q;
        public OnKeyListener r;
        public CharSequence[] s;
        public ListAdapter t;
        public DialogInterface.OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        public interface a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.a = context;
            this.o = true;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.b.inflate(alertController.l, null);
            if (!this.D) {
                int i = this.E ? alertController.n : alertController.o;
                simpleCursorAdapter = this.H != null ? new SimpleCursorAdapter(this.a, i, this.H, new String[]{this.I}, new int[]{16908308}) : this.t != null ? this.t : new c(this.a, i, 16908308, this.s);
            } else if (this.H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.a, alertController.m, 16908308, this.s) {
                    final /* synthetic */ a b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.b.C != null && this.b.C[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final AlertController alertController2 = alertController;
                Object simpleCursorAdapter2 = new CursorAdapter(this, this.a, this.H, false) {
                    final /* synthetic */ a c;
                    private final int d;
                    private final int e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.d));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.c.b.inflate(alertController2.m, viewGroup, false);
                    }
                };
            }
            if (this.L != null) {
                this.L.a(recycleListView);
            }
            alertController.j = simpleCursorAdapter2;
            alertController.k = this.F;
            if (this.u != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.b.u.onClick(alertController.a, i);
                        if (!this.b.E) {
                            alertController.a.dismiss();
                        }
                    }
                });
            } else if (this.G != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.c.C != null) {
                            this.c.C[i] = recycleListView.isItemChecked(i);
                        }
                        this.c.G.onClick(alertController.a, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            if (this.K != null) {
                recycleListView.setOnItemSelectedListener(this.K);
            }
            if (this.E) {
                recycleListView.setChoiceMode(1);
            } else if (this.D) {
                recycleListView.setChoiceMode(2);
            }
            alertController.b = recycleListView;
        }

        public void a(AlertController alertController) {
            if (this.g != null) {
                alertController.b(this.g);
            } else {
                if (this.f != null) {
                    alertController.a(this.f);
                }
                if (this.d != null) {
                    alertController.a(this.d);
                }
                if (this.c != 0) {
                    alertController.b(this.c);
                }
                if (this.e != 0) {
                    alertController.b(alertController.c(this.e));
                }
            }
            if (this.h != null) {
                alertController.b(this.h);
            }
            if (this.i != null) {
                alertController.a(-1, this.i, this.j, null);
            }
            if (this.k != null) {
                alertController.a(-2, this.k, this.l, null);
            }
            if (this.m != null) {
                alertController.a(-3, this.m, this.n, null);
            }
            if (!(this.s == null && this.H == null && this.t == null)) {
                b(alertController);
            }
            if (this.w != null) {
                if (this.B) {
                    alertController.a(this.w, this.x, this.y, this.z, this.A);
                    return;
                }
                alertController.c(this.w);
            } else if (this.v != 0) {
                alertController.a(this.v);
            }
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, l lVar, Window window) {
        this.q = context;
        this.a = lVar;
        this.r = window;
        this.p = new b(lVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.M = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        obtainStyledAttributes.recycle();
        lVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    static void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.u != null ? this.u : this.v != 0 ? LayoutInflater.from(this.q).inflate(this.v, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && a(inflate))) {
            this.r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.A) {
                frameLayout.setPadding(this.w, this.x, this.y, this.z);
            }
            if (this.b != null) {
                ((android.support.v7.widget.ai.a) viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.r.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            p.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.t != null) {
                this.i.setOnScrollChangeListener(new android.support.v4.widget.NestedScrollView.b(this) {
                    final /* synthetic */ AlertController c;

                    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.a(nestedScrollView, findViewById, view2);
                    }
                });
                this.i.post(new Runnable(this) {
                    final /* synthetic */ AlertController c;

                    public void run() {
                        AlertController.a(this.c.i, findViewById, view2);
                    }
                });
            } else if (this.b != null) {
                this.b.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ AlertController c;

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.a(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.b.post(new Runnable(this) {
                    final /* synthetic */ AlertController c;

                    public void run() {
                        AlertController.a(this.c.b, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        return this.L == 0 ? this.K : this.N == 1 ? this.L : this.K;
    }

    private void b(ViewGroup viewGroup) {
        if (this.J != null) {
            viewGroup.addView(this.J, 0, new LayoutParams(-1, -2));
            this.r.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.G = (ImageView) this.r.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.s) ? 1 : 0) == 0 || !this.M) {
            this.r.findViewById(f.title_template).setVisibility(8);
            this.G.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.H = (TextView) this.r.findViewById(f.alertTitle);
        this.H.setText(this.s);
        if (this.E != 0) {
            this.G.setImageResource(this.E);
        } else if (this.F != null) {
            this.G.setImageDrawable(this.F);
        } else {
            this.H.setPadding(this.G.getPaddingLeft(), this.G.getPaddingTop(), this.G.getPaddingRight(), this.G.getPaddingBottom());
            this.G.setVisibility(8);
        }
    }

    private void c() {
        View findViewById = this.r.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        a(viewGroup);
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        View findViewById6 = viewGroup.findViewById(f.contentPanel);
        View findViewById7 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup a = a(findViewById5, findViewById2);
        ViewGroup a2 = a(findViewById6, findViewById3);
        ViewGroup a3 = a(findViewById7, findViewById4);
        c(a2);
        d(a3);
        b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById = a2.findViewById(f.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (z2) {
            if (this.i != null) {
                this.i.setClipToPadding(true);
            }
            findViewById = null;
            if (!(this.t == null && this.b == null)) {
                findViewById = a.findViewById(f.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById = a2.findViewById(f.textSpacerNoTitle);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (this.b instanceof RecycleListView) {
            ((RecycleListView) this.b).a(z2, z3);
        }
        if (!z) {
            findViewById3 = this.b != null ? this.b : this.i;
            if (findViewById3 != null) {
                a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.b;
        if (listView != null && this.j != null) {
            listView.setAdapter(this.j);
            int i = this.k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.I = (TextView) viewGroup.findViewById(16908299);
        if (this.I != null) {
            if (this.t != null) {
                this.I.setText(this.t);
                return;
            }
            this.I.setVisibility(8);
            this.i.removeView(this.I);
            if (this.b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.b, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.c = (Button) viewGroup.findViewById(16908313);
        this.c.setOnClickListener(this.O);
        if (TextUtils.isEmpty(this.B)) {
            this.c.setVisibility(8);
            i = 0;
        } else {
            this.c.setText(this.B);
            this.c.setVisibility(0);
            i = 1;
        }
        this.e = (Button) viewGroup.findViewById(16908314);
        this.e.setOnClickListener(this.O);
        if (TextUtils.isEmpty(this.C)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(this.C);
            this.e.setVisibility(0);
            i |= 2;
        }
        this.g = (Button) viewGroup.findViewById(16908315);
        this.g.setOnClickListener(this.O);
        if (TextUtils.isEmpty(this.D)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.D);
            this.g.setVisibility(0);
            i |= 4;
        }
        if (a(this.q)) {
            if (i == 1) {
                a(this.c);
            } else if (i == 2) {
                a(this.e);
            } else if (i == 4) {
                a(this.g);
            }
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        this.a.setContentView(b());
        c();
    }

    public void a(int i) {
        this.u = null;
        this.v = i;
        this.A = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.D = charSequence;
                this.h = message;
                return;
            case -2:
                this.C = charSequence;
                this.f = message;
                return;
            case -1:
                this.B = charSequence;
                this.d = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.F = drawable;
        this.E = 0;
        if (this.G == null) {
            return;
        }
        if (drawable != null) {
            this.G.setVisibility(0);
            this.G.setImageDrawable(drawable);
            return;
        }
        this.G.setVisibility(8);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.u = view;
        this.v = 0;
        this.A = true;
        this.w = i;
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    public void a(CharSequence charSequence) {
        this.s = charSequence;
        if (this.H != null) {
            this.H.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public void b(int i) {
        this.F = null;
        this.E = i;
        if (this.G == null) {
            return;
        }
        if (i != 0) {
            this.G.setVisibility(0);
            this.G.setImageResource(this.E);
            return;
        }
        this.G.setVisibility(8);
    }

    public void b(View view) {
        this.J = view;
    }

    public void b(CharSequence charSequence) {
        this.t = charSequence;
        if (this.I != null) {
            this.I.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.u = view;
        this.v = 0;
        this.A = false;
    }
}
