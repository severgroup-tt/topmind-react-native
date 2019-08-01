
package com.talenttech.topmind;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

import java.util.HashMap;

import talenttech.topmind.ApiKeyNotFoundException;
import talenttech.topmind.ClientIdNotFoundException;
import talenttech.topmind.TopMind;

import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

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
            runOnUiThread(() -> topmind.logEvent(name, convertMapToParams(eventData)));
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

    private HashMap<String, String> convertMapToParams(ReadableMap map) {
        if (map == null) return new HashMap<>();

        HashMap<String, String> hash = new HashMap<>();

        ReadableMapKeySetIterator iterator = map.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            if (map.getType(key) != ReadableType.String) {
                throw new IllegalArgumentException("Param properties must be a String, but " + map.getType(key) +
                        " found in " + key + " property");
            }
            hash.put(key, map.getString(key));
        }

        return hash;
    }
}
