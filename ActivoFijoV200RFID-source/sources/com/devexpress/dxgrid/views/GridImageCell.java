package com.devexpress.dxgrid.views;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridImageCell.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/devexpress/dxgrid/views/GridImageCell;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridImageCell extends AppCompatImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridImageCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getDrawable() == null || getMeasuredWidth() == 0 || getMeasuredHeight() == 0) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setScaleType(Math.max(((float) getDrawable().getIntrinsicWidth()) / ((float) getMeasuredWidth()), ((float) getDrawable().getIntrinsicHeight()) / ((float) getMeasuredHeight())) > 1.0f ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.CENTER_INSIDE);
        }
    }
}
