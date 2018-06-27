package android.support.v4.h.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public class e {
    private static final c a;
    private final AccessibilityRecord b;

    static class c {
        c() {
        }

        public void a(AccessibilityRecord accessibilityRecord, int i) {
        }

        public void b(AccessibilityRecord accessibilityRecord, int i) {
        }
    }

    static class a extends c {
        a() {
        }

        public void a(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        public void b(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        a.a(accessibilityRecord, i);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        a.b(accessibilityRecord, i);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == null ? eVar.b == null : this.b.equals(eVar.b);
    }

    @Deprecated
    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }
}
