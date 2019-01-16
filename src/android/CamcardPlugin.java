package com.conceicao.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Date;

public class CamcardPlugin extends CordovaPlugin {
  private static final String TAG = "CamcardPlugin";
  private static final String DURATION_LONG = "long";

  public void initialize(CordovaInterface cordova, CordovaWebView webView){
    super.initialize(cordova, webView);
    LOG.d(TAG, "Initializinf CamcardPlugin");
  }

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
      if (!action.equals("echo")) {
        String phrase = args.getString(0);
        LOG.d(TAG, phrase);
      } else if(action.equals("getDate")) {
        final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
        callbackContext.sendPluginResult(result);
      }
      return true;
      /*
      String message;
      String duration;
      try {
        JSONObject options = args.getJSONObject(0);
        message = options.getString("message");
        duration = options.getString("duration");
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      // Create the toast
      Toast toast = Toast.makeText(cordova.getActivity(), message,
        DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
      // Display toast
      toast.show();
      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
      */
  }
}