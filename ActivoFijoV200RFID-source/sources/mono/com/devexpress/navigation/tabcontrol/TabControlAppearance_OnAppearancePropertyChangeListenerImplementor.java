package mono.com.devexpress.navigation.tabcontrol;

import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.SelectedStyleProperty;
import com.devexpress.navigation.tabs.models.StyleProperty;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabControlAppearance_OnAppearancePropertyChangeListenerImplementor implements IGCUserPeer, TabControlAppearance.OnAppearancePropertyChangeListener {
    public static final String __md_methods = "n_onIndicatorPropertyChanged:()V:GetOnIndicatorPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onItemCornerRadiusPropertyChanged:()V:GetOnItemCornerRadiusPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onItemPaddingPropertyChanged:()V:GetOnItemPaddingPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onItemSelectedPropertyChanged:(Lcom/devexpress/navigation/tabs/models/SelectedStyleProperty;)V:GetOnItemSelectedPropertyChanged_Lcom_devexpress_navigation_tabs_models_SelectedStyleProperty_Handler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onItemSpacingPropertyChanged:()V:GetOnItemSpacingPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onItemStylePropertyChanged:(Lcom/devexpress/navigation/tabs/models/StyleProperty;)V:GetOnItemStylePropertyChanged_Lcom_devexpress_navigation_tabs_models_StyleProperty_Handler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onPanelBackgroundPropertyChanged:()V:GetOnPanelBackgroundPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onPanelIndentPropertyChanged:()V:GetOnPanelIndentPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onPanelPaddingPropertyChanged:()V:GetOnPanelPaddingPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\nn_onPanelSpacingPropertyChanged:()V:GetOnPanelSpacingPropertyChangedHandler:DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance/IOnAppearancePropertyChangeListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onIndicatorPropertyChanged();

    private native void n_onItemCornerRadiusPropertyChanged();

    private native void n_onItemPaddingPropertyChanged();

    private native void n_onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty);

    private native void n_onItemSpacingPropertyChanged();

    private native void n_onItemStylePropertyChanged(StyleProperty styleProperty);

    private native void n_onPanelBackgroundPropertyChanged();

    private native void n_onPanelIndentPropertyChanged();

    private native void n_onPanelPaddingPropertyChanged();

    private native void n_onPanelSpacingPropertyChanged();

    static {
        Runtime.register("DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance+IOnAppearancePropertyChangeListenerImplementor, DXNavigation.a", TabControlAppearance_OnAppearancePropertyChangeListenerImplementor.class, __md_methods);
    }

    public TabControlAppearance_OnAppearancePropertyChangeListenerImplementor() {
        if (getClass() == TabControlAppearance_OnAppearancePropertyChangeListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Tabcontrol.TabControlAppearance+IOnAppearancePropertyChangeListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onIndicatorPropertyChanged() {
        n_onIndicatorPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onItemCornerRadiusPropertyChanged() {
        n_onItemCornerRadiusPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onItemPaddingPropertyChanged() {
        n_onItemPaddingPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
        n_onItemSelectedPropertyChanged(selectedStyleProperty);
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onItemSpacingPropertyChanged() {
        n_onItemSpacingPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onItemStylePropertyChanged(StyleProperty styleProperty) {
        n_onItemStylePropertyChanged(styleProperty);
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onPanelBackgroundPropertyChanged() {
        n_onPanelBackgroundPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onPanelIndentPropertyChanged() {
        n_onPanelIndentPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onPanelPaddingPropertyChanged() {
        n_onPanelPaddingPropertyChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
    public void onPanelSpacingPropertyChanged() {
        n_onPanelSpacingPropertyChanged();
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
