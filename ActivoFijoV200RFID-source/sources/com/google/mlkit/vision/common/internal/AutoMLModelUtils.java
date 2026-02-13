package com.google.mlkit.vision.common.internal;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes3.dex */
public class AutoMLModelUtils {
    private AutoMLModelUtils() {
    }

    public static String[] getModelAndLabelFilePaths(Context context, LocalModel localModel, boolean z) throws IOException {
        String str;
        String str2 = z ? (String) Preconditions.checkNotNull(localModel.getAssetFilePath()) : (String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath());
        if (localModel.isManifestFile()) {
            ModelUtils.AutoMLManifest parseManifestFile = ModelUtils.parseManifestFile(str2, z, context);
            if (parseManifestFile == null) {
                throw new IOException("Failed to parse manifest file.");
            }
            Preconditions.checkState(Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE.equals(parseManifestFile.getModelType()), "Model type should be: %s.", Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE);
            str2 = new File(new File(str2).getParent(), parseManifestFile.getModelFile()).toString();
            str = new File(new File(str2).getParent(), parseManifestFile.getLabelsFile()).toString();
        } else {
            str = "";
        }
        return new String[]{str2, str};
    }

    public static List<String> readLabelsFile(Context context, String str, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStream open = z ? context.getAssets().open(str) : new FileInputStream(new File(str));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Key.STRING_CHARSET_NAME));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                arrayList.add(readLine);
            }
            if (open != null) {
                open.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
            }
            throw th;
        }
    }
}
