package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class i extends h {
    private int t = -100;
    private boolean u;
    private boolean v = true;
    private b w;

    class a extends a {
        final /* synthetic */ i c;

        a(i iVar, Callback callback) {
            this.c = iVar;
            super(iVar, callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(this.c.a, callback);
            android.support.v7.view.b b = this.c.b((android.support.v7.view.b.a) aVar);
            return b != null ? aVar.b(b) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.c.o() ? a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    final class b {
        final /* synthetic */ i a;
        private q b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        b(i iVar, q qVar) {
            this.a = iVar;
            this.b = qVar;
            this.c = qVar.a();
        }

        final int a() {
            this.c = this.b.a();
            return this.c ? 2 : 1;
        }

        final void b() {
            boolean a = this.b.a();
            if (a != this.c) {
                this.c = a;
                this.a.i();
            }
        }

        final void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver(this) {
                    final /* synthetic */ b a;

                    {
                        this.a = r1;
                    }

                    public void onReceive(Context context, Intent intent) {
                        this.a.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            this.a.a.registerReceiver(this.d, this.e);
        }

        final void d() {
            if (this.d != null) {
                this.a.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }

    i(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    private boolean h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (y()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                n.a(resources);
            }
        }
        return true;
    }

    private int w() {
        return this.t != -100 ? this.t : e.j();
    }

    private void x() {
        if (this.w == null) {
            this.w = new b(this, q.a(this.a));
        }
    }

    private boolean y() {
        if (!this.u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.t == -100) {
            this.t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void c() {
        super.c();
        i();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.t);
        }
    }

    int d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                x();
                return this.w.a();
            default:
                return i;
        }
    }

    public void d() {
        super.d();
        if (this.w != null) {
            this.w.d();
        }
    }

    public void g() {
        super.g();
        if (this.w != null) {
            this.w.d();
        }
    }

    public boolean i() {
        boolean z = false;
        int w = w();
        int d = d(w);
        if (d != -1) {
            z = h(d);
        }
        if (w == 0) {
            x();
            this.w.c();
        }
        this.u = true;
        return z;
    }

    public boolean o() {
        return this.v;
    }
}
