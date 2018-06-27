package android.support.v4.a;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class c extends r implements f {
    static final boolean a = (VERSION.SDK_INT >= 21);
    final n b;
    ArrayList<a> c = new ArrayList();
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    boolean k = true;
    String l;
    boolean m;
    int n = -1;
    int o;
    CharSequence p;
    int q;
    CharSequence r;
    ArrayList<String> s;
    ArrayList<String> t;
    boolean u = false;
    ArrayList<Runnable> v;

    static final class a {
        int a;
        h b;
        int c;
        int d;
        int e;
        int f;

        a() {
        }

        a(int i, h hVar) {
            this.a = i;
            this.b = hVar;
        }
    }

    public c(n nVar) {
        this.b = nVar;
    }

    private static boolean b(a aVar) {
        h hVar = aVar.b;
        return (hVar == null || !hVar.k || hVar.H == null || hVar.A || hVar.z || !hVar.U()) ? false : true;
    }

    h a(ArrayList<h> arrayList, h hVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return hVar;
            }
            a aVar = (a) this.c.get(i2);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    h hVar2 = aVar.b;
                    int i3 = hVar2.x;
                    Object obj = null;
                    int size = arrayList.size() - 1;
                    h hVar3 = hVar;
                    int i4 = i2;
                    while (size >= 0) {
                        Object obj2;
                        h hVar4 = (h) arrayList.get(size);
                        if (hVar4.x != i3) {
                            obj2 = obj;
                        } else if (hVar4 == hVar2) {
                            obj2 = 1;
                        } else {
                            if (hVar4 == hVar3) {
                                this.c.add(i4, new a(9, hVar4));
                                i4++;
                                hVar3 = null;
                            }
                            a aVar2 = new a(3, hVar4);
                            aVar2.c = aVar.c;
                            aVar2.e = aVar.e;
                            aVar2.d = aVar.d;
                            aVar2.f = aVar.f;
                            this.c.add(i4, aVar2);
                            arrayList.remove(hVar4);
                            i4++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.c.remove(i4);
                        i4--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(hVar2);
                    }
                    i2 = i4;
                    hVar = hVar3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b != hVar) {
                        break;
                    }
                    this.c.add(i2, new a(9, aVar.b));
                    i2++;
                    hVar = null;
                    break;
                case 8:
                    this.c.add(i2, new a(9, hVar));
                    i2++;
                    hVar = aVar.b;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    public void a() {
        if (this.v != null) {
            int size = this.v.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.v.get(i)).run();
            }
            this.v = null;
        }
    }

    void a(int i) {
        if (this.j) {
            if (n.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.c.get(i2);
                if (aVar.b != null) {
                    h hVar = aVar.b;
                    hVar.q += i;
                    if (n.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.q);
                    }
                }
            }
        }
    }

    void a(a aVar) {
        this.c.add(aVar);
        aVar.c = this.d;
        aVar.d = this.e;
        aVar.e = this.f;
        aVar.f = this.g;
    }

    void a(c cVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                a aVar = (a) this.c.get(i2);
                if (b(aVar)) {
                    aVar.b.a(cVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.n);
            printWriter.print(" mCommitted=");
            printWriter.println(this.m);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (!(this.d == 0 && this.e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.p);
            }
            if (!(this.q == 0 && this.r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.r);
            }
        }
        if (!this.c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                String str2;
                a aVar = (a) this.c.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    void a(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            a aVar = (a) this.c.get(size);
            h hVar = aVar.b;
            if (hVar != null) {
                hVar.a(n.d(this.h), this.i);
            }
            switch (aVar.a) {
                case 1:
                    hVar.a(aVar.f);
                    this.b.h(hVar);
                    break;
                case 3:
                    hVar.a(aVar.e);
                    this.b.a(hVar, false);
                    break;
                case 4:
                    hVar.a(aVar.e);
                    this.b.j(hVar);
                    break;
                case 5:
                    hVar.a(aVar.f);
                    this.b.i(hVar);
                    break;
                case 6:
                    hVar.a(aVar.e);
                    this.b.l(hVar);
                    break;
                case 7:
                    hVar.a(aVar.f);
                    this.b.k(hVar);
                    break;
                case 8:
                    this.b.o(null);
                    break;
                case 9:
                    this.b.o(hVar);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
            }
            if (!(this.u || aVar.a == 3 || hVar == null)) {
                this.b.e(hVar);
            }
        }
        if (!this.u && z) {
            this.b.a(this.b.l, true);
        }
    }

    boolean a(ArrayList<c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.c.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            a aVar = (a) this.c.get(i4);
            int i6 = aVar.b != null ? aVar.b.x : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    c cVar = (c) arrayList.get(i7);
                    int size2 = cVar.c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        a aVar2 = (a) cVar.c.get(i8);
                        if ((aVar2.b != null ? aVar2.b.x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (n.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.j) {
            this.b.a(this);
        }
        return true;
    }

    h b(ArrayList<h> arrayList, h hVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return hVar;
            }
            a aVar = (a) this.c.get(i2);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.remove(aVar.b);
                    break;
                case 3:
                case 6:
                    arrayList.add(aVar.b);
                    break;
                case 8:
                    hVar = null;
                    break;
                case 9:
                    hVar = aVar.b;
                    break;
                default:
                    break;
            }
            i = i2 + 1;
        }
    }

    void b() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.c.get(i);
            h hVar = aVar.b;
            if (hVar != null) {
                hVar.a(this.h, this.i);
            }
            switch (aVar.a) {
                case 1:
                    hVar.a(aVar.c);
                    this.b.a(hVar, false);
                    break;
                case 3:
                    hVar.a(aVar.d);
                    this.b.h(hVar);
                    break;
                case 4:
                    hVar.a(aVar.d);
                    this.b.i(hVar);
                    break;
                case 5:
                    hVar.a(aVar.c);
                    this.b.j(hVar);
                    break;
                case 6:
                    hVar.a(aVar.d);
                    this.b.k(hVar);
                    break;
                case 7:
                    hVar.a(aVar.c);
                    this.b.l(hVar);
                    break;
                case 8:
                    this.b.o(hVar);
                    break;
                case 9:
                    this.b.o(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
            }
            if (!(this.u || aVar.a == 1 || hVar == null)) {
                this.b.e(hVar);
            }
        }
        if (!this.u) {
            this.b.a(this.b.l, true);
        }
    }

    boolean b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.c.get(i2);
            int i3 = aVar.b != null ? aVar.b.x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean c() {
        for (int i = 0; i < this.c.size(); i++) {
            if (b((a) this.c.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.n >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.n);
        }
        if (this.l != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.l);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
