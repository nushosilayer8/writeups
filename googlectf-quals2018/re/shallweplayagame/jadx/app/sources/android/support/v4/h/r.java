package android.support.v4.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class r {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    static class a implements s {
        r a;
        boolean b;

        a(r rVar) {
            this.a = rVar;
        }

        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            s sVar = tag instanceof s ? (s) tag : null;
            if (sVar != null) {
                sVar.a(view);
            }
        }

        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                s sVar = tag instanceof s ? (s) tag : null;
                if (sVar != null) {
                    sVar.b(view);
                }
                this.b = true;
            }
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            s sVar = tag instanceof s ? (s) tag : null;
            if (sVar != null) {
                sVar.c(view);
            }
        }
    }

    r(View view) {
        this.d = new WeakReference(view);
    }

    private void a(final View view, final s sVar) {
        if (sVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ r c;

                public void onAnimationCancel(Animator animator) {
                    sVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    sVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    sVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long a() {
        View view = (View) this.d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    public r a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public r a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public r a(s sVar) {
        View view = (View) this.d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                a(view, sVar);
            } else {
                view.setTag(2113929216, sVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    public r a(final u uVar) {
        final View view = (View) this.d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (uVar != null) {
                animatorUpdateListener = new AnimatorUpdateListener(this) {
                    final /* synthetic */ r c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        uVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public r a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public r b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public r b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
