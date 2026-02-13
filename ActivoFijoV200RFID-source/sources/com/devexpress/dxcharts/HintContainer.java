package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.devexpress.dxcharts.CrosshairHintBehavior;
import com.devexpress.dxcharts.HintBase;
import com.devexpress.dxcharts.StaticCrosshairLabelPosition;
import com.devexpress.dxcharts.TooltipHintBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class HintContainer extends ChartElement {
    private CrosshairRenderer crosshairRenderer;
    private HintListener listener;
    private ChartBase mChart;
    private ContextProvider mContext;
    private Hint mDefaultHint;
    private HintBase mUserHint;
    private int mPopupCount = 0;
    private boolean mShowCrosshair = false;
    private List<PopupWindowRenderer> mPopupItems = new ArrayList();

    HintContainer(ContextProvider contextProvider, ChartBase chartBase) {
        this.mContext = contextProvider;
        this.mChart = chartBase;
        Hint hint = new Hint();
        this.mDefaultHint = hint;
        hint.setBehavior(new TooltipHintBehavior());
        this.crosshairRenderer = new CrosshairRenderer(this, contextProvider);
    }

    HintBase getActualHint() {
        HintBase hintBase = this.mUserHint;
        return hintBase != null ? hintBase : this.mDefaultHint;
    }

    boolean isHintEnabled() {
        return this.mUserHint != null;
    }

    float getCornerRadius() {
        return getActualHint().getCornerRadius(this.mContext);
    }

    boolean getHighlightPoint() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior != null ? crosshairHintBehavior.isHighlightPoint() : CrosshairHintBehavior.DEFAULT_HIGHLIGHT_POINT;
    }

    int getMaxSeriesCount() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior != null ? crosshairHintBehavior.getMaxSeriesCount() : CrosshairHintBehavior.DEFAULT_MAX_SERIES_COUNT;
    }

    boolean getArgumentLineHidden() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior == null ? !CrosshairHintBehavior.DEFAULT_ARGUMENT_LINE_VISIBLE : !crosshairHintBehavior.isArgumentLineVisible();
    }

    boolean getArgumentLabelHidden() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior == null ? !CrosshairHintBehavior.DEFAULT_ARGUMENT_LABEL_VISIBLE : !crosshairHintBehavior.isArgumentLabelVisible();
    }

    boolean getValueLineHidden() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior == null ? !CrosshairHintBehavior.DEFAULT_VALUE_LINE_VISIBLE : !crosshairHintBehavior.isValueLineVisible();
    }

    boolean getValueLabelHidden() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior == null ? !CrosshairHintBehavior.DEFAULT_VALUE_LABEL_VISIBLE : !crosshairHintBehavior.isValueLabelVisible();
    }

    boolean getGroupHeaderHidden() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return crosshairHintBehavior == null ? !CrosshairHintBehavior.DEFAULT_GROUP_HEADER_VISIBLE : !crosshairHintBehavior.isGroupHeaderVisible();
    }

    String getGroupHeaderTextPattern() {
        CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) getActualHint().getBehaviorInternal();
        return (crosshairHintBehavior == null || crosshairHintBehavior.getGroupHeaderTextPattern() == null) ? CrosshairHintBehavior.DEFAULT_GROUP_HEADER_TEXT_PATTERN : crosshairHintBehavior.getGroupHeaderTextPattern();
    }

    boolean getShowPointTooltip() {
        TooltipHintBehavior tooltipHintBehavior = (TooltipHintBehavior) getActualHint().getBehaviorInternal();
        return tooltipHintBehavior != null ? tooltipHintBehavior.isShowPointTooltip() : TooltipHintBehavior.DEFAULT_SHOW_POINT_TOOLTIP;
    }

    boolean getShowSeriesTooltip() {
        TooltipHintBehavior tooltipHintBehavior = (TooltipHintBehavior) getActualHint().getBehaviorInternal();
        return tooltipHintBehavior != null ? tooltipHintBehavior.isShowSeriesTooltip() : TooltipHintBehavior.DEFAULT_SHOW_SERIES_TOOLTIP;
    }

    int[] getTailSize() {
        Rect tailRect = getActualHint().getTailRect(this.mContext);
        return new int[]{tailRect.width(), tailRect.height()};
    }

    int[] getSize(TooltipItem[] tooltipItemArr, int i) {
        int[] iArr;
        synchronized (this) {
            Rect rect = new Rect();
            if (i == 0) {
                while (this.mPopupCount >= this.mPopupItems.size()) {
                    this.mPopupItems.add(new PopupWindowRenderer(this.mContext, this));
                }
                rect = this.mPopupItems.get(this.mPopupCount).measure(tooltipItemArr);
                this.mPopupCount++;
            } else if (i == 3) {
                rect = this.crosshairRenderer.measure(tooltipItemArr);
                this.mShowCrosshair = true;
            }
            iArr = new int[]{rect.width(), rect.height()};
        }
        return iArr;
    }

    HintBase getHint() {
        return this.mUserHint;
    }

    void setHint(HintBase hintBase) {
        HintBase hintBase2 = this.mUserHint;
        if (hintBase2 != hintBase) {
            if (hintBase2 != null) {
                hintBase2.removeListener(getSelfListener());
            }
            this.mUserHint = hintBase;
            if (hintBase != null) {
                hintBase.addListener(getSelfListener());
            }
            for (HintBase.Property property : HintBase.Property.values()) {
                notifyListeners(property);
            }
            for (CrosshairHintBehavior.Property property2 : CrosshairHintBehavior.Property.values()) {
                notifyListeners(property2);
            }
            for (TooltipHintBehavior.Property property3 : TooltipHintBehavior.Property.values()) {
                notifyListeners(property3);
            }
            for (StaticCrosshairLabelPosition.Property property4 : StaticCrosshairLabelPosition.Property.values()) {
                notifyListeners(property4);
            }
        }
    }

    ChartBase getOwnerChart() {
        return this.mChart;
    }

    void setHintListener(HintListener hintListener) {
        this.listener = hintListener;
    }

    boolean hintIsShown() {
        Iterator<PopupWindowRenderer> it = this.mPopupItems.iterator();
        while (it.hasNext()) {
            if (it.next().hintIsShown()) {
                return true;
            }
        }
        return this.mShowCrosshair;
    }

    void draw(Canvas canvas, ContextProvider contextProvider, OverlayInfo overlayInfo) {
        synchronized (this) {
            this.crosshairRenderer.draw(canvas, contextProvider, overlayInfo);
        }
    }

    void show(OverlayInfo[] overlayInfoArr, HintInfo hintInfo) {
        synchronized (this) {
            int i = 0;
            for (OverlayInfo overlayInfo : overlayInfoArr) {
                if (overlayInfo.getOverlayLabelType() == 0) {
                    this.mPopupItems.get(i).show(overlayInfo);
                    i++;
                }
            }
            while (i < this.mPopupItems.size()) {
                this.mPopupItems.get(i).hide();
                i++;
            }
            this.mPopupCount = 0;
        }
        HintListener hintListener = this.listener;
        if (hintListener == null || hintInfo == null) {
            return;
        }
        hintListener.onShow(hintInfo);
    }

    void hide(boolean z) {
        HintListener hintListener;
        if (hintIsShown()) {
            synchronized (this) {
                Iterator<PopupWindowRenderer> it = this.mPopupItems.iterator();
                while (it.hasNext()) {
                    it.next().hide();
                }
                this.mPopupCount = 0;
                this.mShowCrosshair = false;
            }
            if (!z || (hintListener = this.listener) == null) {
                return;
            }
            hintListener.onHide();
        }
    }

    void applyTheme(ContextProvider contextProvider) {
        this.mDefaultHint.applyCurrentTheme(contextProvider, new Object[0]);
        HintBase hintBase = this.mUserHint;
        if (hintBase != null) {
            hintBase.applyCurrentTheme(contextProvider, new Object[0]);
        }
    }
}
