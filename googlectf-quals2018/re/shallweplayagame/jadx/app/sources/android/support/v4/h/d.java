package android.support.v4.h;

import android.os.Build.VERSION;
import android.view.Gravity;

public final class d {
    public static int a(int i, int i2) {
        return VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : -8388609 & i;
    }
}
