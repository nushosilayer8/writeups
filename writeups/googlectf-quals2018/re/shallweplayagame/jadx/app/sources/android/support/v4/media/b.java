package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

class b extends a {

    static class a extends a {
        public static void b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
