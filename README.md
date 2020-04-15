# extension-android-immersive

Lime extension for enabling immersive mode on most Android devices.

### Main Features

* Immersive mode for Android ICS and later
* Hiding of status bar and soft navigation keys
* Low profile mode for devices with soft keys hiding disabled
* Setting of status bar color

### How to Install

To install this library, you can simply get the library from haxelib like this:
```bash
haxelib install extension-android-immersive
```

### How to Use

To use this extension, simply add the next line in the project.xml
```xml
<haxelib name="extension-android-immersive" />
```
And target the sdk version to at least 19, by adding the following lines in the project.xml
```xml
<section if="android">
	<android target-sdk-version="19" />
</section>
```
For immersive mode full, low profile or display a colored bar, add one of the following lines in the project.xml (only one)
```xml
<set name="IMMERSIVE_FULL" /> <!-- to set the most immersive mode available -->
<set name="IMMERSIVE_LOW_PROFILE" /> <!-- to set the low profile mode -->
<set name="IMMERSIVE_COLOR_BAR" /> <!-- to leave the status bar, so that you can call setStatusBarColor() afterwards -->
```

To set the status bar color, or change the immersive mode in runtime, call this:

```Haxe
StatusBarColor.setStatusBarColor(color); // color must be in 0xaarrggbb format; -1 leaves the default
StatusBarColor.setLowProfile(); // sets low profile mode
StatusBarColor.setImmersive(); // sets the most immersive mode available
```


### License

The MIT License (MIT) - [LICENSE.md](LICENSE.md)

Copyright &copy; 2015 SempaiGames (http://www.sempaigames.com)

Author: Joacko Bengochea & Federico Bricker
