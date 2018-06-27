package android.support.v4.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab implements Iterable<Intent> {
    private static final c a;
    private final ArrayList<Intent> b = new ArrayList();
    private final Context c;

    public interface a {
        Intent a_();
    }

    static class c {
        c() {
        }
    }

    static class b extends c {
        b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new c();
        }
    }

    private ab(Context context) {
        this.c = context;
    }

    public static ab a(Context context) {
        return new ab(context);
    }

    public ab a(Activity activity) {
        Intent intent = null;
        if (activity instanceof a) {
            intent = ((a) activity).a_();
        }
        Intent a = intent == null ? w.a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(a);
        }
        return this;
    }

    public ab a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent a = w.a(this.c, componentName);
            while (a != null) {
                this.b.add(size, a);
                a = w.a(this.c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public ab a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    public void a() {
        a(null);
    }

    public void a(Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!android.support.v4.b.a.a(this.c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.c.startActivity(intent);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }
}
