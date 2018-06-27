package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class j extends i {
    private final UiModeManager t;

    class a extends a {
        final /* synthetic */ j d;

        a(j jVar, Callback callback) {
            this.d = jVar;
            super(jVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.d.o()) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    j(Context context, Window window, d dVar) {
        super(context, window, dVar);
        this.t = (UiModeManager) context.getSystemService("uimode");
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    int d(int i) {
        return (i == 0 && this.t.getNightMode() == 0) ? -1 : super.d(i);
    }
}
