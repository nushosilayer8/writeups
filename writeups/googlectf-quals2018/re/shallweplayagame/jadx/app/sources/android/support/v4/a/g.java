package android.support.v4.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class g {

    static class a {
        private static Method a;
        private static boolean b;

        public static IBinder a(Bundle bundle, String str) {
            Throwable e;
            if (!b) {
                try {
                    a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    a.setAccessible(true);
                } catch (Throwable e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e2);
                }
                b = true;
            }
            if (a != null) {
                try {
                    return (IBinder) a.invoke(bundle, new Object[]{str});
                } catch (InvocationTargetException e3) {
                    e2 = e3;
                } catch (IllegalAccessException e4) {
                    e2 = e4;
                } catch (IllegalArgumentException e5) {
                    e2 = e5;
                }
            }
            return null;
            Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
            a = null;
            return null;
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        return VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : a.a(bundle, str);
    }
}
