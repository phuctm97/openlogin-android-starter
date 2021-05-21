# openlogin-android-starter

Template project for Android apps using OpenLogin.

## Usage

Open and run with Android Studio.

## Configuration

- Go to [Torus Developer](http://developer.tor.us) and create an OpenLogin project if you don't have one yet.

- Open `app/src/main/res/values/strings.xml` and update `openlogin_client_id` to your OpenLogin project ID.

- Open `app/src/main/AndroidManifest.xml` and update `com.openlogin.sdkapp` to your scheme of choice (e.g. your app bundle ID):

  ```xml
   <!-- Accept URIs: com.openlogin.sdkapp://* -->
  <data android:scheme="com.openlogin.sdkapp" />
  ```
 
- Go to [Torus Developer](http://developer.tor.us) and add `{YOUR CUSTOM SCHEME}://auth` to whitelist URLs in your OpenLogin project.