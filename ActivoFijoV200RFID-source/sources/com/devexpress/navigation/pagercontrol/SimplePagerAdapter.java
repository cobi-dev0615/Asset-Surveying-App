package com.devexpress.navigation.pagercontrol;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SimplePagerAdapter extends PagerAdapter {
    private List<LinearLayout> mCustomPages;
    private boolean mLoopEnabled;
    private int mLoopsCount;
    private int mNewPosition;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return obj == view;
    }

    public SimplePagerAdapter(List<View> list) {
        this(list, false);
    }

    public SimplePagerAdapter(List<View> list, boolean z) {
        this.mCustomPages = new ArrayList();
        this.mLoopEnabled = false;
        this.mNewPosition = -2;
        this.mLoopsCount = 20;
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        this.mLoopEnabled = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mLoopEnabled ? this.mLoopsCount * this.mCustomPages.size() : this.mCustomPages.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = this.mCustomPages.get(i % this.mCustomPages.size());
        if (linearLayout.getParent() == null) {
            viewGroup.addView(linearLayout);
        }
        return linearLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (getRealPosition(this.mNewPosition) == getRealPosition(i) || getRealPosition(this.mNewPosition + 1) == getRealPosition(i) || getRealPosition(this.mNewPosition - 1) == getRealPosition(i)) {
            return;
        }
        viewGroup.removeView((View) obj);
    }

    public void add(View view) {
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(view);
        this.mCustomPages.add(linearLayout);
        notifyDataSetChanged();
    }

    public void clear() {
        Iterator<LinearLayout> it = this.mCustomPages.iterator();
        while (it.hasNext()) {
            it.next().removeAllViews();
        }
    }

    public void removeByIndex(int i) {
        this.mCustomPages.remove(i);
        notifyDataSetChanged();
    }

    public void changeSelectedItem(int i) {
        this.mNewPosition = i;
    }

    public void setLoopEnabled(boolean z) {
        this.mLoopEnabled = z;
        notifyDataSetChanged();
    }

    private int getRealPosition(int i) {
        return i % this.mCustomPages.size();
    }
}
