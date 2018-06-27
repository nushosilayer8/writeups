package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.b.a.i;
import android.support.v4.g.f;
import android.support.v4.g.g;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class l {
    private static final Mode a = Mode.SRC_IN;
    private static l b;
    private static final b c = new b(6);
    private static final int[] d = new int[]{e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = new int[]{e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = new int[]{e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl_dark, e.abc_text_select_handle_middle_mtrl_dark, e.abc_text_select_handle_right_mtrl_dark, e.abc_text_select_handle_left_mtrl_light, e.abc_text_select_handle_middle_mtrl_light, e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = new int[]{e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = new int[]{e.abc_tab_indicator_material, e.abc_textfield_search_material};
    private static final int[] i = new int[]{e.abc_btn_check_material, e.abc_btn_radio_material};
    private WeakHashMap<Context, android.support.v4.g.l<ColorStateList>> j;
    private android.support.v4.g.a<String, c> k;
    private android.support.v4.g.l<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, f<WeakReference<ConstantState>>> n = new WeakHashMap(0);
    private TypedValue o;
    private boolean p;

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class a implements c {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.b.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class b extends g<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        private static int b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, Mode mode) {
            return (PorterDuffColorFilter) a((Object) Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    private static class d implements c {
        d() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    static Mode a(int i) {
        return i == e.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter a = c.a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        c.a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = b(context, i);
        LayerDrawable layerDrawable;
        if (b != null) {
            if (ae.b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.c.a.a.f(drawable);
            android.support.v4.c.a.a.a(drawable, b);
            Mode a = a(i);
            if (a == null) {
                return drawable;
            }
            android.support.v4.c.a.a.a(drawable, a);
            return drawable;
        } else if (i == e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.a(context, android.support.v7.a.a.a.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908303), ar.a(context, android.support.v7.a.a.a.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908301), ar.a(context, android.support.v7.a.a.a.colorControlActivated), a);
            return drawable;
        } else if (i != e.abc_ratingbar_material && i != e.abc_ratingbar_indicator_material && i != e.abc_ratingbar_small_material) {
            return (a(context, i, drawable) || !z) ? drawable : null;
        } else {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.c(context, android.support.v7.a.a.a.colorControlNormal), a);
            a(layerDrawable.findDrawableByLayerId(16908303), ar.a(context, android.support.v7.a.a.a.colorControlActivated), a);
            a(layerDrawable.findDrawableByLayerId(16908301), ar.a(context, android.support.v7.a.a.a.colorControlActivated), a);
            return drawable;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.m;
        monitor-enter(r3);
        r0 = r4.n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.g.f) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static l a() {
        if (b == null) {
            b = new l();
            a(b);
        }
        return b;
    }

    private void a(Context context, int i, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap();
        }
        android.support.v4.g.l lVar = (android.support.v4.g.l) this.j.get(context);
        if (lVar == null) {
            lVar = new android.support.v4.g.l();
            this.j.put(context, lVar);
        }
        lVar.c(i, colorStateList);
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (ae.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i, mode));
    }

    static void a(Drawable drawable, au auVar, int[] iArr) {
        if (!ae.b(drawable) || drawable.mutate() == drawable) {
            if (auVar.d || auVar.c) {
                drawable.setColorFilter(a(auVar.d ? auVar.a : null, auVar.c ? auVar.b : a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void a(l lVar) {
        if (VERSION.SDK_INT < 24) {
            lVar.a("vector", new d());
            if (VERSION.SDK_INT >= 11) {
                lVar.a("animated-vector", new a());
            }
        }
    }

    private void a(String str, c cVar) {
        if (this.k == null) {
            this.k = new android.support.v4.g.a();
        }
        this.k.put(str, cVar);
    }

    static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = a;
        if (a(d, i)) {
            i2 = android.support.v7.a.a.a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(f, i)) {
            i2 = android.support.v7.a.a.a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (ae.b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(ar.a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            f fVar = (f) this.n.get(context);
            if (fVar == null) {
                fVar = new f();
                this.n.put(context, fVar);
            }
            fVar.b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return f(context, ar.a(context, android.support.v7.a.a.a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private Drawable c(Context context, int i) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 == null) {
            if (i == e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{a(context, e.abc_cab_background_internal_bg), a(context, e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, a, a2);
            }
        }
        return a2;
    }

    private ColorStateList d(Context context) {
        return f(context, ar.a(context, android.support.v7.a.a.a.colorAccent));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.l;
        r0 = r0.a(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.support.v4.g.l;
        r0.<init>();
        r9.l = r0;
    L_0x0036:
        r0 = r9.o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.o = r0;
    L_0x0041:
        r2 = r9.o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = a(r2);
        r1 = r9.a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.l;
        r2 = "appcompat_skip_skip";
        r1.c(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.l;	 Catch:{ Exception -> 0x0082 }
        r7.c(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.l.c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = ar.b(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = ar.a;
            iArr2[0] = ar.c(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = ar.a(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
        } else {
            iArr[0] = ar.a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList e(Context context, int i) {
        if (this.j == null) {
            return null;
        }
        android.support.v4.g.l lVar = (android.support.v4.g.l) this.j.get(context);
        return lVar != null ? (ColorStateList) lVar.a(i) : null;
    }

    private ColorStateList f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = ar.a(context, android.support.v7.a.a.a.colorControlHighlight);
        int c = ar.c(context, android.support.v7.a.a.a.colorButtonNormal);
        r0[0] = ar.a;
        r1[0] = c;
        r0[1] = ar.d;
        r1[1] = android.support.v4.c.a.a(a, i);
        r0[2] = ar.b;
        r1[2] = android.support.v4.c.a.a(a, i);
        r0[3] = ar.h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private void f(Context context) {
        if (!this.p) {
            this.p = true;
            Drawable a = a(context, e.abc_vector_test);
            if (a == null || !a(a)) {
                this.p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public Drawable a(Context context, int i) {
        return a(context, i, false);
    }

    Drawable a(Context context, int i, boolean z) {
        f(context);
        Drawable d = d(context, i);
        if (d == null) {
            d = c(context, i);
        }
        if (d == null) {
            d = android.support.v4.b.a.a(context, i);
        }
        if (d != null) {
            d = a(context, i, z, d);
        }
        if (d != null) {
            ae.a(d);
        }
        return d;
    }

    Drawable a(Context context, bb bbVar, int i) {
        Drawable d = d(context, i);
        if (d == null) {
            d = bbVar.a(i);
        }
        return d != null ? a(context, i, false, d) : null;
    }

    public void a(Context context) {
        synchronized (this.m) {
            f fVar = (f) this.n.get(context);
            if (fVar != null) {
                fVar.c();
            }
        }
    }

    ColorStateList b(Context context, int i) {
        ColorStateList e = e(context, i);
        if (e == null) {
            if (i == e.abc_edit_text_material) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_edittext);
            } else if (i == e.abc_switch_track_mtrl_alpha) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_switch_track);
            } else if (i == e.abc_switch_thumb_material) {
                e = e(context);
            } else if (i == e.abc_btn_default_mtrl_shape) {
                e = b(context);
            } else if (i == e.abc_btn_borderless_material) {
                e = c(context);
            } else if (i == e.abc_btn_colored_material) {
                e = d(context);
            } else if (i == e.abc_spinner_mtrl_am_alpha || i == e.abc_spinner_textfield_background_material) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_spinner);
            } else if (a(e, i)) {
                e = ar.b(context, android.support.v7.a.a.a.colorControlNormal);
            } else if (a(h, i)) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_default);
            } else if (a(i, i)) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_btn_checkable);
            } else if (i == e.abc_seekbar_thumb_material) {
                e = android.support.v7.b.a.b.a(context, android.support.v7.a.a.c.abc_tint_seek_thumb);
            }
            if (e != null) {
                a(context, i, e);
            }
        }
        return e;
    }
}
