package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class f {
    static final b a;

    interface b {
        ColorStateList a(ImageView imageView);

        void a(ImageView imageView, ColorStateList colorStateList);

        void a(ImageView imageView, Mode mode);

        Mode b(ImageView imageView);
    }

    static class a implements b {
        a() {
        }

        public ColorStateList a(ImageView imageView) {
            return imageView instanceof l ? ((l) imageView).getSupportImageTintList() : null;
        }

        public void a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof l) {
                ((l) imageView).setSupportImageTintList(colorStateList);
            }
        }

        public void a(ImageView imageView, Mode mode) {
            if (imageView instanceof l) {
                ((l) imageView).setSupportImageTintMode(mode);
            }
        }

        public Mode b(ImageView imageView) {
            return imageView instanceof l ? ((l) imageView).getSupportImageTintMode() : null;
        }
    }

    static class c extends a {
        c() {
        }

        public ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public void a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public void a(ImageView imageView, Mode mode) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new c();
        } else {
            a = new a();
        }
    }

    public static ColorStateList a(ImageView imageView) {
        return a.a(imageView);
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        a.a(imageView, colorStateList);
    }

    public static void a(ImageView imageView, Mode mode) {
        a.a(imageView, mode);
    }

    public static Mode b(ImageView imageView) {
        return a.b(imageView);
    }
}
