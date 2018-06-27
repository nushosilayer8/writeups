package android.support.v7.app;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

class g extends j {

    class a extends a {
        final /* synthetic */ g b;

        a(g gVar, Callback callback) {
            this.b = gVar;
            super(gVar, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            d a = this.b.a(0, true);
            if (a == null || a.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.j, i);
            }
        }
    }

    g(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }
}
