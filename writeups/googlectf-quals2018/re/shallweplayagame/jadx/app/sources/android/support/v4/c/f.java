package android.support.v4.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.b.a.a;
import android.support.v4.b.a.a.c;
import android.support.v4.f.b.b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class f extends d {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;

    static {
        Method method;
        Method method2;
        Method method3;
        Method declaredMethod;
        Constructor constructor;
        Class cls;
        Throwable e;
        Method method4 = null;
        try {
            Class cls2 = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls2.getConstructor(new Class[0]);
            Method method5 = cls2.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method = cls2.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method2 = cls2.getMethod("freeze", new Class[0]);
            method3 = cls2.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls2, 1).getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
            method4 = method3;
            method3 = method2;
            method2 = method;
            method = method5;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            declaredMethod = null;
            method3 = null;
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
            b = constructor;
            a = cls;
            c = method;
            d = method2;
            e = method3;
            f = method4;
            g = declaredMethod;
        } catch (NoSuchMethodException e3) {
            e = e3;
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            declaredMethod = null;
            method3 = null;
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
            b = constructor;
            a = cls;
            c = method;
            d = method2;
            e = method3;
            f = method4;
            g = declaredMethod;
        }
        b = constructor;
        a = cls;
        c = method;
        d = method2;
        e = method3;
        f = method4;
        g = declaredMethod;
    }

    private static Typeface a(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(a, 1), 0, obj);
            return (Typeface) g.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static boolean a(Context context, Object obj, String str, int i, int i2, int i3) {
        Throwable e;
        try {
            return ((Boolean) c.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        throw new RuntimeException(e);
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        Throwable e;
        try {
            return ((Boolean) d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        throw new RuntimeException(e);
    }

    private static Object b() {
        Throwable e;
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InstantiationException e3) {
            e = e3;
        } catch (InvocationTargetException e4) {
            e = e4;
        }
        throw new RuntimeException(e);
    }

    private static boolean b(Object obj) {
        Throwable e;
        try {
            return ((Boolean) e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        throw new RuntimeException(e);
    }

    private static boolean c(Object obj) {
        Throwable e;
        try {
            return ((Boolean) f.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (InvocationTargetException e3) {
            e = e3;
        }
        throw new RuntimeException(e);
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!a()) {
            return super.a(context, resources, i, str, i2);
        }
        Object b = b();
        if (a(context, b, str, 0, -1, -1)) {
            return !b(b) ? null : a(b);
        } else {
            c(b);
            return null;
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (a()) {
            Map a = android.support.v4.f.b.a(context, bVarArr, cancellationSignal);
            Object b = b();
            Object obj = null;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object obj2;
                b bVar = bVarArr[i2];
                ByteBuffer byteBuffer = (ByteBuffer) a.get(bVar.a());
                if (byteBuffer == null) {
                    obj2 = obj;
                } else {
                    if (a(b, byteBuffer, bVar.b(), bVar.c(), bVar.d() ? 1 : 0)) {
                        obj2 = 1;
                    } else {
                        c(b);
                        return null;
                    }
                }
                i2++;
                obj = obj2;
            }
            if (obj != null) {
                return !b(b) ? null : a(b);
            } else {
                c(b);
                return null;
            }
        }
        b a2 = a(bVarArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
            th = null;
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.c()).setItalic(a2.d()).build();
                if (openFileDescriptor == null) {
                    return build;
                }
                if (th != null) {
                    try {
                        openFileDescriptor.close();
                        return build;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        return build;
                    }
                }
                openFileDescriptor.close();
                return build;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                th4 = th2;
                th2 = th5;
            }
        } catch (IOException e) {
            return null;
        }
        if (openFileDescriptor != null) {
            if (th4 != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th32) {
                    th4.addSuppressed(th32);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        throw th2;
    }

    public Typeface a(Context context, a.b bVar, Resources resources, int i) {
        if (!a()) {
            return super.a(context, bVar, resources, i);
        }
        Object b = b();
        c[] a = bVar.a();
        int length = a.length;
        int i2 = 0;
        while (i2 < length) {
            c cVar = a[i2];
            if (a(context, b, cVar.a(), 0, cVar.b(), cVar.c() ? 1 : 0)) {
                i2++;
            } else {
                c(b);
                return null;
            }
        }
        return !b(b) ? null : a(b);
    }
}
