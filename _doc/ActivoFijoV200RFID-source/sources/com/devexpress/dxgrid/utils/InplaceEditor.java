package com.devexpress.dxgrid.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.wrappers.CustomGridCellContainerAppearanceWrapper;
import com.devexpress.dxgrid.interfaces.CellContainerCreator;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.providers.CellAppearanceProvider;
import com.devexpress.dxgrid.views.GridCellContainer;
import com.devexpress.editors.utils.WeakProperty;
import com.devexpress.editors.utils.WeakPropertyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: InplaceEditor.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001;B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u001cJ\u0010\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102JH\u00103\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*J\b\u00104\u001a\u000200H\u0003J\u0006\u00105\u001a\u00020\u001cJ\b\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u000200H\u0002JP\u00108\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*J\u0006\u00109\u001a\u000200J\u0006\u0010:\u001a\u000200R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001d@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/devexpress/dxgrid/utils/InplaceEditor;", "", "columnModel", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "(Lcom/devexpress/dxgrid/models/columns/GridColumnModel;)V", "appearanceProvider", "Lcom/devexpress/dxgrid/utils/providers/CellAppearanceProvider;", "cellContainerCreator", "Lcom/devexpress/dxgrid/interfaces/CellContainerCreator;", "getColumnModel", "()Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "context", "Landroid/content/Context;", "<set-?>", "Lcom/devexpress/dxgrid/providers/DataProvider;", "dataProvider", "getDataProvider", "()Lcom/devexpress/dxgrid/providers/DataProvider;", "detector", "Landroid/view/GestureDetector;", "editableView", "Landroid/view/View;", "gestureDetector", "getGestureDetector", "()Landroid/view/GestureDetector;", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "initialized", "", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "inplaceEditorContainer", "getInplaceEditorContainer", "()Lcom/devexpress/dxgrid/views/GridCellContainer;", "layoutChangeListener", "Lcom/devexpress/dxgrid/utils/InplaceEditor$LayoutChangeListener;", "requestUpdateRunnable", "Ljava/lang/Runnable;", "", "rowIndex", "getRowIndex", "()I", "tapX", "", "tapY", "apply", "", "applyChanges", "fill", "", "appearance", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "init", "initialize", "isContainerFree", "isTapInCell", "open", "openInplaceEditor", "postOpen", "requestUpdate", "LayoutChangeListener", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class InplaceEditor {
    private CellAppearanceProvider appearanceProvider;
    private CellContainerCreator cellContainerCreator;
    private final GridColumnModel columnModel;
    private Context context;
    private DataProvider dataProvider;
    private GestureDetector detector;
    private View editableView;
    private GridAction gridAction;
    private boolean initialized;
    private GridCellContainer inplaceEditorContainer;
    private final LayoutChangeListener layoutChangeListener;
    private Runnable requestUpdateRunnable;
    private int rowIndex;
    private float tapX;
    private float tapY;

    public InplaceEditor(GridColumnModel columnModel) {
        Intrinsics.checkNotNullParameter(columnModel, "columnModel");
        this.columnModel = columnModel;
        this.rowIndex = -1;
        this.layoutChangeListener = new LayoutChangeListener(this);
    }

    public final GridColumnModel getColumnModel() {
        return this.columnModel;
    }

    public final DataProvider getDataProvider() {
        DataProvider dataProvider = this.dataProvider;
        if (dataProvider != null) {
            return dataProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataProvider");
        return null;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    private final GestureDetector getGestureDetector() {
        if (this.detector == null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.utils.InplaceEditor$gestureDetector$1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (InplaceEditor.this.getColumnModel().getHandleGesturesInternally()) {
                        return true;
                    }
                    return super.onDown(e);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    InplaceEditor.this.postOpen();
                    if (InplaceEditor.this.getColumnModel().getHandleGesturesInternally()) {
                        return true;
                    }
                    return super.onSingleTapUp(e);
                }
            });
        }
        GestureDetector gestureDetector = this.detector;
        Intrinsics.checkNotNull(gestureDetector);
        return gestureDetector;
    }

    public final GridCellContainer getInplaceEditorContainer() {
        GridCellContainer gridCellContainer = this.inplaceEditorContainer;
        if (gridCellContainer != null) {
            return gridCellContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inplaceEditorContainer");
        return null;
    }

    public final void openInplaceEditor(Context context, Runnable requestUpdateRunnable, CellContainerCreator cellContainerCreator, CellAppearanceProvider appearanceProvider, DataProvider dataProvider, int rowIndex, GridAction gridAction, float tapX, float tapY) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cellContainerCreator, "cellContainerCreator");
        Intrinsics.checkNotNullParameter(appearanceProvider, "appearanceProvider");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        this.gridAction = gridAction;
        init(context, requestUpdateRunnable, cellContainerCreator, appearanceProvider, dataProvider, rowIndex, tapX, tapY);
        fill(null);
        getInplaceEditorContainer().addOnLayoutChangeListener(this.layoutChangeListener);
    }

    public final void init(Context context, Runnable requestUpdateRunnable, CellContainerCreator cellContainerCreator, CellAppearanceProvider appearanceProvider, DataProvider dataProvider, int rowIndex, float tapX, float tapY) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cellContainerCreator, "cellContainerCreator");
        Intrinsics.checkNotNullParameter(appearanceProvider, "appearanceProvider");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.context = context;
        this.requestUpdateRunnable = requestUpdateRunnable;
        this.cellContainerCreator = cellContainerCreator;
        this.tapX = tapX;
        this.tapY = tapY;
        this.rowIndex = rowIndex;
        this.columnModel.getEditViewProvider().setRequestUpdateRunnable(requestUpdateRunnable, rowIndex);
        if (this.initialized) {
            return;
        }
        this.appearanceProvider = appearanceProvider;
        this.dataProvider = dataProvider;
        initialize();
        this.initialized = true;
    }

    public final void fill(AppearanceBase appearance) {
        EditViewProvider editViewProvider = this.columnModel.getEditViewProvider();
        Context context = this.context;
        CellAppearanceProvider cellAppearanceProvider = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View editableView = editViewProvider.getEditableView(context, this.rowIndex);
        Intrinsics.checkNotNullExpressionValue(editableView, "getEditableView(...)");
        this.editableView = editableView;
        getInplaceEditorContainer().removeAllViews();
        GridCellContainer inplaceEditorContainer = getInplaceEditorContainer();
        View view = this.editableView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editableView");
            view = null;
        }
        inplaceEditorContainer.addView(view, new ViewGroup.LayoutParams(-1, -2));
        CellAppearanceProvider cellAppearanceProvider2 = this.appearanceProvider;
        if (cellAppearanceProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appearanceProvider");
        } else {
            cellAppearanceProvider = cellAppearanceProvider2;
        }
        final GridCellContainerAppearance cellAppearance = cellAppearanceProvider.getCellAppearance(this.columnModel);
        getInplaceEditorContainer().setAppearance(new CustomGridCellContainerAppearanceWrapper(cellAppearance) { // from class: com.devexpress.dxgrid.utils.InplaceEditor$fill$containerAppearance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cellAppearance, null);
                Intrinsics.checkNotNull(cellAppearance);
            }

            @Override // com.devexpress.dxgrid.appearance.wrappers.CustomGridCellContainerAppearanceWrapper, com.devexpress.dxgrid.appearance.GridCellContainerAppearance
            /* renamed from: getPadding */
            public Rect getNoPadding() {
                return InplaceEditor.this.getColumnModel().getEditViewProvider().isPaddingInEditor() ? new Rect(0, 0, 0, 0) : super.getNoPadding();
            }
        });
        if (appearance == null) {
            this.columnModel.getEditViewProvider().updateAppearance(this.rowIndex);
        } else {
            this.columnModel.getEditViewProvider().updateAppearance(appearance, this.rowIndex);
        }
        this.columnModel.getEditViewProvider().updateContent(this.rowIndex);
        requestUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void open() {
        this.columnModel.getEditViewProvider().open(isTapInCell(), this.rowIndex);
    }

    public final void postOpen() {
        getInplaceEditorContainer().post(new Runnable() { // from class: com.devexpress.dxgrid.utils.InplaceEditor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                InplaceEditor.postOpen$lambda$0(InplaceEditor.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postOpen$lambda$0(InplaceEditor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.open();
    }

    public final void requestUpdate() {
        Runnable runnable = this.requestUpdateRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final String applyChanges(boolean applyChanges) {
        if (this.initialized && applyChanges) {
            return apply();
        }
        return null;
    }

    public final boolean isContainerFree() {
        return !this.initialized || getInplaceEditorContainer().getParent() == null;
    }

    private final void initialize() {
        CellContainerCreator cellContainerCreator = this.cellContainerCreator;
        if (cellContainerCreator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cellContainerCreator");
            cellContainerCreator = null;
        }
        GridCellContainer cellContainer = cellContainerCreator.getCellContainer();
        Intrinsics.checkNotNullExpressionValue(cellContainer, "getCellContainer(...)");
        this.inplaceEditorContainer = cellContainer;
        getInplaceEditorContainer().setOnTouchListener(new View.OnTouchListener() { // from class: com.devexpress.dxgrid.utils.InplaceEditor$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initialize$lambda$1;
                initialize$lambda$1 = InplaceEditor.initialize$lambda$1(InplaceEditor.this, view, motionEvent);
                return initialize$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialize$lambda$1(InplaceEditor this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tapX = motionEvent.getX();
        this$0.tapY = motionEvent.getY();
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return this$0.getGestureDetector().onTouchEvent(motionEvent);
    }

    private final String apply() {
        View view = this.editableView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editableView");
            view = null;
        }
        view.clearFocus();
        EditViewProvider editViewProvider = this.columnModel.getEditViewProvider();
        View view3 = this.editableView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editableView");
        } else {
            view2 = view3;
        }
        return editViewProvider.submitEditValue(view2, this.rowIndex);
    }

    private final boolean isTapInCell() {
        Rect rect = new Rect();
        View cell = getInplaceEditorContainer().getCell();
        Intrinsics.checkNotNull(cell, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) cell).getChildAt(0);
        childAt.getHitRect(rect);
        int width = childAt.getWidth() / 2;
        rect.left -= width;
        rect.right += width;
        rect.top -= width;
        rect.bottom += width;
        rect.offset(getInplaceEditorContainer().getCell().getLeft(), getInplaceEditorContainer().getCell().getTop());
        return rect.contains((int) this.tapX, (int) this.tapY);
    }

    /* compiled from: InplaceEditor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001d\u0010\u0002\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/devexpress/dxgrid/utils/InplaceEditor$LayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "owner", "Lcom/devexpress/dxgrid/utils/InplaceEditor;", "(Lcom/devexpress/dxgrid/utils/InplaceEditor;)V", "getOwner", "()Lcom/devexpress/dxgrid/utils/InplaceEditor;", "owner$delegate", "Lcom/devexpress/editors/utils/WeakProperty;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LayoutChangeListener implements View.OnLayoutChangeListener {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LayoutChangeListener.class, "owner", "getOwner()Lcom/devexpress/dxgrid/utils/InplaceEditor;", 0))};

        /* renamed from: owner$delegate, reason: from kotlin metadata */
        private final WeakProperty owner;

        public LayoutChangeListener(InplaceEditor inplaceEditor) {
            this.owner = WeakPropertyKt.weak(inplaceEditor);
        }

        public final InplaceEditor getOwner() {
            return (InplaceEditor) this.owner.getValue(this, $$delegatedProperties[0]);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(v, "v");
            InplaceEditor owner = getOwner();
            if (owner != null) {
                owner.open();
            }
            v.removeOnLayoutChangeListener(this);
        }
    }
}
