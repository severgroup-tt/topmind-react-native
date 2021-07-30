
# react-native-topmind-sdk

[![npm version](https://badge.fury.io/js/react-native-topmind-sdk.svg)](https://badge.fury.io/js/react-native-topmind-sdk)

## Getting started

Run `yarn add react-native-topmind-sdk` or `npm install react-native-topmind-sdk --save`

Then run `react-native link react-native-topmind-sdk`

### Android setup
Add your GitHub credentials(`GITHUB_USER` and `GITHUB_PERSONAL_ACCESS_TOKEN`([instruction](https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token)))
into environment variables

Then add maven repo in build.gradle
```groovy
allprojects {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/severgroup-tt/topmind-sdk-android")
            credentials {
                username = System.getenv('GITHUB_USER')
                password = System.getenv('GITHUB_PERSONAL_ACCESS_TOKEN')
            }
        }
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
   * Required to call before any other calls
   */
  RNTopmind.initialize();

  /**
   * Use it to send event to TopMind.
   * @param name event's name: "menu click" e.g
   * @param eventData Map with data
   * {
   *   foo: {
   *      bar: "someString"
   *    }
   * }
   */
  static logEvent(name: string, eventData: {[key: string]: object} ): void;

  /**
   * Use it to persist user identifier
   * It will be passed through all events as userId property
   * @param userId your user id
   */
  RNTopmind.setUserId(userId: string): void;

  /**
   * It removes all persisted TopMind data (userId e.g)
   */
  RNTopmind.logout(): void;

  /**
   * Sends event that app has started
   */
  RNTopmind.applicationStarted(): void;

  /**
   * Returns the current install id. The id is generated by the app at first run
   * App persists the id through the whole app lifetime.
   *
   * Will be deleted if you clear the application data
   */
  RNTopmind.getInstallId(): Promise<string>;
  
  /**
   * Returns the current sid_long. The id is generated and returned by TopMind at first event response
   * App persist the id through the whole app lifetime and passes it through each event
   *
   * Will be deleted if you clear the application data
   */
  RNTopmind.getSidLong(): Promise<string>;


  /**
   * Returns true if the application was launched for the first time
   */
  RNTopmind.isFirstRun(): Promise<boolean>;
```
