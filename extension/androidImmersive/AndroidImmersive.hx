package extension.androidImmersive;

#if android
	#if (openfl < "4.0.0")
	import openfl.utils.JNI;
	#else
	import lime.system.JNI;
	#end
#end

class AndroidImmersive {
	
	#if (android)
		public static var setStatusBarColor:Int->Void = JNI.createStaticMethod("org/haxe/extension/AndroidImmersive", "setStatusBarColor", "(I)V");
		public static var setLowProfile:Void->Void = JNI.createStaticMethod("org/haxe/extension/AndroidImmersive", "setLowProfile", "()V");
		public static var setImmersive:Void->Void = JNI.createStaticMethod("org/haxe/extension/AndroidImmersive", "setImmersive", "()V");
	#else
		public static var setStatusBarColor:Int->Void = function(i:Int){};
		public static var setLowProfile:Void->Void = function(){};
		public static var setImmersive:Void->Void = function(){};
	#end 

}
