package android.support.constraint.a;

import android.support.constraint.a.g.a;
import java.util.Arrays;
import java.util.HashMap;

public class e {
    private static int d = 1000;
    int a;
    int b;
    final c c;
    private HashMap<String, g> e;
    private d f;
    private int g;
    private int h;
    private b[] i;
    private boolean[] j;
    private int k;
    private int l;
    private g[] m;
    private int n;
    private b[] o;

    public e() {
        this.a = 0;
        this.e = null;
        this.f = new d();
        this.g = 32;
        this.h = this.g;
        this.i = null;
        this.j = new boolean[this.g];
        this.b = 1;
        this.k = 0;
        this.l = this.g;
        this.m = new g[d];
        this.n = 0;
        this.o = new b[this.g];
        this.i = new b[this.g];
        h();
        this.c = new c();
    }

    public static b a(e eVar, g gVar, g gVar2, int i, float f, g gVar3, g gVar4, int i2, boolean z) {
        b b = eVar.b();
        b.a(gVar, gVar2, i, f, gVar3, gVar4, i2);
        if (z) {
            g d = eVar.d();
            g d2 = eVar.d();
            d.c = 4;
            d2.c = 4;
            b.a(d, d2);
        }
        return b;
    }

    public static b a(e eVar, g gVar, g gVar2, int i, boolean z) {
        b b = eVar.b();
        b.a(gVar, gVar2, i);
        if (z) {
            eVar.a(b, 1);
        }
        return b;
    }

    public static b a(e eVar, g gVar, g gVar2, g gVar3, float f, boolean z) {
        b b = eVar.b();
        if (z) {
            eVar.b(b);
        }
        return b.a(gVar, gVar2, gVar3, f);
    }

    private g a(a aVar) {
        g gVar;
        g gVar2 = (g) this.c.b.a();
        if (gVar2 == null) {
            gVar = new g(aVar);
        } else {
            gVar2.c();
            gVar2.a(aVar);
            gVar = gVar2;
        }
        if (this.n >= d) {
            d *= 2;
            this.m = (g[]) Arrays.copyOf(this.m, d);
        }
        g[] gVarArr = this.m;
        int i = this.n;
        this.n = i + 1;
        gVarArr[i] = gVar;
        return gVar;
    }

    private void a(b bVar, int i) {
        bVar.c(d(), i);
    }

    private int b(d dVar) {
        int i;
        for (i = 0; i < this.b; i++) {
            this.j[i] = false;
        }
        int i2 = 0;
        i = 0;
        boolean z = false;
        while (!z) {
            g gVar;
            int i3;
            float f;
            b bVar;
            float c;
            float f2;
            b bVar2;
            boolean z2;
            int i4 = i + 1;
            g a = dVar.a();
            if (a != null) {
                if (this.j[a.a]) {
                    gVar = null;
                    i3 = i2;
                } else {
                    this.j[a.a] = true;
                    i2++;
                    if (i2 >= this.b) {
                        gVar = a;
                        i3 = i2;
                        z = true;
                    }
                }
                if (gVar == null) {
                    i2 = -1;
                    f = Float.MAX_VALUE;
                    for (i = 0; i < this.k; i++) {
                        bVar = this.i[i];
                        if (bVar.a.f != a.UNRESTRICTED && bVar.a(gVar)) {
                            c = bVar.d.c(gVar);
                            if (c < 0.0f) {
                                f2 = (-bVar.b) / c;
                                if (f2 < f) {
                                    i2 = i;
                                    f = f2;
                                }
                            }
                        }
                    }
                    if (i2 <= -1) {
                        bVar2 = this.i[i2];
                        bVar2.a.b = -1;
                        bVar2.b(gVar);
                        bVar2.a.b = i2;
                        for (i = 0; i < this.k; i++) {
                            this.i[i].a(bVar2);
                        }
                        dVar.a(this);
                        try {
                            c(dVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        z2 = z;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                i2 = i3;
                z = z2;
                i = i4;
            }
            gVar = a;
            i3 = i2;
            if (gVar == null) {
                z2 = true;
            } else {
                i2 = -1;
                f = Float.MAX_VALUE;
                for (i = 0; i < this.k; i++) {
                    bVar = this.i[i];
                    c = bVar.d.c(gVar);
                    if (c < 0.0f) {
                        f2 = (-bVar.b) / c;
                        if (f2 < f) {
                            i2 = i;
                            f = f2;
                        }
                    }
                }
                if (i2 <= -1) {
                    z2 = true;
                } else {
                    bVar2 = this.i[i2];
                    bVar2.a.b = -1;
                    bVar2.b(gVar);
                    bVar2.a.b = i2;
                    for (i = 0; i < this.k; i++) {
                        this.i[i].a(bVar2);
                    }
                    dVar.a(this);
                    c(dVar);
                    z2 = z;
                }
            }
            i2 = i3;
            z = z2;
            i = i4;
        }
        return i;
    }

    public static b b(e eVar, g gVar, g gVar2, int i, boolean z) {
        g c = eVar.c();
        b b = eVar.b();
        b.a(gVar, gVar2, c, i);
        if (z) {
            eVar.a(b, (int) (b.d.c(c) * -1.0f));
        }
        return b;
    }

    private void b(b bVar) {
        bVar.a(d(), d());
    }

    private int c(d dVar) {
        Object obj;
        int i;
        int i2 = 0;
        while (i2 < this.k) {
            if (this.i[i2].a.f != a.UNRESTRICTED && this.i[i2].b < 0.0f) {
                obj = 1;
                break;
            }
            i2++;
        }
        obj = null;
        if (obj != null) {
            Object obj2 = null;
            i2 = 0;
            while (obj2 == null) {
                int i3 = i2 + 1;
                int i4 = 2139095039;
                int i5 = 0;
                int i6 = -1;
                i = -1;
                for (i2 = 0; i2 < this.k; i2++) {
                    b bVar = this.i[i2];
                    if (bVar.a.f != a.UNRESTRICTED && bVar.b < 0.0f) {
                        int i7 = i4;
                        i4 = i5;
                        i5 = i6;
                        i6 = i;
                        for (i = 1; i < this.b; i++) {
                            g gVar = this.c.c[i];
                            float c = bVar.d.c(gVar);
                            if (c > 0.0f) {
                                int i8 = 0;
                                int i9 = i7;
                                while (true) {
                                    i7 = i8;
                                    if (i7 >= 6) {
                                        break;
                                    }
                                    i8 = gVar.e[i7] / c;
                                    if ((i8 >= i9 || i7 != r6) && i7 <= r6) {
                                        i8 = i9;
                                    } else {
                                        i6 = i;
                                        i5 = i2;
                                        i4 = i7;
                                    }
                                    i7++;
                                }
                                i7 = i9;
                            }
                        }
                        i = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i7;
                    }
                }
                if (i6 != -1) {
                    b bVar2 = this.i[i6];
                    bVar2.a.b = -1;
                    bVar2.b(this.c.c[i]);
                    bVar2.a.b = i6;
                    for (i2 = 0; i2 < this.k; i2++) {
                        this.i[i2].a(bVar2);
                    }
                    dVar.a(this);
                    obj = obj2;
                } else {
                    obj = 1;
                }
                obj2 = obj;
                i2 = i3;
            }
        } else {
            i2 = 0;
        }
        i = 0;
        while (i < this.k && (this.i[i].a.f == a.UNRESTRICTED || this.i[i].b >= 0.0f)) {
            i++;
        }
        return i2;
    }

    public static b c(e eVar, g gVar, g gVar2, int i, boolean z) {
        g c = eVar.c();
        b b = eVar.b();
        b.b(gVar, gVar2, c, i);
        if (z) {
            eVar.a(b, (int) (b.d.c(c) * -1.0f));
        }
        return b;
    }

    private void c(b bVar) {
        if (this.k > 0) {
            bVar.d.a(bVar, this.i);
            if (bVar.d.a == 0) {
                bVar.e = true;
            }
        }
    }

    private void g() {
        this.g *= 2;
        this.i = (b[]) Arrays.copyOf(this.i, this.g);
        this.c.c = (g[]) Arrays.copyOf(this.c.c, this.g);
        this.j = new boolean[this.g];
        this.h = this.g;
        this.l = this.g;
        this.f.a.clear();
    }

    private void h() {
        for (int i = 0; i < this.i.length; i++) {
            Object obj = this.i[i];
            if (obj != null) {
                this.c.a.a(obj);
            }
            this.i[i] = null;
        }
    }

    private void i() {
        for (int i = 0; i < this.k; i++) {
            b bVar = this.i[i];
            bVar.a.d = bVar.b;
        }
    }

    b a(int i) {
        return this.i[i];
    }

    public g a(Object obj) {
        g gVar = null;
        if (obj != null) {
            if (this.b + 1 >= this.h) {
                g();
            }
            if (obj instanceof android.support.constraint.a.a.a) {
                gVar = ((android.support.constraint.a.a.a) obj).a();
                if (gVar == null) {
                    ((android.support.constraint.a.a.a) obj).a(this.c);
                    gVar = ((android.support.constraint.a.a.a) obj).a();
                }
                if (gVar.a == -1 || gVar.a > this.a || this.c.c[gVar.a] == null) {
                    if (gVar.a != -1) {
                        gVar.c();
                    }
                    this.a++;
                    this.b++;
                    gVar.a = this.a;
                    gVar.f = a.UNRESTRICTED;
                    this.c.c[this.a] = gVar;
                }
            }
        }
        return gVar;
    }

    public void a() {
        int i;
        for (g gVar : this.c.c) {
            if (gVar != null) {
                gVar.c();
            }
        }
        this.c.b.a(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.c.c, null);
        if (this.e != null) {
            this.e.clear();
        }
        this.a = 0;
        this.f.a.clear();
        this.b = 1;
        for (i = 0; i < this.k; i++) {
            this.i[i].c = false;
        }
        h();
        this.k = 0;
    }

    public void a(b bVar) {
        int i = 0;
        if (bVar != null) {
            if (this.k + 1 >= this.l || this.b + 1 >= this.h) {
                g();
            }
            if (!bVar.e) {
                c(bVar);
                bVar.e();
                bVar.f();
                if (!bVar.b()) {
                    return;
                }
            }
            if (this.i[this.k] != null) {
                this.c.a.a(this.i[this.k]);
            }
            if (!bVar.e) {
                bVar.a();
            }
            this.i[this.k] = bVar;
            bVar.a.b = this.k;
            this.k++;
            int i2 = bVar.a.h;
            if (i2 > 0) {
                while (this.o.length < i2) {
                    this.o = new b[(this.o.length * 2)];
                }
                b[] bVarArr = this.o;
                for (int i3 = 0; i3 < i2; i3++) {
                    bVarArr[i3] = bVar.a.g[i3];
                }
                while (i < i2) {
                    b bVar2 = bVarArr[i];
                    if (bVar2 != bVar) {
                        bVar2.d.a(bVar2, bVar);
                        bVar2.a();
                    }
                    i++;
                }
            }
        }
    }

    void a(d dVar) {
        dVar.a(this);
        c(dVar);
        b(dVar);
        i();
    }

    public void a(g gVar, int i) {
        int i2 = gVar.b;
        b bVar;
        if (gVar.b != -1) {
            bVar = this.i[i2];
            if (bVar.e) {
                bVar.b = (float) i;
                return;
            }
            bVar = b();
            bVar.b(gVar, i);
            a(bVar);
            return;
        }
        bVar = b();
        bVar.a(gVar, i);
        a(bVar);
    }

    public void a(g gVar, g gVar2, int i, float f, g gVar3, g gVar4, int i2, int i3) {
        b b = b();
        b.a(gVar, gVar2, i, f, gVar3, gVar4, i2);
        g d = d();
        g d2 = d();
        d.c = i3;
        d2.c = i3;
        b.a(d, d2);
        a(b);
    }

    public void a(g gVar, g gVar2, int i, int i2) {
        b b = b();
        g c = c();
        c.c = i2;
        b.a(gVar, gVar2, c, i);
        a(b);
    }

    public int b(Object obj) {
        g a = ((android.support.constraint.a.a.a) obj).a();
        return a != null ? (int) (a.d + 0.5f) : 0;
    }

    public b b() {
        b bVar = (b) this.c.a.a();
        if (bVar == null) {
            return new b(this.c);
        }
        bVar.d();
        return bVar;
    }

    public void b(g gVar, g gVar2, int i, int i2) {
        b b = b();
        g c = c();
        c.c = i2;
        b.b(gVar, gVar2, c, i);
        a(b);
    }

    public b c(g gVar, g gVar2, int i, int i2) {
        b b = b();
        b.a(gVar, gVar2, i);
        g d = d();
        g d2 = d();
        d.c = i2;
        d2.c = i2;
        b.a(d, d2);
        a(b);
        return b;
    }

    public g c() {
        if (this.b + 1 >= this.h) {
            g();
        }
        g a = a(a.SLACK);
        this.a++;
        this.b++;
        a.a = this.a;
        this.c.c[this.a] = a;
        return a;
    }

    public g d() {
        if (this.b + 1 >= this.h) {
            g();
        }
        g a = a(a.ERROR);
        this.a++;
        this.b++;
        a.a = this.a;
        this.c.c[this.a] = a;
        return a;
    }

    public void e() {
        a(this.f);
    }

    public c f() {
        return this.c;
    }
}
