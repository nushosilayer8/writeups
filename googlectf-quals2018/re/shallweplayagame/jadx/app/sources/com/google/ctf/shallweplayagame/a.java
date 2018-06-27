package com.google.ctf.shallweplayagame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Queue;

public class a extends RelativeLayout {
    static final String a = new String(Character.toChars(9762));
    Context b;
    Queue<AnimatorSet> c;
    public a d = a.EMPTY;
    TextView e;

    enum a {
        EMPTY,
        X,
        O,
        DEATH
    }

    public a(Context context, Queue<AnimatorSet> queue) {
        super(context);
        this.b = context;
        this.c = queue;
        b();
        c();
    }

    private int a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, this.b.getResources().getDisplayMetrics());
    }

    private AnimatorSet a(final String str, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorUpdateListener anonymousClass1 = new AnimatorUpdateListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f = (Float) valueAnimator.getAnimatedValue();
                this.a.e.setScaleX(f.floatValue());
                this.a.e.setScaleY(f.floatValue());
            }
        };
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setDuration((long) i);
        ofFloat.addUpdateListener(anonymousClass1);
        ofFloat.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ a b;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.b.e.setText(str);
                if (str.equals(a.a)) {
                    b.b();
                } else if (str.equals(" ")) {
                    b.a();
                }
            }
        });
        Animator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setDuration((long) i);
        ofFloat2.addUpdateListener(anonymousClass1);
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AnimatorSet animatorSet = (AnimatorSet) this.a.c.poll();
                if (animatorSet != null) {
                    animatorSet.start();
                }
            }
        });
        animatorSet.play(ofFloat2).after(ofFloat);
        return animatorSet;
    }

    private void b() {
        int a = a(5);
        int a2 = a(5);
        setPadding(a, a2, a, a2);
        a = a(100);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        a = a(5);
        layoutParams.setMargins(a, a, a, a);
        setLayoutParams(layoutParams);
        setBackground(this.b.getResources().getDrawable(R.drawable.background));
    }

    private void c() {
        this.e = new TextView(this.b);
        this.e.setTypeface(Typeface.MONOSPACE);
        this.e.setTextColor(-1);
        this.e.setTextSize((float) a(20));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.e.setLayoutParams(layoutParams);
        this.e.setGravity(1);
        this.e.setText(" ");
        addView(this.e);
    }

    public void a(a aVar, int i) {
        this.d = aVar;
        String str = aVar == a.EMPTY ? " " : aVar == a.X ? "X" : aVar == a.O ? "O" : a;
        this.c.add(a(str, i));
    }

    public boolean a() {
        return this.d == a.EMPTY;
    }

    public void setValue(a aVar) {
        a(aVar, 100);
    }
}
