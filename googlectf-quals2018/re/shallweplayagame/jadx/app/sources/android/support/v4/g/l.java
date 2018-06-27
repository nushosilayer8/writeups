package android.support.v4.g;

public class l<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public l() {
        this(10);
    }

    public l(int i) {
        this.b = false;
        if (i == 0) {
            this.c = c.a;
            this.d = c.c;
        } else {
            int a = c.a(i);
            this.c = new int[a];
            this.d = new Object[a];
        }
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public l<E> a() {
        try {
            l<E> lVar = (l) super.clone();
            try {
                lVar.c = (int[]) this.c.clone();
                lVar.d = (Object[]) this.d.clone();
                return lVar;
            } catch (CloneNotSupportedException e) {
                return lVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e) {
        int a = c.a(this.c, this.e, i);
        return (a < 0 || this.d[a] == a) ? e : this.d[a];
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public void b(int i) {
        int a = c.a(this.c, this.e, i);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }

    public void b(int i, E e) {
        int a = c.a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                a = c.a(this.c, this.e, i) ^ -1;
            }
            if (this.e >= this.c.length) {
                int a2 = c.a(this.e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            if (this.e - a != 0) {
                System.arraycopy(this.c, a, this.c, a + 1, this.e - a);
                System.arraycopy(this.d, a, this.d, a + 1, this.e - a);
            }
            this.c[a] = i;
            this.d[a] = e;
            this.e++;
            return;
        }
        this.c[a] = i;
        this.d[a] = e;
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int i) {
        b(i);
    }

    public void c(int i, E e) {
        if (this.e == 0 || i > this.c[this.e - 1]) {
            if (this.b && this.e >= this.c.length) {
                d();
            }
            int i2 = this.e;
            if (i2 >= this.c.length) {
                int a = c.a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            this.c[i2] = i;
            this.d[i2] = e;
            this.e = i2 + 1;
            return;
        }
        b(i, e);
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public int d(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E e(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(d(i));
            stringBuilder.append('=');
            l e = e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
