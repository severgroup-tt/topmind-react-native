
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
