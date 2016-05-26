@ECHO OFF
SET EXTNAME="extension-android-immersive"

REM Build extension
zip -r %EXTNAME%.zip haxelib.json include.xml java extension
haxelib local %EXTNAME%.zip
