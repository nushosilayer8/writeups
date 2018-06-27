package android.support.v7.view.menu;

import android.support.v7.view.menu.p.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g extends BaseAdapter {
    static final int a = android.support.v7.a.a.g.abc_popup_menu_item_layout;
    h b;
    private int c = -1;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    public g(h hVar, LayoutInflater layoutInflater, boolean z) {
        this.e = z;
        this.f = layoutInflater;
        this.b = hVar;
        b();
    }

    public h a() {
        return this.b;
    }

    public j a(int i) {
        ArrayList l = this.e ? this.b.l() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (j) l.get(i);
    }

    public void a(boolean z) {
        this.d = z;
    }

    void b() {
        j r = this.b.r();
        if (r != null) {
            ArrayList l = this.b.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((j) l.get(i)) == r) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public int getCount() {
        ArrayList l = this.e ? this.b.l() : this.b.i();
        return this.c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f.inflate(a, viewGroup, false) : view;
        a aVar = (a) inflate;
        if (this.d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aVar.a(a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
