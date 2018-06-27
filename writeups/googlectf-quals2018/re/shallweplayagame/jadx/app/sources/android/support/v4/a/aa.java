package android.support.v4.a;

import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.c;
import android.arch.lifecycle.d;
import android.arch.lifecycle.g;
import android.os.Bundle;
import android.support.v4.g.k;

public class aa extends Activity implements c {
    private k<Class<? extends Object>, Object> a = new k();
    private d b = new d(this);

    public b a() {
        return this.b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(b.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
