
# react-native-topmind

## Getting started

`npm install react-native-topmind --save` or `yarn add react-native-topmind`

Add maven repo in build.gradle
```groovy
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/talenttech/topmind' }
    }
}
```

And run `react-native link react-native-topmind`

## Usage
```typescript
import { RNTopmind } from 'react-native-topmind';

  /**
   * Required to call before any other calls (!!!)
   */
  RNTopmind.init(): void

  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" f.e
   * @param eventData Map with data {myParam: "myValue"} f.e
   */
  RNTopmind.logEvent(name: string, eventData: {[key: string]: string} ): void;

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId value
   * @param userId your user id
   */
  RNTopmind.setUserId(userId: string): void;

  /**
   * It removes all persisted TopMind data (userId f.e)
   */
  RNTopmind.logout(): void;

  /**
   * Sends event that app has started
   */
  RNTopmind.applicationStarted(): void;
```
