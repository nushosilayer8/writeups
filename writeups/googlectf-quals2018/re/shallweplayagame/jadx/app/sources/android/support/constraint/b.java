package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class b extends View {
    public b(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void draw(Canvas canvas) {
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setVisibility(int i) {
    }
}
