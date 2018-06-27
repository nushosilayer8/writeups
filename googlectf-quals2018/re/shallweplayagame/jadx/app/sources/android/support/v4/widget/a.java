package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.h.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    final a a = new a();
    final View b;
    boolean c;
    boolean d;
    boolean e;
    private final Interpolator f = new AccelerateInterpolator();
    private Runnable g;
    private float[] h = new float[]{0.0f, 0.0f};
    private float[] i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int j;
    private int k;
    private float[] l = new float[]{0.0f, 0.0f};
    private float[] m = new float[]{0.0f, 0.0f};
    private float[] n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean o;
    private boolean p;
    private boolean q;

    private static class a {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e = Long.MIN_VALUE;
        private long f = 0;
        private int g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;

        a() {
        }

        private float a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            if (this.i < 0 || j < this.i) {
                return a.a(((float) (j - this.e)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.i;
            return (a.a(((float) j2) / ((float) this.k), 0.0f, 1.0f) * this.j) + (1.0f - this.j);
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public void a(int i) {
            this.a = i;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void b(int i) {
            this.b = i;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = a(a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f;
            this.f = currentAnimationTimeMillis;
            this.g = (int) ((((float) j) * a) * this.c);
            this.h = (int) ((((float) j) * a) * this.d);
        }

        public int e() {
            return (int) (this.c / Math.abs(this.c));
        }

        public int f() {
            return (int) (this.d / Math.abs(this.d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (this.a.e) {
                if (this.a.c) {
                    this.a.c = false;
                    this.a.a.a();
                }
                a aVar = this.a.a;
                if (aVar.c() || !this.a.a()) {
                    this.a.e = false;
                    return;
                }
                if (this.a.d) {
                    this.a.d = false;
                    this.a.b();
                }
                aVar.d();
                this.a.a(aVar.g(), aVar.h());
                p.a(this.a.b, (Runnable) this);
            }
        }
    }

    public a(View view) {
        this.b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a((float) i, (float) i);
        b((float) i2, (float) i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float a(float f, float f2, float f3, float f4) {
        float f5;
        float a = a(f * f2, 0.0f, f3);
        a = f(f2 - f4, a) - f(f4, a);
        if (a < 0.0f) {
            f5 = -this.f.getInterpolation(-a);
        } else if (a <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f.getInterpolation(a);
        }
        return a(f5, -1.0f, 1.0f);
    }

    private float a(int i, float f, float f2, float f3) {
        float a = a(this.h[i], f2, this.i[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.l[i];
        float f5 = this.m[i];
        float f6 = this.n[i];
        f4 *= f3;
        return a > 0.0f ? a(a * f4, f5, f6) : -a((-a) * f4, f5, f6);
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void c() {
        if (this.g == null) {
            this.g = new b(this);
        }
        this.e = true;
        this.c = true;
        if (this.o || this.k <= 0) {
            this.g.run();
        } else {
            p.a(this.b, this.g, (long) this.k);
        }
        this.o = true;
    }

    private void d() {
        if (this.c) {
            this.e = false;
        } else {
            this.a.b();
        }
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.j) {
            case 0:
            case 1:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.e && this.j == 1) ? 1.0f : 0.0f : 0.0f;
            case 2:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public a a(float f, float f2) {
        this.n[0] = f / 1000.0f;
        this.n[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.j = i;
        return this;
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i, int i2);

    boolean a() {
        a aVar = this.a;
        int f = aVar.f();
        int e = aVar.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    public a b(float f, float f2) {
        this.m[0] = f / 1000.0f;
        this.m[1] = f2 / 1000.0f;
        return this;
    }

    public a b(int i) {
        this.k = i;
        return this;
    }

    void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a c(float f, float f2) {
        this.l[0] = f / 1000.0f;
        this.l[1] = f2 / 1000.0f;
        return this;
    }

    public a c(int i) {
        this.a.a(i);
        return this;
    }

    public a d(float f, float f2) {
        this.h[0] = f;
        this.h[1] = f2;
        return this;
    }

    public a d(int i) {
        this.a.b(i);
        return this;
    }

    public a e(float f, float f2) {
        this.i[0] = f;
        this.i[1] = f2;
        return this;
    }

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.d = true;
                this.o = false;
                break;
            case 1:
            case 3:
                d();
                break;
            case 2:
                break;
        }
        this.a.a(a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.b.getWidth()), a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.b.getHeight()));
        if (!this.e && a()) {
            c();
        }
        if (!(this.q && this.e)) {
            z = false;
        }
        return z;
    }
}
