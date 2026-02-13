package com.gg.reader.api.utils;

import com.devexpress.editors.model.mask.Mask;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class JsonReader {
    public static final int CURRENT = 1;
    public static final int FIRST = 0;
    public static final int NEXT = 2;
    private static Map<Character, Character> escapes;
    private StringBuffer buf = new StringBuffer();
    private char c;
    private CharacterIterator it;
    private Object token;
    private static final Object OBJECT_END = new Object();
    private static final Object ARRAY_END = new Object();
    private static final Object COLON = new Object();
    private static final Object COMMA = new Object();

    static {
        HashMap hashMap = new HashMap();
        escapes = hashMap;
        Character valueOf = Character.valueOf(Typography.quote);
        hashMap.put(valueOf, valueOf);
        Map<Character, Character> map = escapes;
        Character valueOf2 = Character.valueOf(Mask.SHIELDING_SYMBOL);
        map.put(valueOf2, valueOf2);
        escapes.put('/', '/');
        escapes.put('b', '\b');
        escapes.put('f', '\f');
        escapes.put('n', '\n');
        escapes.put('r', '\r');
        escapes.put('t', '\t');
    }

    private char next() {
        char next = this.it.next();
        this.c = next;
        return next;
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(this.c)) {
            next();
        }
    }

    public Object read(CharacterIterator characterIterator, int i) {
        this.it = characterIterator;
        if (i == 0) {
            this.c = characterIterator.first();
        } else if (i == 1) {
            this.c = characterIterator.current();
        } else if (i == 2) {
            this.c = characterIterator.next();
        }
        return read();
    }

    public Object read(CharacterIterator characterIterator) {
        return read(characterIterator, 2);
    }

    public Object read(String str) {
        return read(new StringCharacterIterator(str), 0);
    }

    private Object read() {
        skipWhiteSpace();
        char c = this.c;
        next();
        if (c == '\"') {
            this.token = string();
        } else if (c == ',') {
            this.token = COMMA;
        } else if (c == ':') {
            this.token = COLON;
        } else if (c == '[') {
            this.token = array();
        } else if (c == ']') {
            this.token = ARRAY_END;
        } else if (c == 'f') {
            next();
            next();
            next();
            next();
            this.token = Boolean.FALSE;
        } else if (c == 'n') {
            next();
            next();
            next();
            this.token = null;
        } else if (c == 't') {
            next();
            next();
            next();
            this.token = Boolean.TRUE;
        } else if (c == '{') {
            this.token = object();
        } else if (c == '}') {
            this.token = OBJECT_END;
        } else {
            char previous = this.it.previous();
            this.c = previous;
            if (Character.isDigit(previous) || this.c == '-') {
                this.token = number();
            }
        }
        return this.token;
    }

    private Object object() {
        HashMap hashMap = new HashMap();
        Object read = read();
        while (true) {
            Object obj = this.token;
            Object obj2 = OBJECT_END;
            if (obj == obj2) {
                return hashMap;
            }
            read();
            if (this.token != obj2) {
                hashMap.put(read, read());
                if (read() == COMMA) {
                    read = read();
                }
            }
        }
    }

    private Object array() {
        ArrayList arrayList = new ArrayList();
        Object read = read();
        while (this.token != ARRAY_END) {
            arrayList.add(read);
            if (read() == COMMA) {
                read = read();
            }
        }
        return arrayList;
    }

    private Object number() {
        boolean z = false;
        this.buf.setLength(0);
        if (this.c == '-') {
            add();
        }
        int addDigits = addDigits();
        boolean z2 = true;
        if (this.c == '.') {
            add();
            addDigits += addDigits();
            z = true;
        }
        char c = this.c;
        if (c == 'e' || c == 'E') {
            add();
            char c2 = this.c;
            if (c2 == '+' || c2 == '-') {
                add();
            }
            addDigits();
        } else {
            z2 = z;
        }
        String stringBuffer = this.buf.toString();
        return z2 ? addDigits < 17 ? Double.valueOf(stringBuffer) : new BigDecimal(stringBuffer) : addDigits < 19 ? Long.valueOf(stringBuffer) : new BigInteger(stringBuffer);
    }

    private int addDigits() {
        int i = 0;
        while (Character.isDigit(this.c)) {
            add();
            i++;
        }
        return i;
    }

    private Object string() {
        this.buf.setLength(0);
        while (true) {
            char c = this.c;
            if (c == '\"') {
                next();
                return this.buf.toString();
            }
            if (c == '\\') {
                next();
                char c2 = this.c;
                if (c2 == 'u') {
                    add(unicode());
                } else {
                    Character ch = escapes.get(Character.valueOf(c2));
                    if (ch != null) {
                        add(ch.charValue());
                    }
                }
            } else {
                add();
            }
        }
    }

    private void add(char c) {
        this.buf.append(c);
        next();
    }

    private void add() {
        add(this.c);
    }

    private char unicode() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            char next = next();
            switch (next) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i = ((i << 4) + this.c) - 48;
                    break;
                default:
                    switch (next) {
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            i = ((i << 4) + this.c) - 75;
                            break;
                        default:
                            switch (next) {
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i = ((i << 4) + this.c) - 107;
                                    break;
                            }
                    }
            }
        }
        return (char) i;
    }

    public <T> T jsonToClass(String str, Class<T> cls) {
        try {
            Map map = (Map) read(str);
            if (map.size() <= 0) {
                return null;
            }
            T newInstance = cls.newInstance();
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                String name = declaredFields[i].getName();
                String replaceFirst = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
                if (map.get(name).getClass().getName().equals("java.lang.String")) {
                    newInstance.getClass().getMethod("set" + replaceFirst, String.class).invoke(newInstance, map.get(name));
                }
                if (map.get(name).getClass().getName().equals("java.lang.Integer")) {
                    newInstance.getClass().getMethod("set" + replaceFirst, Integer.class).invoke(newInstance, map.get(name));
                }
                if (map.get(name).getClass().getName().equals("java.lang.Long")) {
                    newInstance.getClass().getMethod("set" + replaceFirst, Integer.TYPE).invoke(newInstance, Integer.valueOf(((Long) map.get(name)).intValue()));
                }
            }
            return newInstance;
        } catch (Exception unused) {
            return null;
        }
    }
}
