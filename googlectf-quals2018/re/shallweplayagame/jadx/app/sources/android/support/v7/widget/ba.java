package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.i;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class ba {
    private final Context a;
    private final View b;
    private final TextView c;
    private final LayoutParams d = new LayoutParams();
    private final Rect e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    ba(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(this.a).inflate(g.tooltip, null);
        this.c = (TextView) this.b.findViewById(f.message);
        this.d.setTitle(getClass().getSimpleName());
        this.d.packageName = this.a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    private static View a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return view.getRootView();
    }

    private void a(View view, int i, int i2, boolean z, LayoutParams layoutParams) {
        int i3;
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            i3 = i2 + dimensionPixelOffset;
            dimensionPixelOffset = i2 - dimensionPixelOffset;
        } else {
            i3 = view.getHeight();
            dimensionPixelOffset = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset2 = this.a.getResources().getDimensionPixelOffset(z ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
        View a = a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.e);
        if (this.e.left < 0 && this.e.top < 0) {
            Resources resources = this.a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            identifier = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.e.set(0, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.g);
        view.getLocationOnScreen(this.f);
        int[] iArr = this.f;
        iArr[0] = iArr[0] - this.g[0];
        iArr = this.f;
        iArr[1] = iArr[1] - this.g[1];
        layoutParams.x = (this.f[0] + i) - (this.e.width() / 2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.b.measure(makeMeasureSpec, makeMeasureSpec);
        makeMeasureSpec = this.b.getMeasuredHeight();
        dimensionPixelOffset = ((dimensionPixelOffset + this.f[1]) - dimensionPixelOffset2) - makeMeasureSpec;
        i3 = (i3 + this.f[1]) + dimensionPixelOffset2;
        if (z) {
            if (dimensionPixelOffset >= 0) {
                layoutParams.y = dimensionPixelOffset;
            } else {
                layoutParams.y = i3;
            }
        } else if (makeMeasureSpec + i3 <= this.e.height()) {
            layoutParams.y = i3;
        } else {
            layoutParams.y = dimensionPixelOffset;
        }
    }

    void a() {
        if (b()) {
            ((WindowManager) this.a.getSystemService("window")).removeView(this.b);
        }
    }

    void a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.c.setText(charSequence);
        a(view, i, i2, z, this.d);
        ((WindowManager) this.a.getSystemService("window")).addView(this.b, this.d);
    }

    boolean b() {
        return this.b.getParent() != null;
    }
}
