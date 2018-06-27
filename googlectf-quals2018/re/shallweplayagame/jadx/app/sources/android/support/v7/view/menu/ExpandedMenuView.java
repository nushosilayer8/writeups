package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.h.b;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, p, OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private h b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        aw a = aw.a(context, attributeSet, a, i, 0);
        if (a.g(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.g(1)) {
            setDivider(a.a(1));
        }
        a.a();
    }

    public void a(h hVar) {
        this.b = hVar;
    }

    public boolean a(j jVar) {
        return this.b.a((MenuItem) jVar, 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((j) getAdapter().getItem(i));
    }
}
