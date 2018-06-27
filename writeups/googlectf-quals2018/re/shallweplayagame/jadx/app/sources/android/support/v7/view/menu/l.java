package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.h.c.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class l extends k {

    class a extends a implements VisibilityListener {
        b c;
        final /* synthetic */ l d;

        public a(l lVar, Context context, ActionProvider actionProvider) {
            this.d = lVar;
            super(lVar, context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public void a(b bVar) {
            VisibilityListener this;
            this.c = bVar;
            ActionProvider actionProvider = this.a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        public boolean b() {
            return this.a.overridesItemVisibility();
        }

        public boolean c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }

    l(Context context, android.support.v4.d.a.b bVar) {
        super(context, bVar);
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.a, actionProvider);
    }
}
