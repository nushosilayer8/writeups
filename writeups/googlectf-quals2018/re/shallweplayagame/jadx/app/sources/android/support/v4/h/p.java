package android.support.v4.h;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class p {
    static final j a;

    static class j {
        static boolean b = false;
        private static Field c;
        private static boolean d;
        private static WeakHashMap<View, String> e;
        WeakHashMap<View, r> a = null;

        j() {
        }

        long a() {
            return ValueAnimator.getFrameDelay();
        }

        public v a(View view, v vVar) {
            return vVar;
        }

        public void a(View view, float f) {
        }

        public void a(View view, int i, int i2) {
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof o) {
                ((o) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void a(View view, Mode mode) {
            if (view instanceof o) {
                ((o) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void a(View view, b bVar) {
            view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
        }

        public void a(View view, n nVar) {
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        public boolean a(View view) {
            return false;
        }

        public void b(View view) {
            view.postInvalidate();
        }

        public int c(View view) {
            if (!d) {
                try {
                    c = View.class.getDeclaredField("mMinHeight");
                    c.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                d = true;
            }
            if (c != null) {
                try {
                    return ((Integer) c.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public void d(View view) {
        }

        public boolean e(View view) {
            return true;
        }

        public int f(View view) {
            return 0;
        }

        public int g(View view) {
            return 0;
        }

        public boolean h(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean i(View view) {
            return view.getWindowToken() != null;
        }

        public String j(View view) {
            return e == null ? null : (String) e.get(view);
        }

        public void k(View view) {
            if (view instanceof h) {
                ((h) view).stopNestedScroll();
            }
        }

        public ColorStateList l(View view) {
            return view instanceof o ? ((o) view).getSupportBackgroundTintList() : null;
        }

        public Mode m(View view) {
            return view instanceof o ? ((o) view).getSupportBackgroundTintMode() : null;
        }

        public r n(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            r rVar = (r) this.a.get(view);
            if (rVar != null) {
                return rVar;
            }
            rVar = new r(view);
            this.a.put(view, rVar);
            return rVar;
        }
    }

    static class a extends j {
        a() {
        }

        public boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class b extends a {
        b() {
        }

        public void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public void b(View view) {
            view.postInvalidateOnAnimation();
        }

        public int c(View view) {
            return view.getMinimumHeight();
        }

        public void d(View view) {
            view.requestFitSystemWindows();
        }

        public boolean e(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class c extends b {
        c() {
        }

        public int f(View view) {
            return view.getLayoutDirection();
        }

        public int g(View view) {
            return view.getWindowSystemUiVisibility();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public boolean h(View view) {
            return view.isLaidOut();
        }

        public boolean i(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        f() {
        }

        public v a(View view, v vVar) {
            Object obj = (WindowInsets) v.a(vVar);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
            if (onApplyWindowInsets != obj) {
                obj = new WindowInsets(onApplyWindowInsets);
            }
            return v.a(obj);
        }

        public void a(View view, float f) {
            view.setElevation(f);
        }

        public void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, final n nVar) {
            if (nVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                    final /* synthetic */ f b;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) v.a(nVar.a(view, v.a((Object) windowInsets)));
                    }
                });
            }
        }

        public void d(View view) {
            view.requestApplyInsets();
        }

        public String j(View view) {
            return view.getTransitionName();
        }

        public void k(View view) {
            view.stopNestedScroll();
        }

        public ColorStateList l(View view) {
            return view.getBackgroundTintList();
        }

        public Mode m(View view) {
            return view.getBackgroundTintMode();
        }
    }

    static class g extends f {
        g() {
        }

        public void a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new i();
        } else if (VERSION.SDK_INT >= 24) {
            a = new h();
        } else if (VERSION.SDK_INT >= 23) {
            a = new g();
        } else if (VERSION.SDK_INT >= 21) {
            a = new f();
        } else if (VERSION.SDK_INT >= 19) {
            a = new e();
        } else if (VERSION.SDK_INT >= 18) {
            a = new d();
        } else if (VERSION.SDK_INT >= 17) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new j();
        }
    }

    public static v a(View view, v vVar) {
        return a.a(view, vVar);
    }

    public static void a(View view) {
        a.b(view);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void a(View view, int i, int i2) {
        a.a(view, i, i2);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, Drawable drawable) {
        a.a(view, drawable);
    }

    public static void a(View view, b bVar) {
        a.a(view, bVar);
    }

    public static void a(View view, n nVar) {
        a.a(view, nVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static int b(View view) {
        return a.f(view);
    }

    public static int c(View view) {
        return a.c(view);
    }

    public static r d(View view) {
        return a.n(view);
    }

    public static String e(View view) {
        return a.j(view);
    }

    public static int f(View view) {
        return a.g(view);
    }

    public static void g(View view) {
        a.d(view);
    }

    public static boolean h(View view) {
        return a.e(view);
    }

    public static ColorStateList i(View view) {
        return a.l(view);
    }

    public static Mode j(View view) {
        return a.m(view);
    }

    public static void k(View view) {
        a.k(view);
    }

    public static boolean l(View view) {
        return a.h(view);
    }

    public static boolean m(View view) {
        return a.i(view);
    }

    public static boolean n(View view) {
        return a.a(view);
    }
}
