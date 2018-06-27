package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class e {
    private static int a = -1;
    private static boolean b = false;

    e() {
    }

    public static e a(Activity activity, d dVar) {
        return a(activity, activity.getWindow(), dVar);
    }

    public static e a(Dialog dialog, d dVar) {
        return a(dialog.getContext(), dialog.getWindow(), dVar);
    }

    private static e a(Context context, Window window, d dVar) {
        return VERSION.SDK_INT >= 24 ? new g(context, window, dVar) : VERSION.SDK_INT >= 23 ? new j(context, window, dVar) : VERSION.SDK_INT >= 14 ? new i(context, window, dVar) : VERSION.SDK_INT >= 11 ? new h(context, window, dVar) : new k(context, window, dVar);
    }

    public static int j() {
        return a;
    }

    public static boolean k() {
        return b;
    }

    public abstract a a();

    public abstract <T extends View> T a(int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(Bundle bundle);

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();
}
