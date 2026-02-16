package com.devexpress.editors.model.mask;

import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.utils.SpannableUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Mask.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0002IJB1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0002J\u001a\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\b\b\u0002\u00104\u001a\u00020\u0013H\u0002J\u0018\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0006H\u0002J\b\u00108\u001a\u00020\u0013H\u0002J\u0016\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020%J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\nH\u0002J\u000e\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u000201J\u000e\u0010@\u001a\u00020*2\u0006\u00100\u001a\u00020\rJ\u0016\u0010A\u001a\u00020*2\u0006\u0010:\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nJ\u001e\u0010C\u001a\u00020*2\u0006\u0010:\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010;\u001a\u00020%J\u0018\u0010E\u001a\u00020F2\u0006\u00106\u001a\u00020\b2\u0006\u0010G\u001a\u00020\nH\u0002J\b\u0010H\u001a\u00020*H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/devexpress/editors/model/mask/Mask;", "", "rules", "", "Lcom/devexpress/editors/model/mask/MaskRule;", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "placeholderChar", "", "placeholderColor", "", "(Ljava/util/List;Lcom/devexpress/editors/DXCharacterCasing;CI)V", "cachedRawValue", "Ljava/lang/StringBuilder;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "isEmpty", "", "()Z", "<set-?>", "isReady", "length", "getLength", "()I", "nextPosition", "getNextPosition", "value", "getPlaceholderChar", "()C", "setPlaceholderChar", "(C)V", "getPlaceholderColor", "setPlaceholderColor", "(I)V", "rawValue", "", "getRawValue", "()Ljava/lang/CharSequence;", "spanBuilder", "addExtraAcceptedSymbolsForNumericListener", "", "acceptedChars", "", "checkReady", "clearCaches", "clearEditableForFormattedValue", "e", "Landroid/text/Editable;", "findFirstEmptyRuleIndex", "endIndex", "allowHardcoded", "getCharWithCasing", "char", "casing", "hasCaches", "insert", "start", "newChars", "isSkippableRuleSurroundedByEmptyRules", "index", "populateWithFormattedValue", "s", "populateWithRawValue", "remove", "count", "replace", "oldCount", "tryAcceptChar", "Lcom/devexpress/editors/model/mask/Mask$AcceptanceResult;", "ruleIndex", "updateCaches", "AcceptanceResult", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Mask {
    public static final char ANY_SYMBOL = 'C';

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final char DIGIT_SYMBOL = '0';
    private static final int EMPTY_INDEX = -1;
    public static final char LETTER_SYMBOL = 'L';
    public static final char SHIELDING_SYMBOL = '\\';
    private final StringBuilder cachedRawValue;
    private DXCharacterCasing characterCasing;
    private boolean isReady;
    private int nextPosition;
    private char placeholderChar;
    private int placeholderColor;
    private final List<MaskRule> rules;
    private final StringBuilder spanBuilder;

    /* compiled from: Mask.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXCharacterCasing.values().length];
            try {
                iArr[DXCharacterCasing.Upper.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXCharacterCasing.Lower.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final Mask parse(CharSequence charSequence, DXCharacterCasing dXCharacterCasing, char c, int i) {
        return INSTANCE.parse(charSequence, dXCharacterCasing, c, i);
    }

    /* compiled from: Mask.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/model/mask/Mask$Companion;", "", "()V", "ANY_SYMBOL", "", "DIGIT_SYMBOL", "EMPTY_INDEX", "", "LETTER_SYMBOL", "SHIELDING_SYMBOL", "parse", "Lcom/devexpress/editors/model/mask/Mask;", "mask", "", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "placeholderChar", "placeholderColor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Mask parse$default(Companion companion, CharSequence charSequence, DXCharacterCasing dXCharacterCasing, char c, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                dXCharacterCasing = DXCharacterCasing.Normal;
            }
            if ((i2 & 4) != 0) {
                c = '_';
            }
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return companion.parse(charSequence, dXCharacterCasing, c, i);
        }

        @JvmStatic
        public final Mask parse(CharSequence mask, DXCharacterCasing characterCasing, char placeholderChar, int placeholderColor) {
            MaskRule exactly;
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(characterCasing, "characterCasing");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < mask.length()) {
                char charAt = mask.charAt(i);
                if (charAt == '0') {
                    exactly = MaskRule.INSTANCE.digit();
                } else if (charAt == 'L') {
                    exactly = MaskRule.INSTANCE.letter();
                } else if (charAt == 'C') {
                    exactly = MaskRule.INSTANCE.any();
                } else if (charAt == '\\') {
                    i++;
                    if (i >= mask.length()) {
                        throw new IllegalArgumentException("Cannot parse the specified 'mask' string.");
                    }
                    exactly = MaskRule.INSTANCE.exactly(mask.charAt(i));
                } else {
                    exactly = MaskRule.INSTANCE.exactly(mask.charAt(i));
                }
                arrayList.add(exactly);
                i++;
            }
            return new Mask(arrayList, characterCasing, placeholderChar, placeholderColor);
        }
    }

    public Mask(List<MaskRule> rules, DXCharacterCasing characterCasing, char c, int i) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(characterCasing, "characterCasing");
        this.rules = rules;
        this.spanBuilder = new StringBuilder();
        this.cachedRawValue = new StringBuilder();
        this.characterCasing = characterCasing;
        this.placeholderChar = '_';
        setPlaceholderChar(c);
        setPlaceholderColor(i);
        insert(0, "");
    }

    public /* synthetic */ Mask(List list, DXCharacterCasing dXCharacterCasing, char c, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, dXCharacterCasing, (i2 & 4) != 0 ? '_' : c, (i2 & 8) != 0 ? 0 : i);
    }

    public final DXCharacterCasing getCharacterCasing() {
        return this.characterCasing;
    }

    public final void setCharacterCasing(DXCharacterCasing dXCharacterCasing) {
        Intrinsics.checkNotNullParameter(dXCharacterCasing, "<set-?>");
        this.characterCasing = dXCharacterCasing;
    }

    public final char getPlaceholderChar() {
        return this.placeholderChar;
    }

    public final void setPlaceholderChar(char c) {
        if (c == this.placeholderChar) {
            return;
        }
        this.placeholderChar = c;
        clearCaches();
    }

    public final int getPlaceholderColor() {
        return this.placeholderColor;
    }

    public final void setPlaceholderColor(int i) {
        if (i == this.placeholderColor) {
            return;
        }
        this.placeholderColor = i;
        clearCaches();
    }

    public final CharSequence getRawValue() {
        if (!hasCaches()) {
            updateCaches();
        }
        return this.cachedRawValue;
    }

    /* renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }

    public final boolean isEmpty() {
        for (MaskRule maskRule : this.rules) {
            if (!maskRule.getCanBeSkipped() && !maskRule.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int getNextPosition() {
        return this.nextPosition;
    }

    public final int getLength() {
        return this.rules.size();
    }

    public final void insert(int start, CharSequence newChars) {
        Intrinsics.checkNotNullParameter(newChars, "newChars");
        if (this.rules.isEmpty()) {
            return;
        }
        int i = 0;
        int findFirstEmptyRuleIndex = findFirstEmptyRuleIndex(start, newChars.length() > 1);
        if (findFirstEmptyRuleIndex == -1 || findFirstEmptyRuleIndex >= this.rules.size()) {
            return;
        }
        while (true) {
            if (i >= newChars.length()) {
                break;
            }
            AcceptanceResult tryAcceptChar = tryAcceptChar(newChars.charAt(i), findFirstEmptyRuleIndex);
            if (!tryAcceptChar.isAccepted()) {
                findFirstEmptyRuleIndex = tryAcceptChar.getIndex();
                break;
            } else {
                findFirstEmptyRuleIndex = tryAcceptChar.getIndex() + 1;
                i++;
            }
        }
        this.nextPosition = findFirstEmptyRuleIndex;
        clearCaches();
        checkReady();
    }

    public final void replace(int start, int oldCount, CharSequence newChars) {
        Intrinsics.checkNotNullParameter(newChars, "newChars");
        remove(start, oldCount);
        insert(start, newChars);
    }

    public final void remove(int start, int count) {
        if (count <= 0) {
            return;
        }
        int min = Math.min((count + start) - 1, this.rules.size());
        if (start <= min) {
            int i = start;
            while (true) {
                this.rules.get(i).clear();
                if (i == min) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.nextPosition = start;
        clearCaches();
        this.isReady = false;
    }

    public final void addExtraAcceptedSymbolsForNumericListener(List<Character> acceptedChars) {
        Intrinsics.checkNotNullParameter(acceptedChars, "acceptedChars");
        if (!acceptedChars.contains(Character.valueOf(this.placeholderChar))) {
            acceptedChars.add(Character.valueOf(this.placeholderChar));
        }
        for (MaskRule maskRule : this.rules) {
            Character ch = maskRule.get_value();
            if (maskRule.getCanBeSkipped() && ch != null && !Character.isDigit(ch.charValue()) && !acceptedChars.contains(ch)) {
                acceptedChars.add(ch);
            }
        }
    }

    static /* synthetic */ int findFirstEmptyRuleIndex$default(Mask mask, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return mask.findFirstEmptyRuleIndex(i, z);
    }

    private final int findFirstEmptyRuleIndex(int endIndex, boolean allowHardcoded) {
        int lastIndex = endIndex >= this.rules.size() ? CollectionsKt.getLastIndex(this.rules) : endIndex;
        MaskRule maskRule = this.rules.get(lastIndex);
        boolean z = maskRule.isEmpty() || maskRule.getCanBeSkipped();
        int i = lastIndex;
        while (i > 0 && (maskRule.isEmpty() || maskRule.getCanBeSkipped())) {
            i--;
            maskRule = this.rules.get(i);
            z = z || maskRule.isEmpty() || maskRule.getCanBeSkipped();
        }
        if (!z) {
            return endIndex;
        }
        if (!allowHardcoded) {
            while (i < this.rules.size() - 1 && maskRule.getCanBeSkipped()) {
                i++;
                maskRule = this.rules.get(i);
            }
        }
        return (maskRule.isEmpty() || maskRule.getCanBeSkipped() || i >= lastIndex) ? i : i + 1;
    }

    private final char getCharWithCasing(char r2, DXCharacterCasing casing) {
        int i = WhenMappings.$EnumSwitchMapping$0[casing.ordinal()];
        if (i != 1) {
            return i != 2 ? r2 : Character.toLowerCase(r2);
        }
        return Character.toUpperCase(r2);
    }

    private final AcceptanceResult tryAcceptChar(char r5, int ruleIndex) {
        if (ruleIndex >= this.rules.size()) {
            return new AcceptanceResult(false, ruleIndex);
        }
        MaskRule maskRule = this.rules.get(ruleIndex);
        boolean canBeSkipped = maskRule.getCanBeSkipped();
        if (!canBeSkipped) {
            r5 = getCharWithCasing(r5, this.characterCasing);
        }
        if (maskRule.accept(r5)) {
            return new AcceptanceResult(true, ruleIndex);
        }
        if (canBeSkipped) {
            return tryAcceptChar(r5, ruleIndex + 1);
        }
        return r5 == this.placeholderChar ? new AcceptanceResult(true, ruleIndex) : new AcceptanceResult(false, ruleIndex);
    }

    private final boolean hasCaches() {
        return this.cachedRawValue.length() > 0 || this.rules.isEmpty();
    }

    private final void clearCaches() {
        StringsKt.clear(this.cachedRawValue);
    }

    private final void updateCaches() {
        populateWithRawValue(this.cachedRawValue);
    }

    public final void populateWithFormattedValue(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        clearEditableForFormattedValue(s);
        if (this.rules.isEmpty()) {
            return;
        }
        StringsKt.clear(this.spanBuilder);
        boolean z = this.rules.get(0).isEmpty() || isSkippableRuleSurroundedByEmptyRules(0);
        Iterator<MaskRule> it = this.rules.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            Character ch = it.next().get_value();
            if (ch != null) {
                if (z) {
                    if (isSkippableRuleSurroundedByEmptyRules(i)) {
                        this.spanBuilder.append(ch.charValue());
                    } else {
                        String sb = this.spanBuilder.toString();
                        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                        SpannableUtilsKt.appendSpan(s, sb, new ForegroundColorSpan(this.placeholderColor), 33);
                        StringsKt.clear(this.spanBuilder);
                        this.spanBuilder.append(ch.charValue());
                        z = false;
                    }
                } else {
                    this.spanBuilder.append(ch.charValue());
                }
            } else if (z) {
                this.spanBuilder.append(this.placeholderChar);
            } else {
                s.append((CharSequence) this.spanBuilder.toString());
                StringsKt.clear(this.spanBuilder);
                this.spanBuilder.append(this.placeholderChar);
                z = true;
            }
            i = i2;
        }
        if (z) {
            String sb2 = this.spanBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            SpannableUtilsKt.appendSpan(s, sb2, new ForegroundColorSpan(this.placeholderColor), 33);
            return;
        }
        s.append((CharSequence) this.spanBuilder.toString());
    }

    public final void populateWithRawValue(StringBuilder e) {
        Intrinsics.checkNotNullParameter(e, "e");
        StringsKt.clear(e);
        for (MaskRule maskRule : this.rules) {
            Character ch = maskRule.get_value();
            if (!maskRule.getCanBeSkipped()) {
                if (ch != null) {
                    e.append(ch.charValue());
                } else if (e.length() > 0) {
                    return;
                }
            }
        }
    }

    private final void checkReady() {
        boolean z;
        Iterator<MaskRule> it = this.rules.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            MaskRule next = it.next();
            if (!next.getCanBeSkipped() && next.get_value() == null) {
                z = false;
                break;
            }
        }
        this.isReady = z;
    }

    private final void clearEditableForFormattedValue(Editable e) {
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) e.getSpans(0, e.length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNull(foregroundColorSpanArr);
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            e.removeSpan(foregroundColorSpan);
        }
        e.clear();
    }

    private final boolean isSkippableRuleSurroundedByEmptyRules(int index) {
        if (!this.rules.get(index).getCanBeSkipped()) {
            return false;
        }
        int i = index + 1;
        while (i < this.rules.size() && this.rules.get(i).getCanBeSkipped()) {
            i++;
        }
        int i2 = index - 1;
        while (i2 >= 0 && this.rules.get(i2).getCanBeSkipped()) {
            i2--;
        }
        if (i2 < 0 || this.rules.get(i2).isEmpty()) {
            return i >= this.rules.size() || this.rules.get(i).isEmpty();
        }
        return false;
    }

    /* compiled from: Mask.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/model/mask/Mask$AcceptanceResult;", "", "isAccepted", "", "index", "", "(ZI)V", "getIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AcceptanceResult {
        private final int index;
        private final boolean isAccepted;

        public static /* synthetic */ AcceptanceResult copy$default(AcceptanceResult acceptanceResult, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = acceptanceResult.isAccepted;
            }
            if ((i2 & 2) != 0) {
                i = acceptanceResult.index;
            }
            return acceptanceResult.copy(z, i);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsAccepted() {
            return this.isAccepted;
        }

        /* renamed from: component2, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final AcceptanceResult copy(boolean isAccepted, int index) {
            return new AcceptanceResult(isAccepted, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AcceptanceResult)) {
                return false;
            }
            AcceptanceResult acceptanceResult = (AcceptanceResult) other;
            return this.isAccepted == acceptanceResult.isAccepted && this.index == acceptanceResult.index;
        }

        public int hashCode() {
            return (UByte$$ExternalSyntheticBackport0.m(this.isAccepted) * 31) + this.index;
        }

        public String toString() {
            return "AcceptanceResult(isAccepted=" + this.isAccepted + ", index=" + this.index + ')';
        }

        public AcceptanceResult(boolean z, int i) {
            this.isAccepted = z;
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        public final boolean isAccepted() {
            return this.isAccepted;
        }
    }
}
