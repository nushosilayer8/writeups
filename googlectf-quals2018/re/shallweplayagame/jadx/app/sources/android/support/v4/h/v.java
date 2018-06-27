package android.support.v4.h;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class v {
    private final Object a;

    private v(Object obj) {
        this.a = obj;
    }

    static v a(Object obj) {
        return obj == null ? null : new v(obj);
    }

    static Object a(v vVar) {
        return vVar == null ? null : vVar.a;
    }

    public int a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetLeft() : 0;
    }

    public v a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new v(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4)) : null;
    }

    public int b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetTop() : 0;
    }

    public int c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetRight() : 0;
    }

    public int d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetBottom() : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == null ? vVar.a == null : this.a.equals(vVar.a);
    }

    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
