package android.arch.lifecycle;

import android.arch.lifecycle.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class d extends b {
    private android.arch.a.a.a<Object, a> a = new android.arch.a.a.a();
    private b b;
    private final c c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<b> g = new ArrayList();

    static class a {
        b a;
        a b;

        void a(c cVar, android.arch.lifecycle.b.a aVar) {
            b b = d.b(aVar);
            this.a = d.a(this.a, b);
            this.b.a(cVar, aVar);
            this.a = b;
        }
    }

    public d(c cVar) {
        this.c = cVar;
        this.b = b.INITIALIZED;
    }

    static b a(b bVar, b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private boolean a() {
        if (this.a.a() == 0) {
            return true;
        }
        b bVar = ((a) this.a.d().getValue()).a;
        b bVar2 = ((a) this.a.e().getValue()).a;
        boolean z = bVar == bVar2 && this.b == bVar2;
        return z;
    }

    static b b(android.arch.lifecycle.b.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return b.STARTED;
            case ON_RESUME:
                return b.RESUMED;
            case ON_DESTROY:
                return b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b() {
        this.g.remove(this.g.size() - 1);
    }

    private void b(b bVar) {
        this.g.add(bVar);
    }

    private static android.arch.lifecycle.b.a c(b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return android.arch.lifecycle.b.a.ON_DESTROY;
            case STARTED:
                return android.arch.lifecycle.b.a.ON_STOP;
            case RESUMED:
                return android.arch.lifecycle.b.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void c() {
        Iterator c = this.a.c();
        while (c.hasNext() && !this.f) {
            Entry entry = (Entry) c.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.a(entry.getKey())) {
                b(aVar.a);
                aVar.a(this.c, d(aVar.a));
                b();
            }
        }
    }

    private static android.arch.lifecycle.b.a d(b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return android.arch.lifecycle.b.a.ON_CREATE;
            case CREATED:
                return android.arch.lifecycle.b.a.ON_START;
            case STARTED:
                return android.arch.lifecycle.b.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void d() {
        Iterator b = this.a.b();
        while (b.hasNext() && !this.f) {
            Entry entry = (Entry) b.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.b) > 0 && !this.f && this.a.a(entry.getKey())) {
                android.arch.lifecycle.b.a c = c(aVar.a);
                b(b(c));
                aVar.a(this.c, c);
                b();
            }
        }
    }

    private void e() {
        while (!a()) {
            this.f = false;
            if (this.b.compareTo(((a) this.a.d().getValue()).a) < 0) {
                d();
            }
            Entry e = this.a.e();
            if (!(this.f || e == null || this.b.compareTo(((a) e.getValue()).a) <= 0)) {
                c();
            }
        }
        this.f = false;
    }

    public void a(android.arch.lifecycle.b.a aVar) {
        this.b = b(aVar);
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        e();
        this.e = false;
    }

    public void a(b bVar) {
        this.b = bVar;
    }
}
