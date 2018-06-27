package android.support.constraint.a.a;

import android.support.constraint.a.c;
import java.util.ArrayList;

public class h extends b {
    protected ArrayList<b> aj = new ArrayList();

    public void F() {
        z();
        if (this.aj != null) {
            int size = this.aj.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.aj.get(i);
                if (bVar instanceof h) {
                    ((h) bVar).F();
                }
            }
        }
    }

    public c H() {
        c cVar;
        b bVar;
        b c = c();
        if (this instanceof c) {
            cVar = (c) this;
            bVar = c;
        } else {
            cVar = null;
            bVar = c;
        }
        while (bVar != null) {
            c = bVar.c();
            if (bVar instanceof c) {
                cVar = (c) bVar;
                bVar = c;
            } else {
                bVar = c;
            }
        }
        return cVar;
    }

    public void I() {
        this.aj.clear();
    }

    public void a() {
        this.aj.clear();
        super.a();
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.aj.size();
        for (int i = 0; i < size; i++) {
            ((b) this.aj.get(i)).a(cVar);
        }
    }

    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.aj.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((b) this.aj.get(i3)).b(r(), s());
        }
    }

    public void b(b bVar) {
        this.aj.add(bVar);
        if (bVar.c() != null) {
            ((h) bVar.c()).c(bVar);
        }
        bVar.a((b) this);
    }

    public void c(b bVar) {
        this.aj.remove(bVar);
        bVar.a(null);
    }

    public void z() {
        super.z();
        if (this.aj != null) {
            int size = this.aj.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.aj.get(i);
                bVar.b(n(), o());
                if (!(bVar instanceof c)) {
                    bVar.z();
                }
            }
        }
    }
}
