package com.devexpress.navigation.navigationdrawer;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DrawerViewAdapter implements IDrawerViewAdapter {
    private View mDrawerContent;
    private View mDrawerFooterContent;
    private View mDrawerHeaderContent;
    private View mMainContent;
    private FragmentManager mMainContentFragmentManager;
    private FragmentTransaction mMainContentFragmentTransaction;
    private Fragment mMainContentPage;
    private boolean mUseFragmentInContent = false;
    private final List<IDrawerViewAdapter.ContentChangedListener> mListeners = new ArrayList();
    private final String fragmentId = "dxDrawerFragment";

    public void setMainContent(View view) {
        if (this.mMainContent != view) {
            this.mUseFragmentInContent = false;
            Fragment fragment = this.mMainContentPage;
            if (fragment != null) {
                fragment.onDestroyView();
                this.mMainContentPage = null;
            }
            this.mMainContentFragmentManager = null;
            this.mMainContent = view;
            raiseContentChange();
        }
    }

    public void setMainContentPage(Object obj, Object obj2) {
        if (this.mMainContentFragmentManager != obj2) {
            this.mMainContentFragmentManager = (FragmentManager) obj2;
        }
        if (this.mMainContentPage != obj) {
            this.mUseFragmentInContent = true;
            this.mMainContent = null;
            this.mMainContentPage = (Fragment) obj;
            raiseContentChange();
        }
    }

    public void setDrawerContent(View view) {
        if (this.mDrawerContent != view) {
            this.mDrawerContent = view;
            raiseContentChange();
        }
    }

    public void setDrawerHeaderContent(View view) {
        if (this.mDrawerHeaderContent != view) {
            this.mDrawerHeaderContent = view;
            raiseContentChange();
        }
    }

    public void setDrawerFooterContent(View view) {
        if (this.mDrawerFooterContent != view) {
            this.mDrawerFooterContent = view;
            raiseContentChange();
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public void ApplyMainContent(ContentView contentView) {
        if (this.mUseFragmentInContent) {
            RecreateMainContentViaFragment(contentView);
            return;
        }
        View view = this.mMainContent;
        if (view != null) {
            contentView.setContent(view);
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public View getDrawerContent(ViewGroup viewGroup) {
        return this.mDrawerContent;
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public View getDrawerHeaderContent(ViewGroup viewGroup) {
        return this.mDrawerHeaderContent;
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public View getDrawerFooterContent(ViewGroup viewGroup) {
        return this.mDrawerFooterContent;
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public void addContentChangedListener(IDrawerViewAdapter.ContentChangedListener contentChangedListener) {
        if (this.mListeners.indexOf(contentChangedListener) < 0) {
            this.mListeners.add(contentChangedListener);
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public void removeContentChangedListener(IDrawerViewAdapter.ContentChangedListener contentChangedListener) {
        this.mListeners.remove(contentChangedListener);
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter
    public void clearContentChangedListener() {
        this.mListeners.clear();
    }

    private void RecreateMainContentViaFragment(ViewGroup viewGroup) {
        Fragment fragment = this.mMainContentPage;
        if (fragment == null) {
            return;
        }
        fragment.setMenuVisibility(false);
        this.mMainContentFragmentManager.executePendingTransactions();
        if (this.mMainContentFragmentTransaction == null) {
            this.mMainContentFragmentTransaction = this.mMainContentFragmentManager.beginTransaction();
        }
        Fragment findFragmentById = this.mMainContentFragmentManager.findFragmentById(viewGroup.getId());
        MakeNavigationHostFragmentRemovable(this.mMainContentPage);
        if (findFragmentById != null) {
            MakeNavigationHostFragmentRemovable(findFragmentById);
        }
        this.mMainContentFragmentTransaction.replace(viewGroup.getId(), this.mMainContentPage, "dxDrawerFragment");
        this.mMainContentFragmentTransaction.commitAllowingStateLoss();
        this.mMainContentFragmentTransaction = null;
        this.mMainContentFragmentManager.executePendingTransactions();
    }

    private void MakeNavigationHostFragmentRemovable(Fragment fragment) {
        NavHostFragment findNavHostFragment = findNavHostFragment(fragment.getView());
        if (findNavHostFragment != null) {
            Navigation.setViewNavController((View) findNavHostFragment.getView().getParent(), Navigation.findNavController(findNavHostFragment.getView()));
        }
    }

    private NavHostFragment findNavHostFragment(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof FragmentContainerView) {
                Fragment findFragment = FragmentManager.findFragment(childAt);
                if (findFragment instanceof NavHostFragment) {
                    return (NavHostFragment) findFragment;
                }
            }
            NavHostFragment findNavHostFragment = findNavHostFragment(childAt);
            if (findNavHostFragment != null) {
                return findNavHostFragment;
            }
        }
        return null;
    }

    private void raiseContentChange() {
        Iterator<IDrawerViewAdapter.ContentChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onContentChanged();
        }
    }
}
