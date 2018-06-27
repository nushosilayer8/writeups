package android.support.v7.b.a;

import java.lang.reflect.Array;

final class c {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());

    private c() {
    }

    public static int a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static int[] a(int[] iArr, int i, int i2) {
        if (a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static <T> T[] a(T[] tArr, int i, T t) {
        if (a || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }
}
