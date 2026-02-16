package org.apache.cordova.dialogs;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Notification extends CordovaPlugin {
    private static final String ACTION_ACTIVITY_START = "activityStart";
    private static final String ACTION_ACTIVITY_STOP = "activityStop";
    private static final String ACTION_ALERT = "alert";
    private static final String ACTION_BEEP = "beep";
    private static final String ACTION_CONFIRM = "confirm";
    private static final String ACTION_PROGRESS_START = "progressStart";
    private static final String ACTION_PROGRESS_STOP = "progressStop";
    private static final String ACTION_PROGRESS_VALUE = "progressValue";
    private static final String ACTION_PROMPT = "prompt";
    private static final long BEEP_TIMEOUT = 5000;
    private static final long BEEP_WAIT_TINE = 100;
    private static final String LOG_TAG = "Notification";
    public int confirmResult = -1;
    public ProgressDialog spinnerDialog = null;
    public ProgressDialog progressDialog = null;

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (this.cordova.getActivity().isFinishing()) {
            return true;
        }
        if (action.equals(ACTION_BEEP)) {
            beep(args.getLong(0));
        } else {
            if (action.equals(ACTION_ALERT)) {
                alert(args.getString(0), args.getString(1), args.getString(2), callbackContext);
                return true;
            }
            if (action.equals(ACTION_CONFIRM)) {
                confirm(args.getString(0), args.getString(1), args.getJSONArray(2), callbackContext);
                return true;
            }
            if (action.equals(ACTION_PROMPT)) {
                prompt(args.getString(0), args.getString(1), args.getJSONArray(2), args.getString(3), callbackContext);
                return true;
            }
            if (action.equals(ACTION_ACTIVITY_START)) {
                activityStart(args.getString(0), args.getString(1));
            } else if (action.equals(ACTION_ACTIVITY_STOP)) {
                activityStop();
            } else if (action.equals(ACTION_PROGRESS_START)) {
                progressStart(args.getString(0), args.getString(1));
            } else if (action.equals(ACTION_PROGRESS_VALUE)) {
                progressValue(args.getInt(0));
            } else {
                if (!action.equals(ACTION_PROGRESS_STOP)) {
                    return false;
                }
                progressStop();
            }
        }
        callbackContext.success();
        return true;
    }

    public void beep(final long count) {
        this.cordova.getThreadPool().execute(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.1
            @Override // java.lang.Runnable
            public void run() {
                Ringtone ringtone = RingtoneManager.getRingtone(Notification.this.cordova.getActivity().getBaseContext(), RingtoneManager.getDefaultUri(2));
                if (ringtone != null) {
                    for (long j = 0; j < count; j++) {
                        ringtone.play();
                        long j2 = Notification.BEEP_TIMEOUT;
                        while (ringtone.isPlaying() && j2 > 0) {
                            j2 -= Notification.BEEP_WAIT_TINE;
                            try {
                                Thread.sleep(Notification.BEEP_WAIT_TINE);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        });
    }

    public synchronized void alert(final String message, final String title, final String buttonLabel, final CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.2
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder createDialog = Notification.this.createDialog(cordovaInterface);
                createDialog.setMessage(message);
                createDialog.setTitle(title);
                createDialog.setCancelable(true);
                createDialog.setPositiveButton(buttonLabel, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.dialogs.Notification.2.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                Notification.this.changeTextDirection(createDialog);
            }
        });
    }

    public synchronized void confirm(final String message, final String title, final JSONArray buttonLabels, final CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.3
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder createDialog = Notification.this.createDialog(cordovaInterface);
                createDialog.setMessage(message);
                createDialog.setTitle(title);
                createDialog.setCancelable(true);
                if (buttonLabels.length() > 0) {
                    try {
                        createDialog.setNegativeButton(buttonLabels.getString(0), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.3.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 1));
                            }
                        });
                    } catch (JSONException unused) {
                        LOG.d(Notification.LOG_TAG, "JSONException on first button.");
                    }
                }
                if (buttonLabels.length() > 1) {
                    try {
                        createDialog.setNeutralButton(buttonLabels.getString(1), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.3.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 2));
                            }
                        });
                    } catch (JSONException unused2) {
                        LOG.d(Notification.LOG_TAG, "JSONException on second button.");
                    }
                }
                if (buttonLabels.length() > 2) {
                    try {
                        createDialog.setPositiveButton(buttonLabels.getString(2), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.3.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 3));
                            }
                        });
                    } catch (JSONException unused3) {
                        LOG.d(Notification.LOG_TAG, "JSONException on third button.");
                    }
                }
                createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.dialogs.Notification.3.4
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                Notification.this.changeTextDirection(createDialog);
            }
        });
    }

    public synchronized void prompt(final String message, final String title, final JSONArray buttonLabels, final String defaultText, final CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.4
            @Override // java.lang.Runnable
            public void run() {
                final EditText editText = new EditText(cordovaInterface.getActivity());
                editText.setTextColor(cordovaInterface.getActivity().getResources().getColor(R.color.primary_text_light));
                editText.setText(defaultText);
                AlertDialog.Builder createDialog = Notification.this.createDialog(cordovaInterface);
                createDialog.setMessage(message);
                createDialog.setTitle(title);
                createDialog.setCancelable(true);
                createDialog.setView(editText);
                final JSONObject jSONObject = new JSONObject();
                if (buttonLabels.length() > 0) {
                    try {
                        createDialog.setNegativeButton(buttonLabels.getString(0), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.4.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 1);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? defaultText : editText.getText());
                                } catch (JSONException e) {
                                    LOG.d(Notification.LOG_TAG, "JSONException on first button.", e);
                                }
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException unused) {
                        LOG.d(Notification.LOG_TAG, "JSONException on first button.");
                    }
                }
                if (buttonLabels.length() > 1) {
                    try {
                        createDialog.setNeutralButton(buttonLabels.getString(1), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.4.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 2);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? defaultText : editText.getText());
                                } catch (JSONException e) {
                                    LOG.d(Notification.LOG_TAG, "JSONException on second button.", e);
                                }
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException unused2) {
                        LOG.d(Notification.LOG_TAG, "JSONException on second button.");
                    }
                }
                if (buttonLabels.length() > 2) {
                    try {
                        createDialog.setPositiveButton(buttonLabels.getString(2), new DialogInterface.OnClickListener() { // from class: org.apache.cordova.dialogs.Notification.4.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 3);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? defaultText : editText.getText());
                                } catch (JSONException e) {
                                    LOG.d(Notification.LOG_TAG, "JSONException on third button.", e);
                                }
                                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException unused3) {
                        LOG.d(Notification.LOG_TAG, "JSONException on third button.");
                    }
                }
                createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.dialogs.Notification.4.4
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        try {
                            jSONObject.put("buttonIndex", 0);
                            jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? defaultText : editText.getText());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONObject));
                    }
                });
                Notification.this.changeTextDirection(createDialog);
            }
        });
    }

    public synchronized void activityStart(final String title, final String message) {
        ProgressDialog progressDialog = this.spinnerDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.spinnerDialog = null;
        }
        final CordovaInterface cordovaInterface = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.5
            @Override // java.lang.Runnable
            public void run() {
                this.spinnerDialog = Notification.this.createProgressDialog(cordovaInterface);
                this.spinnerDialog.setTitle(title);
                this.spinnerDialog.setMessage(message);
                this.spinnerDialog.setCancelable(true);
                this.spinnerDialog.setIndeterminate(true);
                this.spinnerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.dialogs.Notification.5.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        this.spinnerDialog = null;
                    }
                });
                this.spinnerDialog.show();
            }
        });
    }

    public synchronized void activityStop() {
        ProgressDialog progressDialog = this.spinnerDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.spinnerDialog = null;
        }
    }

    public synchronized void progressStart(final String title, final String message) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.progressDialog = null;
        }
        final CordovaInterface cordovaInterface = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.dialogs.Notification.6
            @Override // java.lang.Runnable
            public void run() {
                this.progressDialog = Notification.this.createProgressDialog(cordovaInterface);
                this.progressDialog.setProgressStyle(1);
                this.progressDialog.setTitle(title);
                this.progressDialog.setMessage(message);
                this.progressDialog.setCancelable(true);
                this.progressDialog.setMax(100);
                this.progressDialog.setProgress(0);
                this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.dialogs.Notification.6.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        this.progressDialog = null;
                    }
                });
                this.progressDialog.show();
            }
        });
    }

    public synchronized void progressValue(int value) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setProgress(value);
        }
    }

    public synchronized void progressStop() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog.Builder createDialog(CordovaInterface cordova) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new AlertDialog.Builder(cordova.getActivity(), 5);
        }
        return new AlertDialog.Builder(cordova.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProgressDialog createProgressDialog(CordovaInterface cordova) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new ProgressDialog(cordova.getActivity(), 5);
        }
        return new ProgressDialog(cordova.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTextDirection(AlertDialog.Builder dlg) {
        int i = Build.VERSION.SDK_INT;
        dlg.create();
        AlertDialog show = dlg.show();
        if (i >= 17) {
            ((TextView) show.findViewById(R.id.message)).setTextDirection(5);
        }
    }
}
