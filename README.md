#extension-android-immersive

Lime extension for enabling immersive mode on most Android devices.

###Main Features

* Immersive mode for Android ICS and later
* Hiding of status bar and soft navigation keys
* Low profile mode for devices with soft keys hiding disabled

###How to Install

To install this library, you can simply get the library from haxelib like this:
```bash
haxelib install extension-android-immersive
```

###How to Use

To use this extension, simply add the next line in the project.xml
```xml
<haxelib name="extension-android-immersive" />
```
And target the sdk version 19, by adding the following lines in the project.xml
```xml
<section if="android">
	<android target-sdk-version="19" />
</section>
```

###License

The MIT License (MIT) - [LICENSE.md](LICENSE.md)

Copyright &copy; 2015 SempaiGames (http://www.sempaigames.com)

Author: Joacko Bengochea & Federico Bricker
