package android.support.constraint.a.a;

import android.support.constraint.a.a.a.c;
import android.support.constraint.a.e;
import android.support.constraint.a.g;
import java.util.ArrayList;

public class b {
    public static float D = 0.5f;
    int A = 0;
    protected int B;
    protected int C;
    float E = D;
    float F = D;
    a G = a.FIXED;
    a H = a.FIXED;
    int I;
    int J;
    int K;
    int L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    boolean Q;
    boolean R;
    int S = 0;
    int T = 0;
    boolean U;
    boolean V;
    float W = 0.0f;
    float X = 0.0f;
    b Y = null;
    b Z = null;
    public int a = -1;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private int ae = 0;
    private int af = 0;
    private int ag = 0;
    private int ah = 0;
    private int ai;
    private int aj;
    private Object ak;
    private int al = 0;
    private int am = 0;
    private String an = null;
    private String ao = null;
    public int b = -1;
    int c = 0;
    int d = 0;
    int e = 0;
    int f = 0;
    int g = 0;
    int h = 0;
    a i = new a(this, c.LEFT);
    a j = new a(this, c.TOP);
    a k = new a(this, c.RIGHT);
    a l = new a(this, c.BOTTOM);
    a m = new a(this, c.BASELINE);
    a n = new a(this, c.CENTER_X);
    a o = new a(this, c.CENTER_Y);
    a p = new a(this, c.CENTER);
    protected ArrayList<a> q = new ArrayList();
    b r = null;
    int s = 0;
    int t = 0;
    protected float u = 0.0f;
    protected int v = -1;
    protected int w = 0;
    protected int x = 0;
    protected int y = 0;
    protected int z = 0;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public b() {
        D();
    }

    private void D() {
        this.q.add(this.i);
        this.q.add(this.j);
        this.q.add(this.k);
        this.q.add(this.l);
        this.q.add(this.n);
        this.q.add(this.o);
        this.q.add(this.m);
    }

    private void a(e eVar, boolean z, boolean z2, a aVar, a aVar2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7) {
        int i8;
        g a = eVar.a((Object) aVar);
        g a2 = eVar.a((Object) aVar2);
        g a3 = eVar.a(aVar.f());
        g a4 = eVar.a(aVar2.f());
        int d = aVar.d();
        int d2 = aVar2.d();
        if (this.am == 8) {
            i8 = 0;
            z2 = true;
        } else {
            i8 = i3;
        }
        if (a3 == null && a4 == null) {
            eVar.a(eVar.b().b(a, i));
            if (!z3) {
                if (z) {
                    eVar.a(e.a(eVar, a2, a, i4, true));
                } else if (z2) {
                    eVar.a(e.a(eVar, a2, a, i8, false));
                } else {
                    eVar.a(eVar.b().b(a2, i2));
                }
            }
        } else if (a3 != null && a4 == null) {
            eVar.a(eVar.b().a(a, a3, d));
            if (z) {
                eVar.a(e.a(eVar, a2, a, i4, true));
            } else if (!z3) {
                if (z2) {
                    eVar.a(eVar.b().a(a2, a, i8));
                } else {
                    eVar.a(eVar.b().b(a2, i2));
                }
            }
        } else if (a3 == null && a4 != null) {
            eVar.a(eVar.b().a(a2, a4, d2 * -1));
            if (z) {
                eVar.a(e.a(eVar, a2, a, i4, true));
            } else if (!z3) {
                if (z2) {
                    eVar.a(eVar.b().a(a2, a, i8));
                } else {
                    eVar.a(eVar.b().b(a, i));
                }
            }
        } else if (z2) {
            if (z) {
                eVar.a(e.a(eVar, a2, a, i4, true));
            } else {
                eVar.a(eVar.b().a(a2, a, i8));
            }
            if (aVar.e() != aVar2.e()) {
                g c;
                if (aVar.e() == android.support.constraint.a.a.a.b.STRONG) {
                    eVar.a(eVar.b().a(a, a3, d));
                    c = eVar.c();
                    android.support.constraint.a.b b = eVar.b();
                    b.b(a2, a4, c, d2 * -1);
                    eVar.a(b);
                    return;
                }
                c = eVar.c();
                android.support.constraint.a.b b2 = eVar.b();
                b2.a(a, a3, c, d);
                eVar.a(b2);
                eVar.a(eVar.b().a(a2, a4, d2 * -1));
            } else if (a3 == a4) {
                eVar.a(e.a(eVar, a, a3, 0, 0.5f, a4, a2, 0, true));
            } else if (!z4) {
                eVar.a(e.b(eVar, a, a3, d, aVar.g() != android.support.constraint.a.a.a.a.STRICT));
                eVar.a(e.c(eVar, a2, a4, d2 * -1, aVar2.g() != android.support.constraint.a.a.a.a.STRICT));
                eVar.a(e.a(eVar, a, a3, d, f, a4, a2, d2, false));
            }
        } else if (z3) {
            eVar.a(a, a3, d, 3);
            eVar.b(a2, a4, d2 * -1, 3);
            eVar.a(e.a(eVar, a, a3, d, f, a4, a2, d2, true));
        } else if (!z4) {
            if (i5 == 1) {
                if (i6 > i8) {
                    i8 = i6;
                }
                if (i7 > 0) {
                    if (i7 >= i8) {
                        eVar.b(a2, a, i7, 3);
                    }
                    eVar.c(a2, a, i7, 3);
                    eVar.a(a, a3, d, 2);
                    eVar.b(a2, a4, -d2, 2);
                    eVar.a(a, a3, d, f, a4, a2, d2, 4);
                }
                i7 = i8;
                eVar.c(a2, a, i7, 3);
                eVar.a(a, a3, d, 2);
                eVar.b(a2, a4, -d2, 2);
                eVar.a(a, a3, d, f, a4, a2, d2, 4);
            } else if (i6 == 0 && i7 == 0) {
                eVar.a(eVar.b().a(a, a3, d));
                eVar.a(eVar.b().a(a2, a4, d2 * -1));
            } else {
                if (i7 > 0) {
                    eVar.b(a2, a, i7, 3);
                }
                eVar.a(a, a3, d, 2);
                eVar.b(a2, a4, -d2, 2);
                eVar.a(a, a3, d, f, a4, a2, d2, 4);
            }
        }
    }

    public void A() {
        b c = c();
        if (c == null || !(c instanceof c) || !((c) c()).G()) {
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                ((a) this.q.get(i)).i();
            }
        }
    }

    public a B() {
        return this.G;
    }

    public a C() {
        return this.H;
    }

    public a a(c cVar) {
        switch (cVar) {
            case LEFT:
                return this.i;
            case TOP:
                return this.j;
            case RIGHT:
                return this.k;
            case BOTTOM:
                return this.l;
            case BASELINE:
                return this.m;
            case CENTER_X:
                return this.n;
            case CENTER_Y:
                return this.o;
            case CENTER:
                return this.p;
            default:
                return null;
        }
    }

    public void a() {
        this.i.i();
        this.j.i();
        this.k.i();
        this.l.i();
        this.m.i();
        this.n.i();
        this.o.i();
        this.p.i();
        this.r = null;
        this.s = 0;
        this.t = 0;
        this.u = 0.0f;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.ah = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.ai = 0;
        this.aj = 0;
        this.E = D;
        this.F = D;
        this.G = a.FIXED;
        this.H = a.FIXED;
        this.ak = null;
        this.al = 0;
        this.am = 0;
        this.an = null;
        this.ao = null;
        this.Q = false;
        this.R = false;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = 0.0f;
        this.X = 0.0f;
        this.a = -1;
        this.b = -1;
    }

    public void a(float f) {
        this.E = f;
    }

    public void a(int i) {
        this.am = i;
    }

    public void a(int i, int i2) {
        this.w = i;
        this.x = i2;
    }

    public void a(int i, int i2, int i3) {
        this.c = i;
        this.e = i2;
        this.f = i3;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.w = i;
        this.x = i2;
        if (this.am == 8) {
            this.s = 0;
            this.t = 0;
            return;
        }
        if (this.G == a.FIXED && i5 < this.s) {
            i5 = this.s;
        }
        if (this.H == a.FIXED && i6 < this.t) {
            i6 = this.t;
        }
        this.s = i5;
        this.t = i6;
        if (this.t < this.C) {
            this.t = this.C;
        }
        if (this.s < this.B) {
            this.s = this.B;
        }
    }

    public void a(c cVar, b bVar, c cVar2, int i, int i2) {
        a(cVar).a(bVar.a(cVar2), i, i2, android.support.constraint.a.a.a.b.STRONG, 0, true);
    }

    public void a(a aVar) {
        this.G = aVar;
        if (this.G == a.WRAP_CONTENT) {
            d(this.ai);
        }
    }

    public void a(b bVar) {
        this.r = bVar;
    }

    public void a(android.support.constraint.a.c cVar) {
        this.i.a(cVar);
        this.j.a(cVar);
        this.k.a(cVar);
        this.l.a(cVar);
        this.m.a(cVar);
        this.p.a(cVar);
        this.n.a(cVar);
        this.o.a(cVar);
    }

    public void a(e eVar, int i) {
        g a;
        boolean z;
        boolean z2;
        float f;
        int i2;
        Object obj;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        a aVar;
        android.support.constraint.a.b b;
        g d;
        g a2 = (i == Integer.MAX_VALUE || this.i.g == i) ? eVar.a(this.i) : null;
        g a3 = (i == Integer.MAX_VALUE || this.k.g == i) ? eVar.a(this.k) : null;
        g a4 = (i == Integer.MAX_VALUE || this.j.g == i) ? eVar.a(this.j) : null;
        g a5 = (i == Integer.MAX_VALUE || this.l.g == i) ? eVar.a(this.l) : null;
        g a6 = (i == Integer.MAX_VALUE || this.m.g == i) ? eVar.a(this.m) : null;
        if (this.r != null) {
            boolean z5;
            boolean z6;
            android.support.constraint.a.b b2;
            if ((this.i.c == null || this.i.c.c != this.i) && (this.k.c == null || this.k.c.c != this.k)) {
                z5 = false;
            } else {
                ((c) this.r).a(this, 0);
                z5 = true;
            }
            if ((this.j.c == null || this.j.c.c != this.j) && (this.l.c == null || this.l.c.c != this.l)) {
                z6 = false;
            } else {
                ((c) this.r).a(this, 1);
                z6 = true;
            }
            if (this.r.B() == a.WRAP_CONTENT && !z5) {
                if (this.i.c == null || this.i.c.a != this.r) {
                    a = eVar.a(this.r.i);
                    b2 = eVar.b();
                    b2.a(a2, a, eVar.c(), 0);
                    eVar.a(b2);
                } else if (this.i.c != null && this.i.c.a == this.r) {
                    this.i.a(android.support.constraint.a.a.a.a.STRICT);
                }
                if (this.k.c == null || this.k.c.a != this.r) {
                    a = eVar.a(this.r.k);
                    b2 = eVar.b();
                    b2.a(a, a3, eVar.c(), 0);
                    eVar.a(b2);
                } else if (this.k.c != null && this.k.c.a == this.r) {
                    this.k.a(android.support.constraint.a.a.a.a.STRICT);
                }
            }
            if (this.r.C() == a.WRAP_CONTENT && !z6) {
                if (this.j.c == null || this.j.c.a != this.r) {
                    a = eVar.a(this.r.j);
                    b2 = eVar.b();
                    b2.a(a4, a, eVar.c(), 0);
                    eVar.a(b2);
                } else if (this.j.c != null && this.j.c.a == this.r) {
                    this.j.a(android.support.constraint.a.a.a.a.STRICT);
                }
                if (this.l.c == null || this.l.c.a != this.r) {
                    a = eVar.a(this.r.l);
                    b2 = eVar.b();
                    b2.a(a, a5, eVar.c(), 0);
                    eVar.a(b2);
                    z = z6;
                    z2 = z5;
                } else if (this.l.c != null && this.l.c.a == this.r) {
                    this.l.a(android.support.constraint.a.a.a.a.STRICT);
                }
            }
            z = z6;
            z2 = z5;
        } else {
            z = false;
            z2 = false;
        }
        int i5 = this.s;
        if (i5 < this.B) {
            i5 = this.B;
        }
        int i6 = this.t;
        if (i6 < this.C) {
            i6 = this.C;
        }
        boolean z7 = this.G != a.MATCH_CONSTRAINT;
        boolean z8 = this.H != a.MATCH_CONSTRAINT;
        boolean z9 = (z7 || this.i == null || this.k == null || !(this.i.c == null || this.k.c == null)) ? z7 : true;
        z7 = (z8 || this.j == null || this.l == null || (!(this.j.c == null || this.l.c == null) || (this.A != 0 && (this.m == null || !(this.j.c == null || this.m.c == null))))) ? z8 : true;
        Object obj2 = null;
        int i7 = this.v;
        float f2 = this.u;
        if (this.u > 0.0f && this.am != 8) {
            if (this.G == a.MATCH_CONSTRAINT && this.H == a.MATCH_CONSTRAINT) {
                obj2 = 1;
                if (z9 && !z7) {
                    f = f2;
                    i2 = 0;
                    obj = 1;
                    z3 = z7;
                    i3 = i6;
                    i4 = i5;
                    z8 = z9;
                    if (obj == null) {
                    }
                    if (this.G != a.WRAP_CONTENT) {
                    }
                    if (z4) {
                    }
                    a(eVar, z7, z8, this.i, this.k, this.w, this.w + i4, i4, this.B, this.E, z4, z2, this.c, this.e, this.f);
                    if (this.b != 2) {
                        if (this.H != a.WRAP_CONTENT) {
                        }
                        if (obj == null) {
                        }
                        if (this.A <= 0) {
                            aVar = this.l;
                            eVar.c(a6, a4, w(), 5);
                            if (this.m.c == null) {
                                i4 = this.A;
                                aVar = this.m;
                            } else {
                                i4 = i3;
                            }
                            if (z4) {
                            }
                            a(eVar, z7, z3, this.j, aVar, this.x, this.x + i4, i4, this.C, this.F, z4, z, this.d, this.g, this.h);
                            eVar.c(a5, a4, i3, 5);
                        } else {
                            if (z4) {
                            }
                            a(eVar, z7, z3, this.j, this.l, this.x, this.x + i3, i3, this.C, this.F, z4, z, this.d, this.g, this.h);
                        }
                        if (obj == null) {
                            b = eVar.b();
                            if (i == Integer.MAX_VALUE) {
                            }
                            if (i2 != 0) {
                                eVar.a(b.a(a3, a2, a5, a4, f));
                            } else if (i2 != 1) {
                                eVar.a(b.a(a5, a4, a3, a2, f));
                            } else {
                                if (this.e > 0) {
                                    eVar.a(a3, a2, this.e, 3);
                                }
                                if (this.g > 0) {
                                    eVar.a(a5, a4, this.g, 3);
                                }
                                b.a(a3, a2, a5, a4, f);
                                d = eVar.d();
                                a = eVar.d();
                                d.c = 4;
                                a.c = 4;
                                b.a(d, a);
                                eVar.a(b);
                            }
                        }
                    }
                } else if (!z9 && z7) {
                    i7 = 1;
                    if (this.v == -1) {
                        f = 1.0f / f2;
                        i2 = 1;
                        int obj3 = 1;
                        z3 = z7;
                        i3 = i6;
                        i4 = i5;
                        z8 = z9;
                        if (obj3 == null) {
                        }
                        if (this.G != a.WRAP_CONTENT) {
                        }
                        if (z4) {
                        }
                        a(eVar, z7, z8, this.i, this.k, this.w, this.w + i4, i4, this.B, this.E, z4, z2, this.c, this.e, this.f);
                        if (this.b != 2) {
                            if (this.H != a.WRAP_CONTENT) {
                            }
                            if (obj3 == null) {
                            }
                            if (this.A <= 0) {
                                if (z4) {
                                }
                                a(eVar, z7, z3, this.j, this.l, this.x, this.x + i3, i3, this.C, this.F, z4, z, this.d, this.g, this.h);
                            } else {
                                aVar = this.l;
                                eVar.c(a6, a4, w(), 5);
                                if (this.m.c == null) {
                                    i4 = i3;
                                } else {
                                    i4 = this.A;
                                    aVar = this.m;
                                }
                                if (z4) {
                                }
                                a(eVar, z7, z3, this.j, aVar, this.x, this.x + i4, i4, this.C, this.F, z4, z, this.d, this.g, this.h);
                                eVar.c(a5, a4, i3, 5);
                            }
                            if (obj3 == null) {
                                b = eVar.b();
                                if (i == Integer.MAX_VALUE) {
                                }
                                if (i2 != 0) {
                                    eVar.a(b.a(a3, a2, a5, a4, f));
                                } else if (i2 != 1) {
                                    if (this.e > 0) {
                                        eVar.a(a3, a2, this.e, 3);
                                    }
                                    if (this.g > 0) {
                                        eVar.a(a5, a4, this.g, 3);
                                    }
                                    b.a(a3, a2, a5, a4, f);
                                    d = eVar.d();
                                    a = eVar.d();
                                    d.c = 4;
                                    a.c = 4;
                                    b.a(d, a);
                                    eVar.a(b);
                                } else {
                                    eVar.a(b.a(a5, a4, a3, a2, f));
                                }
                            }
                        }
                    }
                }
            }
            g a7;
            g a8;
            if (this.G == a.MATCH_CONSTRAINT) {
                i4 = (int) (((float) this.t) * f2);
                f = f2;
                i2 = 0;
                obj3 = null;
                z3 = z7;
                i3 = i6;
                z8 = true;
            } else if (this.H == a.MATCH_CONSTRAINT) {
                float f3 = this.v == -1 ? 1.0f / f2 : f2;
                i3 = (int) (((float) this.s) * f3);
                f = f3;
                i2 = 1;
                obj3 = null;
                z3 = true;
                i4 = i5;
                z8 = z9;
            }
            z4 = obj3 == null && (i2 == 0 || i2 == -1);
            z7 = this.G != a.WRAP_CONTENT && (this instanceof c);
            if (this.a != 2 && (i == Integer.MAX_VALUE || (this.i.g == i && this.k.g == i))) {
                if (z4 || this.i.c == null || this.k.c == null) {
                    a(eVar, z7, z8, this.i, this.k, this.w, this.w + i4, i4, this.B, this.E, z4, z2, this.c, this.e, this.f);
                } else {
                    d = eVar.a(this.i);
                    a7 = eVar.a(this.k);
                    a = eVar.a(this.i.f());
                    a8 = eVar.a(this.k.f());
                    eVar.a(d, a, this.i.d(), 3);
                    eVar.b(a7, a8, this.k.d() * -1, 3);
                    if (!z2) {
                        eVar.a(d, a, this.i.d(), this.E, a8, a7, this.k.d(), 4);
                    }
                }
            }
            if (this.b != 2) {
                z7 = this.H != a.WRAP_CONTENT && (this instanceof c);
                z4 = obj3 == null && (i2 == 1 || i2 == -1);
                if (this.A <= 0) {
                    aVar = this.l;
                    if (i == Integer.MAX_VALUE || (this.l.g == i && this.m.g == i)) {
                        eVar.c(a6, a4, w(), 5);
                    }
                    if (this.m.c == null) {
                        i4 = this.A;
                        aVar = this.m;
                    } else {
                        i4 = i3;
                    }
                    if (i == Integer.MAX_VALUE || (this.j.g == i && aVar.g == i)) {
                        if (z4 || this.j.c == null || this.l.c == null) {
                            a(eVar, z7, z3, this.j, aVar, this.x, this.x + i4, i4, this.C, this.F, z4, z, this.d, this.g, this.h);
                            eVar.c(a5, a4, i3, 5);
                        } else {
                            d = eVar.a(this.j);
                            a7 = eVar.a(this.l);
                            a = eVar.a(this.j.f());
                            a8 = eVar.a(this.l.f());
                            eVar.a(d, a, this.j.d(), 3);
                            eVar.b(a7, a8, this.l.d() * -1, 3);
                            if (!z) {
                                eVar.a(d, a, this.j.d(), this.F, a8, a7, this.l.d(), 4);
                            }
                        }
                    }
                } else if (i == Integer.MAX_VALUE || (this.j.g == i && this.l.g == i)) {
                    if (z4 || this.j.c == null || this.l.c == null) {
                        a(eVar, z7, z3, this.j, this.l, this.x, this.x + i3, i3, this.C, this.F, z4, z, this.d, this.g, this.h);
                    } else {
                        d = eVar.a(this.j);
                        a7 = eVar.a(this.l);
                        a = eVar.a(this.j.f());
                        a8 = eVar.a(this.l.f());
                        eVar.a(d, a, this.j.d(), 3);
                        eVar.b(a7, a8, this.l.d() * -1, 3);
                        if (!z) {
                            eVar.a(d, a, this.j.d(), this.F, a8, a7, this.l.d(), 4);
                        }
                    }
                }
                if (obj3 == null) {
                    b = eVar.b();
                    if (i == Integer.MAX_VALUE && (this.i.g != i || this.k.g != i)) {
                        return;
                    }
                    if (i2 != 0) {
                        eVar.a(b.a(a3, a2, a5, a4, f));
                    } else if (i2 != 1) {
                        eVar.a(b.a(a5, a4, a3, a2, f));
                    } else {
                        if (this.e > 0) {
                            eVar.a(a3, a2, this.e, 3);
                        }
                        if (this.g > 0) {
                            eVar.a(a5, a4, this.g, 3);
                        }
                        b.a(a3, a2, a5, a4, f);
                        d = eVar.d();
                        a = eVar.d();
                        d.c = 4;
                        a.c = 4;
                        b.a(d, a);
                        eVar.a(b);
                    }
                }
            }
        }
        f = f2;
        i2 = i7;
        obj3 = obj2;
        z3 = z7;
        i3 = i6;
        i4 = i5;
        z8 = z9;
        if (obj3 == null) {
        }
        if (this.G != a.WRAP_CONTENT) {
        }
        if (z4) {
        }
        a(eVar, z7, z8, this.i, this.k, this.w, this.w + i4, i4, this.B, this.E, z4, z2, this.c, this.e, this.f);
        if (this.b != 2) {
            if (this.H != a.WRAP_CONTENT) {
            }
            if (obj3 == null) {
            }
            if (this.A <= 0) {
                if (z4) {
                }
                a(eVar, z7, z3, this.j, this.l, this.x, this.x + i3, i3, this.C, this.F, z4, z, this.d, this.g, this.h);
            } else {
                aVar = this.l;
                eVar.c(a6, a4, w(), 5);
                if (this.m.c == null) {
                    i4 = i3;
                } else {
                    i4 = this.A;
                    aVar = this.m;
                }
                if (z4) {
                }
                a(eVar, z7, z3, this.j, aVar, this.x, this.x + i4, i4, this.C, this.F, z4, z, this.d, this.g, this.h);
                eVar.c(a5, a4, i3, 5);
            }
            if (obj3 == null) {
                b = eVar.b();
                if (i == Integer.MAX_VALUE) {
                }
                if (i2 != 0) {
                    eVar.a(b.a(a3, a2, a5, a4, f));
                } else if (i2 != 1) {
                    if (this.e > 0) {
                        eVar.a(a3, a2, this.e, 3);
                    }
                    if (this.g > 0) {
                        eVar.a(a5, a4, this.g, 3);
                    }
                    b.a(a3, a2, a5, a4, f);
                    d = eVar.d();
                    a = eVar.d();
                    d.c = 4;
                    a.c = 4;
                    b.a(d, a);
                    eVar.a(b);
                } else {
                    eVar.a(b.a(a5, a4, a3, a2, f));
                }
            }
        }
    }

    public void a(Object obj) {
        this.ak = obj;
    }

    public void a(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            this.u = 0.0f;
            return;
        }
        float parseFloat;
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (!substring.equalsIgnoreCase("W")) {
                i = substring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i2 = i;
            i = indexOf + 1;
        }
        indexOf = str.indexOf(58);
        String substring2;
        if (indexOf < 0 || indexOf >= length - 1) {
            substring2 = str.substring(i);
            if (substring2.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                } catch (NumberFormatException e) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        } else {
            substring2 = str.substring(i, indexOf);
            String substring3 = str.substring(indexOf + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                try {
                    parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        parseFloat = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                    }
                } catch (NumberFormatException e2) {
                    parseFloat = 0.0f;
                }
            }
            parseFloat = 0.0f;
        }
        if (parseFloat > 0.0f) {
            this.u = parseFloat;
            this.v = i2;
        }
    }

    public void b(float f) {
        this.F = f;
    }

    public void b(int i) {
        this.w = i;
    }

    public void b(int i, int i2) {
        this.y = i;
        this.z = i2;
    }

    public void b(int i, int i2, int i3) {
        this.d = i;
        this.g = i2;
        this.h = i3;
    }

    public void b(a aVar) {
        this.H = aVar;
        if (this.H == a.WRAP_CONTENT) {
            e(this.aj);
        }
    }

    public void b(e eVar, int i) {
        if (i == Integer.MAX_VALUE) {
            a(eVar.b(this.i), eVar.b(this.j), eVar.b(this.k), eVar.b(this.l));
        } else if (i == -2) {
            a(this.aa, this.ab, this.ac, this.ad);
        } else {
            if (this.i.g == i) {
                this.aa = eVar.b(this.i);
            }
            if (this.j.g == i) {
                this.ab = eVar.b(this.j);
            }
            if (this.k.g == i) {
                this.ac = eVar.b(this.k);
            }
            if (this.l.g == i) {
                this.ad = eVar.b(this.l);
            }
        }
    }

    public boolean b() {
        return this.r == null;
    }

    public b c() {
        return this.r;
    }

    public void c(float f) {
        this.W = f;
    }

    public void c(int i) {
        this.x = i;
    }

    public void c(int i, int i2) {
        this.w = i;
        this.s = i2 - i;
        if (this.s < this.B) {
            this.s = this.B;
        }
    }

    public int d() {
        return this.am;
    }

    public void d(float f) {
        this.X = f;
    }

    public void d(int i) {
        this.s = i;
        if (this.s < this.B) {
            this.s = this.B;
        }
    }

    public void d(int i, int i2) {
        this.x = i;
        this.t = i2 - i;
        if (this.t < this.C) {
            this.t = this.C;
        }
    }

    public String e() {
        return this.an;
    }

    public void e(int i) {
        this.t = i;
        if (this.t < this.C) {
            this.t = this.C;
        }
    }

    public int f() {
        return this.w;
    }

    public void f(int i) {
        if (i < 0) {
            this.B = 0;
        } else {
            this.B = i;
        }
    }

    public int g() {
        return this.x;
    }

    public void g(int i) {
        if (i < 0) {
            this.C = 0;
        } else {
            this.C = i;
        }
    }

    public int h() {
        return this.am == 8 ? 0 : this.s;
    }

    public void h(int i) {
        this.ai = i;
    }

    public int i() {
        int i = this.s;
        if (this.G != a.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.c == 1) {
            i = Math.max(this.e, i);
        } else if (this.e > 0) {
            i = this.e;
            this.s = i;
        } else {
            i = 0;
        }
        return (this.f <= 0 || this.f >= i) ? i : this.f;
    }

    public void i(int i) {
        this.aj = i;
    }

    public int j() {
        int i = this.t;
        if (this.H != a.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.d == 1) {
            i = Math.max(this.g, i);
        } else if (this.g > 0) {
            i = this.g;
            this.t = i;
        } else {
            i = 0;
        }
        return (this.h <= 0 || this.h >= i) ? i : this.h;
    }

    public void j(int i) {
        this.A = i;
    }

    public int k() {
        return this.ai;
    }

    public void k(int i) {
        this.S = i;
    }

    public int l() {
        return this.am == 8 ? 0 : this.t;
    }

    public void l(int i) {
        this.T = i;
    }

    public int m() {
        return this.aj;
    }

    public int n() {
        return this.ae + this.y;
    }

    public int o() {
        return this.af + this.z;
    }

    public int p() {
        return o() + this.ah;
    }

    public int q() {
        return n() + this.ag;
    }

    protected int r() {
        return this.w + this.y;
    }

    protected int s() {
        return this.x + this.z;
    }

    public int t() {
        return f() + this.s;
    }

    public String toString() {
        return (this.ao != null ? "type: " + this.ao + " " : "") + (this.an != null ? "id: " + this.an + " " : "") + "(" + this.w + ", " + this.x + ") - (" + this.s + " x " + this.t + ")" + " wrap: (" + this.ai + " x " + this.aj + ")";
    }

    public int u() {
        return g() + this.t;
    }

    public boolean v() {
        return this.A > 0;
    }

    public int w() {
        return this.A;
    }

    public Object x() {
        return this.ak;
    }

    public ArrayList<a> y() {
        return this.q;
    }

    public void z() {
        int i = this.w;
        int i2 = this.x;
        int i3 = this.w + this.s;
        int i4 = this.x + this.t;
        this.ae = i;
        this.af = i2;
        this.ag = i3 - i;
        this.ah = i4 - i2;
    }
}
