package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.h.p;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ad;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window.Callback;
import java.util.ArrayList;

class o extends a {
    ad a;
    Callback b;
    private boolean c;
    private boolean d;
    private ArrayList<android.support.v7.app.a.b> e;
    private final Runnable f;

    private final class a implements android.support.v7.view.menu.o.a {
        final /* synthetic */ o a;
        private boolean b;

        a(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar, boolean z) {
            if (!this.b) {
                this.b = true;
                this.a.a.n();
                if (this.a.b != null) {
                    this.a.b.onPanelClosed(j.AppCompatTheme_tooltipFrameBackground, hVar);
                }
                this.b = false;
            }
        }

        public boolean a(h hVar) {
            if (this.a.b == null) {
                return false;
            }
            this.a.b.onMenuOpened(j.AppCompatTheme_tooltipFrameBackground, hVar);
            return true;
        }
    }

    private final class b implements android.support.v7.view.menu.h.a {
        final /* synthetic */ o a;

        b(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar) {
            if (this.a.b == null) {
                return;
            }
            if (this.a.a.i()) {
                this.a.b.onPanelClosed(j.AppCompatTheme_tooltipFrameBackground, hVar);
            } else if (this.a.b.onPreparePanel(0, null, hVar)) {
                this.a.b.onMenuOpened(j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private Menu h() {
        if (!this.c) {
            this.a.a(new a(this), new b(this));
            this.c = true;
        }
        return this.a.q();
    }

    public int a() {
        return this.a.o();
    }

    public void a(float f) {
        p.a(this.a.a(), f);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(boolean z) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu h = h();
        if (h == null) {
            return false;
        }
        h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return h.performShortcut(i, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public Context b() {
        return this.a.b();
    }

    public void c(boolean z) {
    }

    public boolean c() {
        return this.a.k();
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return this.a.l();
    }

    public void e(boolean z) {
        if (z != this.d) {
            this.d = z;
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                ((android.support.v7.app.a.b) this.e.get(i)).a(z);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.f);
        p.a(this.a.a(), this.f);
        return true;
    }

    public boolean f() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    void g() {
        this.a.a().removeCallbacks(this.f);
    }
}
