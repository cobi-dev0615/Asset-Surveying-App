package cf.ser.ssm;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

/* loaded from: classes.dex */
public class MainActivity extends CordovaActivity {
    @Override // org.apache.cordova.CordovaActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }
        loadUrl(this.launchUrl);
    }
}
