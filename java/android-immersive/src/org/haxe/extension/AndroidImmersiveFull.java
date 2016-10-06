package org.haxe.extension;

import android.os.Bundle;

public class AndroidImmersiveFull extends AndroidImmersive {

	@Override public void onCreate (Bundle savedInstanceState) {
		if(AndroidImmersive.currentMode == null){
			AndroidImmersive.currentMode = "immersive";
		}
		super.onCreate(savedInstanceState);
	}

}