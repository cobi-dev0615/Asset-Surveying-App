package com.devexpress.dxcharts;

/* compiled from: PieCenterTextLabel.java */
/* loaded from: classes.dex */
class PatternParser {
    private NativeObjectWrapper patternParser;
    private TextFormatter textFormatter;

    native long nativeCreatePatternParser(Object obj);

    native String nativeParsePieCenterLabelText(long j, String str, String str2, double d);

    public PatternParser() {
        TextFormatter textFormatter = new TextFormatter();
        this.textFormatter = textFormatter;
        this.patternParser = new NativeObjectWrapper(nativeCreatePatternParser(textFormatter));
    }

    String parsePieCenterLabelText(String str, String str2, double d) {
        return nativeParsePieCenterLabelText(this.patternParser.getObject(), str, str2, d);
    }
}
