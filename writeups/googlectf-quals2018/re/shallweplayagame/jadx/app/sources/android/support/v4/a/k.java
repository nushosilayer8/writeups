package android.support.v4.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class k {
    private final l<?> a;

    private k(l<?> lVar) {
        this.a = lVar;
    }

    public static final k a(l<?> lVar) {
        return new k(lVar);
    }

    public h a(String str) {
        return this.a.d.b(str);
    }

    public m a() {
        return this.a.i();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.d.onCreateView(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void a(Parcelable parcelable, o oVar) {
        this.a.d.a(parcelable, oVar);
    }

    public void a(h hVar) {
        this.a.d.a(this.a, this.a, hVar);
    }

    public void a(android.support.v4.g.k<String, u> kVar) {
        this.a.a((android.support.v4.g.k) kVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.a.b(str, fileDescriptor, printWriter, strArr);
    }

    public void a(boolean z) {
        this.a.d.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public void b() {
        this.a.d.k();
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public void b(boolean z) {
        this.a.d.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public Parcelable c() {
        return this.a.d.j();
    }

    public void c(boolean z) {
        this.a.a(z);
    }

    public o d() {
        return this.a.d.h();
    }

    public void e() {
        this.a.d.l();
    }

    public void f() {
        this.a.d.m();
    }

    public void g() {
        this.a.d.n();
    }

    public void h() {
        this.a.d.o();
    }

    public void i() {
        this.a.d.p();
    }

    public void j() {
        this.a.d.q();
    }

    public void k() {
        this.a.d.r();
    }

    public void l() {
        this.a.d.t();
    }

    public void m() {
        this.a.d.u();
    }

    public boolean n() {
        return this.a.d.e();
    }

    public void o() {
        this.a.k();
    }

    public void p() {
        this.a.l();
    }

    public void q() {
        this.a.m();
    }

    public android.support.v4.g.k<String, u> r() {
        return this.a.n();
    }
}
