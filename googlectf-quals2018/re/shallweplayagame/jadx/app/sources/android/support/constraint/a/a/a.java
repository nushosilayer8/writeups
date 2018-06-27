package android.support.constraint.a.a;

import android.support.constraint.a.g;
import java.util.HashSet;

public class a {
    final b a;
    final c b;
    a c;
    public int d = 0;
    int e = -1;
    g f;
    int g = Integer.MAX_VALUE;
    private b h = b.NONE;
    private a i = a.RELAXED;
    private int j = 0;

    public enum a {
        RELAXED,
        STRICT
    }

    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public a(b bVar, c cVar) {
        this.a = bVar;
        this.b = cVar;
    }

    private String a(HashSet<a> hashSet) {
        if (!hashSet.add(this)) {
            return "<-";
        }
        return this.a.e() + ":" + this.b.toString() + (this.c != null ? " connected to " + this.c.a((HashSet) hashSet) : "");
    }

    public g a() {
        return this.f;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(android.support.constraint.a.c cVar) {
        if (this.f == null) {
            this.f = new g(android.support.constraint.a.g.a.UNRESTRICTED);
        } else {
            this.f.c();
        }
    }

    public boolean a(a aVar) {
        boolean z = true;
        if (aVar == null) {
            return false;
        }
        c c = aVar.c();
        if (c == this.b) {
            return this.b != c.CENTER ? this.b != c.BASELINE || (aVar.b().v() && b().v()) : false;
        } else {
            boolean z2;
            switch (this.b) {
                case CENTER:
                    if (c == c.BASELINE || c == c.CENTER_X || c == c.CENTER_Y) {
                        z = false;
                    }
                    return z;
                case LEFT:
                case RIGHT:
                    z2 = c == c.LEFT || c == c.RIGHT;
                    if (aVar.b() instanceof d) {
                        return z2 || c == c.CENTER_X;
                    }
                    break;
                case TOP:
                case BOTTOM:
                    z2 = c == c.TOP || c == c.BOTTOM;
                    if (aVar.b() instanceof d) {
                        return z2 || c == c.CENTER_Y;
                    }
                    break;
                default:
                    return false;
            }
            return z2;
        }
    }

    public boolean a(a aVar, int i, int i2, b bVar, int i3, boolean z) {
        if (aVar == null) {
            this.c = null;
            this.d = 0;
            this.e = -1;
            this.h = b.NONE;
            this.j = 2;
            return true;
        } else if (!z && !a(aVar)) {
            return false;
        } else {
            this.c = aVar;
            if (i > 0) {
                this.d = i;
            } else {
                this.d = 0;
            }
            this.e = i2;
            this.h = bVar;
            this.j = i3;
            return true;
        }
    }

    public boolean a(a aVar, int i, b bVar, int i2) {
        return a(aVar, i, -1, bVar, i2, false);
    }

    public b b() {
        return this.a;
    }

    public c c() {
        return this.b;
    }

    public int d() {
        return this.a.d() == 8 ? 0 : (this.e <= -1 || this.c == null || this.c.a.d() != 8) ? this.d : this.e;
    }

    public b e() {
        return this.h;
    }

    public a f() {
        return this.c;
    }

    public a g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.h = b.STRONG;
        this.j = 0;
        this.i = a.RELAXED;
    }

    public boolean j() {
        return this.c != null;
    }

    public String toString() {
        return this.a.e() + ":" + this.b.toString() + (this.c != null ? " connected to " + this.c.a(new HashSet()) : "");
    }
}
