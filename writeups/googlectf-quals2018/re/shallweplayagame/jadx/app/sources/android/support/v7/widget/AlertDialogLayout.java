package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.h.d;
import android.support.v4.h.p;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.support.v7.widget.ai.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout extends ai {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private static int c(View view) {
        int c = p.c(view);
        if (c > 0) {
            return c;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean c(int i, int i2) {
        int id;
        int measuredHeight;
        int i3;
        int i4;
        int combineMeasuredStates;
        int i5;
        int i6;
        View view = null;
        View view2 = null;
        int childCount = getChildCount();
        int i7 = 0;
        View view3 = null;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                childAt = view2;
                view2 = view;
            } else {
                id = childAt.getId();
                if (id == f.topPanel) {
                    View view4 = view2;
                    view2 = childAt;
                    childAt = view4;
                } else if (id == f.buttonPanel) {
                    view2 = view;
                } else if (id != f.contentPanel && id != f.customPanel) {
                    return false;
                } else {
                    if (view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                    childAt = view2;
                    view2 = view;
                }
            }
            i7++;
            view = view2;
            view2 = childAt;
        }
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i);
        id = 0;
        i7 = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            i7 += view.getMeasuredHeight();
            id = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        int i8 = 0;
        if (view2 != null) {
            view2.measure(i, 0);
            i8 = c(view2);
            measuredHeight = view2.getMeasuredHeight() - i8;
            i7 += i8;
            id = View.combineMeasuredStates(id, view2.getMeasuredState());
            i3 = measuredHeight;
        } else {
            i3 = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : MeasureSpec.makeMeasureSpec(Math.max(0, size - i7), mode));
            measuredHeight = view3.getMeasuredHeight();
            i7 += measuredHeight;
            id = View.combineMeasuredStates(id, view3.getMeasuredState());
            i4 = measuredHeight;
        } else {
            i4 = 0;
        }
        measuredHeight = size - i7;
        if (view2 != null) {
            i7 -= i8;
            i3 = Math.min(measuredHeight, i3);
            if (i3 > 0) {
                measuredHeight -= i3;
                i8 += i3;
            }
            view2.measure(i, MeasureSpec.makeMeasureSpec(i8, 1073741824));
            i8 = view2.getMeasuredHeight() + i7;
            combineMeasuredStates = View.combineMeasuredStates(id, view2.getMeasuredState());
            i5 = measuredHeight;
            measuredHeight = i8;
            i8 = i5;
        } else {
            i8 = measuredHeight;
            combineMeasuredStates = id;
            measuredHeight = i7;
        }
        if (view3 == null || i8 <= 0) {
            i6 = measuredHeight;
            measuredHeight = combineMeasuredStates;
        } else {
            measuredHeight -= i4;
            i7 = i8 - i8;
            view3.measure(i, MeasureSpec.makeMeasureSpec(i8 + i4, mode));
            i5 = measuredHeight + view3.getMeasuredHeight();
            measuredHeight = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
            i6 = i5;
        }
        combineMeasuredStates = 0;
        for (i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            if (childAt2.getVisibility() != 8) {
                combineMeasuredStates = Math.max(combineMeasuredStates, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(combineMeasuredStates + (getPaddingLeft() + getPaddingRight()), i, measuredHeight), View.resolveSizeAndState(i6, i2, 0));
        if (mode2 != 1073741824) {
            d(childCount, i2);
        }
        return true;
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        i5 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i6 = gravity & 8388615;
        switch (gravity & j.AppCompatTheme_windowFixedHeightMajor) {
            case 16:
                i5 = (((i4 - i2) - i5) / 2) + getPaddingTop();
                break;
            case j.AppCompatTheme_panelMenuListTheme /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - i5;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i7 = i5;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int i9;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                a aVar = (a) childAt.getLayoutParams();
                i5 = aVar.h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (d.a(i5, p.b(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + aVar.leftMargin;
                        break;
                }
                i7 = aVar.topMargin + (c(i8) ? i7 + intrinsicHeight : i7);
                a(childAt, i9, i7, measuredWidth, measuredHeight);
                i7 += aVar.bottomMargin + measuredHeight;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (!c(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
