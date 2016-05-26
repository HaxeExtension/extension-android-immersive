package extension.androidImmersive;

class StatusBarColor {
	
	
	public static var statusBarColor(default, set):Int;

	#if (android && immersiveOff)
	public static var setStatusBarColor:Int->Void = openfl.utils.JNI.createStaticMethod("org/haxe/extension/AndroidImmersiveOff", "setStatusBarColor", "(I)V");
	#else 
	public static var setStatusBarColor:Int->Void = function(i:Int){trace("no es android o no encuentra IMMERSIVE_OFF");};
	#end 

	private static function set_statusBarColor(value:Int){
		#if immersiveOff
		trace("IMM!");
		setStatusBarColor(value);
		#end
		return statusBarColor = value;
		
	}
}