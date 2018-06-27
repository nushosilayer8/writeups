package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c<android.support.v4.d.a.b> implements MenuItem {
    private Method c;

    class a extends android.support.v4.h.c {
        final ActionProvider a;
        final /* synthetic */ k b;

        public a(k kVar, Context context, ActionProvider actionProvider) {
            this.b = kVar;
            super(context);
            this.a = actionProvider;
        }

        public View a() {
            return this.a.onCreateActionView();
        }

        public void a(SubMenu subMenu) {
            this.a.onPrepareSubMenu(this.b.a(subMenu));
        }

        public boolean d() {
            return this.a.onPerformDefaultAction();
        }

        public boolean e() {
            return this.a.hasSubMenu();
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView a;

        b(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.a.onActionViewExpanded();
        }

        public void b() {
            this.a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.a;
        }
    }

    private class c extends d<OnActionExpandListener> implements OnActionExpandListener {
        final /* synthetic */ k a;

        c(k kVar, OnActionExpandListener onActionExpandListener) {
            this.a = kVar;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.a.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.a.a(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ k a;

        d(k kVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.a = kVar;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.a.a(menuItem));
        }
    }

    k(Context context, android.support.v4.d.a.b bVar) {
        super(context, bVar);
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.a, actionProvider);
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = ((android.support.v4.d.a.b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((android.support.v4.d.a.b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((android.support.v4.d.a.b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        android.support.v4.h.c a = ((android.support.v4.d.a.b) this.b).a();
        return a instanceof a ? ((a) a).a : null;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.d.a.b) this.b).getActionView();
        return actionView instanceof b ? ((b) actionView).c() : actionView;
    }

    public int getAlphabeticModifiers() {
        return ((android.support.v4.d.a.b) this.b).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.d.a.b) this.b).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((android.support.v4.d.a.b) this.b).getContentDescription();
    }

    public int getGroupId() {
        return ((android.support.v4.d.a.b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((android.support.v4.d.a.b) this.b).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((android.support.v4.d.a.b) this.b).getIconTintList();
    }

    public Mode getIconTintMode() {
        return ((android.support.v4.d.a.b) this.b).getIconTintMode();
    }

    public Intent getIntent() {
        return ((android.support.v4.d.a.b) this.b).getIntent();
    }

    public int getItemId() {
        return ((android.support.v4.d.a.b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.d.a.b) this.b).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((android.support.v4.d.a.b) this.b).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((android.support.v4.d.a.b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((android.support.v4.d.a.b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.d.a.b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((android.support.v4.d.a.b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.d.a.b) this.b).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((android.support.v4.d.a.b) this.b).getTooltipText();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.d.a.b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.d.a.b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((android.support.v4.d.a.b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((android.support.v4.d.a.b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((android.support.v4.d.a.b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((android.support.v4.d.a.b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.d.a.b) this.b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.d.a.b) this.b).setActionView(i);
        View actionView = ((android.support.v4.d.a.b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.d.a.b) this.b).setActionView(new b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.d.a.b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.d.a.b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((android.support.v4.d.a.b) this.b).setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.d.a.b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.d.a.b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.b).a(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.d.a.b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.d.a.b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.d.a.b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((android.support.v4.d.a.b) this.b).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((android.support.v4.d.a.b) this.b).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.d.a.b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.d.a.b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((android.support.v4.d.a.b) this.b).setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.d.a.b) this.b).setOnActionExpandListener(onActionExpandListener != null ? new c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.d.a.b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.d.a.b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((android.support.v4.d.a.b) this.b).setShortcut(c, c2, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.d.a.b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.d.a.b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.d.a.b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((android.support.v4.d.a.b) this.b).b(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.d.a.b) this.b).setVisible(z);
    }
}
