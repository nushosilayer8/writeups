package android.support.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.b.a.c;
import android.support.v4.c.b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g implements Interpolator {
    private float[] a;
    private float[] b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public g(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = c.a(resources, theme, attributeSet, a.l);
        a(a, xmlPullParser);
        a.recycle();
    }

    private void a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        a(path);
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (c.a(xmlPullParser, "pathData")) {
            String a = c.a(typedArray, xmlPullParser, "pathData", 4);
            Path a2 = b.a(a);
            if (a2 == null) {
                throw new InflateException("The path is null, which is created from " + a);
            }
            a(a2);
        } else if (!c.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (c.a(xmlPullParser, "controlY1")) {
            float a3 = c.a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float a4 = c.a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a5 = c.a(xmlPullParser, "controlX2");
            if (a5 != c.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (a5) {
                a(a3, a4, c.a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), c.a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            } else {
                a(a3, a4);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        int i2;
        this.a = new float[min];
        this.b = new float[min];
        float[] fArr = new float[2];
        for (i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
            this.a[i2] = fArr[0];
            this.b[i2] = fArr[1];
        }
        if (((double) Math.abs(this.a[0])) > 1.0E-5d || ((double) Math.abs(this.b[0])) > 1.0E-5d || ((double) Math.abs(this.a[min - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.b[min - 1] - 1.0f)) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[min - 1] + "," + this.b[min - 1]);
        }
        float f = 0.0f;
        i2 = 0;
        while (i < min) {
            int i3 = i2 + 1;
            float f2 = this.a[i2];
            if (f2 < f) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
            }
            this.a[i] = f2;
            i++;
            f = f2;
            i2 = i3;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.a[i2]) {
                length = i;
            } else {
                int i3 = length;
                length = i2;
                i2 = i3;
            }
            i = length;
            length = i2;
        }
        float f2 = this.a[length] - this.a[i];
        if (f2 == 0.0f) {
            return this.b[i];
        }
        f2 = (f - this.a[i]) / f2;
        float f3 = this.b[i];
        return (f2 * (this.b[length] - f3)) + f3;
    }
}
