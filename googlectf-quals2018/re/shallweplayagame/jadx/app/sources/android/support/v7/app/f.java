package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.aw;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

abstract class f extends e {
    private static boolean m = true;
    private static final boolean n = (VERSION.SDK_INT < 21);
    private static final int[] o = new int[]{16842836};
    final Context a;
    final Window b;
    final Callback c = this.b.getCallback();
    final Callback d;
    final d e;
    a f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence p;
    private boolean q;
    private boolean r;

    class a extends i {
        final /* synthetic */ f a;

        a(f fVar, Callback callback) {
            this.a = fVar;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.a.a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof h)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.a.b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.a.a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            h hVar = menu instanceof h ? (h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar == null) {
                return onPreparePanel;
            }
            hVar.c(false);
            return onPreparePanel;
        }
    }

    static {
        if (n && !m) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                private boolean a(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    return message != null ? message.contains("drawable") || message.contains("Drawable") : false;
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Throwable notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    f(Context context, Window window, d dVar) {
        this.a = context;
        this.b = window;
        this.e = dVar;
        if (this.c instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = a(this.c);
        this.b.setCallback(this.d);
        aw a = aw.a(context, null, o);
        Drawable b = a.b(0);
        if (b != null) {
            this.b.setBackgroundDrawable(b);
        }
        a.a();
    }

    public a a() {
        l();
        return this.f;
    }

    abstract b a(android.support.v7.view.b.a aVar);

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    abstract void a(int i, Menu menu);

    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    public MenuInflater b() {
        if (this.g == null) {
            l();
            this.g = new g(this.f != null ? this.f.b() : this.a);
        }
        return this.g;
    }

    abstract void b(CharSequence charSequence);

    abstract boolean b(int i, Menu menu);

    public void c() {
        this.q = true;
    }

    public void c(Bundle bundle) {
    }

    public void d() {
        this.q = false;
    }

    public void g() {
        this.r = true;
    }

    public boolean i() {
        return false;
    }

    abstract void l();

    final a m() {
        return this.f;
    }

    final Context n() {
        Context context = null;
        a a = a();
        if (a != null) {
            context = a.b();
        }
        return context == null ? this.a : context;
    }

    public boolean o() {
        return false;
    }

    final boolean p() {
        return this.r;
    }

    final Callback q() {
        return this.b.getCallback();
    }

    final CharSequence r() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.p;
    }
}
