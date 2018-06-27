package android.support.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {
    static final Mode a = Mode.SRC_IN;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private static class d {
        protected android.support.v4.c.b.b[] m = null;
        String n;
        int o;

        public d(d dVar) {
            this.n = dVar.n;
            this.o = dVar.o;
            this.m = android.support.v4.c.b.a(dVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                android.support.v4.c.b.b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public android.support.v4.c.b.b[] getPathData() {
            return this.m;
        }

        public String getPathName() {
            return this.n;
        }

        public void setPathData(android.support.v4.c.b.b[] bVarArr) {
            if (android.support.v4.c.b.a(this.m, bVarArr)) {
                android.support.v4.c.b.b(this.m, bVarArr);
            } else {
                this.m = android.support.v4.c.b.a(bVarArr);
            }
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = android.support.v4.c.b.b(string);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (android.support.v4.b.a.c.a(xmlPullParser, "pathData")) {
                TypedArray a = android.support.v4.b.a.c.a(resources, theme, attributeSet, a.d);
                a(a);
                a.recycle();
            }
        }

        public boolean a() {
            return true;
        }
    }

    private static class b extends d {
        int a = 0;
        float b = 0.0f;
        int c = 0;
        float d = 1.0f;
        int e = 0;
        float f = 1.0f;
        float g = 0.0f;
        float h = 1.0f;
        float i = 0.0f;
        Cap j = Cap.BUTT;
        Join k = Join.MITER;
        float l = 4.0f;
        private int[] p;

        public b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.a = bVar.a;
            this.b = bVar.b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Cap a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.p = null;
            if (android.support.v4.b.a.c.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = android.support.v4.c.b.b(string);
                }
                this.c = android.support.v4.b.a.c.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
                this.f = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
                this.j = a(android.support.v4.b.a.c.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(android.support.v4.b.a.c.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.a = android.support.v4.b.a.c.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
                this.d = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.h = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
                this.e = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "fillType", 13, this.e);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.b.a.c.a(resources, theme, attributeSet, a.c);
            a(a, xmlPullParser);
            a.recycle();
        }

        float getFillAlpha() {
            return this.f;
        }

        int getFillColor() {
            return this.c;
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.a;
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setFillAlpha(float f) {
            this.f = f;
        }

        void setFillColor(int i) {
            this.c = i;
        }

        void setStrokeAlpha(float f) {
            this.d = f;
        }

        void setStrokeColor(int i) {
            this.a = i;
        }

        void setStrokeWidth(float f) {
            this.b = f;
        }

        void setTrimPathEnd(float f) {
            this.h = f;
        }

        void setTrimPathOffset(float f) {
            this.i = f;
        }

        void setTrimPathStart(float f) {
            this.g = f;
        }
    }

    private static class c {
        final ArrayList<Object> a = new ArrayList();
        float b = 0.0f;
        int c;
        private final Matrix d = new Matrix();
        private float e = 0.0f;
        private float f = 0.0f;
        private float g = 1.0f;
        private float h = 1.0f;
        private float i = 0.0f;
        private float j = 0.0f;
        private final Matrix k = new Matrix();
        private int[] l;
        private String m = null;

        public c(c cVar, android.support.v4.g.a<String, Object> aVar) {
            this.b = cVar.b;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.l = cVar.l;
            this.m = cVar.m;
            this.c = cVar.c;
            if (this.m != null) {
                aVar.put(this.m, this);
            }
            this.k.set(cVar.k);
            ArrayList arrayList = cVar.a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof c) {
                        this.a.add(new c((c) obj, aVar));
                    } else {
                        d bVar;
                        if (obj instanceof b) {
                            bVar = new b((b) obj);
                        } else if (obj instanceof a) {
                            bVar = new a((a) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.a.add(bVar);
                        if (bVar.n != null) {
                            aVar.put(bVar.n, bVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        private void a() {
            this.k.reset();
            this.k.postTranslate(-this.e, -this.f);
            this.k.postScale(this.g, this.h);
            this.k.postRotate(this.b, 0.0f, 0.0f);
            this.k.postTranslate(this.i + this.e, this.j + this.f);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.b = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "rotation", 5, this.b);
            this.e = typedArray.getFloat(1, this.e);
            this.f = typedArray.getFloat(2, this.f);
            this.g = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "scaleX", 3, this.g);
            this.h = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "scaleY", 4, this.h);
            this.i = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "translateX", 6, this.i);
            this.j = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "translateY", 7, this.j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.b.a.c.a(resources, theme, attributeSet, a.b);
            a(a, xmlPullParser);
            a.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.k;
        }

        public float getPivotX() {
            return this.e;
        }

        public float getPivotY() {
            return this.f;
        }

        public float getRotation() {
            return this.b;
        }

        public float getScaleX() {
            return this.g;
        }

        public float getScaleY() {
            return this.h;
        }

        public float getTranslateX() {
            return this.i;
        }

        public float getTranslateY() {
            return this.j;
        }

        public void setPivotX(float f) {
            if (f != this.e) {
                this.e = f;
                a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public void setRotation(float f) {
            if (f != this.b) {
                this.b = f;
                a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }
    }

    private static class e {
        private static final Matrix k = new Matrix();
        final c a;
        float b;
        float c;
        float d;
        float e;
        int f;
        String g;
        final android.support.v4.g.a<String, Object> h;
        private final Path i;
        private final Path j;
        private final Matrix l;
        private Paint m;
        private Paint n;
        private PathMeasure o;
        private int p;

        public e() {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new android.support.v4.g.a();
            this.a = new c();
            this.i = new Path();
            this.j = new Path();
        }

        public e(e eVar) {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new android.support.v4.g.a();
            this.a = new c(eVar.a, this.h);
            this.i = new Path(eVar.i);
            this.j = new Path(eVar.j);
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.p = eVar.p;
            this.f = eVar.f;
            this.g = eVar.g;
            if (eVar.g != null) {
                this.h.put(eVar.g, this);
            }
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.d.set(matrix);
            cVar.d.preConcat(cVar.k);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < cVar.a.size()) {
                    Object obj = cVar.a.get(i4);
                    if (obj instanceof c) {
                        a((c) obj, cVar.d, canvas, i, i2, colorFilter);
                    } else if (obj instanceof d) {
                        a(cVar, (d) obj, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.d;
            float f2 = ((float) i2) / this.e;
            float min = Math.min(f, f2);
            Matrix a = cVar.d;
            this.l.set(a);
            this.l.postScale(f, f2);
            f2 = a(a);
            if (f2 != 0.0f) {
                dVar.a(this.i);
                Path path = this.i;
                this.j.reset();
                if (dVar.a()) {
                    this.j.addPath(path, this.l);
                    canvas.clipPath(this.j);
                    return;
                }
                b bVar = (b) dVar;
                if (!(bVar.g == 0.0f && bVar.h == 1.0f)) {
                    float f3 = (bVar.g + bVar.i) % 1.0f;
                    float f4 = (bVar.h + bVar.i) % 1.0f;
                    if (this.o == null) {
                        this.o = new PathMeasure();
                    }
                    this.o.setPath(this.i, false);
                    float length = this.o.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.o.getSegment(f3, length, path, true);
                        this.o.getSegment(0.0f, f4, path, true);
                    } else {
                        this.o.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.j.addPath(path, this.l);
                if (bVar.c != 0) {
                    if (this.n == null) {
                        this.n = new Paint();
                        this.n.setStyle(Style.FILL);
                        this.n.setAntiAlias(true);
                    }
                    Paint paint = this.n;
                    paint.setColor(i.a(bVar.c, bVar.f));
                    paint.setColorFilter(colorFilter);
                    this.j.setFillType(bVar.e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                    canvas.drawPath(this.j, paint);
                }
                if (bVar.a != 0) {
                    if (this.m == null) {
                        this.m = new Paint();
                        this.m.setStyle(Style.STROKE);
                        this.m.setAntiAlias(true);
                    }
                    Paint paint2 = this.m;
                    if (bVar.k != null) {
                        paint2.setStrokeJoin(bVar.k);
                    }
                    if (bVar.j != null) {
                        paint2.setStrokeCap(bVar.j);
                    }
                    paint2.setStrokeMiter(bVar.l);
                    paint2.setColor(i.a(bVar.a, bVar.d));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth((f2 * min) * bVar.b);
                    canvas.drawPath(this.j, paint2);
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.a, k, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public void setRootAlpha(int i) {
            this.f = i;
        }
    }

    private static class f extends ConstantState {
        int a;
        e b;
        ColorStateList c;
        Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f() {
            this.c = null;
            this.d = i.a;
            this.b = new e();
        }

        public f(f fVar) {
            this.c = null;
            this.d = i.a;
            if (fVar != null) {
                this.a = fVar.a;
                this.b = new e(fVar.b);
                if (fVar.b.n != null) {
                    this.b.n = new Paint(fVar.b.n);
                }
                if (fVar.b.m != null) {
                    this.b.m = new Paint(fVar.b.m);
                }
                this.c = fVar.c;
                this.d = fVar.d;
                this.e = fVar.e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.b.getRootAlpha() < 255;
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    private static class g extends ConstantState {
        private final ConstantState a;

        public g(ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    i() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    i(f fVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = fVar;
        this.d = a(this.d, fVar.c, fVar.d);
    }

    static int a(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    private static Mode a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.ADD : mode;
            default:
                return mode;
        }
    }

    public static i a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.b = android.support.v4.b.a.b.a(resources, i, theme);
            iVar.h = new g(iVar.b.getConstantState());
            return iVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
        }
        return null;
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        f fVar = this.c;
        e eVar = fVar.b;
        fVar.d = a(android.support.v4.b.a.c.a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.c = colorStateList;
        }
        fVar.e = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.e);
        eVar.d = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.d);
        eVar.e = android.support.v4.b.a.c.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.e);
        if (eVar.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.b = typedArray.getDimension(3, eVar.b);
            eVar.c = typedArray.getDimension(2, eVar.c);
            if (eVar.b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.setAlpha(android.support.v4.b.a.c.a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    eVar.g = string;
                    eVar.h.put(string, eVar);
                }
            }
        }
    }

    private boolean a() {
        return VERSION.SDK_INT >= 17 ? isAutoMirrored() && android.support.v4.c.a.a.g(this) == 1 : false;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.c;
        e eVar = fVar.b;
        Stack stack = new Stack();
        stack.push(eVar.a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(bVar);
                    if (bVar.getPathName() != null) {
                        eVar.h.put(bVar.getPathName(), bVar);
                    }
                    obj2 = null;
                    fVar.a = bVar.o | fVar.a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(aVar);
                    if (aVar.getPathName() != null) {
                        eVar.h.put(aVar.getPathName(), aVar);
                    }
                    fVar.a |= aVar.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        cVar2.a(resources, attributeSet, theme, xmlPullParser);
                        cVar.a.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            eVar.h.put(cVar2.getGroupName(), cVar2);
                        }
                        fVar.a |= cVar2.c;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object a(String str) {
        return this.c.b.h.get(str);
    }

    void a(boolean z) {
        this.g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            android.support.v4.c.a.a.d(this.b);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.c.b(min, height);
                if (!this.g) {
                    this.c.a(min, height);
                } else if (!this.c.b()) {
                    this.c.a(min, height);
                    this.c.c();
                }
                this.c.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.b != null ? android.support.v4.c.a.a.c(this.b) : this.c.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.b != null && VERSION.SDK_INT >= 24) {
            return new g(this.b.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : (int) this.c.b.c;
    }

    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : (int) this.c.b.b;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.c;
        fVar.b = new e();
        TypedArray a = android.support.v4.b.a.c.a(resources, theme, attributeSet, a.a);
        a(a, xmlPullParser);
        a.recycle();
        fVar.a = getChangingConfigurations();
        fVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, fVar.c, fVar.d);
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.b != null ? android.support.v4.c.a.a.b(this.b) : this.c.e;
    }

    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        } else if (!this.f && super.mutate() == this) {
            this.c = new f(this.c);
            this.f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        f fVar = this.c;
        if (fVar.c == null || fVar.d == null) {
            return false;
        }
        this.d = a(this.d, fVar.c, fVar.d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.c.b.getRootAlpha() != i) {
            this.c.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, z);
        } else {
            this.c.e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, colorStateList);
            return;
        }
        f fVar = this.c;
        if (fVar.c != colorStateList) {
            fVar.c = colorStateList;
            this.d = a(this.d, colorStateList, fVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, mode);
            return;
        }
        f fVar = this.c;
        if (fVar.d != mode) {
            fVar.d = mode;
            this.d = a(this.d, fVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.b != null ? this.b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
