package android.support.v7.widget;

import android.support.v4.h.p;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class az implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static az i;
    private final View a;
    private final CharSequence b;
    private final Runnable c = new Runnable(this) {
        final /* synthetic */ az a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.a(false);
        }
    };
    private final Runnable d = new Runnable(this) {
        final /* synthetic */ az a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.a();
        }
    };
    private int e;
    private int f;
    private ba g;
    private boolean h;

    private az(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    private void a() {
        if (i == this) {
            i = null;
            if (this.g != null) {
                this.g.a();
                this.g = null;
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        this.a.removeCallbacks(this.c);
        this.a.removeCallbacks(this.d);
    }

    public static void a(View view, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (i != null && i.a == view) {
                i.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        az azVar = new az(view, charSequence);
    }

    private void a(boolean z) {
        if (p.m(this.a)) {
            if (i != null) {
                i.a();
            }
            i = this;
            this.h = z;
            this.g = new ba(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(this);
            long longPressTimeout = this.h ? 2500 : (p.f(this.a) & 1) == 1 ? 3000 - ((long) ViewConfiguration.getLongPressTimeout()) : 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, longPressTimeout);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.g == null || !this.h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
            if (!(accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.a.isEnabled() && this.g == null) {
                            this.e = (int) motionEvent.getX();
                            this.f = (int) motionEvent.getY();
                            this.a.removeCallbacks(this.c);
                            this.a.postDelayed(this.c, (long) ViewConfiguration.getLongPressTimeout());
                            break;
                        }
                    case 10:
                        a();
                        break;
                }
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.e = view.getWidth() / 2;
        this.f = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
