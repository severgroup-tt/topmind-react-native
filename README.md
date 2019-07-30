
# react-native-topmind

## Getting started

`$ npm install react-native-topmind --save`

### Mostly automatic installation

`$ react-native link react-native-topmind`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-topmind` and add `RNTopmind.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNTopmind.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNTopmindPackage;` to the imports at the top of the file
  - Add `new RNTopmindPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-topmind'
  	project(':react-native-topmind').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-topmind/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-topmind')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNTopmind.sln` in `node_modules/react-native-topmind/windows/RNTopmind.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Topmind.RNTopmind;` to the usings at the top of the file
  - Add `new RNTopmindPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNTopmind from 'react-native-topmind';

// TODO: What to do with the module?
RNTopmind;
```
  