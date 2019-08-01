
package com.talenttech.topmind;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import talenttech.topmind.ApiKeyNotFoundException;
import talenttech.topmind.ClientIdNotFoundException;
import talenttech.topmind.TopMind;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;
import static com.talenttech.topmind.Utils.toMap;

public class RNTopmindModule extends ReactContextBaseJavaModule {

    private TopMind topmind = null;

    RNTopmindModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNTopmind";
    }

    @ReactMethod
    public void initialize() {
        try {
            if (getCurrentActivity() != null) {
                topmind = new TopMind(getCurrentActivity());
            }
        } catch (ApiKeyNotFoundException e) {
            e.printStackTrace();
        } catch (ClientIdNotFoundException e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void logEvent(final String name, final ReadableMap eventData) {
        if (topmind != null) {
            runOnUiThread(() -> topmind.logEvent(name, toMap(eventData)));
        }
    }

    @ReactMethod
    public void setUserId(final String userId) {
        if (topmind != null) {
            runOnUiThread(() -> topmind.setUserId(userId));
        }
    }

    @ReactMethod
    public void logout() {
        if (topmind != null) {
            runOnUiThread(() -> topmind.logout());
        }
    }

    @ReactMethod
    public void applicationStarted() {
        if (topmind != null) {
            runOnUiThread(() -> topmind.applicationStarted());
        }
    }
}
