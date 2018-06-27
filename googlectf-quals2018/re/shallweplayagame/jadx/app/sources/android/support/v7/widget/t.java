package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.k;
import android.support.v7.a.a.a;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class t extends RadioButton implements k {
    private final k a;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        this.a = new k(this);
        this.a.a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.a != null ? this.a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(b.b(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}
