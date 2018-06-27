package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.a.a.g;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f implements o, OnItemClickListener {
    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private android.support.v7.view.menu.o.a i;

    private class a extends BaseAdapter {
        final /* synthetic */ f a;
        private int b = -1;

        public a(f fVar) {
            this.a = fVar;
            a();
        }

        public j a(int i) {
            ArrayList l = this.a.c.l();
            int i2 = this.a.e + i;
            if (this.b >= 0 && i2 >= this.b) {
                i2++;
            }
            return (j) l.get(i2);
        }

        void a() {
            j r = this.a.c.r();
            if (r != null) {
                ArrayList l = this.a.c.l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((j) l.get(i)) == r) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        public int getCount() {
            int size = this.a.c.l().size() - this.a.e;
            return this.b < 0 ? size : size - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.a.b.inflate(this.a.g, viewGroup, false) : view;
            ((android.support.v7.view.menu.p.a) inflate).a(a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a(this);
            }
            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a(this);
        }
        return this.h;
    }

    public void a(Context context, h hVar) {
        if (this.f != 0) {
            this.a = new ContextThemeWrapper(context, this.f);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = hVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public void a(h hVar, boolean z) {
        if (this.i != null) {
            this.i.a(hVar, z);
        }
    }

    public void a(android.support.v7.view.menu.o.a aVar) {
        this.i = aVar;
    }

    public boolean a(h hVar, j jVar) {
        return false;
    }

    public boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new i(uVar).a(null);
        if (this.i != null) {
            this.i.a(uVar);
        }
        return true;
    }

    public void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public boolean b() {
        return false;
    }

    public boolean b(h hVar, j jVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.a(i), (o) this, 0);
    }
}
