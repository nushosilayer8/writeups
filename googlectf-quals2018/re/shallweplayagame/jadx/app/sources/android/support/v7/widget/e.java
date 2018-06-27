package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e extends DataSetObservable {
    static final String a = e.class.getSimpleName();
    private static final Object e = new Object();
    private static final Map<String, e> f = new HashMap();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    public static final class a implements Comparable<a> {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.a = resolveInfo;
        }

        public int a(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return a((a) obj);
        }

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
            return Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    public static final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(ComponentName componentName, long j, float f) {
            this.a = componentName;
            this.b = j;
            this.c = f;
        }

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

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
            c cVar = (c) obj;
            if (this.a == null) {
                if (cVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(cVar.a)) {
                return false;
            }
            return this.b != cVar.b ? false : Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
        }

        public int hashCode() {
            return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.a);
            stringBuilder.append("; time:").append(this.b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean a(e eVar, Intent intent);
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ e a;

        e(e eVar) {
            this.a = eVar;
        }

        public Void a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.a.b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.b));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.a.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(e.a, "Error writing historical record file: " + this.a.c, e2);
                    this.a.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(e.a, "Error writing historical record file: " + this.a.c, e22);
                    this.a.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(e.a, "Error writing historical record file: " + this.a.c, e222);
                    this.a.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.a.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(e.a, "Error writing historical record file: " + str, e2222);
            }
            return null;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return a(objArr);
        }
    }

    private boolean a(c cVar) {
        boolean add = this.i.add(cVar);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.c)) {
                new e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.i), this.c});
            }
        }
    }

    private void d() {
        int f = f() | g();
        h();
        if (f != 0) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean g() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                c cVar = (c) this.i.remove(0);
            }
        }
    }

    private void i() {
        try {
            InputStream openFileInput = this.b.openFileInput(this.c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput != null) {
                                try {
                                    openFileInput.close();
                                    return;
                                } catch (IOException e) {
                                    return;
                                }
                            }
                            return;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(a, "Error reading historical recrod file: " + this.c, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(a, "Error reading historical recrod file: " + this.c, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = ((a) this.h.get(i)).a;
        }
        return resolveInfo;
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = (a) this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.h.get(0)).a;
            return resolveInfo;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = (a) this.h.get(i);
            a aVar2 = (a) this.h.get(0);
            a(new c(new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.b - aVar.b) + 5.0f : 1.0f));
        }
    }
}
