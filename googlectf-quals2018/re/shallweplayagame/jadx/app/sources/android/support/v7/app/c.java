package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.a.ab;
import android.support.v4.a.ab.a;
import android.support.v4.a.i;
import android.support.v4.a.w;
import android.support.v7.view.b;
import android.support.v7.widget.bb;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class c extends i implements a, d {
    private e l;
    private int m = 0;
    private Resources n;

    private boolean a(int i, KeyEvent keyEvent) {
        if (!(VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()))) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public b a(b.a aVar) {
        return null;
    }

    public void a(ab abVar) {
        abVar.a((Activity) this);
    }

    public void a(b bVar) {
    }

    public boolean a(Intent intent) {
        return w.a((Activity) this, intent);
    }

    public Intent a_() {
        return w.a(this);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        j().b(view, layoutParams);
    }

    public void b(Intent intent) {
        w.b((Activity) this, intent);
    }

    public void b(ab abVar) {
    }

    public void b(b bVar) {
    }

    public void closeOptionsMenu() {
        a g = g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.d()) {
            super.closeOptionsMenu();
        }
    }

    public void d() {
        j().f();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a g = g();
        return (keyCode == 82 && g != null && g.a(keyEvent)) ? true : super.dispatchKeyEvent(keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return j().a(i);
    }

    public a g() {
        return j().a();
    }

    public MenuInflater getMenuInflater() {
        return j().b();
    }

    public Resources getResources() {
        if (this.n == null && bb.a()) {
            this.n = new bb(this, super.getResources());
        }
        return this.n == null ? super.getResources() : this.n;
    }

    public boolean h() {
        Intent a_ = a_();
        if (a_ == null) {
            return false;
        }
        if (a(a_)) {
            ab a = ab.a((Context) this);
            a(a);
            b(a);
            a.a();
            try {
                android.support.v4.a.a.a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            b(a_);
        }
        return true;
    }

    @Deprecated
    public void i() {
    }

    public void invalidateOptionsMenu() {
        j().f();
    }

    public e j() {
        if (this.l == null) {
            this.l = e.a((Activity) this, (d) this);
        }
        return this.l;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
        if (this.n != null) {
            this.n.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        i();
    }

    protected void onCreate(Bundle bundle) {
        e j = j();
        j.h();
        j.a(bundle);
        if (j.i() && this.m != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.m, false);
            } else {
                setTheme(this.m);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        j().g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a g = g();
        return (menuItem.getItemId() != 16908332 || g == null || (g.a() & 4) == 0) ? false : h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        j().b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        j().e();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j().c(bundle);
    }

    protected void onStart() {
        super.onStart();
        j().c();
    }

    protected void onStop() {
        super.onStop();
        j().d();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().a(charSequence);
    }

    public void openOptionsMenu() {
        a g = g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.c()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        j().b(i);
    }

    public void setContentView(View view) {
        j().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        j().a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.m = i;
    }
}
