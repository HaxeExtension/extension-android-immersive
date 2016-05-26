#!/bin/bash
dir=`dirname "$0"`
cd "$dir"

EXTNAME="extension-android-immersive"

rm -rf $EXTNAME.zip

zip -r $EXTNAME.zip haxelib.json include.xml java extension

haxelib remove $EXTNAME
haxelib local $EXTNAME.zip
