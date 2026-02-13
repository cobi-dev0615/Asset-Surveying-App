package com.devexpress.navigation.tabs.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.HeaderItemAppearance;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel;
import com.devexpress.navigation.tabs.models.Padding;
import com.devexpress.navigation.tabs.models.SelectedStyleProperty;
import com.devexpress.navigation.tabs.models.StyleProperty;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.utils.PositionHelper;
import com.devexpress.navigation.tabs.utils.SizeConverter;

/* loaded from: classes2.dex */
public class TabItemView extends LinearLayout {
    private AppCompatImageView imageView;
    private TabControlAppearance.OnAppearancePropertyChangeListener listenerAppearance;
    private IReadonlyHeaderItemModel mHeaderItem;
    private HeaderItemAppearance mHeaderItemAppearance;
    private HeaderItemModel.OnHeaderChangeListener mHeaderListener;
    private TabSize mHeightOnVerticalPanel;
    private boolean mSelected;
    private SizeConverter mSizeConverter;
    private TabSize mWidthOnHorizontalPanel;
    private TextViewContainer textView;

    public TabItemView(Context context, SizeConverter sizeConverter) {
        super(context);
        this.mHeaderItemAppearance = null;
        this.mSelected = false;
        this.listenerAppearance = new TabControlAppearance.OnAppearancePropertyChangeListener() { // from class: com.devexpress.navigation.tabs.views.TabItemView.1
            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onIndicatorPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemCornerRadiusPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelBackgroundPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelIndentPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelPaddingPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelSpacingPropertyChanged() {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemStylePropertyChanged(StyleProperty styleProperty) {
                TabItemView.this.styleByAppearance();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSpacingPropertyChanged() {
                TabItemView.this.setIconSpacing();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemPaddingPropertyChanged() {
                TabItemView.this.setPadding();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
                if (TabItemView.this.mSelected) {
                    TabItemView.this.styleByAppearance();
                }
            }
        };
        this.mSizeConverter = sizeConverter;
    }

    public void setModel(IReadonlyHeaderItemModel iReadonlyHeaderItemModel, HeaderItemAppearance headerItemAppearance) {
        tryInitListener();
        IReadonlyHeaderItemModel iReadonlyHeaderItemModel2 = this.mHeaderItem;
        if (iReadonlyHeaderItemModel2 != null) {
            iReadonlyHeaderItemModel2.clearListeners();
        }
        this.mHeaderItem = iReadonlyHeaderItemModel;
        iReadonlyHeaderItemModel.addListener(this.mHeaderListener);
        HeaderItemAppearance headerItemAppearance2 = this.mHeaderItemAppearance;
        if (headerItemAppearance2 != null) {
            headerItemAppearance2.removeOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        this.mHeaderItemAppearance = headerItemAppearance;
        if (headerItemAppearance != null) {
            headerItemAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        recreateView();
    }

    public IReadonlyHeaderItemModel getModel() {
        return this.mHeaderItem;
    }

    public void select() {
        this.mSelected = true;
        styleByAppearance();
    }

    public void deselect() {
        this.mSelected = false;
        styleByAppearance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable getColoredIcon(Drawable drawable) {
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(this.mSelected ? this.mHeaderItemAppearance.getSelectedIconColor() : this.mHeaderItemAppearance.getIconColor(), PorterDuff.Mode.SRC_ATOP));
        }
        return drawable;
    }

    private void tryInitListener() {
        if (this.mHeaderListener != null) {
            return;
        }
        this.mHeaderListener = new HeaderItemModel.OnHeaderChangeListener() { // from class: com.devexpress.navigation.tabs.views.TabItemView.2
            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onViewChanged(View view, View view2) {
                TabItemView.this.recreateView();
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onIconChanged(Drawable drawable, Drawable drawable2) {
                if (TabItemView.this.mHeaderItem.getView() == null) {
                    TabItemView.this.imageView.setImageDrawable(TabItemView.this.getColoredIcon(drawable2));
                }
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onTextChanged(CharSequence charSequence, CharSequence charSequence2) {
                if (TabItemView.this.mHeaderItem.getView() == null) {
                    boolean isTextVisible = HeaderItemModel.isTextVisible(TabItemView.this.mHeaderItem.getActualHeaderVisibleElements());
                    if (charSequence2 == null || charSequence2.length() <= 0) {
                        isTextVisible = false;
                    }
                    TabItemView.this.setTextVisibility(isTextVisible);
                    TabItemView.this.textView.setText(charSequence2);
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                TabItemView.this.mWidthOnHorizontalPanel = tabSize2;
                TabItemView.this.requestLayout();
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                TabItemView.this.mHeightOnVerticalPanel = tabSize2;
                TabItemView.this.requestLayout();
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderIconPositionChanged(Position position, Position position2) {
                if (TabItemView.this.mHeaderItem.getView() == null) {
                    TabItemView.this.setIconPosition(position, position2);
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2) {
                if (TabItemView.this.mHeaderItem.getView() == null) {
                    TabItemView.this.setIconVisibility(HeaderItemModel.isIconVisible(headerElements2));
                    TabItemView.this.setTextVisibility(HeaderItemModel.isTextVisible(headerElements2));
                    TabItemView.this.setIconSpacing();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreateView() {
        removeAllViews();
        if (this.mHeaderItem.getView() != null) {
            createCustomView();
        } else {
            createDefaultView(getContext());
        }
    }

    private void createDefaultView(Context context) {
        boolean z = false;
        setLayoutDirection(0);
        setGravity(17);
        this.imageView = new AppCompatImageView(context);
        TextViewContainer textViewContainer = new TextViewContainer(context);
        this.textView = textViewContainer;
        textViewContainer.setPadding(10, 5, 10, 5);
        addView(this.imageView);
        addView(this.textView);
        setIconVisibility(HeaderItemModel.isIconVisible(this.mHeaderItem.getActualHeaderVisibleElements()));
        CharSequence text = this.mHeaderItem.getText();
        boolean isTextVisible = HeaderItemModel.isTextVisible(this.mHeaderItem.getActualHeaderVisibleElements());
        if (text != null && text.length() > 0) {
            z = isTextVisible;
        }
        setTextVisibility(z);
        setIconPosition(Position.Default, this.mHeaderItem.getActualIconPosition());
        if (z) {
            this.textView.setText(text);
        }
        styleByAppearance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void styleByAppearance() {
        if (this.mHeaderItem.getView() != null) {
            return;
        }
        if (this.mSelected) {
            setBackground(this.mHeaderItemAppearance.getBackgroundWithRadius(getHeight() / 2));
            this.textView.setTextColor(this.mHeaderItemAppearance.getSelectedItemHeaderColor());
        } else {
            setBackgroundColor(0);
            this.textView.setTextColor(this.mHeaderItemAppearance.getItemHeaderColor());
        }
        this.textView.setTypeface(this.mHeaderItemAppearance.getItemHeaderFont());
        this.textView.setTextSize(this.mHeaderItemAppearance.getItemHeaderFontSize());
        this.imageView.setImageDrawable(getColoredIcon(this.mHeaderItem.getIcon()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIconSpacing() {
        if (this.imageView == null) {
            return;
        }
        int convertDpToPx = this.mSizeConverter.convertDpToPx(this.mHeaderItemAppearance.getItemHeaderIconSpacing());
        if (convertDpToPx <= 0 || !HeaderItemModel.isTextVisible(this.mHeaderItem.getActualHeaderVisibleElements())) {
            this.imageView.setPadding(0, 0, 0, 0);
            return;
        }
        int i = AnonymousClass3.$SwitchMap$com$devexpress$navigation$common$Position[this.mHeaderItem.getActualIconPosition().ordinal()];
        if (i == 1) {
            this.imageView.setPadding(0, 0, convertDpToPx, 0);
            return;
        }
        if (i == 2) {
            this.imageView.setPadding(0, 0, 0, convertDpToPx);
            return;
        }
        if (i == 3) {
            this.imageView.setPadding(convertDpToPx, 0, 0, 0);
        } else if (i == 4) {
            this.imageView.setPadding(0, convertDpToPx, 0, 0);
        } else {
            this.imageView.setPadding(0, 0, 0, 0);
        }
    }

    /* renamed from: com.devexpress.navigation.tabs.views.TabItemView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr;
            try {
                iArr[Position.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPadding() {
        Padding actualPadding = this.mHeaderItemAppearance.getActualPadding();
        if (actualPadding != null) {
            setPadding(this.mSizeConverter.convertDpToPx(actualPadding.getLeft()), this.mSizeConverter.convertDpToPx(actualPadding.getTop()), this.mSizeConverter.convertDpToPx(actualPadding.getRight()), this.mSizeConverter.convertDpToPx(actualPadding.getBottom()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIconVisibility(boolean z) {
        this.imageView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextVisibility(boolean z) {
        this.textView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIconPosition(Position position, Position position2) {
        boolean z = PositionHelper.needChangeViewsOrder(position, position2) && HeaderItemModel.isIconVisible(this.mHeaderItem.getActualHeaderVisibleElements()) && HeaderItemModel.isTextVisible(this.mHeaderItem.getActualHeaderVisibleElements());
        setOrientation(PositionHelper.getOrientationByDirection(position2));
        if (z) {
            refreshViews();
        }
        setIconSpacing();
        setPadding();
    }

    private void createCustomView() {
        setGravity(GravityCompat.START);
        addView(this.mHeaderItem.getView());
    }

    private void refreshViews() {
        removeAllViews();
        if (PositionHelper.isReverseDirection(this.mHeaderItem.getActualIconPosition())) {
            addTextView();
            addIconView();
        } else {
            addIconView();
            addTextView();
        }
    }

    private void addIconView() {
        if (HeaderItemModel.isIconVisible(this.mHeaderItem.getActualHeaderVisibleElements())) {
            addView(this.imageView);
        }
    }

    private void addTextView() {
        if (HeaderItemModel.isTextVisible(this.mHeaderItem.getActualHeaderVisibleElements())) {
            addView(this.textView);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        styleByAppearance();
        if (this.mHeaderItem.getView() != null) {
            this.mHeaderItem.getView().layout(0, 0, i3 - i, i4 - i2);
        } else {
            super.onLayout(z, i, i2, i3, i4);
            resizeTextViewContainer(i3 - i);
        }
    }

    private void resizeTextViewContainer(int i) {
        HeaderElements actualHeaderVisibleElements = this.mHeaderItem.getActualHeaderVisibleElements();
        if (actualHeaderVisibleElements == HeaderElements.Icon) {
            return;
        }
        IReadonlyHeaderItemModel iReadonlyHeaderItemModel = this.mHeaderItem;
        TabSize actualWidth = iReadonlyHeaderItemModel != null ? iReadonlyHeaderItemModel.getActualWidth() : null;
        if (actualWidth != null && actualWidth.getIsAuto() && actualWidth.getMaxSize() == 0.0f) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (getOrientation() == 0 && actualHeaderVisibleElements != HeaderElements.Text) {
            if (this.mHeaderItem.getActualIconPosition() == Position.Left) {
                paddingLeft += this.imageView.getWidth();
            } else {
                paddingRight += this.imageView.getWidth();
            }
        }
        this.textView.setBounds(i - (paddingRight + paddingLeft), paddingLeft);
    }

    public HeaderItemAppearance getHeaderItemAppearance() {
        return this.mHeaderItemAppearance;
    }

    public void setHeaderItemAppearance(HeaderItemAppearance headerItemAppearance) {
        HeaderItemAppearance headerItemAppearance2 = this.mHeaderItemAppearance;
        if (headerItemAppearance2 != null) {
            headerItemAppearance2.removeOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        this.mHeaderItemAppearance = headerItemAppearance;
        headerItemAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
    }

    public void initOwnAppearance(HeaderItemAppearance headerItemAppearance) {
        HeaderItemAppearance headerItemAppearance2 = this.mHeaderItemAppearance;
        if (headerItemAppearance2 != null) {
            headerItemAppearance2.removeOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        this.mHeaderItemAppearance = headerItemAppearance;
        if (headerItemAppearance != null) {
            headerItemAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
    }
}
