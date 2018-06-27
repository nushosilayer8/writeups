package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {
    private static final int[] a = new int[]{0, 4, 8};
    private static SparseIntArray c = new SparseIntArray();
    private HashMap<Integer, a> b = new HashMap();

    private static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public float N;
        public float O;
        public int P;
        public int Q;
        public float R;
        public boolean S;
        public float T;
        public float U;
        public float V;
        public float W;
        public float X;
        public float Y;
        public float Z;
        boolean a;
        public float aa;
        public float ab;
        public float ac;
        public int ad;
        public int ae;
        public int af;
        public int ag;
        public int ah;
        public int ai;
        public int b;
        public int c;
        int d;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public float u;
        public float v;
        public String w;
        public int x;
        public int y;
        public int z;

        private a() {
            this.a = false;
            this.e = -1;
            this.f = -1;
            this.g = -1.0f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = 0;
            this.H = -1;
            this.I = -1;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = 0.0f;
            this.O = 0.0f;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = false;
            this.T = 0.0f;
            this.U = 0.0f;
            this.V = 0.0f;
            this.W = 1.0f;
            this.X = 1.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.aa = 0.0f;
            this.ab = 0.0f;
            this.ac = 0.0f;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = -1;
            this.ai = -1;
        }

        public a a() {
            a aVar = new a();
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = this.h;
            aVar.i = this.i;
            aVar.j = this.j;
            aVar.k = this.k;
            aVar.l = this.l;
            aVar.m = this.m;
            aVar.n = this.n;
            aVar.o = this.o;
            aVar.p = this.p;
            aVar.q = this.q;
            aVar.r = this.r;
            aVar.s = this.s;
            aVar.t = this.t;
            aVar.u = this.u;
            aVar.v = this.v;
            aVar.w = this.w;
            aVar.x = this.x;
            aVar.y = this.y;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.z = this.z;
            aVar.A = this.A;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            aVar.K = this.K;
            aVar.L = this.L;
            aVar.M = this.M;
            aVar.N = this.N;
            aVar.O = this.O;
            aVar.P = this.P;
            aVar.Q = this.Q;
            aVar.R = this.R;
            aVar.S = this.S;
            aVar.T = this.T;
            aVar.U = this.U;
            aVar.V = this.V;
            aVar.W = this.W;
            aVar.X = this.X;
            aVar.Y = this.Y;
            aVar.Z = this.Z;
            aVar.aa = this.aa;
            aVar.ab = this.ab;
            aVar.ac = this.ac;
            aVar.ad = this.ad;
            aVar.ae = this.ae;
            aVar.af = this.af;
            aVar.ag = this.ag;
            aVar.ah = this.ah;
            aVar.ai = this.ai;
            return aVar;
        }

        public void a(android.support.constraint.ConstraintLayout.a aVar) {
            aVar.d = this.h;
            aVar.e = this.i;
            aVar.f = this.j;
            aVar.g = this.k;
            aVar.h = this.l;
            aVar.i = this.m;
            aVar.j = this.n;
            aVar.k = this.o;
            aVar.l = this.p;
            aVar.m = this.q;
            aVar.n = this.r;
            aVar.o = this.s;
            aVar.p = this.t;
            aVar.leftMargin = this.A;
            aVar.rightMargin = this.B;
            aVar.topMargin = this.C;
            aVar.bottomMargin = this.D;
            aVar.u = this.M;
            aVar.v = this.L;
            aVar.w = this.u;
            aVar.x = this.v;
            aVar.y = this.w;
            aVar.L = this.x;
            aVar.M = this.y;
            aVar.C = this.N;
            aVar.B = this.O;
            aVar.E = this.Q;
            aVar.D = this.P;
            aVar.F = this.ad;
            aVar.G = this.ae;
            aVar.J = this.af;
            aVar.K = this.ag;
            aVar.H = this.ah;
            aVar.I = this.ai;
            aVar.N = this.z;
            aVar.c = this.g;
            aVar.a = this.e;
            aVar.b = this.f;
            aVar.width = this.b;
            aVar.height = this.c;
            if (VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.F);
                aVar.setMarginEnd(this.E);
            }
            aVar.a();
        }

        public /* synthetic */ Object clone() {
            return a();
        }
    }

    static {
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintRight_toRightOf, 30);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintTop_toTopOf, 36);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_editor_absoluteX, 6);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_editor_absoluteY, 7);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintGuide_begin, 17);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintGuide_end, 18);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintGuide_percent, 19);
        c.append(android.support.constraint.c.a.ConstraintSet_android_orientation, 27);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintStart_toEndOf, 32);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintStart_toStartOf, 33);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginLeft, 13);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginTop, 16);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginRight, 14);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginBottom, 11);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginStart, 15);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_goneMarginEnd, 12);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintVertical_weight, 40);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHorizontal_weight, 39);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHorizontal_bias, 20);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintVertical_bias, 37);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintDimensionRatio, 5);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintLeft_creator, 60);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintTop_creator, 60);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintRight_creator, 60);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintBottom_creator, 60);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintBaseline_creator, 60);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginLeft, 24);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginRight, 28);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginStart, 31);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginEnd, 8);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginTop, 34);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_marginBottom, 2);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_width, 23);
        c.append(android.support.constraint.c.a.ConstraintSet_android_layout_height, 21);
        c.append(android.support.constraint.c.a.ConstraintSet_android_visibility, 22);
        c.append(android.support.constraint.c.a.ConstraintSet_android_alpha, 43);
        c.append(android.support.constraint.c.a.ConstraintSet_android_elevation, 44);
        c.append(android.support.constraint.c.a.ConstraintSet_android_rotationX, 45);
        c.append(android.support.constraint.c.a.ConstraintSet_android_rotationY, 46);
        c.append(android.support.constraint.c.a.ConstraintSet_android_scaleX, 47);
        c.append(android.support.constraint.c.a.ConstraintSet_android_scaleY, 48);
        c.append(android.support.constraint.c.a.ConstraintSet_android_transformPivotX, 49);
        c.append(android.support.constraint.c.a.ConstraintSet_android_transformPivotY, 50);
        c.append(android.support.constraint.c.a.ConstraintSet_android_translationX, 51);
        c.append(android.support.constraint.c.a.ConstraintSet_android_translationY, 52);
        c.append(android.support.constraint.c.a.ConstraintSet_android_translationZ, 53);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintWidth_default, 54);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHeight_default, 55);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintWidth_max, 56);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHeight_max, 57);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintWidth_min, 58);
        c.append(android.support.constraint.c.a.ConstraintSet_layout_constraintHeight_min, 59);
        c.append(android.support.constraint.c.a.ConstraintSet_android_id, 38);
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.constraint.c.a.ConstraintSet);
        a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (c.get(index)) {
                case 1:
                    aVar.p = a(typedArray, index, aVar.p);
                    break;
                case 2:
                    aVar.D = typedArray.getDimensionPixelSize(index, aVar.D);
                    break;
                case 3:
                    aVar.o = a(typedArray, index, aVar.o);
                    break;
                case 4:
                    aVar.n = a(typedArray, index, aVar.n);
                    break;
                case 5:
                    aVar.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.x = typedArray.getDimensionPixelOffset(index, aVar.x);
                    break;
                case 7:
                    aVar.y = typedArray.getDimensionPixelOffset(index, aVar.y);
                    break;
                case 8:
                    aVar.E = typedArray.getDimensionPixelSize(index, aVar.E);
                    break;
                case 9:
                    aVar.n = a(typedArray, index, aVar.t);
                    break;
                case 10:
                    aVar.s = a(typedArray, index, aVar.s);
                    break;
                case 11:
                    aVar.K = typedArray.getDimensionPixelSize(index, aVar.K);
                    break;
                case 12:
                    aVar.L = typedArray.getDimensionPixelSize(index, aVar.L);
                    break;
                case 13:
                    aVar.H = typedArray.getDimensionPixelSize(index, aVar.H);
                    break;
                case 14:
                    aVar.J = typedArray.getDimensionPixelSize(index, aVar.J);
                    break;
                case 15:
                    aVar.M = typedArray.getDimensionPixelSize(index, aVar.M);
                    break;
                case 16:
                    aVar.I = typedArray.getDimensionPixelSize(index, aVar.I);
                    break;
                case 17:
                    aVar.e = typedArray.getDimensionPixelOffset(index, aVar.e);
                    break;
                case 18:
                    aVar.f = typedArray.getDimensionPixelOffset(index, aVar.f);
                    break;
                case 19:
                    aVar.g = typedArray.getFloat(index, aVar.g);
                    break;
                case 20:
                    aVar.u = typedArray.getFloat(index, aVar.u);
                    break;
                case 21:
                    aVar.c = typedArray.getLayoutDimension(index, aVar.c);
                    break;
                case 22:
                    aVar.G = typedArray.getInt(index, aVar.G);
                    aVar.G = a[aVar.G];
                    break;
                case 23:
                    aVar.b = typedArray.getLayoutDimension(index, aVar.b);
                    break;
                case 24:
                    aVar.A = typedArray.getDimensionPixelSize(index, aVar.A);
                    break;
                case 25:
                    aVar.h = a(typedArray, index, aVar.h);
                    break;
                case 26:
                    aVar.i = a(typedArray, index, aVar.i);
                    break;
                case 27:
                    aVar.z = typedArray.getInt(index, aVar.z);
                    break;
                case 28:
                    aVar.B = typedArray.getDimensionPixelSize(index, aVar.B);
                    break;
                case 29:
                    aVar.j = a(typedArray, index, aVar.j);
                    break;
                case 30:
                    aVar.k = a(typedArray, index, aVar.k);
                    break;
                case 31:
                    aVar.F = typedArray.getDimensionPixelSize(index, aVar.F);
                    break;
                case 32:
                    aVar.q = a(typedArray, index, aVar.q);
                    break;
                case 33:
                    aVar.r = a(typedArray, index, aVar.r);
                    break;
                case 34:
                    aVar.C = typedArray.getDimensionPixelSize(index, aVar.C);
                    break;
                case 35:
                    aVar.m = a(typedArray, index, aVar.m);
                    break;
                case 36:
                    aVar.l = a(typedArray, index, aVar.l);
                    break;
                case 37:
                    aVar.v = typedArray.getFloat(index, aVar.v);
                    break;
                case 38:
                    aVar.d = typedArray.getResourceId(index, aVar.d);
                    break;
                case 39:
                    aVar.O = typedArray.getFloat(index, aVar.O);
                    break;
                case 40:
                    aVar.N = typedArray.getFloat(index, aVar.N);
                    break;
                case 41:
                    aVar.P = typedArray.getInt(index, aVar.P);
                    break;
                case 42:
                    aVar.Q = typedArray.getInt(index, aVar.Q);
                    break;
                case 43:
                    aVar.R = typedArray.getFloat(index, aVar.R);
                    break;
                case 44:
                    aVar.S = true;
                    aVar.T = typedArray.getFloat(index, aVar.T);
                    break;
                case 45:
                    aVar.U = typedArray.getFloat(index, aVar.U);
                    break;
                case 46:
                    aVar.V = typedArray.getFloat(index, aVar.V);
                    break;
                case 47:
                    aVar.W = typedArray.getFloat(index, aVar.W);
                    break;
                case 48:
                    aVar.X = typedArray.getFloat(index, aVar.X);
                    break;
                case 49:
                    aVar.Y = typedArray.getFloat(index, aVar.Y);
                    break;
                case 50:
                    aVar.Z = typedArray.getFloat(index, aVar.Z);
                    break;
                case 51:
                    aVar.aa = typedArray.getFloat(index, aVar.aa);
                    break;
                case 52:
                    aVar.ab = typedArray.getFloat(index, aVar.ab);
                    break;
                case 53:
                    aVar.ac = typedArray.getFloat(index, aVar.ac);
                    break;
                case 60:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + c.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + c.get(index));
                    break;
            }
        }
    }

    public void a(Context context, int i) {
        XmlPullParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                switch (eventType) {
                    case 0:
                        xml.getName();
                        break;
                    case 2:
                        String name = xml.getName();
                        a a = a(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            a.a = true;
                        }
                        this.b.put(Integer.valueOf(a.d), a);
                        break;
                    default:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.b.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.b.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                a aVar = (a) this.b.get(Integer.valueOf(id));
                android.support.constraint.ConstraintLayout.a aVar2 = (android.support.constraint.ConstraintLayout.a) childAt.getLayoutParams();
                aVar.a(aVar2);
                childAt.setLayoutParams(aVar2);
                childAt.setVisibility(aVar.G);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.R);
                    childAt.setRotationX(aVar.U);
                    childAt.setRotationY(aVar.V);
                    childAt.setScaleX(aVar.W);
                    childAt.setScaleY(aVar.X);
                    childAt.setPivotX(aVar.Y);
                    childAt.setPivotY(aVar.Z);
                    childAt.setTranslationX(aVar.aa);
                    childAt.setTranslationY(aVar.ab);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.ac);
                        if (aVar.S) {
                            childAt.setElevation(aVar.T);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = (a) this.b.get(num);
            if (aVar3.a) {
                View bVar = new b(constraintLayout.getContext());
                bVar.setId(num.intValue());
                LayoutParams b = constraintLayout.b();
                aVar3.a(b);
                constraintLayout.addView(bVar, b);
            }
        }
    }
}
