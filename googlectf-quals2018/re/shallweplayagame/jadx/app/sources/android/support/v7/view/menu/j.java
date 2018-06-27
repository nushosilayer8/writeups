package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.support.v4.d.a.b;
import android.support.v4.h.c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class j implements b {
    private static String F;
    private static String G;
    private static String H;
    private static String I;
    private View A;
    private c B;
    private OnActionExpandListener C;
    private boolean D = false;
    private ContextMenuInfo E;
    h a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private int j = 4096;
    private char k;
    private int l = 4096;
    private Drawable m;
    private int n = 0;
    private u o;
    private Runnable p;
    private OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t = null;
    private Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    j(h hVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.a = hVar;
        this.b = i2;
        this.c = i;
        this.d = i3;
        this.e = i4;
        this.f = charSequence;
        this.z = i5;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = a.f(drawable).mutate();
            if (this.v) {
                a.a(drawable, this.t);
            }
            if (this.w) {
                a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    public b a(int i) {
        Context e = this.a.e();
        a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public b a(c cVar) {
        if (this.B != null) {
            this.B.f();
        }
        this.A = null;
        this.B = cVar;
        this.a.b(true);
        if (this.B != null) {
            this.B.a(new c.b(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public void a(boolean z) {
                    this.a.a.a(this.a);
                }
            });
        }
        return this;
    }

    public b a(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && this.b > 0) {
            view.setId(this.b);
        }
        this.a.b(this);
        return this;
    }

    public b a(CharSequence charSequence) {
        this.r = charSequence;
        this.a.b(false);
        return this;
    }

    public c a() {
        return this.B;
    }

    CharSequence a(p.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    public void a(u uVar) {
        this.o = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    void a(ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public void a(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & -5);
    }

    public b b(int i) {
        setShowAsAction(i);
        return this;
    }

    public b b(CharSequence charSequence) {
        this.s = charSequence;
        this.a.b(false);
        return this;
    }

    void b(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (this.y & -3);
        if (i != this.y) {
            this.a.b(false);
        }
    }

    public boolean b() {
        if ((this.q != null && this.q.onMenuItemClick(this)) || this.a.a(this.a, (MenuItem) this)) {
            return true;
        }
        if (this.p != null) {
            this.p.run();
            return true;
        }
        if (this.h != null) {
            try {
                this.a.e().startActivity(this.h);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.B != null && this.B.d();
    }

    public int c() {
        return this.e;
    }

    boolean c(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (this.y & -9);
        return i != this.y;
    }

    public boolean collapseActionView() {
        return (this.z & 8) == 0 ? false : this.A == null ? true : (this.C == null || this.C.onMenuItemActionCollapse(this)) ? this.a.d(this) : false;
    }

    char d() {
        return this.a.b() ? this.k : this.i;
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    String e() {
        char d = d();
        if (d == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(F);
        switch (d) {
            case 8:
                stringBuilder.append(H);
                break;
            case 10:
                stringBuilder.append(G);
                break;
            case ' ':
                stringBuilder.append(I);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void e(boolean z) {
        this.D = z;
        this.a.b(false);
    }

    public boolean expandActionView() {
        return !n() ? false : (this.C == null || this.C.onMenuItemActionExpand(this)) ? this.a.c(this) : false;
    }

    boolean f() {
        return this.a.c() && d() != 0;
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.A != null) {
            return this.A;
        }
        if (this.B == null) {
            return null;
        }
        this.A = this.B.a((MenuItem) this);
        return this.A;
    }

    public int getAlphabeticModifiers() {
        return this.l;
    }

    public char getAlphabeticShortcut() {
        return this.k;
    }

    public CharSequence getContentDescription() {
        return this.r;
    }

    public int getGroupId() {
        return this.c;
    }

    public Drawable getIcon() {
        if (this.m != null) {
            return a(this.m);
        }
        if (this.n == 0) {
            return null;
        }
        Drawable b = android.support.v7.b.a.b.b(this.a.e(), this.n);
        this.n = 0;
        this.m = b;
        return a(b);
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public Mode getIconTintMode() {
        return this.u;
    }

    public Intent getIntent() {
        return this.h;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.b;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.j;
    }

    public char getNumericShortcut() {
        return this.i;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.g != null ? this.g : this.f;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.s;
    }

    public void h() {
        this.a.b(this);
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return this.a.q();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public boolean isVisible() {
        return (this.B == null || !this.B.b()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.c();
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    public boolean n() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && this.B != null) {
            this.A = this.B.a((MenuItem) this);
        }
        return this.A != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.k != c) {
            this.k = Character.toLowerCase(c);
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (!(this.k == c && this.l == i)) {
            this.k = Character.toLowerCase(c);
            this.l = KeyEvent.normalizeMetaState(i);
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (this.y & -2);
        if (i != this.y) {
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.a.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return a(charSequence);
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.m = null;
        this.n = i;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.n = 0;
        this.m = drawable;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.i != c) {
            this.i = c;
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (!(this.i == c && this.j == i)) {
            this.i = c;
            this.j = KeyEvent.normalizeMetaState(i);
            this.a.b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.i = c;
        this.k = Character.toLowerCase(c2);
        this.a.b(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.i = c;
        this.j = KeyEvent.normalizeMetaState(i);
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState(i2);
        this.a.b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.z = i;
                this.a.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.a.e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        this.a.b(false);
        if (this.o != null) {
            this.o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f;
        }
        this.a.b(false);
        return this;
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return b(charSequence);
    }

    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.a.a(this);
        }
        return this;
    }

    public String toString() {
        return this.f != null ? this.f.toString() : null;
    }
}
