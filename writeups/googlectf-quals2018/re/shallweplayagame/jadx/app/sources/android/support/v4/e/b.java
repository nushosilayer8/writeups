package android.support.v4.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        public b a(Parcel parcel) {
            return new b(parcel);
        }

        public b[] a(int i) {
            return new b[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    final boolean a = false;
    final Handler b = null;
    a c;

    class a extends android.support.v4.e.a.a {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        public void a(int i, Bundle bundle) {
            if (this.a.b != null) {
                this.a.b.post(new b(this.a, i, bundle));
            } else {
                this.a.a(i, bundle);
            }
        }
    }

    class b implements Runnable {
        final int a;
        final Bundle b;
        final /* synthetic */ b c;

        b(b bVar, int i, Bundle bundle) {
            this.c = bVar;
            this.a = i;
            this.b = bundle;
        }

        public void run() {
            this.c.a(this.a, this.b);
        }
    }

    b(Parcel parcel) {
        this.c = android.support.v4.e.a.a.a(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a(this);
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
