package android.support.constraint.a.a;

import android.support.constraint.a.a.a.b;
import java.util.ArrayList;

public class g {
    private int a;
    private int b;
    private int c;
    private int d;
    private ArrayList<a> e = new ArrayList();

    static class a {
        private a a;
        private a b;
        private int c;
        private b d;
        private int e;

        public a(a aVar) {
            this.a = aVar;
            this.b = aVar.f();
            this.c = aVar.d();
            this.d = aVar.e();
            this.e = aVar.h();
        }

        public void a(b bVar) {
            this.a = bVar.a(this.a.c());
            if (this.a != null) {
                this.b = this.a.f();
                this.c = this.a.d();
                this.d = this.a.e();
                this.e = this.a.h();
                return;
            }
            this.b = null;
            this.c = 0;
            this.d = b.STRONG;
            this.e = 0;
        }

        public void b(b bVar) {
            bVar.a(this.a.c()).a(this.b, this.c, this.d, this.e);
        }
    }

    public g(b bVar) {
        this.a = bVar.f();
        this.b = bVar.g();
        this.c = bVar.h();
        this.d = bVar.l();
        ArrayList y = bVar.y();
        int size = y.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a((a) y.get(i)));
        }
    }

    public void a(b bVar) {
        this.a = bVar.f();
        this.b = bVar.g();
        this.c = bVar.h();
        this.d = bVar.l();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            ((a) this.e.get(i)).a(bVar);
        }
    }

    public void b(b bVar) {
        bVar.b(this.a);
        bVar.c(this.b);
        bVar.d(this.c);
        bVar.e(this.d);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            ((a) this.e.get(i)).b(bVar);
        }
    }
}
