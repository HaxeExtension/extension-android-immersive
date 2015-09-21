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
import android.view.KeyEvent;
import android.view.KeyCharacterMap;
import android.widget.FrameLayout;
import android.widget.VideoView;
import android.util.Log;
import android.content.res.AssetFileDescriptor;



public class AndroidImmersive extends Extension {
	

	private static final int DELAY_TIME = 500;
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	@Override public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		Log.i("IMM", "activityResult");
		return true;
	}

	/**
	 * Called when the activity is starting.
	 */
	@Override public void onCreate (Bundle savedInstanceState) {
		Log.i("IMM", "create");
		View decorView = mainActivity.getWindow().getDecorView();
		decorView.setOnSystemUiVisibilityChangeListener (new View.OnSystemUiVisibilityChangeListener() {
    	@Override
   		public void onSystemUiVisibilityChange(int visibility) {
   			if(Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 19){
   				//super.onSystemUiVisibilityChange(visibility);
   				return;
   			}
        	// Note that system bars will only be "visible" if none of the
        	// LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
        	if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
            handleSystemUIHide();
        	} else {
            handleSystemUIHide();
        }
    }
});
	}
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	@Override public void onDestroy () {
		Log.i("IMM", "destroy");
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	@Override public void onPause () {
		Log.i("IMM", "pause");
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	@Override public void onRestart () {
		Log.i("IMM", "restart");
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	@Override public void onResume () {
		Log.i("IMM", "resume");
		handleSystemUIHide();
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	@Override public void onStart () {
		Log.i("IMM", "start");
		handleSystemUIHide();
	}
		
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	@Override public void onStop () {
		Log.i("IMM", "stop");
	}
	public static void handleSystemUIHide(){
		Log.i("IMM", "handle");
		Handler handler = new Handler();
		Runnable runnable = new Runnable(){
    		public void run() {
    			Log.i("IMM", "run");
        		hideSystemUI();
    		}
		};
		handler.postDelayed(runnable, DELAY_TIME);
	}

	public static void hideSystemUI(){
		Log.i("IMM", "hide");
		::if (ANDROID_TARGET_SDK_VERSION >= 19)::
		boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
		boolean hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);
		if(Build.VERSION.SDK_INT >= 19) {
			Log.i("IMM", ">19");
			// devices with immersive mode
			View decorView = mainActivity.getWindow().getDecorView();
			decorView.setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);	
		}
		else if (hasBackKey && hasHomeKey && Build.VERSION.SDK_INT >= 16) {
			Log.i("IMM", ">16");
		    // no navigation soft keys, unless it is enabled in the settings
		    View decorView = mainActivity.getWindow().getDecorView();
			decorView.setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_FULLSCREEN
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_LOW_PROFILE);	
		}
		else if(Build.VERSION.SDK_INT >= 15) {
			Log.i("IMM", ">=15");
			// enable low profile in api 15 devices
			View decorView = mainActivity.getWindow().getDecorView();
			decorView.setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_FULLSCREEN
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_LOW_PROFILE);	
		}
		::end::
	}


}
