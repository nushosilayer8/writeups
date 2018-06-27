package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.d.a.b;
import android.support.v4.g.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class c<T> extends d<T> {
    final Context a;
    private Map<b, MenuItem> c;
    private Map<android.support.v4.d.a.c, SubMenu> d;

    c(Context context, T t) {
        super(t);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.c == null) {
            this.c = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = q.a(this.a, bVar);
        this.c.put(bVar, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.d.a.c)) {
            return subMenu;
        }
        android.support.v4.d.a.c cVar = (android.support.v4.d.a.c) subMenu;
        if (this.d == null) {
            this.d = new a();
        }
        SubMenu subMenu2 = (SubMenu) this.d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = q.a(this.a, cVar);
        this.d.put(cVar, subMenu2);
        return subMenu2;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    final void a(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void b(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
