package org.haxe.extension;

import java.io.IOException;
import java.util.Map;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.VideoView;
import android.util.Log;
import android.content.res.AssetFileDescriptor;


public class AndroidImmersive extends Extension {
	

	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	@Override public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		return true;
	}

	/**
	 * Called when the activity is starting.
	 */
	@Override public void onCreate (Bundle savedInstanceState) {
	}
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	@Override public void onDestroy () {
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	@Override public void onPause () {
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	@Override public void onRestart () {
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	@Override public void onResume () {
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	@Override public void onStart () {
	}
		
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	@Override public void onStop () {
	}


}
