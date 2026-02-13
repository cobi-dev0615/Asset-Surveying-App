package com.google.crypto.tink.shaded.protobuf;

import com.gg.reader.api.protocol.gx.EnumG;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1) {
        if (byte1 > -12) {
            return -1;
        }
        return byte1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 > -12 || byte2 > -65) {
            return -1;
        }
        return byte1 ^ (byte2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 > -12 || byte2 > -65 || byte3 > -65) {
            return -1;
        }
        return (byte1 ^ (byte2 << 8)) ^ (byte3 << 16);
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.isAvailable() && !Android.isOnAndroidDevice()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        processor = safeProcessor;
    }

    static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bytes, int index, int limit) {
        byte b = bytes[index - 1];
        int i = limit - index;
        if (i == 0) {
            return incompleteStateFor(b);
        }
        if (i == 1) {
            return incompleteStateFor(b, bytes[index]);
        }
        if (i == 2) {
            return incompleteStateFor(b, bytes[index], bytes[index + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(final ByteBuffer buffer, final int byte1, final int index, final int remaining) {
        if (remaining == 0) {
            return incompleteStateFor(byte1);
        }
        if (remaining == 1) {
            return incompleteStateFor(byte1, buffer.get(index));
        }
        if (remaining == 2) {
            return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
        }
        throw new AssertionError();
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
        }
    }

    static int encodedLength(String string) {
        int length = string.length();
        int i = 0;
        while (i < length && string.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = string.charAt(i);
                if (charAt >= 2048) {
                    i2 += encodedLengthGeneral(string, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + 4294967296L));
    }

    private static int encodedLengthGeneral(String string, int start) {
        int length = string.length();
        int i = 0;
        while (start < length) {
            char charAt = string.charAt(start);
            if (charAt < 2048) {
                i += (127 - charAt) >>> 31;
            } else {
                i += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(string, start) < 65536) {
                        throw new UnpairedSurrogateException(start, length);
                    }
                    start++;
                }
            }
            start++;
        }
        return i;
    }

    static int encode(String in, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in, out, offset, length);
    }

    static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    static void encodeUtf8(String in, ByteBuffer out) {
        processor.encodeUtf8(in, out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int i = limit - 7;
        int i2 = index;
        while (i2 < i && (buffer.getLong(i2) & (-9187201950435737472L)) == 0) {
            i2 += 8;
        }
        return i2 - index;
    }

    static abstract class Processor {
        abstract String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(String in, byte[] out, int offset, int length);

        abstract void encodeUtf8Direct(String in, ByteBuffer out);

        abstract int partialIsValidUtf8(int state, byte[] bytes, int index, int limit);

        abstract int partialIsValidUtf8Direct(final int state, final ByteBuffer buffer, int index, final int limit);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            return partialIsValidUtf8(0, bytes, index, limit) == 0;
        }

        final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8(0, buffer, index, limit) == 0;
        }

        final int partialIsValidUtf8(final int state, final ByteBuffer buffer, int index, final int limit) {
            if (buffer.hasArray()) {
                int arrayOffset = buffer.arrayOffset();
                return partialIsValidUtf8(state, buffer.array(), index + arrayOffset, arrayOffset + limit);
            }
            if (buffer.isDirect()) {
                return partialIsValidUtf8Direct(state, buffer, index, limit);
            }
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int partialIsValidUtf8Default(final int r7, final java.nio.ByteBuffer r8, int r9, final int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int partialIsValidUtf8(final ByteBuffer buffer, int index, final int limit) {
            int estimateConsecutiveAscii = index + Utf8.estimateConsecutiveAscii(buffer, index, limit);
            while (estimateConsecutiveAscii < limit) {
                int i = estimateConsecutiveAscii + 1;
                byte b = buffer.get(estimateConsecutiveAscii);
                if (b >= 0) {
                    estimateConsecutiveAscii = i;
                } else if (b < -32) {
                    if (i >= limit) {
                        return b;
                    }
                    if (b < -62 || buffer.get(i) > -65) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 2;
                } else {
                    if (b >= -16) {
                        if (i >= limit - 2) {
                            return Utf8.incompleteStateFor(buffer, b, i, limit - i);
                        }
                        int i2 = estimateConsecutiveAscii + 2;
                        byte b2 = buffer.get(i);
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i3 = estimateConsecutiveAscii + 3;
                            if (buffer.get(i2) <= -65) {
                                estimateConsecutiveAscii += 4;
                                if (buffer.get(i3) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i >= limit - 1) {
                        return Utf8.incompleteStateFor(buffer, b, i, limit - i);
                    }
                    int i4 = estimateConsecutiveAscii + 2;
                    byte b3 = buffer.get(i);
                    if (b3 > -65 || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || buffer.get(i4) > -65))) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray()) {
                return decodeUtf8(buffer.array(), buffer.arrayOffset() + index, size);
            }
            if (buffer.isDirect()) {
                return decodeUtf8Direct(buffer, index, size);
            }
            return decodeUtf8Default(buffer, index, size);
        }

        final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int i = index + size;
            char[] cArr = new char[size];
            int i2 = 0;
            while (index < i) {
                byte b = buffer.get(index);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                index++;
                DecodeUtil.handleOneByte(b, cArr, i2);
                i2++;
            }
            int i3 = i2;
            while (index < i) {
                int i4 = index + 1;
                byte b2 = buffer.get(index);
                if (DecodeUtil.isOneByte(b2)) {
                    int i5 = i3 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i3);
                    while (i4 < i) {
                        byte b3 = buffer.get(i4);
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i4++;
                        DecodeUtil.handleOneByte(b3, cArr, i5);
                        i5++;
                    }
                    i3 = i5;
                    index = i4;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i4 >= i) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    index += 2;
                    DecodeUtil.handleTwoBytes(b2, buffer.get(i4), cArr, i3);
                    i3++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i4 >= i - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i6 = index + 2;
                    index += 3;
                    DecodeUtil.handleThreeBytes(b2, buffer.get(i4), buffer.get(i6), cArr, i3);
                    i3++;
                } else {
                    if (i4 >= i - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b4 = buffer.get(i4);
                    int i7 = index + 3;
                    byte b5 = buffer.get(index + 2);
                    index += 4;
                    DecodeUtil.handleFourBytes(b2, b4, b5, buffer.get(i7), cArr, i3);
                    i3 += 2;
                }
            }
            return new String(cArr, 0, i3);
        }

        final void encodeUtf8(String in, ByteBuffer out) {
            if (out.hasArray()) {
                int arrayOffset = out.arrayOffset();
                Java8Compatibility.position(out, Utf8.encode(in, out.array(), out.position() + arrayOffset, out.remaining()) - arrayOffset);
            } else if (out.isDirect()) {
                encodeUtf8Direct(in, out);
            } else {
                encodeUtf8Default(in, out);
            }
        }

        final void encodeUtf8Default(String in, ByteBuffer out) {
            int length = in.length();
            int position = out.position();
            int i = 0;
            while (i < length) {
                try {
                    char charAt = in.charAt(i);
                    if (charAt >= 128) {
                        break;
                    }
                    out.put(position + i, (byte) charAt);
                    i++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(i) + " at index " + (out.position() + Math.max(i, (position - out.position()) + 1)));
                }
            }
            if (i == length) {
                Java8Compatibility.position(out, position + i);
                return;
            }
            position += i;
            while (i < length) {
                char charAt2 = in.charAt(i);
                if (charAt2 < 128) {
                    out.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i2 = position + 1;
                    try {
                        out.put(position, (byte) ((charAt2 >>> 6) | 192));
                        out.put(i2, (byte) ((charAt2 & '?') | 128));
                        position = i2;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i2;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(i) + " at index " + (out.position() + Math.max(i, (position - out.position()) + 1)));
                    }
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    int i3 = position + 1;
                    out.put(position, (byte) ((charAt2 >>> '\f') | EnumG.BaseMid_SetResidenceTime));
                    position += 2;
                    out.put(i3, (byte) (((charAt2 >>> 6) & 63) | 128));
                    out.put(position, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i4 = i + 1;
                    if (i4 != length) {
                        try {
                            char charAt3 = in.charAt(i4);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i5 = position + 1;
                                try {
                                    out.put(position, (byte) ((codePoint >>> 18) | EnumG.BaseMid_SafeCertification));
                                    int i6 = position + 2;
                                    try {
                                        out.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                        position += 3;
                                        out.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                        out.put(position, (byte) ((codePoint & 63) | 128));
                                        i = i4;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        i = i4;
                                        position = i6;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(i) + " at index " + (out.position() + Math.max(i, (position - out.position()) + 1)));
                                    }
                                } catch (IndexOutOfBoundsException unused4) {
                                    position = i5;
                                    i = i4;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(i) + " at index " + (out.position() + Math.max(i, (position - out.position()) + 1)));
                                }
                            } else {
                                i = i4;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i, length);
                }
                i++;
                position++;
            }
            Java8Compatibility.position(out, position);
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$000(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.crypto.tink.shaded.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((bytes.length - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int i = index + size;
            char[] cArr = new char[size];
            int i2 = 0;
            while (index < i) {
                byte b = bytes[index];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                index++;
                DecodeUtil.handleOneByte(b, cArr, i2);
                i2++;
            }
            int i3 = i2;
            while (index < i) {
                int i4 = index + 1;
                byte b2 = bytes[index];
                if (DecodeUtil.isOneByte(b2)) {
                    int i5 = i3 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i3);
                    while (i4 < i) {
                        byte b3 = bytes[i4];
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i4++;
                        DecodeUtil.handleOneByte(b3, cArr, i5);
                        i5++;
                    }
                    i3 = i5;
                    index = i4;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i4 >= i) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    index += 2;
                    DecodeUtil.handleTwoBytes(b2, bytes[i4], cArr, i3);
                    i3++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i4 >= i - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i6 = index + 2;
                    index += 3;
                    DecodeUtil.handleThreeBytes(b2, bytes[i4], bytes[i6], cArr, i3);
                    i3++;
                } else {
                    if (i4 >= i - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b4 = bytes[i4];
                    int i7 = index + 3;
                    byte b5 = bytes[index + 2];
                    index += 4;
                    DecodeUtil.handleFourBytes(b2, b4, b5, bytes[i7], cArr, i3);
                    i3 += 2;
                }
            }
            return new String(cArr, 0, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int encodeUtf8(java.lang.String r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 251
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.String, byte[], int, int):int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        void encodeUtf8Direct(String in, ByteBuffer out) {
            encodeUtf8Default(in, out);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
            while (index < limit && bytes[index] >= 0) {
                index++;
            }
            if (index >= limit) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
            while (index < limit) {
                int i = index + 1;
                byte b = bytes[index];
                if (b < 0) {
                    if (b < -32) {
                        if (i >= limit) {
                            return b;
                        }
                        if (b >= -62) {
                            index += 2;
                            if (bytes[i] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b >= -16) {
                        if (i >= limit - 2) {
                            return Utf8.incompleteStateFor(bytes, i, limit);
                        }
                        int i2 = index + 2;
                        byte b2 = bytes[i];
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i3 = index + 3;
                            if (bytes[i2] <= -65) {
                                index += 4;
                                if (bytes[i3] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i >= limit - 1) {
                        return Utf8.incompleteStateFor(bytes, i, limit);
                    }
                    int i4 = index + 2;
                    byte b3 = bytes[i];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        index += 3;
                        if (bytes[i4] > -65) {
                        }
                    }
                    return -1;
                }
                index = i;
            }
            return 0;
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r13, r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r13, r2) > (-65)) goto L59;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r12, byte[] r13, final int r14, final int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a8, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2) > (-65)) goto L59;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8Direct(final int r11, java.nio.ByteBuffer r12, final int r13, final int r14) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            String str = new String(bytes, index, size, Internal.UTF_8);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(Internal.UTF_8), Arrays.copyOfRange(bytes, index, size + index))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            long addressOffset = UnsafeUtil.addressOffset(buffer) + index;
            long j = size + addressOffset;
            char[] cArr = new char[size];
            int i = 0;
            while (addressOffset < j) {
                byte b = UnsafeUtil.getByte(addressOffset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                addressOffset++;
                DecodeUtil.handleOneByte(b, cArr, i);
                i++;
            }
            while (addressOffset < j) {
                long j2 = addressOffset + 1;
                byte b2 = UnsafeUtil.getByte(addressOffset);
                if (DecodeUtil.isOneByte(b2)) {
                    int i2 = i + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i);
                    while (j2 < j) {
                        byte b3 = UnsafeUtil.getByte(j2);
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        j2++;
                        DecodeUtil.handleOneByte(b3, cArr, i2);
                        i2++;
                    }
                    i = i2;
                    addressOffset = j2;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (j2 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    addressOffset += 2;
                    DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j2), cArr, i);
                    i++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (j2 >= j - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j3 = 2 + addressOffset;
                    addressOffset += 3;
                    DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(j3), cArr, i);
                    i++;
                } else {
                    if (j2 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b4 = UnsafeUtil.getByte(j2);
                    long j4 = addressOffset + 3;
                    byte b5 = UnsafeUtil.getByte(2 + addressOffset);
                    addressOffset += 4;
                    DecodeUtil.handleFourBytes(b2, b4, b5, UnsafeUtil.getByte(j4), cArr, i);
                    i += 2;
                }
            }
            return new String(cArr, 0, i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int encodeUtf8(final String in, final byte[] out, final int offset, final int length) {
            long j;
            String str;
            String str2;
            int i;
            long j2;
            long j3;
            char charAt;
            long j4 = offset;
            long j5 = length + j4;
            int length2 = in.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length2 > length || out.length - length < offset) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(length2 - 1) + " at index " + (offset + length));
            }
            int i2 = 0;
            while (true) {
                j = 1;
                if (i2 >= length2 || (charAt = in.charAt(i2)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(out, j4, (byte) charAt);
                i2++;
                j4 = 1 + j4;
            }
            if (i2 == length2) {
                return (int) j4;
            }
            while (i2 < length2) {
                char charAt2 = in.charAt(i2);
                if (charAt2 >= 128 || j4 >= j5) {
                    if (charAt2 >= 2048 || j4 > j5 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j4 > j5 - 3) {
                            if (j4 <= j5 - 4) {
                                int i3 = i2 + 1;
                                if (i3 != length2) {
                                    char charAt3 = in.charAt(i3);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        j2 = 1;
                                        UnsafeUtil.putByte(out, j4, (byte) ((codePoint >>> 18) | EnumG.BaseMid_SafeCertification));
                                        j3 = j5;
                                        UnsafeUtil.putByte(out, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j6 = j4 + 3;
                                        UnsafeUtil.putByte(out, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                        j4 += 4;
                                        UnsafeUtil.putByte(out, j6, (byte) ((codePoint & 63) | 128));
                                        i2 = i3;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                throw new UnpairedSurrogateException(i2 - 1, length2);
                            }
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i = i2 + 1) == length2 || !Character.isSurrogatePair(charAt2, in.charAt(i)))) {
                                throw new UnpairedSurrogateException(i2, length2);
                            }
                            throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j4);
                        }
                        UnsafeUtil.putByte(out, j4, (byte) ((charAt2 >>> '\f') | 480));
                        long j7 = j4 + 2;
                        UnsafeUtil.putByte(out, j4 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j4 += 3;
                        UnsafeUtil.putByte(out, j7, (byte) ((charAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j8 = j4 + j;
                        UnsafeUtil.putByte(out, j4, (byte) ((charAt2 >>> 6) | 960));
                        j4 += 2;
                        UnsafeUtil.putByte(out, j8, (byte) ((charAt2 & '?') | 128));
                    }
                    j3 = j5;
                    j2 = 1;
                } else {
                    UnsafeUtil.putByte(out, j4, (byte) charAt2);
                    j3 = j5;
                    str2 = str4;
                    j2 = j;
                    j4 += j;
                    str = str3;
                }
                i2++;
                str3 = str;
                str4 = str2;
                j = j2;
                j5 = j3;
            }
            return (int) j4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        void encodeUtf8Direct(String in, ByteBuffer out) {
            long j;
            char c;
            long j2;
            int i;
            int i2;
            char c2;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(out);
            long position = out.position() + addressOffset;
            long limit = out.limit() + addressOffset;
            int length = in.length();
            if (length > limit - position) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(length - 1) + " at index " + out.limit());
            }
            int i3 = 0;
            while (true) {
                j = 1;
                c = 128;
                if (i3 >= length || (charAt = in.charAt(i3)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(position, (byte) charAt);
                i3++;
                position = 1 + position;
            }
            if (i3 == length) {
                Java8Compatibility.position(out, (int) (position - addressOffset));
                return;
            }
            while (i3 < length) {
                char charAt2 = in.charAt(i3);
                if (charAt2 >= c || position >= limit) {
                    if (charAt2 >= 2048 || position > limit - 2) {
                        j2 = addressOffset;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || position > limit - 3) {
                            if (position <= limit - 4) {
                                i2 = i3 + 1;
                                if (i2 != length) {
                                    char charAt3 = in.charAt(i2);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        UnsafeUtil.putByte(position, (byte) ((codePoint >>> 18) | EnumG.BaseMid_SafeCertification));
                                        c2 = 128;
                                        UnsafeUtil.putByte(position + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j3 = position + 3;
                                        UnsafeUtil.putByte(position + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                        position += 4;
                                        UnsafeUtil.putByte(j3, (byte) ((codePoint & 63) | 128));
                                    } else {
                                        i3 = i2;
                                    }
                                }
                                throw new UnpairedSurrogateException(i3 - 1, length);
                            }
                            if (55296 > charAt2 || charAt2 > 57343 || ((i = i3 + 1) != length && Character.isSurrogatePair(charAt2, in.charAt(i)))) {
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            }
                            throw new UnpairedSurrogateException(i3, length);
                        }
                        long j4 = position + j;
                        UnsafeUtil.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                        long j5 = position + 2;
                        UnsafeUtil.putByte(j4, (byte) (((charAt2 >>> 6) & 63) | 128));
                        position += 3;
                        UnsafeUtil.putByte(j5, (byte) ((charAt2 & '?') | 128));
                    } else {
                        j2 = addressOffset;
                        long j6 = position + j;
                        UnsafeUtil.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                        position += 2;
                        UnsafeUtil.putByte(j6, (byte) ((charAt2 & '?') | 128));
                    }
                    i2 = i3;
                    c2 = 128;
                } else {
                    UnsafeUtil.putByte(position, (byte) charAt2);
                    j2 = addressOffset;
                    i2 = i3;
                    c2 = c;
                    position += j;
                }
                c = c2;
                addressOffset = j2;
                j = 1;
                i3 = i2 + 1;
            }
            Java8Compatibility.position(out, (int) (position - addressOffset));
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, final int maxChars) {
            int i = 0;
            if (maxChars < 16) {
                return 0;
            }
            int i2 = 8 - (((int) offset) & 7);
            while (i < i2) {
                long j = 1 + offset;
                if (UnsafeUtil.getByte(bytes, offset) < 0) {
                    return i;
                }
                i++;
                offset = j;
            }
            while (true) {
                int i3 = i + 8;
                if (i3 > maxChars || (UnsafeUtil.getLong((Object) bytes, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + offset) & (-9187201950435737472L)) != 0) {
                    break;
                }
                offset += 8;
                i = i3;
            }
            while (i < maxChars) {
                long j2 = offset + 1;
                if (UnsafeUtil.getByte(bytes, offset) < 0) {
                    return i;
                }
                i++;
                offset = j2;
            }
            return maxChars;
        }

        private static int unsafeEstimateConsecutiveAscii(long address, final int maxChars) {
            if (maxChars < 16) {
                return 0;
            }
            int i = (int) ((-address) & 7);
            int i2 = i;
            while (i2 > 0) {
                long j = 1 + address;
                if (UnsafeUtil.getByte(address) < 0) {
                    return i - i2;
                }
                i2--;
                address = j;
            }
            int i3 = maxChars - i;
            while (i3 >= 8 && (UnsafeUtil.getLong(address) & (-9187201950435737472L)) == 0) {
                address += 8;
                i3 -= 8;
            }
            return maxChars - i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(final byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            if (remaining == 0) {
                return Utf8.incompleteStateFor(byte1);
            }
            if (remaining == 1) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset));
            }
            if (remaining == 2) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, offset + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeIncompleteStateFor(long address, final int byte1, int remaining) {
            if (remaining == 0) {
                return Utf8.incompleteStateFor(byte1);
            }
            if (remaining == 1) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address));
            }
            if (remaining == 2) {
                return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(address + 1));
            }
            throw new AssertionError();
        }
    }

    private static class DecodeUtil {
        private static char highSurrogate(int codePoint) {
            return (char) ((codePoint >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int codePoint) {
            return (char) ((codePoint & 1023) + 56320);
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }

        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < -62 || isNotTrailingByte(byte2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 31) << 6) | trailingByteValue(byte2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || ((byte1 == -32 && byte2 < -96) || ((byte1 == -19 && byte2 >= -96) || isNotTrailingByte(byte3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 15) << 12) | (trailingByteValue(byte2) << 6) | trailingByteValue(byte3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || (((byte1 << 28) + (byte2 + 112)) >> 30) != 0 || isNotTrailingByte(byte3) || isNotTrailingByte(byte4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12) | (trailingByteValue(byte3) << 6) | trailingByteValue(byte4);
            resultArr[resultPos] = highSurrogate(trailingByteValue);
            resultArr[resultPos + 1] = lowSurrogate(trailingByteValue);
        }
    }

    private Utf8() {
    }
}
