package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v4.h.c;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class g extends MenuInflater {
    static final Class<?>[] a = new Class[]{Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d = this.c;
    Context e;
    private Object f;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] a = new Class[]{MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, new Object[]{menuItem})).booleanValue();
                }
                this.c.invoke(this.b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private Mode F = null;
        c a;
        final /* synthetic */ g b;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(g gVar, Menu menu) {
            this.b = gVar;
            this.c = menu;
            a();
        }

        private char a(String str) {
            return str == null ? 0 : str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.b.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (this.b.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(this.b.a(), this.B));
            }
            if (menuItem instanceof j) {
                j jVar = (j) menuItem;
            }
            if (this.t >= 2) {
                if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                } else if (menuItem instanceof k) {
                    ((k) menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View) a(this.z, g.a, this.b.c));
            } else {
                z = false;
            }
            if (this.y > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.y);
                }
            }
            if (this.a != null) {
                android.support.v4.h.g.a(menuItem, this.a);
            }
            android.support.v4.h.g.a(menuItem, this.C);
            android.support.v4.h.g.b(menuItem, this.D);
            android.support.v4.h.g.b(menuItem, this.p, this.q);
            android.support.v4.h.g.a(menuItem, this.r, this.s);
            if (this.F != null) {
                android.support.v4.h.g.a(menuItem, this.F);
            }
            if (this.E != null) {
                android.support.v4.h.g.a(menuItem, this.E);
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.b.e.obtainStyledAttributes(attributeSet, android.support.v7.a.a.j.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public void b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.b.e.obtainStyledAttributes(attributeSet, android.support.v7.a.a.j.MenuItem);
            this.k = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_android_id, 0);
            this.l = (obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_android_menuCategory, this.e) & -65536) | (obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_android_title);
            this.n = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_android_titleCondensed);
            this.o = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_android_icon, 0);
            this.p = a(obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_alphabeticShortcut));
            this.q = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_alphabeticModifiers, 4096);
            this.r = a(obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_numericShortcut));
            this.s = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_android_checkable)) {
                this.t = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_checked, false);
            this.v = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_visible, this.h);
            this.w = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_enabled, this.i);
            this.x = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_showAsAction, -1);
            this.B = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_onClick);
            this.y = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_actionLayout, 0);
            this.z = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_actionViewClass);
            this.A = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_actionProviderClass);
            if (this.A == null) {
                z = false;
            }
            if (z && this.y == 0 && this.z == null) {
                this.a = (c) a(this.A, g.b, this.b.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.a = null;
            }
            this.C = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_contentDescription);
            this.D = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_iconTintMode)) {
                this.F = ae.a(obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_iconTint)) {
                this.E = obtainStyledAttributes.getColorStateList(android.support.v7.a.a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            obtainStyledAttributes.recycle();
            this.j = false;
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }
    }

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00dd;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d5;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.c();
        r10.a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00c9;
    L_0x00ab:
        r3 = r7.d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.a;
        if (r3 == 0) goto L_0x00c3;
    L_0x00b5:
        r3 = r7.a;
        r3 = r3.e();
        if (r3 == 0) goto L_0x00c3;
    L_0x00bd:
        r7.c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c3:
        r7.b();
        r3 = r5;
        goto L_0x0029;
    L_0x00c9:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d1:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d5:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.d.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.e.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
