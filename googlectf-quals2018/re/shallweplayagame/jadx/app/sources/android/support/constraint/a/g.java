package android.support.constraint.a;

import java.util.Arrays;

public class g {
    private static int i = 1;
    public int a = -1;
    int b = -1;
    public int c = 0;
    public float d;
    float[] e = new float[6];
    a f;
    b[] g = new b[8];
    int h = 0;
    private String j;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f = aVar;
    }

    void a() {
        for (int i = 0; i < 6; i++) {
            this.e[i] = 0.0f;
        }
    }

    void a(b bVar) {
        int i = 0;
        while (i < this.h) {
            if (this.g[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
        if (this.h >= this.g.length) {
            this.g = (b[]) Arrays.copyOf(this.g, this.g.length * 2);
        }
        this.g[this.h] = bVar;
        this.h++;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    String b() {
        String str = this + "[";
        int i = 0;
        while (i < this.e.length) {
            str = str + this.e[i];
            str = i < this.e.length + -1 ? str + ", " : str + "] ";
            i++;
        }
        return str;
    }

    void b(b bVar) {
        int i = 0;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.g[i2] == bVar) {
                while (i < (this.h - i2) - 1) {
                    this.g[i2 + i] = this.g[(i2 + i) + 1];
                    i++;
                }
                this.h--;
                return;
            }
        }
    }

    public void c() {
        this.j = null;
        this.f = a.UNKNOWN;
        this.c = 0;
        this.a = -1;
        this.b = -1;
        this.d = 0.0f;
        this.h = 0;
    }

    public String toString() {
        return "" + this.j;
    }
}
