package android.support.constraint.a;

import android.support.constraint.a.g.a;

public class b {
    g a = null;
    float b = 0.0f;
    boolean c = false;
    final a d;
    boolean e = false;

    public b(c cVar) {
        this.d = new a(this, cVar);
    }

    public b a(float f, float f2, float f3, g gVar, int i, g gVar2, int i2, g gVar3, int i3, g gVar4, int i4) {
        if (f2 == 0.0f || f == f3) {
            this.b = (float) ((((-i) - i2) + i3) + i4);
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
            this.d.a(gVar4, 1.0f);
            this.d.a(gVar3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.b = (((float) ((-i) - i2)) + (((float) i3) * f4)) + (((float) i4) * f4);
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
            this.d.a(gVar4, f4);
            this.d.a(gVar3, -f4);
        }
        return this;
    }

    b a(g gVar, int i) {
        this.a = gVar;
        gVar.d = (float) i;
        this.b = (float) i;
        this.e = true;
        return this;
    }

    public b a(g gVar, g gVar2) {
        this.d.a(gVar, 1.0f);
        this.d.a(gVar2, -1.0f);
        return this;
    }

    public b a(g gVar, g gVar2, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.b = (float) i;
        }
        if (obj == null) {
            this.d.a(gVar, -1.0f);
            this.d.a(gVar2, 1.0f);
        } else {
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
        }
        return this;
    }

    b a(g gVar, g gVar2, int i, float f, g gVar3, g gVar4, int i2) {
        if (gVar2 == gVar3) {
            this.d.a(gVar, 1.0f);
            this.d.a(gVar4, 1.0f);
            this.d.a(gVar2, -2.0f);
        } else if (f == 0.5f) {
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
            this.d.a(gVar3, -1.0f);
            this.d.a(gVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.d.a(gVar, -1.0f);
            this.d.a(gVar2, 1.0f);
            this.b = (float) i;
        } else if (f >= 1.0f) {
            this.d.a(gVar3, -1.0f);
            this.d.a(gVar4, 1.0f);
            this.b = (float) i2;
        } else {
            this.d.a(gVar, (1.0f - f) * 1.0f);
            this.d.a(gVar2, (1.0f - f) * -1.0f);
            this.d.a(gVar3, -1.0f * f);
            this.d.a(gVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        return this;
    }

    b a(g gVar, g gVar2, g gVar3, float f) {
        this.d.a(gVar, -1.0f);
        this.d.a(gVar2, 1.0f - f);
        this.d.a(gVar3, f);
        return this;
    }

    public b a(g gVar, g gVar2, g gVar3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.b = (float) i;
        }
        if (obj == null) {
            this.d.a(gVar, -1.0f);
            this.d.a(gVar2, 1.0f);
            this.d.a(gVar3, 1.0f);
        } else {
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
            this.d.a(gVar3, -1.0f);
        }
        return this;
    }

    public b a(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.d.a(gVar, -1.0f);
        this.d.a(gVar2, 1.0f);
        this.d.a(gVar3, f);
        this.d.a(gVar4, -f);
        return this;
    }

    void a() {
        this.d.a(this);
    }

    boolean a(b bVar) {
        this.d.a(this, bVar);
        return true;
    }

    boolean a(g gVar) {
        return this.d.b(gVar);
    }

    public b b(g gVar, int i) {
        if (i < 0) {
            this.b = (float) (i * -1);
            this.d.a(gVar, 1.0f);
        } else {
            this.b = (float) i;
            this.d.a(gVar, -1.0f);
        }
        return this;
    }

    public b b(g gVar, g gVar2, g gVar3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.b = (float) i;
        }
        if (obj == null) {
            this.d.a(gVar, -1.0f);
            this.d.a(gVar2, 1.0f);
            this.d.a(gVar3, -1.0f);
        } else {
            this.d.a(gVar, 1.0f);
            this.d.a(gVar2, -1.0f);
            this.d.a(gVar3, 1.0f);
        }
        return this;
    }

    void b(g gVar) {
        if (this.a != null) {
            this.d.a(this.a, -1.0f);
            this.a = null;
        }
        float a = this.d.a(gVar) * -1.0f;
        this.a = gVar;
        if (a != 1.0f) {
            this.b /= a;
            this.d.a(a);
        }
    }

    boolean b() {
        return this.a != null && (this.a.f == a.UNRESTRICTED || this.b >= 0.0f);
    }

    b c(g gVar, int i) {
        this.d.a(gVar, (float) i);
        return this;
    }

    String c() {
        String str;
        Object obj;
        String str2 = "";
        str2 = (this.a == null ? str2 + "0" : str2 + this.a) + " = ";
        if (this.b != 0.0f) {
            str = str2 + this.b;
            obj = 1;
        } else {
            str = str2;
            obj = null;
        }
        int i = this.d.a;
        String str3 = str;
        for (int i2 = 0; i2 < i; i2++) {
            g a = this.d.a(i2);
            if (a != null) {
                float f;
                float b = this.d.b(i2);
                String gVar = a.toString();
                if (obj == null) {
                    if (b < 0.0f) {
                        str3 = str3 + "- ";
                        f = b * -1.0f;
                    } else {
                        f = b;
                    }
                } else if (b > 0.0f) {
                    str3 = str3 + " + ";
                    f = b;
                } else {
                    str3 = str3 + " - ";
                    f = b * -1.0f;
                }
                str3 = f == 1.0f ? str3 + gVar : str3 + f + " " + gVar;
                int i3 = 1;
            }
        }
        return obj == null ? str3 + "0.0" : str3;
    }

    public void d() {
        this.a = null;
        this.d.a();
        this.b = 0.0f;
        this.e = false;
    }

    void e() {
        if (this.b < 0.0f) {
            this.b *= -1.0f;
            this.d.b();
        }
    }

    void f() {
        g c = this.d.c();
        if (c != null) {
            b(c);
        }
        if (this.d.a == 0) {
            this.e = true;
        }
    }

    public String toString() {
        return c();
    }
}
