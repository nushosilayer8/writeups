package android.support.constraint.a;

import java.util.Arrays;

public class a {
    int a = 0;
    private final b b;
    private final c c;
    private int d = 8;
    private g e = null;
    private int[] f = new int[this.d];
    private int[] g = new int[this.d];
    private float[] h = new float[this.d];
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    a(b bVar, c cVar) {
        this.b = bVar;
        this.c = cVar;
    }

    public final float a(g gVar) {
        if (this.e == gVar) {
            this.e = null;
        }
        if (this.i == -1) {
            return 0.0f;
        }
        int i = this.i;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            int i4 = this.f[i];
            if (i4 == gVar.a) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    this.g[i3] = this.g[i];
                }
                this.c.c[i4].b(this.b);
                this.a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            int i5 = i;
            i = this.g[i];
            i3 = i5;
        }
        return 0.0f;
    }

    final g a(int i) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (i3 == i) {
                return this.c.c[this.f[i2]];
            }
            i2 = this.g[i2];
            i3++;
        }
        return null;
    }

    public final void a() {
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }

    void a(float f) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
            i2++;
        }
    }

    void a(b bVar) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            this.c.c[this.f[i]].a(bVar);
            i = this.g[i];
            i2++;
        }
    }

    void a(b bVar, b bVar2) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            if (this.f[i] == bVar2.a.a) {
                float f = this.h[i];
                a(bVar2.a);
                a aVar = bVar2.d;
                i = aVar.i;
                i2 = 0;
                while (i != -1 && i2 < aVar.a) {
                    b(this.c.c[aVar.f[i]], aVar.h[i] * f);
                    i = aVar.g[i];
                    i2++;
                }
                bVar.b += bVar2.b * f;
                bVar2.a.b(bVar);
                i = this.i;
                i2 = 0;
            } else {
                i = this.g[i];
                i2++;
            }
        }
    }

    void a(b bVar, b[] bVarArr) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            g gVar = this.c.c[this.f[i]];
            if (gVar.b != -1) {
                float f = this.h[i];
                a(gVar);
                b bVar2 = bVarArr[gVar.b];
                if (!bVar2.e) {
                    a aVar = bVar2.d;
                    i = aVar.i;
                    i2 = 0;
                    while (i != -1 && i2 < aVar.a) {
                        b(this.c.c[aVar.f[i]], aVar.h[i] * f);
                        i = aVar.g[i];
                        i2++;
                    }
                }
                bVar.b += bVar2.b * f;
                bVar2.a.b(bVar);
                i = this.i;
                i2 = 0;
            } else {
                i = this.g[i];
                i2++;
            }
        }
    }

    public final void a(g gVar, float f) {
        if (f == 0.0f) {
            a(gVar);
        } else if (this.i == -1) {
            this.i = 0;
            this.h[this.i] = f;
            this.f[this.i] = gVar.a;
            this.g[this.i] = -1;
            this.a++;
            if (!this.k) {
                this.j++;
            }
        } else {
            int i = this.i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.a) {
                if (this.f[i] == gVar.a) {
                    this.h[i] = f;
                    return;
                }
                if (this.f[i] < gVar.a) {
                    i3 = i;
                }
                i2++;
                i = this.g[i];
            }
            i = this.j + 1;
            if (this.k) {
                i = this.f[this.j] == -1 ? this.j : this.f.length;
            }
            if (i >= this.f.length && this.a < this.f.length) {
                for (i2 = 0; i2 < this.f.length; i2++) {
                    if (this.f[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f.length) {
                i = this.f.length;
                this.d *= 2;
                this.k = false;
                this.j = i - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i] = gVar.a;
            this.h[i] = f;
            if (i3 != -1) {
                this.g[i] = this.g[i3];
                this.g[i3] = i;
            } else {
                this.g[i] = this.i;
                this.i = i;
            }
            this.a++;
            if (!this.k) {
                this.j++;
            }
            if (this.a >= this.f.length) {
                this.k = true;
            }
        }
    }

    final float b(int i) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
            i3++;
        }
        return 0.0f;
    }

    void b() {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * -1.0f;
            i = this.g[i];
            i2++;
        }
    }

    public final void b(g gVar, float f) {
        if (f != 0.0f) {
            if (this.i == -1) {
                this.i = 0;
                this.h[this.i] = f;
                this.f[this.i] = gVar.a;
                this.g[this.i] = -1;
                this.a++;
                if (!this.k) {
                    this.j++;
                    return;
                }
                return;
            }
            int i = this.i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.a) {
                int i4 = this.f[i];
                if (i4 == gVar.a) {
                    float[] fArr = this.h;
                    fArr[i] = fArr[i] + f;
                    if (this.h[i] == 0.0f) {
                        if (i == this.i) {
                            this.i = this.g[i];
                        } else {
                            this.g[i3] = this.g[i];
                        }
                        this.c.c[i4].b(this.b);
                        if (this.k) {
                            this.j = i;
                        }
                        this.a--;
                        return;
                    }
                    return;
                }
                if (this.f[i] < gVar.a) {
                    i3 = i;
                }
                i2++;
                i = this.g[i];
            }
            i = this.j + 1;
            if (this.k) {
                i = this.f[this.j] == -1 ? this.j : this.f.length;
            }
            if (i >= this.f.length && this.a < this.f.length) {
                for (i2 = 0; i2 < this.f.length; i2++) {
                    if (this.f[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f.length) {
                i = this.f.length;
                this.d *= 2;
                this.k = false;
                this.j = i - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i] = gVar.a;
            this.h[i] = f;
            if (i3 != -1) {
                this.g[i] = this.g[i3];
                this.g[i3] = i;
            } else {
                this.g[i] = this.i;
                this.i = i;
            }
            this.a++;
            if (!this.k) {
                this.j++;
            }
            if (this.j >= this.f.length) {
                this.k = true;
                this.j = this.f.length - 1;
            }
        }
    }

    final boolean b(g gVar) {
        if (this.i == -1) {
            return false;
        }
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            if (this.f[i] == gVar.a) {
                return true;
            }
            i = this.g[i];
            i2++;
        }
        return false;
    }

    public final float c(g gVar) {
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            if (this.f[i] == gVar.a) {
                return this.h[i];
            }
            i = this.g[i];
            i2++;
        }
        return 0.0f;
    }

    g c() {
        g gVar = null;
        int i = 0;
        int i2 = this.i;
        g gVar2 = null;
        while (i2 != -1 && i < this.a) {
            float f;
            g gVar3;
            float f2 = this.h[i2];
            if (f2 < 0.0f) {
                if (f2 > (-981668463)) {
                    this.h[i2] = 0.0f;
                    f = 0.0f;
                }
                f = f2;
            } else {
                if (f2 < 0.001f) {
                    this.h[i2] = 0.0f;
                    f = 0.0f;
                }
                f = f2;
            }
            if (f != 0.0f) {
                gVar3 = this.c.c[this.f[i2]];
                if (gVar3.f == android.support.constraint.a.g.a.UNRESTRICTED) {
                    if (f < 0.0f) {
                        return gVar3;
                    }
                    if (gVar2 == null) {
                        gVar2 = gVar;
                        i++;
                        i2 = this.g[i2];
                        gVar = gVar2;
                        gVar2 = gVar3;
                    }
                } else if (f < 0.0f && (gVar == null || gVar3.c < gVar.c)) {
                    g gVar4 = gVar2;
                    gVar2 = gVar3;
                    gVar3 = gVar4;
                    i++;
                    i2 = this.g[i2];
                    gVar = gVar2;
                    gVar2 = gVar3;
                }
            }
            gVar3 = gVar2;
            gVar2 = gVar;
            i++;
            i2 = this.g[i2];
            gVar = gVar2;
            gVar2 = gVar3;
        }
        return gVar2 != null ? gVar2 : gVar;
    }

    public String toString() {
        String str = "";
        int i = this.i;
        int i2 = 0;
        while (i != -1 && i2 < this.a) {
            str = ((str + " -> ") + this.h[i] + " : ") + this.c.c[this.f[i]];
            i = this.g[i];
            i2++;
        }
        return str;
    }
}
