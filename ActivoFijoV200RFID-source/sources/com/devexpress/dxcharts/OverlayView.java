package com.devexpress.dxcharts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class OverlayView extends View {
    private BitmapDrawable backgroundBitmap;
    private ContextProvider context;
    private ArrayList<OverlayDrawableInterface> drawable;

    public OverlayView(ContextProvider contextProvider) {
        super(contextProvider.getContext());
        this.drawable = new ArrayList<>();
        this.context = contextProvider;
    }

    public void addDrawable(OverlayDrawableInterface overlayDrawableInterface) {
        this.drawable.add(overlayDrawableInterface);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<OverlayDrawableInterface> it = this.drawable.iterator();
        while (it.hasNext()) {
            OverlayDrawableInterface next = it.next();
            if (next.canDraw()) {
                next.draw(canvas, this.context);
            }
        }
    }

    public void setBackgroundBitmap(Bitmap bitmap) {
        this.backgroundBitmap = bitmap != null ? new BitmapDrawable(getContext().getResources(), bitmap) : null;
        setBackground(this.backgroundBitmap);
    }
}
