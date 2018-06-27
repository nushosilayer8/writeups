package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class d implements Parcelable {
    public static final Creator<d> CREATOR = new Creator<d>() {
        public d a(Parcel parcel) {
            return new d(parcel);
        }

        public d[] a(int i) {
            return new d[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public d(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public d(c cVar) {
        int size = cVar.c.size();
        this.a = new int[(size * 6)];
        if (cVar.j) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) cVar.c.get(i2);
                int i3 = i + 1;
                this.a[i] = aVar.a;
                int i4 = i3 + 1;
                this.a[i3] = aVar.b != null ? aVar.b.e : -1;
                int i5 = i4 + 1;
                this.a[i4] = aVar.c;
                i3 = i5 + 1;
                this.a[i5] = aVar.d;
                i5 = i3 + 1;
                this.a[i3] = aVar.e;
                i = i5 + 1;
                this.a[i5] = aVar.f;
            }
            this.b = cVar.h;
            this.c = cVar.i;
            this.d = cVar.l;
            this.e = cVar.n;
            this.f = cVar.o;
            this.g = cVar.p;
            this.h = cVar.q;
            this.i = cVar.r;
            this.j = cVar.s;
            this.k = cVar.t;
            this.l = cVar.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public c a(n nVar) {
        int i = 0;
        c cVar = new c(nVar);
        int i2 = 0;
        while (i < this.a.length) {
            a aVar = new a();
            int i3 = i + 1;
            aVar.a = this.a[i];
            if (n.a) {
                Log.v("FragmentManager", "Instantiate " + cVar + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i = this.a[i3];
            if (i >= 0) {
                aVar.b = (h) nVar.f.get(i);
            } else {
                aVar.b = null;
            }
            i3 = i4 + 1;
            aVar.c = this.a[i4];
            i4 = i3 + 1;
            aVar.d = this.a[i3];
            i3 = i4 + 1;
            aVar.e = this.a[i4];
            i4 = i3 + 1;
            aVar.f = this.a[i3];
            cVar.d = aVar.c;
            cVar.e = aVar.d;
            cVar.f = aVar.e;
            cVar.g = aVar.f;
            cVar.a(aVar);
            i2++;
            i = i4;
        }
        cVar.h = this.b;
        cVar.i = this.c;
        cVar.l = this.d;
        cVar.n = this.e;
        cVar.j = true;
        cVar.o = this.f;
        cVar.p = this.g;
        cVar.q = this.h;
        cVar.r = this.i;
        cVar.s = this.j;
        cVar.t = this.k;
        cVar.u = this.l;
        cVar.a(1);
        return cVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        if (this.l) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
