
package com.talenttech.topmind;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNTopmindModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNTopmindModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNTopmind";
  }
}
