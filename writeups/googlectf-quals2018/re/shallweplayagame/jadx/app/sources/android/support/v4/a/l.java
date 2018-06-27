package android.support.v4.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.g.k;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class l<E> extends j {
    private final Activity a;
    final Context b;
    final int c;
    final n d;
    private final Handler e;
    private k<String, u> f;
    private boolean g;
    private v h;
    private boolean i;
    private boolean j;

    l(Activity activity, Context context, Handler handler, int i) {
        this.d = new n();
        this.a = activity;
        this.b = context;
        this.e = handler;
        this.c = i;
    }

    l(i iVar) {
        this(iVar, iVar, iVar.c, 0);
    }

    v a(String str, boolean z, boolean z2) {
        if (this.f == null) {
            this.f = new k();
        }
        v vVar = (v) this.f.get(str);
        if (vVar == null && z2) {
            vVar = new v(str, this, z);
            this.f.put(str, vVar);
            return vVar;
        } else if (!z || vVar == null || vVar.e) {
            return vVar;
        } else {
            vVar.b();
            return vVar;
        }
    }

    public View a(int i) {
        return null;
    }

    void a(k<String, u> kVar) {
        if (kVar != null) {
            int size = kVar.size();
            for (int i = 0; i < size; i++) {
                ((v) kVar.c(i)).a(this);
            }
        }
        this.f = kVar;
    }

    void a(String str) {
        if (this.f != null) {
            v vVar = (v) this.f.get(str);
            if (vVar != null && !vVar.f) {
                vVar.h();
                this.f.remove(str);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void a(boolean z) {
        this.g = z;
        if (this.h != null && this.j) {
            this.j = false;
            if (z) {
                this.h.d();
            } else {
                this.h.c();
            }
        }
    }

    public boolean a() {
        return true;
    }

    public boolean a(h hVar) {
        return true;
    }

    public LayoutInflater b() {
        return (LayoutInflater) this.b.getSystemService("layout_inflater");
    }

    void b(h hVar) {
    }

    void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.j);
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
            printWriter.println(":");
            this.h.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.c;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.b;
    }

    Handler h() {
        return this.e;
    }

    n i() {
        return this.d;
    }

    boolean j() {
        return this.g;
    }

    void k() {
        if (!this.j) {
            this.j = true;
            if (this.h != null) {
                this.h.b();
            } else if (!this.i) {
                this.h = a("(root)", this.j, false);
                if (!(this.h == null || this.h.e)) {
                    this.h.b();
                }
            }
            this.i = true;
        }
    }

    void l() {
        if (this.h != null) {
            this.h.h();
        }
    }

    void m() {
        if (this.f != null) {
            int size = this.f.size();
            v[] vVarArr = new v[size];
            for (int i = size - 1; i >= 0; i--) {
                vVarArr[i] = (v) this.f.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = vVarArr[i2];
                vVar.e();
                vVar.g();
            }
        }
    }

    k<String, u> n() {
        int i;
        int i2 = 0;
        if (this.f != null) {
            int size = this.f.size();
            v[] vVarArr = new v[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                vVarArr[i3] = (v) this.f.c(i3);
            }
            boolean j = j();
            i = 0;
            while (i2 < size) {
                v vVar = vVarArr[i2];
                if (!vVar.f && j) {
                    if (!vVar.e) {
                        vVar.b();
                    }
                    vVar.d();
                }
                if (vVar.f) {
                    i = 1;
                } else {
                    vVar.h();
                    this.f.remove(vVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f : null;
    }
}
