package crc64588f1aa41a024a66;

import com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider;
import com.devexpress.editors.dataForm.protocols.DataFormEditorInfo;
import com.devexpress.editors.dataForm.protocols.DataFormValueValidationError;
import com.devexpress.editors.dataForm.protocols.DataFormValuesValidationErrors;
import com.devexpress.editors.dataForm.protocols.ExpanderInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataFormDataProvider extends DXDataFormDataProvider implements IGCUserPeer {
    public static final String __md_methods = "n_getEditors:(I)Ljava/util/List;:GetGetEditors_IHandler\nn_getGroups:()Ljava/util/List;:GetGetGroupsHandler\nn_isLastElementInLine:(II)Z:GetIsLastElementInLine_IIHandler\nn_getEditor:(II)Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;:GetGetEditor_IIHandler\nn_getGroup:(I)Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;:GetGetGroup_IHandler\nn_getPickerDataSource:(II)Ljava/util/List;:GetGetPickerDataSource_IIHandler\nn_isSourceUpdated:(II)Z:GetIsSourceUpdated_IIHandler\nn_postValue:(Ljava/lang/Object;II)V:GetPostValue_Ljava_lang_Object_IIHandler\nn_validate:(Ljava/lang/Object;II)Lcom/devexpress/editors/dataForm/protocols/DataFormValueValidationError;:GetValidate_Ljava_lang_Object_IIHandler\nn_preValidate:(Ljava/lang/Object;II)Lcom/devexpress/editors/dataForm/protocols/DataFormValueValidationError;:GetPreValidate_Ljava_lang_Object_IIHandler\nn_postValidate:(II)Lcom/devexpress/editors/dataForm/protocols/DataFormValueValidationError;:GetPostValidate_IIHandler\nn_validateValues:(Ljava/util/Map;)Lcom/devexpress/editors/dataForm/protocols/DataFormValuesValidationErrors;:GetValidateValues_Ljava_util_Map_Handler\n";
    private ArrayList refList;

    private native DataFormEditorInfo n_getEditor(int i, int i2);

    private native List n_getEditors(int i);

    private native ExpanderInfo n_getGroup(int i);

    private native List n_getGroups();

    private native List n_getPickerDataSource(int i, int i2);

    private native boolean n_isLastElementInLine(int i, int i2);

    private native boolean n_isSourceUpdated(int i, int i2);

    private native DataFormValueValidationError n_postValidate(int i, int i2);

    private native void n_postValue(Object obj, int i, int i2);

    private native DataFormValueValidationError n_preValidate(Object obj, int i, int i2);

    private native DataFormValueValidationError n_validate(Object obj, int i, int i2);

    private native DataFormValuesValidationErrors n_validateValues(Map map);

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormDataProvider, DevExpress.Maui.Editors", DataFormDataProvider.class, __md_methods);
    }

    public DataFormDataProvider() {
        if (getClass() == DataFormDataProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormDataProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public List getEditors(int i) {
        return n_getEditors(i);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public List getGroups() {
        return n_getGroups();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public boolean isLastElementInLine(int i, int i2) {
        return n_isLastElementInLine(i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public DataFormEditorInfo getEditor(int i, int i2) {
        return n_getEditor(i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public ExpanderInfo getGroup(int i) {
        return n_getGroup(i);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public List getPickerDataSource(int i, int i2) {
        return n_getPickerDataSource(i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public boolean isSourceUpdated(int i, int i2) {
        return n_isSourceUpdated(i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public void postValue(Object obj, int i, int i2) {
        n_postValue(obj, i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public DataFormValueValidationError validate(Object obj, int i, int i2) {
        return n_validate(obj, i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public DataFormValueValidationError preValidate(Object obj, int i, int i2) {
        return n_preValidate(obj, i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public DataFormValueValidationError postValidate(int i, int i2) {
        return n_postValidate(i, i2);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider
    public DataFormValuesValidationErrors validateValues(Map map) {
        return n_validateValues(map);
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
