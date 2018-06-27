package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class h<K, V> {
    b b;
    c c;
    e d;

    final class a<T> implements Iterator<T> {
        final int a;
        int b;
        int c;
        boolean d = false;
        final /* synthetic */ h e;

        a(h hVar, int i) {
            this.e = hVar;
            this.a = i;
            this.b = hVar.a();
        }

        public boolean hasNext() {
            return this.c < this.b;
        }

        public T next() {
            if (hasNext()) {
                T a = this.e.a(this.c, this.a);
                this.c++;
                this.d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.d) {
                this.c--;
                this.b--;
                this.d = false;
                this.e.a(this.c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ h a;

        b(h hVar) {
            this.a = hVar;
        }

        public boolean a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.a.a();
            for (Entry entry : collection) {
                this.a.a(entry.getKey(), entry.getValue());
            }
            return a != this.a.a();
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.a.a(entry.getKey());
            return a >= 0 ? c.a(this.a.a(a, 1), entry.getValue()) : false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.a.a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.a.a(a, 0);
                Object a3 = this.a.a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.a.a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new d(this.a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ h a;

        c(h hVar) {
            this.a = hVar;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object obj) {
            return this.a.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return h.a(this.a.b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.a.a() - 1; a >= 0; a--) {
                Object a2 = this.a.a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.a.a() == 0;
        }

        public Iterator<K> iterator() {
            return new a(this.a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.a.a(obj);
            if (a < 0) {
                return false;
            }
            this.a.a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return h.b(this.a.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return h.c(this.a.b(), collection);
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            return this.a.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.a.a((Object[]) tArr, 0);
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int a;
        int b;
        boolean c = false;
        final /* synthetic */ h d;

        d(h hVar) {
            this.d = hVar;
            this.a = hVar.a() - 1;
            this.b = -1;
        }

        public Entry<K, V> a() {
            if (hasNext()) {
                this.b++;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(c.a(entry.getKey(), this.d.a(this.b, 0)) && c.a(entry.getValue(), this.d.a(this.b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.c) {
                return this.d.a(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.c) {
                return this.d.a(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.b < this.a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.c) {
                Object a = this.d.a(this.b, 0);
                Object a2 = this.d.a(this.b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return a();
        }

        public void remove() {
            if (this.c) {
                this.d.a(this.b);
                this.b--;
                this.a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.c) {
                return this.d.a(this.b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ h a;

        e(h hVar) {
            this.a = hVar;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.a.c();
        }

        public boolean contains(Object obj) {
            return this.a.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.a.a() == 0;
        }

        public Iterator<V> iterator() {
            return new a(this.a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.a.b(obj);
            if (b < 0) {
                return false;
            }
            this.a.a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.a.a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.a.a(i, 1))) {
                    this.a.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.a.a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.a.a(i, 1))) {
                    this.a.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.a.a();
        }

        public Object[] toArray() {
            return this.a.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.a.a((Object[]) tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    public <T> T[] a(T[] tArr, int i) {
        int a = a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    public Object[] b(int i) {
        int a = a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    protected abstract void c();

    public Set<Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b(this);
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c(this);
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e(this);
        }
        return this.d;
    }
}
