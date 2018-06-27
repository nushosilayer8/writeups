package android.support.v4.media.session;

import android.media.session.MediaSession.QueueItem;

class d {

    static class a {
        public static Object a(Object obj) {
            return ((QueueItem) obj).getDescription();
        }

        public static long b(Object obj) {
            return ((QueueItem) obj).getQueueId();
        }
    }
}
