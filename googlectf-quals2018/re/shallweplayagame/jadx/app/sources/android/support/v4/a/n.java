package android.support.v4.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.i;
import android.support.v4.h.p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class n extends m implements Factory2 {
    static final Interpolator E = new DecelerateInterpolator(2.5f);
    static final Interpolator F = new DecelerateInterpolator(1.5f);
    static final Interpolator G = new AccelerateInterpolator(2.5f);
    static final Interpolator H = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q = null;
    SparseArray<Parcelable> A = null;
    ArrayList<g> B;
    o C;
    Runnable D = new Runnable(this) {
        final /* synthetic */ n a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.e();
        }
    };
    private final CopyOnWriteArrayList<i<android.support.v4.a.m.a, Boolean>> I = new CopyOnWriteArrayList();
    ArrayList<f> b;
    boolean c;
    int d = 0;
    final ArrayList<h> e = new ArrayList();
    SparseArray<h> f;
    ArrayList<c> g;
    ArrayList<h> h;
    ArrayList<c> i;
    ArrayList<Integer> j;
    ArrayList<android.support.v4.a.m.b> k;
    int l = 0;
    l m;
    j n;
    h o;
    h p;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    ArrayList<c> w;
    ArrayList<Boolean> x;
    ArrayList<h> y;
    Bundle z = null;

    interface f {
        boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2);
    }

    private static class b implements AnimationListener {
        private final AnimationListener a;

        private b(AnimationListener animationListener) {
            this.a = animationListener;
        }

        /* synthetic */ b(AnimationListener animationListener, AnonymousClass1 anonymousClass1) {
            this(animationListener);
        }

        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }
    }

    private static class a extends b {
        View a;

        a(View view, AnimationListener animationListener) {
            super(animationListener, null);
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (p.m(this.a) || VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.setLayerType(0, null);
                    }
                });
            } else {
                this.a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class c {
        public final Animation a;
        public final Animator b;

        private c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        /* synthetic */ c(Animator animator, AnonymousClass1 anonymousClass1) {
            this(animator);
        }

        private c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        /* synthetic */ c(Animation animation, AnonymousClass1 anonymousClass1) {
            this(animation);
        }
    }

    private static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }
    }

    static class e {
        public static final int[] a = new int[]{16842755, 16842960, 16842961};
    }

    static class g implements c {
        private final boolean a;
        private final c b;
        private int c;

        g(c cVar, boolean z) {
            this.a = z;
            this.b = cVar;
        }

        public void a() {
            this.c--;
            if (this.c == 0) {
                this.b.b.y();
            }
        }

        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = false;
            boolean z2 = this.c > 0;
            n nVar = this.b.b;
            int size = nVar.e.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) nVar.e.get(i);
                hVar.a(null);
                if (z2 && hVar.U()) {
                    hVar.A();
                }
            }
            n nVar2 = this.b.b;
            c cVar = this.b;
            boolean z3 = this.a;
            if (!z2) {
                z = true;
            }
            nVar2.a(cVar, z3, z, true);
        }

        public void e() {
            this.b.b.a(this.b, this.a, false, false);
        }
    }

    n() {
    }

    private void A() {
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                ((g) this.B.remove(0)).d();
            }
        }
    }

    private void B() {
        int size = this.f == null ? 0 : this.f.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.f.valueAt(i);
            if (hVar != null) {
                if (hVar.R() != null) {
                    int T = hVar.T();
                    View R = hVar.R();
                    hVar.a(null);
                    Animation animation = R.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        R.clearAnimation();
                    }
                    a(hVar, T, 0, 0, false);
                } else if (hVar.S() != null) {
                    hVar.S().end();
                }
            }
        }
    }

    private void C() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, android.support.v4.g.b<h> bVar) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            int i5;
            c cVar = (c) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            boolean z = cVar.c() && !cVar.a((ArrayList) arrayList, i3 + 1, i2);
            if (z) {
                if (this.B == null) {
                    this.B = new ArrayList();
                }
                c gVar = new g(cVar, booleanValue);
                this.B.add(gVar);
                cVar.a(gVar);
                if (booleanValue) {
                    cVar.b();
                } else {
                    cVar.a(false);
                }
                int i6 = i4 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, cVar);
                }
                b((android.support.v4.g.b) bVar);
                i5 = i6;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    static c a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220);
        return new c(alphaAnimation, null);
    }

    static c a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return new c(animationSet, null);
    }

    private static AnimationListener a(Animation animation) {
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (AnimationListener) q.get(animation);
        } catch (Throwable e) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    private void a(c cVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            cVar.a(z3);
        } else {
            cVar.b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(cVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            s.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) this.f.valueAt(i);
                if (hVar != null && hVar.H != null && hVar.P && cVar.b(hVar.x)) {
                    if (hVar.R > 0.0f) {
                        hVar.H.setAlpha(hVar.R);
                    }
                    if (z3) {
                        hVar.R = 0.0f;
                    } else {
                        hVar.R = -1.0f;
                        hVar.P = false;
                    }
                }
            }
        }
    }

    private void a(final h hVar, c cVar, int i) {
        final View view = hVar.H;
        hVar.b(i);
        if (cVar.a != null) {
            Animation animation = cVar.a;
            hVar.a(hVar.H);
            animation.setAnimationListener(new b(this, a(animation)) {
                final /* synthetic */ n b;

                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (hVar.R() != null) {
                        hVar.a(null);
                        this.b.a(hVar, hVar.T(), 0, 0, false);
                    }
                }
            });
            b(view, cVar);
            hVar.H.startAnimation(animation);
            return;
        }
        Animator animator = cVar.b;
        hVar.a(cVar.b);
        final ViewGroup viewGroup = hVar.G;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ n d;

            public void onAnimationEnd(Animator animator) {
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (hVar.S() != null) {
                    hVar.a(null);
                    this.d.a(hVar, hVar.T(), 0, 0, false);
                }
            }
        });
        animator.setTarget(hVar.H);
        b(hVar.H, cVar);
        animator.start();
    }

    private static void a(o oVar) {
        if (oVar != null) {
            List<h> a = oVar.a();
            if (a != null) {
                for (h hVar : a) {
                    hVar.C = true;
                }
            }
            List<o> b = oVar.b();
            if (b != null) {
                for (o a2 : b) {
                    a(a2);
                }
            }
        }
    }

    private void a(android.support.v4.g.b<h> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) bVar.b(i);
            if (!hVar.k) {
                View i2 = hVar.i();
                hVar.R = i2.getAlpha();
                i2.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    private void a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        int size = this.B == null ? 0 : this.B.size();
        while (i < size) {
            int indexOf;
            g gVar = (g) this.B.get(i);
            if (!(arrayList == null || gVar.a)) {
                indexOf = arrayList.indexOf(gVar.b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    gVar.e();
                    i++;
                    size = size;
                }
            }
            if (gVar.c() || (arrayList != null && gVar.b.a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.B.remove(i);
                i--;
                size--;
                if (!(arrayList == null || gVar.a)) {
                    indexOf = arrayList.indexOf(gVar.b);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        gVar.e();
                    }
                }
                gVar.d();
            }
            i++;
            size = size;
        }
    }

    private void a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        c cVar;
        int a;
        boolean z = ((c) arrayList.get(i)).u;
        if (this.y == null) {
            this.y = new ArrayList();
        } else {
            this.y.clear();
        }
        this.y.addAll(this.e);
        int i3 = i;
        h v = v();
        boolean z2 = false;
        while (i3 < i2) {
            cVar = (c) arrayList.get(i3);
            h a2 = !((Boolean) arrayList2.get(i3)).booleanValue() ? cVar.a(this.y, v) : cVar.b(this.y, v);
            boolean z3 = z2 || cVar.j;
            i3++;
            v = a2;
            z2 = z3;
        }
        this.y.clear();
        if (!z) {
            s.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            android.support.v4.g.b bVar = new android.support.v4.g.b();
            b(bVar);
            a = a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, bVar);
            a(bVar);
        } else {
            a = i2;
        }
        if (a != i && z) {
            s.a(this, arrayList, arrayList2, i, a, true);
            a(this.l, true);
        }
        while (i < i2) {
            cVar = (c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && cVar.n >= 0) {
                c(cVar.n);
                cVar.n = -1;
            }
            cVar.a();
            i++;
        }
        if (z2) {
            g();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.a instanceof AnimationSet)) {
            return a(cVar.b);
        }
        List animations = ((AnimationSet) cVar.a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && p.h(view) && a(cVar);
    }

    private boolean a(String str, int i, int i2) {
        e();
        c(true);
        if (this.p != null && i < 0 && str == null) {
            m h = this.p.h();
            if (h != null && h.a()) {
                return true;
            }
        }
        boolean a = a(this.w, this.x, str, i, i2);
        if (a) {
            this.c = true;
            try {
                b(this.w, this.x);
            } finally {
                z();
            }
        }
        f();
        C();
        return a;
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void b(android.support.v4.g.b<h> bVar) {
        if (this.l >= 1) {
            int min = Math.min(this.l, 4);
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) this.e.get(i);
                if (hVar.b < min) {
                    a(hVar, min, hVar.M(), hVar.N(), false);
                    if (!(hVar.H == null || hVar.z || !hVar.P)) {
                        bVar.add(hVar);
                    }
                }
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a(view, cVar)) {
            if (cVar.b != null) {
                cVar.b.addListener(new d(view));
                return;
            }
            AnimationListener a = a(cVar.a);
            view.setLayerType(2, null);
            cVar.a.setAnimationListener(new a(view, a));
        }
    }

    private void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((c) arrayList.get(i)).u) {
                    i3 = i;
                } else {
                    if (i2 != i) {
                        a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((c) arrayList.get(i2)).u) {
                            i2++;
                        }
                    }
                    i3 = i2;
                    a((ArrayList) arrayList, (ArrayList) arrayList2, i, i3);
                    i2 = i3;
                    i3--;
                }
                i = i3 + 1;
            }
            if (i2 != size) {
                a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    private static void b(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            c cVar = (c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                cVar.a(-1);
                cVar.a(i == i2 + -1);
            } else {
                cVar.a(1);
                cVar.b();
            }
            i++;
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                x();
            }
            if (this.w == null) {
                this.w = new ArrayList();
                this.x = new ArrayList();
            }
            this.c = true;
            try {
                a(null, null);
            } finally {
                this.c = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.util.ArrayList<android.support.v4.a.c> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        r0 = 0;
        monitor-enter(r4);
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        r1 = r1.size();	 Catch:{ all -> 0x003e }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = r4.b;	 Catch:{ all -> 0x003e }
        r3 = r1.size();	 Catch:{ all -> 0x003e }
        r2 = r0;
        r1 = r0;
    L_0x0018:
        if (r2 >= r3) goto L_0x002b;
    L_0x001a:
        r0 = r4.b;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (android.support.v4.a.n.f) r0;	 Catch:{ all -> 0x003e }
        r0 = r0.a(r5, r6);	 Catch:{ all -> 0x003e }
        r1 = r1 | r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x002b:
        r0 = r4.b;	 Catch:{ all -> 0x003e }
        r0.clear();	 Catch:{ all -> 0x003e }
        r0 = r4.m;	 Catch:{ all -> 0x003e }
        r0 = r0.h();	 Catch:{ all -> 0x003e }
        r2 = r4.D;	 Catch:{ all -> 0x003e }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x000f;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.n.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public static int d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void e(int i) {
        try {
            this.c = true;
            a(i, false);
            e();
        } finally {
            this.c = false;
        }
    }

    private h p(h hVar) {
        ViewGroup viewGroup = hVar.G;
        View view = hVar.H;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.e.indexOf(hVar) - 1; indexOf >= 0; indexOf--) {
            h hVar2 = (h) this.e.get(indexOf);
            if (hVar2.G == viewGroup && hVar2.H != null) {
                return hVar2;
            }
        }
        return null;
    }

    private void x() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    private void y() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.B == null || this.B.isEmpty()) ? null : 1;
            if (this.b == null || this.b.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && obj == null)) {
                this.m.h().removeCallbacks(this.D);
                this.m.h().post(this.D);
            }
        }
    }

    private void z() {
        this.c = false;
        this.x.clear();
        this.w.clear();
    }

    public h a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        h hVar = (h) this.f.get(i);
        if (hVar != null) {
            return hVar;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return hVar;
    }

    public h a(String str) {
        int size;
        h hVar;
        if (str != null) {
            for (size = this.e.size() - 1; size >= 0; size--) {
                hVar = (h) this.e.get(size);
                if (hVar != null && str.equals(hVar.y)) {
                    return hVar;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                hVar = (h) this.f.valueAt(size);
                if (hVar != null && str.equals(hVar.y)) {
                    return hVar;
                }
            }
        }
        return null;
    }

    c a(h hVar, int i, boolean z, int i2) {
        int M = hVar.M();
        Animation a = hVar.a(i, z, M);
        if (a != null) {
            return new c(a, null);
        }
        Animator b = hVar.b(i, z, M);
        if (b != null) {
            return new c(b, null);
        }
        if (M != 0) {
            Object obj;
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(M));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), M);
                    if (loadAnimation != null) {
                        return new c(loadAnimation, null);
                    }
                    obj = 1;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                    obj = null;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    b = AnimatorInflater.loadAnimator(this.m.g(), M);
                    if (b != null) {
                        return new c(b, null);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    a = AnimationUtils.loadAnimation(this.m.g(), M);
                    if (a != null) {
                        return new c(a, null);
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        int b2 = b(i, z);
        if (b2 < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.g(), 0.0f, 1.0f);
            case 6:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.m.d()) {
                    i2 = this.m.e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void a(int i, c cVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList();
            }
            int size = this.i.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + cVar);
                }
                this.i.set(i, cVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + cVar);
                }
                this.i.add(cVar);
            }
        }
    }

    void a(int i, boolean z) {
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.l) {
            this.l = i;
            if (this.f != null) {
                h hVar;
                int size = this.e.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    hVar = (h) this.e.get(i2);
                    e(hVar);
                    i2++;
                    i3 = hVar.L != null ? hVar.L.a() | i3 : i3;
                }
                size = this.f.size();
                i2 = 0;
                while (i2 < size) {
                    int a;
                    hVar = (h) this.f.valueAt(i2);
                    if (hVar != null && ((hVar.l || hVar.A) && !hVar.P)) {
                        e(hVar);
                        if (hVar.L != null) {
                            a = hVar.L.a() | i3;
                            i2++;
                            i3 = a;
                        }
                    }
                    a = i3;
                    i2++;
                    i3 = a;
                }
                if (i3 == 0) {
                    d();
                }
                if (this.r && this.m != null && this.l == 5) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                h hVar = (h) this.e.get(i2);
                if (hVar != null) {
                    hVar.a(configuration);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(Bundle bundle, String str, h hVar) {
        if (hVar.e < 0) {
            a(new IllegalStateException("Fragment " + hVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, hVar.e);
    }

    void a(Parcelable parcelable, o oVar) {
        if (parcelable != null) {
            p pVar = (p) parcelable;
            if (pVar.a != null) {
                int size;
                h hVar;
                int i;
                List list;
                if (oVar != null) {
                    List a = oVar.a();
                    List b = oVar.b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean size2 = false;
                    }
                    for (int i2 = 0; i2 < size2; i2++) {
                        hVar = (h) a.get(i2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + hVar);
                        }
                        i = 0;
                        while (i < pVar.a.length && pVar.a[i].b != hVar.e) {
                            i++;
                        }
                        if (i == pVar.a.length) {
                            a(new IllegalStateException("Could not find active fragment with index " + hVar.e));
                        }
                        q qVar = pVar.a[i];
                        qVar.l = hVar;
                        hVar.d = null;
                        hVar.q = 0;
                        hVar.n = false;
                        hVar.k = false;
                        hVar.h = null;
                        if (qVar.k != null) {
                            qVar.k.setClassLoader(this.m.g().getClassLoader());
                            hVar.d = qVar.k.getSparseParcelableArray("android:view_state");
                            hVar.c = qVar.k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f = new SparseArray(pVar.a.length);
                i = 0;
                while (i < pVar.a.length) {
                    q qVar2 = pVar.a[i];
                    if (qVar2 != null) {
                        o oVar2 = (list == null || i >= list.size()) ? null : (o) list.get(i);
                        hVar = qVar2.a(this.m, this.n, this.o, oVar2);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + hVar);
                        }
                        this.f.put(hVar.e, hVar);
                        qVar2.l = null;
                    }
                    i++;
                }
                if (oVar != null) {
                    List a2 = oVar.a();
                    if (a2 != null) {
                        i = a2.size();
                    } else {
                        boolean z = false;
                    }
                    for (int i3 = 0; i3 < i; i3++) {
                        hVar = (h) a2.get(i3);
                        if (hVar.i >= 0) {
                            hVar.h = (h) this.f.get(hVar.i);
                            if (hVar.h == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + hVar + " target no longer exists: " + hVar.i);
                            }
                        }
                    }
                }
                this.e.clear();
                if (pVar.b != null) {
                    for (size2 = 0; size2 < pVar.b.length; size2++) {
                        hVar = (h) this.f.get(pVar.b[size2]);
                        if (hVar == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + pVar.b[size2]));
                        }
                        hVar.k = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size2 + ": " + hVar);
                        }
                        if (this.e.contains(hVar)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.e) {
                            this.e.add(hVar);
                        }
                    }
                }
                if (pVar.c != null) {
                    this.g = new ArrayList(pVar.c.length);
                    for (int i4 = 0; i4 < pVar.c.length; i4++) {
                        c a3 = pVar.c[i4].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + a3.n + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new android.support.v4.g.e("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a3);
                        if (a3.n >= 0) {
                            a(a3.n, a3);
                        }
                    }
                } else {
                    this.g = null;
                }
                if (pVar.d >= 0) {
                    this.p = (h) this.f.get(pVar.d);
                }
                this.d = pVar.e;
            }
        }
    }

    void a(c cVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(cVar);
    }

    public void a(h hVar) {
        if (!hVar.J) {
            return;
        }
        if (this.c) {
            this.v = true;
            return;
        }
        hVar.J = false;
        a(hVar, this.l, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(android.support.v4.a.h r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.k;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.A;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.l;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r11.b;
        if (r12 <= r0) goto L_0x0023;
    L_0x0018:
        r0 = r11.b;
        if (r0 != 0) goto L_0x003b;
    L_0x001c:
        r0 = r11.b();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r12 = r5;
    L_0x0023:
        r0 = r11.J;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r11.b;
        if (r0 >= r9) goto L_0x002e;
    L_0x002b:
        if (r12 <= r6) goto L_0x002e;
    L_0x002d:
        r12 = r6;
    L_0x002e:
        r0 = r11.b;
        if (r0 > r12) goto L_0x032e;
    L_0x0032:
        r0 = r11.m;
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r11.n;
        if (r0 != 0) goto L_0x003e;
    L_0x003a:
        return;
    L_0x003b:
        r12 = r11.b;
        goto L_0x0023;
    L_0x003e:
        r0 = r11.R();
        if (r0 != 0) goto L_0x004a;
    L_0x0044:
        r0 = r11.S();
        if (r0 == 0) goto L_0x005a;
    L_0x004a:
        r11.a(r7);
        r11.a(r7);
        r2 = r11.T();
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x005a:
        r0 = r11.b;
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01c2;
            case 2: goto L_0x02c0;
            case 3: goto L_0x02c5;
            case 4: goto L_0x02e9;
            default: goto L_0x005f;
        };
    L_0x005f:
        r0 = r11.b;
        if (r0 == r12) goto L_0x003a;
    L_0x0063:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.b;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.b = r12;
        goto L_0x003a;
    L_0x009a:
        if (r12 <= 0) goto L_0x01c2;
    L_0x009c:
        r0 = a;
        if (r0 == 0) goto L_0x00b8;
    L_0x00a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00b8:
        r0 = r11.c;
        if (r0 == 0) goto L_0x0100;
    L_0x00bc:
        r0 = r11.c;
        r1 = r10.m;
        r1 = r1.g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.c;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.d = r0;
        r0 = r11.c;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.h = r0;
        r0 = r11.h;
        if (r0 == 0) goto L_0x00ed;
    L_0x00e3:
        r0 = r11.c;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.j = r0;
    L_0x00ed:
        r0 = r11.c;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.K = r0;
        r0 = r11.K;
        if (r0 != 0) goto L_0x0100;
    L_0x00fb:
        r11.J = r5;
        if (r12 <= r6) goto L_0x0100;
    L_0x00ff:
        r12 = r6;
    L_0x0100:
        r0 = r10.m;
        r11.s = r0;
        r0 = r10.o;
        r11.v = r0;
        r0 = r10.o;
        if (r0 == 0) goto L_0x014f;
    L_0x010c:
        r0 = r10.o;
        r0 = r0.t;
    L_0x0110:
        r11.r = r0;
        r0 = r11.h;
        if (r0 == 0) goto L_0x0164;
    L_0x0116:
        r0 = r10.f;
        r1 = r11.h;
        r1 = r1.e;
        r0 = r0.get(r1);
        r1 = r11.h;
        if (r0 == r1) goto L_0x0156;
    L_0x0124:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " declared target fragment ";
        r1 = r1.append(r2);
        r2 = r11.h;
        r1 = r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014f:
        r0 = r10.m;
        r0 = r0.i();
        goto L_0x0110;
    L_0x0156:
        r0 = r11.h;
        r0 = r0.b;
        if (r0 >= r5) goto L_0x0164;
    L_0x015c:
        r1 = r11.h;
        r0 = r10;
        r2 = r5;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0164:
        r0 = r10.m;
        r0 = r0.g();
        r10.a(r11, r0, r3);
        r11.F = r3;
        r0 = r10.m;
        r0 = r0.g();
        r11.a(r0);
        r0 = r11.F;
        if (r0 != 0) goto L_0x019b;
    L_0x017c:
        r0 = new android.support.v4.a.z;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x019b:
        r0 = r11.v;
        if (r0 != 0) goto L_0x0313;
    L_0x019f:
        r0 = r10.m;
        r0.b(r11);
    L_0x01a4:
        r0 = r10.m;
        r0 = r0.g();
        r10.b(r11, r0, r3);
        r0 = r11.T;
        if (r0 != 0) goto L_0x031a;
    L_0x01b1:
        r0 = r11.c;
        r10.a(r11, r0, r3);
        r0 = r11.c;
        r11.k(r0);
        r0 = r11.c;
        r10.b(r11, r0, r3);
    L_0x01c0:
        r11.C = r3;
    L_0x01c2:
        r10.c(r11);
        if (r12 <= r5) goto L_0x02c0;
    L_0x01c7:
        r0 = a;
        if (r0 == 0) goto L_0x01e3;
    L_0x01cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01e3:
        r0 = r11.m;
        if (r0 != 0) goto L_0x02ab;
    L_0x01e7:
        r0 = r11.x;
        if (r0 == 0) goto L_0x04a1;
    L_0x01eb:
        r0 = r11.x;
        r1 = -1;
        if (r0 != r1) goto L_0x0211;
    L_0x01f0:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.a(r0);
    L_0x0211:
        r0 = r10.n;
        r1 = r11.x;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0260;
    L_0x021d:
        r1 = r11.o;
        if (r1 != 0) goto L_0x0260;
    L_0x0221:
        r1 = r11.e();	 Catch:{ NotFoundException -> 0x0323 }
        r2 = r11.x;	 Catch:{ NotFoundException -> 0x0323 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0323 }
    L_0x022b:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.x;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.a(r2);
    L_0x0260:
        r11.G = r0;
        r1 = r11.c;
        r1 = r11.d(r1);
        r2 = r11.c;
        r1 = r11.b(r1, r0, r2);
        r11.H = r1;
        r1 = r11.H;
        if (r1 == 0) goto L_0x032a;
    L_0x0274:
        r1 = r11.H;
        r11.I = r1;
        r1 = r11.H;
        r1.setSaveFromParentEnabled(r3);
        if (r0 == 0) goto L_0x0284;
    L_0x027f:
        r1 = r11.H;
        r0.addView(r1);
    L_0x0284:
        r0 = r11.z;
        if (r0 == 0) goto L_0x028f;
    L_0x0288:
        r0 = r11.H;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x028f:
        r0 = r11.H;
        r1 = r11.c;
        r11.a(r0, r1);
        r0 = r11.H;
        r1 = r11.c;
        r10.a(r11, r0, r1, r3);
        r0 = r11.H;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0328;
    L_0x02a5:
        r0 = r11.G;
        if (r0 == 0) goto L_0x0328;
    L_0x02a9:
        r11.P = r5;
    L_0x02ab:
        r0 = r11.c;
        r11.l(r0);
        r0 = r11.c;
        r10.c(r11, r0, r3);
        r0 = r11.H;
        if (r0 == 0) goto L_0x02be;
    L_0x02b9:
        r0 = r11.c;
        r11.a(r0);
    L_0x02be:
        r11.c = r7;
    L_0x02c0:
        r0 = 2;
        if (r12 <= r0) goto L_0x02c5;
    L_0x02c3:
        r11.b = r6;
    L_0x02c5:
        if (r12 <= r6) goto L_0x02e9;
    L_0x02c7:
        r0 = a;
        if (r0 == 0) goto L_0x02e3;
    L_0x02cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02e3:
        r11.C();
        r10.b(r11, r3);
    L_0x02e9:
        if (r12 <= r9) goto L_0x005f;
    L_0x02eb:
        r0 = a;
        if (r0 == 0) goto L_0x0307;
    L_0x02ef:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0307:
        r11.D();
        r10.c(r11, r3);
        r11.c = r7;
        r11.d = r7;
        goto L_0x005f;
    L_0x0313:
        r0 = r11.v;
        r0.a(r11);
        goto L_0x01a4;
    L_0x031a:
        r0 = r11.c;
        r11.g(r0);
        r11.b = r5;
        goto L_0x01c0;
    L_0x0323:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x022b;
    L_0x0328:
        r5 = r3;
        goto L_0x02a9;
    L_0x032a:
        r11.I = r7;
        goto L_0x02ab;
    L_0x032e:
        r0 = r11.b;
        if (r0 <= r12) goto L_0x005f;
    L_0x0332:
        r0 = r11.b;
        switch(r0) {
            case 1: goto L_0x0339;
            case 2: goto L_0x03cb;
            case 3: goto L_0x03aa;
            case 4: goto L_0x0386;
            case 5: goto L_0x0361;
            default: goto L_0x0337;
        };
    L_0x0337:
        goto L_0x005f;
    L_0x0339:
        if (r12 >= r5) goto L_0x005f;
    L_0x033b:
        r0 = r10.t;
        if (r0 == 0) goto L_0x034f;
    L_0x033f:
        r0 = r11.R();
        if (r0 == 0) goto L_0x044b;
    L_0x0345:
        r0 = r11.R();
        r11.a(r7);
        r0.clearAnimation();
    L_0x034f:
        r0 = r11.R();
        if (r0 != 0) goto L_0x035b;
    L_0x0355:
        r0 = r11.S();
        if (r0 == 0) goto L_0x045d;
    L_0x035b:
        r11.b(r12);
        r12 = r5;
        goto L_0x005f;
    L_0x0361:
        r0 = 5;
        if (r12 >= r0) goto L_0x0386;
    L_0x0364:
        r0 = a;
        if (r0 == 0) goto L_0x0380;
    L_0x0368:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0380:
        r11.G();
        r10.d(r11, r3);
    L_0x0386:
        if (r12 >= r9) goto L_0x03aa;
    L_0x0388:
        r0 = a;
        if (r0 == 0) goto L_0x03a4;
    L_0x038c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03a4:
        r11.H();
        r10.e(r11, r3);
    L_0x03aa:
        if (r12 >= r6) goto L_0x03cb;
    L_0x03ac:
        r0 = a;
        if (r0 == 0) goto L_0x03c8;
    L_0x03b0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03c8:
        r11.I();
    L_0x03cb:
        r0 = 2;
        if (r12 >= r0) goto L_0x0339;
    L_0x03ce:
        r0 = a;
        if (r0 == 0) goto L_0x03ea;
    L_0x03d2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ea:
        r0 = r11.H;
        if (r0 == 0) goto L_0x03fd;
    L_0x03ee:
        r0 = r10.m;
        r0 = r0.a(r11);
        if (r0 == 0) goto L_0x03fd;
    L_0x03f6:
        r0 = r11.d;
        if (r0 != 0) goto L_0x03fd;
    L_0x03fa:
        r10.m(r11);
    L_0x03fd:
        r11.J();
        r10.f(r11, r3);
        r0 = r11.H;
        if (r0 == 0) goto L_0x0441;
    L_0x0407:
        r0 = r11.G;
        if (r0 == 0) goto L_0x0441;
    L_0x040b:
        r0 = r11.H;
        r0.clearAnimation();
        r0 = r11.G;
        r1 = r11.H;
        r0.endViewTransition(r1);
        r0 = r10.l;
        if (r0 <= 0) goto L_0x049f;
    L_0x041b:
        r0 = r10.t;
        if (r0 != 0) goto L_0x049f;
    L_0x041f:
        r0 = r11.H;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x049f;
    L_0x0427:
        r0 = r11.R;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x049f;
    L_0x042e:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x0432:
        r1 = 0;
        r11.R = r1;
        if (r0 == 0) goto L_0x043a;
    L_0x0437:
        r10.a(r11, r0, r12);
    L_0x043a:
        r0 = r11.G;
        r1 = r11.H;
        r0.removeView(r1);
    L_0x0441:
        r11.G = r7;
        r11.H = r7;
        r11.I = r7;
        r11.n = r3;
        goto L_0x0339;
    L_0x044b:
        r0 = r11.S();
        if (r0 == 0) goto L_0x034f;
    L_0x0451:
        r0 = r11.S();
        r11.a(r7);
        r0.cancel();
        goto L_0x034f;
    L_0x045d:
        r0 = a;
        if (r0 == 0) goto L_0x0479;
    L_0x0461:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0479:
        r0 = r11.C;
        if (r0 != 0) goto L_0x0494;
    L_0x047d:
        r11.K();
        r10.g(r11, r3);
    L_0x0483:
        r11.L();
        r10.h(r11, r3);
        if (r15 != 0) goto L_0x005f;
    L_0x048b:
        r0 = r11.C;
        if (r0 != 0) goto L_0x0497;
    L_0x048f:
        r10.g(r11);
        goto L_0x005f;
    L_0x0494:
        r11.b = r3;
        goto L_0x0483;
    L_0x0497:
        r11.s = r7;
        r11.v = r7;
        r11.r = r7;
        goto L_0x005f;
    L_0x049f:
        r0 = r7;
        goto L_0x0432;
    L_0x04a1:
        r0 = r7;
        goto L_0x0260;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.n.a(android.support.v4.a.h, int, int, int, boolean):void");
    }

    void a(h hVar, Context context, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).a(hVar, context, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).a((m) this, hVar, context);
            }
        }
    }

    void a(h hVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).a(hVar, bundle, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).a((m) this, hVar, bundle);
            }
        }
    }

    void a(h hVar, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).a(hVar, view, bundle, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).a(this, hVar, view, bundle);
            }
        }
    }

    public void a(h hVar, boolean z) {
        if (a) {
            Log.v("FragmentManager", "add: " + hVar);
        }
        f(hVar);
        if (!hVar.A) {
            if (this.e.contains(hVar)) {
                throw new IllegalStateException("Fragment already added: " + hVar);
            }
            synchronized (this.e) {
                this.e.add(hVar);
            }
            hVar.k = true;
            hVar.l = false;
            if (hVar.H == null) {
                hVar.Q = false;
            }
            if (hVar.D && hVar.E) {
                this.r = true;
            }
            if (z) {
                b(hVar);
            }
        }
    }

    public void a(l lVar, j jVar, h hVar) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = lVar;
        this.n = jVar;
        this.o = hVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        h hVar;
        c cVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    hVar = (h) this.f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                    if (hVar != null) {
                        hVar.a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                hVar = (h) this.e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(hVar.toString());
            }
        }
        if (this.h != null) {
            size = this.h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    hVar = (h) this.h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(hVar.toString());
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    cVar = (c) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(cVar.toString());
                    cVar.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.i != null) {
                int size2 = this.i.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        cVar = (c) this.i.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(cVar);
                    }
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null) {
            i = this.b.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    f fVar = (f) this.b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(fVar);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            h hVar = (h) this.e.get(size);
            if (hVar != null) {
                hVar.d(z);
            }
        }
    }

    public boolean a() {
        x();
        return a(null, -1, 0);
    }

    boolean a(int i) {
        return this.l >= i;
    }

    public boolean a(Menu menu) {
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i >= this.e.size()) {
                return z2;
            }
            h hVar = (h) this.e.get(i);
            if (hVar != null && hVar.c(menu)) {
            }
            z = i + 1;
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        h hVar;
        int i = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.e.size()) {
            hVar = (h) this.e.get(i2);
            if (hVar != null && hVar.b(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(hVar);
            }
            i2++;
            z = z;
        }
        if (this.h != null) {
            while (i < this.h.size()) {
                hVar = (h) this.h.get(i);
                if (arrayList == null || !arrayList.contains(hVar)) {
                    hVar.r();
                }
                i++;
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        for (int i = 0; i < this.e.size(); i++) {
            h hVar = (h) this.e.get(i);
            if (hVar != null && hVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.g == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                c cVar;
                size2 = this.g.size() - 1;
                while (size2 >= 0) {
                    cVar = (c) this.g.get(size2);
                    if ((str != null && str.equals(cVar.d())) || (i >= 0 && i == cVar.n)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        cVar = (c) this.g.get(size2);
                        if ((str == null || !str.equals(cVar.d())) && (i < 0 || i != cVar.n)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (size2 = this.g.size() - 1; size2 > size; size2--) {
                arrayList.add(this.g.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public h b(int i) {
        int size;
        h hVar;
        for (size = this.e.size() - 1; size >= 0; size--) {
            hVar = (h) this.e.get(size);
            if (hVar != null && hVar.w == i) {
                return hVar;
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                hVar = (h) this.f.valueAt(size);
                if (hVar != null && hVar.w == i) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public h b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                h hVar = (h) this.f.valueAt(size);
                if (hVar != null) {
                    hVar = hVar.a(str);
                    if (hVar != null) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    public List<h> b() {
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<h> list;
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    void b(h hVar) {
        a(hVar, this.l, 0, 0, false);
    }

    void b(h hVar, Context context, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).b(hVar, context, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).b((m) this, hVar, context);
            }
        }
    }

    void b(h hVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).b(hVar, bundle, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).b((m) this, hVar, bundle);
            }
        }
    }

    void b(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).b(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).a(this, hVar);
            }
        }
    }

    public void b(Menu menu) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                h hVar = (h) this.e.get(i2);
                if (hVar != null) {
                    hVar.d(menu);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            h hVar = (h) this.e.get(size);
            if (hVar != null) {
                hVar.e(z);
            }
        }
    }

    public boolean b(MenuItem menuItem) {
        for (int i = 0; i < this.e.size(); i++) {
            h hVar = (h) this.e.get(i);
            if (hVar != null && hVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void c(h hVar) {
        if (hVar.m && !hVar.p) {
            hVar.H = hVar.b(hVar.d(hVar.c), null, hVar.c);
            if (hVar.H != null) {
                hVar.I = hVar.H;
                hVar.H.setSaveFromParentEnabled(false);
                if (hVar.z) {
                    hVar.H.setVisibility(8);
                }
                hVar.a(hVar.H, hVar.c);
                a(hVar, hVar.H, hVar.c, false);
                return;
            }
            hVar.I = null;
        }
    }

    void c(h hVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).c(hVar, bundle, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).c(this, hVar, bundle);
            }
        }
    }

    void c(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).c(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).b(this, hVar);
            }
        }
    }

    public boolean c() {
        return this.s;
    }

    void d() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    h hVar = (h) this.f.valueAt(i2);
                    if (hVar != null) {
                        a(hVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void d(final h hVar) {
        if (hVar.H != null) {
            c a = a(hVar, hVar.N(), !hVar.z, hVar.O());
            if (a == null || a.b == null) {
                if (a != null) {
                    b(hVar.H, a);
                    hVar.H.startAnimation(a.a);
                    a.a.start();
                }
                int i = (!hVar.z || hVar.V()) ? 0 : 8;
                hVar.H.setVisibility(i);
                if (hVar.V()) {
                    hVar.f(false);
                }
            } else {
                a.b.setTarget(hVar.H);
                if (!hVar.z) {
                    hVar.H.setVisibility(0);
                } else if (hVar.V()) {
                    hVar.f(false);
                } else {
                    final ViewGroup viewGroup = hVar.G;
                    final View view = hVar.H;
                    viewGroup.startViewTransition(view);
                    a.b.addListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ n d;

                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (hVar.H != null) {
                                hVar.H.setVisibility(8);
                            }
                        }
                    });
                }
                b(hVar.H, a);
                a.b.start();
            }
        }
        if (hVar.k && hVar.D && hVar.E) {
            this.r = true;
        }
        hVar.Q = false;
        hVar.a(hVar.z);
    }

    void d(h hVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).d(hVar, bundle, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).d(this, hVar, bundle);
            }
        }
    }

    void d(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).d(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).c(this, hVar);
            }
        }
    }

    void e(h hVar) {
        if (hVar != null) {
            int i = this.l;
            if (hVar.l) {
                i = hVar.b() ? Math.min(i, 1) : Math.min(i, 0);
            }
            a(hVar, i, hVar.N(), hVar.O(), false);
            if (hVar.H != null) {
                h p = p(hVar);
                if (p != null) {
                    View view = p.H;
                    ViewGroup viewGroup = hVar.G;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(hVar.H);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(hVar.H, indexOfChild);
                    }
                }
                if (hVar.P && hVar.G != null) {
                    if (hVar.R > 0.0f) {
                        hVar.H.setAlpha(hVar.R);
                    }
                    hVar.R = 0.0f;
                    hVar.P = false;
                    c a = a(hVar, hVar.N(), true, hVar.O());
                    if (a != null) {
                        b(hVar.H, a);
                        if (a.a != null) {
                            hVar.H.startAnimation(a.a);
                        } else {
                            a.b.setTarget(hVar.H);
                            a.b.start();
                        }
                    }
                }
            }
            if (hVar.Q) {
                d(hVar);
            }
        }
    }

    void e(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).e(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).d(this, hVar);
            }
        }
    }

    public boolean e() {
        c(true);
        boolean z = false;
        while (c(this.w, this.x)) {
            this.c = true;
            try {
                b(this.w, this.x);
                z();
                z = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        f();
        C();
        return z;
    }

    void f() {
        if (this.v) {
            int i = 0;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                h hVar = (h) this.f.valueAt(i2);
                if (!(hVar == null || hVar.L == null)) {
                    i |= hVar.L.a();
                }
            }
            if (i == 0) {
                this.v = false;
                d();
            }
        }
    }

    void f(h hVar) {
        if (hVar.e < 0) {
            int i = this.d;
            this.d = i + 1;
            hVar.a(i, this.o);
            if (this.f == null) {
                this.f = new SparseArray();
            }
            this.f.put(hVar.e, hVar);
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + hVar);
            }
        }
    }

    void f(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).f(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).e(this, hVar);
            }
        }
    }

    void g() {
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.size()) {
                    ((android.support.v4.a.m.b) this.k.get(i2)).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void g(h hVar) {
        if (hVar.e >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + hVar);
            }
            this.f.put(hVar.e, null);
            this.m.a(hVar.f);
            hVar.p();
        }
    }

    void g(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).g(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).f(this, hVar);
            }
        }
    }

    o h() {
        a(this.C);
        return this.C;
    }

    public void h(h hVar) {
        if (a) {
            Log.v("FragmentManager", "remove: " + hVar + " nesting=" + hVar.q);
        }
        boolean z = !hVar.b();
        if (!hVar.A || z) {
            synchronized (this.e) {
                this.e.remove(hVar);
            }
            if (hVar.D && hVar.E) {
                this.r = true;
            }
            hVar.k = false;
            hVar.l = true;
        }
    }

    void h(h hVar, boolean z) {
        if (this.o != null) {
            m f = this.o.f();
            if (f instanceof n) {
                ((n) f).h(hVar, true);
            }
        }
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!z || ((Boolean) iVar.b).booleanValue()) {
                ((android.support.v4.a.m.a) iVar.a).g(this, hVar);
            }
        }
    }

    void i() {
        List list;
        List list2;
        if (this.f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f.size()) {
                ArrayList arrayList;
                ArrayList arrayList2;
                h hVar = (h) this.f.valueAt(i);
                if (hVar != null) {
                    Object obj;
                    if (hVar.B) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(hVar);
                        hVar.i = hVar.h != null ? hVar.h.e : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + hVar);
                        }
                    }
                    if (hVar.t != null) {
                        hVar.t.i();
                        obj = hVar.t.C;
                    } else {
                        o obj2 = hVar.u;
                    }
                    if (list == null && obj2 != null) {
                        list = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list.add(null);
                        }
                    }
                    arrayList2 = list;
                    if (arrayList2 != null) {
                        arrayList2.add(obj2);
                    }
                } else {
                    List arrayList22 = list;
                }
                i++;
                Object list22 = arrayList;
                Object list3 = arrayList22;
            }
        } else {
            list3 = null;
            list22 = null;
        }
        if (list22 == null && list3 == null) {
            this.C = null;
        } else {
            this.C = new o(list22, list3);
        }
    }

    public void i(h hVar) {
        boolean z = true;
        if (a) {
            Log.v("FragmentManager", "hide: " + hVar);
        }
        if (!hVar.z) {
            hVar.z = true;
            if (hVar.Q) {
                z = false;
            }
            hVar.Q = z;
        }
    }

    Parcelable j() {
        d[] dVarArr = null;
        A();
        B();
        e();
        this.s = true;
        this.C = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        q[] qVarArr = new q[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            h hVar = (h) this.f.valueAt(i);
            if (hVar != null) {
                if (hVar.e < 0) {
                    a(new IllegalStateException("Failure saving state: active " + hVar + " has cleared index: " + hVar.e));
                }
                q qVar = new q(hVar);
                qVarArr[i] = qVar;
                if (hVar.b <= 0 || qVar.k != null) {
                    qVar.k = hVar.c;
                } else {
                    qVar.k = n(hVar);
                    if (hVar.h != null) {
                        if (hVar.h.e < 0) {
                            a(new IllegalStateException("Failure saving state: " + hVar + " has target not in fragment manager: " + hVar.h));
                        }
                        if (qVar.k == null) {
                            qVar.k = new Bundle();
                        }
                        a(qVar.k, "android:target_state", hVar.h);
                        if (hVar.j != 0) {
                            qVar.k.putInt("android:target_req_state", hVar.j);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + hVar + ": " + qVar.k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            i = this.e.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((h) this.e.get(i2)).e;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.e.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.e.get(i2));
                    }
                }
            } else {
                iArr = null;
            }
            if (this.g != null) {
                i = this.g.size();
                if (i > 0) {
                    dVarArr = new d[i];
                    for (i2 = 0; i2 < i; i2++) {
                        dVarArr[i2] = new d((c) this.g.get(i2));
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.g.get(i2));
                        }
                    }
                }
            }
            p pVar = new p();
            pVar.a = qVarArr;
            pVar.b = iArr;
            pVar.c = dVarArr;
            if (this.p != null) {
                pVar.d = this.p.e;
            }
            pVar.e = this.d;
            i();
            return pVar;
        } else if (!a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void j(h hVar) {
        boolean z = false;
        if (a) {
            Log.v("FragmentManager", "show: " + hVar);
        }
        if (hVar.z) {
            hVar.z = false;
            if (!hVar.Q) {
                z = true;
            }
            hVar.Q = z;
        }
    }

    public void k() {
        this.C = null;
        this.s = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.e.get(i);
            if (hVar != null) {
                hVar.E();
            }
        }
    }

    public void k(h hVar) {
        if (a) {
            Log.v("FragmentManager", "detach: " + hVar);
        }
        if (!hVar.A) {
            hVar.A = true;
            if (hVar.k) {
                if (a) {
                    Log.v("FragmentManager", "remove from detach: " + hVar);
                }
                synchronized (this.e) {
                    this.e.remove(hVar);
                }
                if (hVar.D && hVar.E) {
                    this.r = true;
                }
                hVar.k = false;
            }
        }
    }

    public void l() {
        this.s = false;
        e(1);
    }

    public void l(h hVar) {
        if (a) {
            Log.v("FragmentManager", "attach: " + hVar);
        }
        if (hVar.A) {
            hVar.A = false;
            if (!hVar.k) {
                if (this.e.contains(hVar)) {
                    throw new IllegalStateException("Fragment already added: " + hVar);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + hVar);
                }
                synchronized (this.e) {
                    this.e.add(hVar);
                }
                hVar.k = true;
                if (hVar.D && hVar.E) {
                    this.r = true;
                }
            }
        }
    }

    public void m() {
        this.s = false;
        e(2);
    }

    void m(h hVar) {
        if (hVar.I != null) {
            if (this.A == null) {
                this.A = new SparseArray();
            } else {
                this.A.clear();
            }
            hVar.I.saveHierarchyState(this.A);
            if (this.A.size() > 0) {
                hVar.d = this.A;
                this.A = null;
            }
        }
    }

    Bundle n(h hVar) {
        Bundle bundle;
        if (this.z == null) {
            this.z = new Bundle();
        }
        hVar.m(this.z);
        d(hVar, this.z, false);
        if (this.z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.z;
            this.z = null;
        }
        if (hVar.H != null) {
            m(hVar);
        }
        if (hVar.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", hVar.d);
        }
        if (!hVar.K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", hVar.K);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        e(4);
    }

    public void o() {
        this.s = false;
        e(5);
    }

    public void o(h hVar) {
        if (hVar == null || (this.f.get(hVar.e) == hVar && (hVar.s == null || hVar.f() == this))) {
            this.p = hVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + hVar + " is not an active fragment of FragmentManager " + this);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!h.a(this.m.g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        h hVar;
        h b = resourceId != -1 ? b(resourceId) : null;
        if (b == null && string2 != null) {
            b = a(string2);
        }
        if (b == null && id != -1) {
            b = b(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            h a = this.n.a(context, string, null);
            a.m = true;
            a.w = resourceId != 0 ? resourceId : id;
            a.x = id;
            a.y = string2;
            a.n = true;
            a.r = this;
            a.s = this.m;
            a.a(this.m.g(), attributeSet, a.c);
            a(a, true);
            hVar = a;
        } else if (b.n) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.n = true;
            b.s = this.m;
            if (!b.C) {
                b.a(this.m.g(), attributeSet, b.c);
            }
            hVar = b;
        }
        if (this.l >= 1 || !hVar.m) {
            b(hVar);
        } else {
            a(hVar, 1, 0, 0, false);
        }
        if (hVar.H == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            hVar.H.setId(resourceId);
        }
        if (hVar.H.getTag() == null) {
            hVar.H.setTag(string2);
        }
        return hVar.H;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void p() {
        e(4);
    }

    public void q() {
        this.s = true;
        e(3);
    }

    public void r() {
        e(2);
    }

    public void s() {
        e(1);
    }

    public void t() {
        this.t = true;
        e();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.o != null) {
            android.support.v4.g.d.a(this.o, stringBuilder);
        } else {
            android.support.v4.g.d.a(this.m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                h hVar = (h) this.e.get(i2);
                if (hVar != null) {
                    hVar.F();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public h v() {
        return this.p;
    }

    Factory2 w() {
        return this;
    }
}
