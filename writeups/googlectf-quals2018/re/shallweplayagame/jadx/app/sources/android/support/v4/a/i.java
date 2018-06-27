package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.g.k;
import android.support.v4.g.l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class i extends f {
    final Handler c = new Handler(this) {
        final /* synthetic */ i a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.a.g) {
                        this.a.a(false);
                        return;
                    }
                    return;
                case 2:
                    this.a.b();
                    this.a.d.n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final k d = k.a(new a(this));
    boolean e;
    boolean f;
    boolean g = true;
    boolean h = true;
    boolean i;
    int j;
    l<String> k;

    class a extends l<i> {
        final /* synthetic */ i a;

        public a(i iVar) {
            this.a = iVar;
            super(iVar);
        }

        public View a(int i) {
            return this.a.findViewById(i);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a() {
            Window window = this.a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean a(h hVar) {
            return !this.a.isFinishing();
        }

        public LayoutInflater b() {
            return this.a.getLayoutInflater().cloneInContext(this.a);
        }

        public void b(h hVar) {
            this.a.a(hVar);
        }

        public void c() {
            this.a.d();
        }

        public boolean d() {
            return this.a.getWindow() != null;
        }

        public int e() {
            Window window = this.a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }
    }

    static final class b {
        Object a;
        o b;
        k<String, u> c;

        b() {
        }
    }

    private static void a(m mVar, android.arch.lifecycle.b.b bVar) {
        for (h hVar : mVar.b()) {
            if (hVar != null) {
                hVar.U.a(bVar);
                a(hVar.g(), bVar);
            }
        }
    }

    public android.arch.lifecycle.b a() {
        return super.a();
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    public void a(h hVar) {
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            e();
        } else if (z) {
            this.d.o();
            this.d.c(true);
        }
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void b() {
        this.d.h();
    }

    public Object c() {
        return null;
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.e);
        printWriter.print("mResumed=");
        printWriter.print(this.f);
        printWriter.print(" mStopped=");
        printWriter.print(this.g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.h);
        this.d.a(str2, fileDescriptor, printWriter, strArr);
        this.d.a().a(str, fileDescriptor, printWriter, strArr);
    }

    void e() {
        this.d.c(this.i);
        this.d.k();
    }

    public m f() {
        return this.d.a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.k.a(i4);
            this.k.c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            h a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        m a = this.d.a();
        boolean c = a.c();
        if (c && VERSION.SDK_INT <= 25) {
            return;
        }
        if (c || !a.a()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.d.a(null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.d.a(bVar.c);
        }
        if (bundle != null) {
            this.d.a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.j = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.k = new l(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.k.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.k == null) {
            this.k = new l();
            this.j = 0;
        }
        this.d.e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.d.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.d.l();
        this.d.p();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.d.a(menuItem);
            case 6:
                return this.d.b(menuItem);
            default:
                return false;
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.d.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            b();
        }
        this.d.i();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        b();
        this.d.n();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.d.a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.k.a(i3);
            this.k.c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            h a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.a(i & 65535, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.n();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.g) {
            a(true);
        }
        Object c = c();
        o d = this.d.d();
        k r = this.d.r();
        if (d == null && r == null && c == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = c;
        bVar.b = d;
        bVar.c = r;
        return bVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a(f(), android.arch.lifecycle.b.b.CREATED);
        Parcelable c = this.d.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.k.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.j);
            int[] iArr = new int[this.k.b()];
            String[] strArr = new String[this.k.b()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.b()) {
                    iArr[i2] = this.k.d(i2);
                    strArr[i2] = (String) this.k.e(i2);
                    i = i2 + 1;
                } else {
                    bundle.putIntArray("android:support:request_indicies", iArr);
                    bundle.putStringArray("android:support:request_fragment_who", strArr);
                    return;
                }
            }
        }
    }

    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.o();
        this.d.g();
        this.d.q();
    }

    public void onStateNotSaved() {
        this.d.b();
    }

    protected void onStop() {
        super.onStop();
        this.g = true;
        a(f(), android.arch.lifecycle.b.b.CREATED);
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            e.a(i);
        }
        super.startActivityForResult(intent, i);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
