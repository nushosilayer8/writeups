package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class a extends Drawable implements Callback {
    private Drawable a;

    public a(Drawable drawable) {
        a(drawable);
    }

    public Drawable a() {
        return this.a;
    }

    public void a(Drawable drawable) {
        if (this.a != null) {
            this.a.setCallback(null);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.a.getPadding(rect);
    }

    public int[] getState() {
        return this.a.getState();
    }

    public Region getTransparentRegion() {
        return this.a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return android.support.v4.c.a.a.b(this.a);
    }

    public boolean isStateful() {
        return this.a.isStateful();
    }

    public void jumpToCurrentState() {
        android.support.v4.c.a.a.a(this.a);
    }

    protected void onBoundsChange(Rect rect) {
        this.a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        android.support.v4.c.a.a.a(this.a, z);
    }

    public void setChangingConfigurations(int i) {
        this.a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        android.support.v4.c.a.a.a(this.a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        android.support.v4.c.a.a.a(this.a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.a.setState(iArr);
    }

    public void setTint(int i) {
        android.support.v4.c.a.a.a(this.a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        android.support.v4.c.a.a.a(this.a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        android.support.v4.c.a.a.a(this.a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
