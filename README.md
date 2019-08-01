
# react-native-topmind-sdk

[![npm version](https://badge.fury.io/js/react-native-topmind-sdk.svg)](https://badge.fury.io/js/react-native-topmind-sdk)

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
  RNTopmind.initialize();

  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" e.g
   * @param eventData Map with data {foo: "bar"} e.g
   * or {
   *      foo: { 
   *        bar: "someString" 
   *      }
   *    }
   */
  RNTopmind.logEvent(name: string, eventData: {[key: string]: string | object } );

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId property
   * @param userId your user id
   */
  RNTopmind.setUserId(userId: string);

  /**
   * It removes all persisted TopMind data (userId e.g)
   */
  RNTopmind.logout();

  /**
   * Sends event that app has started
   */
  RNTopmind.applicationStarted();
```
