package android.support.v4.a;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.d;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.k;
import android.support.v4.h.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class h implements android.arch.lifecycle.c, ComponentCallbacks, OnCreateContextMenuListener {
    private static final k<String, Class<?>> V = new k();
    static final Object a = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E = true;
    boolean F;
    ViewGroup G;
    View H;
    View I;
    boolean J;
    boolean K = true;
    v L;
    boolean M;
    boolean N;
    a O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    d U = new d(this);
    int b = 0;
    Bundle c;
    SparseArray<Parcelable> d;
    int e = -1;
    String f;
    Bundle g;
    h h;
    int i = -1;
    int j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;
    n r;
    l s;
    n t;
    o u;
    h v;
    int w;
    int x;
    String y;
    boolean z;

    static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        y g = null;
        y h = null;
        boolean i;
        c j;
        boolean k;
        private Object l = null;
        private Object m = h.a;
        private Object n = null;
        private Object o = h.a;
        private Object p = null;
        private Object q = h.a;
        private Boolean r;
        private Boolean s;

        a() {
        }
    }

    public static class b extends RuntimeException {
        public b(String str, Exception exception) {
            super(str, exception);
        }
    }

    interface c {
        void a();

        void b();
    }

    private void W() {
        c cVar = null;
        if (this.O != null) {
            this.O.i = false;
            c cVar2 = this.O.j;
            this.O.j = null;
            cVar = cVar2;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    private a X() {
        if (this.O == null) {
            this.O = new a();
        }
        return this.O;
    }

    public static h a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                V.put(str, cls);
            }
            h hVar = (h) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(hVar.getClass().getClassLoader());
                hVar.b(bundle);
            }
            return hVar;
        } catch (Exception e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        } catch (Exception e222) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e222);
        } catch (Exception e2222) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e2222);
        }
    }

    static boolean a(Context context, String str) {
        try {
            Class cls = (Class) V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                V.put(str, cls);
            }
            return h.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public void A() {
        if (this.r == null || this.r.m == null) {
            X().i = false;
        } else if (Looper.myLooper() != this.r.m.h().getLooper()) {
            this.r.m.h().postAtFrontOfQueue(new Runnable(this) {
                final /* synthetic */ h a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.W();
                }
            });
        } else {
            W();
        }
    }

    void B() {
        if (this.s == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.t = new n();
        this.t.a(this.s, new j(this) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public h a(Context context, String str, Bundle bundle) {
                return this.a.s.a(context, str, bundle);
            }

            public View a(int i) {
                if (this.a.H != null) {
                    return this.a.H.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean a() {
                return this.a.H != null;
            }
        }, this);
    }

    void C() {
        if (this.t != null) {
            this.t.k();
            this.t.e();
        }
        this.b = 4;
        this.F = false;
        j();
        if (this.F) {
            if (this.t != null) {
                this.t.n();
            }
            if (this.L != null) {
                this.L.g();
            }
            this.U.a(android.arch.lifecycle.b.a.ON_START);
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onStart()");
    }

    void D() {
        if (this.t != null) {
            this.t.k();
            this.t.e();
        }
        this.b = 5;
        this.F = false;
        k();
        if (this.F) {
            if (this.t != null) {
                this.t.o();
                this.t.e();
            }
            this.U.a(android.arch.lifecycle.b.a.ON_RESUME);
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onResume()");
    }

    void E() {
        if (this.t != null) {
            this.t.k();
        }
    }

    void F() {
        onLowMemory();
        if (this.t != null) {
            this.t.u();
        }
    }

    void G() {
        this.U.a(android.arch.lifecycle.b.a.ON_PAUSE);
        if (this.t != null) {
            this.t.p();
        }
        this.b = 4;
        this.F = false;
        l();
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void H() {
        this.U.a(android.arch.lifecycle.b.a.ON_STOP);
        if (this.t != null) {
            this.t.q();
        }
        this.b = 3;
        this.F = false;
        m();
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void I() {
        if (this.t != null) {
            this.t.r();
        }
        this.b = 2;
        if (this.M) {
            this.M = false;
            if (!this.N) {
                this.N = true;
                this.L = this.s.a(this.f, this.M, false);
            }
            if (this.L == null) {
                return;
            }
            if (this.s.j()) {
                this.L.d();
            } else {
                this.L.c();
            }
        }
    }

    void J() {
        if (this.t != null) {
            this.t.s();
        }
        this.b = 1;
        this.F = false;
        n();
        if (this.F) {
            if (this.L != null) {
                this.L.f();
            }
            this.p = false;
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    void K() {
        this.U.a(android.arch.lifecycle.b.a.ON_DESTROY);
        if (this.t != null) {
            this.t.t();
        }
        this.b = 0;
        this.F = false;
        this.T = false;
        o();
        if (this.F) {
            this.t = null;
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void L() {
        this.F = false;
        q();
        this.S = null;
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.t == null) {
        } else {
            if (this.C) {
                this.t.t();
                this.t = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }

    int M() {
        return this.O == null ? 0 : this.O.d;
    }

    int N() {
        return this.O == null ? 0 : this.O.e;
    }

    int O() {
        return this.O == null ? 0 : this.O.f;
    }

    y P() {
        return this.O == null ? null : this.O.g;
    }

    y Q() {
        return this.O == null ? null : this.O.h;
    }

    View R() {
        return this.O == null ? null : this.O.a;
    }

    Animator S() {
        return this.O == null ? null : this.O.b;
    }

    int T() {
        return this.O == null ? 0 : this.O.c;
    }

    boolean U() {
        return this.O == null ? false : this.O.i;
    }

    boolean V() {
        return this.O == null ? false : this.O.k;
    }

    public android.arch.lifecycle.b a() {
        return this.U;
    }

    h a(String str) {
        return str.equals(this.f) ? this : this.t != null ? this.t.b(str) : null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    void a(int i) {
        if (this.O != null || i != 0) {
            X().d = i;
        }
    }

    void a(int i, int i2) {
        if (this.O != null || i != 0 || i2 != 0) {
            X();
            this.O.e = i;
            this.O.f = i2;
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    final void a(int i, h hVar) {
        this.e = i;
        if (hVar != null) {
            this.f = hVar.f + ":" + this.e;
        } else {
            this.f = "android:fragment:" + this.e;
        }
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    void a(Animator animator) {
        X().b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.F = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void a(Context context) {
        this.F = true;
        Activity f = this.s == null ? null : this.s.f();
        if (f != null) {
            this.F = false;
            a(f);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        Activity f = this.s == null ? null : this.s.f();
        if (f != null) {
            this.F = false;
            a(f, attributeSet, bundle);
        }
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.t != null) {
            this.t.a(configuration);
        }
    }

    final void a(Bundle bundle) {
        if (this.d != null) {
            this.I.restoreHierarchyState(this.d);
            this.d = null;
        }
        this.F = false;
        i(bundle);
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    void a(c cVar) {
        X();
        if (cVar != this.O.j) {
            if (cVar == null || this.O.j == null) {
                if (this.O.i) {
                    this.O.j = cVar;
                }
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void a(h hVar) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    void a(View view) {
        X().a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mIndex=");
        printWriter.print(this.e);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.K);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.r);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.h);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (M() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(M());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.H);
        }
        if (R() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(R());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(T());
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.L.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.t + ":");
            this.t.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.t != null) {
            this.t.k();
        }
        this.p = true;
        return a(layoutInflater, viewGroup, bundle);
    }

    void b(int i) {
        X().c = i;
    }

    public void b(Bundle bundle) {
        if (this.e < 0 || !c()) {
            this.g = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    final boolean b() {
        return this.q > 0;
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            a(menu, menuInflater);
        }
        return this.t != null ? z | this.t.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater c(Bundle bundle) {
        return e(bundle);
    }

    public void c(boolean z) {
    }

    public final boolean c() {
        return this.r == null ? false : this.r.c();
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            a(menu);
        }
        return this.t != null ? z | this.t.a(menu) : z;
    }

    boolean c(MenuItem menuItem) {
        if (!this.z) {
            if (this.D && this.E && a(menuItem)) {
                return true;
            }
            if (this.t != null && this.t.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final i d() {
        return this.s == null ? null : (i) this.s.f();
    }

    LayoutInflater d(Bundle bundle) {
        this.S = c(bundle);
        return this.S;
    }

    void d(Menu menu) {
        if (!this.z) {
            if (this.D && this.E) {
                b(menu);
            }
            if (this.t != null) {
                this.t.b(menu);
            }
        }
    }

    void d(boolean z) {
        b(z);
        if (this.t != null) {
            this.t.a(z);
        }
    }

    boolean d(MenuItem menuItem) {
        if (!this.z) {
            if (b(menuItem)) {
                return true;
            }
            if (this.t != null && this.t.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final Resources e() {
        if (this.s != null) {
            return this.s.g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater e(Bundle bundle) {
        if (this.s == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater b = this.s.b();
        g();
        e.b(b, this.t.w());
        return b;
    }

    void e(boolean z) {
        c(z);
        if (this.t != null) {
            this.t.b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final m f() {
        return this.r;
    }

    public void f(Bundle bundle) {
        this.F = true;
        g(bundle);
        if (this.t != null && !this.t.a(1)) {
            this.t.l();
        }
    }

    void f(boolean z) {
        X().k = z;
    }

    public final m g() {
        if (this.t == null) {
            B();
            if (this.b >= 5) {
                this.t.o();
            } else if (this.b >= 4) {
                this.t.n();
            } else if (this.b >= 2) {
                this.t.m();
            } else if (this.b >= 1) {
                this.t.l();
            }
        }
        return this.t;
    }

    void g(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.t == null) {
                    B();
                }
                this.t.a(parcelable, this.u);
                this.u = null;
                this.t.l();
            }
        }
    }

    m h() {
        return this.t;
    }

    public void h(Bundle bundle) {
        this.F = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public View i() {
        return this.H;
    }

    public void i(Bundle bundle) {
        this.F = true;
    }

    public void j() {
        this.F = true;
        if (!this.M) {
            this.M = true;
            if (!this.N) {
                this.N = true;
                this.L = this.s.a(this.f, this.M, false);
            } else if (this.L != null) {
                this.L.b();
            }
        }
    }

    public void j(Bundle bundle) {
    }

    public void k() {
        this.F = true;
    }

    void k(Bundle bundle) {
        if (this.t != null) {
            this.t.k();
        }
        this.b = 1;
        this.F = false;
        f(bundle);
        this.T = true;
        if (this.F) {
            this.U.a(android.arch.lifecycle.b.a.ON_CREATE);
            return;
        }
        throw new z("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void l() {
        this.F = true;
    }

    void l(Bundle bundle) {
        if (this.t != null) {
            this.t.k();
        }
        this.b = 2;
        this.F = false;
        h(bundle);
        if (!this.F) {
            throw new z("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.t != null) {
            this.t.m();
        }
    }

    public void m() {
        this.F = true;
    }

    void m(Bundle bundle) {
        j(bundle);
        if (this.t != null) {
            Parcelable j = this.t.j();
            if (j != null) {
                bundle.putParcelable("android:support:fragments", j);
            }
        }
    }

    public void n() {
        this.F = true;
    }

    public void o() {
        this.F = true;
        if (!this.N) {
            this.N = true;
            this.L = this.s.a(this.f, this.M, false);
        }
        if (this.L != null) {
            this.L.h();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        d().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.F = true;
    }

    void p() {
        this.e = -1;
        this.f = null;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = 0;
        this.r = null;
        this.t = null;
        this.s = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
        this.C = false;
        this.L = null;
        this.M = false;
        this.N = false;
    }

    public void q() {
        this.F = true;
    }

    public void r() {
    }

    public Object s() {
        return this.O == null ? null : this.O.l;
    }

    public Object t() {
        return this.O == null ? null : this.O.m == a ? s() : this.O.m;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        android.support.v4.g.d.a(this, stringBuilder);
        if (this.e >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.e);
        }
        if (this.w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object u() {
        return this.O == null ? null : this.O.n;
    }

    public Object v() {
        return this.O == null ? null : this.O.o == a ? u() : this.O.o;
    }

    public Object w() {
        return this.O == null ? null : this.O.p;
    }

    public Object x() {
        return this.O == null ? null : this.O.q == a ? w() : this.O.q;
    }

    public boolean y() {
        return (this.O == null || this.O.s == null) ? true : this.O.s.booleanValue();
    }

    public boolean z() {
        return (this.O == null || this.O.r == null) ? true : this.O.r.booleanValue();
    }
}
