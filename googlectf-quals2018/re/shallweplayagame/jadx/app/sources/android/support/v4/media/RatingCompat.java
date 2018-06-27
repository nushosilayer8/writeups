package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        public RatingCompat a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] a(int i) {
            return new RatingCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    private final int a;
    private final float b;

    RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public int describeContents() {
        return this.a;
    }

    public String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
