
# react-native-topmind

## Getting started

Add to package.json

`"react-native-topmind": "https://github.com/severgroup-tt/topmind-react-native.git#master"`

Add maven repo in build.gradle
```groovy
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/talenttech/topmind' }
    }
}
```

And run `react-native link react-native-topmind`

then run `cd ios && pod install`

Add
```
<key>TopMindClientId</key>
<string>your_client_id</string>
<key>TopMindApiKey</key>
<string>your_api_key</string>
```
to `info.plist`

And add
```
<string name="TopmindClientId">your_client_id</string>
<string name="TopmindApiKey">your_api_key</string>
```
to `res/values/strings.xml`

and
```
<meta-data android:name="TopmindApiKey" android:value="@string/TopmindApiKey" />
<meta-data android:name="TopmindClientId" android:value="@string/TopmindClientId" />
```

to your `AndroidManifest.xml`

## Usage
```typescript
import { RNTopmind } from 'react-native-topmind';

  /**
   * Required to call before any other calls (!!!)
   */
  RNTopmind.init();

  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" f.e
   * @param eventData Map with data {myParam: "myValue"} f.e
   */
  RNTopmind.logEvent(name: string, eventData: {[key: string]: string} );

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId property
   * @param userId your user id
   */
  RNTopmind.setUserId(userId: string);

  /**
   * It removes all persisted TopMind data (userId f.e)
   */
  RNTopmind.logout();

  /**
   * Sends event that app has started
   */
  RNTopmind.applicationStarted();
```
