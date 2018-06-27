package android.support.v4.g;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class k<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public k() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public k(int i) {
        if (i == 0) {
            this.f = c.a;
            this.g = c.c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
        }
    }

    private void e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (d != null) {
                    objArr = d;
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (b != null) {
                    objArr = b;
                    this.g = objArr;
                    b = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[(i << 1)];
    }

    int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a = a(this.f, i, 0);
        if (a < 0 || this.g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f[a] == 0) {
            if (this.g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a = a(this.f, i2, i);
        if (a < 0 || obj.equals(this.g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f[a] == i) {
            if (obj.equals(this.g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.g[i2];
        this.g[i2] = v;
        return v2;
    }

    public void a(int i) {
        int i2 = this.h;
        if (this.f.length < i) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    int b(Object obj) {
        int i = 1;
        int i2 = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K b(int i) {
        return this.g[i << 1];
    }

    public V c(int i) {
        return this.g[(i << 1) + 1];
    }

    public void clear() {
        if (this.h > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            int i = this.h;
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        int i2 = 8;
        V v = this.g[(i << 1) + 1];
        int i3 = this.h;
        if (i3 <= 1) {
            a(this.f, this.g, i3);
            this.f = c.a;
            this.g = c.c;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f.length <= 8 || this.h >= this.f.length / 3) {
                if (i < i4) {
                    System.arraycopy(this.f, i + 1, this.f, i, i4 - i);
                    System.arraycopy(this.g, (i + 1) << 1, this.g, i << 1, (i4 - i) << 1);
                }
                this.g[i4 << 1] = null;
                this.g[(i4 << 1) + 1] = null;
                i2 = i4;
            } else {
                if (i3 > 8) {
                    i2 = (i3 >> 1) + i3;
                }
                Object obj = this.f;
                Object obj2 = this.g;
                e(i2);
                if (i3 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f, 0, i);
                    System.arraycopy(obj2, 0, this.g, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(obj, i + 1, this.f, i, i4 - i);
                    System.arraycopy(obj2, (i + 1) << 1, this.g, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            }
        }
        if (i3 != this.h) {
            throw new ConcurrentModificationException();
        }
        this.h = i2;
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (size() != kVar.size()) {
                return false;
            }
            i = 0;
            while (i < this.h) {
                try {
                    b = b(i);
                    c = c(i);
                    obj2 = kVar.get(b);
                    if (c == null) {
                        if (obj2 != null || !kVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.h) {
                try {
                    b = b(i);
                    c = c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public V get(Object obj) {
        int a = a(obj);
        return a >= 0 ? this.g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        int i3 = this.h;
        if (k == null) {
            a = a();
            i = 0;
        } else {
            i = k.hashCode();
            a = a((Object) k, i);
        }
        if (a >= 0) {
            int i4 = (a << 1) + 1;
            V v2 = this.g[i4];
            this.g[i4] = v;
            return v2;
        }
        a ^= -1;
        if (i3 >= this.f.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            e(i2);
            if (i3 != this.h) {
                throw new ConcurrentModificationException();
            }
            if (this.f.length > 0) {
                System.arraycopy(iArr, 0, this.f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            a(iArr, objArr, i3);
        }
        if (a < i3) {
            System.arraycopy(this.f, a, this.f, a + 1, i3 - a);
            System.arraycopy(this.g, a << 1, this.g, (a + 1) << 1, (this.h - a) << 1);
        }
        if (i3 != this.h || a >= this.f.length) {
            throw new ConcurrentModificationException();
        }
        this.f[a] = i;
        this.g[a << 1] = k;
        this.g[(a << 1) + 1] = v;
        this.h++;
        return null;
    }

    public V remove(Object obj) {
        int a = a(obj);
        return a >= 0 ? d(a) : null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            k b = b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
