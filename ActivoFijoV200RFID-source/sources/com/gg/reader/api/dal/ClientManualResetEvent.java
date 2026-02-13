package com.gg.reader.api.dal;

import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.utils.ManualResetEvent;

/* loaded from: classes2.dex */
public class ClientManualResetEvent {
    public Message data;
    public ManualResetEvent evt;

    public ClientManualResetEvent(boolean z) {
        this.evt = new ManualResetEvent(z);
    }
}
