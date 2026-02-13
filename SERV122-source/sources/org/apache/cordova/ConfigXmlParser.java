package org.apache.cordova;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConfigXmlParser {
    private static String TAG = "ConfigXmlParser";
    private String launchUrl = null;
    private CordovaPreferences prefs = new CordovaPreferences();
    private ArrayList<PluginEntry> pluginEntries = new ArrayList<>(20);
    boolean insideFeature = false;
    String service = "";
    String pluginClass = "";
    String paramType = "";
    boolean onload = false;

    public CordovaPreferences getPreferences() {
        return this.prefs;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }

    public String getLaunchUrl() {
        if (this.launchUrl == null) {
            this.launchUrl = "https://" + this.prefs.getString("hostname", "localhost");
        }
        if (this.prefs.getBoolean("AndroidInsecureFileModeEnabled", false)) {
            this.launchUrl = "file:///android_asset/www/index.html";
        }
        return this.launchUrl;
    }

    public void parse(Context action) {
        int identifier = action.getResources().getIdentifier("config", "xml", action.getClass().getPackage().getName());
        if (identifier == 0 && (identifier = action.getResources().getIdentifier("config", "xml", action.getPackageName())) == 0) {
            LOG.e(TAG, "res/xml/config.xml is missing!");
        } else {
            this.pluginEntries.add(new PluginEntry(AllowListPlugin.PLUGIN_NAME, "org.apache.cordova.AllowListPlugin", true));
            parse(action.getResources().getXml(identifier));
        }
    }

    public void parse(XmlPullParser xml) {
        int i = -1;
        while (i != 1) {
            if (i == 2) {
                handleStartTag(xml);
            } else if (i == 3) {
                handleEndTag(xml);
            }
            try {
                i = xml.next();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void handleStartTag(XmlPullParser xml) {
        String attributeValue;
        String name = xml.getName();
        if (name.equals("feature")) {
            this.insideFeature = true;
            this.service = xml.getAttributeValue(null, "name");
            return;
        }
        if (this.insideFeature && name.equals("param")) {
            String attributeValue2 = xml.getAttributeValue(null, "name");
            this.paramType = attributeValue2;
            if (attributeValue2.equals(NotificationCompat.CATEGORY_SERVICE)) {
                this.service = xml.getAttributeValue(null, "value");
                return;
            }
            if (this.paramType.equals("package") || this.paramType.equals("android-package")) {
                this.pluginClass = xml.getAttributeValue(null, "value");
                return;
            } else {
                if (this.paramType.equals("onload")) {
                    this.onload = "true".equals(xml.getAttributeValue(null, "value"));
                    return;
                }
                return;
            }
        }
        if (name.equals("preference")) {
            this.prefs.set(xml.getAttributeValue(null, "name").toLowerCase(Locale.ENGLISH), xml.getAttributeValue(null, "value"));
        } else {
            if (!name.equals("content") || (attributeValue = xml.getAttributeValue(null, "src")) == null) {
                return;
            }
            setStartUrl(attributeValue);
        }
    }

    public void handleEndTag(XmlPullParser xml) {
        if (xml.getName().equals("feature")) {
            this.pluginEntries.add(new PluginEntry(this.service, this.pluginClass, this.onload));
            this.service = "";
            this.pluginClass = "";
            this.insideFeature = false;
            this.onload = false;
        }
    }

    private void setStartUrl(String src) {
        if (Pattern.compile("^[a-z-]+://").matcher(src).find()) {
            this.launchUrl = src;
            return;
        }
        if (src.charAt(0) == '/') {
            src = src.substring(1);
        }
        if (this.prefs.getBoolean("AndroidInsecureFileModeEnabled", false)) {
            this.launchUrl = "file:///android_asset/www/" + src;
            return;
        }
        this.launchUrl = "https://" + this.prefs.getString("hostname", "localhost") + "/" + src;
    }
}
