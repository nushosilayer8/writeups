package android.support.v7.view;

import android.content.Context;
import android.support.v4.d.a.b;
import android.support.v4.g.k;
import android.support.v7.view.menu.q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class f extends ActionMode {
    final Context a;
    final b b;

    public static class a implements android.support.v7.view.b.a {
        final Callback a;
        final Context b;
        final ArrayList<f> c = new ArrayList();
        final k<Menu, Menu> d = new k();

        public a(Context context, Callback callback) {
            this.b = context;
            this.a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = q.a(this.b, (android.support.v4.d.a.a) menu);
            this.d.put(menu, menu2);
            return menu2;
        }

        public void a(b bVar) {
            this.a.onDestroyActionMode(b(bVar));
        }

        public boolean a(b bVar, Menu menu) {
            return this.a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(b(bVar), q.a(this.b, (b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.c.get(i);
                if (fVar != null && fVar.b == bVar) {
                    return fVar;
                }
            }
            ActionMode fVar2 = new f(this.b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }

        public boolean b(b bVar, Menu menu) {
            return this.a.onPrepareActionMode(b(bVar), a(menu));
        }
    }

    public f(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.i();
    }

    public Menu getMenu() {
        return q.a(this.a, (android.support.v4.d.a.a) this.b.b());
    }

    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.j();
    }

    public CharSequence getTitle() {
        return this.b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    public void invalidate() {
        this.b.d();
    }

    public boolean isTitleOptional() {
        return this.b.h();
    }

    public void setCustomView(View view) {
        this.b.a(view);
    }

    public void setSubtitle(int i) {
        this.b.b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.b.a(obj);
    }

    public void setTitle(int i) {
        this.b.a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }
}
