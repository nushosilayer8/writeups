package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class e extends b implements a {
    private Context a;
    private ActionBarContextView b;
    private b.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private h g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = aVar;
        this.g = new h(actionBarContextView.getContext()).a(1);
        this.g.a((a) this);
        this.f = z;
    }

    public MenuInflater a() {
        return new g(this.b.getContext());
    }

    public void a(int i) {
        b(this.a.getString(i));
    }

    public void a(h hVar) {
        d();
        this.b.a();
    }

    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference(view) : null;
    }

    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    public boolean a(h hVar, MenuItem menuItem) {
        return this.c.a((b) this, menuItem);
    }

    public Menu b() {
        return this.g;
    }

    public void b(int i) {
        a(this.a.getString(i));
    }

    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    public void c() {
        if (!this.e) {
            this.e = true;
            this.b.sendAccessibilityEvent(32);
            this.c.a(this);
        }
    }

    public void d() {
        this.c.b(this, this.g);
    }

    public CharSequence f() {
        return this.b.getTitle();
    }

    public CharSequence g() {
        return this.b.getSubtitle();
    }

    public boolean h() {
        return this.b.d();
    }

    public View i() {
        return this.d != null ? (View) this.d.get() : null;
    }
}
