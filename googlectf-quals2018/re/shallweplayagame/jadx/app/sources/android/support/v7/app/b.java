package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class b extends l implements DialogInterface {
    final AlertController a = new AlertController(getContext(), this, getWindow());

    public static class a {
        private final android.support.v7.app.AlertController.a a;
        private final int b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i) {
            this.a = new android.support.v7.app.AlertController.a(new ContextThemeWrapper(context, b.a(context, i)));
            this.b = i;
        }

        public Context a() {
            return this.a.a;
        }

        public a a(OnKeyListener onKeyListener) {
            this.a.r = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a a(View view) {
            this.a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.a.t = listAdapter;
            this.a.u = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public b b() {
            b bVar = new b(this.a.a, this.b);
            this.a.a(bVar.a);
            bVar.setCancelable(this.a.o);
            if (this.a.o) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.a.p);
            bVar.setOnDismissListener(this.a.q);
            if (this.a.r != null) {
                bVar.setOnKeyListener(this.a.r);
            }
            return bVar;
        }
    }

    protected b(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.a.b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}
