package org.haxe.extension;

import android.os.Bundle;

public class AndroidImmersiveStatusColorBar extends AndroidImmersive {

	@Override public void onCreate (Bundle savedInstanceState) {
		if(AndroidImmersive.currentMode == null){
		//	AndroidImmersive.currentMode = "statusBarColor";
		}
		super.onCreate(savedInstanceState);
	}

}