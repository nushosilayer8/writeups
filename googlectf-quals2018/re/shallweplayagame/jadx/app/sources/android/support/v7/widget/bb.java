package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;

public class bb extends Resources {
    private final WeakReference<Context> a;

    public bb(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public static boolean a() {
        return e.k() && VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.a.get();
        return context != null ? l.a().a(context, this, i) : super.getDrawable(i);
    }
}
