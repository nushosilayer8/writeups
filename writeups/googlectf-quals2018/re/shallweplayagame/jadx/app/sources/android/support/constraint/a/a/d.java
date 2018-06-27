package android.support.constraint.a.a;

import android.support.constraint.a.a.a.c;
import android.support.constraint.a.e;
import java.util.ArrayList;

public class d extends b {
    protected float aa = -1.0f;
    protected int ab = -1;
    protected int ac = -1;
    private a ad = this.j;
    private int ae = 0;
    private boolean af = false;
    private int ag = 0;
    private f ah = new f();
    private int ai = 8;

    public d() {
        this.q.clear();
        this.q.add(this.ad);
    }

    public int D() {
        return this.ae;
    }

    public float E() {
        return this.aa;
    }

    public int F() {
        return this.ab;
    }

    public int G() {
        return this.ac;
    }

    public a a(c cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.ae == 1) {
                    return this.ad;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.ae == 0) {
                    return this.ad;
                }
                break;
        }
        return null;
    }

    public void a(e eVar, int i) {
        c cVar = (c) c();
        if (cVar != null) {
            Object a;
            Object a2 = cVar.a(c.LEFT);
            a a3 = cVar.a(c.RIGHT);
            if (this.ae == 0) {
                a3 = cVar.a(c.TOP);
                a = cVar.a(c.BOTTOM);
                a2 = a3;
            } else {
                a a4 = a3;
            }
            if (this.ab != -1) {
                eVar.a(e.a(eVar, eVar.a(this.ad), eVar.a(a2), this.ab, false));
            } else if (this.ac != -1) {
                eVar.a(e.a(eVar, eVar.a(this.ad), eVar.a(a4), -this.ac, false));
            } else if (this.aa != -1.0f) {
                eVar.a(e.a(eVar, eVar.a(this.ad), eVar.a(a2), eVar.a(a4), this.aa, this.af));
            }
        }
    }

    public void b(e eVar, int i) {
        if (c() != null) {
            int b = eVar.b(this.ad);
            if (this.ae == 1) {
                b(b);
                c(0);
                e(c().l());
                d(0);
                return;
            }
            b(0);
            c(b);
            d(c().h());
            e(0);
        }
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.aa = f;
            this.ab = -1;
            this.ac = -1;
        }
    }

    public void m(int i) {
        if (this.ae != i) {
            this.ae = i;
            this.q.clear();
            if (this.ae == 1) {
                this.ad = this.i;
            } else {
                this.ad = this.j;
            }
            this.q.add(this.ad);
        }
    }

    public void n(int i) {
        if (i > -1) {
            this.aa = -1.0f;
            this.ab = i;
            this.ac = -1;
        }
    }

    public void o(int i) {
        if (i > -1) {
            this.aa = -1.0f;
            this.ab = -1;
            this.ac = i;
        }
    }

    public ArrayList<a> y() {
        return this.q;
    }
}
