package android.support.v4.a;

import android.os.Bundle;
import android.support.v4.b.b.b;
import android.support.v4.g.d;
import android.support.v4.g.l;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class v extends u {
    static boolean a = false;
    final l<a> b = new l();
    final l<a> c = new l();
    final String d;
    boolean e;
    boolean f;
    l g;

    final class a implements android.support.v4.b.b.a<Object>, b<Object> {
        final int a;
        final Bundle b;
        android.support.v4.a.u.a<Object> c;
        android.support.v4.b.b<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ v o;

        void a() {
            if (this.i && this.j) {
                this.h = true;
            } else if (!this.h) {
                this.h = true;
                if (v.a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.d == null && this.c != null) {
                    this.d = this.c.a(this.a, this.b);
                }
                if (this.d == null) {
                    return;
                }
                if (!this.d.getClass().isMemberClass() || Modifier.isStatic(this.d.getClass().getModifiers())) {
                    if (!this.m) {
                        this.d.a(this.a, this);
                        this.d.a((android.support.v4.b.b.a) this);
                        this.m = true;
                    }
                    this.d.a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
            }
        }

        void a(android.support.v4.b.b<Object> bVar, Object obj) {
            String str;
            if (this.c != null) {
                if (this.o.g != null) {
                    String str2 = this.o.g.d.u;
                    this.o.g.d.u = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (v.a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.a(obj));
                    }
                    this.c.a((android.support.v4.b.b) bVar, obj);
                    this.f = true;
                } finally {
                    if (this.o.g != null) {
                        this.o.g.d.u = str;
                    }
                }
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void b() {
            if (v.a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void c() {
            if (this.i) {
                if (v.a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                if (!(this.h == this.j || this.h)) {
                    e();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e && !this.i) {
                    a(this.d, this.g);
                }
            }
        }

        void e() {
            if (v.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (!this.i && this.d != null && this.m) {
                this.m = false;
                this.d.a((b) this);
                this.d.b(this);
                this.d.c();
            }
        }

        void f() {
            String str;
            android.support.v4.a.u.a aVar = null;
            if (v.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z) {
                if (v.a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.o.g != null) {
                    String str2 = this.o.g.d.u;
                    this.o.g.d.u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    aVar = this.o.g;
                    if (aVar != null) {
                        aVar = this.o.g.d;
                        aVar.u = str;
                    }
                }
            }
            this.c = aVar;
            this.g = aVar;
            this.e = false;
            if (this.d != null) {
                if (this.m) {
                    this.m = false;
                    this.d.a((b) this);
                    this.d.b(this);
                }
                this.d.e();
            }
            if (this.n != null) {
                this.n.f();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.a);
            stringBuilder.append(" : ");
            d.a(this.d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    v(String str, l lVar, boolean z) {
        this.d = str;
        this.g = lVar;
        this.e = z;
    }

    void a(l lVar) {
        this.g = lVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a aVar;
        int i = 0;
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.b.b(); i2++) {
                aVar = (a) this.b.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                aVar = (a) this.c.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            a aVar = (a) this.b.e(i);
            int i2 = (!aVar.h || aVar.f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.e = true;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).a();
        }
    }

    void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.e) {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).e();
            }
            this.e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.e) {
            this.f = true;
            this.e = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void e() {
        if (this.f) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).c();
            }
        }
    }

    void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).k = true;
        }
    }

    void g() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((a) this.b.e(b)).d();
        }
    }

    void h() {
        int b;
        if (!this.f) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.b.b() - 1; b >= 0; b--) {
                ((a) this.b.e(b)).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((a) this.c.e(b)).f();
        }
        this.c.c();
        this.g = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
