
# react-native-topmind-sdk

## Getting started

Run `yarn add react-native-topmind-sdk` or `npm install react-native-topmind-sdk --save`

Then run `react-native link react-native-topmind-sdk`

### Android setup
Add maven repo in build.gradle
```groovy
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/talenttech/topmind' }
    }
}
```

Add
```
<string name="TopmindClientId">your_client_id</string>
<string name="TopmindApiKey">your_api_key</string>
```
to `res/values/strings.xml` and
```
<meta-data android:name="TopmindApiKey" android:value="@string/TopmindApiKey" />
<meta-data android:name="TopmindClientId" android:value="@string/TopmindClientId" />
```

to your `AndroidManifest.xml`

### iOS setup

Add
```
<key>TopMindClientId</key>
<string>your_client_id</string>
<key>TopMindApiKey</key>
<string>your_api_key</string>
```
to `info.plist`

and run `cd ios && pod install`

## Usage
```typescript
import { RNTopmind } from 'react-native-topmind-sdk';

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
