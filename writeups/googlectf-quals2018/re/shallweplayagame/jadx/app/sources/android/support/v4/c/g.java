package android.support.v4.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.b.a.a.b;
import android.support.v4.b.a.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class g implements a {

    private interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    g() {
    }

    private c a(b bVar, int i) {
        return (c) a(bVar.a(), i, new a<c>(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public int a(c cVar) {
                return cVar.b();
            }

            public /* synthetic */ boolean a(Object obj) {
                return b((c) obj);
            }

            public /* synthetic */ int b(Object obj) {
                return a((c) obj);
            }

            public boolean b(c cVar) {
                return cVar.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t2;
            T t3 = tArr[i4];
            int abs = (aVar.a(t3) == z ? 0 : 1) + (Math.abs(aVar.b(t3) - i2) * 2);
            if (t == null || i3 > abs) {
                i3 = abs;
                t2 = t3;
            } else {
                t2 = t;
            }
            i4++;
            t = t2;
        }
        return t;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File a = h.a(context);
        if (a != null) {
            try {
                if (h.a(a, resources, i)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, android.support.v4.f.b.b[] bVarArr, int i) {
        Throwable th;
        Typeface typeface = null;
        if (bVarArr.length >= 1) {
            Closeable openInputStream;
            try {
                openInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).a());
                try {
                    typeface = a(context, (InputStream) openInputStream);
                    h.a(openInputStream);
                } catch (IOException e) {
                    h.a(openInputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    h.a(openInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                openInputStream = typeface;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                openInputStream = typeface;
                th = th4;
                h.a(openInputStream);
                throw th;
            }
        }
        return typeface;
    }

    public Typeface a(Context context, b bVar, Resources resources, int i) {
        c a = a(bVar, i);
        return a == null ? null : c.a(context, resources, a.d(), a.a(), i);
    }

    protected Typeface a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File a = h.a(context);
        if (a != null) {
            try {
                if (h.a(a, inputStream)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }

    protected android.support.v4.f.b.b a(android.support.v4.f.b.b[] bVarArr, int i) {
        return (android.support.v4.f.b.b) a(bVarArr, i, new a<android.support.v4.f.b.b>(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public int a(android.support.v4.f.b.b bVar) {
                return bVar.c();
            }

            public /* synthetic */ boolean a(Object obj) {
                return b((android.support.v4.f.b.b) obj);
            }

            public /* synthetic */ int b(Object obj) {
                return a((android.support.v4.f.b.b) obj);
            }

            public boolean b(android.support.v4.f.b.b bVar) {
                return bVar.d();
            }
        });
    }
}
