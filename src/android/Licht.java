package org.apache.cordova.plugin;



import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

// Kamera
import android.content.Context;
import android.hardware.camera2.*;

/**
 *
 */
public class Licht extends CordovaPlugin{

    boolean on = false;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("licht")) {
            String message = args.getString(0);
            try {
                this.licht(message, callbackContext);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private void licht(String message, CallbackContext callbackContext) throws CameraAccessException{

        CameraManager manager = (CameraManager) cordova.getActivity().getSystemService(Context.CAMERA_SERVICE);

        if (on == false) {
            manager.setTorchMode("0", true);
            callbackContext.success("Licht aus");
            on=true;
        } else {
            manager.setTorchMode("0", false);
            callbackContext.success("Licht an");
            on=false;
        }
    }
}
