package org.apache.cordova;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AllowList {
    public static final String TAG = "CordovaAllowList";
    private ArrayList<URLPattern> allowList = new ArrayList<>();

    private static class URLPattern {
        public Pattern host;
        public Pattern path;
        public Integer port;
        public Pattern scheme;

        private String regexFromPattern(String pattern, boolean allowWildcards) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                char charAt = pattern.charAt(i);
                if (charAt == '*' && allowWildcards) {
                    sb.append(".");
                } else if ("\\.[]{}()^$?+|".indexOf(charAt) > -1) {
                    sb.append('\\');
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0073 A[Catch: NumberFormatException -> 0x008b, TryCatch #0 {NumberFormatException -> 0x008b, blocks: (B:27:0x000a, B:30:0x0011, B:4:0x001e, B:6:0x0024, B:8:0x005b, B:11:0x0062, B:13:0x0073, B:16:0x007c, B:19:0x0088, B:21:0x006f, B:22:0x0027, B:24:0x002f, B:25:0x004f, B:3:0x001c), top: B:26:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0027 A[Catch: NumberFormatException -> 0x008b, TryCatch #0 {NumberFormatException -> 0x008b, blocks: (B:27:0x000a, B:30:0x0011, B:4:0x001e, B:6:0x0024, B:8:0x005b, B:11:0x0062, B:13:0x0073, B:16:0x007c, B:19:0x0088, B:21:0x006f, B:22:0x0027, B:24:0x002f, B:25:0x004f, B:3:0x001c), top: B:26:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0024 A[Catch: NumberFormatException -> 0x008b, TryCatch #0 {NumberFormatException -> 0x008b, blocks: (B:27:0x000a, B:30:0x0011, B:4:0x001e, B:6:0x0024, B:8:0x005b, B:11:0x0062, B:13:0x0073, B:16:0x007c, B:19:0x0088, B:21:0x006f, B:22:0x0027, B:24:0x002f, B:25:0x004f, B:3:0x001c), top: B:26:0x000a }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public URLPattern(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) throws java.net.MalformedURLException {
            /*
                r5 = this;
                r5.<init>()
                r0 = 0
                java.lang.String r1 = "*"
                r2 = 2
                r3 = 0
                if (r6 == 0) goto L1c
                boolean r4 = r1.equals(r6)     // Catch: java.lang.NumberFormatException -> L8b
                if (r4 == 0) goto L11
                goto L1c
            L11:
                java.lang.String r6 = r5.regexFromPattern(r6, r0)     // Catch: java.lang.NumberFormatException -> L8b
                java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6, r2)     // Catch: java.lang.NumberFormatException -> L8b
                r5.scheme = r6     // Catch: java.lang.NumberFormatException -> L8b
                goto L1e
            L1c:
                r5.scheme = r3     // Catch: java.lang.NumberFormatException -> L8b
            L1e:
                boolean r6 = r1.equals(r7)     // Catch: java.lang.NumberFormatException -> L8b
                if (r6 == 0) goto L27
                r5.host = r3     // Catch: java.lang.NumberFormatException -> L8b
                goto L59
            L27:
                java.lang.String r6 = "*."
                boolean r6 = r7.startsWith(r6)     // Catch: java.lang.NumberFormatException -> L8b
                if (r6 == 0) goto L4f
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L8b
                r6.<init>()     // Catch: java.lang.NumberFormatException -> L8b
                java.lang.String r4 = "([a-z0-9.-]*\\.)?"
                r6.append(r4)     // Catch: java.lang.NumberFormatException -> L8b
                java.lang.String r7 = r7.substring(r2)     // Catch: java.lang.NumberFormatException -> L8b
                java.lang.String r7 = r5.regexFromPattern(r7, r0)     // Catch: java.lang.NumberFormatException -> L8b
                r6.append(r7)     // Catch: java.lang.NumberFormatException -> L8b
                java.lang.String r6 = r6.toString()     // Catch: java.lang.NumberFormatException -> L8b
                java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6, r2)     // Catch: java.lang.NumberFormatException -> L8b
                r5.host = r6     // Catch: java.lang.NumberFormatException -> L8b
                goto L59
            L4f:
                java.lang.String r6 = r5.regexFromPattern(r7, r0)     // Catch: java.lang.NumberFormatException -> L8b
                java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6, r2)     // Catch: java.lang.NumberFormatException -> L8b
                r5.host = r6     // Catch: java.lang.NumberFormatException -> L8b
            L59:
                if (r8 == 0) goto L6f
                boolean r6 = r1.equals(r8)     // Catch: java.lang.NumberFormatException -> L8b
                if (r6 == 0) goto L62
                goto L6f
            L62:
                r6 = 10
                int r6 = java.lang.Integer.parseInt(r8, r6)     // Catch: java.lang.NumberFormatException -> L8b
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.NumberFormatException -> L8b
                r5.port = r6     // Catch: java.lang.NumberFormatException -> L8b
                goto L71
            L6f:
                r5.port = r3     // Catch: java.lang.NumberFormatException -> L8b
            L71:
                if (r9 == 0) goto L88
                java.lang.String r6 = "/*"
                boolean r6 = r6.equals(r9)     // Catch: java.lang.NumberFormatException -> L8b
                if (r6 == 0) goto L7c
                goto L88
            L7c:
                r6 = 1
                java.lang.String r6 = r5.regexFromPattern(r9, r6)     // Catch: java.lang.NumberFormatException -> L8b
                java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch: java.lang.NumberFormatException -> L8b
                r5.path = r6     // Catch: java.lang.NumberFormatException -> L8b
                goto L8a
            L88:
                r5.path = r3     // Catch: java.lang.NumberFormatException -> L8b
            L8a:
                return
            L8b:
                java.net.MalformedURLException r6 = new java.net.MalformedURLException
                java.lang.String r7 = "Port must be a number"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.AllowList.URLPattern.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
        }

        public boolean matches(Uri uri) {
            try {
                Pattern pattern = this.scheme;
                if (pattern != null && !pattern.matcher(uri.getScheme()).matches()) {
                    return false;
                }
                Pattern pattern2 = this.host;
                if (pattern2 != null && !pattern2.matcher(uri.getHost()).matches()) {
                    return false;
                }
                Integer num = this.port;
                if (num != null && !num.equals(Integer.valueOf(uri.getPort()))) {
                    return false;
                }
                Pattern pattern3 = this.path;
                if (pattern3 != null) {
                    if (!pattern3.matcher(uri.getPath()).matches()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                LOG.d(AllowList.TAG, e.toString());
                return false;
            }
        }
    }

    public void addAllowListEntry(String origin, boolean subdomains) {
        String str = ProxyConfig.MATCH_ALL_SCHEMES;
        if (this.allowList != null) {
            try {
                if (origin.compareTo(ProxyConfig.MATCH_ALL_SCHEMES) == 0) {
                    LOG.d(TAG, "Unlimited access to network resources");
                    this.allowList = null;
                    return;
                }
                Matcher matcher = Pattern.compile("^((\\*|[A-Za-z-]+):(//)?)?(\\*|((\\*\\.)?[^*/:]+))?(:(\\d+))?(/.*)?").matcher(origin);
                if (matcher.matches()) {
                    String group = matcher.group(2);
                    String group2 = matcher.group(4);
                    if ((!"file".equals(group) && !"content".equals(group)) || group2 != null) {
                        str = group2;
                    }
                    String group3 = matcher.group(8);
                    String group4 = matcher.group(9);
                    if (group == null) {
                        this.allowList.add(new URLPattern(ProxyConfig.MATCH_HTTP, str, group3, group4));
                        this.allowList.add(new URLPattern(ProxyConfig.MATCH_HTTPS, str, group3, group4));
                    } else {
                        this.allowList.add(new URLPattern(group, str, group3, group4));
                    }
                }
            } catch (Exception unused) {
                LOG.d(TAG, "Failed to add origin %s", origin);
            }
        }
    }

    public boolean isUrlAllowListed(String uri) {
        if (this.allowList == null) {
            return true;
        }
        Uri parse = Uri.parse(uri);
        Iterator<URLPattern> it = this.allowList.iterator();
        while (it.hasNext()) {
            if (it.next().matches(parse)) {
                return true;
            }
        }
        return false;
    }
}
