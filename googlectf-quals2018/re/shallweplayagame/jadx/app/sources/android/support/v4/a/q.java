package android.support.v4.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class q implements Parcelable {
    public static final Creator<q> CREATOR = new Creator<q>() {
        public q a(Parcel parcel) {
            return new q(parcel);
        }

        public q[] a(int i) {
            return new q[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    h l;

    public q(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.j = z;
        this.k = parcel.readBundle();
    }

    public q(h hVar) {
        this.a = hVar.getClass().getName();
        this.b = hVar.e;
        this.c = hVar.m;
        this.d = hVar.w;
        this.e = hVar.x;
        this.f = hVar.y;
        this.g = hVar.B;
        this.h = hVar.A;
        this.i = hVar.g;
        this.j = hVar.z;
    }

    public h a(l lVar, j jVar, h hVar, o oVar) {
        if (this.l == null) {
            Context g = lVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            if (jVar != null) {
                this.l = jVar.a(g, this.a, this.i);
            } else {
                this.l = h.a(g, this.a, this.i);
            }
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.c = this.k;
            }
            this.l.a(this.b, hVar);
            this.l.m = this.c;
            this.l.o = true;
            this.l.w = this.d;
            this.l.x = this.e;
            this.l.y = this.f;
            this.l.B = this.g;
            this.l.A = this.h;
            this.l.z = this.j;
            this.l.r = lVar.d;
            if (n.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.u = oVar;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        if (!this.j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.k);
    }
}
