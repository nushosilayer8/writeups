package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.a.g;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        private final List<a> a;
        private b b;
        private HashMap<a, a> c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.b = android.support.v4.media.session.b.a.a(g.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        private static class a extends c {
            a(a aVar) {
                super(aVar);
            }

            public void a() {
                throw new AssertionError();
            }

            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void a(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void a(List<QueueItem> list) {
                throw new AssertionError();
            }
        }

        private void a() {
            if (this.b != null) {
                synchronized (this.a) {
                    for (a aVar : this.a) {
                        a aVar2 = new a(aVar);
                        this.c.put(aVar, aVar2);
                        aVar.b = true;
                        try {
                            this.b.a(aVar2);
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.a.clear();
                }
            }
        }
    }

    public static abstract class a implements DeathRecipient {
        a a;
        boolean b;
        private final Object c;

        private static class c extends android.support.v4.media.session.a.a {
            private final WeakReference<a> a;

            c(a aVar) {
                this.a = new WeakReference(aVar);
            }

            public void a() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            public void a(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new b(parcelableVolumeInfo.a, parcelableVolumeInfo.b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e) : null, null);
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a(List<QueueItem> list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void a(boolean z) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(10, Boolean.valueOf(z), null);
                }
            }

            public void b(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void b(boolean z) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }
        }

        private class a extends Handler {
            boolean a;
            final /* synthetic */ a b;

            public void handleMessage(Message message) {
                if (this.a) {
                    switch (message.what) {
                        case 1:
                            this.b.a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.b.a((b) message.obj);
                            return;
                        case 5:
                            this.b.a((List) message.obj);
                            return;
                        case 6:
                            this.b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.b.a((Bundle) message.obj);
                            return;
                        case 8:
                            this.b.a();
                            return;
                        case 9:
                            this.b.a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.b.b(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            this.b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.b.b(((Integer) message.obj).intValue());
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class b implements android.support.v4.media.session.c.a {
            private final WeakReference<a> a;

            b(a aVar) {
                this.a = new WeakReference(aVar);
            }

            public void a() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a();
                }
            }

            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            public void a(Object obj) {
                a aVar = (a) this.a.get();
                if (aVar != null && !aVar.b) {
                    aVar.a(PlaybackStateCompat.a(obj));
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar == null) {
                    return;
                }
                if (!aVar.b || VERSION.SDK_INT >= 23) {
                    aVar.a(str, bundle);
                }
            }

            public void a(List<?> list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(QueueItem.a((List) list));
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }
        }

        public a() {
            if (VERSION.SDK_INT >= 21) {
                this.c = c.a(new b(this));
            } else {
                this.c = new c(this);
            }
        }

        public void a() {
        }

        public void a(int i) {
        }

        void a(int i, Object obj, Bundle bundle) {
            if (this.a != null) {
                Message obtainMessage = this.a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b(int i) {
        }

        @Deprecated
        public void b(boolean z) {
        }
    }

    public static final class b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }
}
