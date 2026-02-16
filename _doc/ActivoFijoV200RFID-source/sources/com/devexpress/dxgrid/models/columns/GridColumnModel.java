package com.devexpress.dxgrid.models.columns;

import androidx.core.view.GravityCompat;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridHeaderTextAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.dxgrid.models.appearance.CellAppearance;
import com.devexpress.dxgrid.models.appearance.CellAppearanceBase;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.ViewProvider;
import com.devexpress.dxgrid.utils.InplaceEditor;

/* loaded from: classes.dex */
public abstract class GridColumnModel {
    private boolean allowAutoFilter;
    private final String caption;
    private CellAppearance cellAppearance;
    private int columnIndex;
    private int columnSpan;
    private CustomAppearanceProvider customAppearanceProvider;
    private EditViewProvider editViewProvider;
    private String fieldName;
    private FixedStyle fixedStyle;
    private int gravity;
    private GridLength gridColumnWidth;
    private final GridHeaderTextAppearance gridHeaderTextAppearance;
    private CellAppearanceBase headerAppearance;
    private LineBreakMode headerCaptionLineBreakMode;
    private ContentAlignment horizontalContentAlignment;
    private ContentAlignment horizontalHeaderAlignment;
    private InplaceEditor inplaceEditor;
    private int rowIndex;
    private int rowSpan;
    private Boolean showFilterIcon;
    private ColumnSortOrder sortOrder;
    private ContentAlignment verticalContentAlignment;
    private ViewProvider viewProvider;

    protected abstract EditViewProvider createEditViewProvider();

    protected abstract ViewProvider createViewProvider();

    public boolean getHandleGesturesInternally() {
        return false;
    }

    protected GridColumnModel(String str, String str2) {
        this(str, str2, new GridLength());
    }

    protected GridColumnModel(String str, String str2, GridLength gridLength) {
        this(str, str2, gridLength, ColumnSortOrder.None);
    }

    protected GridColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder) {
        this(str, str2, gridLength, columnSortOrder, FixedStyle.None);
    }

    protected GridColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle) {
        this.gridHeaderTextAppearance = new GridHeaderTextAppearance();
        this.rowIndex = 0;
        this.columnIndex = 0;
        this.rowSpan = 1;
        this.columnSpan = 1;
        this.horizontalHeaderAlignment = ContentAlignment.Center;
        this.horizontalContentAlignment = ContentAlignment.Start;
        this.verticalContentAlignment = ContentAlignment.Start;
        this.headerCaptionLineBreakMode = LineBreakMode.WordWrap;
        this.cellAppearance = new CellAppearance();
        this.headerAppearance = new CellAppearanceBase();
        this.allowAutoFilter = true;
        this.showFilterIcon = null;
        this.gravity = 0;
        this.fieldName = str;
        this.caption = str2;
        this.gridColumnWidth = gridLength;
        this.sortOrder = columnSortOrder;
        this.fixedStyle = fixedStyle;
        this.inplaceEditor = createInplaceEditor();
    }

    public FixedStyle getFixedStyle() {
        return this.fixedStyle;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getCaption() {
        return this.caption;
    }

    public GridLength getGridColumnWidth() {
        return this.gridColumnWidth;
    }

    public ColumnSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final ViewProvider getViewProvider() {
        if (this.viewProvider == null) {
            this.viewProvider = createViewProvider();
        }
        return this.viewProvider;
    }

    public final EditViewProvider getEditViewProvider() {
        if (this.editViewProvider == null) {
            this.editViewProvider = createEditViewProvider();
        }
        return this.editViewProvider;
    }

    public void setEditViewProvider(EditViewProvider editViewProvider) {
        this.editViewProvider = editViewProvider;
    }

    private InplaceEditor createInplaceEditor() {
        return new InplaceEditor(this);
    }

    public InplaceEditor getInplaceEditor() {
        return this.inplaceEditor;
    }

    public ContentAlignment getHorizontalHeaderAlignment() {
        return this.horizontalHeaderAlignment;
    }

    public ContentAlignment getHorizontalContentAlignment() {
        return this.horizontalContentAlignment;
    }

    public final ContentAlignment getBaseHorizontalContentAlignment() {
        return this.horizontalContentAlignment;
    }

    public void setHorizontalHeaderAlignment(ContentAlignment contentAlignment) {
        this.horizontalHeaderAlignment = contentAlignment;
        updateGravity(contentAlignment);
    }

    public void setHorizontalContentAlignment(ContentAlignment contentAlignment) {
        this.horizontalContentAlignment = contentAlignment;
        updateGravity(contentAlignment);
    }

    public ContentAlignment getVerticalContentAlignment() {
        return this.verticalContentAlignment;
    }

    public void setVerticalContentAlignment(ContentAlignment contentAlignment) {
        this.verticalContentAlignment = contentAlignment;
    }

    public void accept(IColumnVisitor iColumnVisitor) {
        iColumnVisitor.visit(this);
    }

    public LineBreakMode getHeaderCaptionLineBreakMode() {
        return this.headerCaptionLineBreakMode;
    }

    public void setHeaderCaptionLineBreakMode(LineBreakMode lineBreakMode) {
        this.headerCaptionLineBreakMode = lineBreakMode;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int i) {
        this.rowIndex = i;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public void setColumnIndex(int i) {
        this.columnIndex = i;
    }

    public int getRowSpan() {
        return this.rowSpan;
    }

    public void setRowSpan(int i) {
        this.rowSpan = i;
    }

    public int getColumnSpan() {
        return this.columnSpan;
    }

    public void setColumnSpan(int i) {
        this.columnSpan = i;
    }

    public CellAppearance getCellAppearance() {
        return this.cellAppearance;
    }

    public void setCellAppearance(CellAppearance cellAppearance) {
        this.cellAppearance = cellAppearance;
    }

    public GridCellContainerAppearance getHeaderAppearance() {
        return this.headerAppearance;
    }

    public void setHeaderAppearance(CellAppearanceBase cellAppearanceBase) {
        this.headerAppearance = cellAppearanceBase;
    }

    /* renamed from: com.devexpress.dxgrid.models.columns.GridColumnModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment;

        static {
            int[] iArr = new int[ContentAlignment.values().length];
            $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment = iArr;
            try {
                iArr[ContentAlignment.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.Center.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.End.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.Stretch.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void updateGravity(ContentAlignment contentAlignment) {
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[contentAlignment.ordinal()];
        if (i == 1) {
            this.gravity = GravityCompat.START;
            return;
        }
        if (i == 2) {
            this.gravity = 1;
        } else if (i == 3) {
            this.gravity = GravityCompat.END;
        } else {
            if (i != 4) {
                return;
            }
            this.gravity = 7;
        }
    }

    public int getGravity() {
        return this.gravity;
    }

    public CustomAppearanceProvider getCustomAppearanceProvider() {
        return this.customAppearanceProvider;
    }

    public void setCustomAppearanceProvider(CustomAppearanceProvider customAppearanceProvider) {
        this.customAppearanceProvider = customAppearanceProvider;
    }

    public boolean isAllowAutoFilter() {
        return this.allowAutoFilter;
    }

    public void setAllowAutoFilter(boolean z) {
        this.allowAutoFilter = z;
    }

    public Boolean isShowFilterIcon() {
        return this.showFilterIcon;
    }

    public void setShowFilterIcon(Boolean bool) {
        this.showFilterIcon = bool;
    }

    public GridTextAppearance getGridHeaderTextAppearance() {
        this.gridHeaderTextAppearance.initialize(this.headerAppearance, this);
        return this.gridHeaderTextAppearance;
    }
}
