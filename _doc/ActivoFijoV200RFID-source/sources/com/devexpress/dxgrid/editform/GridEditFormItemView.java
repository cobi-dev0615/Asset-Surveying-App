package com.devexpress.dxgrid.editform;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.interfaces.CellContainerCreator;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.models.columns.TemplateColumnModel;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.utils.GridCellCreatorService;
import com.devexpress.dxgrid.utils.providers.CellAppearanceProvider;
import com.devexpress.dxgrid.views.GridCellContainer;

/* loaded from: classes.dex */
public class GridEditFormItemView extends ViewGroup {
    private static final float CaptionWidthRatio = 0.4f;
    private static final float EditorWidthRatio = 0.6f;
    private AppearanceBase appearance;
    private TextView caption;
    private DataProvider dataProvider;
    private int editorMeasureHeight;
    private TextView errorText;
    private int errorTextMeasureHeight;
    private final GridColumnModel gridColumnModel;
    private GridCellContainer inplaceEditorContainer;
    private final Rect itemPadding;
    private final int rowIndex;
    private final TouchCallback touchCallback;

    public GridEditFormItemView(Context context, DataProvider dataProvider, GridEditFormViewInfo gridEditFormViewInfo, int i, TouchCallback touchCallback, AppearanceBase appearanceBase, Rect rect) {
        super(context);
        this.editorMeasureHeight = 0;
        this.errorTextMeasureHeight = 0;
        this.touchCallback = touchCallback;
        this.itemPadding = rect;
        GridColumnModel gridColumnModel = gridEditFormViewInfo.getGridColumnModel();
        this.gridColumnModel = gridColumnModel;
        gridColumnModel.setHorizontalContentAlignment(ContentAlignment.Start);
        gridColumnModel.setVerticalContentAlignment(ContentAlignment.Center);
        this.rowIndex = i;
        this.dataProvider = dataProvider;
        createSubviews(appearanceBase, gridEditFormViewInfo.isReadonly(), gridEditFormViewInfo.getFieldCaption());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.touchCallback.touch(this);
        return false;
    }

    private void createSubviews(final AppearanceBase appearanceBase, boolean z, String str) {
        TextView textView = new TextView(getContext());
        this.caption = textView;
        this.appearance = appearanceBase;
        textView.setText(str + ":");
        this.caption.setTypeface(appearanceBase.getTypeface());
        this.caption.setTextColor(appearanceBase.getTextColor());
        this.caption.setTextSize(2, appearanceBase.getTextSize());
        addView(this.caption);
        this.caption.setGravity(16);
        EditorAppearanceProvider editorAppearanceProvider = new EditorAppearanceProvider(appearanceBase);
        if (!z) {
            this.gridColumnModel.getInplaceEditor().init(getContext(), null, new CellContainerCreator() { // from class: com.devexpress.dxgrid.editform.GridEditFormItemView.1
                @Override // com.devexpress.dxgrid.interfaces.CellContainerCreator
                public GridCellContainer getCellContainer() {
                    return new GridCellContainer(GridEditFormItemView.this.getContext(), appearanceBase, null, 0);
                }
            }, editorAppearanceProvider, this.dataProvider, this.rowIndex, -1.0f, -1.0f);
            this.gridColumnModel.getInplaceEditor().fill(appearanceBase);
            GridCellContainer inplaceEditorContainer = this.gridColumnModel.getInplaceEditor().getInplaceEditorContainer();
            this.inplaceEditorContainer = inplaceEditorContainer;
            inplaceEditorContainer.setOnTouchListener(new GridCellContainerTouchListener(getContext(), this.gridColumnModel));
        } else {
            View createCell = GridCellCreatorService.createCell(getContext(), this.rowIndex, this.gridColumnModel);
            GridCellContainer gridCellContainer = new GridCellContainer(getContext(), appearanceBase, null, 0);
            gridCellContainer.addView(createCell);
            gridCellContainer.updateAppearance(this.gridColumnModel, editorAppearanceProvider, this.rowIndex);
            this.gridColumnModel.getViewProvider().updateContent(gridCellContainer.getCell(), this.dataProvider, this.gridColumnModel.getFieldName(), this.rowIndex);
            this.inplaceEditorContainer = gridCellContainer;
        }
        addView(this.inplaceEditorContainer);
    }

    public void applyChanges() {
        updateError(this.gridColumnModel.getInplaceEditor().applyChanges(true));
    }

    public void updateValidation() {
        updateError(this.dataProvider.getCellErrorText(this.gridColumnModel.getFieldName(), this.rowIndex));
    }

    private void updateError(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.errorText == null) {
                TextView createErrorText = createErrorText();
                this.errorText = createErrorText;
                addView(createErrorText);
            }
            this.errorText.setText(str);
        } else {
            TextView textView = this.errorText;
            if (textView == null) {
                return;
            }
            removeView(textView);
            this.errorText = null;
        }
        invalidate();
    }

    private TextView createErrorText() {
        TextView textView = new TextView(getContext());
        textView.setTypeface(this.appearance.getErrorTypeface());
        textView.setTextColor(this.appearance.getErrorTextColor());
        textView.setTextSize(2, this.appearance.getErrorTextSize());
        return textView;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.itemPadding.top + this.itemPadding.bottom;
        float size = View.MeasureSpec.getSize(i) - (this.itemPadding.left + this.itemPadding.right);
        this.caption.measure(View.MeasureSpec.makeMeasureSpec((int) (CaptionWidthRatio * size), BasicMeasure.EXACTLY), i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size * 0.6f), BasicMeasure.EXACTLY);
        if (this.gridColumnModel instanceof TemplateColumnModel) {
            this.inplaceEditorContainer.requestLayout();
            this.inplaceEditorContainer.measure(View.MeasureSpec.makeMeasureSpec(makeMeasureSpec, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            this.inplaceEditorContainer.measure(makeMeasureSpec, i2);
        }
        int measuredHeight = this.inplaceEditorContainer.getMeasuredHeight();
        this.editorMeasureHeight = measuredHeight;
        int i5 = measuredHeight + this.itemPadding.top;
        TextView textView = this.errorText;
        if (textView != null) {
            textView.measure(makeMeasureSpec, i2);
            int measuredHeight2 = this.errorText.getMeasuredHeight();
            this.errorTextMeasureHeight = measuredHeight2;
            i3 = measuredHeight2 + this.appearance.getErrorTopOffset() + this.appearance.getErrorMinBottomOffset();
            if (i3 < this.itemPadding.bottom) {
                i3 = this.itemPadding.bottom;
            }
        } else {
            i3 = this.itemPadding.bottom;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), Math.max(this.caption.getMeasuredHeight() + i4, i5 + i3));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = (i4 - i2) - (this.itemPadding.top + this.itemPadding.bottom);
        float f = (i3 - i) - (this.itemPadding.left + this.itemPadding.right);
        int i6 = this.itemPadding.left + ((int) (CaptionWidthRatio * f));
        this.caption.layout(this.itemPadding.left, this.itemPadding.top, i6, this.itemPadding.top + i5);
        int i7 = ((int) (f * 0.6f)) + i6;
        this.inplaceEditorContainer.layout(i6, this.itemPadding.top, i7, this.itemPadding.top + this.editorMeasureHeight);
        if (this.errorText != null) {
            int errorTopOffset = this.itemPadding.top + this.editorMeasureHeight + this.appearance.getErrorTopOffset();
            this.errorText.layout(i6, errorTopOffset, i7, this.errorTextMeasureHeight + errorTopOffset);
        }
    }

    public Object getValue() {
        return this.dataProvider.getValue(this.gridColumnModel.getFieldName(), this.rowIndex);
    }

    class GridCellContainerTouchListener implements View.OnTouchListener {
        private GestureDetector gestureDetector;

        public GridCellContainerTouchListener(Context context, final GridColumnModel gridColumnModel) {
            this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.editform.GridEditFormItemView.GridCellContainerTouchListener.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    gridColumnModel.getInplaceEditor().postOpen();
                    return true;
                }
            });
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.onTouchEvent(motionEvent)) {
                return true;
            }
            return this.gestureDetector.onTouchEvent(motionEvent);
        }
    }

    class EditorAppearanceProvider implements CellAppearanceProvider {
        private final AppearanceBase appearance;

        @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
        public boolean isUpdateShouldRequestCustomCellStyle() {
            return false;
        }

        EditorAppearanceProvider(AppearanceBase appearanceBase) {
            this.appearance = appearanceBase;
        }

        @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
        public GridCellContainerAppearance getCellAppearance(GridColumnModel gridColumnModel) {
            return this.appearance;
        }

        @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
        public GridTextAppearance getCellTextAppearance(GridColumnModel gridColumnModel) {
            return this.appearance;
        }
    }
}
