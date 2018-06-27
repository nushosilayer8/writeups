package android.support.v4.g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends k<K, V> implements Map<K, V> {
    h<K, V> a;

    public a(int i) {
        super(i);
    }

    private h<K, V> b() {
        if (this.a == null) {
            this.a = new h<K, V>(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                protected int a() {
                    return this.a.h;
                }

                protected int a(Object obj) {
                    return this.a.a(obj);
                }

                protected Object a(int i, int i2) {
                    return this.a.g[(i << 1) + i2];
                }

                protected V a(int i, V v) {
                    return this.a.a(i, (Object) v);
                }

                protected void a(int i) {
                    this.a.d(i);
                }

                protected void a(K k, V v) {
                    this.a.put(k, v);
                }

                protected int b(Object obj) {
                    return this.a.b(obj);
                }

                protected Map<K, V> b() {
                    return this.a;
                }

                protected void c() {
                    this.a.clear();
                }
            };
        }
        return this.a;
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }
}
