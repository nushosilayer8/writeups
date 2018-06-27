package android.support.v4.a;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

abstract class f extends e {
    boolean b;

    f() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.b || i == -1)) {
            e.a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.a || i == -1)) {
            e.a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
