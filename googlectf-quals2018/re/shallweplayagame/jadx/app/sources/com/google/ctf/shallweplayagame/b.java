package com.google.ctf.shallweplayagame;

import android.media.ToneGenerator;
import android.os.Handler;

public class b {
    static final ToneGenerator a = new ToneGenerator(3, 100);

    static void a() {
        new Handler().post(new Runnable() {
            public void run() {
                b.a.startTone(24, 100);
            }
        });
    }

    static void b() {
        new Handler().post(new Runnable() {
            public void run() {
                b.a.startTone(49, 100);
            }
        });
    }
}
