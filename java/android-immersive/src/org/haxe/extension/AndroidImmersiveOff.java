package org.haxe.extension;

import java.io.IOException;
import java.util.Map;
import java.lang.Runnable;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.KeyEvent;
import android.view.KeyCharacterMap;
import android.widget.FrameLayout;
import android.widget.VideoView;
import android.util.Log;
import android.content.res.AssetFileDescriptor;
import android.support.v4.content.ContextCompat;



public class AndroidImmersiveOff extends Extension {
	

	public static void setStatusBarColor(final int color){
		::if (ANDROID_TARGET_SDK_VERSION >= 21)::
		if(Build.VERSION.SDK_INT >= 21) {
			Log.i("IMM", "setting color: "+color);
			Extension.mainActivity.runOnUiThread(new Runnable() {
				public void run() {
					try{
						Window window = Extension.mainActivity.getWindow();
						window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); 
						window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
						window.setStatusBarColor(color);
					}catch(Exception e) {
						Log.i("IMM", "Exception: "+e.toString());
					}
				}
			});
		}	
		::end::
	}
}