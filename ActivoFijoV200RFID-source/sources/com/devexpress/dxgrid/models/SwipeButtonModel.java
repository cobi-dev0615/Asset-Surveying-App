package com.devexpress.dxgrid.models;

import android.graphics.drawable.Drawable;
import com.devexpress.dxgrid.models.appearance.SwipeAppearance;
import com.devexpress.dxgrid.providers.SwipeButtonAction;
import com.devexpress.dxgrid.providers.SwipeButtonViewProvider;

/* loaded from: classes.dex */
public class SwipeButtonModel {
    private final SwipeButtonAction action;
    private final SwipeAppearance appearance;
    private Drawable image;
    private IImageChangedListener listener;
    private final Location location;
    private final String text;
    private final SwipeButtonViewProvider viewProvider;

    public enum Location {
        Start,
        End
    }

    public SwipeButtonModel(Location location, String str, SwipeButtonAction swipeButtonAction, SwipeAppearance swipeAppearance, SwipeButtonViewProvider swipeButtonViewProvider) {
        this.location = location;
        this.text = str;
        this.action = swipeButtonAction;
        this.appearance = swipeAppearance;
        this.viewProvider = swipeButtonViewProvider;
    }

    public Location getLocation() {
        return this.location;
    }

    public IImageChangedListener getImageListener() {
        return this.listener;
    }

    public void setImageListener(IImageChangedListener iImageChangedListener) {
        this.listener = iImageChangedListener;
    }

    public String getText() {
        return this.text;
    }

    public Drawable getImage() {
        return this.image;
    }

    public void setImage(Drawable drawable) {
        this.image = drawable;
        IImageChangedListener iImageChangedListener = this.listener;
        if (iImageChangedListener != null) {
            iImageChangedListener.onImageChanged();
        }
    }

    public SwipeButtonAction getAction() {
        return this.action;
    }

    public SwipeAppearance getAppearance() {
        return this.appearance;
    }

    public SwipeButtonViewProvider getViewProvider() {
        return this.viewProvider;
    }
}
