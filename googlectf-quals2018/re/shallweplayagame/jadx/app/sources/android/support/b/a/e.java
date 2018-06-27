package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.b.a.c;
import android.support.v4.c.b.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class e {

    private static class a implements TypeEvaluator<b[]> {
        private b[] a;

        private a() {
        }

        public b[] a(float f, b[] bVarArr, b[] bVarArr2) {
            if (android.support.v4.c.b.a(bVarArr, bVarArr2)) {
                if (this.a == null || !android.support.v4.c.b.a(this.a, bVarArr)) {
                    this.a = android.support.v4.c.b.a(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.a[i].a(bVarArr[i], bVarArr2[i], f);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return a(f, (b[]) obj, (b[]) obj2);
        }
    }

    private static int a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i = 0;
        TypedArray a = c.a(resources, theme, attributeSet, a.j);
        TypedValue b = c.b(a, xmlPullParser, "value", 0);
        if ((b != null ? 1 : 0) != 0 && a(b.type)) {
            i = 3;
        }
        a.recycle();
        return i;
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        int i3 = peekValue != null ? 1 : 0;
        int i4 = i3 != 0 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        int i5 = peekValue2 != null ? 1 : 0;
        return ((i3 == 0 || !a(i4)) && (i5 == 0 || !a(i5 != 0 ? peekValue2.type : 0))) ? 0 : 3;
    }

    public static Animator a(Context context, int i) {
        return VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator a(Context context, Resources resources, Theme theme, int i) {
        return a(context, resources, theme, i, 1.0f);
    }

    public static Animator a(Context context, Resources resources, Theme theme, int i, float f) {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator a = a(context, resources, theme, (XmlPullParser) xmlResourceParser, f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (Throwable e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static Animator a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static Animator a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    Object obj;
                    if (name.equals("objectAnimator")) {
                        animator = a(context, resources, theme, attributeSet, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("animator")) {
                        animator = a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("set")) {
                        Animator animatorSet2 = new AnimatorSet();
                        TypedArray a = c.a(resources, theme, attributeSet, a.h);
                        a(context, resources, theme, xmlPullParser, attributeSet, (AnimatorSet) animatorSet2, c.a(a, xmlPullParser, "ordering", 0, 0), f);
                        a.recycle();
                        obj = null;
                        animator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(a2);
                        }
                        obj = 1;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && obj == null) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(animator);
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static Keyframe a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray a = c.a(resources, theme, attributeSet, a.j);
        Keyframe keyframe = null;
        float a2 = c.a(a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = c.b(a, xmlPullParser, "value", 0);
        int i2 = b != null ? 1 : 0;
        if (i == 4) {
            i = (i2 == 0 || !a(b.type)) ? 0 : 3;
        }
        if (i2 != 0) {
            switch (i) {
                case 0:
                    keyframe = Keyframe.ofFloat(a2, c.a(a, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                case 3:
                    keyframe = Keyframe.ofInt(a2, c.a(a, xmlPullParser, "value", 0, 0));
                    break;
            }
        }
        keyframe = i == 0 ? Keyframe.ofFloat(a2) : Keyframe.ofInt(a2);
        int c = c.c(a, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            keyframe.setInterpolator(d.a(context, c));
        }
        a.recycle();
        return keyframe;
    }

    private static ObjectAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int next;
        Keyframe a;
        int size;
        Keyframe keyframe;
        float fraction;
        int i2;
        float fraction2;
        Keyframe[] keyframeArr;
        int i3;
        PropertyValuesHolder ofKeyframe;
        ArrayList arrayList = null;
        int i4 = i;
        while (true) {
            next = xmlPullParser.next();
            if (next != 3 && next != 1) {
                ArrayList arrayList2;
                if (xmlPullParser.getName().equals("keyframe")) {
                    if (i4 == 4) {
                        i4 = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                    }
                    a = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i4, xmlPullParser);
                    if (a != null) {
                        arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(a);
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                } else {
                    arrayList2 = arrayList;
                }
                arrayList = arrayList2;
            } else if (arrayList != null) {
                size = arrayList.size();
                if (size > 0) {
                    keyframe = (Keyframe) arrayList.get(0);
                    a = (Keyframe) arrayList.get(size - 1);
                    fraction = a.getFraction();
                    if (fraction < 1.0f) {
                        i2 = size;
                    } else if (fraction >= 0.0f) {
                        a.setFraction(1.0f);
                        i2 = size;
                    } else {
                        arrayList.add(arrayList.size(), a(a, 1.0f));
                        i2 = size + 1;
                    }
                    fraction2 = keyframe.getFraction();
                    if (fraction2 != 0.0f) {
                        if (fraction2 >= 0.0f) {
                            keyframe.setFraction(0.0f);
                        } else {
                            arrayList.add(0, a(keyframe, 0.0f));
                            i2++;
                        }
                    }
                    keyframeArr = new Keyframe[i2];
                    arrayList.toArray(keyframeArr);
                    for (i3 = 0; i3 < i2; i3++) {
                        keyframe = keyframeArr[i3];
                        if (keyframe.getFraction() >= 0.0f) {
                            if (i3 == 0) {
                                keyframe.setFraction(0.0f);
                            } else if (i3 != i2 - 1) {
                                keyframe.setFraction(1.0f);
                            } else {
                                next = i3 + 1;
                                size = i3;
                                while (next < i2 - 1 && keyframeArr[next].getFraction() < 0.0f) {
                                    size = next;
                                    next++;
                                }
                                a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, size);
                            }
                        }
                    }
                    ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                    if (i4 == 3) {
                        return ofKeyframe;
                    }
                    ofKeyframe.setEvaluator(f.a());
                    return ofKeyframe;
                }
            }
        }
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                keyframe = (Keyframe) arrayList.get(0);
                a = (Keyframe) arrayList.get(size - 1);
                fraction = a.getFraction();
                if (fraction < 1.0f) {
                    i2 = size;
                } else if (fraction >= 0.0f) {
                    arrayList.add(arrayList.size(), a(a, 1.0f));
                    i2 = size + 1;
                } else {
                    a.setFraction(1.0f);
                    i2 = size;
                }
                fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 >= 0.0f) {
                        arrayList.add(0, a(keyframe, 0.0f));
                        i2++;
                    } else {
                        keyframe.setFraction(0.0f);
                    }
                }
                keyframeArr = new Keyframe[i2];
                arrayList.toArray(keyframeArr);
                for (i3 = 0; i3 < i2; i3++) {
                    keyframe = keyframeArr[i3];
                    if (keyframe.getFraction() >= 0.0f) {
                        if (i3 == 0) {
                            keyframe.setFraction(0.0f);
                        } else if (i3 != i2 - 1) {
                            next = i3 + 1;
                            size = i3;
                            while (next < i2 - 1) {
                                size = next;
                                next++;
                            }
                            a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, size);
                        } else {
                            keyframe.setFraction(1.0f);
                        }
                    }
                }
                ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i4 == 3) {
                    return ofKeyframe;
                }
                ofKeyframe.setEvaluator(f.a());
                return ofKeyframe;
            }
        }
        return null;
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj = peekValue != null ? 1 : null;
        int i4 = obj != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj2 = peekValue2 != null ? 1 : null;
        int i5 = obj2 != null ? peekValue2.type : 0;
        if (i == 4) {
            i = ((obj == null || !a(i4)) && (obj2 == null || !a(i5))) ? 0 : 3;
        }
        Object obj3 = i == 0 ? 1 : null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            b[] b = android.support.v4.c.b.b(string);
            b[] b2 = android.support.v4.c.b.b(string2);
            if (!(b == null && b2 == null)) {
                if (b != null) {
                    TypeEvaluator aVar = new a();
                    if (b2 == null) {
                        return PropertyValuesHolder.ofObject(str, aVar, new Object[]{b});
                    } else if (android.support.v4.c.b.a(b, b2)) {
                        return PropertyValuesHolder.ofObject(str, aVar, new Object[]{b, b2});
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else if (b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), new Object[]{b2});
                }
            }
            return null;
        }
        PropertyValuesHolder ofFloat;
        TypeEvaluator typeEvaluator = null;
        if (i == 3) {
            typeEvaluator = f.a();
        }
        if (obj3 != null) {
            float dimension;
            if (obj != null) {
                float dimension2 = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (obj2 != null) {
                    dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2, dimension});
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
                }
            } else {
                dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
            }
        } else if (obj != null) {
            int dimension3 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (obj2 != null) {
                i4 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3, i4});
            } else {
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3});
            }
        } else if (obj2 != null) {
            i4 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            ofFloat = PropertyValuesHolder.ofInt(str, new int[]{i4});
        } else {
            ofFloat = null;
        }
        if (ofFloat == null || typeEvaluator == null) {
            return ofFloat;
        }
        ofFloat.setEvaluator(typeEvaluator);
        return ofFloat;
    }

    private static ValueAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a = c.a(resources, theme, attributeSet, a.g);
        TypedArray a2 = c.a(resources, theme, attributeSet, a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a, a2, f, xmlPullParser);
        int c = c.c(a, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(d.a(context, c));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a = c.a(typedArray, xmlPullParser, "pathData", 1);
        if (a != null) {
            String a2 = c.a(typedArray, xmlPullParser, "propertyXName", 2);
            String a3 = c.a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2 && i != 4) {
                if (a2 == null) {
                }
                a(android.support.v4.c.b.a(a), objectAnimator, 0.5f * f, a2, a3);
                return;
            } else if (a2 == null || a3 != null) {
                a(android.support.v4.c.b.a(a), objectAnimator, 0.5f * f, a2, a3);
                return;
            } else {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
        }
        objectAnimator.setPropertyName(c.a(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) c.a(typedArray, xmlPullParser, "duration", 1, 300);
        long a2 = (long) c.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = c.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (c.a(xmlPullParser, "valueFrom") && c.a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                a3 = a(typedArray, 5, 6);
            }
            if (a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{a(typedArray, a3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(a);
        valueAnimator.setStartDelay(a2);
        valueAnimator.setRepeatCount(c.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(c.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, a3, f, xmlPullParser);
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i = 0;
        float f3 = f2 / ((float) (min - 1));
        int i2 = 0;
        f2 = 0.0f;
        while (i2 < min) {
            int i3;
            pathMeasure2.getPosTan(f2, fArr3, null);
            pathMeasure2.getPosTan(f2, fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            float f4 = f2 + f3;
            if (i + 1 >= arrayList.size() || f4 <= ((Float) arrayList.get(i + 1)).floatValue()) {
                f2 = f4;
                i3 = i;
            } else {
                f2 = f4 - ((Float) arrayList.get(i + 1)).floatValue();
                i3 = i + 1;
                pathMeasure2.nextContour();
            }
            i2++;
            i = i3;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder, propertyValuesHolder2});
        }
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static boolean a(int i) {
        return i >= 28 && i <= 31;
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    ArrayList arrayList2;
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        Object a;
                        TypedArray a2 = c.a(resources, theme, attributeSet, a.i);
                        String a3 = c.a(a2, xmlPullParser, "propertyName", 3);
                        int a4 = c.a(a2, xmlPullParser, "valueType", 2, 4);
                        PropertyValuesHolder a5 = a(context, resources, theme, xmlPullParser, a3, a4);
                        if (a5 == null) {
                            a = a(a2, a4, 0, 1, a3);
                        } else {
                            PropertyValuesHolder a6 = a5;
                        }
                        if (a6 != null) {
                            arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList2.add(a6);
                        } else {
                            arrayList2 = arrayList;
                        }
                        a2.recycle();
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                    arrayList = arrayList2;
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
        }
        return propertyValuesHolderArr;
    }
}
