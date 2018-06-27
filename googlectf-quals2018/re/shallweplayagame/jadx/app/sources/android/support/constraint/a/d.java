package android.support.constraint.a;

import android.support.constraint.a.g.a;
import java.util.ArrayList;

public class d {
    ArrayList<g> a = new ArrayList();

    private void b(e eVar) {
        this.a.clear();
        for (int i = 1; i < eVar.b; i++) {
            g gVar = eVar.c.c[i];
            for (int i2 = 0; i2 < 6; i2++) {
                gVar.e[i2] = 0.0f;
            }
            gVar.e[gVar.c] = 1.0f;
            if (gVar.f == a.ERROR) {
                this.a.add(gVar);
            }
        }
    }

    g a() {
        int size = this.a.size();
        int i = 0;
        int i2 = 0;
        g gVar = null;
        while (i < size) {
            g gVar2 = (g) this.a.get(i);
            g gVar3 = gVar;
            int i3 = 5;
            while (i3 >= 0) {
                float f = gVar2.e[i3];
                if (gVar3 == null && f < 0.0f && i3 >= r1) {
                    i2 = i3;
                    gVar3 = gVar2;
                }
                if (f > 0.0f && i3 > i2) {
                    i2 = i3;
                    gVar3 = null;
                }
                i3--;
            }
            i++;
            gVar = gVar3;
        }
        return gVar;
    }

    void a(e eVar) {
        b(eVar);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.a.get(i);
            if (gVar.b != -1) {
                a aVar = eVar.a(gVar.b).d;
                int i2 = aVar.a;
                for (int i3 = 0; i3 < i2; i3++) {
                    g a = aVar.a(i3);
                    if (a != null) {
                        float b = aVar.b(i3);
                        for (int i4 = 0; i4 < 6; i4++) {
                            float[] fArr = a.e;
                            fArr[i4] = fArr[i4] + (gVar.e[i4] * b);
                        }
                        if (!this.a.contains(a)) {
                            this.a.add(a);
                        }
                    }
                }
                gVar.a();
            }
        }
    }

    public String toString() {
        int size = this.a.size();
        String str = "Goal: ";
        for (int i = 0; i < size; i++) {
            str = str + ((g) this.a.get(i)).b();
        }
        return str;
    }
}
