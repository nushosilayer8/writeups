package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.h.p;
import android.support.v7.a.a.d;
import android.support.v7.a.a.g;
import android.support.v7.widget.al;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class e extends m implements o, OnKeyListener, OnDismissListener {
    final Handler a;
    final List<a> b = new ArrayList();
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final List<h> j = new LinkedList();
    private final OnGlobalLayoutListener k = new OnGlobalLayoutListener(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void onGlobalLayout() {
            if (this.a.d() && this.a.b.size() > 0 && !((a) this.a.b.get(0)).a.g()) {
                View view = this.a.c;
                if (view == null || !view.isShown()) {
                    this.a.c();
                    return;
                }
                for (a aVar : this.a.b) {
                    aVar.a.a();
                }
            }
        }
    };
    private final OnAttachStateChangeListener l = new OnAttachStateChangeListener(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.a.y != null) {
                if (!this.a.y.isAlive()) {
                    this.a.y = view.getViewTreeObserver();
                }
                this.a.y.removeGlobalOnLayoutListener(this.a.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final al m = new al(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void a(h hVar, MenuItem menuItem) {
            this.a.a.removeCallbacksAndMessages(hVar);
        }

        public void b(final h hVar, final MenuItem menuItem) {
            int i;
            this.a.a.removeCallbacksAndMessages(null);
            int size = this.a.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (hVar == ((a) this.a.b.get(i2)).b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i++;
                final a aVar = i < this.a.b.size() ? (a) this.a.b.get(i) : null;
                this.a.a.postAtTime(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 d;

                    public void run() {
                        if (aVar != null) {
                            this.d.a.d = true;
                            aVar.b.a(false);
                            this.d.a.d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int n = 0;
    private int o = 0;
    private View p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private android.support.v7.view.menu.o.a x;
    private ViewTreeObserver y;
    private OnDismissListener z;

    private static class a {
        public final am a;
        public final h b;
        public final int c;

        public a(am amVar, h hVar, int i) {
            this.a = amVar;
            this.b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.e = context;
        this.p = view;
        this.g = i;
        this.h = i2;
        this.i = z;
        this.v = false;
        this.q = i();
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        int i = 0;
        MenuItem a = a(aVar.b, hVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        g gVar;
        int i2;
        ListView a2 = aVar.a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (i < count) {
            if (a == gVar.a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= a2.getChildCount()) ? null : a2.getChildAt(i2);
    }

    private void c(h hVar) {
        View a;
        a aVar;
        LayoutInflater from = LayoutInflater.from(this.e);
        Object gVar = new g(hVar, from, this.i);
        if (!d() && this.v) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int a2 = m.a(gVar, null, this.e, this.f);
        am h = h();
        h.a((ListAdapter) gVar);
        h.g(a2);
        h.e(this.o);
        if (this.b.size() > 0) {
            a aVar2 = (a) this.b.get(this.b.size() - 1);
            a = a(aVar2, hVar);
            aVar = aVar2;
        } else {
            a = null;
            Object aVar3 = null;
        }
        if (a != null) {
            int i;
            h.c(false);
            h.a(null);
            int d = d(a2);
            boolean z = d == 1;
            this.q = d;
            if (VERSION.SDK_INT >= 26) {
                h.b(a);
                d = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                i = iArr2[0] - iArr[0];
                d = iArr2[1] - iArr[1];
            }
            int width = (this.o & 5) == 5 ? z ? i + a2 : i - a.getWidth() : z ? a.getWidth() + i : i - a2;
            h.c(width);
            h.b(true);
            h.d(d);
        } else {
            if (this.r) {
                h.c(this.t);
            }
            if (this.s) {
                h.d(this.u);
            }
            h.a(g());
        }
        this.b.add(new a(h, hVar, this.q));
        h.a();
        ViewGroup e = h.e();
        e.setOnKeyListener(this);
        if (aVar3 == null && this.w && hVar.m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(hVar.m());
            e.addHeaderView(frameLayout, null, false);
            h.a();
        }
    }

    private int d(int i) {
        ListView a = ((a) this.b.get(this.b.size() - 1)).a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        if (this.q != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        } else {
            return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
    }

    private int d(h hVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (hVar == ((a) this.b.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    private am h() {
        am amVar = new am(this.e, null, this.g, this.h);
        amVar.a(this.m);
        amVar.a((OnItemClickListener) this);
        amVar.a((OnDismissListener) this);
        amVar.b(this.p);
        amVar.e(this.o);
        amVar.a(true);
        amVar.h(2);
        return amVar;
    }

    private int i() {
        return p.b(this.p) == 1 ? 0 : 1;
    }

    public void a() {
        if (!d()) {
            for (h c : this.j) {
                c(c);
            }
            this.j.clear();
            this.c = this.p;
            if (this.c != null) {
                Object obj = this.y == null ? 1 : null;
                this.y = this.c.getViewTreeObserver();
                if (obj != null) {
                    this.y.addOnGlobalLayoutListener(this.k);
                }
                this.c.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = android.support.v4.h.d.a(i, p.b(this.p));
        }
    }

    public void a(h hVar) {
        hVar.a((o) this, this.e);
        if (d()) {
            c(hVar);
        } else {
            this.j.add(hVar);
        }
    }

    public void a(h hVar, boolean z) {
        int d = d(hVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.b.size()) {
                ((a) this.b.get(i)).b.a(false);
            }
            a aVar = (a) this.b.remove(d);
            aVar.b.b((o) this);
            if (this.d) {
                aVar.a.b(null);
                aVar.a.b(0);
            }
            aVar.a.c();
            d = this.b.size();
            if (d > 0) {
                this.q = ((a) this.b.get(d - 1)).c;
            } else {
                this.q = i();
            }
            if (d == 0) {
                c();
                if (this.x != null) {
                    this.x.a(hVar, true);
                }
                if (this.y != null) {
                    if (this.y.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.k);
                    }
                    this.y = null;
                }
                this.c.removeOnAttachStateChangeListener(this.l);
                this.z.onDismiss();
            } else if (z) {
                ((a) this.b.get(0)).b.a(false);
            }
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar) {
        this.x = aVar;
    }

    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = android.support.v4.h.d.a(this.n, p.b(this.p));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public boolean a(u uVar) {
        for (a aVar : this.b) {
            if (uVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        a((h) uVar);
        if (this.x != null) {
            this.x.a(uVar);
        }
        return true;
    }

    public void b(int i) {
        this.r = true;
        this.t = i;
    }

    public void b(boolean z) {
        for (a a : this.b) {
            m.a(a.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (size--; size >= 0; size--) {
                a aVar = aVarArr[size];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    public void c(int i) {
        this.s = true;
        this.u = i;
    }

    public void c(boolean z) {
        this.w = z;
    }

    public boolean d() {
        return this.b.size() > 0 && ((a) this.b.get(0)).a.d();
    }

    public ListView e() {
        return this.b.isEmpty() ? null : ((a) this.b.get(this.b.size() - 1)).a();
    }

    protected boolean f() {
        return false;
    }

    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.b.get(i);
            if (!aVar.a.d()) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            aVar.b.a(false);
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
