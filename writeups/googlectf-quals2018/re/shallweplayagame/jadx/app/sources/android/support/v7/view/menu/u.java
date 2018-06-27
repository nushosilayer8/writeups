package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.h.a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u extends h implements SubMenu {
    private h d;
    private j e;

    public u(Context context, h hVar, j jVar) {
        super(context);
        this.d = hVar;
        this.e = jVar;
    }

    public String a() {
        int itemId = this.e != null ? this.e.getItemId() : 0;
        return itemId == 0 ? null : super.a() + ":" + itemId;
    }

    public void a(a aVar) {
        this.d.a(aVar);
    }

    boolean a(h hVar, MenuItem menuItem) {
        return super.a(hVar, menuItem) || this.d.a(hVar, menuItem);
    }

    public boolean b() {
        return this.d.b();
    }

    public boolean c() {
        return this.d.c();
    }

    public boolean c(j jVar) {
        return this.d.c(jVar);
    }

    public boolean d(j jVar) {
        return this.d.d(jVar);
    }

    public MenuItem getItem() {
        return this.e;
    }

    public h p() {
        return this.d.p();
    }

    public Menu s() {
        return this.d;
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.e(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }
}
