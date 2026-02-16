package com.devexpress.navigation.pagercontrol;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.devexpress.navigation.common.MapExtension;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabs.utils.ResetFlag;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class InternalPagerControlAdapter extends PagerAdapter {
    private ITabControlAdapter mBaseAdapter;
    private final IPagePositionProvider mPositionProvider;
    private final ResetFlag mResetFlag;
    private final Map<Object, Integer> mViews = new HashMap();

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return obj == view;
    }

    public InternalPagerControlAdapter(ITabControlAdapter iTabControlAdapter, IPagePositionProvider iPagePositionProvider, ResetFlag resetFlag) {
        this.mBaseAdapter = iTabControlAdapter;
        this.mPositionProvider = iPagePositionProvider;
        this.mResetFlag = resetFlag;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mBaseAdapter.getItemsCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.mBaseAdapter.getView(viewGroup, i);
        if (view == null) {
            view = new View(viewGroup.getContext());
        }
        if (view.getParent() != null) {
            viewGroup.removeView(view);
        }
        viewGroup.addView(view);
        this.mViews.remove(view);
        this.mViews.put(view, Integer.valueOf(i));
        view.clearFocus();
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.mViews.containsValue(Integer.valueOf(i))) {
            removeViewFromCache(i);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mResetFlag.isReset()) {
            this.mViews.clear();
            this.mResetFlag.setReset(false);
            return -2;
        }
        if (this.mViews.containsKey(obj)) {
            return this.mPositionProvider.getNewPosition(this.mViews.get(obj).intValue());
        }
        return -2;
    }

    private void removeViewFromCache(int i) {
        this.mViews.remove((View) MapExtension.getKeyByValue(this.mViews, Integer.valueOf(i)));
    }
}
