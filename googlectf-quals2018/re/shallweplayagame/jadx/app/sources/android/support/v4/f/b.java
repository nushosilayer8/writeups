package android.support.v4.f;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.c.c;
import android.support.v4.c.h;
import android.support.v4.g.g;
import android.support.v4.g.j;
import android.support.v4.g.k;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {
    private static final g<String, Typeface> a = new g(16);
    private static final c b = new c("fonts", 10, 10000);
    private static final Object c = new Object();
    private static final k<String, ArrayList<android.support.v4.f.c.a<Typeface>>> d = new k();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() {
        public int a(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((byte[]) obj, (byte[]) obj2);
        }
    };

    public static class a {
        private final int a;
        private final b[] b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) j.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) {
        int i = 0;
        String a = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            throw new NameNotFoundException("No package found for authority: " + a);
        } else if (resolveContentProvider.packageName.equals(aVar.b())) {
            List a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, e);
            List a3 = a(aVar, resources);
            while (true) {
                int i2 = i;
                if (i2 >= a3.size()) {
                    return null;
                }
                List arrayList = new ArrayList((Collection) a3.get(i2));
                Collections.sort(arrayList, e);
                if (a(a2, arrayList)) {
                    return resolveContentProvider;
                }
                i = i2 + 1;
            }
        } else {
            throw new NameNotFoundException("Found content provider " + a + ", but package was not " + aVar.b());
        }
    }

    public static Typeface a(final Context context, final a aVar, final TextView textView, int i, int i2, final int i3) {
        final Object obj = aVar.f() + "-" + i3;
        Typeface typeface = (Typeface) a.a(obj);
        if (typeface != null) {
            return typeface;
        }
        Object obj2 = i == 0 ? 1 : null;
        if (obj2 != null && i2 == -1) {
            return b(context, aVar, i3);
        }
        Callable anonymousClass1 = new Callable<Typeface>() {
            public Typeface a() {
                Typeface a = b.b(context, aVar, i3);
                if (a != null) {
                    b.a.a(obj, a);
                }
                return a;
            }

            public /* synthetic */ Object call() {
                return a();
            }
        };
        if (obj2 != null) {
            try {
                return (Typeface) b.a(anonymousClass1, i2);
            } catch (InterruptedException e) {
                return null;
            }
        }
        final WeakReference weakReference = new WeakReference(textView);
        AnonymousClass2 anonymousClass2 = new android.support.v4.f.c.a<Typeface>() {
            public void a(Typeface typeface) {
                if (((TextView) weakReference.get()) != null) {
                    textView.setTypeface(typeface, i3);
                }
            }
        };
        synchronized (c) {
            if (d.containsKey(obj)) {
                ((ArrayList) d.get(obj)).add(anonymousClass2);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(anonymousClass2);
            d.put(obj, arrayList);
            b.a(anonymousClass1, new android.support.v4.f.c.a<Typeface>() {
                public void a(Typeface typeface) {
                    ArrayList arrayList;
                    synchronized (b.c) {
                        arrayList = (ArrayList) b.d.get(obj);
                        b.d.remove(obj);
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            ((android.support.v4.f.c.a) arrayList.get(i2)).a(typeface);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            });
            return null;
        }
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) {
        ProviderInfo a = a(context.getPackageManager(), aVar, context.getResources());
        return a == null ? new a(1, null) : new a(0, a(context, aVar, a.authority, cancellationSignal));
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        return aVar.d() != null ? aVar.d() : android.support.v4.b.a.a.a(resources, aVar.e());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        Map hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri a = bVar.a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, h.a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static b[] a(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Uri build = new Builder().scheme("content").authority(str).build();
        Uri build2 = new Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            ArrayList arrayList2;
            Cursor query = VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("result_code");
                        arrayList2 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex("_id");
                        int columnIndex3 = query.getColumnIndex("file_id");
                        int columnIndex4 = query.getColumnIndex("font_ttc_index");
                        int columnIndex5 = query.getColumnIndex("font_weight");
                        int columnIndex6 = query.getColumnIndex("font_italic");
                        while (query.moveToNext()) {
                            int i = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i2 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, query.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            int i3 = columnIndex5 != -1 ? query.getInt(columnIndex5) : 400;
                            boolean z = columnIndex6 != -1 && query.getInt(columnIndex6) == 1;
                            arrayList2.add(new b(withAppendedId, i2, i3, z, i));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (b[]) arrayList2.toArray(new b[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                }
            }
            arrayList2 = arrayList;
            if (query != null) {
                query.close();
            }
            return (b[]) arrayList2.toArray(new b[0]);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    private static Typeface b(Context context, a aVar, int i) {
        try {
            a a = a(context, null, aVar);
            return a.a() == 0 ? c.a(context, null, a.b(), i) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
