package org.haxe.extension;

import android.os.Bundle;

public class AndroidImmersiveLowProfile extends AndroidImmersive {

	@Override public void onCreate (Bundle savedInstanceState) {
		if(AndroidImmersive.currentMode == null){
			AndroidImmersive.currentMode = "lowProfile";
		}
		super.onCreate(savedInstanceState);
	}

}