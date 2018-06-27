package com.google.ctf.shallweplayagame;

class N {
    static final int[] a = new int[]{0, 1, 0};
    static final int[] b = new int[]{1, 0, 2};
    static final int[] c = new int[]{2, 0, 1};
    static final int[] d = new int[]{3, 0, 0};
    static final int[] e = new int[]{4, 1, 0};
    static final int[] f = new int[]{5, 0, 1};
    static final int[] g = new int[]{6, 0, 0};
    static final int[] h = new int[]{7, 0, 2};
    static final int[] i = new int[]{8, 0, 1};

    static {
        System.loadLibrary("rary");
    }

    static native Object _(Object... objArr);
}
