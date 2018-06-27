package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class c {

    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4, int i5);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);
    }

    static class b<T extends a> extends Callback {
        protected final T a;

        public b(T t) {
            this.a = t;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.a.a(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            this.a.a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.a.b(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.a.a((Object) playbackState);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.a.a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.a.a(charSequence);
        }

        public void onSessionDestroyed() {
            this.a.a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.a.a(str, bundle);
        }
    }

    public static class c {
        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }

        public static AudioAttributes a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
