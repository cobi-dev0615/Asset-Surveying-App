package com.devexpress.navigation.navigationdrawer;

import android.util.Pair;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class YViewCache {
    ArrayList<Pair<VerticalCoordinates, WeakReference<View>>> cache = new ArrayList<>();

    public void Clear() {
        this.cache.clear();
    }

    public boolean Add(View view) {
        return this.cache.add(new Pair<>(new VerticalCoordinates(view.getTop(), view.getBottom()), new WeakReference(view)));
    }

    public View getView(float f) {
        for (int i = 0; i < this.cache.size(); i++) {
            Pair<VerticalCoordinates, WeakReference<View>> pair = this.cache.get(i);
            if (((VerticalCoordinates) pair.first).getTop() <= f && ((VerticalCoordinates) pair.first).getBottom() >= f) {
                return (View) ((WeakReference) pair.second).get();
            }
        }
        return null;
    }

    public void refreshY() {
        for (int i = 0; i < this.cache.size(); i++) {
            Pair<VerticalCoordinates, WeakReference<View>> pair = this.cache.get(i);
            View view = (View) ((WeakReference) pair.second).get();
            if (view != null) {
                ((VerticalCoordinates) pair.first).setTop(view.getTop());
                ((VerticalCoordinates) pair.first).setBottom(view.getBottom());
            }
        }
    }

    public boolean Empty() {
        return this.cache.size() == 0;
    }

    class VerticalCoordinates {
        int mBottom;
        int mTop;

        public VerticalCoordinates(int i, int i2) {
            this.mTop = i;
            this.mBottom = i2;
        }

        public int getTop() {
            return this.mTop;
        }

        void setTop(int i) {
            if (this.mTop != i) {
                this.mTop = i;
            }
        }

        public int getBottom() {
            return this.mBottom;
        }

        void setBottom(int i) {
            if (this.mBottom != i) {
                this.mBottom = i;
            }
        }
    }
}
