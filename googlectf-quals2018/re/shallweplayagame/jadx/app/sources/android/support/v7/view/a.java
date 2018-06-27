package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.a.a.b;
import android.support.v7.a.a.d;
import android.support.v7.a.a.j;
import android.view.ViewConfiguration;

public class a {
    private Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int a() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        return (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) ? 5 : (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) ? 4 : i >= 360 ? 3 : 2;
    }

    public boolean b() {
        return VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.a).hasPermanentMenuKey();
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        return this.a.getResources().getBoolean(b.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, j.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }
}
