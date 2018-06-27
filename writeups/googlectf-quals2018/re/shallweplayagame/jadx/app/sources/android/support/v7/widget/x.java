package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.o;
import android.support.v4.h.p;
import android.support.v7.a.a.g;
import android.support.v7.a.a.j;
import android.support.v7.view.d;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class x extends Spinner implements o {
    private static final int[] a = new int[]{16843505};
    private final g b;
    private final Context c;
    private ah d;
    private SpinnerAdapter e;
    private final boolean f;
    private b g;
    private int h;
    private final Rect i;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof as) {
                as asVar = (as) spinnerAdapter;
                if (asVar.a() == null) {
                    asVar.a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.a == null ? 0 : this.a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.a == null ? null : this.a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.a == null ? null : this.a.getItem(i);
        }

        public long getItemId(int i) {
            return this.a == null ? -1 : this.a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends aj {
        ListAdapter a;
        final /* synthetic */ x b;
        private CharSequence h;
        private final Rect i = new Rect();

        public b(final x xVar, Context context, AttributeSet attributeSet, int i) {
            this.b = xVar;
            super(context, attributeSet, i);
            b((View) xVar);
            a(true);
            a(0);
            a(new OnItemClickListener(this) {
                final /* synthetic */ b b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.b.b.setSelection(i);
                    if (this.b.b.getOnItemClickListener() != null) {
                        this.b.b.performItemClick(view, i, this.b.a.getItemId(i));
                    }
                    this.b.c();
                }
            });
        }

        public void a() {
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(this.b.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b a;

                        {
                            this.a = r1;
                        }

                        public void onGlobalLayout() {
                            if (this.a.a(this.a.b)) {
                                this.a.f();
                                super.a();
                                return;
                            }
                            this.a.c();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    a(new OnDismissListener(this) {
                        final /* synthetic */ b b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        boolean a(View view) {
            return p.m(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        void f() {
            int i;
            Drawable h = h();
            if (h != null) {
                h.getPadding(this.b.i);
                i = bc.a(this.b) ? this.b.i.right : -this.b.i.left;
            } else {
                Rect b = this.b.i;
                this.b.i.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.b.getPaddingLeft();
            int paddingRight = this.b.getPaddingRight();
            int width = this.b.getWidth();
            if (this.b.h == -2) {
                int a = this.b.a((SpinnerAdapter) this.a, h());
                int i2 = (this.b.getContext().getResources().getDisplayMetrics().widthPixels - this.b.i.left) - this.b.i.right;
                if (a <= i2) {
                    i2 = a;
                }
                g(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.b.h == -1) {
                g((width - paddingLeft) - paddingRight);
            } else {
                g(this.b.h);
            }
            c(bc.a(this.b) ? ((width - paddingRight) - l()) + i : i + paddingLeft);
        }
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public x(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        final b bVar;
        aw a;
        CharSequence[] f;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.i = new Rect();
        aw a2 = aw.a(context, attributeSet, j.Spinner, i, 0);
        this.b = new g(this);
        if (theme != null) {
            this.c = new d(context, theme);
        } else {
            int g = a2.g(j.Spinner_popupTheme, 0);
            if (g != 0) {
                this.c = new d(context, g);
            } else {
                this.c = VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.c != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    bVar = new b(this, this.c, attributeSet, i);
                                    a = aw.a(this.c, attributeSet, j.Spinner, i, 0);
                                    this.h = a.f(j.Spinner_android_dropDownWidth, -2);
                                    bVar.a(a.a(j.Spinner_android_popupBackground));
                                    bVar.a(a2.d(j.Spinner_android_prompt));
                                    a.a();
                                    this.g = bVar;
                                    this.d = new ah(this, this) {
                                        final /* synthetic */ x b;

                                        public s a() {
                                            return bVar;
                                        }

                                        public boolean b() {
                                            if (!this.b.g.d()) {
                                                this.b.g.a();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                f = a2.f(j.Spinner_android_entries);
                                if (f != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, f);
                                    arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.a();
                                this.f = true;
                                if (this.e != null) {
                                    setAdapter(this.e);
                                    this.e = null;
                                }
                                this.b.a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.c, attributeSet, i);
                            a = aw.a(this.c, attributeSet, j.Spinner, i, 0);
                            this.h = a.f(j.Spinner_android_dropDownWidth, -2);
                            bVar.a(a.a(j.Spinner_android_popupBackground));
                            bVar.a(a2.d(j.Spinner_android_prompt));
                            a.a();
                            this.g = bVar;
                            this.d = /* anonymous class already generated */;
                        }
                        f = a2.f(j.Spinner_android_entries);
                        if (f != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, f);
                            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.a();
                        this.f = true;
                        if (this.e != null) {
                            setAdapter(this.e);
                            this.e = null;
                        }
                        this.b.a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                bVar = new b(this, this.c, attributeSet, i);
                a = aw.a(this.c, attributeSet, j.Spinner, i, 0);
                this.h = a.f(j.Spinner_android_dropDownWidth, -2);
                bVar.a(a.a(j.Spinner_android_popupBackground));
                bVar.a(a2.d(j.Spinner_android_prompt));
                a.a();
                this.g = bVar;
                this.d = /* anonymous class already generated */;
            }
        }
        f = a2.f(j.Spinner_android_entries);
        if (f != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, f);
            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.a();
        this.f = true;
        if (this.e != null) {
            setAdapter(this.e);
            this.e = null;
        }
        this.b.a(attributeSet, i);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.i);
        return (this.i.left + this.i.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.g != null ? this.g.j() : VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.g != null ? this.g.k() : VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.g != null ? this.h : VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.g != null ? this.g.h() : VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.g != null ? this.c : VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.g != null ? this.g.b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null && this.g.d()) {
            this.g.c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.d == null || !this.d.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.g == null) {
            return super.performClick();
        }
        if (!this.g.d()) {
            this.g.a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f) {
            super.setAdapter(spinnerAdapter);
            if (this.g != null) {
                this.g.a(new a(spinnerAdapter, (this.c == null ? getContext() : this.c).getTheme()));
                return;
            }
            return;
        }
        this.e = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.g != null) {
            this.g.c(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.g != null) {
            this.g.d(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.g != null) {
            this.g.a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v7.b.a.b.b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.g != null) {
            this.g.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }
}
