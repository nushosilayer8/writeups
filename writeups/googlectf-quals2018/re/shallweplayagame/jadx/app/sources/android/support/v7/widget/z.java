package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.widget.TextView;

class z extends y {
    private au b;
    private au c;

    z(TextView textView) {
        super(textView);
    }

    void a() {
        super.a();
        if (this.b != null || this.c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.b);
            a(compoundDrawablesRelative[2], this.c);
        }
    }

    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        l a = l.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextHelper_android_drawableStart)) {
            this.b = y.a(context, a, obtainStyledAttributes.getResourceId(j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTextHelper_android_drawableEnd)) {
            this.c = y.a(context, a, obtainStyledAttributes.getResourceId(j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
