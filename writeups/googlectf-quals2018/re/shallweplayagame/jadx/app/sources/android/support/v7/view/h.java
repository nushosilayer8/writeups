package android.support.v7.view;

import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v4.h.t;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<r> a = new ArrayList();
    s b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final t f = new t(this) {
        final /* synthetic */ h a;
        private boolean b = false;
        private int c = 0;

        {
            this.a = r2;
        }

        void a() {
            this.c = 0;
            this.b = false;
            this.a.b();
        }

        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (this.a.b != null) {
                    this.a.b.a(null);
                }
            }
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == this.a.a.size()) {
                if (this.a.b != null) {
                    this.a.b.b(null);
                }
                a();
            }
        }
    };

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(r rVar) {
        if (!this.e) {
            this.a.add(rVar);
        }
        return this;
    }

    public h a(r rVar, r rVar2) {
        this.a.add(rVar);
        rVar2.b(rVar.a());
        this.a.add(rVar2);
        return this;
    }

    public h a(s sVar) {
        if (!this.e) {
            this.b = sVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (this.c >= 0) {
                    rVar.a(this.c);
                }
                if (this.d != null) {
                    rVar.a(this.d);
                }
                if (this.b != null) {
                    rVar.a(this.f);
                }
                rVar.c();
            }
            this.e = true;
        }
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((r) it.next()).b();
            }
            this.e = false;
        }
    }
}
