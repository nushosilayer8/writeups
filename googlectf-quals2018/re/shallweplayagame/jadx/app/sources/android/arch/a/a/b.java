package android.arch.a.a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Entry<K, V>> {
    private c<K, V> a;
    private c<K, V> b;
    private WeakHashMap<Object<K, V>, Boolean> c = new WeakHashMap();
    private int d = 0;

    private static abstract class e<K, V> implements Iterator<Entry<K, V>> {
        c<K, V> a;
        c<K, V> b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        private c<K, V> b() {
            return (this.b == this.a || this.a == null) ? null : a(this.b);
        }

        abstract c<K, V> a(c<K, V> cVar);

        public Entry<K, V> a() {
            Entry entry = this.b;
            this.b = b();
            return entry;
        }

        public boolean hasNext() {
            return this.b != null;
        }

        public /* synthetic */ Object next() {
            return a();
        }
    }

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }
    }

    private static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }
    }

    static class c<K, V> implements Entry<K, V> {
        final K a;
        final V b;
        c<K, V> c;
        c<K, V> d;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    private class d implements Iterator<Entry<K, V>> {
        final /* synthetic */ b a;
        private c<K, V> b;
        private boolean c;

        private d(b bVar) {
            this.a = bVar;
            this.c = true;
        }

        public Entry<K, V> a() {
            if (this.c) {
                this.c = false;
                this.b = this.a.a;
            } else {
                this.b = this.b != null ? this.b.c : null;
            }
            return this.b;
        }

        public boolean hasNext() {
            return this.c ? this.a.a != null : (this.b == null || this.b.c == null) ? false : true;
        }

        public /* synthetic */ Object next() {
            return a();
        }
    }

    public int a() {
        return this.d;
    }

    public Iterator<Entry<K, V>> b() {
        Iterator bVar = new b(this.b, this.a);
        this.c.put(bVar, Boolean.valueOf(false));
        return bVar;
    }

    public d c() {
        d dVar = new d();
        this.c.put(dVar, Boolean.valueOf(false));
        return dVar;
    }

    public Entry<K, V> d() {
        return this.a;
    }

    public Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if (entry == null && next != null) {
                return false;
            }
            if (entry != null && !entry.equals(next)) {
                return false;
            }
        }
        boolean z = (it.hasNext() || it2.hasNext()) ? false : true;
        return z;
    }

    public Iterator<Entry<K, V>> iterator() {
        Iterator aVar = new a(this.a, this.b);
        this.c.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
