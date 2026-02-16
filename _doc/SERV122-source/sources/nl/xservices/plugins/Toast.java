package nl.xservices.plugins;

import android.R;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Toast extends CordovaPlugin {
    private static final String ACTION_HIDE_EVENT = "hide";
    private static final String ACTION_SHOW_EVENT = "show";
    private static final int BASE_TOP_BOTTOM_OFFSET = 20;
    private static final int GRAVITY_BOTTOM = 81;
    private static final int GRAVITY_CENTER = 17;
    private static final int GRAVITY_TOP = 49;
    private static final boolean IS_AT_LEAST_JELLY_BEAN;
    private static final boolean IS_AT_LEAST_LOLLIPOP;
    private static final boolean IS_AT_LEAST_PIE;
    private static final boolean IS_AT_LEAST_R;
    private static CountDownTimer _timer;
    private JSONObject currentData;
    private String currentMessage;
    private boolean isPaused;
    private android.widget.Toast mostRecentToast;
    private ViewGroup viewGroup;

    static {
        IS_AT_LEAST_JELLY_BEAN = Build.VERSION.SDK_INT >= 16;
        IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
        IS_AT_LEAST_PIE = Build.VERSION.SDK_INT >= 28;
        IS_AT_LEAST_R = Build.VERSION.SDK_INT >= 30;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (ACTION_HIDE_EVENT.equals(action)) {
            returnTapEvent(ACTION_HIDE_EVENT, this.currentMessage, this.currentData, callbackContext);
            hide();
            callbackContext.success();
            return true;
        }
        if (ACTION_SHOW_EVENT.equals(action)) {
            if (this.isPaused) {
                return true;
            }
            JSONObject jSONObject = args.getJSONObject(0);
            final String string = jSONObject.getString("message");
            final SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, string.length() - 1, 18);
            final String string2 = jSONObject.getString("duration");
            final String string3 = jSONObject.getString("position");
            int i = jSONObject.has("addPixelsY") ? jSONObject.getInt("addPixelsY") : 0;
            final JSONObject jSONObject2 = jSONObject.has("data") ? jSONObject.getJSONObject("data") : null;
            final JSONObject optJSONObject = jSONObject.optJSONObject("styling");
            this.currentMessage = string;
            this.currentData = jSONObject2;
            final int i2 = i;
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: nl.xservices.plugins.Toast.1
                /* JADX WARN: Type inference failed for: r10v0, types: [nl.xservices.plugins.Toast$1$3] */
                @Override // java.lang.Runnable
                public void run() {
                    int parseInt;
                    if ("short".equalsIgnoreCase(string2)) {
                        parseInt = 2000;
                    } else {
                        parseInt = "long".equalsIgnoreCase(string2) ? 4000 : Integer.parseInt(string2);
                    }
                    final android.widget.Toast makeText = android.widget.Toast.makeText(Toast.IS_AT_LEAST_LOLLIPOP ? Toast.this.cordova.getActivity().getWindow().getContext() : Toast.this.cordova.getActivity().getApplicationContext(), spannableString, !"short".equalsIgnoreCase(string2) ? 1 : 0);
                    if ("top".equals(string3)) {
                        makeText.setGravity(49, 0, i2 + 20);
                    } else if ("bottom".equals(string3)) {
                        makeText.setGravity(81, 0, 20 - i2);
                    } else if ("center".equals(string3)) {
                        makeText.setGravity(17, 0, i2);
                    } else {
                        callbackContext.error("invalid position. valid options are 'top', 'center' and 'bottom'");
                        return;
                    }
                    if (optJSONObject != null && Toast.IS_AT_LEAST_JELLY_BEAN && !Toast.IS_AT_LEAST_R) {
                        String optString = optJSONObject.optString("backgroundColor", "#333333");
                        String optString2 = optJSONObject.optString("textColor", "#ffffff");
                        Double valueOf = Double.valueOf(optJSONObject.optDouble("textSize", -1.0d));
                        double optDouble = optJSONObject.optDouble("opacity", 0.8d);
                        int optInt = optJSONObject.optInt("cornerRadius", 100);
                        int optInt2 = optJSONObject.optInt("horizontalPadding", 50);
                        int optInt3 = optJSONObject.optInt("verticalPadding", 30);
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setCornerRadius(optInt);
                        gradientDrawable.setAlpha((int) (optDouble * 255.0d));
                        gradientDrawable.setColor(Color.parseColor(optString));
                        makeText.getView().setBackground(gradientDrawable);
                        TextView textView = (TextView) makeText.getView().findViewById(R.id.message);
                        textView.setTextColor(Color.parseColor(optString2));
                        if (valueOf.doubleValue() > -1.0d) {
                            textView.setTextSize(valueOf.floatValue());
                        }
                        makeText.getView().setPadding(optInt2, optInt3, optInt2, optInt3);
                        if (Toast.IS_AT_LEAST_LOLLIPOP) {
                            makeText.getView().setElevation(6.0f);
                        }
                    }
                    if (!Toast.IS_AT_LEAST_R) {
                        if (Toast.IS_AT_LEAST_LOLLIPOP) {
                            Toast.this.getViewGroup().setOnTouchListener(new View.OnTouchListener() { // from class: nl.xservices.plugins.Toast.1.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    float f;
                                    float height;
                                    if (motionEvent.getAction() != 0) {
                                        return false;
                                    }
                                    if (Toast.this.mostRecentToast == null || !Toast.this.mostRecentToast.getView().isShown()) {
                                        Toast.this.getViewGroup().setOnTouchListener(null);
                                        return false;
                                    }
                                    float width = Toast.this.mostRecentToast.getView().getWidth() / 2.0f;
                                    float width2 = (view.getWidth() / 2) - width;
                                    float width3 = (view.getWidth() / 2) + width;
                                    float gravity = Toast.this.mostRecentToast.getGravity();
                                    float yOffset = Toast.this.mostRecentToast.getYOffset();
                                    float height2 = Toast.this.mostRecentToast.getView().getHeight();
                                    if (gravity == 81.0f) {
                                        height = (view.getHeight() - yOffset) - height2;
                                        f = view.getHeight() - yOffset;
                                    } else if (gravity == 17.0f) {
                                        float f2 = height2 / 2.0f;
                                        height = ((view.getHeight() / 2) + yOffset) - f2;
                                        f = (view.getHeight() / 2) + yOffset + f2;
                                    } else {
                                        f = yOffset + height2;
                                        float x = motionEvent.getX();
                                        float y = motionEvent.getY();
                                        return ((x > width2 ? 1 : (x == width2 ? 0 : -1)) < 0 && (x > width3 ? 1 : (x == width3 ? 0 : -1)) <= 0 && (y > yOffset ? 1 : (y == yOffset ? 0 : -1)) >= 0 && (y > f ? 1 : (y == f ? 0 : -1)) <= 0) && Toast.this.returnTapEvent("touch", string, jSONObject2, callbackContext);
                                    }
                                    yOffset = height;
                                    float x2 = motionEvent.getX();
                                    float y2 = motionEvent.getY();
                                    if ((x2 > width2 ? 1 : (x2 == width2 ? 0 : -1)) < 0 && (x2 > width3 ? 1 : (x2 == width3 ? 0 : -1)) <= 0 && (y2 > yOffset ? 1 : (y2 == yOffset ? 0 : -1)) >= 0 && (y2 > f ? 1 : (y2 == f ? 0 : -1)) <= 0) {
                                        return false;
                                    }
                                }
                            });
                        } else {
                            makeText.getView().setOnTouchListener(new View.OnTouchListener() { // from class: nl.xservices.plugins.Toast.1.2
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    return motionEvent.getAction() == 0 && Toast.this.returnTapEvent("touch", string, jSONObject2, callbackContext);
                                }
                            });
                        }
                    }
                    CountDownTimer unused = Toast._timer = new CountDownTimer(parseInt, 2500L) { // from class: nl.xservices.plugins.Toast.1.3
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Toast.this.returnTapEvent(Toast.ACTION_HIDE_EVENT, string, jSONObject2, callbackContext);
                            makeText.cancel();
                        }
                    }.start();
                    Toast.this.mostRecentToast = makeText;
                    makeText.show();
                    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
                    pluginResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(pluginResult);
                }
            });
            return true;
        }
        callbackContext.error("toast." + action + " is not a supported function. Did you mean '" + ACTION_SHOW_EVENT + "'?");
        return false;
    }

    private void hide() {
        android.widget.Toast toast = this.mostRecentToast;
        if (toast != null) {
            toast.cancel();
            getViewGroup().setOnTouchListener(null);
        }
        CountDownTimer countDownTimer = _timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean returnTapEvent(String eventName, String message, JSONObject data, CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, eventName);
            jSONObject.put("message", message);
            jSONObject.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(jSONObject);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getViewGroup() {
        if (this.viewGroup == null) {
            this.viewGroup = (ViewGroup) ((ViewGroup) this.cordova.getActivity().findViewById(R.id.content)).getChildAt(0);
        }
        return this.viewGroup;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onPause(boolean multitasking) {
        hide();
        this.isPaused = true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onResume(boolean multitasking) {
        this.isPaused = false;
    }
}
