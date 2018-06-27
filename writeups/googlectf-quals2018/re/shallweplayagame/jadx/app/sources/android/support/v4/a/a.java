package android.support.v4.a;

import android.app.Activity;
import android.os.Build.VERSION;

public class a extends android.support.v4.b.a {
    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}
