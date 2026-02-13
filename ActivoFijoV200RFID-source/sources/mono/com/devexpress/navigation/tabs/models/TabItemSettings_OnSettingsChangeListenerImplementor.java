package mono.com.devexpress.navigation.tabs.models;

import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.models.TabItemSettings;
import com.devexpress.navigation.tabs.models.TabSize;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabItemSettings_OnSettingsChangeListenerImplementor implements IGCUserPeer, TabItemSettings.OnSettingsChangeListener {
    public static final String __md_methods = "n_onHeaderHeightOnVerticalPanelChanged:(Ljava/lang/Object;Lcom/devexpress/navigation/tabs/models/TabSize;Lcom/devexpress/navigation/tabs/models/TabSize;)V:GetOnHeaderHeightOnVerticalPanelChanged_Ljava_lang_Object_Lcom_devexpress_navigation_tabs_models_TabSize_Lcom_devexpress_navigation_tabs_models_TabSize_Handler:DevExpress.Android.Navigation.Tabs.Models.TabItemSettings/IOnSettingsChangeListenerInvoker, DXNavigation.a\nn_onHeaderIconPositionChanged:(Lcom/devexpress/navigation/common/Position;Lcom/devexpress/navigation/common/Position;)V:GetOnHeaderIconPositionChanged_Lcom_devexpress_navigation_common_Position_Lcom_devexpress_navigation_common_Position_Handler:DevExpress.Android.Navigation.Tabs.Models.TabItemSettings/IOnSettingsChangeListenerInvoker, DXNavigation.a\nn_onHeaderVisibleElementsChanged:(Lcom/devexpress/navigation/common/HeaderElements;Lcom/devexpress/navigation/common/HeaderElements;)V:GetOnHeaderVisibleElementsChanged_Lcom_devexpress_navigation_common_HeaderElements_Lcom_devexpress_navigation_common_HeaderElements_Handler:DevExpress.Android.Navigation.Tabs.Models.TabItemSettings/IOnSettingsChangeListenerInvoker, DXNavigation.a\nn_onHeaderWidthOnHorizontalPanelChanged:(Ljava/lang/Object;Lcom/devexpress/navigation/tabs/models/TabSize;Lcom/devexpress/navigation/tabs/models/TabSize;)V:GetOnHeaderWidthOnHorizontalPanelChanged_Ljava_lang_Object_Lcom_devexpress_navigation_tabs_models_TabSize_Lcom_devexpress_navigation_tabs_models_TabSize_Handler:DevExpress.Android.Navigation.Tabs.Models.TabItemSettings/IOnSettingsChangeListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2);

    private native void n_onHeaderIconPositionChanged(Position position, Position position2);

    private native void n_onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2);

    private native void n_onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2);

    static {
        Runtime.register("DevExpress.Android.Navigation.Tabs.Models.TabItemSettings+IOnSettingsChangeListenerImplementor, DXNavigation.a", TabItemSettings_OnSettingsChangeListenerImplementor.class, __md_methods);
    }

    public TabItemSettings_OnSettingsChangeListenerImplementor() {
        if (getClass() == TabItemSettings_OnSettingsChangeListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Tabs.Models.TabItemSettings+IOnSettingsChangeListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
    public void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
        n_onHeaderHeightOnVerticalPanelChanged(obj, tabSize, tabSize2);
    }

    @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
    public void onHeaderIconPositionChanged(Position position, Position position2) {
        n_onHeaderIconPositionChanged(position, position2);
    }

    @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
    public void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2) {
        n_onHeaderVisibleElementsChanged(headerElements, headerElements2);
    }

    @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
    public void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
        n_onHeaderWidthOnHorizontalPanelChanged(obj, tabSize, tabSize2);
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
