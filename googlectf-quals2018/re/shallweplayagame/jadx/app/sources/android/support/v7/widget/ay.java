package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class ay {
    private static final c a;

    private interface c {
        void a(View view, CharSequence charSequence);
    }

    @TargetApi(26)
    private static class a implements c {
        private a() {
        }

        public void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private static class b implements c {
        private b() {
        }

        public void a(View view, CharSequence charSequence) {
            az.a(view, charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static void a(View view, CharSequence charSequence) {
        a.a(view, charSequence);
    }
}
