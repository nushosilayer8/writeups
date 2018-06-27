package android.support.v4.h;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class q {
    static final c a;

    static class c {
        c() {
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof k) {
                ((k) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof k ? ((k) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof k ? ((k) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof k ? ((k) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public void a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStopNestedScroll", e);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScroll", e);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreScroll", e);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreFling", e);
                return false;
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedFling", e);
                return false;
            }
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStartNestedScroll", e);
                return false;
            }
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScrollAccepted", e);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new b();
        } else if (VERSION.SDK_INT >= 19) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i);
        } else if (i == 0) {
            a.a(viewParent, view);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            a.a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            a.a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        return viewParent instanceof l ? ((l) viewParent).a(view, view2, i, i2) : i2 == 0 ? a.a(viewParent, view, view2, i) : false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof l) {
            ((l) viewParent).b(view, view2, i, i2);
        } else if (i2 == 0) {
            a.b(viewParent, view, view2, i);
        }
    }
}
