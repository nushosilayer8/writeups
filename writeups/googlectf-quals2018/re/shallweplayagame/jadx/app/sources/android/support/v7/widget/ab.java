package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.a.a.j;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class ab {
    private static final RectF a = new RectF();
    private static Hashtable<String, Method> b = new Hashtable();
    private int c = 0;
    private boolean d = false;
    private float e = -1.0f;
    private float f = -1.0f;
    private float g = -1.0f;
    private int[] h = new int[0];
    private boolean i = false;
    private TextPaint j;
    private final TextView k;
    private final Context l;

    ab(TextView textView) {
        this.k = textView;
        this.l = this.k.getContext();
    }

    private int a(RectF rectF) {
        int length = this.h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = 1;
        length--;
        while (i2 <= length) {
            i = (i2 + length) / 2;
            if (a(this.h[i], rectF)) {
                int i3 = i + 1;
                i = i2;
                i2 = i3;
            } else {
                length = i - 1;
                i = length;
            }
        }
        return this.h[i];
    }

    @TargetApi(14)
    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.k.getLineSpacingMultiplier();
            lineSpacingExtra = this.k.getLineSpacingExtra();
            includeFontPadding = this.k.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) a(this.k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) a(this.k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) a(this.k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
        }
        return new StaticLayout(charSequence, this.j, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    @TargetApi(23)
    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.j, i).setAlignment(alignment).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private <T> T a(java.lang.Object r7, java.lang.String r8, T r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.utils.BlockUtils.getNextBlock(BlockUtils.java:289)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:131)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:642)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r6 = this;
        r2 = 0;
        r0 = 0;
        r1 = r6.a(r8);	 Catch:{ Exception -> 0x0010 }
        r3 = 0;	 Catch:{ Exception -> 0x0010 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0010 }
        r9 = r1.invoke(r7, r3);	 Catch:{ Exception -> 0x0010 }
        if (r9 != 0) goto L_0x000f;
    L_0x000f:
        return r9;
    L_0x0010:
        r1 = move-exception;
        r2 = 1;
        r3 = "ACTVAutoSizeHelper";	 Catch:{ all -> 0x0034 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r4.<init>();	 Catch:{ all -> 0x0034 }
        r5 = "Failed to invoke TextView#";	 Catch:{ all -> 0x0034 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0034 }
        r4 = r4.append(r8);	 Catch:{ all -> 0x0034 }
        r5 = "() method";	 Catch:{ all -> 0x0034 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0034 }
        r4 = r4.toString();	 Catch:{ all -> 0x0034 }
        android.util.Log.w(r3, r4, r1);	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x000f;
    L_0x0032:
        r9 = r0;
        goto L_0x000f;
    L_0x0034:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0039;
    L_0x0037:
        if (r2 == 0) goto L_0x0039;
    L_0x0039:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ab.a(java.lang.Object, java.lang.String, java.lang.Object):T");
    }

    private Method a(String str) {
        try {
            Method method = (Method) b.get(str);
            if (method != null) {
                return method;
            }
            method = TextView.class.getDeclaredMethod(str, new Class[0]);
            if (method == null) {
                return method;
            }
            method.setAccessible(true);
            b.put(str, method);
            return method;
        } catch (Throwable e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    private void a(float f) {
        if (f != this.k.getPaint().getTextSize()) {
            this.k.getPaint().setTextSize(f);
            boolean isInLayout = VERSION.SDK_INT >= 18 ? this.k.isInLayout() : false;
            if (this.k.getLayout() != null) {
                this.d = false;
                String str = "nullLayouts";
                try {
                    Method a = a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.k, new Object[0]);
                    }
                } catch (Throwable e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (isInLayout) {
                    this.k.forceLayout();
                } else {
                    this.k.requestLayout();
                }
                this.k.invalidate();
            }
        }
    }

    private void a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size " + "text size (" + f + "px)");
        } else if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        } else {
            this.c = 1;
            this.f = f;
            this.g = f2;
            this.e = f3;
            this.i = false;
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.h = a(iArr);
            h();
        }
    }

    private boolean a(int i, RectF rectF) {
        CharSequence text = this.k.getText();
        int maxLines = VERSION.SDK_INT >= 16 ? this.k.getMaxLines() : -1;
        if (this.j == null) {
            this.j = new TextPaint();
        } else {
            this.j.reset();
        }
        this.j.set(this.k.getPaint());
        this.j.setTextSize((float) i);
        Alignment alignment = (Alignment) a(this.k, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
        StaticLayout a = VERSION.SDK_INT >= 23 ? a(text, alignment, Math.round(rectF.right), maxLines) : a(text, alignment, Math.round(rectF.right));
        return (maxLines == -1 || (a.getLineCount() <= maxLines && a.getLineEnd(a.getLineCount() - 1) == text.length())) ? ((float) a.getHeight()) <= rectF.bottom : false;
    }

    private int[] a(int[] iArr) {
        int size;
        if (size != 0) {
            int i;
            Arrays.sort(iArr);
            List arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (size != arrayList.size()) {
                size = arrayList.size();
                iArr = new int[size];
                for (i = 0; i < size; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        }
        return iArr;
    }

    private boolean h() {
        int length = this.h.length;
        this.i = length > 0;
        if (this.i) {
            this.c = 1;
            this.f = (float) this.h[0];
            this.g = (float) this.h[length - 1];
            this.e = -1.0f;
        }
        return this.i;
    }

    private boolean i() {
        if (k() && this.c == 1) {
            if (!this.i || this.h.length == 0) {
                float round = (float) Math.round(this.f);
                int i = 1;
                while (Math.round(this.e + round) <= Math.round(this.g)) {
                    i++;
                    round += this.e;
                }
                int[] iArr = new int[i];
                float f = this.f;
                for (int i2 = false; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.e;
                }
                this.h = a(iArr);
            }
            this.d = true;
        } else {
            this.d = false;
        }
        return this.d;
    }

    private void j() {
        this.c = 0;
        this.f = -1.0f;
        this.g = -1.0f;
        this.e = -1.0f;
        this.h = new int[0];
        this.d = false;
    }

    private boolean k() {
        return !(this.k instanceof m);
    }

    int a() {
        return this.c;
    }

    void a(int i) {
        if (k()) {
            switch (i) {
                case 0:
                    j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (i()) {
                        f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    void a(int i, float f) {
        a(TypedValue.applyDimension(i, f, (this.l == null ? Resources.getSystem() : this.l.getResources()).getDisplayMetrics()));
    }

    void a(int i, int i2, int i3, int i4) {
        if (k()) {
            DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (i()) {
                f();
            }
        }
    }

    void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(attributeSet, j.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            this.c = obtainStyledAttributes.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!k()) {
            this.c = 0;
        } else if (this.c == 1) {
            if (!this.i) {
                DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    void a(int[] iArr, int i) {
        int i2 = 0;
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.h = a(iArr2);
                if (!h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            }
            this.i = false;
            if (i()) {
                f();
            }
        }
    }

    int b() {
        return Math.round(this.e);
    }

    int c() {
        return Math.round(this.f);
    }

    int d() {
        return Math.round(this.g);
    }

    int[] e() {
        return this.h;
    }

    void f() {
        if (g()) {
            if (this.d) {
                if (this.k.getMeasuredHeight() > 0 && this.k.getMeasuredWidth() > 0) {
                    int measuredWidth = ((Boolean) a(this.k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue() ? 1048576 : (this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft()) - this.k.getTotalPaddingRight();
                    int height = (this.k.getHeight() - this.k.getCompoundPaddingBottom()) - this.k.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (a) {
                            a.setEmpty();
                            a.right = (float) measuredWidth;
                            a.bottom = (float) height;
                            float a = (float) a(a);
                            if (a != this.k.getTextSize()) {
                                a(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            this.d = true;
        }
    }

    boolean g() {
        return k() && this.c != 0;
    }
}
