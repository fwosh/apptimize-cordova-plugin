package com.apptimize.cordova;

import android.content.Context;
import android.telecom.Call;

import com.apptimize.Apptimize;
import com.apptimize.ApptimizeTest;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class ApptimizeCordovaPlugin extends CordovaPlugin {

    // Preferences from config.xml
    private static final String APPTIMIZE_APP_KEY_ANDROID_PREFERENCE = "com.apptimize.android.app_key";

    @Override
    protected void pluginInitialize() {
        final Context context = this.cordova.getActivity().getApplicationContext();
        final String appKey = this.preferences.getString(APPTIMIZE_APP_KEY_ANDROID_PREFERENCE, null);
        Apptimize.setup(context, appKey);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("startApptimize".equals(action)) {
            /*
            final Context context = this.cordova.getActivity().getApplicationContext();
            final String appKey = args.getString(0);
            final CallbackContext callbackContext1 = callbackContext;
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    Apptimize.setup(context, appKey);
                    callbackContext1.success();
                }
            });*/
            return true;
        }
        else if ("runTest".equals(action)) {
            final CallbackContext callbackContext1 = callbackContext;
            final String testName = args.getString(0);
            Apptimize.runTest(testName, new ApptimizeTest() {

                @Override
                public void baseline() {
                    callbackContext1.success(0);
                }

                @SuppressWarnings("unused")
                public void variation1() {
                    callbackContext1.success(1);
                }

                @SuppressWarnings("unused")
                public void variation2() {
                    callbackContext1.success(2);
                }

                @SuppressWarnings("unused")
                public void variation3() {
                    callbackContext1.success(3);
                }

                @SuppressWarnings("unused")
                public void variation4() {
                    callbackContext1.success(4);
                }

                @SuppressWarnings("unused")
                public void variation5() {
                    callbackContext1.success(5);
                }

                @SuppressWarnings("unused")
                public void variation6() {
                    callbackContext1.success(6);
                }

                @SuppressWarnings("unused")
                public void variation7() {
                    callbackContext1.success(7);
                }

                @SuppressWarnings("unused")
                public void variation8() {
                    callbackContext1.success(8);
                }

                @SuppressWarnings("unused")
                public void variation9() {
                    callbackContext1.success(9);
                }

            });
            return true;
        }
        else if ("track".equals(action)) {
            Apptimize.track(args.getString(0));
        }
        else if ("trackValue".equals(action)) {
            Apptimize.track(args.getString(0), args.getDouble(1));
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }
}