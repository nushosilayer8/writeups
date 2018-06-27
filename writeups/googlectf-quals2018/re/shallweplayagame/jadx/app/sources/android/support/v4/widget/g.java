package android.support.v4.widget;

import android.widget.ListView;

public class g extends a {
    private final ListView f;

    public g(ListView listView) {
        super(listView);
        this.f = listView;
    }

    public void a(int i, int i2) {
        h.a(this.f, i2);
    }

    public boolean e(int i) {
        return false;
    }

    public boolean f(int i) {
        ListView listView = this.f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
