package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class p implements Parcelable {
    public static final Creator<p> CREATOR = new Creator<p>() {
        public p a(Parcel parcel) {
            return new p(parcel);
        }

        public p[] a(int i) {
            return new p[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    q[] a;
    int[] b;
    d[] c;
    int d = -1;
    int e;

    public p(Parcel parcel) {
        this.a = (q[]) parcel.createTypedArray(q.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (d[]) parcel.createTypedArray(d.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, i);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
