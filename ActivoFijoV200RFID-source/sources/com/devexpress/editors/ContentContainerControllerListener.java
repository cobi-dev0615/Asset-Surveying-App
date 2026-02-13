package com.devexpress.editors;

import kotlin.Metadata;

/* compiled from: ComboBoxEdit.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/ContentContainerControllerListener;", "", "close", "", "onLostFocus", "isOpened", "show", "", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ContentContainerControllerListener {
    boolean close(boolean onLostFocus);

    boolean isOpened();

    void show();

    void update();
}
