package android.support.constraint.a.a;

import android.support.constraint.a.a.b.a;
import android.support.constraint.a.b;
import android.support.constraint.a.e;
import android.support.constraint.a.g;
import java.util.ArrayList;
import java.util.Arrays;

public class c extends h {
    static boolean ac = true;
    protected e aa = new e();
    protected e ab = null;
    int ad;
    int ae;
    int af;
    int ag;
    int ah;
    int ai;
    private g ak;
    private int al = 0;
    private int am = 0;
    private b[] an = new b[4];
    private b[] ao = new b[4];
    private b[] ap = new b[4];
    private int aq = 2;
    private boolean[] ar = new boolean[3];
    private b[] as = new b[4];
    private boolean at = false;
    private boolean au = false;

    private void J() {
        this.al = 0;
        this.am = 0;
    }

    private int a(e eVar, b[] bVarArr, b bVar, int i, boolean[] zArr) {
        int i2;
        zArr[0] = true;
        zArr[1] = false;
        bVarArr[0] = null;
        bVarArr[2] = null;
        bVarArr[1] = null;
        bVarArr[3] = null;
        boolean z;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        int i3;
        if (i == 0) {
            z = bVar.i.c == null || bVar.i.c.a == this;
            bVar.Y = null;
            bVar2 = null;
            if (bVar.d() != 8) {
                bVar2 = bVar;
            }
            bVar3 = null;
            i2 = 0;
            bVar4 = bVar;
            bVar5 = bVar2;
            while (bVar4.k.c != null) {
                bVar4.Y = null;
                if (bVar4.d() != 8) {
                    bVar6 = bVar5 == null ? bVar4 : bVar5;
                    if (!(bVar2 == null || bVar2 == bVar4)) {
                        bVar2.Y = bVar4;
                    }
                    bVar5 = bVar4;
                } else {
                    eVar.c(bVar4.i.f, bVar4.i.c.f, 0, 5);
                    eVar.c(bVar4.k.f, bVar4.i.f, 0, 5);
                    bVar6 = bVar5;
                    bVar5 = bVar2;
                }
                if (bVar4.d() != 8 && bVar4.G == a.MATCH_CONSTRAINT) {
                    if (bVar4.H == a.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (bVar4.u <= 0.0f) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.an.length) {
                            this.an = (b[]) Arrays.copyOf(this.an, this.an.length * 2);
                        }
                        i3 = i2 + 1;
                        this.an[i2] = bVar4;
                        i2 = i3;
                    }
                }
                if (bVar4.k.c.a.i.c == null || bVar4.k.c.a.i.c.a != bVar4 || bVar4.k.c.a == bVar4) {
                    break;
                }
                bVar2 = bVar4.k.c.a;
                bVar3 = bVar2;
                bVar4 = bVar2;
                bVar2 = bVar5;
                bVar5 = bVar6;
            }
            bVar6 = bVar5;
            bVar5 = bVar2;
            if (!(bVar4.k.c == null || bVar4.k.c.a == this)) {
                z = false;
            }
            if (bVar.i.c == null || bVar3.k.c == null) {
                zArr[1] = true;
            }
            bVar.U = z;
            bVar3.Y = null;
            bVarArr[0] = bVar;
            bVarArr[2] = bVar6;
            bVarArr[1] = bVar3;
            bVarArr[3] = bVar5;
        } else {
            z = bVar.j.c == null || bVar.j.c.a == this;
            bVar.Z = null;
            bVar2 = null;
            if (bVar.d() != 8) {
                bVar2 = bVar;
            }
            bVar3 = null;
            i2 = 0;
            bVar4 = bVar;
            bVar5 = bVar2;
            while (bVar4.l.c != null) {
                bVar4.Z = null;
                if (bVar4.d() != 8) {
                    bVar6 = bVar5 == null ? bVar4 : bVar5;
                    if (!(bVar2 == null || bVar2 == bVar4)) {
                        bVar2.Z = bVar4;
                    }
                    bVar5 = bVar4;
                } else {
                    eVar.c(bVar4.j.f, bVar4.j.c.f, 0, 5);
                    eVar.c(bVar4.l.f, bVar4.j.f, 0, 5);
                    bVar6 = bVar5;
                    bVar5 = bVar2;
                }
                if (bVar4.d() != 8 && bVar4.H == a.MATCH_CONSTRAINT) {
                    if (bVar4.G == a.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (bVar4.u <= 0.0f) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.an.length) {
                            this.an = (b[]) Arrays.copyOf(this.an, this.an.length * 2);
                        }
                        i3 = i2 + 1;
                        this.an[i2] = bVar4;
                        i2 = i3;
                    }
                }
                if (bVar4.l.c.a.j.c == null || bVar4.l.c.a.j.c.a != bVar4 || bVar4.l.c.a == bVar4) {
                    break;
                }
                bVar2 = bVar4.l.c.a;
                bVar3 = bVar2;
                bVar4 = bVar2;
                bVar2 = bVar5;
                bVar5 = bVar6;
            }
            bVar6 = bVar5;
            bVar5 = bVar2;
            if (!(bVar4.l.c == null || bVar4.l.c.a == this)) {
                z = false;
            }
            if (bVar.j.c == null || bVar3.l.c == null) {
                zArr[1] = true;
            }
            bVar.V = z;
            bVar3.Z = null;
            bVarArr[0] = bVar;
            bVarArr[2] = bVar6;
            bVarArr[1] = bVar3;
            bVarArr[3] = bVar5;
        }
        return i2;
    }

    private boolean a(e eVar) {
        int i;
        b bVar;
        int i2;
        int size = this.aj.size();
        for (i = 0; i < size; i++) {
            bVar = (b) this.aj.get(i);
            bVar.a = -1;
            bVar.b = -1;
            if (bVar.G == a.MATCH_CONSTRAINT || bVar.H == a.MATCH_CONSTRAINT) {
                bVar.a = 1;
                bVar.b = 1;
            }
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        while (!z) {
            int i6 = i3 + 1;
            int i7 = 0;
            i2 = 0;
            i = 0;
            while (i7 < size) {
                bVar = (b) this.aj.get(i7);
                if (bVar.a == -1) {
                    if (this.G == a.WRAP_CONTENT) {
                        bVar.a = 1;
                    } else {
                        e.b(this, eVar, bVar);
                    }
                }
                if (bVar.b == -1) {
                    if (this.H == a.WRAP_CONTENT) {
                        bVar.b = 1;
                    } else {
                        e.c(this, eVar, bVar);
                    }
                }
                if (bVar.b == -1) {
                    i++;
                }
                i7++;
                i2 = bVar.a == -1 ? i2 + 1 : i2;
            }
            boolean z2 = (i == 0 && i2 == 0) ? true : (i5 == i && i4 == i2) ? true : z;
            i4 = i2;
            i5 = i;
            z = z2;
            i3 = i6;
        }
        int i8 = 0;
        i2 = 0;
        i = 0;
        while (i8 < size) {
            bVar = (b) this.aj.get(i8);
            if (bVar.a == 1 || bVar.a == -1) {
                i++;
            }
            i3 = (bVar.b == 1 || bVar.b == -1) ? i2 + 1 : i2;
            i8++;
            i2 = i3;
        }
        return i == 0 && i2 == 0;
    }

    private void b(e eVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.al) {
                b bVar = this.ap[i2];
                int a = a(eVar, this.as, this.ap[i2], 0, this.ar);
                b bVar2 = this.as[2];
                if (bVar2 != null) {
                    if (!this.ar[1]) {
                        Object obj = bVar.S == 0 ? 1 : null;
                        Object obj2 = bVar.S == 2 ? 1 : null;
                        Object obj3 = this.G == a.WRAP_CONTENT ? 1 : null;
                        if ((this.aq != 2 && this.aq != 8) || !this.ar[0] || !bVar.U || obj2 != null || obj3 != null || bVar.S != 0) {
                            b bVar3;
                            a aVar;
                            g gVar;
                            if (a != 0 && obj2 == null) {
                                int i3;
                                float f = 0.0f;
                                bVar3 = null;
                                b bVar4 = bVar2;
                                while (bVar4 != null) {
                                    if (bVar4.G != a.MATCH_CONSTRAINT) {
                                        i = bVar4.i.d();
                                        if (bVar3 != null) {
                                            i += bVar3.k.d();
                                        }
                                        i3 = 3;
                                        if (bVar4.i.c.a.G == a.MATCH_CONSTRAINT) {
                                            i3 = 2;
                                        }
                                        eVar.a(bVar4.i.f, bVar4.i.c.f, i, i3);
                                        i = bVar4.k.d();
                                        if (bVar4.k.c.a.i.c != null && bVar4.k.c.a.i.c.a == bVar4) {
                                            i += bVar4.k.c.a.i.d();
                                        }
                                        i3 = 3;
                                        if (bVar4.k.c.a.G == a.MATCH_CONSTRAINT) {
                                            i3 = 2;
                                        }
                                        eVar.b(bVar4.k.f, bVar4.k.c.f, -i, i3);
                                    } else {
                                        f += bVar4.W;
                                        i = 0;
                                        if (bVar4.k.c != null) {
                                            i = bVar4.k.d();
                                            if (bVar4 != this.as[3]) {
                                                i += bVar4.k.c.a.i.d();
                                            }
                                        }
                                        eVar.a(bVar4.k.f, bVar4.i.f, 0, 1);
                                        eVar.b(bVar4.k.f, bVar4.k.c.f, -i, 1);
                                    }
                                    bVar3 = bVar4;
                                    bVar4 = bVar4.Y;
                                }
                                if (a != 1) {
                                    i = 0;
                                    while (true) {
                                        int i4 = i;
                                        if (i4 >= a - 1) {
                                            break;
                                        }
                                        b bVar5 = this.an[i4];
                                        bVar2 = this.an[i4 + 1];
                                        g gVar2 = bVar5.i.f;
                                        g gVar3 = bVar5.k.f;
                                        g gVar4 = bVar2.i.f;
                                        g gVar5 = bVar2.k.f;
                                        if (bVar2 == this.as[3]) {
                                            gVar5 = this.as[1].k.f;
                                        }
                                        i = bVar5.i.d();
                                        if (!(bVar5.i.c == null || bVar5.i.c.a.k.c == null || bVar5.i.c.a.k.c.a != bVar5)) {
                                            i += bVar5.i.c.a.k.d();
                                        }
                                        eVar.a(gVar2, bVar5.i.c.f, i, 2);
                                        i3 = bVar5.k.d();
                                        if (bVar5.k.c == null || bVar5.Y == null) {
                                            i = i3;
                                        } else {
                                            i = (bVar5.Y.i.c != null ? bVar5.Y.i.d() : 0) + i3;
                                        }
                                        eVar.b(gVar3, bVar5.k.c.f, -i, 2);
                                        if (i4 + 1 == a - 1) {
                                            i = bVar2.i.d();
                                            if (!(bVar2.i.c == null || bVar2.i.c.a.k.c == null || bVar2.i.c.a.k.c.a != bVar2)) {
                                                i += bVar2.i.c.a.k.d();
                                            }
                                            eVar.a(gVar4, bVar2.i.c.f, i, 2);
                                            aVar = bVar2.k;
                                            if (bVar2 == this.as[3]) {
                                                aVar = this.as[1].k;
                                            }
                                            i3 = aVar.d();
                                            if (!(aVar.c == null || aVar.c.a.i.c == null || aVar.c.a.i.c.a != bVar2)) {
                                                i3 += aVar.c.a.i.d();
                                            }
                                            eVar.b(gVar5, aVar.c.f, -i3, 2);
                                        }
                                        if (bVar.f > 0) {
                                            eVar.b(gVar3, gVar2, bVar.f, 2);
                                        }
                                        b b = eVar.b();
                                        b.a(bVar5.W, f, bVar2.W, gVar2, bVar5.i.d(), gVar3, bVar5.k.d(), gVar4, bVar2.i.d(), gVar5, bVar2.k.d());
                                        eVar.a(b);
                                        i = i4 + 1;
                                    }
                                } else {
                                    bVar4 = this.an[0];
                                    i = bVar4.i.d();
                                    if (bVar4.i.c != null) {
                                        i += bVar4.i.c.d();
                                    }
                                    i3 = bVar4.k.d();
                                    if (bVar4.k.c != null) {
                                        i3 += bVar4.k.c.d();
                                    }
                                    gVar = bVar.k.c.f;
                                    if (bVar4 == this.as[3]) {
                                        gVar = this.as[1].k.c.f;
                                    }
                                    if (bVar4.c == 1) {
                                        eVar.a(bVar.i.f, bVar.i.c.f, i, 1);
                                        eVar.b(bVar.k.f, gVar, -i3, 1);
                                        eVar.c(bVar.k.f, bVar.i.f, bVar.h(), 2);
                                    } else {
                                        eVar.c(bVar4.i.f, bVar4.i.c.f, i, 1);
                                        eVar.c(bVar4.k.f, gVar, -i3, 1);
                                    }
                                }
                            } else {
                                a aVar2;
                                int d;
                                int d2;
                                g gVar6;
                                b bVar6 = null;
                                obj3 = null;
                                b bVar7 = null;
                                b bVar8 = bVar2;
                                while (bVar8 != null) {
                                    Object obj4;
                                    b bVar9;
                                    b bVar10;
                                    bVar3 = bVar8.Y;
                                    if (bVar3 == null) {
                                        obj4 = 1;
                                        bVar9 = this.as[1];
                                    } else {
                                        obj4 = obj3;
                                        bVar9 = bVar6;
                                    }
                                    if (obj2 != null) {
                                        a aVar3 = bVar8.i;
                                        i = aVar3.d();
                                        int d3 = bVar7 != null ? i + bVar7.k.d() : i;
                                        i = 1;
                                        if (bVar2 != bVar8) {
                                            i = 3;
                                        }
                                        eVar.a(aVar3.f, aVar3.c.f, d3, i);
                                        if (bVar8.G == a.MATCH_CONSTRAINT) {
                                            aVar = bVar8.k;
                                            if (bVar8.c == 1) {
                                                eVar.c(aVar.f, aVar3.f, Math.max(bVar8.e, bVar8.h()), 3);
                                            } else {
                                                eVar.a(aVar3.f, aVar3.c.f, aVar3.d, 3);
                                                eVar.b(aVar.f, aVar3.f, bVar8.e, 3);
                                            }
                                        }
                                        bVar10 = bVar3;
                                    } else if (obj != null || obj4 == null || bVar7 == null) {
                                        if (obj != null || obj4 != null || bVar7 != null) {
                                            b bVar11;
                                            a aVar4 = bVar8.i;
                                            aVar2 = bVar8.k;
                                            d = aVar4.d();
                                            d2 = aVar2.d();
                                            eVar.a(aVar4.f, aVar4.c.f, d, 1);
                                            eVar.b(aVar2.f, aVar2.c.f, -d2, 1);
                                            gVar = aVar4.c != null ? aVar4.c.f : null;
                                            if (bVar7 == null) {
                                                gVar = bVar.i.c != null ? bVar.i.c.f : null;
                                            }
                                            if (bVar3 == null) {
                                                bVar11 = bVar9.k.c != null ? bVar9.k.c.a : null;
                                            } else {
                                                bVar11 = bVar3;
                                            }
                                            if (bVar11 != null) {
                                                gVar6 = bVar11.i.f;
                                                if (obj4 != null) {
                                                    gVar6 = bVar9.k.c != null ? bVar9.k.c.f : null;
                                                }
                                                if (!(gVar == null || gVar6 == null)) {
                                                    eVar.a(aVar4.f, gVar, d, 0.5f, gVar6, aVar2.f, d2, 4);
                                                }
                                            }
                                            bVar10 = bVar11;
                                        } else if (bVar8.i.c == null) {
                                            eVar.a(bVar8.i.f, bVar8.n());
                                            bVar10 = bVar3;
                                        } else {
                                            eVar.c(bVar8.i.f, bVar.i.c.f, bVar8.i.d(), 5);
                                            bVar10 = bVar3;
                                        }
                                    } else if (bVar8.k.c == null) {
                                        eVar.a(bVar8.k.f, bVar8.q());
                                        bVar10 = bVar3;
                                    } else {
                                        eVar.c(bVar8.k.f, bVar9.k.c.f, -bVar8.k.d(), 5);
                                        bVar10 = bVar3;
                                    }
                                    if (obj4 != null) {
                                        bVar10 = null;
                                    }
                                    bVar6 = bVar9;
                                    bVar7 = bVar8;
                                    bVar8 = bVar10;
                                    obj3 = obj4;
                                }
                                if (obj2 != null) {
                                    aVar = bVar2.i;
                                    aVar2 = bVar6.k;
                                    d = aVar.d();
                                    d2 = aVar2.d();
                                    gVar = bVar.i.c != null ? bVar.i.c.f : null;
                                    gVar6 = bVar6.k.c != null ? bVar6.k.c.f : null;
                                    if (!(gVar == null || gVar6 == null)) {
                                        eVar.b(aVar2.f, gVar6, -d2, 1);
                                        eVar.a(aVar.f, gVar, d, bVar.E, gVar6, aVar2.f, d2, 4);
                                    }
                                }
                            }
                        } else {
                            e.a(this, eVar, a, bVar);
                        }
                    } else {
                        i = bVar.n();
                        while (bVar2 != null) {
                            eVar.a(bVar2.i.f, i);
                            i += (bVar2.i.d() + bVar2.h()) + bVar2.k.d();
                            bVar2 = bVar2.Y;
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void c(e eVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.am) {
                b bVar = this.ao[i2];
                int a = a(eVar, this.as, this.ao[i2], 1, this.ar);
                b bVar2 = this.as[2];
                if (bVar2 != null) {
                    if (!this.ar[1]) {
                        Object obj = bVar.T == 0 ? 1 : null;
                        Object obj2 = bVar.T == 2 ? 1 : null;
                        Object obj3 = this.H == a.WRAP_CONTENT ? 1 : null;
                        if ((this.aq != 2 && this.aq != 8) || !this.ar[0] || !bVar.V || obj2 != null || obj3 != null || bVar.T != 0) {
                            b bVar3;
                            a aVar;
                            g gVar;
                            if (a != 0 && obj2 == null) {
                                int i3;
                                float f = 0.0f;
                                bVar3 = null;
                                b bVar4 = bVar2;
                                while (bVar4 != null) {
                                    if (bVar4.H != a.MATCH_CONSTRAINT) {
                                        i = bVar4.j.d();
                                        if (bVar3 != null) {
                                            i += bVar3.l.d();
                                        }
                                        i3 = 3;
                                        if (bVar4.j.c.a.H == a.MATCH_CONSTRAINT) {
                                            i3 = 2;
                                        }
                                        eVar.a(bVar4.j.f, bVar4.j.c.f, i, i3);
                                        i = bVar4.l.d();
                                        if (bVar4.l.c.a.j.c != null && bVar4.l.c.a.j.c.a == bVar4) {
                                            i += bVar4.l.c.a.j.d();
                                        }
                                        i3 = 3;
                                        if (bVar4.l.c.a.H == a.MATCH_CONSTRAINT) {
                                            i3 = 2;
                                        }
                                        eVar.b(bVar4.l.f, bVar4.l.c.f, -i, i3);
                                    } else {
                                        f += bVar4.X;
                                        i = 0;
                                        if (bVar4.l.c != null) {
                                            i = bVar4.l.d();
                                            if (bVar4 != this.as[3]) {
                                                i += bVar4.l.c.a.j.d();
                                            }
                                        }
                                        eVar.a(bVar4.l.f, bVar4.j.f, 0, 1);
                                        eVar.b(bVar4.l.f, bVar4.l.c.f, -i, 1);
                                    }
                                    bVar3 = bVar4;
                                    bVar4 = bVar4.Z;
                                }
                                if (a != 1) {
                                    i = 0;
                                    while (true) {
                                        int i4 = i;
                                        if (i4 >= a - 1) {
                                            break;
                                        }
                                        b bVar5 = this.an[i4];
                                        bVar2 = this.an[i4 + 1];
                                        g gVar2 = bVar5.j.f;
                                        g gVar3 = bVar5.l.f;
                                        g gVar4 = bVar2.j.f;
                                        g gVar5 = bVar2.l.f;
                                        if (bVar2 == this.as[3]) {
                                            gVar5 = this.as[1].l.f;
                                        }
                                        i = bVar5.j.d();
                                        if (!(bVar5.j.c == null || bVar5.j.c.a.l.c == null || bVar5.j.c.a.l.c.a != bVar5)) {
                                            i += bVar5.j.c.a.l.d();
                                        }
                                        eVar.a(gVar2, bVar5.j.c.f, i, 2);
                                        i3 = bVar5.l.d();
                                        if (bVar5.l.c == null || bVar5.Z == null) {
                                            i = i3;
                                        } else {
                                            i = (bVar5.Z.j.c != null ? bVar5.Z.j.d() : 0) + i3;
                                        }
                                        eVar.b(gVar3, bVar5.l.c.f, -i, 2);
                                        if (i4 + 1 == a - 1) {
                                            i = bVar2.j.d();
                                            if (!(bVar2.j.c == null || bVar2.j.c.a.l.c == null || bVar2.j.c.a.l.c.a != bVar2)) {
                                                i += bVar2.j.c.a.l.d();
                                            }
                                            eVar.a(gVar4, bVar2.j.c.f, i, 2);
                                            aVar = bVar2.l;
                                            if (bVar2 == this.as[3]) {
                                                aVar = this.as[1].l;
                                            }
                                            i3 = aVar.d();
                                            if (!(aVar.c == null || aVar.c.a.j.c == null || aVar.c.a.j.c.a != bVar2)) {
                                                i3 += aVar.c.a.j.d();
                                            }
                                            eVar.b(gVar5, aVar.c.f, -i3, 2);
                                        }
                                        if (bVar.h > 0) {
                                            eVar.b(gVar3, gVar2, bVar.h, 2);
                                        }
                                        b b = eVar.b();
                                        b.a(bVar5.X, f, bVar2.X, gVar2, bVar5.j.d(), gVar3, bVar5.l.d(), gVar4, bVar2.j.d(), gVar5, bVar2.l.d());
                                        eVar.a(b);
                                        i = i4 + 1;
                                    }
                                } else {
                                    bVar4 = this.an[0];
                                    i = bVar4.j.d();
                                    if (bVar4.j.c != null) {
                                        i += bVar4.j.c.d();
                                    }
                                    i3 = bVar4.l.d();
                                    if (bVar4.l.c != null) {
                                        i3 += bVar4.l.c.d();
                                    }
                                    gVar = bVar.l.c.f;
                                    if (bVar4 == this.as[3]) {
                                        gVar = this.as[1].l.c.f;
                                    }
                                    if (bVar4.d == 1) {
                                        eVar.a(bVar.j.f, bVar.j.c.f, i, 1);
                                        eVar.b(bVar.l.f, gVar, -i3, 1);
                                        eVar.c(bVar.l.f, bVar.j.f, bVar.l(), 2);
                                    } else {
                                        eVar.c(bVar4.j.f, bVar4.j.c.f, i, 1);
                                        eVar.c(bVar4.l.f, gVar, -i3, 1);
                                    }
                                }
                            } else {
                                a aVar2;
                                int d;
                                int d2;
                                g gVar6;
                                b bVar6 = null;
                                obj3 = null;
                                b bVar7 = null;
                                b bVar8 = bVar2;
                                while (bVar8 != null) {
                                    Object obj4;
                                    b bVar9;
                                    b bVar10;
                                    bVar3 = bVar8.Z;
                                    if (bVar3 == null) {
                                        obj4 = 1;
                                        bVar9 = this.as[1];
                                    } else {
                                        obj4 = obj3;
                                        bVar9 = bVar6;
                                    }
                                    if (obj2 != null) {
                                        aVar2 = bVar8.j;
                                        int d3 = aVar2.d();
                                        if (bVar7 != null) {
                                            d3 += bVar7.l.d();
                                        }
                                        i = 1;
                                        if (bVar2 != bVar8) {
                                            i = 3;
                                        }
                                        g gVar7 = null;
                                        gVar = null;
                                        if (aVar2.c != null) {
                                            gVar7 = aVar2.f;
                                            gVar = aVar2.c.f;
                                        } else if (bVar8.m.c != null) {
                                            gVar7 = bVar8.m.f;
                                            gVar = bVar8.m.c.f;
                                            d3 -= aVar2.d();
                                        }
                                        if (!(gVar7 == null || gVar == null)) {
                                            eVar.a(gVar7, gVar, d3, i);
                                        }
                                        if (bVar8.H == a.MATCH_CONSTRAINT) {
                                            aVar = bVar8.l;
                                            if (bVar8.d == 1) {
                                                eVar.c(aVar.f, aVar2.f, Math.max(bVar8.g, bVar8.l()), 3);
                                            } else {
                                                eVar.a(aVar2.f, aVar2.c.f, aVar2.d, 3);
                                                eVar.b(aVar.f, aVar2.f, bVar8.g, 3);
                                            }
                                        }
                                        bVar10 = bVar3;
                                    } else if (obj != null || obj4 == null || bVar7 == null) {
                                        if (obj != null || obj4 != null || bVar7 != null) {
                                            b bVar11;
                                            a aVar3 = bVar8.j;
                                            aVar2 = bVar8.l;
                                            d = aVar3.d();
                                            d2 = aVar2.d();
                                            eVar.a(aVar3.f, aVar3.c.f, d, 1);
                                            eVar.b(aVar2.f, aVar2.c.f, -d2, 1);
                                            gVar = aVar3.c != null ? aVar3.c.f : null;
                                            if (bVar7 == null) {
                                                gVar = bVar.j.c != null ? bVar.j.c.f : null;
                                            }
                                            if (bVar3 == null) {
                                                bVar11 = bVar9.l.c != null ? bVar9.l.c.a : null;
                                            } else {
                                                bVar11 = bVar3;
                                            }
                                            if (bVar11 != null) {
                                                gVar6 = bVar11.j.f;
                                                if (obj4 != null) {
                                                    gVar6 = bVar9.l.c != null ? bVar9.l.c.f : null;
                                                }
                                                if (!(gVar == null || gVar6 == null)) {
                                                    eVar.a(aVar3.f, gVar, d, 0.5f, gVar6, aVar2.f, d2, 4);
                                                }
                                            }
                                            bVar10 = bVar11;
                                        } else if (bVar8.j.c == null) {
                                            eVar.a(bVar8.j.f, bVar8.o());
                                            bVar10 = bVar3;
                                        } else {
                                            eVar.c(bVar8.j.f, bVar.j.c.f, bVar8.j.d(), 5);
                                            bVar10 = bVar3;
                                        }
                                    } else if (bVar8.l.c == null) {
                                        eVar.a(bVar8.l.f, bVar8.p());
                                        bVar10 = bVar3;
                                    } else {
                                        eVar.c(bVar8.l.f, bVar9.l.c.f, -bVar8.l.d(), 5);
                                        bVar10 = bVar3;
                                    }
                                    if (obj4 != null) {
                                        bVar10 = null;
                                    }
                                    bVar6 = bVar9;
                                    bVar7 = bVar8;
                                    bVar8 = bVar10;
                                    obj3 = obj4;
                                }
                                if (obj2 != null) {
                                    aVar = bVar2.j;
                                    aVar2 = bVar6.l;
                                    d = aVar.d();
                                    d2 = aVar2.d();
                                    gVar = bVar.j.c != null ? bVar.j.c.f : null;
                                    gVar6 = bVar6.l.c != null ? bVar6.l.c.f : null;
                                    if (!(gVar == null || gVar6 == null)) {
                                        eVar.b(aVar2.f, gVar6, -d2, 1);
                                        eVar.a(aVar.f, gVar, d, bVar.F, gVar6, aVar2.f, d2, 4);
                                    }
                                }
                            }
                        } else {
                            e.b(this, eVar, a, bVar);
                        }
                    } else {
                        i = bVar.o();
                        while (bVar2 != null) {
                            eVar.a(bVar2.j.f, i);
                            i += (bVar2.j.d() + bVar2.l()) + bVar2.l.d();
                            bVar2 = bVar2.Z;
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void d(b bVar) {
        int i = 0;
        while (i < this.al) {
            if (this.ap[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
        if (this.al + 1 >= this.ap.length) {
            this.ap = (b[]) Arrays.copyOf(this.ap, this.ap.length * 2);
        }
        this.ap[this.al] = bVar;
        this.al++;
    }

    private void e(b bVar) {
        int i = 0;
        while (i < this.am) {
            if (this.ao[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
        if (this.am + 1 >= this.ao.length) {
            this.ao = (b[]) Arrays.copyOf(this.ao, this.ao.length * 2);
        }
        this.ao[this.am] = bVar;
        this.am++;
    }

    public boolean D() {
        return this.at;
    }

    public boolean E() {
        return this.au;
    }

    public void F() {
        boolean z;
        int size;
        int i;
        b bVar;
        int i2;
        boolean z2;
        int i3;
        int max;
        int i4 = this.w;
        int i5 = this.x;
        int max2 = Math.max(0, h());
        int max3 = Math.max(0, l());
        this.at = false;
        this.au = false;
        if (this.r != null) {
            if (this.ak == null) {
                this.ak = new g(this);
            }
            this.ak.a(this);
            b(this.af);
            c(this.ag);
            A();
            a(this.aa.f());
        } else {
            this.w = 0;
            this.x = 0;
        }
        boolean z3 = false;
        a aVar = this.H;
        a aVar2 = this.G;
        if (this.aq == 2 && (this.H == a.WRAP_CONTENT || this.G == a.WRAP_CONTENT)) {
            a(this.aj, this.ar);
            z3 = this.ar[0];
            if (max2 > 0 && max3 > 0 && (this.ad > max2 || this.ae > max3)) {
                z3 = false;
            }
            if (z3) {
                if (this.G == a.WRAP_CONTENT) {
                    this.G = a.FIXED;
                    if (max2 <= 0 || max2 >= this.ad) {
                        d(Math.max(this.B, this.ad));
                    } else {
                        this.at = true;
                        d(max2);
                    }
                }
                if (this.H == a.WRAP_CONTENT) {
                    this.H = a.FIXED;
                    if (max3 <= 0 || max3 >= this.ae) {
                        e(Math.max(this.C, this.ae));
                    } else {
                        this.au = true;
                        e(max3);
                        z = z3;
                        J();
                        size = this.aj.size();
                        for (i = 0; i < size; i++) {
                            bVar = (b) this.aj.get(i);
                            if (bVar instanceof h) {
                                ((h) bVar).F();
                            }
                        }
                        i2 = 0;
                        z2 = z;
                        z = true;
                        while (z) {
                            i3 = i2 + 1;
                            try {
                                this.aa.a();
                                z = c(this.aa, Integer.MAX_VALUE);
                                if (z) {
                                    this.aa.e();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (z) {
                                b(this.aa, Integer.MAX_VALUE);
                                while (max < size) {
                                    bVar = (b) this.aj.get(max);
                                    if (bVar.G == a.MATCH_CONSTRAINT || bVar.h() >= bVar.k()) {
                                        if (bVar.H != a.MATCH_CONSTRAINT && bVar.l() < bVar.m()) {
                                            this.ar[2] = true;
                                            break;
                                        }
                                    } else {
                                        this.ar[2] = true;
                                        break;
                                    }
                                }
                            }
                            a(this.aa, Integer.MAX_VALUE, this.ar);
                            if (i3 < 8 || !this.ar[2]) {
                                z3 = false;
                                z = z2;
                            } else {
                                int i6;
                                int i7 = 0;
                                int i8 = 0;
                                for (i6 = 0; i6 < size; i6++) {
                                    bVar = (b) this.aj.get(i6);
                                    i7 = Math.max(i7, bVar.w + bVar.h());
                                    i8 = Math.max(i8, bVar.l() + bVar.x);
                                }
                                i2 = Math.max(this.B, i7);
                                i6 = Math.max(this.C, i8);
                                if (aVar2 != a.WRAP_CONTENT || h() >= i2) {
                                    z3 = false;
                                    z = z2;
                                } else {
                                    d(i2);
                                    this.G = a.WRAP_CONTENT;
                                    z = true;
                                    z3 = true;
                                }
                                if (aVar == a.WRAP_CONTENT && l() < i6) {
                                    e(i6);
                                    this.H = a.WRAP_CONTENT;
                                    z = true;
                                    z3 = true;
                                }
                            }
                            i = Math.max(this.B, h());
                            if (i > h()) {
                                d(i);
                                this.G = a.FIXED;
                                z = true;
                                z3 = true;
                            }
                            i = Math.max(this.C, l());
                            if (i > l()) {
                                e(i);
                                this.H = a.FIXED;
                                z = true;
                                z3 = true;
                            }
                            if (z) {
                                if (this.G == a.WRAP_CONTENT && max2 > 0 && h() > max2) {
                                    this.at = true;
                                    z = true;
                                    this.G = a.FIXED;
                                    d(max2);
                                    z3 = true;
                                }
                                if (this.H == a.WRAP_CONTENT && max3 > 0 && l() > max3) {
                                    this.au = true;
                                    z = true;
                                    this.H = a.FIXED;
                                    e(max3);
                                    z3 = true;
                                }
                            }
                            z2 = z;
                            z = z3;
                            i2 = i3;
                        }
                        if (this.r == null) {
                            i2 = Math.max(this.B, h());
                            max = Math.max(this.C, l());
                            this.ak.b(this);
                            d((i2 + this.af) + this.ah);
                            e((this.ag + max) + this.ai);
                        } else {
                            this.w = i4;
                            this.x = i5;
                        }
                        if (z2) {
                            this.G = aVar2;
                            this.H = aVar;
                        }
                        a(this.aa.f());
                        if (this == H()) {
                            z();
                        }
                    }
                }
            }
        }
        z = z3;
        J();
        size = this.aj.size();
        for (i = 0; i < size; i++) {
            bVar = (b) this.aj.get(i);
            if (bVar instanceof h) {
                ((h) bVar).F();
            }
        }
        i2 = 0;
        z2 = z;
        z = true;
        while (z) {
            i3 = i2 + 1;
            this.aa.a();
            z = c(this.aa, Integer.MAX_VALUE);
            if (z) {
                this.aa.e();
            }
            if (z) {
                b(this.aa, Integer.MAX_VALUE);
                for (max = 0; max < size; max++) {
                    bVar = (b) this.aj.get(max);
                    if (bVar.G == a.MATCH_CONSTRAINT) {
                    }
                    if (bVar.H != a.MATCH_CONSTRAINT) {
                    }
                }
            } else {
                a(this.aa, Integer.MAX_VALUE, this.ar);
            }
            if (i3 < 8) {
            }
            z3 = false;
            z = z2;
            i = Math.max(this.B, h());
            if (i > h()) {
                d(i);
                this.G = a.FIXED;
                z = true;
                z3 = true;
            }
            i = Math.max(this.C, l());
            if (i > l()) {
                e(i);
                this.H = a.FIXED;
                z = true;
                z3 = true;
            }
            if (z) {
                this.at = true;
                z = true;
                this.G = a.FIXED;
                d(max2);
                z3 = true;
                this.au = true;
                z = true;
                this.H = a.FIXED;
                e(max3);
                z3 = true;
            }
            z2 = z;
            z = z3;
            i2 = i3;
        }
        if (this.r == null) {
            this.w = i4;
            this.x = i5;
        } else {
            i2 = Math.max(this.B, h());
            max = Math.max(this.C, l());
            this.ak.b(this);
            d((i2 + this.af) + this.ah);
            e((this.ag + max) + this.ai);
        }
        if (z2) {
            this.G = aVar2;
            this.H = aVar;
        }
        a(this.aa.f());
        if (this == H()) {
            z();
        }
    }

    public boolean G() {
        return false;
    }

    public void a() {
        this.aa.a();
        this.af = 0;
        this.ah = 0;
        this.ag = 0;
        this.ai = 0;
        super.a();
    }

    void a(b bVar, int i) {
        if (i == 0) {
            while (bVar.i.c != null && bVar.i.c.a.k.c != null && bVar.i.c.a.k.c == bVar.i && bVar.i.c.a != bVar) {
                bVar = bVar.i.c.a;
            }
            d(bVar);
        } else if (i == 1) {
            while (bVar.j.c != null && bVar.j.c.a.l.c != null && bVar.j.c.a.l.c == bVar.j && bVar.j.c.a != bVar) {
                bVar = bVar.j.c.a;
            }
            e(bVar);
        }
    }

    public void a(b bVar, boolean[] zArr) {
        b bVar2 = null;
        boolean z = false;
        if (bVar.G == a.MATCH_CONSTRAINT && bVar.H == a.MATCH_CONSTRAINT && bVar.u > 0.0f) {
            zArr[0] = false;
            return;
        }
        boolean i = bVar.i();
        if (bVar.G != a.MATCH_CONSTRAINT || bVar.H == a.MATCH_CONSTRAINT || bVar.u <= 0.0f) {
            int i2;
            int i3;
            bVar.Q = true;
            if (bVar instanceof d) {
                int i4;
                d dVar = (d) bVar;
                if (dVar.D() != 1) {
                    i4 = i2;
                    z = i2;
                } else if (dVar.F() != -1) {
                    i4 = dVar.F();
                } else if (dVar.G() != -1) {
                    i2 = dVar.G();
                    i4 = 0;
                    z = i2;
                } else {
                    i4 = 0;
                }
                i2 = i4;
                i3 = z;
            } else if (!bVar.k.j() && !bVar.i.j()) {
                boolean i32 = i2;
                i2 = bVar.f() + i2;
            } else if (bVar.k.c == null || bVar.i.c == null || (bVar.k.c != bVar.i.c && (bVar.k.c.a != bVar.i.c.a || bVar.k.c.a == bVar.r))) {
                b bVar3;
                if (bVar.k.c != null) {
                    bVar3 = bVar.k.c.a;
                    i32 = bVar.k.d() + i2;
                    if (!(bVar3.b() || bVar3.Q)) {
                        a(bVar3, zArr);
                    }
                } else {
                    bVar3 = null;
                    i32 = i2;
                }
                if (bVar.i.c != null) {
                    bVar2 = bVar.i.c.a;
                    i2 = i2 + bVar.i.d();
                    if (!(bVar2.b() || bVar2.Q)) {
                        a(bVar2, zArr);
                    }
                }
                if (!(bVar.k.c == null || bVar3.b())) {
                    if (bVar.k.c.b == android.support.constraint.a.a.a.c.RIGHT) {
                        i32 += bVar3.K - bVar3.i();
                    } else if (bVar.k.c.c() == android.support.constraint.a.a.a.c.LEFT) {
                        i32 += bVar3.K;
                    }
                    boolean z2 = bVar3.N || !(bVar3.i.c == null || bVar3.k.c == null || bVar3.G == a.MATCH_CONSTRAINT);
                    bVar.N = z2;
                    if (bVar.N && (bVar3.i.c == null || bVar3.i.c.a != bVar)) {
                        i32 += i32 - bVar3.K;
                    }
                }
                if (!(bVar.i.c == null || bVar2.b())) {
                    if (bVar.i.c.c() == android.support.constraint.a.a.a.c.LEFT) {
                        i2 += bVar2.J - bVar2.i();
                    } else if (bVar.i.c.c() == android.support.constraint.a.a.a.c.RIGHT) {
                        i2 += bVar2.J;
                    }
                    if (bVar2.M || !(bVar2.i.c == null || bVar2.k.c == null || bVar2.G == a.MATCH_CONSTRAINT)) {
                        z = true;
                    }
                    bVar.M = z;
                    if (bVar.M && (bVar2.k.c == null || bVar2.k.c.a != bVar)) {
                        i2 += i2 - bVar2.J;
                    }
                }
            } else {
                zArr[0] = false;
                return;
            }
            if (bVar.d() == 8) {
                i2 -= bVar.s;
                i32 -= bVar.s;
            }
            bVar.J = i2;
            bVar.K = i32;
            return;
        }
        zArr[0] = false;
    }

    public void a(e eVar, int i, boolean[] zArr) {
        zArr[2] = false;
        b(eVar, i);
        int size = this.aj.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.aj.get(i2);
            bVar.b(eVar, i);
            if (bVar.G == a.MATCH_CONSTRAINT && bVar.h() < bVar.k()) {
                zArr[2] = true;
            }
            if (bVar.H == a.MATCH_CONSTRAINT && bVar.l() < bVar.m()) {
                zArr[2] = true;
            }
        }
    }

    public void a(ArrayList<b> arrayList, boolean[] zArr) {
        b bVar;
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int size = arrayList.size();
        zArr[0] = true;
        int i8 = 0;
        while (i8 < size) {
            int i9;
            bVar = (b) arrayList.get(i8);
            if (bVar.b()) {
                i9 = i7;
                i = i6;
            } else {
                if (!bVar.Q) {
                    a(bVar, zArr);
                }
                if (!bVar.R) {
                    b(bVar, zArr);
                }
                if (zArr[0]) {
                    i = (bVar.J + bVar.K) - bVar.h();
                    int l = (bVar.I + bVar.L) - bVar.l();
                    if (bVar.G == a.MATCH_PARENT) {
                        i = (bVar.h() + bVar.i.d) + bVar.k.d;
                    }
                    if (bVar.H == a.MATCH_PARENT) {
                        l = (bVar.l() + bVar.j.d) + bVar.l.d;
                    }
                    if (bVar.d() == 8) {
                        i = 0;
                        l = 0;
                    }
                    i3 = Math.max(i3, bVar.J);
                    i4 = Math.max(i4, bVar.K);
                    i5 = Math.max(i5, bVar.L);
                    i2 = Math.max(i2, bVar.I);
                    i = Math.max(i6, i);
                    i9 = Math.max(i7, l);
                } else {
                    return;
                }
            }
            i8++;
            i3 = i3;
            i2 = i2;
            i5 = i5;
            i4 = i4;
            i6 = i;
            i7 = i9;
        }
        this.ad = Math.max(this.B, Math.max(Math.max(i3, i4), i6));
        this.ae = Math.max(this.C, Math.max(Math.max(i2, i5), i7));
        for (i = 0; i < size; i++) {
            bVar = (b) arrayList.get(i);
            bVar.Q = false;
            bVar.R = false;
            bVar.M = false;
            bVar.N = false;
            bVar.O = false;
            bVar.P = false;
        }
    }

    public void b(b bVar, boolean[] zArr) {
        b bVar2 = null;
        boolean z = false;
        if (bVar.H != a.MATCH_CONSTRAINT || bVar.G == a.MATCH_CONSTRAINT || bVar.u <= 0.0f) {
            int i;
            int i2;
            boolean i3 = bVar.j();
            bVar.R = true;
            int i4;
            b b;
            if (bVar instanceof d) {
                d dVar = (d) bVar;
                if (dVar.D() != 0) {
                    i4 = i3;
                    z = i3;
                } else if (dVar.F() != -1) {
                    i3 = dVar.F();
                    i4 = 0;
                    z = i3;
                } else {
                    i4 = dVar.G() != -1 ? dVar.G() : 0;
                }
                i3 = i4;
                i2 = z;
            } else if (bVar.m.c == null && bVar.j.c == null && bVar.l.c == null) {
                i2 = i3 + bVar.g();
            } else if (bVar.l.c != null && bVar.j.c != null && (bVar.l.c == bVar.j.c || (bVar.l.c.a == bVar.j.c.a && bVar.l.c.a != bVar.r))) {
                zArr[0] = false;
                return;
            } else if (bVar.m.j()) {
                b = bVar.m.c.b();
                if (!b.R) {
                    b(b, zArr);
                }
                int max = Math.max((b.I - b.t) + i3, i3);
                i4 = Math.max((b.L - b.t) + i3, i3);
                if (bVar.d() == 8) {
                    max -= bVar.t;
                    i4 -= bVar.t;
                }
                bVar.I = max;
                bVar.L = i4;
                return;
            } else {
                if (bVar.j.j()) {
                    b = bVar.j.c.b();
                    i2 = bVar.j.d() + i3;
                    if (!(b.b() || b.R)) {
                        b(b, zArr);
                    }
                } else {
                    b = null;
                    i2 = i3;
                }
                if (bVar.l.j()) {
                    bVar2 = bVar.l.c.b();
                    i3 = i3 + bVar.l.d();
                    if (!(bVar2.b() || bVar2.R)) {
                        b(bVar2, zArr);
                    }
                }
                if (!(bVar.j.c == null || b.b())) {
                    if (bVar.j.c.c() == android.support.constraint.a.a.a.c.TOP) {
                        i2 += b.I - b.j();
                    } else if (bVar.j.c.c() == android.support.constraint.a.a.a.c.BOTTOM) {
                        i2 += b.I;
                    }
                    boolean z2 = b.O || !(b.j.c == null || b.j.c.a == bVar || b.l.c == null || b.l.c.a == bVar || b.H == a.MATCH_CONSTRAINT);
                    bVar.O = z2;
                    if (bVar.O && (b.l.c == null || b.l.c.a != bVar)) {
                        i2 += i2 - b.I;
                    }
                }
                if (!(bVar.l.c == null || bVar2.b())) {
                    if (bVar.l.c.c() == android.support.constraint.a.a.a.c.BOTTOM) {
                        i3 += bVar2.L - bVar2.j();
                    } else if (bVar.l.c.c() == android.support.constraint.a.a.a.c.TOP) {
                        i3 += bVar2.L;
                    }
                    if (bVar2.P || !(bVar2.j.c == null || bVar2.j.c.a == bVar || bVar2.l.c == null || bVar2.l.c.a == bVar || bVar2.H == a.MATCH_CONSTRAINT)) {
                        z = true;
                    }
                    bVar.P = z;
                    if (bVar.P && (bVar2.j.c == null || bVar2.j.c.a != bVar)) {
                        i3 += i3 - bVar2.L;
                    }
                }
            }
            if (bVar.d() == 8) {
                i2 -= bVar.t;
                i3 -= bVar.t;
            }
            bVar.I = i2;
            bVar.L = i3;
            return;
        }
        zArr[0] = false;
    }

    public boolean c(e eVar, int i) {
        boolean z;
        a(eVar, i);
        int size = this.aj.size();
        if (this.aq != 2 && this.aq != 4) {
            z = true;
        } else if (a(eVar)) {
            return false;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.aj.get(i2);
            if (bVar instanceof c) {
                a aVar = bVar.G;
                a aVar2 = bVar.H;
                if (aVar == a.WRAP_CONTENT) {
                    bVar.a(a.FIXED);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    bVar.b(a.FIXED);
                }
                bVar.a(eVar, i);
                if (aVar == a.WRAP_CONTENT) {
                    bVar.a(aVar);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    bVar.b(aVar2);
                }
            } else {
                if (z) {
                    e.a(this, eVar, bVar);
                }
                bVar.a(eVar, i);
            }
        }
        if (this.al > 0) {
            b(eVar);
        }
        if (this.am > 0) {
            c(eVar);
        }
        return true;
    }

    public void m(int i) {
        this.aq = i;
    }
}
