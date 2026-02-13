package com.devexpress.navigation.pagercontrol;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.devexpress.navigation.common.MapExtension;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabs.utils.ResetFlag;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class InternalPagerFragmentAdapter extends FragmentStatePagerAdapter {
    private final ITabControlAdapter mBaseAdapter;
    private final Map<Object, Integer> mFragments;
    private final IPagePositionProvider mPositionProvider;
    private final ResetFlag mResetFlag;

    public InternalPagerFragmentAdapter(ITabControlAdapter iTabControlAdapter, FragmentManager fragmentManager, IPagePositionProvider iPagePositionProvider, ResetFlag resetFlag) {
        super(fragmentManager, 1);
        this.mFragments = new HashMap();
        this.mBaseAdapter = iTabControlAdapter;
        this.mPositionProvider = iPagePositionProvider;
        this.mResetFlag = resetFlag;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        Fragment fragment = (Fragment) this.mBaseAdapter.getFragment(i);
        if (this.mFragments.containsValue(Integer.valueOf(i))) {
            removeFragmentFromCache(i);
        }
        this.mFragments.put(fragment, Integer.valueOf(i));
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mBaseAdapter.getItemsCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        if (this.mFragments.containsValue(Integer.valueOf(i))) {
            removeFragmentFromCache(i);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mResetFlag.isReset()) {
            this.mFragments.clear();
            this.mResetFlag.setReset(false);
            return -2;
        }
        if (this.mFragments.containsKey(obj)) {
            return this.mPositionProvider.getNewPosition(this.mFragments.get(obj).intValue());
        }
        return -2;
    }

    private void removeFragmentFromCache(int i) {
        this.mFragments.remove((Fragment) MapExtension.getKeyByValue(this.mFragments, Integer.valueOf(i)));
    }
}
