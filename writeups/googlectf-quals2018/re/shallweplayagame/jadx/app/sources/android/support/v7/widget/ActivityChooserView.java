package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.h.c;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    final a a;
    final FrameLayout b;
    final FrameLayout c;
    c d;
    final DataSetObserver e;
    OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final ai j;
    private final ImageView k;
    private final int l;
    private final OnGlobalLayoutListener m;
    private aj n;
    private boolean o;
    private int p;

    public static class InnerLayout extends ai {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            aw a = aw.a(context, attributeSet, a);
            setBackgroundDrawable(a.a(0));
            a.a();
        }
    }

    private class a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView a;
        private e b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public int a() {
            int i = 0;
            int i2 = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.c = i2;
            return i3;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public void a(e eVar) {
            e d = this.a.a.d();
            if (d != null && this.a.isShown()) {
                d.unregisterObserver(this.a.e);
            }
            this.b = eVar;
            if (eVar != null && this.a.isShown()) {
                eVar.registerObserver(this.a.e);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z, boolean z2) {
            if (this.d != z || this.e != z2) {
                this.d = z;
                this.e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public int c() {
            return this.b.a();
        }

        public e d() {
            return this.b;
        }

        public boolean e() {
            return this.d;
        }

        public int getCount() {
            int a = this.b.a();
            if (!(this.d || this.b.b() == null)) {
                a--;
            }
            a = Math.min(a, this.c);
            return this.f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.d || this.b.b() == null)) {
                        i++;
                    }
                    return this.b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.list_item) {
                        view = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        view.setActivated(true);
                        return view;
                    }
                    view.setActivated(false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.a.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(this.a.getContext().getString(h.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView a;

        private void a() {
            if (this.a.f != null) {
                this.a.f.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.a.c) {
                this.a.b();
                Intent b = this.a.a.d().b(this.a.a.d().a(this.a.a.b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.a.getContext().startActivity(b);
                }
            } else if (view == this.a.b) {
                this.a.g = false;
                this.a.a(this.a.h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            if (this.a.d != null) {
                this.a.d.a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.a.b();
                    if (!this.a.g) {
                        if (!this.a.a.e()) {
                            i++;
                        }
                        Intent b = this.a.a.d().b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.a.a.d().c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.a.c) {
                if (this.a.a.getCount() > 0) {
                    this.a.g = true;
                    this.a.a(this.a.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    void a(int i) {
        if (this.a.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        boolean z = this.c.getVisibility() == 0;
        int c = this.a.c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.a.a(false);
            this.a.a(i);
        } else {
            this.a.a(true);
            this.a.a(i - 1);
        }
        aj listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.d()) {
            if (this.g || !z) {
                this.a.a(true, z);
            } else {
                this.a.a(false, false);
            }
            listPopupWindow.g(Math.min(this.a.a(), this.l));
            listPopupWindow.a();
            if (this.d != null) {
                this.d.a(true);
            }
            listPopupWindow.e().setContentDescription(getContext().getString(h.abc_activitychooserview_choose_application));
            listPopupWindow.e().setSelector(new ColorDrawable(0));
        }
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.m);
            }
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().d();
    }

    public e getDataModel() {
        return this.a.d();
    }

    aj getListPopupWindow() {
        if (this.n == null) {
            this.n = new aj(getContext());
            this.n.a(this.a);
            this.n.b((View) this);
            this.n.a(true);
            this.n.a(this.i);
            this.n.a(this.i);
        }
        return this.n;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e d = this.a.d();
        if (d != null) {
            d.registerObserver(this.e);
        }
        this.o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e d = this.a.d();
        if (d != null) {
            d.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(e eVar) {
        this.a.a(eVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.k.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setProvider(c cVar) {
        this.d = cVar;
    }
}
