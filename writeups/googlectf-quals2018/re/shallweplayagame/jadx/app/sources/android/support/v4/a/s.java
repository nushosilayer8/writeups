package android.support.v4.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.h.p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class s {
    private static final int[] a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    static class a {
        public h a;
        public boolean b;
        public c c;
        public h d;
        public boolean e;
        public c f;

        a() {
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        sparseArray.put(i, aVar);
        return aVar;
    }

    private static android.support.v4.g.a<String, String> a(int i, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        android.support.v4.g.a<String, String> aVar = new android.support.v4.g.a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            c cVar = (c) arrayList.get(i4);
            if (cVar.b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (cVar.s != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = cVar.s.size();
                    if (booleanValue) {
                        arrayList3 = cVar.s;
                        arrayList4 = cVar.t;
                    } else {
                        ArrayList arrayList5 = cVar.s;
                        arrayList3 = cVar.t;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static Object a(h hVar, h hVar2, boolean z) {
        if (hVar == null || hVar2 == null) {
            return null;
        }
        return t.b(t.a(z ? hVar2.x() : hVar.w()));
    }

    private static Object a(h hVar, boolean z) {
        if (hVar == null) {
            return null;
        }
        return t.a(z ? hVar.v() : hVar.s());
    }

    private static Object a(ViewGroup viewGroup, View view, android.support.v4.g.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        View view2 = null;
        final h hVar = aVar2.a;
        final h hVar2 = aVar2.d;
        if (hVar != null) {
            hVar.i().setVisibility(0);
        }
        if (hVar == null || hVar2 == null) {
            return null;
        }
        Object obj3;
        final boolean z = aVar2.b;
        Object a = aVar.isEmpty() ? null : a(hVar, hVar2, z);
        android.support.v4.g.a b = b((android.support.v4.g.a) aVar, a, aVar2);
        final android.support.v4.g.a c = c(aVar, a, aVar2);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (c != null) {
                c.clear();
                obj3 = null;
            } else {
                obj3 = null;
            }
        } else {
            a((ArrayList) arrayList, b, aVar.keySet());
            a((ArrayList) arrayList2, c, aVar.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        b(hVar, hVar2, z, b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            t.a(obj3, view, (ArrayList) arrayList);
            a(obj3, obj2, b, aVar2.e, aVar2.f);
            rect = new Rect();
            view2 = b(c, aVar2, obj, z);
            if (view2 != null) {
                t.a(obj, rect);
            }
        } else {
            rect = null;
        }
        x.a(viewGroup, new Runnable() {
            public void run() {
                s.b(hVar, hVar2, z, c, false);
                if (view2 != null) {
                    t.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(Object obj, Object obj2, Object obj3, h hVar, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || hVar == null)) {
            z2 = z ? hVar.z() : hVar.y();
        }
        return z2 ? t.a(obj2, obj, obj3) : t.b(obj2, obj, obj3);
    }

    private static String a(android.support.v4.g.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return (String) aVar.b(i);
            }
        }
        return null;
    }

    private static void a(c cVar, a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        h hVar = aVar.b;
        if (hVar != null) {
            int i = hVar.x;
            if (i != 0) {
                int i2;
                int i3;
                a a;
                boolean z3;
                int i4;
                int i5;
                boolean i32;
                int i6;
                switch (z ? a[aVar.a] : aVar.a) {
                    case 1:
                    case 7:
                        z3 = z2 ? hVar.P : (hVar.k || hVar.z) ? false : true;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    case 3:
                    case 6:
                        i6 = z2 ? (hVar.k || hVar.H == null || hVar.H.getVisibility() != 0 || hVar.R < 0.0f) ? 0 : 1 : (!hVar.k || hVar.z) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 4:
                        i6 = z2 ? (hVar.Q && hVar.k && hVar.z) ? 1 : 0 : (!hVar.k || hVar.z) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i32 = 0;
                        break;
                    case 5:
                        z3 = z2 ? hVar.Q && !hVar.z && hVar.k : hVar.z;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        i32 = z3;
                        break;
                    default:
                        i4 = 0;
                        i2 = 0;
                        i5 = 0;
                        i32 = 0;
                        break;
                }
                a aVar2 = (a) sparseArray.get(i);
                if (i32 != 0) {
                    a = a(aVar2, (SparseArray) sparseArray, i);
                    a.a = hVar;
                    a.b = z;
                    a.c = cVar;
                } else {
                    a = aVar2;
                }
                if (!(z2 || i4 == 0)) {
                    if (a != null && a.d == hVar) {
                        a.d = null;
                    }
                    n nVar = cVar.b;
                    if (hVar.b < 1 && nVar.l >= 1 && !cVar.u) {
                        nVar.f(hVar);
                        nVar.a(hVar, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.d == null)) {
                    aVar2 = a;
                } else {
                    aVar2 = a(a, (SparseArray) sparseArray, i);
                    aVar2.d = hVar;
                    aVar2.e = z;
                    aVar2.f = cVar;
                }
                if (!z2 && i5 != 0 && aVar2 != null && aVar2.a == hVar) {
                    aVar2.a = null;
                }
            }
        }
    }

    public static void a(c cVar, SparseArray<a> sparseArray, boolean z) {
        int size = cVar.c.size();
        for (int i = 0; i < size; i++) {
            a(cVar, (a) cVar.c.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    private static void a(n nVar, int i, a aVar, View view, android.support.v4.g.a<String, String> aVar2) {
        ViewGroup viewGroup = null;
        if (nVar.n.a()) {
            viewGroup = (ViewGroup) nVar.n.a(i);
        }
        if (viewGroup != null) {
            h hVar = aVar.a;
            h hVar2 = aVar.d;
            boolean z = aVar.b;
            boolean z2 = aVar.e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a = a(hVar, z);
            Object b = b(hVar2, z2);
            Object a2 = a(viewGroup, view, (android.support.v4.g.a) aVar2, aVar, arrayList2, arrayList, a, b);
            if (a != null || a2 != null || b != null) {
                ArrayList b2 = b(b, hVar2, arrayList2, view);
                ArrayList b3 = b(a, hVar, arrayList, view);
                b(b3, 4);
                Object a3 = a(a, b, a2, hVar, z);
                if (a3 != null) {
                    a(b, hVar2, b2);
                    ArrayList a4 = t.a(arrayList);
                    t.a(a3, a, b3, b, b2, a2, arrayList);
                    t.a(viewGroup, a3);
                    t.a(viewGroup, arrayList2, arrayList, a4, aVar2);
                    b(b3, 0);
                    t.a(a2, arrayList2, arrayList);
                }
            }
        }
    }

    static void a(n nVar, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (nVar.l >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                c cVar = (c) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    b(cVar, sparseArray, z);
                } else {
                    a(cVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(nVar.m.g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    android.support.v4.g.a a = a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    a aVar = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(nVar, keyAt, aVar, view, a);
                    } else {
                        b(nVar, keyAt, aVar, view, a);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.g.a<String, String> aVar, android.support.v4.g.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    private static void a(ViewGroup viewGroup, h hVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final h hVar2 = hVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        x.a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    t.c(obj3, view2);
                    arrayList5.addAll(s.b(obj3, hVar2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        t.b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(Object obj, h hVar, final ArrayList<View> arrayList) {
        if (hVar != null && obj != null && hVar.k && hVar.z && hVar.Q) {
            hVar.f(true);
            t.b(obj, hVar.i(), (ArrayList) arrayList);
            x.a(hVar.G, new Runnable() {
                public void run() {
                    s.b(arrayList, 4);
                }
            });
        }
    }

    private static void a(Object obj, Object obj2, android.support.v4.g.a<String, View> aVar, boolean z, c cVar) {
        if (cVar.s != null && !cVar.s.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) cVar.t.get(0);
            } else {
                String obj32 = (String) cVar.s.get(0);
            }
            View view = (View) aVar.get(obj32);
            t.a(obj, view);
            if (obj2 != null) {
                t.a(obj2, view);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.g.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.c(size);
            if (collection.contains(p.e(view))) {
                arrayList.add(view);
            }
        }
    }

    private static android.support.v4.g.a<String, View> b(android.support.v4.g.a<String, String> aVar, Object obj, a aVar2) {
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        ArrayList arrayList;
        y yVar;
        h hVar = aVar2.d;
        Map aVar3 = new android.support.v4.g.a();
        t.a(aVar3, hVar.i());
        c cVar = aVar2.f;
        y P;
        if (aVar2.e) {
            P = hVar.P();
            arrayList = cVar.t;
            yVar = P;
        } else {
            P = hVar.Q();
            arrayList = cVar.s;
            yVar = P;
        }
        aVar3.a(arrayList);
        if (yVar != null) {
            yVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(p.e(view))) {
                    aVar.put(p.e(view), (String) aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar3.keySet());
        }
        return aVar3;
    }

    private static View b(android.support.v4.g.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        c cVar = aVar2.c;
        if (obj == null || aVar == null || cVar.s == null || cVar.s.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) cVar.s.get(0);
        } else {
            String obj22 = (String) cVar.t.get(0);
        }
        return (View) aVar.get(obj22);
    }

    private static Object b(h hVar, boolean z) {
        if (hVar == null) {
            return null;
        }
        return t.a(z ? hVar.t() : hVar.u());
    }

    private static Object b(ViewGroup viewGroup, View view, android.support.v4.g.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final h hVar = aVar2.a;
        final h hVar2 = aVar2.d;
        if (hVar == null || hVar2 == null) {
            return null;
        }
        Object obj3;
        final boolean z = aVar2.b;
        Object a = aVar.isEmpty() ? null : a(hVar, hVar2, z);
        android.support.v4.g.a b = b((android.support.v4.g.a) aVar, a, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        b(hVar, hVar2, z, b, true);
        if (obj3 != null) {
            rect = new Rect();
            t.a(obj3, view, (ArrayList) arrayList);
            a(obj3, obj2, b, aVar2.e, aVar2.f);
            if (obj != null) {
                t.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final android.support.v4.g.a<String, String> aVar3 = aVar;
        final a aVar4 = aVar2;
        final ArrayList<View> arrayList3 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj4 = obj;
        x.a(viewGroup, new Runnable() {
            public void run() {
                android.support.v4.g.a a = s.c(aVar3, obj3, aVar4);
                if (a != null) {
                    arrayList3.addAll(a.values());
                    arrayList3.add(view2);
                }
                s.b(hVar, hVar2, z, a, false);
                if (obj3 != null) {
                    t.a(obj3, arrayList4, arrayList3);
                    View a2 = s.b(a, aVar4, obj4, z);
                    if (a2 != null) {
                        t.a(a2, rect);
                    }
                }
            }
        });
        return obj3;
    }

    private static ArrayList<View> b(Object obj, h hVar, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View i = hVar.i();
            if (i != null) {
                t.a((ArrayList) arrayList2, i);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                t.a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    public static void b(c cVar, SparseArray<a> sparseArray, boolean z) {
        if (cVar.b.n.a()) {
            for (int size = cVar.c.size() - 1; size >= 0; size--) {
                a(cVar, (a) cVar.c.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void b(h hVar, h hVar2, boolean z, android.support.v4.g.a<String, View> aVar, boolean z2) {
        int i = 0;
        y P = z ? hVar2.P() : hVar.P();
        if (P != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            while (i < size) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
                i++;
            }
            if (z2) {
                P.a(arrayList2, arrayList, null);
            } else {
                P.b(arrayList2, arrayList, null);
            }
        }
    }

    private static void b(n nVar, int i, a aVar, View view, android.support.v4.g.a<String, String> aVar2) {
        ViewGroup viewGroup = null;
        if (nVar.n.a()) {
            viewGroup = (ViewGroup) nVar.n.a(i);
        }
        if (viewGroup != null) {
            h hVar = aVar.a;
            h hVar2 = aVar.d;
            boolean z = aVar.b;
            boolean z2 = aVar.e;
            Object a = a(hVar, z);
            Object b = b(hVar2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object b2 = b(viewGroup, view, aVar2, aVar, arrayList, arrayList2, a, b);
            if (a != null || b2 != null || b != null) {
                ArrayList b3 = b(b, hVar2, arrayList, view);
                Object obj = (b3 == null || b3.isEmpty()) ? null : b;
                t.b(a, view);
                b = a(a, obj, b2, hVar, aVar.b);
                if (b != null) {
                    ArrayList arrayList3 = new ArrayList();
                    t.a(b, a, arrayList3, obj, b3, b2, arrayList2);
                    a(viewGroup, hVar, view, arrayList2, a, arrayList3, obj, b3);
                    t.a((View) viewGroup, arrayList2, (Map) aVar2);
                    t.a(viewGroup, b);
                    t.a(viewGroup, arrayList2, (Map) aVar2);
                }
            }
        }
    }

    private static void b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static android.support.v4.g.a<String, View> c(android.support.v4.g.a<String, String> aVar, Object obj, a aVar2) {
        h hVar = aVar2.a;
        View i = hVar.i();
        if (aVar.isEmpty() || obj == null || i == null) {
            aVar.clear();
            return null;
        }
        ArrayList arrayList;
        y yVar;
        android.support.v4.g.a<String, View> aVar3 = new android.support.v4.g.a();
        t.a((Map) aVar3, i);
        c cVar = aVar2.c;
        y Q;
        if (aVar2.b) {
            Q = hVar.Q();
            arrayList = cVar.s;
            yVar = Q;
        } else {
            Q = hVar.P();
            arrayList = cVar.t;
            yVar = Q;
        }
        if (arrayList != null) {
            aVar3.a(arrayList);
        }
        if (yVar != null) {
            yVar.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                i = (View) aVar3.get(str);
                if (i == null) {
                    str = a((android.support.v4.g.a) aVar, str);
                    if (str != null) {
                        aVar.remove(str);
                    }
                } else if (!str.equals(p.e(i))) {
                    str = a((android.support.v4.g.a) aVar, str);
                    if (str != null) {
                        aVar.put(str, p.e(i));
                    }
                }
            }
        } else {
            a((android.support.v4.g.a) aVar, (android.support.v4.g.a) aVar3);
        }
        return aVar3;
    }
}
