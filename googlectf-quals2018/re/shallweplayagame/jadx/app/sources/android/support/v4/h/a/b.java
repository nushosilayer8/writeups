package android.support.v4.h.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static final a a;
    private final Object b;

    interface a {
        Object a(b bVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(b bVar) {
            return null;
        }
    }

    private static class b extends d {
        b() {
        }

        public Object a(final b bVar) {
            return c.a(new a(this) {
                final /* synthetic */ b b;

                public Object a(int i) {
                    a a = bVar.a(i);
                    return a == null ? null : a.a();
                }

                public List<Object> a(String str, int i) {
                    List a = bVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((a) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public boolean a(int i, int i2, Bundle bundle) {
                    return bVar.a(i, i2, bundle);
                }
            });
        }
    }

    private static class c extends d {
        c() {
        }

        public Object a(final b bVar) {
            return d.a(new a(this) {
                final /* synthetic */ c b;

                public Object a(int i) {
                    a a = bVar.a(i);
                    return a == null ? null : a.a();
                }

                public List<Object> a(String str, int i) {
                    List a = bVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((a) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public boolean a(int i, int i2, Bundle bundle) {
                    return bVar.a(i, i2, bundle);
                }

                public Object b(int i) {
                    a b = bVar.b(i);
                    return b == null ? null : b.a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new d();
        }
    }

    public b() {
        this.b = a.a(this);
    }

    public b(Object obj) {
        this.b = obj;
    }

    public a a(int i) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    public List<a> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public a b(int i) {
        return null;
    }
}
